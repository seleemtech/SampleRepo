<%@ include file="/init.jsp" %>

<portlet:actionURL name="patientadd" var="patientaddURL" />

<aui:form action="${patientaddURL}" method="post" name="fm" >
<aui:input name="patientId" type="hidden" />
<aui:input name="patientName" />
<aui:input name="phoneNo" />
<aui:input name="patientAdd" />
<aui:button type="submit" value="add"></aui:button>

</aui:form>
