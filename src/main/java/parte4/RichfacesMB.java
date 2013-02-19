package parte4;

import dao.CidadeDAO;
import managedBean.AbstractManagedBean;
import model.Cidade;
import org.richfaces.component.UIPanelMenuItem;
import org.richfaces.event.ItemChangeEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class RichfacesMB implements Serializable {

    private int contadorAjax;
    private int contadorClique;
    private String nomeEnviado;
    private String grupoSelecionado;

    private List<Cidade> cidades;
    private List<Cidade> cidadesParaRepeat;

    public List<Cidade> getCidades() {
        if(cidades == null){
            CidadeDAO cidadeDAO = AbstractManagedBean.getCidadeDAO();
            cidades = cidadeDAO.buscaPorPaginacao(0, 20);
        }
        
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public int getContadorAjax() {
        return ++contadorAjax;
    }

    public void setContadorAjax(int contadorAjax) {
        this.contadorAjax = contadorAjax;
    }

    public int getContadorClique() {
        return contadorClique++;
    }

    public void setContadorClique(int contadorClique) {
        this.contadorClique = contadorClique;
    }

    public String getNomeEnviado() {
        return nomeEnviado;
    }

    public void setNomeEnviado(String nomeEnviado) {
        this.nomeEnviado = nomeEnviado;
    }

    public String getGrupoSelecionado() {
        return grupoSelecionado;
    }

    public void setGrupoSelecionado(String grupoSelecionado) {
        this.grupoSelecionado = grupoSelecionado;
    }

    public void atualizarGrupoSelecionado(ItemChangeEvent event){
        if(event == null || event.getNewItem() == null){
            return;
        }

        UIPanelMenuItem panel = (UIPanelMenuItem) event.getNewItem();
        setGrupoSelecionado(panel.getLabel());
    }

    public List<Cidade> getCidadesParaRepeat() {
        if(cidadesParaRepeat == null){
            CidadeDAO cidadeDAO = AbstractManagedBean.getCidadeDAO();
            cidadesParaRepeat = cidadeDAO.buscaPorPaginacao(0, 100);
        }

        return cidadesParaRepeat;
    }

    public void setCidadesParaRepeat(List<Cidade> cidadesParaRepeat) {
        this.cidadesParaRepeat = cidadesParaRepeat;
    }
}