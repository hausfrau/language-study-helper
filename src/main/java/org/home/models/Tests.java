package org.home.models;

import java.util.Date;

public class Tests extends Base{

	private Long idtests;
	
	private String question;
    
	private Integer questlang;
    
	private Long idlocaletquestion;
    
	private String answer;
    
	private Integer answerlang;
    
	private Integer result;
    
	private String rightanswer;
    
	private Long idlocaletrightanswer;
    
	private Date date;
    
	private Long idsubjectt;

	public Long getIdtests() {
		return idtests;
	}

	public void setIdtests(Long idtests) {
		this.idtests = idtests;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getQuestlang() {
		return questlang;
	}

	public void setQuestlang(Integer questlang) {
		this.questlang = questlang;
	}

	public Long getIdlocaletquestion() {
		return idlocaletquestion;
	}

	public void setIdlocaletquestion(Long idlocaletquestion) {
		this.idlocaletquestion = idlocaletquestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getAnswerlang() {
		return answerlang;
	}

	public void setAnswerlang(Integer answerlang) {
		this.answerlang = answerlang;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getRightanswer() {
		return rightanswer;
	}

	public void setRightanswer(String rightanswer) {
		this.rightanswer = rightanswer;
	}

	public Long getIdlocaletrightanswer() {
		return idlocaletrightanswer;
	}

	public void setIdlocaletrightanswer(Long idlocaletrightanswer) {
		this.idlocaletrightanswer = idlocaletrightanswer;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public Long getIdsubjectt() {
		return idsubjectt;
	}

	public void setIdsubjectt(Long idsubjectt) {
		this.idsubjectt = idsubjectt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result
				+ ((answerlang == null) ? 0 : answerlang.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime
				* result
				+ ((idlocaletquestion == null) ? 0 : idlocaletquestion
						.hashCode());
		result = prime
				* result
				+ ((idlocaletrightanswer == null) ? 0 : idlocaletrightanswer
						.hashCode());
		result = prime * result
				+ ((idsubjectt == null) ? 0 : idsubjectt.hashCode());
		result = prime * result + ((idtests == null) ? 0 : idtests.hashCode());
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result
				+ ((questlang == null) ? 0 : questlang.hashCode());
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result
				+ ((rightanswer == null) ? 0 : rightanswer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tests other = (Tests) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (answerlang == null) {
			if (other.answerlang != null)
				return false;
		} else if (!answerlang.equals(other.answerlang))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idlocaletquestion == null) {
			if (other.idlocaletquestion != null)
				return false;
		} else if (!idlocaletquestion.equals(other.idlocaletquestion))
			return false;
		if (idlocaletrightanswer == null) {
			if (other.idlocaletrightanswer != null)
				return false;
		} else if (!idlocaletrightanswer.equals(other.idlocaletrightanswer))
			return false;
		if (idsubjectt == null) {
			if (other.idsubjectt != null)
				return false;
		} else if (!idsubjectt.equals(other.idsubjectt))
			return false;
		if (idtests == null) {
			if (other.idtests != null)
				return false;
		} else if (!idtests.equals(other.idtests))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (questlang == null) {
			if (other.questlang != null)
				return false;
		} else if (!questlang.equals(other.questlang))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (rightanswer == null) {
			if (other.rightanswer != null)
				return false;
		} else if (!rightanswer.equals(other.rightanswer))
			return false;
		return true;
	}
	
    
	
	
}
