package parte4;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@ManagedBean
public class TemasDisponiveis {
    private List<String> temas;

    public List<String> getTemas() {
        if(temas == null){
            temas = new ArrayList<String>();
            temas.add("casablanca");
            temas.add("cupertino");
            temas.add("dark-hive");
            temas.add("bluesky");
            temas.add("blitzer");
        }

        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }
}
