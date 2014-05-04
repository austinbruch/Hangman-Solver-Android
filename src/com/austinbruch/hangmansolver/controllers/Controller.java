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
	private ArrayList<String>listOfWords;
	private boolean DEBUG_MODE = true;


	public Controller(Context context){
		this.mContext = context;
	}

	public void loadWordList() {
		// first, try to load the ArrayList from the device from a previous save
		// if we can't load it, then parse the file from into a new ArrayList

		// for now, always parsing the text file, will work on loading from file later
		parseWordListFile();
	}

	public void generateAnswerPossibilities() {
		// this is the overall controller function
		// we want to take in user input, filter results, and display results on screen
		
	}
	
 	private void parseWordListFile(){
		listOfWords = new ArrayList<String>();
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
					listOfWords.add(currentWord);
				}
				Log.i("Test", "Size of arraylist:" + listOfWords.size());
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
