package org.home.app;

import org.home.services.DataLayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
	
	final static private String URL = "http://localhost:8080/app/";
	static public String LIST = "list";
	static public String LISTTEXTTYPE = "listTextType";
	static public String LISTCOMMONSUBJECT = "listCommonSubject";	
	static public String LISTCOMMONSUBJECTESSENCE = "listCommonSubjectEssence";	
	static public String LISTTRANSLATEESSENCE = "listTranslateEssence";	
	
	@Autowired
	DataLayerServiceImpl dataLayerService;

	public BaseController() {
		
	}
	
	//TODO asdfasdfasdf
	public static String getListUrl(String list) {
		return BaseController.URL+list; 
	}
	
	
	public DataLayerServiceImpl getDataLayerService() {
		return dataLayerService;
	}

}
