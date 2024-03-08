package com.salinas.empleado;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import android.os.Bundle;

import com.salinas.empleado.model.Empleado;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre, edtCuotaPorHora;
    private Spinner spnTipoEmpleado, spnHorasTrabajadas;
    private Button btnCalcularSueldo;
    private Button buttonSalir;

    private String[] tiposEmpleado = {"Tipo 1", "Tipo 2", "Tipo 3", "Tipo 4"};
    private String[] horasTrabajadas = {"Menos de 40 horas", "Más de 40 horas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = findViewById(R.id.edtNombre);
        edtCuotaPorHora = findViewById(R.id.edtCuotaPorHora);
        spnTipoEmpleado = findViewById(R.id.spnTipoEmpleado);
        spnHorasTrabajadas = findViewById(R.id.spnHorasTrabajadas);
        btnCalcularSueldo = findViewById(R.id.btnCalcularSueldo);

        ArrayAdapter<String> tipoEmpleadoAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, tiposEmpleado);
        tipoEmpleadoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTipoEmpleado.setAdapter(tipoEmpleadoAdapter);

        ArrayAdapter<String> horasTrabajadasAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, horasTrabajadas);
        horasTrabajadasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnHorasTrabajadas.setAdapter(horasTrabajadasAdapter);

        btnCalcularSueldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre                .getText().toString();
                int tipoEmpleado = spnTipoEmpleado.getSelectedItemPosition() + 1;
                int horasTrabajadas;
                if (spnHorasTrabajadas.getSelectedItemPosition() == 0) {
                    horasTrabajadas = 40;
                } else {
                    horasTrabajadas = 50;
                }
                double cuotaPorHora = Double.parseDouble(edtCuotaPorHora.getText().toString());

                Empleado empleado = new Empleado(nombre, tipoEmpleado, horasTrabajadas, cuotaPorHora);

                double sueldo = empleado.calcularSueldo();

                Toast.makeText(MainActivity.this, "El sueldo a pagar es: $" + sueldo, Toast.LENGTH_SHORT).show();
            }
        });
        Button btnNuevo = findViewById(R.id.buttonNuevo);
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Borrar el contenido de los EditText
                EditText edtCuotaPorHora = findViewById(R.id.edtCuotaPorHora);
                EditText edtNombre = findViewById(R.id.edtNombre);
                edtCuotaPorHora.setText("");
                edtNombre.setText("");
            }
        });
        Button btnSalir = findViewById(R.id.buttonSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}

