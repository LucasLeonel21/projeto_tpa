package app.controllers;

import org.javalite.http.Http;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.DELETE;
import app.models.Pessoa;

public class PessoasController extends AppController{

	@POST
	public void index(){
		String smartcard = param("smartcard");
		String password = param("password");
		
		Pessoa pessoa = Pessoa.findFirst("smartcard = ?", smartcard);
		boolean travado = Boolean.parseBoolean(pessoa.get("trava").toString());
		System.out.println(travado);
		String password_check = (String)pessoa.get("password");
		if (password_check.equals(password)){
			if(travado){
				Http.get("http:/"+"/"+"10.10.113.50/$0");
				/*redirect("http:/"+"/"+"10.10.113.45:8080/teste");
				redirect("https:/"+"/"+"google.com");*/
				pessoa.set("trava", false).saveIt();
				respond("Destravado: pass").contentType("text/html");
			}else{
				Http.get("http:/"+"/"+"10.10.113.50/$1");
				/*redirect("http:/"+"/"+"10.10.113.45:8080/teste");
				Get get = Http.get("http:/"+"/"+"10.10.113.175/?$0");*/
				pessoa.set("trava", true).saveIt();
				respond("Travado: you shall not pass").contentType("text/html");
				
			}
		}else{
			respond(password_check + "/" + password).contentType("text/html");
		};
	}
}
