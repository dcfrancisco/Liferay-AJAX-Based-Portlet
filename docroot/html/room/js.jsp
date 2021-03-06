<%--
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
--%>
<script type="text/javascript">
	function <portlet:namespace/>_confirm(type, roomId, roomName) {
		var handleYes = function() {
			url = '<portlet:resourceURL id="delete-room"><portlet:param name="roomId" value="_ROOM_ID_" /></portlet:resourceURL>';
			url = url.replace("_ROOM_ID_", roomId);
			<portlet:namespace/>deleteRoom(url);
			this.close();
		};
		AUI()
				.use(
						'aui-dialog',
						'aui-overlay-manager',
						'dd-constrain',
						function(A) {
							var d = new A.Dialog(
									{
										bodyContent : "<liferay-ui:message key='room-confirm-body-delete' />"
												+ " " + roomName,
										centered : true,
										destroyOnClose : true,
										draggable : false,
										height : 200,
										width : 200,
										resizable : false,
										stack : true,
										title : "<liferay-ui:message key='room-confirm-delete' />",
										buttons : [
												{
													text : "<liferay-ui:message key='yes' />",
													handler : handleYes
												},
												{
													text : "<liferay-ui:message key='no' />",
													handler : function() {
														this.close();
													},
													isDefault : true
												} ]
									}).render();
						});
	}

	function <portlet:namespace/>_updateRoom() {
		var url;
		url = '<portlet:resourceURL id="update-room" />';
		<portlet:namespace/>updateRoom("<portlet:namespace/>", "updateForm",
				url);
	}

	function <portlet:namespace/>updateRoom(ns, formid, url) {
		var fqid = ns + formid;
		AUI()
				.use(
						'aui-node',
						'aui-io',
						'aui-form',
						'aui-dialog',
						function(A) {
							var form = A.one("#" + fqid);
							var config = {
								method : "POST",
								form : {
									id : fqid
								},
								on : {
									success : function(obj, txnId, res) {
										<portlet:namespace/>_showListView();
										var d = new A.Dialog(
												{
													title : "<liferay-ui:message key='room-process-result' />",
													bodyContent : "<liferay-ui:message key='room-update-success'/>",
													centered : true,
													destroyOnClose : true
												}).render();

									},
									failure : function(obj, txnId, res) {
										var d = new A.Dialog(
												{
													title : "<liferay-ui:message key='room-process-result' />",
													bodyContent : "<liferay-ui:message key='error' />"
															+ ": "
															+ res.responseText,
													destroyOnClose : true
												}).render();
									}
								}
							};
							A.io.request(url, config);
						});
	}

	function <portlet:namespace/>deleteRoom(url) {
		AUI()
				.use(
						'aui-io',
						'aui-dialog',
						function(A) {
							var config = {
								method : "POST",
								on : {
									success : function(obj, txnId, res) {
										<portlet:namespace/>_showListView();
										var d = new A.Dialog(
												{
													title : "<liferay-ui:message key='room-process-result' />",
													bodyContent : "<liferay-ui:message key='room-delete-success' />",
													centered : true,
													destroyOnClose : true
												}).render();
									},
									failure : function(obj, txnId, res) {
										var d = new A.Dialog(
												{
													title : "<liferay-ui:message key='room-process-result' />",
													bodyContent : "<liferay-ui:message key='error' />"
															+ ": "
															+ res.responseText,
													destroyOnClose : true
												}).render();
									}
								}
							};
							A.io.request(url, config);
						});
	}

	function <portlet:namespace/>_showListView() {
		var url;
		url = '<portlet:resourceURL id="_RESOURCE_ID_">';
		url += '<portlet:param name="itemPerPage" value="_ITEM_PER_PAGE_" />';
		url += '<portlet:param name="targetPage" value="_TARGET_PAGE_" />';
		url += '</portlet:resourceURL>';
		url = url.replace("_RESOURCE_ID_", "list-view");
		url = url.replace("_ITEM_PER_PAGE_", 5);
		url = url.replace("_TARGET_PAGE_", 1);
		<portlet:namespace/>showListView("<portlet:namespace/>", "mainPanel",
				url);
	}

	function <portlet:namespace/>showListView(ns, panelid, url) {
		var fqid = ns + panelid;
		AUI()
				.use(
						'yui2-connection',
						'yui2-datatable',
						'yui2-paginator',
						'yui2-button',
						function(A) {
							var myDataSource = new A.YUI2.util.DataSource(url);
							myDataSource.connXhrMode = "queueRequests";
							myDataSource.responseType = A.YUI2.util.DataSource.TYPE_JSON;
							myDataSource.responseSchema = {
								resultsList : "data",
								fields : [ "id", "name", "capacity",
										"available" ]
							};
							var formatButtons = function(elCell, oRecord,
									oColumn, id) {
								var updateId = "<portlet:namespace/>update"
										+ id;
								var buttons = "<button type='button' id='";
                                buttons += updateId;
                                buttons += "' name='";
                                buttons += updateId;
                                buttons += " value='update'><liferay-ui:message key='room-show-update'/></button>";
								var deleteId = "<portlet:namespace/>delete"
										+ id;
								buttons += "<button type='button' id='";
                                buttons += deleteId;
                                buttons += "' name='";
                                buttons += deleteId;
                                buttons += " value='delete'><liferay-ui:message key='room-show-delete'/></button>";

								var b1 = new A.YUI2.widget.Button(updateId);
								var b2 = new A.YUI2.widget.Button(deleteId);
								elCell.innerHTML = buttons;
							};
							var myColumnDefs = [
									{
										key : "id",
										label : "",
										formatter : formatButtons
									},
									{
										key : "name",
										label : "<liferay-ui:message key='reservation-room'/>",
										sortable : true
									},
									{
										key : "capacity",
										label : "<liferay-ui:message key='room-capacity'/>",
										sortable : true
									},
									{
										key : "available",
										label : "<liferay-ui:message key='room-available'/>",
									} ];
							var oConfigs = {
								renderLoopSize : 0,
								initialLoad : false,
								paginator : new A.YUI2.widget.Paginator({
									rowsPerPage : 5
								})
							};
							var myDataTable = new A.YUI2.widget.DataTable(fqid,
									myColumnDefs, myDataSource, oConfigs);
							myDataTable.subscribe("buttonClickEvent", function(
									oArgs) {
								if (oArgs.target) {
									var oRecord = this.getRecord(oArgs.target);
									var oData = oRecord.getData();
									if (oArgs.target.id.indexOf("update") > 0) {
										<portlet:namespace/>_showJspInPanel(
												"update-view", +oData.id);
									} else {
										<portlet:namespace/>_confirm(
												'delete-view', oData.id,
												oData.name);
									}
								}
							});

							var mySuccessHandler = function() {
								this.onDataReturnAppendRows.apply(this,
										arguments);
							};
							var myFailureHandler = function() {
								console.error("ERROR OCCURRED!");
							};
							var callbackObj = {
								success : mySuccessHandler,
								failure : myFailureHandler,
								scope : myDataTable
							};
							myDataSource.sendRequest("", callbackObj);
						});
	}
</script>
