package ys.service;

import ys.dao.WordDao;
import ys.main.WordSet;

public class WordRegisterService {

	private WordDao wordDao;

	public WordRegisterService(WordDao wordDao) {
		// TODO Auto-generated constructor stub
		this.wordDao = wordDao;
	}

	public void register(WordSet wordSet) {
		// TODO Auto-generated method stub
		String key = wordSet.getKey();
		if (this.verify(key)) {
			this.wordDao.insert(wordSet);
		} else
			System.out.println("이미 키워드가 존재 합니다.");

	}

	public boolean verify(String key) {
		// TODO Auto-generated method stub

		WordSet wordSet = this.wordDao.select(key);
		return wordSet == null ? true : false;

	}

}
