/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.Locale;

public class NumbersActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Adapter arrayAdapter = new ArrayAdapter(this,,);
        //String [] words String[10];
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word(getString(R.string.one), "lutti", R.drawable.number_one));
        words.add(new Word(getString(R.string.two), "otiiko", R.drawable.number_two));
        words.add(new Word(getString(R.string.three), "tolookosu", R.drawable.number_three));
        words.add(new Word(getString(R.string.four), "oyyisa", R.drawable.number_four));
        words.add(new Word(getString(R.string.five), "massokka", R.drawable.number_five));
        words.add(new Word(getString(R.string.six), "temmokka", R.drawable.number_six));
        words.add(new Word(getString(R.string.seven), "kenekaku", R.drawable.number_seven));
        words.add(new Word(getString(R.string.eight), "kawinta", R.drawable.number_eight));
        words.add(new Word(getString(R.string.nine), "wo'e", R.drawable.number_nine));
        words.add(new Word(getString(R.string.ten), "na'aacha", R.drawable.number_ten));



        /*int index=0;
        for (index=0;index<=words.size();index++)
        {
            //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
            TextView wordView = new TextView(this);
            wordView.setText(words.get(0));
           // rootView.add(wordView);
            //index++;
        }*/

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }


        });

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        final ListView listView = (ListView) findViewById(R.id.list);
        // final TextView number = (TextView) .findViewById(R.id.default_text_view);
        //listView.setAdapter(itemsAdapter);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String wordToSpeak = words.get(position).getmDefaultTranslation().toString();
                Toast.makeText(getApplicationContext(), wordToSpeak, Toast.LENGTH_SHORT).show();
                textToSpeech.speak(wordToSpeak, TextToSpeech.QUEUE_FLUSH, null);

            }
        });


    }

    public void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }
}
