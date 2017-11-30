package app.controllers;

import java.time.LocalDateTime;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.DELETE;
import app.models.Pessoa;

public class PessoasController extends AppController{
	public void index(){
		view("pessoas", Pessoa.findAll());
	}

	public void show(){}

	@POST
	public void create(){
		Pessoa pessoa = new Pessoa();

		if(!pessoa.save()){
			flash("message", "Algo deu errado");
			flash("errors", pessoa.errors());
			redirect(PessoasController.class, "new_form");
		}else{
			flash("message", "Nova pessoa adicionada: " + pessoa.get("name"));
			redirect(PessoasController.class);
		}
	}

	@DELETE
	public void delete(){
		Pessoa p = (Pessoa)Pessoa.findById(getId());
		String name = p.getString("name");
		p.delete();
		flash("message", "Pessoa '" + name + "' foi deletada");
		redirect(PessoasController.class);
	}

	public void newForm(){}
}
