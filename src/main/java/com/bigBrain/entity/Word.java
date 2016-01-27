package com.bigBrain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "word")
public class Word {

	public Word() {

	}

	public Word(String word) {
		this.word = word;
	}

	@Id
	@Column(name = "word")
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override public String toString() {
		return "Word{" +
			"word='" + word + '\'' +
			'}';
	}

}
