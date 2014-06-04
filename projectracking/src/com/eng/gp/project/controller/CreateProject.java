package com.eng.gp.project.controller;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.eng.gp.project.util.DateFormats;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.gridpoint.energy.domainmodel.ProjectTrackingItem;
import com.gridpoint.energy.domainmodel.ProjectTrackingItemForCreate;
import com.jayway.restassured.response.Response;

/**
 * Servlet implementation class CreateProject
 */
@WebServlet("/createProject")
public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static final String createProject = "http://localhost:8080/publicApi/services/projectTracking/createProject";
	private static final String getProjectsByPremises = "http://localhost:8080/publicApi/services/projectTracking/getProjectsByPremisesId";
	
	HttpSession session = null;
	ObjectMapper objectMapper = new ObjectMapper();
	
	String projectName;
	String projectTypeid;
	String[] channels;
	String premisesId;
	String sDate;
	String eDate;
	String description;
	
	StringBuffer sb;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			 projectName = request.getParameter("projectname");
			 projectTypeid = request.getParameter("projecttype");
			// channelDisplayName = request.getParameter("channelDisplayNames").split(",");
			 premisesId = request.getParameter("premisesid");
			 sDate = request.getParameter("start");
			 eDate = request.getParameter("end");
			 channels= request.getParameterValues("selectedAttributes");
			//String sdate = request.getParameter("start").replace("/", "-");
			//sdate = sdate.replace("/", "-");
			  // String edate = request.getParameter("end").replace("/", "-");;
			//edate = edate.replace("/", "-");
			 description = request.getParameter("description");
			
			String str_date_time = null;
			String end_date_time = null;
			if(!StringUtils.isBlank(sDate)){
			sb = new StringBuffer();
			long mill = System.currentTimeMillis();
			Date tempDate = new Date(mill);
			int hours = tempDate.getHours();
			int min = tempDate.getMinutes();
			int sec = tempDate.getSeconds();
			sb.append(sDate + " ");
			sb.append(hours);
			sb.append(":");
			sb.append(min);
			sb.append(":");
			sb.append(sec);
			str_date_time = sb.toString();
			}
			
			if(!StringUtils.isBlank(eDate)){
			
			sb = new StringBuffer();
			sb.append(eDate + " ");
			sb.append(23);
			sb.append(":");
			sb.append(59);
			sb.append(":");
			sb.append(59);
			end_date_time = sb.toString();
			}
			
			Set<String>channelDisplayName =new HashSet<String>();
			if(channels!=null){
			for(String chString :channels){
				channelDisplayName.add(chString);
			 }
			}
			
			/* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date s = sdf.parse(str_date_time);
			Date e = sdf.parse(end_date_time);
			Long st = s.getTime();
			Long et = e.getTime();
			String sl =String.valueOf(st);
			String el = String.valueOf(et);*/
			
			ProjectTrackingItemForCreate project = new ProjectTrackingItemForCreate();
			project.setProjectName(projectName);
			project.setProjectTypeId(Long.parseLong(projectTypeid));
			project.setPremisesId(Long.parseLong(premisesId));
			project.setStartDate(str_date_time);
			project.setEndDate(end_date_time);
			project.setChannelDisplayNames(channelDisplayName);
			project.setDescription(description);
			
			Gson gson = new Gson();
			String json = gson.toJson(project);
			session = request.getSession(true);
			ProjectTrackingItem createdprojectTracking = createProject(json);
			List<ProjectTrackingItem> allProjects = null;
			
			if(createdprojectTracking!=null && createdprojectTracking.getProjectId()!=null){
				allProjects = getProjectsByPremisesId(createdprojectTracking.getPremisesId());
			}
			
			if(allProjects!=null){
				request.setAttribute("allProjects", allProjects);
			}
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/projectslist.jsp");
			requestDispatcher.forward(request, response);
			
			}catch(Exception e){
				e.printStackTrace();
			}

	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	private ProjectTrackingItem createProject(String jsonProjectString) throws JsonMappingException, JsonParseException, JSONException, IOException{
		 
		Map<String, String> loginCookie = (Map<String, String>) session.getAttribute("loginCookies");
		Response restCreateProject = given().cookies(loginCookie).queryParam("username", "cianalyst").queryParam("password", "password").request().body(jsonProjectString).post(createProject);
		String projectResponse = restCreateProject.asString();
		System.out.println(projectResponse);
		
		objectMapper.registerSubtypes(Map.class);
		objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.getDeserializationConfig().setDateFormat(new SimpleDateFormat(DateFormats.DATE_FORMAT_LOCALDATETIME));
		objectMapper.configure(Feature.READ_ENUMS_USING_TO_STRING, false);
		
		ProjectTrackingItem createdProject = getProjectFromJSon(projectResponse);
		
		return createdProject;
	}
	
	@SuppressWarnings("deprecation")
	private ProjectTrackingItem getProjectFromJSon(String jsonResponse) throws JSONException, JsonParseException, 
	JsonMappingException, IOException{
		ProjectTrackingItem project = null;
		if (jsonResponse != null
				&& !jsonResponse.equals("{\"result\":\"\"}")
				&& !jsonResponse.equals("{\"result\":{}}")
				&& !jsonResponse.contains("\"fault\":")) {
			JSONObject jsonObject = new JSONObject(jsonResponse);
			JSONObject jsonObject1 = (JSONObject) jsonObject.get("result");

			objectMapper.getDeserializationConfig().setDateFormat(new SimpleDateFormat(DateFormats.DATE_FORMAT_PROJECT_TRACKING));
			project = objectMapper.readValue(jsonObject1.toString(),ProjectTrackingItem.class);
		}
		return project;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	private List<ProjectTrackingItem> getProjectsByPremisesId(Long premisesId){
		
		Map<String, String> loginCookie = (Map<String, String>) session.getAttribute("loginCookies");
		Response restProjectResponse = given().cookies(loginCookie).queryParam("username", "cianalyst").queryParam("password", "password").queryParam("premisesId",premisesId).get(getProjectsByPremises);
		String projectResponse = restProjectResponse.asString();
		
		System.out.println(projectResponse);
		
		List<ProjectTrackingItem> projectsList =null;
		
		try {
			JSONObject jsonObject = new JSONObject(projectResponse);
			JSONArray jsonArray = (JSONArray) jsonObject.get("result");
			if (jsonArray.length() > 0) 
			{
				objectMapper.registerSubtypes(Map.class);
				objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				objectMapper.getDeserializationConfig().setDateFormat(new SimpleDateFormat(DateFormats.DATE_FORMAT_LOCALDATETIME));
		    
				
				projectsList = new ArrayList<ProjectTrackingItem>();
				for (int iCount = 0; iCount < jsonArray.length(); iCount++) 
				{
					JSONObject projectObject = jsonArray.getJSONObject(iCount); 
					ProjectTrackingItem project =(ProjectTrackingItem) objectMapper.readValue(projectObject.toString(), ProjectTrackingItem.class);
					projectsList.add(project);
				}

			}
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		
		return projectsList;
		
	}

}
