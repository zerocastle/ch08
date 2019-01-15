package ys.service;

import ys.dao.WordDao;
import ys.main.WordSet;

public class WordSearchService {

	private WordDao wordDao;

	public WordSearchService(WordDao wordDao) {
		// TODO Auto-generated constructor stub
		this.wordDao = wordDao;
	}

	public WordSet searchWord(String key) {
		// TODO Auto-generated method stub

		if (this.verify(key)) {
			return this.wordDao.select(key); // dao 로 접근 하여 없는 key 값을 던져 주어 값을 가지고 온다. 반환 값은 WordSet 객체 값이 된다 
		} else {
			System.out.println("그런 단어는 없습니다.");
		}
		return null;

	}

	private boolean verify(String key) {
		// TODO Auto-generated method stub
		WordSet wordSet = this.wordDao.select(key); // 검색 했는데 없으면 false 를 return
		return wordSet != null ? true : false;

	}

}
