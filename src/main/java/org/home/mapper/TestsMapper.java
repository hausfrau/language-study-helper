package org.home.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.home.models.Tests;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Olga&Sergey Ogarkov
 * @since 12.03.2014
 */
public class TestsMapper  implements RowMapper<Tests> {
	@Override
	public Tests mapRow(ResultSet resultSet, int i) throws SQLException {
		Tests t = new Tests();
		t.setIdtests(resultSet.getLong("idtests"));
		t.setQuestion(resultSet.getString("question"));
		t.setQuestlang(resultSet.getInt("questlang"));
		t.setIdlocaletquestion(resultSet.getLong("idlocaletquestion"));
		t.setAnswer(resultSet.getString("answer"));
		t.setAnswerlang(resultSet.getInt("answerlang"));
		t.setResult(resultSet.getInt("result"));
		t.setRightanswer(resultSet.getString("rightanswer"));
		t.setIdlocaletrightanswer(resultSet.getLong("idlocaletrightanswer"));
		t.setDate(resultSet.getDate("date"));
		t.setIdsubjectt(resultSet.getLong("idsubjectt"));
		return t;
	}
}
