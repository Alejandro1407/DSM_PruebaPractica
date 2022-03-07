package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import sv.com.udb.dsm.R;

public class ResultActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvMes;
    private TextView tvCodigo;
    private TextView tvVentas;
    private TextView tvPorcentaje;
    private TextView tvComision;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvNombre = findViewById(R.id.viewNombre);
        tvMes = findViewById(R.id.viewMes);
        tvCodigo = findViewById(R.id.viewCodigo);
        tvVentas = findViewById(R.id.viewVentas);
        tvPorcentaje = findViewById(R.id.viewPorcentaje);
        tvComision = findViewById(R.id.viewTotal);
        imageView = findViewById(R.id.imageView2);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("txtNombre");
        String mes = bundle.getString("txtMes");
        String codigo = bundle.getString("txtCodigo");
        String ventas = bundle.getString("txtVentas");
        String comision = bundle.getString("Comision");
        String total = bundle.getString("totComision");
        String imageUri =  bundle.getString("image");

        tvNombre.setText(nombre);
        tvMes.setText(mes);
        tvCodigo.setText(codigo);
        tvVentas.setText(ventas);
        tvPorcentaje.setText(comision);
        tvComision.setText(total);
        if(null != imageUri && !"".equals(imageUri)){
            imageView.setImageURI(Uri.parse(imageUri));
        }

    }

    public void finalizar(View v) {
        finish();
    }
}