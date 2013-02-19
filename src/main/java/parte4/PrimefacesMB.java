package parte4;

import dao.CidadeDAO;
import managedBean.AbstractManagedBean;
import managedBean.CidadeLazyList;
import model.Cidade;
import model.Foto;
import org.primefaces.event.DragDropEvent;
import org.primefaces.model.LazyDataModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class PrimefacesMB implements Serializable {

    private int contador;
    private Cidade cidade;
    private List<Foto> fotos;
    private List<Foto> fotosSelecionadas;
    private LazyDataModel<Cidade> cidadesLazy;
    private CidadeDAO cidadeDAO = AbstractManagedBean.getCidadeDAO();


    public LazyDataModel<Cidade> getCidadesLazy() {
        if (cidadesLazy == null) {
            cidadesLazy = new CidadeLazyList();
        }

        return cidadesLazy;
    }

    public void setCidadesLazy(LazyDataModel<Cidade> cidadesLazy) {
        this.cidadesLazy = cidadesLazy;
    }

    public Cidade getCidade() {
        if (cidade == null) {
            cidade = new Cidade();
        }

        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void mensagemSucesso(ActionEvent event) {
        AbstractManagedBean.enviarMensagenDeInformacaoAoUsuario("sucesso");
    }

    public void mensagemErro(ActionEvent event) {
        AbstractManagedBean.enviarMensagenDeErroAoUsuario("erro");
    }

    public List<Cidade> autoComplete(String valorPesquisado) {
        final int maximoResultadosExibidos = 5;

        if (valorPesquisado == null || valorPesquisado.isEmpty()) {
            int comecarPesquisaPosicao = 1;
            return cidadeDAO.buscaPorPaginacao(comecarPesquisaPosicao, maximoResultadosExibidos);
        }

        return cidadeDAO.findByNameLike(valorPesquisado, maximoResultadosExibidos);
    }

    public List<Foto> getFotos() {
        if (fotos == null) {
            fotos = new ArrayList<Foto>();
            fotos.add(new Foto("Aniversariante", "/resources/imagens/minhoca_03.jpg"));
            fotos.add(new Foto("Anos 60", "/resources/imagens/minhoca_02.jpg"));
            fotos.add(new Foto("Roqueira", "/resources/imagens/minhoca_01.jpg"));
        }

        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public List<Foto> getFotosSelecionadas() {
        if (fotosSelecionadas == null) {
            fotosSelecionadas = new ArrayList<Foto>();
        }

        return fotosSelecionadas;
    }

    public void setFotosSelecionadas(List<Foto> fotosSelecionadas) {
        this.fotosSelecionadas = fotosSelecionadas;
    }

    public void fotoDespejada(DragDropEvent event) {
        Foto foto = (Foto) event.getData();

        getFotos().remove(foto);
        getFotosSelecionadas().add(foto);
    }

    public void somar(){
        contador++;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}