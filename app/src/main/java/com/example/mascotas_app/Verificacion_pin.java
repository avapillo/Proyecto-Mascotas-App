package com.example.mascotas_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Verificacion_pin extends AppCompatActivity {

    private final String PIN_CORRECTO = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verificacion_pin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button loginButton = findViewById(R.id.btnPin);
        EditText pinEditText = findViewById(R.id.editTextPin);

        // Botón para verificar el PIN
        loginButton.setOnClickListener(v -> {
            String pinIngresado = pinEditText.getText().toString().trim();

            // Verificar que el PIN no esté vacío
            if (pinIngresado.isEmpty()) {
                Toast.makeText(Verificacion_pin.this, "Por favor, ingresa un PIN", Toast.LENGTH_SHORT).show();
                return;
            }

            // Verificación del PIN
            if (pinIngresado.equals(PIN_CORRECTO)) {
                // Si el PIN es correcto, redirigir al menú principal
                Intent intent = new Intent(Verificacion_pin.this, Menu_Inicio.class); // Cambia a tu Activity de menú
                startActivity(intent);
                finish(); // Cierra la pantalla actual
            } else {
                // Si el PIN es incorrecto, mostrar mensaje de error
                Toast.makeText(Verificacion_pin.this, "PIN incorrecto", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
