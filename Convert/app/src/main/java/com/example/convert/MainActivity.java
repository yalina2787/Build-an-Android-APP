package com.example.convert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    Button convertButton;
    EditText editText_km;
    EditText editText_m;
    String flag = "km";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertButton = (Button) findViewById(R.id.button_convert);
        editText_km = (EditText) findViewById(R.id.editText_km);
        editText_m = (EditText) findViewById(R.id.editText_m);

        convertButton.setOnClickListener(this);
        editText_km.setOnKeyListener(this);
        editText_m.setOnKeyListener(this);
    }




    @Override
    public void onClick(View v) {
        Toast.makeText(this.getBaseContext(), editText_km.getText().toString(), 1000).show();
        float dataKm = 0;
        float dataM = 0;

        try {
            dataKm = Float.parseFloat(editText_km.getText().toString());
        } catch (Exception e) {
            dataKm = 0;
        }

        try {
            dataM = Float.parseFloat(editText_m.getText().toString());
        }  catch (Exception e) {
            dataM = 0;
        }

        if(flag == "km"){
            dataM = dataKm * 1000;
            editText_m.setText(dataM +"");
        }else{
            dataKm = dataM/1000;
            editText_km.setText(dataKm + "");
        }


    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(v == editText_km) {
            flag = "km";

        } else {
            flag = "m";
        }
        Toast.makeText(this.getBaseContext(), flag, 1000).show();
        return false;
    }

}