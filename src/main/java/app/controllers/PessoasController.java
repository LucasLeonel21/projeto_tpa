package app.controllers;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.DELETE;
import app.models.Pessoa;

public class PessoasController extends AppController{
	public void index(HttpServletRequest request) throws ServletException, IOException {
		String smartcard = request.getParameter("smartcart");
		String password = request.getParameter("password");
		
		System.out.print(smartcard + " " + password);
	}
}
