package converter;

import dao.CidadeDAO;
import managedBean.AbstractManagedBean;
import model.Cidade;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String key) {
        CidadeDAO cidadeDAO = (CidadeDAO) AbstractManagedBean.getManagedBean("cidadeDAO");

        return cidadeDAO.findById(Integer.parseInt(key));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object cidadeObject) {
        if(cidadeObject != null && cidadeObject instanceof Cidade){
            Cidade cidade = (Cidade) cidadeObject;
            return String.valueOf(cidade.getId());
        }

        return "";
    }
}