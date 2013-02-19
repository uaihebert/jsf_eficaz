package parte4;

import dao.CidadeDAO;
import managedBean.AbstractManagedBean;
import managedBean.CidadeLazyList;
import model.Cidade;
import org.primefaces.model.LazyDataModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CidadesPaginadasMB implements Serializable {
    private List<Cidade> cidades;

    private LazyDataModel<Cidade> cidadesLazy;

    public List<Cidade> getCidades() {
        if(cidades == null){
            CidadeDAO cidadeDAO = AbstractManagedBean.getCidadeDAO();
            cidades = cidadeDAO.listAll();
        }

        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public LazyDataModel<Cidade> getCidadesLazy() {
        if(cidadesLazy == null){
            cidadesLazy = new CidadeLazyList();
        }

        return cidadesLazy;
    }

    public void setCidadesLazy(LazyDataModel<Cidade> cidadesLazy) {
        this.cidadesLazy = cidadesLazy;
    }
}