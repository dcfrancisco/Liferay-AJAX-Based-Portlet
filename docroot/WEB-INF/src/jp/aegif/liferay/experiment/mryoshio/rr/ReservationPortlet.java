/**
 * Copyright (c) 2011 Aegif Corporation. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package jp.aegif.liferay.experiment.mryoshio.rr;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletException;

import jp.aegif.liferay.experiment.mryoshio.rr.model.Reservation;
import jp.aegif.liferay.experiment.mryoshio.rr.model.impl.ReservationImpl;
import jp.aegif.liferay.experiment.mryoshio.rr.service.ReservationLocalServiceUtil;
import jp.aegif.liferay.experiment.mryoshio.rr.service.RoomLocalServiceUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletBag;
import com.liferay.portal.kernel.portlet.PortletBagPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class ReservationPortlet
 */
public class ReservationPortlet extends TemplatePortlet {

	public void init() throws PortletException {
		logger = LogFactoryUtil.getLog(ReservationPortlet.class);
		super.init();
	}

	@Override
	public void serveResource(ResourceRequest req, ResourceResponse res)
			throws IOException, PortletException {

		if (logger.isDebugEnabled())
			debug(req);

		try {
			String rid = req.getResourceID();
			PortletBag pbag = PortletBagPool.get(PortalUtil.getPortletId(req));
			String ajaxResponse = null;
			if ("add-view".equals(rid) || "update-view".equals(rid)) {
				ajaxResponse = PortalUtil.renderPage(pbag.getServletContext(),
						PortalUtil.getHttpServletRequest(req),
						PortalUtil.getHttpServletResponse(res), editJSP, false);
			} else if ("list-view".equals(rid)) {
				ajaxResponse = getListDataAsJson(
						Integer.parseInt(req.getParameter("itemPerPage")),
						Integer.parseInt(req.getParameter("targetPage")));
			} else if ("update-reservation".equals(rid)) {
				updateReservation(req);
			} else if ("delete-reservation".equals(rid)) {
				deleteReservation(req);
			} else {
				ajaxResponse = ERR_NO_TYPE_SPECIFIED;
			}
			PrintWriter writer = res.getWriter();
			writer.write(ajaxResponse);
			writer.flush();
			writer.close();
		} catch (ServletException e) {
			throw new PortletException(e);
		}
	}

	private String getListDataAsJson(int parseInt, int parseInt2)
			throws PortletException {
		JSONObject ret = new JSONObject();
		try {
			/*
			 * TODO imporove to use itemPerPage, targetPage parameters.
			 */
			// int start = itemPerPage * (targetPage - 1); List<Reservation>
			// reservations =
			// ReservationLocalServiceUtil.getReservations(start, start +
			// itemPerPage);
			//
			List<Reservation> reservations = ReservationLocalServiceUtil
					.getReservations(0,
							ReservationLocalServiceUtil.getReservationsCount());
			JSONArray jr = new JSONArray();
			for (Iterator<Reservation> i = reservations.iterator(); i.hasNext();) {
				JSONObject j = new JSONObject();
				Reservation r = i.next();
				j.put("id", r.getReservationId());
				j.put("roomName", RoomLocalServiceUtil.getRoom(r.getRoomId())
						.getName());
				j.put("beginTime", formatter.format(r.getBeginTime()));
				j.put("endTime", formatter.format(r.getEndTime()));
				j.put("userName", UserLocalServiceUtil.getUser(r.getUserId())
						.getScreenName());
				jr.put(j);
			}
			ret.put("data", jr);
		} catch (Exception e) {
			throw new PortletException(ERR_SEARCH_RESERVATION + ": " + e);
		}
		logger.debug("return json: " + ret);
		return ret.toString();
	}

	private void deleteReservation(ResourceRequest req) throws PortletException {
		try {
			ReservationLocalServiceUtil.deleteReservation(Integer.valueOf(req
					.getParameter("reservationId")));
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	private void updateReservation(ResourceRequest req) throws PortletException {
		Reservation reservation = reservationFromRequest(req);
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			if (reservation.getReservationId() > 0) {
				logger.debug("Update reservation: " + reservation);
				ReservationLocalServiceUtil.updateReservation(reservation);
			} else if (reservation.getReservationId() == 0) {
				logger.debug("Create reservation: " + reservation);
				ReservationLocalServiceUtil.addReservation(reservation, userId);
			} else {
				throw new PortletException(ERR_ILLEGAL_RESERVATION_SPECIFIED);
			}
		} catch (SystemException e) {
			throw new PortletException(e);
		} catch (PortalException e) {
			throw new PortletException(e);
		}
	}

	private Reservation reservationFromRequest(ResourceRequest req) {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		ReservationImpl reservation = new ReservationImpl();
		reservation
				.setReservationId(ParamUtil.getInteger(req, "reservationId"));
		reservation.setCompanyId(PortalUtil.getCompanyId(req));
		reservation.setGroupId(themeDisplay.getScopeGroupId());
		reservation.setRoomId(ParamUtil.getInteger(req, "roomId"));

		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.set(ParamUtil.getInteger(req, "beginTimeYear"),
				ParamUtil.getInteger(req, "beginTimeMonth"),
				ParamUtil.getInteger(req, "beginTimeDay"),
				ParamUtil.getInteger(req, "beginTimeHour"),
				ParamUtil.getInteger(req, "beginTimeMinute"));
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.set(ParamUtil.getInteger(req, "endTimeYear"),
				ParamUtil.getInteger(req, "endTimeMonth"),
				ParamUtil.getInteger(req, "endTimeDay"),
				ParamUtil.getInteger(req, "endTimeHour"),
				ParamUtil.getInteger(req, "endTimeMinute"));

		reservation.setBeginTime(beginCalendar.getTime());
		reservation.setEndTime(endCalendar.getTime());
		reservation.setNote(ParamUtil.getString(req, "note"));
		reservation.setUserId(ParamUtil.getInteger(req, "userId"));
		reservation.setOwnerId(themeDisplay.getUserId());
		return reservation;
	}

	private static final String ERR_ILLEGAL_RESERVATION_SPECIFIED = "[ERROR] Reservation id is illegal.";
	private static final String ERR_SEARCH_RESERVATION = "[ERROR] Reservation couldn't be searched.";
	private static SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

}