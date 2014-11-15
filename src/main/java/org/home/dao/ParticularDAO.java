package org.home.dao;

import java.util.List;
import java.util.Map;

import org.home.models.BindSubj;
import org.home.models.Lang;
import org.home.models.LocaleTranslate;
import org.home.models.SubjectT;
import org.home.models.Tests;
import org.home.models.TextType;

/**
 * DAO particulars
 * @author Olga&Sergey Ogarkov
 * since 05.01.2014
 *
 */
public interface ParticularDAO {
	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	public Integer createLang(Lang lang);*/
	
	public Lang getLangByIdLang(long idLang);
	
	/*ПО-МОЕМОМУ НЕ ИСПОЛЬЗУЕТСЯ, УБРАТЬ!!!
	public Integer updateLang(Lang lang);*/
	
	public Integer deleteLang(Lang lang);
	
	public List<Lang> getListLangs();
	
		
	public Integer createTextType(TextType textType);
	
	public TextType getTextTypeByIdTextType(long idTextType);
	
	public Integer updateTextType(TextType textType);
	
	public Integer deleteTextType(TextType textType);
	
	public List<TextType> getListTextTypes();
	

	public Integer createBindSubj(BindSubj bindSubj);
	
	public BindSubj getBindSubjById(long id);
	
	public Integer updateBindSubj(BindSubj bindSubj);
	
	public Integer deleteBindSubj(BindSubj bindSubj);
	
	public List<BindSubj> getListBindsSubj();
	
	
	public Integer createSubjectT(SubjectT subjectT);
	
	public SubjectT getSubjectTByIdSubjectT(long idSubjectT);
	
	public Integer updateSubjectT(SubjectT subjectT);
	
	public Integer deleteSubjectT(SubjectT subjectT);
	
	public List<SubjectT> getListSubjectTs();

		
	public Integer createLocaleTranslate(LocaleTranslate localeTranslate);
	
	public LocaleTranslate getLocaleTranslateByIdTranslate(long idTranslate);
	
	public Integer updateLocaleTranslate(LocaleTranslate localeTranslate);
	
	public Integer deleteLocaleTranslate(LocaleTranslate localeTranslate);
	
	public List<LocaleTranslate> getListLocaleTranslates();

	public Lang saveLang(Lang lang);

	public TextType saveTextType(TextType tt);
	
	//public CommonSubjects saveCommonSubject(CommonSubjects cs);
	
	public List<BindSubj> getBindSubjDependencyOfCommonSubjects(long id);

	public Map getMapLangs();

	public Map getMapTextTypes();

	public Tests saveTest(Tests test);

	public LocaleTranslate getRandomLocaleTranslateByIdSubjectT(String idsts);

	public List<Long> getListChildsIdSubjectTByParentIDSubjectT(long id);

	public String getStringFromGetListChildsIdSubjectTByParentIDSubjectT(long id);

	public LocaleTranslate getAnswerLocaleTranslateByIditemOfTranslatesT(long iditem,
			long idlang);

	public Long getItemsTIdItemsTByLocaleTranslateIdTranslate(long idTranslate);
	
	public Map getAjaxAllLang();

}
