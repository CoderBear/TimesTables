package com.udemy.sbsapps.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ListView listView;

    ArrayAdapter<Integer> arrayAdapter;
    ArrayList<Integer> multiplicationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.listView);

        multiplicationList = new ArrayList<>();
        for(int i = 1; i < seekBar.getMax() + 1; i++) {
            multiplicationList.add((seekBar.getProgress() + 1)*i);
        }

        arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, multiplicationList);
        listView.setAdapter(arrayAdapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                multiplicationList.clear();
                if (progress >= min) {
                    for(int i = 1; i < seekBar.getMax() + 1; i++) {
                        multiplicationList.add((progress + 1)*i);
                    }

                    arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, multiplicationList);
                    listView.setAdapter(arrayAdapter);

//                    for(int j = 0; j < multiplicationList.size(); j++) {
//                        Log.i("info", multiplicationList.get(j).toString());
//                    }
                } else {
                    seekBar.setProgress(min);
                    for(int i = 1; i < seekBar.getMax() + 1; i++) {
                        multiplicationList.add((progress + 1)*i);
                    }

                    arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, multiplicationList);
                    listView.setAdapter(arrayAdapter);

//                    for(int j = 0; j < multiplicationList.size(); j++) {
//                        Log.i("info", multiplicationList.get(j).toString());
//                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
