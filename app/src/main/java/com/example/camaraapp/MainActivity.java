package com.example.camaraapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //CONEXIONES CON OBJETOS DE VENTANA:
    public Button btnnewImage;
    public Button btnEliminar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnnewImage = (Button) findViewById(R.id.btnNewImage);


    }

    //MENU PRINCIPAL MODIFICADO::::::::::::::::::::::::::::
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //CODIGO PARA AGREGAR EL NUEVO MENU PERSONALIZADO
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //AQUI VA EN CASO DE UTILIZAR LAS OPCIONES DE LOS BOTONES DE LA BARRA SUPERIOR
            case R.id.icon_delete: {
                Toast.makeText(this, "Este es el boton eliminar", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setMessage("¿Desea eliminar la imagen?")
                        .setCancelable(false) //para clickear a lado de dialog y salir
                        //EN ESTE PARTE PONDREMOS QUE HARA CUANDO LE DEMOS OPCION SI:::::::::::
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        //EN CASO DE QUE LA OPCION SEA NO:::::::::::::::::::::::::::::::::::::
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                // asignando a nuestra alerta un titulo:::::::
                AlertDialog titulo = alerta.create();
                titulo.setTitle("¿ESTA SEGURO DE ELIMINAR?");
                titulo.show();
                break;
            }
            case R.id.icon_add: {
                Toast.makeText(this, "Este es el boton almacenar", Toast.LENGTH_SHORT).show();
                break;
            }

        }
        return true;
    }


}