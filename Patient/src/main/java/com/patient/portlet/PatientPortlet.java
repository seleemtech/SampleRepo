package com.patient.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.patient.constants.PatientPortletKeys;
import com.patientservice.model.Patient;
import com.patientservice.service.PatientLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Patient",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PatientPortletKeys.PATIENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PatientPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
	{
	List<Patient> patientList=PatientLocalServiceUtil.getPatients(-1, -1);
	renderRequest.setAttribute("patientList", patientList);
	long patientId =ParamUtil.getLong(renderRequest, "patientId");
	renderRequest.setAttribute("patientId", patientId);
	super.render(renderRequest, renderResponse);
	

	}
	@ProcessAction(name="patientadd")
	public void patientadd(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		long patientId =ParamUtil.getLong(actionRequest, "patientId");
		String patientName =ParamUtil.getString(actionRequest, "patientName");
		long phoneNo =ParamUtil.getLong(actionRequest, "phoneNo");
		String patientAdd=ParamUtil.getString(actionRequest, "patientAdd");
		
		Patient pnt =PatientLocalServiceUtil.createPatient(patientId);
		pnt.setPatientName(patientName);
		pnt.setPhoneNo(phoneNo);
		pnt.setPatientAdd(patientAdd);
		PatientLocalServiceUtil.addPatient(pnt);
	}

	/*
	 * @ProcessAction(name="patientupdate") public void patientupdate(ActionRequest
	 * actionRequest, ActionResponse actionResponse) { long patientId
	 * =ParamUtil.getLong(actionRequest,"patientId"); String
	 * patientName=ParamUtil.getString(actionRequest, "patientName"); long phoneNo
	 * =ParamUtil.getLong(actionRequest, "phoneNo"); String
	 * patientAdd=ParamUtil.getString(actionRequest, "patientAdd");
	 * 
	 * Patient pnt=PatientLocalServiceUtil.fetchPatient(patientId);
	 * pnt.setPatientName(patientName); pnt.setPhoneNo(phoneNo);
	 * pnt.setPatientAdd(patientAdd); PatientLocalServiceUtil.updatePatient(pnt);
	 * 
	 * }
	 */
	@ProcessAction(name="delete")
	public void delete(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException
	{
		long patientId=ParamUtil.getLong(actionRequest, "patientId");
		PatientLocalServiceUtil.deletePatient(patientId);
	}
}