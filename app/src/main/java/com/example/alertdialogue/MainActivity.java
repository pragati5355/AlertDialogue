package com.example.alertdialogue;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button Button1,Button2;
    RecyclerView recyclerView;
    List<ModelClass> ModelList;
    ModelClass ModelClass;
    AdapterClass adapterClass;

    AlertDialog.Builder builder;
    AlertDialog.Builder Custombuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button1 = findViewById(R.id.Button1);
        Button2 = findViewById(R.id.Button2);
        recyclerView = findViewById(R.id.RecycleView);

        ModelList = new ArrayList<>();
        adapterClass = new AdapterClass(this,ModelList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterClass);

        builder = new AlertDialog.Builder(this);
        Custombuilder = new AlertDialog.Builder(this);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Button is Clicked",Toast.LENGTH_LONG).show();

                builder.setTitle("Action")
                        .setCancelable(false)
                        .setMessage("Are you sure you want to exit?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(MainActivity.this,"User Clicked on Yes Button",Toast.LENGTH_LONG).show();
                                finish();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(MainActivity.this,"User Clicked on No Button",Toast.LENGTH_LONG).show();
                                dialog.cancel();

                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Form Button is Clicked",Toast.LENGTH_LONG).show();

                Custombuilder.setTitle("User Form");
                final View customview= getLayoutInflater().inflate(R.layout.custom_alert,null);

                Custombuilder.setView(customview);
                Button btnSave= customview.findViewById(R.id.btnSave);
                EditText edtName= customview.findViewById(R.id.EdtName);
                EditText edtMob = customview.findViewById(R.id.EdtMobno);
                EditText edtMail = customview.findViewById(R.id.EdtMail);
                EditText edtweb = customview.findViewById(R.id.EdtWebsite);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       ModelClass = new ModelClass();
                       ModelClass.setName(edtName.getText().toString().trim());
                       ModelClass.setMobile(edtMob.getText().toString().trim());
                       ModelClass.setMail(edtMail.getText().toString().trim());
                       ModelClass.setWebsite(edtweb.getText().toString().trim());
                       adapterClass.notifyDataSetChanged();
                       ModelList.add(ModelClass);
                    }
                });

                AlertDialog alertDialog = Custombuilder.create();
                alertDialog.show();

            }
        });

    }
}