package com.austinbruch.hangmansolver.models;

import java.util.ArrayList;

public class Word {
	private int letterCount;
	private String word;
	private ArrayList<Character> lettersNotUsed = new ArrayList<Character>();
	
	public int getLetterCount() {
		return letterCount;
	}
	public void setLetterCount(int letterCount) {
		this.letterCount = letterCount;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public ArrayList<Character> getLettersNotUsed() {
		return lettersNotUsed;
	}
	public void setLettersNotUsed(ArrayList<Character> lettersNotUsed) {
		this.lettersNotUsed = lettersNotUsed;
	}

	@Override
	public String toString(){
		return this.word;
	}
}
