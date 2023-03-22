package com.example.traductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private EditText etPalabraSpanish;
    private Button btnTraducir;
    private TextView tvResultado;
    private HashMap palabras = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        etPalabraSpanish = findViewById(R.id.etPalabraSpanish);
        btnTraducir = findViewById(R.id.btnTraducir);
        tvResultado = findViewById(R.id.tvResultado);
        viewModel.getResultado().observe(this, resultado -> tvResultado.setText(resultado));

        this.btnTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.traducir(etPalabraSpanish.getText().toString());
            }
        });
    }
}