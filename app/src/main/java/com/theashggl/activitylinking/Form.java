package com.theashggl.activitylinking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Form extends AppCompatActivity {
    databases db;
    EditText frt,seco,father,adress;
    RadioGroup grp1,grp2;
    RadioButton gen,nat;
    Button clik,updt;
    TextView ones,two,three,four,five,six,seven,eight;
    public String er,sr,bg,gender,nation;
    Integer yu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        db=new databases(Form.this);
        frt= findViewById(R.id.firstone);
        seco= findViewById(R.id.secondone);
        father= findViewById(R.id.Father);
        adress= findViewById(R.id.addr);
        grp1= findViewById(R.id.rbg1);
        grp2= findViewById(R.id.rbg2);
        clik= findViewById(R.id.buttton);
        ones= findViewById(R.id.fname);
        two= findViewById(R.id.sname);
        three= findViewById(R.id.faname);
        four= findViewById(R.id.adres);
        five= findViewById(R.id.gender);
        six= findViewById(R.id.Nation);
        seven= findViewById(R.id.display1);
        eight= findViewById(R.id.display2);
        updt= findViewById(R.id.updates);

        clik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                er = frt.getText().toString();
                sr = seco.getText().toString();
                bg = father.getText().toString();
                yu = Integer.parseInt(String.valueOf(adress.getText()));


                int selectedId = grp1.getCheckedRadioButtonId();

                int secondradio = grp2.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                gen = (RadioButton) findViewById(selectedId);
                gender = gen.getText().toString();
                nat = (RadioButton) findViewById(secondradio);
                nation = nat.getText().toString();


                ones.setText(er);
                two.setText(sr);
                three.setText(bg);
                four.setText("Address is " + yu + " , gender is " + gender + " and the nationality is " + nation);


                if (er.equalsIgnoreCase("")) {
                    frt.setError("Enter your first name");
                    frt.requestFocus();
                } else if (sr.equalsIgnoreCase("")) {
                    seco.setError("Enter your last name");
                    seco.requestFocus();
                } else if (bg.equalsIgnoreCase("")) {
                    father.setError("Enter your father's name");
                    father.requestFocus();
                } else if (yu.equals("")) {
                    adress.setError("Enter your roll");
                    adress.requestFocus();
                } else if (grp1.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Form.this, "Please select an item from the radio button", Toast.LENGTH_SHORT).show();
                } else if (grp2.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Form.this, "Please select an item from the radio button", Toast.LENGTH_SHORT).show();
                }


                else {
                    long insertdata = db.insertdata(er, sr, bg, yu);
                    if (insertdata>0) {
                        Toast.makeText(Form.this, "Data inserted Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Form.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        updt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean datatruth=db.update(er,sr,bg,adress.getText().toString());

                if(er.equalsIgnoreCase("")) {
                    frt.setError("Enter your first name");
                    frt.requestFocus();
                } else if (sr.equalsIgnoreCase("")) {
                    seco.setError("Enter your last name");
                    seco.requestFocus();
                } else if (bg.equalsIgnoreCase("")) {
                    father.setError("Enter your father's name");
                    father.requestFocus();
                } else if (yu.equals("")) {
                    adress.setError("Enter your roll");
                    adress.requestFocus();
                } else if (grp1.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Form.this, "Please select an item from the radio button", Toast.LENGTH_SHORT).show();
                } else if (grp2.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Form.this, "Please select an item from the radio button", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (datatruth == true) {
                        Toast.makeText(Form.this, "success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Form.this, "unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}