
<%
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
%>


<%@include file="/html/init.jsp"%>
<%@ include file="/html/common.jsp" %>
<%@ include file="/html/room/js.jsp" %>


<script type="text/javascript">
	AUI().ready('aui-panel', function(A) {
		var panel = new A.Panel({
			visible : false
		}).render("#<portlet:namespace/>mainPanel");

		<portlet:namespace/>_showJspInPanel("list-view");
	});
</script>


<portlet:defineObjects />

<div id="<portlet:namespace/>mainPanel"></div>