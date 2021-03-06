package com.example.darklighttheme;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;

import java.util.logging.LogManager;

public class MainActivity extends BaseActivity {
    private final static String KeyStorage = "KeyStorage";


    private EditText display1;
    private EditText display2;
    private MaterialButton key0;
    private MaterialButton key1;
    private MaterialButton key2;
    private MaterialButton key3;
    private MaterialButton key4;
    private MaterialButton key5;
    private MaterialButton key6;
    private MaterialButton key7;
    private MaterialButton key8;
    private MaterialButton key9;
    private MaterialButton keyAdd;
    private MaterialButton keySubtract;
    private MaterialButton keyDivide;
    private MaterialButton keyMultiply;
    private MaterialButton keyEquals;
    private MaterialButton keyC;

    public String a, b, u = "",si="",con="", e = "Math error";
    char ch=' ';
    double exp1=Math.exp(1),v=0.0,pie=Math.PI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initThemeChooser();


        display1 = (EditText) findViewById(R.id.display1);
        display2 = (EditText) findViewById(R.id.display2);
        key0 = findViewById(R.id.key_0);
        key1 = findViewById(R.id.key_1);
        key2 = findViewById(R.id.key_2);
        key3 = findViewById(R.id.key_3);
        key4 = findViewById(R.id.key_4);
        key5 = findViewById(R.id.key_5);
        key6 = findViewById(R.id.key_6);
        key7 = findViewById(R.id.key_7);
        key8 = findViewById(R.id.key_8);
        key9 = findViewById(R.id.key_9);
        keyAdd = findViewById(R.id.key_add);
        keySubtract = findViewById(R.id.key_subtract);
        keyDivide = findViewById(R.id.key_divide);
        keyMultiply = findViewById(R.id.key_multiply);
        keyEquals = findViewById(R.id.key_equals);
        keyC = findViewById(R.id.key_C);



        key0.setOnClickListener(view -> {
            u = u + "0";
            con=si+u;
            display1.setText(con);
        });

        key1.setOnClickListener(view -> {
            u = u + "1";
            con=si+u;
            display1.setText(con);
        });
        key2.setOnClickListener(view -> {
            u = u + "2";
            con=si+u;
            display1.setText(con);
        });
        key3.setOnClickListener(view -> {
            u = u + "3";
            con=si+u;
            display1.setText(con);
        });
        key4.setOnClickListener(view -> {
            u = u + "4";
            con=si+u;
            display1.setText(con);
        });
        key5.setOnClickListener(view -> {
            u = u + "5";
            con=si+u;
            display1.setText(con);
        });
        key6.setOnClickListener(view -> {
            u = u + "6";
            con=si+u;
            display1.setText(con);
        });
        key7.setOnClickListener(view -> {
            u = u + "7";
            con=si+u;
            display1.setText(con);
        });
        key8.setOnClickListener(view -> {
            u = u + "8";
            con=si+u;
            display1.setText(con);
        });
        key9.setOnClickListener(view -> {
            u = u + "9";
            con=si+u;
            display1.setText(con);
        });

