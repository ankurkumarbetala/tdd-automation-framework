package com.framework.core.components;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class RepositoryLoader {

	public static String FetchElementValue(String type, String pageName, String env, String element)
			throws Exception {
		File xmlFile = new File(
				System.getProperty("user.dir") + "//src//main//resources//" + "OR.xml");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();// DocumentBuilderFactory
		DocumentBuilder docBuilder = dbFactory.newDocumentBuilder(); // DocBuilder
		Document document = docBuilder.parse(xmlFile);// Build the Document

		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression xExpression = null;
		if (type.equalsIgnoreCase("id")) {
			xExpression = xpath
					.compile("//" + env + "//" + pageName + "//" + element + "/id/text()"); //staging//LoginPage//tbx_username/id/text()
		} else if (type.equalsIgnoreCase("xpath")) {
			xExpression = xpath
					.compile("//" + env + "//" + pageName + "//" + element + "/xpath/text()");
		}
		return (String) xExpression.evaluate(document, XPathConstants.STRING);

	}

	public static void main(String[] args) throws Exception {
		RepositoryLoader rObj = new RepositoryLoader();
		System.out.println(rObj.FetchElementValue("xpath", "LoginPage", "sit", "tbx_password"));
	}
}
