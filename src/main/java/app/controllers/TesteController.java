package app.controllers;

import org.javalite.activeweb.AppController;

public class TesteController extends AppController{
	public void index(){
		respond("Deu Certo").contentType("text/html");
	}
} 
