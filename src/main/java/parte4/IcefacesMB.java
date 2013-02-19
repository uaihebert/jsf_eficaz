package parte4;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class IcefacesMB implements Serializable {

    private Date data;

    private String richText;
    private String resultadoDialog;
    private final String MENSGEM_PADRAO = "selecione um item";

    private List<String> menuList;

    private Format formatter;

    private final int TAMANHO_MAXIMO_ITENS_LOG = 17;

    @PostConstruct
    private void init(){
        formatter = new SimpleDateFormat("HH:mm:ss");
        menuList = new ArrayList<String>(TAMANHO_MAXIMO_ITENS_LOG);
        menuList.add(MENSGEM_PADRAO);
    }

    public void dialogSim(ActionEvent event) {
        setResultadoDialog("O sim foi escolhido");
    }

    public void dialogNao(ActionEvent event) {
        setResultadoDialog("O não foi escolhido");
    }

    public String getResultadoDialog() {
        return resultadoDialog;
    }

    public void setResultadoDialog(String resultadoDialog) {
        this.resultadoDialog = resultadoDialog;
    }

    public List<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }

    public void fireAction(ActionEvent event) {
        String [] results = event.getComponent().getParent().getClientId().split(":");
        String message = results[results.length - 1].toUpperCase() + " > ";
        results = event.getComponent().getClientId().split(":");
        message += results[results.length-1].toUpperCase();
        message += " - selecionado @ "+formatter.format(new Date()) + " (horario do servidor)";

        if(menuList.get(0).equals(MENSGEM_PADRAO)) {
            menuList.clear();
        }
        if (menuList.size()< TAMANHO_MAXIMO_ITENS_LOG) {
            menuList.add(message);
        }
        else {
            menuList.clear();
            menuList.add(message);
        }
    }

    public String getRichText() {
        return richText;
    }

    public void setRichText(String richText) {
        this.richText = richText;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}