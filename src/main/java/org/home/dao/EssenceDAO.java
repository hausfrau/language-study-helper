package org.home.dao;

import java.util.List;
import java.util.Map;

import org.home.models.BindCommonSubjects;
import org.home.models.CommonSubjectEssence;
import org.home.models.CommonSubjects;
import org.home.models.CommonSubjectsItems;
import org.home.models.ItemsT;
import org.home.models.SubjectsItems;
import org.home.models.SubjectsItems1;
import org.home.models.TranslateEssence;
import org.home.models.TranslatesT;

/**
 * DAO Essences
 * @author Olga&Sergey Ogarkov
 * since 05.01.2014
 *
 */
public interface EssenceDAO {
	
	public Integer createCommonSubject(CommonSubjects commonSubject);
	
	public CommonSubjects getCommonSubjectByIdCommonSubj(long idCommonSubj);
	
	public Integer updateCommonSubject(CommonSubjects commonSubject);
	
	public Integer deleteCommonSubject(CommonSubjects commonSubject);
	
	public List<CommonSubjects> getListCommonSubjects();
	
		
	public Integer createCommonSubjectsItem(CommonSubjectsItems commonSubjectsItem);
	
	public CommonSubjectsItems getCommonSubjectsItemById(long id);
	
	public Integer updateCommonSubjectsItem(CommonSubjectsItems commonSubjectsItem);
	
	public Integer deleteCommonSubjectsItem(CommonSubjectsItems commonSubjectsItem);
	
	public List<CommonSubjectsItems> getListCommonSubjectsItems();
	

	public Integer createBindCommonSubject(BindCommonSubjects bindCommonSubject);
	
	public BindCommonSubjects getBindCommonSubjectById(long id);
	
	public Integer updateBindCommonSubject(BindCommonSubjects bindCommonSubjects);
	
	public Integer deleteBindCommonSubject(BindCommonSubjects bindCommonSubjects);
	
	public List<BindCommonSubjects> getListBindsCommonSubjects();
	
	
	public Integer createSubjectsItems(SubjectsItems subjectItem);
	
	public SubjectsItems getSubjectItemById(long id);
	
	public Integer updateSubjectItem(SubjectsItems subjectItem);
	
	public Integer deleteSubjectItem(SubjectsItems subjectItem);
	
	public List<SubjectsItems> getListSubjectsItems();
	
	
	public Integer createSubjectItem1(SubjectsItems1 subjectItem1);
	
	public SubjectsItems1 getSubjectItem1ById(long id);
	
	public Integer updateSubjectItem1(SubjectsItems1 subjectItem1);
	
	public Integer deleteSubjectItem1(SubjectsItems1 subjectItem1);
	
	public List<SubjectsItems1> getListSubjectsItems1();
	
	
	public Integer createItemT(ItemsT itemT);
	
	public ItemsT getItemsTByIdItemsT(long idItemsT);
	
	public Integer updateItemT(ItemsT itemT);
	
	public Integer deleteItemT(ItemsT ItemT);
	
	public List<ItemsT> getListItemsT();
	
	
	public Integer createTranslateT(TranslatesT translateT);
	
	public TranslatesT getTranslateTByIdTranslatesT(long id);
	
	public Integer updateTranslateT(TranslatesT translateT);
	
	public Integer deleteTranslatesT(TranslatesT translateT);
	
	public List<TranslatesT> getListTranslatesT();
	
	
	public CommonSubjects saveCommonSubject(CommonSubjects cs) ;// throws Exception ;
	
	public CommonSubjectsItems saveCommonSubjectsItems(CommonSubjectsItems csi);
	
	public BindCommonSubjects saveBindCommonSubjects(BindCommonSubjects bcs);
	
	public CommonSubjectsItems getPidCommonSubjectItemsFromCommonSubjects(long id);

	public Map<String, String> getMapCommonSubjects(Integer idLang);

	public CommonSubjectEssence saveCommonSubjectEssence(
			CommonSubjectEssence cse);
	
	public List<List<CommonSubjectEssence>> getListCommonSubjectEssences();
	
	//public List<CommonSubjectEssence> getRowCommonSubjectEssence(Long id);
	
	public CommonSubjectEssence getCommonSubjectEssenceByBindCommonSubjectId(long bcsId);
	
	public Integer updateCommonSubjectsItemByPid(Long id, Long pid);

	public Map<String, String> getMapCommonSubjectsGroup();

	public List<List<TranslateEssence>> getListTranslateEssences();

	public Map<String, String> getMapSubjectT(Integer lang);

	public Map<String, String> getMapTranslatesGroup();

	public TranslateEssence getTranslateEssenceByTtIdTranslatesT(long ttidtranslatest);

	public TranslateEssence saveTranslateEssence(TranslateEssence te);

	public Map<String, String> getMapSubjectsGroup();
	
	//public TranslateEssence getListTranslatesByIdSubjectT(long idSubjectT);

	public TranslateEssence getTranslateEssenceByTranslatesT(long ttIdItem);

	

}
