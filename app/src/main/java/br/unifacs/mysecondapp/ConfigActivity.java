package br.unifacs.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class ConfigActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        RadioButton rbMas,rbFem;
        rbMas=(RadioButton) findViewById(R.id.radioButtonMasculino);
        rbFem=(RadioButton) findViewById(R.id.radioButtonFeminino);
        rbMas.setOnCheckedChangeListener(this);
        rbFem.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton.getId()==R.id.radioButtonMasculino &&compoundButton.isChecked())
            Toast.makeText(this,"Você escolheu Masculino",Toast.LENGTH_SHORT).show();
        if (compoundButton.getId()==R.id.radioButtonFeminino && compoundButton.isChecked())
            Toast.makeText(this,"Você escolheu Feminino",Toast.LENGTH_SHORT).show();

    }
}