package com.hbo.got.entity;

public class Meaning {
	private long id;
	private String enMean;
	private String viMean;
	private Vocabulary vocabulary;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEnMean() {
		return enMean;
	}
	public void setEnMean(String enMean) {
		this.enMean = enMean;
	}
	public String getViMean() {
		return viMean;
	}
	public void setViMean(String viMean) {
		this.viMean = viMean;
	}
	public Vocabulary getVocabulary() {
		return vocabulary;
	}
	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}
	
	
}
