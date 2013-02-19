package parte2;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class DependentScopedMB implements Serializable {
	private int numeroDeAcessos;

	public int getNumeroDeAcessos() {
		return ++numeroDeAcessos;
	}

	public void setNumeroDeAcessos(int numeroDeAcessos) {
		this.numeroDeAcessos = numeroDeAcessos;
	}
}