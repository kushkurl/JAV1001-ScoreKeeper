//Kushagra Kurl - A00246944 
//Jaskirat kaur - A00219135

package com.kushagrakurl.tennisscore;

import android.os.Bundle;



import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
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
    RadioGroup radioGrp;
    RadioButton pID;
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

        radioGrp = (RadioGroup)findViewById(R.id.radioGroup);
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
        int playerID  = (int)radioGrp.getCheckedRadioButtonId();
        pID=(RadioButton)findViewById(playerID);
        String selectedPlayerID = pID.getText().toString();//Integer.parseInt(pID.getText().toString());
        int jumpPointBy = (int) jumpVal.getValue();
        int set11 = Integer.parseInt(set1_1.getText().toString());
        int set12 = Integer.parseInt(set1_2.getText().toString());
        int set21 = Integer.parseInt(set2_1.getText().toString());
        int set22 = Integer.parseInt(set2_2.getText().toString());
        int set31 = Integer.parseInt(set3_1.getText().toString());
        int set32 = Integer.parseInt(set3_2.getText().toString());

        switch (view.getId()){
            case R.id.addScore:{
                if( (set11 < 6 && set12 < 6) || Math.abs(set11 - set12) < 2){

                        if (selectedPlayerID.equals("1")) {
                            set11 = set11 + jumpPointBy;
                            set1_1.setText(String.valueOf(set11));
                        } else if (selectedPlayerID.equals("2")) {
                            set12 = set12 + jumpPointBy;
                            set1_2.setText(String.valueOf(set12));
                        }

                }
                else if((set21 < 6 && set22 < 6) || Math.abs(set21 - set22) < 2){

                        if (selectedPlayerID.equals("1")) {
                            set21 = set21 + jumpPointBy;
                            set2_1.setText(String.valueOf(set21));
                        } else if (selectedPlayerID.equals("2")) {
                            set22 = set22 + jumpPointBy;
                            set2_2.setText(String.valueOf(set22));
                        }

                }
                else if((set31 < 6 && set32 < 6) || Math.abs(set31 - set32) < 2){

                        if (selectedPlayerID.equals("1")) {
                            set31 = set31 + jumpPointBy;
                            set3_1.setText(String.valueOf(set31));
                        } else if (selectedPlayerID.equals("2")) {
                            set32 = set32 + jumpPointBy;
                            set3_2.setText(String.valueOf(set32));
                        }

                }
                else {
                    alert.setMessage("Cannot add score to final score").setTitle("Match Over!");
                    AlertDialog alertBox = alert.create();
                    alertBox.setTitle("Match Over!");
                    alertBox.show();
                }
            }
            break;
            case R.id.removeScore:{
                if( set11 < 6 || set12 < 6){
                    if (selectedPlayerID.equals("1") && set11 > 0){
                        set11 = (set11 - jumpPointBy) < 0 ? 0 : (set11 - jumpPointBy);

                        set1_1.setText(String.valueOf(set11));
                    }
                    else if(selectedPlayerID.equals("2") && set12 > 0){
                        set12 = (set12 - jumpPointBy) < 0 ? 0 : (set12 - jumpPointBy);
                        set1_2.setText(String.valueOf(set12));
                    }
                }
                else if( set21 < 6 || set22 < 6){
                    if (selectedPlayerID.equals("1") && set21 > 0){
                        set21 = (set21 - jumpPointBy) < 0 ? 0 : (set21 - jumpPointBy);
                        set2_1.setText(String.valueOf(set21));
                    }
                    else if(selectedPlayerID.equals("2") && set22 > 0){
                        set22 = (set22 - jumpPointBy) < 0 ? 0 : (set22 - jumpPointBy);
                        set2_2.setText(String.valueOf(set22));
                    }
                }
                else if( set31 < 6 || set32 < 6){
                    if (selectedPlayerID.equals("1") && set31 > 0){
                        set31 = (set31 - jumpPointBy) < 0 ? 0 : (set31 - jumpPointBy);
                        set3_1.setText(String.valueOf(set31));
                    }
                    else if(selectedPlayerID.equals("2") && set32 > 0){
                        set32 = (set32 - jumpPointBy) < 0 ? 0 : (set32 - jumpPointBy);
                        set3_2.setText(String.valueOf(set32));
                    }
                }
                else {
                    alert.setMessage("Cannot subtract score from final score").setTitle("Match Over!");
                    AlertDialog alertBox = alert.create();
                    alertBox.setTitle("Match Over!");
                    alertBox.show();
                }

            }
        }
    }
}