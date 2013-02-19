package parte5;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class AjaxMB implements Serializable {
    private String estadoSelcionado;
    private String bairroSelcionado;
    private String cidadeSelecionada;

    private List<String> estados;
    private List<String> bairros;
    private List<String> cidades;


    @PostConstruct
    private void init() {
        estados = new ArrayList<String>();
        estados.add("MG");
        estados.add("ES");
        estados.add("RJ");

        cidades = new ArrayList<String>();
        bairros = new ArrayList<String>();
    }

    public void chamadaAjax(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void alterarEstado() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cidades.clear();
        bairros.clear();

        if (estadoSelcionado == null || estadoSelcionado.isEmpty()) {
            return;
        }

        if ("MG".equals(estadoSelcionado)) {
            cidades.add("Caratinga");
            cidades.add("Goverandor Valadares");
            cidades.add("Teófilo Otoni");
        }

        if ("ES".equals(estadoSelcionado)) {
            cidades.add("Itaoca da Pedra");
        }

        if ("RJ".equals(estadoSelcionado)) {
            cidades.add("Rio de Janeiro");
        }
    }

    public void alterarCidade() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bairros.clear();

        if (cidadeSelecionada == null || cidadeSelecionada.isEmpty()) {
            return;
        }

        if ("Caratinga".equals(cidadeSelecionada)) {
            bairros.add("Esplanada");
            bairros.add("Monte Líbano");
            bairros.add("Zacarias");
        }

        if ("Goverandor Valadares".equals(cidadeSelecionada)) {
            bairros.add("Bairro de Lourdes");
            bairros.add("Carapina");
            bairros.add("Vila Bretas");
        }

        if ("Teófilo Otoni".equals(cidadeSelecionada)) {
            bairros.add("Altino Barbosa");
            bairros.add("Morro do Bispo");
            bairros.add("Filadélfia");
        }

        if ("Itaoca da Pedra".equals(cidadeSelecionada)) {
            bairros.add("Centro");
            bairros.add("Alto Moledo");
        }

        if ("Rio de Janeiro".equals(cidadeSelecionada)) {
            bairros.add("Benfica");
            bairros.add("Irajá");
        }
    }

    public String getEstadoSelcionado() {
        return estadoSelcionado;
    }

    public void setEstadoSelcionado(String estadoSelcionado) {
        this.estadoSelcionado = estadoSelcionado;
    }

    public String getBairroSelcionado() {
        return bairroSelcionado;
    }

    public void setBairroSelcionado(String bairroSelcionado) {
        this.bairroSelcionado = bairroSelcionado;
    }

    public String getCidadeSelecionada() {
        return cidadeSelecionada;
    }

    public void setCidadeSelecionada(String cidadeSelecionada) {
        this.cidadeSelecionada = cidadeSelecionada;
    }

    public List<String> getEstados() {
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    public List<String> getBairros() {
        return bairros;
    }

    public void setBairros(List<String> bairros) {
        this.bairros = bairros;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }
}