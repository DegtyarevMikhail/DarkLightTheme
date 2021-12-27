package com.example.darklighttheme;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivity extends BaseActivity {

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

        key0.setOnClickListener(view -> display1.setText("0"));
        key1.setOnClickListener(view -> display1.setText("1"));
        key2.setOnClickListener(view -> display1.setText("2"));
        key3.setOnClickListener(view -> display1.setText("3"));
        key4.setOnClickListener(view -> display1.setText("4"));
        key5.setOnClickListener(view -> display1.setText("5"));
        key6.setOnClickListener(view -> display1.setText("6"));
        key7.setOnClickListener(view -> display1.setText("7"));
        key8.setOnClickListener(view -> display1.setText("8"));
        key9.setOnClickListener(view -> display1.setText("9"));
        keyAdd.setOnClickListener(view -> display2.setText("+"));
        keySubtract.setOnClickListener(view -> display2.setText("-"));
        keyDivide.setOnClickListener(view -> display2.setText("/"));
        keyMultiply.setOnClickListener(view -> display2.setText("*"));
        keyEquals.setOnClickListener(view -> display2.setText("="));
        keyC.setOnClickListener(view -> {
            display1.setText("");
            display2.setText("");

        });


    }

    // Инициализация радиокнопок
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

    // Все инициализации кнопок очень похожи, поэтому создадим метод для переиспользования
    private void initRadioButton(View button, final int codeStyle){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сохраним настройки
                setAppTheme(codeStyle);
                // пересоздадим активити, чтобы тема применилась
                recreate();
            }
        });
    }
}
