package com.austinbruch.hangmansolver.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.austinbruch.hangmansolver.models.Word;

public class Controller {

	private Context mContext;
	private ArrayList<String>listOfAllWords;
	private ArrayList<String>validResults;
	private boolean DEBUG_MODE = true;


	public Controller(Context context){
		this.mContext = context;
	}

	public void loadWordList() {
		// first, try to load the ArrayList from the device from a previous save
		// if we can't load it, then parse the file from into a new ArrayList

		// for now, always parsing the text file, will work on loading from file later
		parseWordListFile();
		validResults = new ArrayList<String>();
		validResults.addAll(listOfAllWords);
	}
	
	public void grabInputs() {
		
	}

	private void generateAnswerPossibilities(int length, String currentKnown, String lettersNotUsed) {
		// this is the overall controller function
		// we want to take in user input, filter results, and display results on screen
		filterOnLength(length); // taking all of the words in valid results, eliminiate those that are the wrong length
		
		
	}
	
	private void filterOnLength(int length) {
		for(String iter : validResults) {
			if(iter.length() != length) {
				validResults.remove(iter);
			}
		}
	}
	
	private void writeResults(){
		
	}
	
 	private void parseWordListFile(){
		listOfAllWords = new ArrayList<String>();
		Scanner fileReader = null;

		AssetManager assetManager = mContext.getResources().getAssets();
		InputStream inputStream = null;

		try {
			inputStream = assetManager.open("enable1.txt");
			if ( inputStream != null) {
				String line = null;
				fileReader = new Scanner(inputStream).useDelimiter("");
				while(fileReader.hasNext())
				{
					String currentWord = fileReader.nextLine().toUpperCase(Locale.getDefault());
					listOfAllWords.add(currentWord);
				}
				Log.i("Test", "Size of arraylist:" + listOfAllWords.size());
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
