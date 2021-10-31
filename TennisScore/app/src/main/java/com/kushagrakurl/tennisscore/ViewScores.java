package com.kushagrakurl.tennisscore;

import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;

/**
 * TODO: document your custom view class.
 */
public class ViewScores extends AppCompatActivity implements View.OnClickListener {
    Button incScore;
    Button decScore;
    RadioGroup selectedPlayer;
    Slider jumpVal;
    TextView set1_1;
    TextView set1_2;
    TextView set2_1;
    TextView set2_2;
    TextView set3_1;
    TextView set3_2;
    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_view_scores);

        selectedPlayer = (RadioGroup)findViewById(R.id.radioGroup);
        jumpVal = (Slider)findViewById(R.id.jumpValue);

        incScore = (Button)findViewById(R.id.addScore);
        decScore = (Button)findViewById(R.id.removeScore);
        incScore.setOnClickListener(this);
        decScore.setOnClickListener(this);

        set1_1 = (TextView)findViewById(R.id.set1_1);
        set1_2 = (TextView)findViewById(R.id.set1_2);
        set2_1 = (TextView)findViewById(R.id.set2_1);
        set2_2 = (TextView)findViewById(R.id.set2_2);
        set3_1 = (TextView)findViewById(R.id.set3_1);
        set3_2 = (TextView)findViewById(R.id.set3_2);

        alert = new AlertDialog.Builder(this);
    }

    @Override
    public void onClick(View view) {
        int selectedPlayerID = selectedPlayer.getCheckedRadioButtonId();
        int jumpPointBy = (int) jumpVal.getValue();
        int set11 = Integer.parseInt(set1_1.getText().toString());
        int set12 = Integer.parseInt(set1_2.getText().toString());
        int set21 = Integer.parseInt(set2_1.getText().toString());
        int set22 = Integer.parseInt(set2_2.getText().toString());
        int set31 = Integer.parseInt(set3_1.getText().toString());
        int set32 = Integer.parseInt(set3_2.getText().toString());

        switch (view.getId()){
            case R.id.addScore:{
                if( Math.abs(set11 - set12) < 2 ){
                    if (selectedPlayerID == 1){
                        set1_1.setText(set11 += 1);
                    }
                    else {
                        set1_2.setText(set12 += 1);
                    }
                }
                else if( Math.abs(set21 - set22) < 2 ){
                    if (selectedPlayerID == 1){
                        set2_1.setText(set21 += 1);
                    }
                    else {
                        set2_2.setText(set22 += 1);
                    }
                }
                else if( Math.abs(set31 - set32) < 2 ){
                    if (selectedPlayerID == 1){
                        set3_1.setText(set31 += 1);
                    }
                    else {
                        set3_2.setText(set32 += 1);
                    }
                }
                else {
                    alert.setMessage("Cannot add score to final score").setTitle("Match Over!");
                    AlertDialog alertBox = alert.create();
                    alertBox.setTitle("Match Over!");
                    alertBox.show();
                }
            }
            case R.id.removeScore:{
                if( Math.abs(set11 - set12) < 2 && set11 > 0 && set12 > 0){
                    if (selectedPlayerID == 1){
                        set1_1.setText(set11 -= 1);
                    }
                    else {
                        set1_2.setText(set12 -= 1);
                    }
                }
                else if( Math.abs(set21 - set22) < 2 && set21 > 0 && set22 > 0){
                    if (selectedPlayerID == 1){
                        set2_1.setText(set21 -= 1);
                    }
                    else {
                        set2_2.setText(set22 -= 1);
                    }
                }
                else if( Math.abs(set31 - set32) < 2 && set31 > 0 && set32 > 0){
                    if (selectedPlayerID == 1){
                        set3_1.setText(set31 -= 1);
                    }
                    else {
                        set3_2.setText(set32 -= 1);
                    }
                }
                else {
                    alert.setMessage("Cannot add score to final score").setTitle("Match Over!");
                    AlertDialog alertBox = alert.create();
                    alertBox.setTitle("Match Over!");
                    alertBox.show();
                }

            }
        }
    }
}