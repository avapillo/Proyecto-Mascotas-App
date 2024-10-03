package com.example.mascotas_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registro_Paciente extends AppCompatActivity {

    EditText NombreEdit, ApellidoEdit, TelefonoEdit;
    Button Guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_paciente);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NombreEdit = findViewById(R.id.editText_pro_1);
        ApellidoEdit = findViewById(R.id.editText_pro_2);
        TelefonoEdit = findViewById(R.id.editText_pro_3);
        Guardar = findViewById(R.id.bot_register_2);

    }

    // Método que se llama al presionar el botón "Guardar"
    public void GuardarDatos(View view) {
        String nombre = NombreEdit.getText().toString().trim();
        String apellido = ApellidoEdit.getText().toString().trim();
        String telefono = TelefonoEdit.getText().toString().trim();

        // Validación de campos vacíos
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty()) {
            Toast.makeText(Registro_Paciente.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        } else {
            // Guardado de los datos (futuro: guardar en la base de datos)
            Toast.makeText(Registro_Paciente.this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
            limpiarCampos(); // Limpiar campos
        }
    }

    // Método para limpiar los EditText
    private void limpiarCampos() {
        NombreEdit.setText("");
        ApellidoEdit.setText("");
        TelefonoEdit.setText("");
    }

    public void Atras(View view){
        Intent atras = new Intent(this, com.example.mascotas_app.Mostrar_Registro.class);
        startActivity(atras);
    }
}
