package parte2;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ViewScopedMB implements Serializable {
	private int numeroDeAcessos;

	public String somar() {
		numeroDeAcessos++;

		return null;
	}

	public int getNumeroDeAcessos() {
		return ++numeroDeAcessos;
	}

	public void setNumeroDeAcessos(int numeroDeAcessos) {
		this.numeroDeAcessos = numeroDeAcessos;
	}
}