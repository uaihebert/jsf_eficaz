package parte3;

import model.Cidade;
import org.primefaces.component.datatable.DataTable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
@ViewScoped
public class CidadeMB implements Serializable {
    private static List<Cidade> cidades;
    private Cidade cidade;
    private DataTable dataTable;

    @PostConstruct
    private void init(){
        if (cidades == null){
            cidades = new ArrayList<Cidade>();
            cidades.add(new Cidade(1, "Goverandor Valadares", "MG"));
            cidades.add(new Cidade(2, "Itaoca da Pedra", "ES"));
            cidades.add(new Cidade(3, "Rio de Janeiro", "RJ"));
        }
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> lista) {
        cidades = lista;
    }

    public Cidade getCidade() {
        if(cidade == null){
            cidade = new Cidade();
        }

        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void atualizarCidade(Cidade cidade){
        this.cidade = cidade;
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public void selecionarCidade(){
        Integer rowIndex = dataTable.getRowIndex() + 1;
        this.cidade = (Cidade) dataTable.getRowData(rowIndex.toString());
    }
}