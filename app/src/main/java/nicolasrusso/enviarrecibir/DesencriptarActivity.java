package nicolasrusso.enviarrecibir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import nicolasrusso.enviarrecibir.models.UsuarioModel;

public class DesencriptarActivity extends AppCompatActivity {
    TextView lblEmailDesencriptar;
    TextView lblPassDesencriptar;
    UsuarioModel usuario;
    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desencriptar);

        inicializarVistas();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            usuario = (UsuarioModel) bundle.getSerializable("USER");

            if(usuario != null) {
                email = usuario.getEmail();
                password = usuario.getPassword();
                lblEmailDesencriptar.setText(email);
                lblPassDesencriptar.setText(email);

                // lblEmailDesencriptar.setText(usuario.getEmail());
                // lblPassDesencriptar.setText(usuario.getPassword());
            }
        }
    }

    private void inicializarVistas() {
        lblEmailDesencriptar = findViewById(R.id.lblEmailDesencriptar);
        lblPassDesencriptar = findViewById(R.id.lblPassDesencriptar);
    }
}