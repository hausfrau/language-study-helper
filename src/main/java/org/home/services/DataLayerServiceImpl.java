package org.home.services;

import java.util.List;
import java.util.Map;

import org.home.dao.EssenceDAO;
import org.home.dao.ParticularDAO;
import org.home.dao.UserDAO;
import org.home.models.CommonSubjectEssence;
import org.home.models.CommonSubjects;
import org.home.models.Lang;
import org.home.models.LocaleTranslate;
import org.home.models.Role;
import org.home.models.Tests;
import org.home.models.TextType;
import org.home.models.TranslateEssence;
import org.home.models.Users;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DataLayerServiceImpl {
	
	//private static final Logger logger = LoggerFactory.getLogger(DataLayerServiceImpl.class);
	
	@Autowired
	UserDAO userDAO;
	@Autowired	
	EssenceDAO essenceDAO;
	@Autowired	
	ParticularDAO particularDAO;
		
	
	public List<Users> getAllListUsers() {
		return userDAO.getAllListUsers();
	}
	
	
	public List<Role> getAllListRoles() {
		return userDAO.getListRoles();
	}
	
	public Users saveUser(Users user) {		
		return userDAO.saveUser(user);
	}
	
	public void deleteUser(Long id) throws Exception {	
		userDAO.deleteUser(id);	
	} 
	
	public Users getUser(Long id) {
		return userDAO.getUserById(id);
	}
	
	public List<Lang> getListAllLangs() {
		return particularDAO.getListLangs();
	}
	
	public Map<String, String> getMapLangs() {
		return particularDAO.getMapLangs();
	}
	
	public Map<String, String> getMapCommonSubjects(Integer idLang) {
		return essenceDAO.getMapCommonSubjects(idLang);
	}
	
	public Map<String, String> getMapCommonSubjectsGroup() {
		return essenceDAO.getMapCommonSubjectsGroup();
	}
	
	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	public Integer insertLang(Lang lang) {		
		return particularDAO.createLang(lang);
	}*/

	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	public Integer updatetLang(Lang lang) {		
		return particularDAO.updateLang(lang);
	}*/
	
	public void deleteLang(Lang lang) throws Exception {	
		particularDAO.deleteLang(lang);	
	} 
	
	public Lang getLang(Long id) {
		return particularDAO.getLangByIdLang(id);
	}	
	
	public Lang saveLang(Lang lang) {		
		return particularDAO.saveLang(lang);
	}	

	
	public List<TextType> getListAllTextTypes() {
		return particularDAO.getListTextTypes();
	}
	
	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	public Integer insertTextType(TextType tt) {		
		return particularDAO.createTextType(tt);
	}*/
	
	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	public Integer updateTextType(TextType tt) {		
		return particularDAO.updateTextType(tt);
	}*/
	
	public void deleteTextType(TextType tt) throws Exception {	
		particularDAO.deleteTextType(tt);	
	} 
	
	public TextType getTextType(Long id) {
		return particularDAO.getTextTypeByIdTextType(id);
	}	
	
	public TextType saveTextType(TextType tt) {		
		return particularDAO.saveTextType(tt);
	}	

	
	public List<CommonSubjects> getListAllCommonSubjects() {
		return essenceDAO.getListCommonSubjects();
	}
	
	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	public Integer insertCommonSubject(CommonSubjects cs) {		
		return essenceDAO.createCommonSubject(cs);
	}*/

	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	public Integer updateCommonSubject(CommonSubjects cs) {		
		return essenceDAO.updateCommonSubject(cs);
	}*/
	
	public void deleteCommonSubject(CommonSubjects cs) throws Exception {	
		essenceDAO.deleteCommonSubject(cs);	
	} 
	
	public CommonSubjects getCommonSubject(Long id) {
		return essenceDAO.getCommonSubjectByIdCommonSubj(id);
	}	
	
	public CommonSubjects saveCommonSubject(CommonSubjects cs) {		
		return essenceDAO.saveCommonSubject(cs);
	}	

	public List<List<CommonSubjectEssence>> getListCommonSubjectEssences() {
		return essenceDAO.getListCommonSubjectEssences();
	}
	
	/*public List<CommonSubjectEssence> getListCommonSubjectEssences() {
		return essenceDAO.getRowCommonSubjectEssence(null);
	}*/
	
	public CommonSubjectEssence saveCommonSubjectEssence(CommonSubjectEssence cse) {		
		return essenceDAO.saveCommonSubjectEssence(cse);
	}	
	
	public CommonSubjectEssence getCommonSubjectEssenceByBindCommonSubjectId(Long bcsId) {		
		return essenceDAO.getCommonSubjectEssenceByBindCommonSubjectId(bcsId);
	}	
	
	public List<List<TranslateEssence>> getListTranslateEssences() {
		return essenceDAO.getListTranslateEssences();
	}
	
	
	public Map<String, String> getMapSubjectT(Integer lang) {
		return essenceDAO.getMapSubjectT(lang);
	}
	
	public Map<String, String> getMapTranslatesGroup() {
		return essenceDAO.getMapTranslatesGroup();
	}
	
	
	public TranslateEssence getTranslateEssenceByTtIdTranslatesT(long ttidtranslatest) {
		return essenceDAO.getTranslateEssenceByTtIdTranslatesT(ttidtranslatest);
	}
	
	public TranslateEssence saveTranslateEssence(TranslateEssence te) {		
		return essenceDAO.saveTranslateEssence(te);
	}	
	
	public Map<String, String> getMapTextTypes() {
		return particularDAO.getMapTextTypes();
	}
	
	public Map<String, String> getMapSubjectsGroup() {
		return essenceDAO.getMapSubjectsGroup();
	}
	
	/*public List<TranslateEssence> getListTranslatesByIdSubjectT(Long idSubjectT) {
		return essenceDAO.getListTranslatesByIdSubjectT(idSubjectT);
	}*/
	
	public Tests saveTest(Tests test) {		
		return particularDAO.saveTest(test);
	}
	
	//возвращает случайный конкретный перевод по выбранной теме, включая подразделы если нужно, список содержит id-шники выбранных тем 
	public LocaleTranslate getRandomLocaleTranslateByIdSubjectT(String idsts) {
		return particularDAO.getRandomLocaleTranslateByIdSubjectT(idsts);
	}
	
	//вытаскивает id-шники всех дочерних тем по известному id темы
	public List<Long> getListChildsIdSubjectTByParentIDSubjectT(long id) {
		return particularDAO.getListChildsIdSubjectTByParentIDSubjectT(id);
	}
	
	//вытаскивает список id-шников через запятую в строке и всех дочерних тем по известному id темы
	public String getStringFromGetListChildsIdSubjectTByParentIDSubjectT(long id) {
		return particularDAO.getStringFromGetListChildsIdSubjectTByParentIDSubjectT(id);
	}
	
	
	//вытаскивает перевод исходя из сущности фразы и языка
	public LocaleTranslate getAnswerLocaleTranslateByIditemOfTranslatesT(long iditem, long idlang) {
		return particularDAO.getAnswerLocaleTranslateByIditemOfTranslatesT(iditem, idlang);
	}
	
	public Long getItemsTIdItemsTByLocaleTranslateIdTranslate(long id) {
		return particularDAO.getItemsTIdItemsTByLocaleTranslateIdTranslate(id);
	}
	
	/*public TranslateEssence getTranslateessenceByText(String text) {
		return particularDAO.getTranslateessenceByText(text);
	}*/

	public Map<String, String> getAjaxAllLang() {
		return particularDAO.getAjaxAllLang();
	}
	
	
}
