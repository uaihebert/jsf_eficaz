package parte2;

import managedBean.AbstractManagedBean;
import model.Cidade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class SendRedirectMB {
    private Cidade cidade;

    public String redirecionarSemFlash() {
        AbstractManagedBean.enviarMensagenDeInformacaoAoUsuario("sendRedirectCidadeCadastrada", cidade.getNome());

        return "/paginas/parte2/sendRedirect/fimSemFlash.xhtml?faces-redirect=true";
    }

    public String redirecionarComFlash() {
        AbstractManagedBean.enviarMensagenDeInformacaoAoUsuario("sendRedirectCidadeCadastrada", cidade.getNome());

        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("cidade", cidade);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        return "/paginas/parte2/sendRedirect/fimComFlash.xhtml?faces-redirect=true";
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
}