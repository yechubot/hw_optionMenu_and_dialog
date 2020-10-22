package com.example.pet_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_seeAnimals;
    RadioButton btn_dog, btn_cat, btn_rabbit;
    View dialogView;
    TextView dial_petName, dial_petContents;
    ImageView dial_petImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_seeAnimals = findViewById(R.id.btn_seeAnimals);
        btn_cat = findViewById(R.id.btn_cat);
        btn_dog = findViewById(R.id.btn_dog);
        btn_rabbit = findViewById(R.id.btn_rabbit);

        btn_seeAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = View.inflate(MainActivity.this, R.layout.pet_dialog, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                dial_petName = dialogView.findViewById(R.id.dial_petName);
                dial_petContents = dialogView.findViewById(R.id.dial_petContents);
                dial_petImg = dialogView.findViewById(R.id.dial_petImg);

                if (btn_dog.isChecked()) {
                    dial_petImg.setImageResource(R.drawable.dog);
                    dial_petContents.setText("강아지 설명 쭉 나와 ");
                    builder.setTitle("강아지 설명");
                } else if (btn_cat.isChecked()) {
                    dial_petImg.setImageResource(R.drawable.cat);
                    dial_petContents.setText("고양이 설명 쭉 나와 ");
                    builder.setTitle("고양이 설명");
                } else {
                    dial_petImg.setImageResource(R.drawable.rabbit);
                    dial_petContents.setText("토끼 설명 쭉 나와 ");
                    builder.setTitle("토끼 설명");
                }

                builder.setPositiveButton("닫기", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
