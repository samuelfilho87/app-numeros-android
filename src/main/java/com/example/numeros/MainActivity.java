package com.example.numeros;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText) findViewById(R.id.editTextNumber);
        final Button button = findViewById(R.id.button_ok);

        final TextView textoDigitadoView = (TextView)findViewById(R.id.numDigitado);
        final TextView textoEhPrimoView = (TextView)findViewById(R.id.ehPrimo);
        final TextView textoBinarioView = (TextView)findViewById(R.id.binario);
        final TextView textoHexadecimalView = (TextView)findViewById(R.id.hexadecimal);
        final TextView textoCorView = (TextView)findViewById(R.id.cor);

        final LinearLayout boxColorTopo = (LinearLayout)findViewById(R.id.boxCorTopo);
        final LinearLayout boxColorBottom = (LinearLayout)findViewById(R.id.boxCorBottom);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textoDigitado =  input.getText().toString();

                if(textoDigitado.length() > 0) {
                    input.setText("");
                    textoDigitadoView.setText("Número informado: " + textoDigitado);

                    Numero num = new Numero(Integer.parseInt((textoDigitado)));

                    if(num.ehPrimo()) {
                        textoEhPrimoView.setText("É um número primo: sim");
                    } else {
                        textoEhPrimoView.setText("É um número primo: não");
                    }

                    textoBinarioView.setText("Binário: " + num.binario());
                    textoHexadecimalView.setText("Hexadecimal: " + num.hexadecimal());

                    String cor = num.corHexadecimal(num.hexadecimal());

                    textoCorView.setText("Cor: " + cor);
                    boxColorTopo.setBackgroundColor(Color.parseColor(cor));
                    boxColorBottom.setBackgroundColor(Color.parseColor(cor));
                }
            }
        });
    }
}