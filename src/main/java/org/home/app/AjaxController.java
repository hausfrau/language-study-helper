package org.home.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.home.models.LocaleTranslate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController extends BaseController {
	
	@RequestMapping(value = "/getListCommonSubjectsAjax/{id}", method = RequestMethod.GET)	
	public @ResponseBody Map<String, String> getListCommonSubjectsAjax(@PathVariable Integer id) {
		System.out.println("смена языка"+id);
		if(id == null) {
			return Collections.emptyMap();
		}	
		return dataLayerService.getMapCommonSubjects(id);
	}
	
	@RequestMapping(value = "/getListCommonSubjectsGroupAjax", method = RequestMethod.GET)	
	public @ResponseBody Map<String, String> getListCommonSubjectsGroupAjax() {
		return dataLayerService.getMapCommonSubjectsGroup();
	}

	@RequestMapping(value = "/getListTranslatesAjax/{id}", method = RequestMethod.GET)	
	public @ResponseBody Map<String, String> getListTranslatesAjax(@PathVariable Integer id) {
		System.out.println("смена языка"+id);
		if(id == null) {
			return Collections.emptyMap();
		}	
		return dataLayerService.getMapSubjectT(id);
	}
	/* @RequestMapping("/userGrid")
		public @ResponseBody GridModel getUsersForGrid(
		   @RequestParam("_search") String search,
		   @RequestParam String nd,
		   @RequestParam int rows,
		   @RequestParam int page,
		   @RequestParam String sidx) 
		   @RequestParam String sord) {
	  */
	
	
	@RequestMapping(value = "/getListChildsIdSubjectTByParentIDSubjectT/{id}", method = RequestMethod.GET)	
	public @ResponseBody List<Long> getListChildsIdSubjectTByParentIDSubjectT(@PathVariable long id) {
		return dataLayerService.getListChildsIdSubjectTByParentIDSubjectT(id);
	}
	
	//
	@RequestMapping(value = "/getRandomLocaleTranslateByIdSubjectT/{ids}", method = RequestMethod.GET)	
	public @ResponseBody LocaleTranslate getRandomLocaleTranslateByIdSubjectT(@PathVariable String ids) {
		//Arrays.asList(ids.split(","));
		return dataLayerService.getRandomLocaleTranslateByIdSubjectT(ids);
	}	
	
	@RequestMapping(value = "/getStringFromGetListChildsIdSubjectTByParentIDSubjectT/{id}", method = RequestMethod.GET)	
	public @ResponseBody String getStringFromGetListChildsIdSubjectTByParentIDSubjectT(@PathVariable long id) {
		return dataLayerService.getStringFromGetListChildsIdSubjectTByParentIDSubjectT(id);
	}
	
	@RequestMapping(value = "/getAnswerLocaleTranslateByIditemOfTranslatesT", method = RequestMethod.GET)	
	public @ResponseBody LocaleTranslate getAnswerLocaleTranslateByIditemOfTranslatesT( @RequestParam long iditem, 
																						@RequestParam long idlang) {
		return dataLayerService.getAnswerLocaleTranslateByIditemOfTranslatesT(iditem, idlang);
	}	

	@RequestMapping(value = "/getItemsTIdItemsTByLocaleTranslateIdTranslate/{id}", method = RequestMethod.GET)	
	public @ResponseBody Long getItemsTIdItemsTByLocaleTranslateIdTranslate(@PathVariable long id) {
		return dataLayerService.getItemsTIdItemsTByLocaleTranslateIdTranslate(id);
	}
	
	
	/*@RequestMapping(value = "/getTranslateessenceByText/{text}", method = RequestMethod.GET)	
	public @ResponseBody LocaleTranslate getTranslateessenceByText(@PathVariable String text) {
		return dataLayerService.getTranslateessenceByText(text);
	}*/
	
	
	@RequestMapping(value = "/getAjaxAllLang",  method = RequestMethod.GET)	
	public @ResponseBody Map<String, String> getAjaxAllLAng() {
		return dataLayerService.getAjaxAllLang();
	}
}
