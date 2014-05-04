package com.austinbruch.hangmansolver.models;


public class Word {
	private int letterCount;
	private String word;
	
	
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

	@Override
	public String toString(){
		return this.word;
	}
}
