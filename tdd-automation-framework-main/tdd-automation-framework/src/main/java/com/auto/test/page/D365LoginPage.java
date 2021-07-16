package com.auto.test.page;

import com.framework.core.components.WebComponents;

public class D365LoginPage extends WebComponents {

	static String PageName = D365LoginPage.class.getSimpleName(); // HomePage

	public D365LoginPage() {
		super(PageName);
	}

	public void enterUsername(String username) throws Exception {
		
		typeInto("tbx_Username", username);
		clickElement("btn_Submit");
		Thread.sleep(5000);
	}
	
	public void enterPassword(String password) throws Exception {
		
		typeInto("tbx_Password", password);
		clickElement("btn_Submit");
		wait(3000);
	}
	
	public void staySignedInPage() throws Exception {
		clickElement("btn_staySigninIn");
		Thread.sleep(5000);
	}
	
	public void switchtoIframe() throws Exception {
		switchToIframe("AppTileContainerSec_1_LI_15");
		clickElement("lnk_Sasleshub");
		Thread.sleep(5000);
	}
	
}
