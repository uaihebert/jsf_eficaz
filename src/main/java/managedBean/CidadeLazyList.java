package managedBean;

import dao.CidadeDAO;
import model.Cidade;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

public class CidadeLazyList extends LazyDataModel<Cidade> {

    private List<Cidade> cidades;


    @Override
    public List<Cidade> load(int posicaoPrimeiraLinha,
                             int maximoPorPagina,
                             String ordernarPeloCampo,
                             SortOrder ordernarAscOuDesc,
                             Map<String, String> filtros) {

        String ordernacao = ordernarAscOuDesc.toString();

        if(SortOrder.UNSORTED.equals(ordernarAscOuDesc)){
            ordernacao = SortOrder.ASCENDING.toString();
        }


        cidades = getDAO().buscaPorPaginacao(posicaoPrimeiraLinha,
                                             maximoPorPagina,
                                             ordernarPeloCampo,
                                             ordernacao, filtros);

        // total encontrado no banco de dados, caso o filtro esteja preenchido dispara a consulta novamente
        if (getRowCount() <= 0 || (filtros != null && !filtros.isEmpty())) {
            setRowCount(getDAO().countAll(filtros));
        }

        // quantidade a ser exibida em cada página
        setPageSize(maximoPorPagina);

        return cidades;
    }

    private CidadeDAO getDAO() {
        return AbstractManagedBean.getCidadeDAO();
    }

    @Override
    public Cidade getRowData(String rowKey) {
        for (Cidade cidade : cidades) {
            if (rowKey.equals(String.valueOf(cidade.getId())))
                return cidade;
        }

        return null;
    }

    @Override
    public Object getRowKey(Cidade cidade) {
        return cidade.getId();
    }

    @Override
    public void setRowIndex(int rowIndex) {
        // solução para evitar ArithmeticException
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        }
        else
            super.setRowIndex(rowIndex % getPageSize());
    }
}