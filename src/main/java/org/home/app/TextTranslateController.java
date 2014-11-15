package org.home.app;

import java.util.Collections;
import java.util.Map;

import org.home.models.CommonSubjectEssence;
import org.home.models.CommonSubjects;
import org.home.models.Lang;
import org.home.models.Tests;
import org.home.models.TextType;
import org.home.models.TranslateEssence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TextTranslateController  extends BaseController{

	static public String LIST = "listLang";

	// private static final Logger logger =
	// LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/listLang")
	public String listLangs(ModelMap model) {
		model.addAttribute("langs", dataLayerService.getListAllLangs());
		return "langs";
	}

	@RequestMapping(value = "/createLang")
	public String createLang(ModelMap model) {
		model.addAttribute("lang", new Lang());
		return "editLang";
	}

	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	@RequestMapping(value = "/insertLang", method = RequestMethod.POST)
	public String insertLang(@ModelAttribute Lang lang, ModelMap model) {
		dataLayerService.insertLang(lang);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LIST);
	}*/

	@RequestMapping(value = "/editLang/{idLang}", method = RequestMethod.GET)
	public String editLang(@PathVariable int idLang, ModelMap model) {
		Lang l = dataLayerService.getLang((long) idLang);
		model.addAttribute("lang", l);
		return "editLang";
	}

	@RequestMapping(value = "/saveLang", method = RequestMethod.POST)
	public String saveLang(@ModelAttribute Lang lang, ModelMap model) {
		if (lang.getIdLang() != null) {
			lang.setNew(false);
		}
		dataLayerService.saveLang(lang);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LIST);
	}

	@RequestMapping(value = "/deleteLang/{idLang}", method = RequestMethod.GET)
	public String deleteLang(@PathVariable int idLang, ModelMap model)
			throws Exception {
		Lang lang = dataLayerService.getLang((long) idLang);
		dataLayerService.deleteLang(lang);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LIST);
	}	
	
	
	
	@RequestMapping(value = "/listTextType")
	public String listTextTypes(ModelMap model) {
		model.addAttribute("texttypes", dataLayerService.getListAllTextTypes());
		return "texttypes";
	}

	@RequestMapping(value = "/createTextType")
	public String createTextType(ModelMap model) {
		model.addAttribute("texttype", new TextType());
		return "editTextType";
	}

	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	@RequestMapping(value = "/insertTextType", method = RequestMethod.POST)
	public String insertTextType(@ModelAttribute TextType tt, ModelMap model) {
		dataLayerService.insertTextType(tt);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LISTTEXTTYPE);
	}*/

	@RequestMapping(value = "/editTextType/{idTextType}", method = RequestMethod.GET)
	public String editTextType(@PathVariable int idTextType, ModelMap model) {
		TextType tt = dataLayerService.getTextType((long) idTextType);
		model.addAttribute("texttype", tt);
		return "editTextType";
	}

	@RequestMapping(value = "/saveTextType", method = RequestMethod.POST)
	public String saveTextType(@ModelAttribute TextType tt, ModelMap model) {
		if (tt.getIdTextType() != null) {
			tt.setNew(false);
		} 
		dataLayerService.saveTextType(tt);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LISTTEXTTYPE);
	}

	@RequestMapping(value = "/deleteTextType/{idTextType}", method = RequestMethod.GET)
	public String deleteTextType(@PathVariable int idTextType, ModelMap model)
			throws Exception {
		TextType tt = dataLayerService.getTextType((long) idTextType);
		dataLayerService.deleteTextType(tt);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LISTTEXTTYPE);
	}	
	
	
	@RequestMapping(value = "/listCommonSubject")
	public String listCommonSubjects(ModelMap model) {
		
		model.addAttribute("commonsubjects", dataLayerService.getListAllCommonSubjects());
		return "commonsubjects";
	}

	@RequestMapping(value = "/createCommonSubject")
	public String createCommonSubjects(ModelMap model) {
		//model.addAttribute("langList", dataLayerService.getListAllLangs());
		model.addAttribute("langList", dataLayerService.getMapLangs());
		model.addAttribute("pidcommonsubjects", dataLayerService.getMapCommonSubjects(0));
		model.addAttribute("commonsubject", new CommonSubjects());
		return "editCommonSubject";
	}

	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	@RequestMapping(value = "/insertCommonSubject", method = RequestMethod.POST)
	public String insertCommonSubject(@ModelAttribute CommonSubjects cs, ModelMap model) {
		dataLayerService.insertCommonSubject(cs);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LISTCOMMONSUBJECT);
	}*/

	@RequestMapping(value = "/editCommonSubject/{idCommonSubject}", method = RequestMethod.GET)
	public String editCommonSubject(@PathVariable int idCommonSubject, ModelMap model) {
		CommonSubjects cs = dataLayerService.getCommonSubject((long) idCommonSubject);
		
		model.addAttribute("langList", dataLayerService.getMapLangs());
		model.addAttribute("pidcommonsubjects", dataLayerService.getMapCommonSubjects(cs.getLang()));
		model.addAttribute("commonsubject", cs);
		return "editCommonSubject";
	}

	@RequestMapping(value = "/saveCommonSubject", method = RequestMethod.POST)
	public String saveCommonSubject(@ModelAttribute CommonSubjects cs, ModelMap model) {
		if (cs.getIdCommonSubj() != null) {
			cs.setNew(false);
		}
		dataLayerService.saveCommonSubject(cs);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LISTCOMMONSUBJECT);
	}

	@RequestMapping(value = "/deleteCommonSubject/{idCommonSubject}", method = RequestMethod.GET)
	public String deleteCommonSubject(@PathVariable int idCommonSubject, ModelMap model)
			throws Exception {
		CommonSubjects cs = dataLayerService.getCommonSubject((long) idCommonSubject);
		dataLayerService.deleteCommonSubject(cs);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LISTCOMMONSUBJECT);
	}		
	

	@RequestMapping(value = "/listCommonSubjectEssence")
	public String listCommonSubjectEssences(ModelMap model) {
		model.addAttribute("commonsubjectsessences", dataLayerService.getListCommonSubjectEssences());
		return "commonsubjectessence";
	}
	
	@RequestMapping(value = "/saveCommonSubjectEssence", method = RequestMethod.POST)
	public String saveCommonSubjectEssence(@ModelAttribute CommonSubjectEssence cse, ModelMap model) {
		if (cse.getBcsId() != null) {
			cse.setNew(false);
		}
		dataLayerService.saveCommonSubjectEssence(cse);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LISTCOMMONSUBJECTESSENCE);
	}

	@RequestMapping(value = "/editCommonSubjectEssence/{bcsId}", method = RequestMethod.GET)
	public String editCommonSubjectEssence(@PathVariable int bcsId, ModelMap model) {
		CommonSubjectEssence cse = dataLayerService.getCommonSubjectEssenceByBindCommonSubjectId((long) bcsId);
		System.out.println("cse = "+cse.toString());
		model.addAttribute("langList", dataLayerService.getMapLangs());
		System.out.println("cse.getCsLang() = "+cse.getCsLang());
		model.addAttribute("pidcommonsubjects", dataLayerService.getMapCommonSubjects(cse.getCsLang()));
		model.addAttribute("commonsubjectessence", cse);
		model.addAttribute("commonsubjectitemsgroup", dataLayerService.getMapCommonSubjectsGroup());
		return "editCommonSubjectEssence";
	}	
	
	@RequestMapping(value = "/createCommonSubjectEssence")
	public String createCommonSubjectEssence(ModelMap model) {
		//model.addAttribute("langList", dataLayerService.getListAllLangs());
		model.addAttribute("langList", dataLayerService.getMapLangs());
		model.addAttribute("pidcommonsubjects", dataLayerService.getMapCommonSubjects(0));
		model.addAttribute("commonsubjectessence", new CommonSubjectEssence());
		model.addAttribute("commonsubjectitemsgroup", dataLayerService.getMapCommonSubjectsGroup());
		return "editCommonSubjectEssence";
	}	
	
	@RequestMapping(value = "/getListCommonSubjectsGroupAjax/{id}", method = RequestMethod.GET)	
	public @ResponseBody Map<String, String> getListCommonSubjectsGroupAjax(@PathVariable Integer id) {
		System.out.println("смена языка"+id);
		if(id == null) {
			return Collections.emptyMap();
		}	
		return dataLayerService.getMapCommonSubjectsGroup();
	}
	
	@RequestMapping(value = "/listTranslateEssence")
	public String listTranslateEssences(ModelMap model) {
		model.addAttribute("translateessences", dataLayerService.getListTranslateEssences());
		return "translateessence";
	}
	//deleteTranslateEssence/
	//editTranslateEssence/"
	//${translateessences}
	
	@RequestMapping(value = "/editTranslateEssence/{ttIdTranslatesT}", method = RequestMethod.GET)
	public String editTranslateEssence(@PathVariable int ttIdTranslatesT, ModelMap model) {
		TranslateEssence te = dataLayerService.getTranslateEssenceByTtIdTranslatesT((long) ttIdTranslatesT);
		System.out.println("te = "+te.toString());
		model.addAttribute("langList", dataLayerService.getMapLangs());
		System.out.println("te.getLtIdLang() = "+te.getLtIdLang());
		model.addAttribute("subjectst", dataLayerService.getMapSubjectT(te.getLtIdLang()));
		model.addAttribute("translateessence", te);
		model.addAttribute("translatesgroup", dataLayerService.getMapTranslatesGroup());
		model.addAttribute("texttypes", dataLayerService.getMapTextTypes());
		model.addAttribute("subjectsgroup", dataLayerService.getMapSubjectsGroup());
		return "editTranslateEssence";
	}	
	
	@RequestMapping(value = "/createTranslateEssence")
	public String createTranslateEssence(ModelMap model) {
		model.addAttribute("langList", dataLayerService.getMapLangs());
		model.addAttribute("subjectst", dataLayerService.getMapSubjectT(0));
		model.addAttribute("translateessence", new TranslateEssence());
		model.addAttribute("translatesgroup", dataLayerService.getMapTranslatesGroup());
		model.addAttribute("texttypes", dataLayerService.getMapTextTypes());
		model.addAttribute("subjectsgroup", dataLayerService.getMapSubjectsGroup());
		return "editTranslateEssence";
	}
	
	@RequestMapping(value = "/saveTranslateEssence", method = RequestMethod.POST)
	public String saveTranslateEssence(@ModelAttribute TranslateEssence te, ModelMap model) {
		if (te.getTtIdTranslatesT() != null) {
			te.setNew(false);
		}
		dataLayerService.saveTranslateEssence(te);
		return "redirect:"
				+ BaseController.getListUrl(TextTranslateController.LISTTRANSLATEESSENCE);
	}
	
	
	@RequestMapping(value = "/showTranslatesBySubjectItem")
	public String showTranslates(ModelMap model) {
		model.addAttribute("translates", dataLayerService.getListTranslateEssences());
		return "listtranslatesbysubjectsitem";
	}
	
	@RequestMapping(value = "/testTranslateBySubjectT")
	public String testTranslateBySubjectT(ModelMap model) {
		model.addAttribute("newtest", new Tests());
		model.addAttribute("subjectst", dataLayerService.getMapSubjectT(0));
		model.addAttribute("langList", dataLayerService.getMapLangs());
		return "test";
	}
	
	@RequestMapping(value = "/saveTest", method = RequestMethod.POST)
	public String saveTest(@ModelAttribute Tests t, ModelMap model) {
		if (t.getIdtests() != null) {
			t.setNew(false);
		}
		dataLayerService.saveTest(t);
		return "test";
		//return "redirect:"
		//		+ BaseController.getListUrl(TextTranslateController.LISTTRANSLATEESSENCE);
	}
	
	@RequestMapping(value = "/ajaxGetAllLang", method = RequestMethod.GET)
	public String eajaxGetAllLang( ModelMap model) {
		model.addAttribute("langList", dataLayerService.getMapLangs());
		return "ajaxgetalllang";
	}
}
