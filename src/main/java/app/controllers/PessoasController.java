package app.controllers;

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
				//respond("Destravado: pass").contentType("text/html");
				pessoa.set("trava", false).saveIt();
				redirect("http:/"+"/"+"10.10.113.50/$0");
			}else{
				//respond("Travado: you shall not pass").contentType("text/html");
				pessoa.set("trava", true).saveIt();
				redirect("http:/"+"/"+"10.10.113.50/$1");				
			}
		}else{
			respond(password_check + "/" + password).contentType("text/html");
		};
	}
}
