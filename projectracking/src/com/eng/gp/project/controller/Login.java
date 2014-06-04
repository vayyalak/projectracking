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

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import com.eng.gp.project.domain.ProjectType;
import com.eng.gp.project.domain.UserDetails;
import com.eng.gp.project.services.ProjectTrackingService;
import com.eng.gp.project.services.ProjectTrackingServiceBean;
import com.eng.gp.project.util.DateFormats;
import com.eng.gp.project.util.JsonToObject;
import com.gridpoint.energy.domainmodel.Channel;
import com.gridpoint.energy.domainmodel.Premises;
import com.gridpoint.energy.domainmodel.Tenant;
import com.jayway.restassured.response.Response;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session = null;
	
	String userName =null;
	String password = null;
	
	String loginPath = "http://localhost:8080/publicApi/services/auth/login";
	String getChannel = "http://localhost:8080/publicApi/services/data/getChannelsByEndpointId";
	String getTenants = "http://localhost:8080/publicApi/services/projectTracking/getTenants";
	String getPremises = "http://localhost:8080/publicApi/services/projectTracking/getPremises";
	String getChannelsByPremisesId = "http://localhost:8080/publicApi/services/projectTracking/getChannelsByPremisesId";
	
	private JsonToObject jsonToObject = new JsonToObject();
	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	ObjectMapper objectMapper = new ObjectMapper();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		session = request.getSession(true);
		
		 userName = request.getParameter("j_username");
		 password = request.getParameter("j_password");
		
		ProjectTrackingService  service = new ProjectTrackingServiceBean();
		
 UserDetails userDetails =  userLogin(userName,password);
 	if(userDetails.getUsername()!=null){
		
		List<Channel> channelList  = getChannelsByEndPoint(Long.parseLong("12349"));
		
		Tenant tenant = getTenant();
		List<Premises>PremisesList = null;
		if(tenant!=null && tenant.getTenantId()!=null){
			PremisesList =getPremises(tenant);
		}
		if(channelList!=null && !channelList.isEmpty()){
		 request.setAttribute("allChannels", channelList);
		}
		if(tenant!=null){
			request.setAttribute("tenant", tenant);
		}
		
		if(PremisesList!=null && !PremisesList.isEmpty()){
			request.setAttribute("PremisesList", PremisesList);
		}
		List<ProjectType> projectslist;
		projectslist = service.getAllProjectTypes();
		request.setAttribute("allProjectstypes", projectslist);
		if(channelList!=null && !channelList.isEmpty()){
		 request.setAttribute("allChannels", channelList);
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/project22.jsp");
		requestDispatcher.forward(request, response);

		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		}
		}
	
	@SuppressWarnings("static-access")
	private UserDetails userLogin(String userName, String password){
		
		Response restResponse = given().queryParam("username", userName).queryParam("password", password).post(loginPath);
		Map<String, String> cookieMap = restResponse.getCookies();			
		session.setAttribute("loginCookies", cookieMap);
		String responseJson = restResponse.asString();
		System.out.println(responseJson);
		UserDetails userDetails = (UserDetails) jsonToObject.getStringToObject(responseJson, "userDetails", UserDetails.class);
		return userDetails;
	}
	
	@SuppressWarnings("unchecked")
	private List<Channel> getChannelsByEndPoint(Long premisesId){
		
		List<Channel> channelList =null;
		
		Map<String, String> loginCookie = (Map<String, String>) session.getAttribute("loginCookies");
		Response restChannelResponse = given().cookies(loginCookie).queryParam("username", userName).queryParam("password", password).queryParam("premisesId",premisesId).get(getChannelsByPremisesId);
		String channelResponse = restChannelResponse.asString();
		
		System.out.println(channelResponse);
		
		//Channel channel = (Channel) jsonToObject.getStringToObject(channelResponse, "result", Channel.class);
		//System.out.println(channel.toString());
		
		try {
			JSONObject jsonObject = new JSONObject(channelResponse);
			JSONArray jsonArray = (JSONArray) jsonObject.get("result");
			if (jsonArray.length() > 0) 
			{
				objectMapper.registerSubtypes(Map.class);
				objectMapper.configure(Feature.READ_ENUMS_USING_TO_STRING,false);
				objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				objectMapper.getDeserializationConfig().setDateFormat(new SimpleDateFormat(DateFormats.DATE_FORMAT_LOCALDATETIME));
				
				channelList = new ArrayList<Channel>();
				for (int iCount = 0; iCount < jsonArray.length(); iCount++) 
				{

					JSONObject channelObject = jsonArray.getJSONObject(iCount); 
					Channel channel =(Channel) objectMapper.readValue(channelObject.toString(), Channel.class);
					 channelList.add(channel);
					
				}

			}
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		return channelList;
		
		}
	
	
	@SuppressWarnings("unchecked")
	private Tenant getTenant(){
	
	Tenant  tenant =null;
	try{
		String usr = userName;
		Map<String, String> loginCookie2 = (Map<String, String>) session.getAttribute("loginCookies");
		Response restTenantResponse = given().cookies(loginCookie2).queryParam("username", userName).queryParam("password", password).queryParam("usr",usr).get(getTenants);
		String tenantlResponse = restTenantResponse.asString();
		
		JSONObject jsonObject = new JSONObject(tenantlResponse);
		JSONArray jsonArray = (JSONArray) jsonObject.get("result");
		JSONObject tenantObject = jsonArray.getJSONObject(0); 
		
		 tenant = (Tenant)  objectMapper.readValue(tenantObject.toString(), Tenant.class);
		
		System.out.println(tenant.toString());
		
	}catch(Exception e){
		e.printStackTrace();
	}
		return	tenant; 
}
	
	@SuppressWarnings("unchecked")
	private List<Premises> getPremises(Tenant tenant){
		
		Map<String, String> loginCookie3 = (Map<String, String>) session.getAttribute("loginCookies");
		Response restPremisesResponse = given().cookies(loginCookie3).queryParam("username", userName).queryParam("password", password).queryParam("tenantId",tenant.getTenantId()).get(getPremises);
		String premiseslResponse = restPremisesResponse.asString();
		
		List<Premises> PremisesList =null;
		
		try{
				JSONObject jsonObject = new JSONObject(premiseslResponse);
				JSONArray jsonArray = (JSONArray) jsonObject.get("result");
				if (jsonArray.length() > 0) 
				{
					PremisesList = new ArrayList<Premises>();
					for (int iCount = 0; iCount < jsonArray.length(); iCount++) 
					{
						JSONObject premisesObject = jsonArray.getJSONObject(iCount); 
						PremisesList.add((Premises) objectMapper.readValue(premisesObject.toString(), Premises.class));
					}

				}
			
			}catch(Exception ex){
				ex.printStackTrace();
			}
		return PremisesList;
	}
	
	}
