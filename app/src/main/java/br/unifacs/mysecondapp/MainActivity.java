package br.unifacs.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int numberOfRuns;
    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor sharedPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botao1 =(Button) findViewById(R.id.button_1);
        Button botaosobre= (Button) findViewById(R.id.button_sobre);
        Button botaosair = (Button) findViewById(R.id.button_sair);
        botao1.setOnClickListener(this);
        botaosobre.setOnClickListener(this);
        botaosair.setOnClickListener(this);
        sharedPrefs=getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        numberOfRuns=sharedPrefs.getInt("NumeroRodada", 0);
        numberOfRuns++;
        String mens="Esta é a "+numberOfRuns+"a. vez que esta aplicação roda";
        Toast.makeText(this,mens,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        // Identifique quem é v e defina uma ação
        switch (view.getId()) {
            case R.id.button_1:
                Intent i=new Intent(this,ConfigActivity.class);
                startActivity(i);
                break;
            case R.id.button_sobre:
                // ação associado ao click do botão sobre
                Intent j=new Intent(this,SobreActivity.class);
                startActivity(j);
                break;
            case R.id.button_sair:
                finish();  // finaliza a atividade
                break;
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        sharedPrefsEditor=sharedPrefs.edit();
        if (sharedPrefsEditor!=null) {
            sharedPrefsEditor.putInt("NumeroRodada", numberOfRuns);
            sharedPrefsEditor.commit();
        }
    }

}