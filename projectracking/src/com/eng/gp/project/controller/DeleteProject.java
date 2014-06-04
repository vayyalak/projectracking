package com.eng.gp.project.controller;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.json.JSONArray;
import org.json.JSONObject;

import com.eng.gp.project.services.ProjectTrackingService;
import com.eng.gp.project.services.ProjectTrackingServiceBean;
import com.eng.gp.project.util.DateFormats;
import com.eng.gp.project.util.JsonToObject;
import com.gridpoint.energy.domainmodel.ProjectTrackingItem;
import com.jayway.restassured.response.Response;

/**
 * Servlet implementation class DeleteProject
 */
@WebServlet("/deleteProjectByProjectId")
public class DeleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String deleteProjectByProjectId = "http://localhost:8080/publicApi/services/projectTracking/deleteProject";
	private static final String getProjectsByPremises = "http://localhost:8080/publicApi/services/projectTracking/getProjectsByPremisesId";
	
	HttpSession session = null;
	ObjectMapper objectMapper = new ObjectMapper();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		long projectId = Long.parseLong((request.getParameter("projectId")));
		//ProjectTrackingService  service = new ProjectTrackingServiceBean();
		//boolean result = service.deleteProject(projectId);
		session = request.getSession(true);
		Map<String, String> loginCookie = (Map<String, String>) session.getAttribute("loginCookies");
		Response restDeleteProject = given().cookies(loginCookie).queryParam("username", "cianalyst").queryParam("password", "password").queryParam("projectId",projectId).get(deleteProjectByProjectId);
		String deleteProjectResponse = restDeleteProject.asString();
		System.out.println(deleteProjectResponse);
		
		JSONObject jsonObject = new JSONObject(deleteProjectResponse);
		 boolean isDeleted = (Boolean) jsonObject.get("result");
		
		if(isDeleted){
			Long premisesId = Long.parseLong("12349");
			List<ProjectTrackingItem> allProjects = getProjectsByPremisesId(premisesId);
			
			if(allProjects!=null){
				request.setAttribute("allProjects", allProjects);
			}
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/projectslist.jsp");
			requestDispatcher.forward(request, response);
		}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		}
	}catch(Exception exception){
		exception.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@SuppressWarnings("unchecked")
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
