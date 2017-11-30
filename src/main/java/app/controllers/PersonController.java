package app.controllers;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.DELETE;
import app.models.Person;

public class PersonController extends AppController{
	public void index(){
		view("persons", Person.findAll());
	}

	public void show(){}

	@POST
	public void create(){
		Person person = new Person();
		if(!person.save()){
			flash("message", "Algo deu errado");
			flash("errors", person.errors());
			redirect(PersonController.class, "new_form");
		}else{
			flash("message", "Nova pessoa adicionada: " + person.get("name"));
			redirect(PersonController.class);
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
