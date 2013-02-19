package parte2;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SessionScopedMB implements Serializable {
	private int numeroDeAcessos;

	public int getNumeroDeAcessos() {
		return ++numeroDeAcessos;
	}

	public void setNumeroDeAcessos(int numeroDeAcessos) {
		this.numeroDeAcessos = numeroDeAcessos;
	}
}