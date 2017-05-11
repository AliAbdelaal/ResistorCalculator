package com.Ali.resistorcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;

public class Resistor_Main extends ActionBarActivity {

	TextView ans;
	EditText ip1,ip2;
	Button btn;
	Spinner state;
	ImageView img;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor__main);
        ans=(TextView) findViewById(R.id.textView3);
        ip1=(EditText) findViewById(R.id.editText1);
        ip2=(EditText) findViewById(R.id.editText2); 
        btn=(Button)   findViewById(R.id.button1);
        state=(Spinner)findViewById(R.id.spinner1);
        img=(ImageView)findViewById(R.id.imageView1);
        img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clear();
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(img.getWindowToken(), 0);
				
			}
		});
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(isEmpty()) Toast.makeText(getApplicationContext(), "enter values !", Toast.LENGTH_SHORT).show();
				else calculate();
				
			}
		});
        ip1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ip2.requestFocus();
				
			}
		});
        ip2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(isEmpty()) Toast.makeText(getApplicationContext(), "enter values !", Toast.LENGTH_SHORT).show();
				else calculate();
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(img.getWindowToken(), 0);
				
			}
		});
        
    }
    
    protected void clear(){
    	ip1.setText("");
    	ip2.setText("");
    	ans.setText("Sum =");
    }
    protected boolean isEmpty(){
    	String tst1 = ip1.getText().toString().trim();
    	String tst2 = ip2.getText().toString().trim();
    	if(tst1.equals("")||tst2.equals("")) return true;
    	else return false;
    	
    }
    
    protected void calculate(){
    	double R1 = Double.parseDouble(ip1.getText().toString());
    	double R2 = Double.parseDouble(ip2.getText().toString());
    	double sum =0d;
    	if(state.getSelectedItem().toString().equals("Parallel to")){
    		sum = (R1 * R2) / (R1 + R2);
    	}
    	else {
    		sum = (R1 + R2);
    	}
    	String ansString = String.format("%1.2f Ω", sum);
    	ans.setText(ansString);
    }
    


    
}
