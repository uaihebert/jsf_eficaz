package parte3;

import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class UsuarioMB implements Serializable {
	private String userCSS = "estilo.css";
	private List<String> cssDisponivel;
	private String tema;
	private String linguaEscolhida = "pt";
	private Locale locale;

    private int tabAtiva;

	@PostConstruct
	private void init() {
		cssDisponivel = new ArrayList<String>();
		cssDisponivel.add("estilo.css");
		cssDisponivel.add("estilo2.css");
	}

	public void alterarTema() {
		System.out.println("alterado para: " + tema);
	}

	public String alterarEstilo() {
		return null;
	}

	public String alterarIdioma() {
		locale = new Locale(linguaEscolhida);
		FacesContext instance = FacesContext.getCurrentInstance();
		instance.getViewRoot().setLocale(locale);
		return null;
	}

	public List<String> getCssDisponivel() {
		return cssDisponivel;
	}

	public void setCssDisponivel(List<String> cssDisponivel) {
		this.cssDisponivel = cssDisponivel;
	}

	public String getUserCSS() {
		return userCSS;
	}

	public void setUserCSS(String userCSS) {
		this.userCSS = userCSS;
	}

	public String getTema() {
		if (tema == null) {
			tema = "bluesky";
		}

		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getLinguaEscolhida() {
		return linguaEscolhida;
	}

	public void setLinguaEscolhida(String linguaEscolhida) {
		this.linguaEscolhida = linguaEscolhida;
	}

	public Locale getLocale() {
		if(locale == null){
			locale = new Locale(linguaEscolhida);
		}
		
		return locale;
	}

    public int getTabAtiva() {
        return tabAtiva;
    }

    public void setTabAtiva(int tabAtiva) {
        this.tabAtiva = tabAtiva;
    }

    public void onTabChange(TabChangeEvent event){
        TabView tabView = (TabView) event.getComponent();
        setTabAtiva(tabView.getActiveIndex());
    }
}