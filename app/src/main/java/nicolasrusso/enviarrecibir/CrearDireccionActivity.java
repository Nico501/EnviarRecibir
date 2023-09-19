package nicolasrusso.enviarrecibir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import nicolasrusso.enviarrecibir.models.DireccionModel;

public class CrearDireccionActivity extends AppCompatActivity {
    EditText txtCalleCrear;
    EditText txtNumeroCrear;
    EditText txtCiudadCrear;
    Button btnCrearCrear;
    String calle;
    String ciudad;
    int numero;
    DireccionModel direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_direccion);

        inicializarVistas();

        btnCrearCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calle = txtCalleCrear.getText().toString();
                numero = Integer.parseInt(txtNumeroCrear.getText().toString());
                ciudad = txtCiudadCrear.getText().toString();
                direccion = new DireccionModel(calle, numero, ciudad);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("DIR", direccion);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void inicializarVistas() {
        txtCalleCrear = findViewById(R.id.txtCalleCrear);
        txtCiudadCrear = findViewById(R.id.txtCiudadCrear);
        txtNumeroCrear = findViewById(R.id.txtNumeroCrear);
        btnCrearCrear = findViewById(R.id.btnCrearCrear);
    }
}