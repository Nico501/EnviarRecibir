package nicolasrusso.enviarrecibir;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nicolasrusso.enviarrecibir.models.DireccionModel;
import nicolasrusso.enviarrecibir.models.UsuarioModel;

public class MainActivity extends AppCompatActivity {
    private final int DIRECCIONES = 1;
    EditText txtEmailMain;
    EditText txtPasswordMain;
    Button btnDesencriptarMain;
    Button btnCrearDireccionMain;
    UsuarioModel usuario;
    DireccionModel direccion;
    String email;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVistas();

        btnDesencriptarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = txtEmailMain.getText().toString();
                password = txtPasswordMain.getText().toString();
                usuario = new UsuarioModel(email, password);
                Intent intent = new Intent(MainActivity.this, DesencriptarActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("USER", usuario);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnCrearDireccionMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearDireccionActivity.class);
                startActivityForResult(intent, DIRECCIONES);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == DIRECCIONES){
            if(resultCode == RESULT_OK){
                if(data != null) {
                    Bundle bundle = data.getExtras();
                    if (bundle != null){
                        direccion = (DireccionModel) bundle.getSerializable("DIR");
                        Toast.makeText( this, direccion.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    private void inicializarVistas() {
        txtPasswordMain = findViewById(R.id.txtPasswordMain);
        txtEmailMain = findViewById(R.id.txtEmailMain);
        btnDesencriptarMain = findViewById(R.id.btnDesencriptarMain);
        btnCrearDireccionMain = findViewById(R.id.btnCrearDireccionMain);
    }
}