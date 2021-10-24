package com.example.nataliailealmanca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity implements selectListener{
    RecyclerView recyclerView;
    List<dataModel> dataList;
    customAdapter customAdapter;
    getElement getElement;
    ConstraintLayout popup,recyclelayout;
    TextView popGermanText,popTurkishtext,popSentence;
    Button btnreturn;
    ImageView germanFlag, turkishFlag;
    MediaPlayer mediaPlayer;
    TextToSpeech textToSpeech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                germanFlag.findViewById(R.id.imageView);
                turkishFlag.findViewById(R.id.imageView2);
                textToSpeech.setLanguage(Locale.GERMAN);
                if(status!=TextToSpeech.ERROR){

                }

            }


        });
        setContentView(R.layout.activity_main2);

        displayItems();

    }

    private void displayItems() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        dataList=new ArrayList<>();
        Resources res= getResources();
        String[] germanWords= res.getStringArray(R.array.germanWords);
        String[] turkishwords= res.getStringArray(R.array.turkishWords);
        String[] sentences = res.getStringArray(R.array.sentences);
        for(int i = 0; i<germanWords.length;i++){
            getElement getElement = new getElement();
            dataList.add(new dataModel(getElement.getElement(germanWords,i),getElement.getElement(turkishwords,i),getElement.getElement(sentences,i)));
        }



        customAdapter= new customAdapter(this,dataList,this);
        recyclerView.setAdapter(customAdapter);
    }
    private View.OnClickListener returnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            recyclelayout=findViewById(R.id.RecyclerLayout);

            ConstraintLayout popup = findViewById(R.id.popup);
            turkishFlag.setVisibility(View.VISIBLE);
            germanFlag.setVisibility(View.VISIBLE);
            popup.setVisibility(View.GONE);

            recyclelayout.setVisibility(View.VISIBLE);
        }
    };

    @Override
    public void onItemClicked(dataModel dataModel) {

        recyclelayout=findViewById(R.id.RecyclerLayout);
        popGermanText = findViewById(R.id.popGermanText);
        popTurkishtext= findViewById(R.id.popTurkishText);
        popSentence=findViewById(R.id.popSentence);
        ConstraintLayout popup = findViewById(R.id.popup);

        germanFlag.setVisibility(View.GONE);
        turkishFlag.setVisibility(View.GONE);
        btnreturn = findViewById(R.id.button);
        String speech = dataModel.getGerman();
        textToSpeech.speak(speech,TextToSpeech.QUEUE_FLUSH,null);
        popup.setVisibility(View.VISIBLE);
        popSentence.setText(dataModel.getSentences());
        popGermanText.setText(dataModel.getGerman());
        popTurkishtext.setText(dataModel.getTurkish());

        btnreturn.setOnClickListener(returnClick);
        recyclelayout.setVisibility(View.GONE);


    }


}