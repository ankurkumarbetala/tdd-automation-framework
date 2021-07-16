package com.auto.core.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class PropertyTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args)
			throws JsonParseException, JsonSyntaxException, FileNotFoundException {
		JsonParser parser = new JsonParser();
		Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + File.separator
				+ "src//test//resources//configs//properties.json"));
		String res = obj.toString();
		Gson gson = new Gson();
		Container propObj = new Container();
		propObj = gson.fromJson(res, Container.class);
		System.out.println(propObj.getUat().getUrl());
		System.out.println(propObj.getUat().getTakeScreenshot());
		
		propObj.getSit().getLongWaitTime();
	}
}
