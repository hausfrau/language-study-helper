package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.TextType;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since
 */
public class FindTextMapper implements RowMapper<TextType> {
	@Override
	public TextType mapRow(ResultSet resultSet, int i) throws SQLException {
		TextType tt = new TextType();
		tt.setIdTextType(resultSet.getLong("idtext_type"));
		tt.setTextTypeName(resultSet.getString("text_typename"));
		return tt;
	}
	
	/*
	lt.idtranslate ltidtranslate, lt.text lttext, lt.idlang ltidlang, lt.idgender ltidgender, 
	lt.plur_ends ltplur_ends, 
    lt.root_changes,
    lt.idSubject_t,
    lt.path_mp3
    
    `bindtranslatesubject`.`id`,
    `bindtranslatesubject`.`idtranslate`,
    `bindtranslatesubject`.`idsubjectt`
    
    `subject_t`.`idsubject_t`,
    `subject_t`.`subject_name`,
    `subject_t`.`lang`,
    `subject_t`.`pid`*/
}
