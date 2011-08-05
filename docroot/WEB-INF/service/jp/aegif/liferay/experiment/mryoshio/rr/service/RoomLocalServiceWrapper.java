/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package jp.aegif.liferay.experiment.mryoshio.rr.service;

/**
 * <p>
 * This class is a wrapper for {@link RoomLocalService}.
 * </p>
 *
 * @author    ashitaba.yoshioka@aegif.jp
 * @see       RoomLocalService
 * @generated
 */
public class RoomLocalServiceWrapper implements RoomLocalService {
	public RoomLocalServiceWrapper(RoomLocalService roomLocalService) {
		_roomLocalService = roomLocalService;
	}

	/**
	* Adds the room to the database. Also notifies the appropriate model listeners.
	*
	* @param room the room to add
	* @return the room that was added
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room addRoom(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomLocalService.addRoom(room);
	}

	/**
	* Creates a new room with the primary key. Does not add the room to the database.
	*
	* @param roomId the primary key for the new room
	* @return the new room
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room createRoom(
		int roomId) {
		return _roomLocalService.createRoom(roomId);
	}

	/**
	* Deletes the room with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roomId the primary key of the room to delete
	* @throws PortalException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRoom(int roomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_roomLocalService.deleteRoom(roomId);
	}

	/**
	* Deletes the room from the database. Also notifies the appropriate model listeners.
	*
	* @param room the room to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRoom(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_roomLocalService.deleteRoom(room);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _roomLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the room with the primary key.
	*
	* @param roomId the primary key of the room to get
	* @return the room
	* @throws PortalException if a room with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room getRoom(
		int roomId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _roomLocalService.getRoom(roomId);
	}

	/**
	* Gets a range of all the rooms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of rooms to return
	* @param end the upper bound of the range of rooms to return (not inclusive)
	* @return the range of rooms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<jp.aegif.liferay.experiment.mryoshio.rr.model.Room> getRooms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomLocalService.getRooms(start, end);
	}

	/**
	* Gets the number of rooms.
	*
	* @return the number of rooms
	* @throws SystemException if a system exception occurred
	*/
	public int getRoomsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomLocalService.getRoomsCount();
	}

	/**
	* Updates the room in the database. Also notifies the appropriate model listeners.
	*
	* @param room the room to update
	* @return the room that was updated
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room updateRoom(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomLocalService.updateRoom(room);
	}

	/**
	* Updates the room in the database. Also notifies the appropriate model listeners.
	*
	* @param room the room to update
	* @param merge whether to merge the room with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the room that was updated
	* @throws SystemException if a system exception occurred
	*/
	public jp.aegif.liferay.experiment.mryoshio.rr.model.Room updateRoom(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _roomLocalService.updateRoom(room, merge);
	}

	public void addRoom(
		jp.aegif.liferay.experiment.mryoshio.rr.model.Room room, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_roomLocalService.addRoom(room, userId);
	}

	public RoomLocalService getWrappedRoomLocalService() {
		return _roomLocalService;
	}

	private RoomLocalService _roomLocalService;
}