package com.example.aluno.persistencia;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private final int SEGUNDA = 1;
    private final String TEXT_VISIBLE = "textVisible";
    private final String TEXT_CONTENT = "textContent";

    private TextView mtextViewHello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextViewHello = (TextView) findViewById(R.id.textViewHello);
        //salvando o texto apos girar a tela
        if(savedInstanceState!=null){
            boolean isVisible = savedInstanceState.getBoolean(TEXT_VISIBLE);
            if(isVisible){
                String msg = savedInstanceState.getString(TEXT_CONTENT);
                mtextViewHello.setVisibility(View.VISIBLE);
                mtextViewHello.setText(msg);
            }

        }

    }

        //fazendo com que a segunda retorne a primeira apos morrer
    public void goNext(View view){

        Intent intent = new Intent(this,SegundaActivity.class);
        //startActivity(intent);
        startActivityForResult(intent,SEGUNDA);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SEGUNDA){

            if(resultCode == RESULT_OK){

                String mensagem = data.getStringExtra(SegundaActivity.RESPOSTA);
                TextView textView = (TextView) findViewById(R.id.textViewHello);
                mtextViewHello.setVisibility(View.VISIBLE);
                mtextViewHello.setText(mensagem);

            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(mtextViewHello.getVisibility()==View.VISIBLE){
            outState.putBoolean(TEXT_VISIBLE,true);
            outState.putString(TEXT_CONTENT,mtextViewHello.getText().toString());
        }

    }
}
