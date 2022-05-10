<%@ include file="/init.jsp" %>
<portlet:actionURL name="patientupdate" var="patientupURL" />
<h4>Update Here</h4>

<aui:form action="${patientupURL}" name="fm" >
<aui:input name="patientId" type="hidden" value="${pnt.patientId}" />
<aui:input name="patientName" value="${pnt.patientName}" />
<aui:input name="phoneNo" value="${pnt.phoneNo}" />
<aui:input name="patientAdd" value="${pnt.patientAdd}" />
<aui:button type="submit" value="Save" ></aui:button>
</aui:form>

