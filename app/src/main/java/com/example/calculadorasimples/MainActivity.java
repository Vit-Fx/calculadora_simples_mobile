package com.example.calculadorasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    Button buttonSoma, buttonSub, buttonMult, buttonDiv, buttonDelete;
    EditText editTextValor1, editTextValor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associa componente java ao componente xml
        buttonSoma = findViewById(R.id.button_soma);
        editTextValor1 = findViewById(R.id.edit_valor1);
        editTextValor2 = findViewById(R.id.edit_valor2);
        buttonSub = findViewById(R.id.button_sub);
        buttonDiv = findViewById(R.id.button_div);
        buttonMult = findViewById(R.id.button_mult);
        buttonDelete = findViewById(R.id.button_delete);


        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado("soma");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado("sub");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado("div");
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextValor1.getText().clear();
                editTextValor2.getText().clear();

                editTextValor1.requestFocus();
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostraResultado("mult");
            }
        });
    }

    public void mostraResultado(String op) {
        double result = 0;

        if (editTextValor1.getText().length()>0 && editTextValor2.getText().length()>0) {

            double v1 = Double.parseDouble(editTextValor1.getText().toString());
            double v2 = Double.parseDouble(editTextValor2.getText().toString());

            if (op == "soma")
                result = v1 + v2;
            else if (op == "sub")
                result = v1 - v2;
            else if (op == "div")
                result = v1 / v2;
            else if (op == "mult")
                result = v1 * v2;
           //Toast.makeText(MainActivity.this, "Resultado: " + result, Toast.LENGTH_SHORT).show();
            AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
            msg.setTitle("Resultado");
            msg.setNeutralButton("OK", null);
            msg.setMessage(result+"").show();

        }
        else{
            Toast.makeText(MainActivity.this, "Preencha os valores", Toast.LENGTH_SHORT).show();
        }
    }
}