package com.pageObjectmanager;

import com.pageObjectModel.SwagLabsLoginPageObjectModel;
import com.utility.FileReaderManager;

public class PageObjectManager {
	private static PageObjectManager manager;
	private SwagLabsLoginPageObjectModel loginPage ;
	private FileReaderManager fileReder;
	/*private SwagLabsSearchModel search;*/
	
	private PageObjectManager() {
	}
	
	public static PageObjectManager getpageObjectManger() {
		if (manager == null) {
			manager = new PageObjectManager();
		}
		return manager;	
	}
	public SwagLabsLoginPageObjectModel getLoginPage() {
		if (loginPage == null) {
			loginPage = new SwagLabsLoginPageObjectModel ();
		}
		return loginPage;
	}
	public FileReaderManager getFileReder() {
		if (fileReder == null) {
			fileReder = new FileReaderManager();
		}
		return fileReder;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}