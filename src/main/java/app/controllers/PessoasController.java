package app.controllers;

import java.util.List;
import java.time.LocalDateTime;
import org.javalite.http.Http;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.DELETE;
import app.models.Pessoa;

public class PessoasController extends AppController{

	@POST
	public void index(){
		String smartcard = param("smartcard");
		String password = param("password");
		
		Pessoa pessoa = Pessoa.findFirst("smartcard = ?", smartcard);
		boolean travado = (boolean)pessoa.get("trava");
		String password_check = (String)pessoa.get("password");
		if (password_check.equals(password)){
			if(travado){
				/*Http.get("http://10.10.117.147$1");*/
				pessoa.set("trava", false).saveIt();	
				respond("Destravado:  pass").contentType("text/html");
			}else{
				pessoa.set("trava", true).saveIt();
				respond("Travado: you shall not pass").contentType("text/html");		
				
			}
		}else{
			respond(password_check + "/" + password).contentType("text/html");
		};
	}
}
