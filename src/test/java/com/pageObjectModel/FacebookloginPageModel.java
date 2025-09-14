package com.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;
import com.interfaceElements.FacebookLoginPageElements;

public class FacebookloginPageModel extends BaseClass  implements FacebookLoginPageElements{
	
	@FindBy(id = email_id)
	private WebElement email;
	
	@FindBy(id = password_id)
	private WebElement password;
	
	@FindBy(name = loginBtn_name)
	private WebElement loginButton;
	
	@FindBy(linkText = forgetPass_linkText)
	private WebElement forgetBtn;
	
	@FindBy(xpath = createAcc_xpath)
	private WebElement createAcc;
	
	//constructor
	public FacebookloginPageModel () {
		PageFactory.initElements(driver, this);
	}
	public void loginPage() {
		valuePassing(email, "kiran@gmail.com");
		valuePassing(password, "kiran@123");
		elementClick(loginButton);
	}
	
	

}
