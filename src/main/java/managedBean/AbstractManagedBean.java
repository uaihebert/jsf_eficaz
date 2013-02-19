package managedBean;

import dao.CidadeDAO;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.Map;
import java.util.ResourceBundle;

public abstract class AbstractManagedBean {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("bundle");

    public static Object getManagedBean(String managedBean){
        FacesContext instance = FacesContext.getCurrentInstance();
        ExternalContext context = instance.getExternalContext();
        Map<String, Object> applicationMap = context.getApplicationMap();
        return applicationMap.get(managedBean);
    }

    private static String getChave(String chaveDaMensagem, Object... parametros){
        if(parametros!= null){
            return MessageFormat.format(resourceBundle.getString(chaveDaMensagem), parametros);
        }

        return resourceBundle.getString(chaveDaMensagem);
    }

    public static CidadeDAO getCidadeDAO() {
        return (CidadeDAO) getManagedBean("cidadeDAO");
    }

    public static void enviarMensagenDeInformacaoAoUsuario(String chaveDaMensagem, Object... parametros){
        adicionarMensagem(chaveDaMensagem, FacesMessage.SEVERITY_INFO, parametros);
    }

    public static void enviarMensagenDeErroAoUsuario(String chaveDaMensagem){
        adicionarMensagem(chaveDaMensagem, FacesMessage.SEVERITY_ERROR);
    }

    private static void adicionarMensagem(String chaveDaMensagem, Severity severityError, Object... parametros){
        FacesContext instance = FacesContext.getCurrentInstance();
        instance.addMessage(null, new FacesMessage(severityError, getChave(chaveDaMensagem, parametros), getChave(chaveDaMensagem)));
    }
}