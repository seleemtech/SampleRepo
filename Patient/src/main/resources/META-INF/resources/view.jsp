<%@ include file="/init.jsp" %>

<portlet:renderURL var="renderURL">
<portlet:param name="mvcPath" value="/add.jsp" />
</portlet:renderURL>

<aui:button type="submit" onClick="${renderURL}" value="add" ></aui:button>

<table class="table table-striped">
<tr>
<th>Patient Name</th>
<th>Phone No</th>
<th>Patient Add</th>
<!-- <th>Edit</th> -->
<th>Delete</th>
</tr>

<c:forEach items="${patientList }" var="pnt">
<%-- <portlet:renderURL var="updateRenderURL">
<portlet:param name="mvcPath" value="/update.jsp" />
<portlet:param name="patientId" value="${pnt.patientId}" />
</portlet:renderURL> --%>

<portlet:actionURL name="delete" var="deletepatientURL">
<portlet:param name="patientId" value="${pnt.patientId}"/>
</portlet:actionURL>

<tr>
<td>${pnt.patientName}</td>
<td>${pnt.phoneNo}</td>
<td>${pnt.patientAdd}</td>

<%-- <td> <a class="text-center" style="width:50px">
<a href="${updateRenderURL}" class="btn btn-info btn-lg"><i class="glyphicon glyphicon-cog"></i>
</a>
</td> --%>

<td> <a class="text-center" style="width:50px">
<a href="${deletepatientURL}" class="btn btn-info btn-lg">
<i onclick="return confirm('Are sure want you delete this item ?');" class="glyphicon glyphicon-remove-circle"></i>
</a>
</td>

</tr>
</c:forEach>
</table>
