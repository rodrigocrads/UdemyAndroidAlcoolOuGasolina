package com.cursoandroid.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editPrecoGasolina, editPrecoAlcool;
    Button btnCalcular;
    TextView campoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        btnCalcular = findViewById(R.id.btnCalcular);
        campoResultado = findViewById(R.id.textResultado);
    }

    public void calcularPrecos(View view)
    {
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        // validar campos
        boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if ( camposValidados ) {
            // realizar cálculo
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            String resultado = valorAlcool / valorGasolina >= 0.7 ? "Gasolina" : "Álcool";

            campoResultado.setText("É melhor usar " + resultado);

        } else {
            campoResultado.setText("Informes valores de preço válidos para álcool ou gasolina.");
        }
    }

    private boolean validarCampos(String precoGasolina, String precoAlcool)
    {
        boolean estaoValidos = true;

        if (precoAlcool == null || precoAlcool.equals("") )
            estaoValidos = false;

        if (precoGasolina == null || precoGasolina.equals("") )
            estaoValidos = false;

        return estaoValidos;
    }

}
