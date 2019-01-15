package ys.dao;

import java.util.HashMap;
import java.util.Map;

import ys.main.WordSet;

public class WordDao {
	private Map<String, WordSet> wordDB = new HashMap<String, WordSet>();

	public WordDao() {
		// TODO Auto-generated constructor stub
	}

	public void insert(WordSet wordSet) {
		// TODO Auto-generated method stub
		this.wordDB.put(wordSet.getKey(), wordSet);

	}

	public WordSet select(String key) {
		return this.wordDB.get(key);
	}

}
