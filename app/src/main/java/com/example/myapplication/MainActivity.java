package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaCas;
import android.os.Bundle;
import android.util.EventLog;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.*;
import com.faendir.rhino_android.RhinoAndroidHelper;

import java.util.EventListener;
import java.util.EventObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Made By Rutvik Rathod", Toast.LENGTH_SHORT).show();


    }

    public void btnlistener1(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.append("1");

    }

    public void btnlistener2(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.append("2");

    }

    public void btnlistener3(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.append("3");

    }

    public void btnlistener4(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.append("4");

    }

    public void btnlistener5(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.append("5");

    }

    public void btnlistener6(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.append("6");

    }

    public void btnlistener7(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.append("7");

    }

    public void btnlistener8(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.append("8");

    }

    public void btnlistener9(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.append("9");

    }

    public void btnlistener0(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        if(tv.getText().toString().equals(""))
            tv.append("0");
        if(tv.getText().toString().equals("0"))
            tv.append("");
        else
            tv.append("0");

    }

    public void btnlistener00(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        if(tv.getText().toString().equals(""))
            tv.append("0");
        if(tv.getText().toString().equals("0"))
            tv.append("");
        else {
            tv.append("00");
        }

    }

    public void btnlistenerdot(View v) {
        TextView tv=(TextView) findViewById(R.id.textView);

        if(!tv.getText().toString().contains(".")){
            tv.append(".");
        }


    }

    public void btnlistenerpercentage(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
           if(!tv.getText().toString().equals(""))
              tv.append("%");

    }

    public void btnlistenerdevide(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
              if(!tv.getText().toString().equals("")) {
                  tv.append("÷");
              }

    }

    public void btnlistenermul(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        int len=tv.getText().length();
        String currentexp=tv.getText().toString();
        if(currentexp.charAt(len-1)=='×')
        {
            tv.append("");

        }
          else
            tv.append("×");

    }

    public void btnlistenerminus(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.append("-");

    }

    public void btnlisteneradd(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        if(!tv.getText().toString().equals("")) {
            tv.append("+");
        }

    }

    public void btnlistenerclr(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        tv.setText("");
        tv2.setText("");


    }

    public void btnlistenerbackspace(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        String text = (tv.getText()).toString();
        if (!text.equals("")) {
            String newstr = text.substring(0, text.length() - 1);
            tv.setText(newstr);
        }
    }

    public void btnlisteneraddcalc(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        String exp = tv.getText().toString();

        //  String ar[]=exp.split("[*,/,-,+]");
//        int num1=Integer.parseInt(ar[0]);
//        int num2=Integer.parseInt(ar[1]);
      //  exp = exp.replaceAll("%", );
        exp=exp.replaceAll("÷","/");
        exp=exp.replaceAll("×","*");
        new RhinoAndroidHelper().enterContext().setOptimizationLevel(-1);

        String finalres = "";
        try {
            Scriptable scriptable=new RhinoAndroidHelper().enterContext().initStandardObjects();
    finalres=new RhinoAndroidHelper().enterContext().evaluateString(scriptable,exp,"javascript",1,null).toString();
        } catch (Exception e) {
            finalres = "0";
        }
        if(!finalres.contains(".")) {
            Double f = Double.valueOf(finalres);
            int res = Integer.valueOf(f.intValue());
            tv2.setText(String.valueOf(res));
        }
        else{
            tv2.setText(finalres);
        }


    }
}