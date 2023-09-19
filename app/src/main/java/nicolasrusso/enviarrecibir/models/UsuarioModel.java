package nicolasrusso.enviarrecibir.models;

import java.io.Serializable;

public class UsuarioModel implements Serializable {
    String email;
    String password;

    public UsuarioModel() {
    }

    public UsuarioModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
