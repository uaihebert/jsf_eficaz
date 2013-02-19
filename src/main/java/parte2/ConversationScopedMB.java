package parte2;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class ConversationScopedMB implements Serializable {

	@Inject
	private Conversation conversation;
	
	private int numeroDeAcessos;

	public String iniciar(){
		conversation.begin();
		return null;
	}
	
	public boolean isTransient(){
		return conversation.isTransient();
	}
	
	public String somar(){
		if(!conversation.isTransient()){
			numeroDeAcessos++;
		}
		
		return null;
	}
	
	public String finalizar(){
		conversation.end();
		return "/paginas/parte2/conversationScoped.xhtml?faces-redirect=true";
	}
	
	public String navegar(){
		if(conversation.isTransient()){
			return null;
		}
		
		return "/paginas/parte2/conversationScoped2.xhtml?faces-redirect=true";
	}
	
	public int getNumeroDeAcessos() {
		return ++numeroDeAcessos;
	}

	public void setNumeroDeAcessos(int numeroDeAcessos) {
		this.numeroDeAcessos = numeroDeAcessos;
	}
}