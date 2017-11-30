package app.controllers;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.DELETE;
import app.models.Pessoa;

public class PessoaController extends AppController{
	public void index(){
		view("pessoas", Pessoa.findAll());
	}

	public void show(){}

	@POST
	public void create(){
		Pessoa pessoa = new Person();
		if(!pessoa.save()){
			flash("message", "Algo deu errado");
			flash("errors", pessoa.errors());
			redirect(PessoaController.class, "new_form");
		}else{
			flash("message", "Nova pessoa adicionada: " + pessoa.get("name"));
			redirect(PessoaController.class);
		}
	}

	@DELETE
	public void delete(){
		Person p = (Person)Person.findById(getId());
		String name = p.getString("name");
		p.delete();
		flash("message", "Pessoa '" + name + "' foi deletada");
		redirect(PersonController.class);
	}

	public void newForm(){}
}
