package sv.com.edu.udb.dsm.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import sv.com.udb.dsm.R;

public class LoginActivity extends AppCompatActivity {

    private final EditText txtA;

    private final EditText txtB;

    public LoginActivity() {
        super();
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}