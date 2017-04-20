package com.example.n551.widgettest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import static com.example.n551.widgettest.R.id.mySpinner;

public class MainActivity extends AppCompatActivity {
    private static final String[] CStr ={ "广州", "从化", "武汉", "汕头" };
    private TextView myT;
    private Spinner mySp;
    private ArrayAdapter adap;
    private List allCountries;
    Animation myAni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myT=(TextView)findViewById(R.id.myTextView);
        mySp=(Spinner)findViewById(mySpinner);
        adap=new ArrayAdapter(this, android.R.layout.simple_spinner_item,CStr);
        adap.setDropDownViewResource(R.layout.myspinner_dropdown);
        mySp.setAdapter(adap);
        mySp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView arg0, View arg1,int arg2, long arg3)
            {
                myT.setText(CStr[arg2]);
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView arg0)
            {
                myT.setText("hello");
            }
        });
        myAni = AnimationUtils.loadAnimation(this, R.anim.my_anim);
		/* 将mySpinner加入OnTouchListener */
        mySp.setOnTouchListener(new Spinner.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
				/* 将mySpinner执行Animation */
                v.startAnimation(myAni);
				/* 将mySpinner隐藏 */
                v.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.spinner_demo1, menu);
        return true;
    }
}
