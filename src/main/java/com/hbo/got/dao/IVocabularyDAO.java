package com.hbo.got.dao;

import java.util.List;

import com.hbo.got.entity.Vocabulary;

public interface IVocabularyDAO {
	public Long save(Vocabulary voca);
	public List<Vocabulary> findAll();
	public Vocabulary findByVoca(String voca);
}
