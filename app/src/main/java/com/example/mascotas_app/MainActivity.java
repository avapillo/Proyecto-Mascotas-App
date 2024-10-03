package com.example.mascotas_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Animación de carga de la Activity
        Animation animacion_1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion_2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        TextView Text_1 = findViewById(R.id.TexT_1);
        TextView Text_2 = findViewById(R.id.TexT_2);
        ImageView Image = findViewById(R.id.Inicio_icono);

        Text_1.setAnimation(animacion_2);
        Text_2.setAnimation(animacion_2);
        Image.setAnimation(animacion_1);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Verificacion_pin.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}
