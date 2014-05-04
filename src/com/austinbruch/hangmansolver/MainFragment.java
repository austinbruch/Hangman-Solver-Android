package com.austinbruch.hangmansolver;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.austinbruch.hangmansolver.controllers.Controller;

public class MainFragment extends Fragment {

	private Controller mController;
	private Context mContext;

	private Spinner letterCountSpinner, sortMethodSpinner;
	private Button submitButton;
	private EditText firstLetterEditText, secondLetterEditText, thirdLetterEditText, fourthLetterEditText;
	private EditText fifthLetterEditText, sixthLetterEditText, seventhLetterEditText, eighthLetterEditText, lettersNotIncludedEditText;
	private ListView wordsResultsListView, lettersResultsListView;

	private String[] lengthChoices = {"2", "3", "4", "5", "6", "7", "8"};
	private String[] sortChoices = {"A to Z", "Z to A"};



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		mContext = getActivity();

		grabUIElements(rootView);
		initializeSpinners();
		setupSpinnerOnItemSelectedListeners();



		mController = new Controller(getActivity());
		mController.loadWordList();


		return rootView;

	}

	private void initializeSpinners() {
		ArrayAdapter<CharSequence> letterCountAdapter = new ArrayAdapter<CharSequence>(mContext, android.R.layout.simple_dropdown_item_1line, lengthChoices);
		//		letterCountAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		letterCountSpinner.setAdapter(letterCountAdapter);

		ArrayAdapter<CharSequence> sortMethodAdapter = new ArrayAdapter<CharSequence>(mContext, android.R.layout.simple_dropdown_item_1line, sortChoices);
		sortMethodSpinner.setAdapter(sortMethodAdapter);

	}

	private void setupSpinnerOnItemSelectedListeners() {
		letterCountSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				switch((int)arg3)
				{
				case 0: // value 2
					enableFocusableEditText(true, true, false, false, false, false, false, false);
					break;
				case 1: // value 3
					enableFocusableEditText(true, true, true, false, false, false, false, false);
					break;
				case 2: // value 4
					enableFocusableEditText(true, true, true, true, false, false, false, false);
					break;
				case 3: // value 5
					enableFocusableEditText(true, true, true, true, true, false, false, false);
					break;
				case 4: // value 6
					enableFocusableEditText(true, true, true, true, true, true, false, false);
					break;
				case 5: // value 7
					enableFocusableEditText(true, true, true, true, true, true, true, false);
					break;
				case 6: // value 8
					enableFocusableEditText(true, true, true, true, true, true, true, true);
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		sortMethodSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

				switch((int)arg3)
				{
				case 0: // value A to Z
					break;
				case 1: // value Z to A
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			} 
		});
	}

	private void enableFocusableEditText(boolean first, boolean second, boolean third, boolean fourth, boolean fifth, boolean sixth, boolean seventh, boolean eighth) {
		firstLetterEditText.setEnabled(first);
		firstLetterEditText.setFocusable(first);
		firstLetterEditText.setClickable(first);
		firstLetterEditText.setFocusableInTouchMode(first);

		secondLetterEditText.setEnabled(second);
		secondLetterEditText.setFocusable(second);
		secondLetterEditText.setClickable(second);
		secondLetterEditText.setFocusableInTouchMode(second);

		thirdLetterEditText.setEnabled(third);
		thirdLetterEditText.setFocusable(third);
		thirdLetterEditText.setClickable(third);
		thirdLetterEditText.setFocusableInTouchMode(third);

		fourthLetterEditText.setEnabled(fourth);
		fourthLetterEditText.setFocusable(fourth);
		fourthLetterEditText.setClickable(fourth);
		fourthLetterEditText.setFocusableInTouchMode(fourth);

		fifthLetterEditText.setEnabled(fifth);
		fifthLetterEditText.setFocusable(fifth);
		fifthLetterEditText.setClickable(fifth);
		fifthLetterEditText.setFocusableInTouchMode(fifth);

		sixthLetterEditText.setEnabled(sixth);
		sixthLetterEditText.setFocusable(sixth);
		sixthLetterEditText.setClickable(sixth);
		sixthLetterEditText.setFocusableInTouchMode(sixth);

		seventhLetterEditText.setEnabled(seventh);
		seventhLetterEditText.setFocusable(seventh);
		seventhLetterEditText.setClickable(seventh);
		seventhLetterEditText.setFocusableInTouchMode(seventh);

		eighthLetterEditText.setEnabled(eighth);
		eighthLetterEditText.setFocusable(eighth);
		eighthLetterEditText.setClickable(eighth);
		eighthLetterEditText.setFocusableInTouchMode(eighth);
	}

	private void grabUIElements(View rootView) {
		letterCountSpinner = (Spinner)rootView.findViewById(R.id.letterCountSpinner);
		sortMethodSpinner = (Spinner)rootView.findViewById(R.id.sortMethodSpinner);

		submitButton = (Button)rootView.findViewById(R.id.submitButton);

		firstLetterEditText = (EditText)rootView.findViewById(R.id.firstLetterEditText);
		secondLetterEditText = (EditText)rootView.findViewById(R.id.secondLetterEditText);
		thirdLetterEditText = (EditText)rootView.findViewById(R.id.thirdLetterEditText);
		fourthLetterEditText = (EditText)rootView.findViewById(R.id.fourthLetterEditText);
		fifthLetterEditText = (EditText)rootView.findViewById(R.id.fifthLetterEditText);
		sixthLetterEditText = (EditText)rootView.findViewById(R.id.sixthLetterEditText);
		seventhLetterEditText = (EditText)rootView.findViewById(R.id.seventhLetterEditText);
		eighthLetterEditText = (EditText)rootView.findViewById(R.id.eighthLetterEditText);

		lettersNotIncludedEditText = (EditText)rootView.findViewById(R.id.lettersNotIncludedEditText);

		wordsResultsListView = (ListView)rootView.findViewById(R.id.wordsResultsListView);
		lettersResultsListView = (ListView)rootView.findViewById(R.id.lettersResultsListView);
	}

}
