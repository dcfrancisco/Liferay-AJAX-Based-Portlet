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
package jp.aegif.liferay.experiment.mryoshio.rr.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;

import jp.aegif.liferay.experiment.mryoshio.rr.model.Room;
import jp.aegif.liferay.experiment.mryoshio.rr.model.RoomModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the Room service. Represents a row in the
 * &quot;rr_Room&quot; database table, with each column mapped to a property of
 * this class.
 * 
 * <p>
 * This implementation and its corresponding interface
 * {@link jp.aegif.liferay.experiment.mryoshio.rr.model.RoomModel} exist only as
 * a container for the default property accessors generated by ServiceBuilder.
 * Helper methods and all application logic should be put in {@link RoomImpl}.
 * </p>
 * 
 * <p>
 * Never modify or reference this class directly. All methods that expect a room
 * model instance should use the
 * {@link jp.aegif.liferay.experiment.mryoshio.rr.model.Room} interface instead.
 * </p>
 * 
 * @author ashitaba.yoshioka@aegif.jp
 * @see RoomImpl
 * @see jp.aegif.liferay.experiment.mryoshio.rr.model.Room
 * @see jp.aegif.liferay.experiment.mryoshio.rr.model.RoomModel
 * @generated
 */
public class RoomModelImpl extends BaseModelImpl<Room> implements RoomModel {
	public static final String TABLE_NAME = "rr_Room";
	public static final Object[][] TABLE_COLUMNS = {
			{ "roomId", new Integer(Types.INTEGER) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "ownerId", new Integer(Types.BIGINT) },
			{ "name", new Integer(Types.VARCHAR) },
			{ "capacity", new Integer(Types.INTEGER) },
			{ "available", new Integer(Types.BOOLEAN) } };
	public static final String TABLE_SQL_CREATE = "create table rr_Room (roomId INTEGER not null primary key,companyId LONG,groupId LONG,ownerId LONG,name VARCHAR(75) null,capacity INTEGER,available BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table rr_Room";
	public static final String ORDER_BY_JPQL = " ORDER BY room.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rr_Room.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil
			.getBoolean(
					com.liferay.util.service.ServiceProps
							.get("value.object.entity.cache.enabled.jp.aegif.liferay.experiment.mryoshio.rr.model.Room"),
					true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil
			.getBoolean(
					com.liferay.util.service.ServiceProps
							.get("value.object.finder.cache.enabled.jp.aegif.liferay.experiment.mryoshio.rr.model.Room"),
					true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil
			.getLong(com.liferay.util.service.ServiceProps
					.get("lock.expiration.time.jp.aegif.liferay.experiment.mryoshio.rr.model.Room"));

	public RoomModelImpl() {
	}

	public int getPrimaryKey() {
		return _roomId;
	}

	public void setPrimaryKey(int pk) {
		setRoomId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_roomId);
	}

	public int getRoomId() {
		return _roomId;
	}

	public void setRoomId(int roomId) {
		_roomId = roomId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		} else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public int getCapacity() {
		return _capacity;
	}

	public void setCapacity(int capacity) {
		_capacity = capacity;
	}

	public boolean getAvailable() {
		return _available;
	}

	public boolean isAvailable() {
		return _available;
	}

	public void setAvailable(boolean available) {
		_available = available;
	}

	public Room toEscapedModel() {
		if (isEscapedModel()) {
			return (Room) this;
		} else {
			return (Room) Proxy
					.newProxyInstance(Room.class.getClassLoader(),
							new Class[] { Room.class },
							new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		RoomImpl clone = new RoomImpl();

		clone.setRoomId(getRoomId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setOwnerId(getOwnerId());
		clone.setName(getName());
		clone.setCapacity(getCapacity());
		clone.setAvailable(getAvailable());

		return clone;
	}

	public int compareTo(Room room) {
		int value = 0;

		value = getName().compareTo(room.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Room room = null;

		try {
			room = (Room) obj;
		} catch (ClassCastException cce) {
			return false;
		}

		int pk = room.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{roomId=");
		sb.append(getRoomId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", capacity=");
		sb.append(getCapacity());
		sb.append(", available=");
		sb.append(getAvailable());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("jp.aegif.liferay.experiment.mryoshio.rr.model.Room");
		sb.append("</model-name>");

		sb.append("<column><column-name>roomId</column-name><column-value><![CDATA[");
		sb.append(getRoomId());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>capacity</column-name><column-value><![CDATA[");
		sb.append(getCapacity());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>available</column-name><column-value><![CDATA[");
		sb.append(getAvailable());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _roomId;
	private long _companyId;
	private long _groupId;
	private long _ownerId;
	private String _name;
	private int _capacity;
	private boolean _available;
}