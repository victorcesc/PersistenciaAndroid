package com.example.aluno.persistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SegundaActivity extends AppCompatActivity {

    public static final String RESPOSTA = "resposta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
    }
    public void enviarTexto(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        String texto = editText.getText().toString();

        Intent intent = new Intent();

        intent.putExtra(RESPOSTA,texto);

        setResult(RESULT_OK,intent);

        finish();


    }
}
