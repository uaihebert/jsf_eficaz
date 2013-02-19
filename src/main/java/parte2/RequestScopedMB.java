package parte2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RequestScopedMB {
	private int numeroDeAcessos;

	public int getNumeroDeAcessos() {
		return ++numeroDeAcessos;
	}

	public void setNumeroDeAcessos(int numeroDeAcessos) {
		this.numeroDeAcessos = numeroDeAcessos;
	}
}