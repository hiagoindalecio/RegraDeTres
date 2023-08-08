package com.example.regradetres;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConfigureScreen();
    }

    private void ConfigureScreen() {
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Teste", "Caiu no click");
                btnCalc_OnClick();
            }
        });
    }

    private void btnCalc_OnClick() {
        TextView txtUpLeft = findViewById(R.id.txtUpLeft);
        TextView txtDownLeft = findViewById(R.id.txtDownLeft);
        TextView txtUpRight = findViewById(R.id.txtUpRight);

        if (txtUpLeft.getText().toString().isEmpty() ||
            txtDownLeft.getText().toString().isEmpty() ||
            txtUpRight.getText().toString().isEmpty()) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Attention");
            builder.setMessage("Provide all the values!");
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog alerta = builder.create();
            alerta.show();
        }
        else {
            float result = parseFloat(txtUpRight.getText().toString()) * parseFloat(txtDownLeft.getText().toString());
            result = result / parseFloat(txtUpLeft.getText().toString());

            TextView txtResult = findViewById(R.id.txtResult);
            txtResult.setText(new StringBuilder().append("X value: ").append(result).toString());
        }
    }
}