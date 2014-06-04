package com.eng.gp.project.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gridpoint.energy.domainmodel.exception.ServiceException;

public class JsonToObject
{

	public static List<?> getStringToList(String responseJson, Class<?> clazz, Class<?> serviceClazz) throws ServiceException
	{
		List<Object> response = null;
		if (responseJson != null && !responseJson.equals("{\"result\":\"\"}") && !responseJson.equals("{\"result\":{}}")
				&& !responseJson.contains("\"fault\":"))
		{
			response = new ArrayList<Object>();
			Gson gson = new Gson();
			JSONObject jsonObject;
			try
			{
				jsonObject = new JSONObject(responseJson);
				JSONArray jsonArray = (JSONArray) jsonObject.get("result");
				for (int iCount = 0; iCount < jsonArray.length(); iCount++)
				{
					jsonObject = (JSONObject) jsonArray.get(iCount);
					Object object = gson.fromJson(jsonObject.toString(), clazz);
					response.add(object);
				}
			}
			catch (JSONException e)
			{
				e.printStackTrace();
				org.junit.Assert.assertFalse(true);
			}
		} else
			if (responseJson != null && responseJson.contains("\"fault\":"))
			{
				throw new ServiceException(serviceClazz + " : "  + responseJson);
			}
		if (response == null || response.size() == 0)
		{
			response = null;
			return response;
		}
		return response;
	}

	public static Object getStringToObject(String responseJson, String path, Class<?> clazz)
	{
		JSONObject jsonObject;
		Object object = null;
		if (responseJson != null && !responseJson.equals("{\"result\":\"\"}") && !responseJson.equals("{\"result\":{}}")
				&& !responseJson.contains("\"fault\":"))
		{
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:sss").create();
			try
			{
				jsonObject = new JSONObject(responseJson);
				jsonObject = (JSONObject) jsonObject.get("result");
				if (path != null && !path.equals(""))
				{
					object = gson.fromJson(jsonObject.get(path).toString(), clazz);
				} else
				{
					object = gson.fromJson(jsonObject.toString(), clazz);
				}
			}
			catch (JSONException e)
			{
				e.printStackTrace();
				org.junit.Assert.assertFalse(true);
			}
		}
		return object;
	}
}