        keyAdd.setOnClickListener(view -> {
            u = u + "+";
            con=si+u;
            display1.setText(con);
            ch = '+';
        });
        keySubtract.setOnClickListener(view -> {
            u = u + "-";
            con=si+u;
            display1.setText(con);
            ch = '-';
        });
        keyDivide.setOnClickListener(view -> {
            u = u + "/";
            con=si+u;
            display1.setText(con);
            ch = '/';
        });
        keyMultiply.setOnClickListener(view -> {
            u = u + "*";
            con=si+u;
            display1.setText(con);
            ch = '*';
        });
        keyEquals.setOnClickListener(view -> cal());
        keyC.setOnClickListener(view -> {
            display1.setText("");

        });
        keyC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display1.setText("");
                u="";
                si="";
                con="";
                display2.setText("");
            }
        });



    }

    private void cal() {
        if(ch==' ')
            display2.setText(u);

        b = display1.getText().toString();
        if (si.length() > 0) {
            u = change(u);
            v = Double.parseDouble(u);
            double val = 0.0d;
            if (si.equals("log ")) {
                val = Math.log10(v);
            }
            if (si.equals("ln ")) {
                val = Math.log(v);
            }
            if (si.equals("sin ")) {
                val = Math.sin(Math.toRadians(v));
            }
            if (si.equals("cos "))
                val = Math.cos(Math.toRadians(v));
            if (si.equals("tan ")) {
                if (v == 90) {
                    display2.setText(e);
                    return;
                }
                if (v == 45) {
                    display2.setText("1");
                    return;
                }


                val = Math.tan(Math.toRadians(v));
            }
            a = "" + val;
            display2.setText(a);
            si = "";
            u = "";
            return;


        }
        if (u.equals("e")) {

            String x = "" + exp1;
            display2.setText(x);
            return;
        }
        if (u.equals("??")) {

            String x = "" + pie;
            display2.setText(x);
            return;
        }

        b = change(b);
        double a1 = Double.parseDouble(b.substring(0, b.indexOf(ch)));
        if(u.charAt(u.length()-1)==ch)
            Toast.makeText(getApplicationContext(),"Operand missing", Toast.LENGTH_LONG).show();
        else {
            double a2 = Double.parseDouble(b.substring(b.indexOf(ch) + 1));
            if (ch == '+')
                a1 = a1 + a2;
            if (ch == '-')
                a1 = a1 - a2;
            if (ch == '*')
                a1 = a1 * a2;
            if (ch == '/') {
                if (a2 == 0) {

                    Toast.makeText(getApplicationContext(), e, Toast.LENGTH_LONG).show();
                    return;
                } else
                    a1 = a1 / a2;
            }
            if (ch == 'P') {
                if(a2>a1){
                    Toast.makeText(getApplicationContext(),"Not possible", Toast.LENGTH_LONG).show();
                    return;}

                if(a1==a2)
                    a1=1.0;
                else{
                    Double a = fact(a1);
                    Double x = a1 - a2;
                    Double b = fact(x);
                    a1 = a / b;}
            }
            if (ch == 'C') {
                if(a2>a1){
                    Toast.makeText(getApplicationContext(),"Not possible", Toast.LENGTH_LONG).show();
                    return;}
                if(a1==a2)
                    a1=1.0;
                else{
                    Double a = fact(a1);
                    Double c = fact(a2);
                    Double x = a1 - a2;
                    Double b = fact(x);
                    a1 = a / (b * c);}
            }
            if (ch == '^') {
                a1 = Math.pow(a1, a2);
            }
            a = "" + a1;
            display2.setText(a);
            u = a;
        }
    }
    public String change(String t)
    {
        String v=""+exp1,val="",ti=""+pie;
        int p=0;
        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            if(ch=='e')
            {
                val=val+t.substring(p,i)+v;
                p=i+1;
            }
            if(ch=='??')
            {
                val=val+t.substring(p,i)+ti;
                p=i+1;
            }
        }
        val=val+t.substring(p);
        return val;
    }
    public Double fact(Double a)    {
        if(a==0)
            return 1.0;

        Double i, f=1.0;
        for(i=2.0;i<=a;i++)
            f=f*i;
        return f;
    }

    // ?????????????????????????? ??????????????????????
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonMyCoolStyle),
                MyCoolCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialDark),
                AppThemeDarkCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLight),
                AppThemeLightCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMaterialLightDarkAction),
                AppThemeCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton)rg.getChildAt(getCodeStyle(MyCoolCodeStyle))).setChecked(true);
    }

    // ?????? ?????????????????????????? ???????????? ?????????? ????????????, ?????????????? ???????????????? ?????????? ?????? ??????????????????????????????????
    private void initRadioButton(View button, final int codeStyle){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ???????????????? ??????????????????
                setAppTheme(codeStyle);
                // ???????????????????????? ????????????????, ?????????? ???????? ??????????????????????
                recreate();
            }
        });
    }
}
