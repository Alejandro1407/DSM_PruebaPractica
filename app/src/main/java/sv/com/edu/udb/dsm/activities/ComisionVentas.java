package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import sv.com.udb.dsm.R;

public class ComisionVentas extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtCodigo;
    private EditText txtMes;
    private EditText txtVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comision_ventas);
        txtNombre = findViewById(R.id.txtName);
        txtCodigo = findViewById(R.id.txtCodigo);
        txtMes = findViewById(R.id.viewMes);
        txtVentas = findViewById(R.id.txtVenta);
    }


    public void calcular(View view) {
        String nombre = txtNombre.getText().toString();
        String codigo = txtCodigo.getText().toString();
        String mes = txtMes.getText().toString();
        String ventas = txtVentas.getText().toString();

        String comision = "";
        String totalComi = "";

        double ven = Double.parseDouble(ventas);
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
        startActivity(i);
    }


}