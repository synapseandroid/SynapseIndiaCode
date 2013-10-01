package com.mobile.shnarped.jsonparser;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * This Class parse the json response. 
 * @author Amit Kumar
 *
 */
public class EventParser 
{
	public EventParser()
	{

	}

	public ArrayList<Event> parse(String json)
	{
		ArrayList<Event> eventData = null;
		try {
			JSONArray jsonArray = new JSONArray(json);
			int x = jsonArray.length();
			ObjectMapper mapper = new ObjectMapper();
			eventData = new ArrayList<Event>(10);
			for(int i = 0; i < x; i++)
			{
				JSONObject object = jsonArray.getJSONObject(i);
				if(object != null)
				{
					if(object.getString("type").equals("news"))
					{
						String str = object.toString();

						NewsEvent newsEvent = null;
						try {
							newsEvent = mapper.readValue(str, NewsEvent.class);
							eventData.add(newsEvent);
						} catch (JsonParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JsonMappingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					else if(object.getString("type").equals("pound"))
					{
						String str = object.toString();
						PoundEvent poundEvent = null;
						try {
							poundEvent = mapper.readValue(str, PoundEvent.class);
							eventData.add(poundEvent);
						} catch (JsonParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JsonMappingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					else if(object.getString("type").equals("game"))
					{
						String str = object.toString();
						GameEvent gameEvent = null;
						try {
							gameEvent = mapper.readValue(str, GameEvent.class);
							eventData.add(gameEvent);
						} catch (JsonParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JsonMappingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventData;
	}
}
