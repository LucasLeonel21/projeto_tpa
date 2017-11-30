package app.controllers;

import java.time.LocalDateTime;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.DELETE;
import app.models.Pessoa;

public class PessoasController extends AppController{
	public void index(){
		String smartcard = request.getParameter('smartcart');
		String password = request.getParameter('password');
		
		out.print(smartcard + ' ' + password);
	}
}
