package com.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;
import com.interfaceElements.LoginSwagLabsElement;
import com.utility.FileReaderManager;

public class SwagLabsLoginPageObjectModel extends BaseClass implements LoginSwagLabsElement{
	static FileReaderManager reader;
	@FindBy(id = email_id)
	private WebElement email;
	
	@FindBy(id = password_id)
	private WebElement password;
	
	@FindBy(name = loginBtn_name)
	private WebElement loginButton;
	public SwagLabsLoginPageObjectModel () {
		PageFactory.initElements(driver, this);
		//action methods
		FileReaderManager reader = new FileReaderManager();
	}
	public void loginPage() {
		
		valuePassing(email, reader.getDataProperty("email") );
		valuePassing(password,reader.getDataProperty("password"));
		elementClick(loginButton);
	

}}
