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
    }

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
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        if(mtextViewHello.getVisibility()==View.VISIBLE){
            outState.putBoolean(TEXT_VISIBLE,true);
            outState.putString(TEXT_CONTENT,mtextViewHello.getText().toString());
        }

    }


}
