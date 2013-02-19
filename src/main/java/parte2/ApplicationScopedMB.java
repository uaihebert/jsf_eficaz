package parte2;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean
@ApplicationScoped
public class ApplicationScopedMB implements Serializable {
    private int numeroDeAcessos;

    public int getNumeroDeAcessos() {
        return ++numeroDeAcessos;
    }

    public void setNumeroDeAcessos(int numeroDeAcessos) {
        this.numeroDeAcessos = numeroDeAcessos;
    }
}