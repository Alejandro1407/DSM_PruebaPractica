package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageView;

import sv.com.udb.dsm.R;

public class ComisionVentas extends AppCompatActivity {

    public static final String EMPTY = "";
    private EditText txtNombre;
    private EditText txtCodigo;
    private EditText txtMes;
    private EditText txtVentas;
    private String uriImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comision_ventas);
        txtNombre = findViewById(R.id.txtName);
        txtCodigo = findViewById(R.id.txtCodigo);
        txtMes = findViewById(R.id.viewMes);
        txtVentas = findViewById(R.id.txtVenta);
    }

    public void processImage(View view){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), 200);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 200) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    uriImage = selectedImageUri.toString();
                }
            }
        }
    }

    public void calcular(View view) {
        String nombre = txtNombre.getText().toString();
        String codigo = txtCodigo.getText().toString();
        String mes = txtMes.getText().toString();
        String ventas = txtVentas.getText().toString();

        String comision = EMPTY;
        String totalComi = EMPTY;

        if ( EMPTY.equals(nombre) || EMPTY.equals(codigo) || EMPTY.equals(mes) || EMPTY.equals(ventas) || EMPTY.equals(ventas)){
            Toast.makeText(this,"El campo nombre, codigo, mes y ventas no deben estar vacios y el campo ventas debe ser mayor a 0", Toast.LENGTH_LONG).show();
            return;
        }
        double ven = Double.parseDouble(ventas);
        if(ven < 0){
            Toast.makeText(this,"Campo ventas debe ser mayor a 0", Toast.LENGTH_LONG).show();
            return;
        }
        double total = 0;

        if (ven < 500){
            comision = "Sin comision";
            totalComi = String.valueOf(total);

        } else if(ven >= 500 && ven < 1000){
            comision = "5%";
            total = ven * 0.05;
            totalComi = String.valueOf(total);

        } else if (ven >= 1000 && ven < 2000){
            comision = "10%";
            total = ven * 0.1;
            totalComi = String.valueOf(total);

        } else if (ven >= 2000 && ven < 3000){
            comision = "15%";
            total = ven * 0.15;
            totalComi = String.valueOf(total);

        } else if (ven >= 3000 && ven < 4000){
            comision = "20%";
            total = ven * 0.2;
            totalComi = String.valueOf(total);

        } else {
            comision = "30%";
            total = ven * 0.3;
            totalComi = String.valueOf(total);

        }

        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("txtNombre", nombre);
        i.putExtra("txtCodigo", codigo);
        i.putExtra("txtMes", mes);
        i.putExtra("txtVentas", ventas);
        i.putExtra("Comision", comision);
        i.putExtra("totComision", totalComi);
        i.putExtra("image",uriImage);
        startActivity(i);
    }


}