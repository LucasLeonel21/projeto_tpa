package app.models;

import org.javalite.activejdbc.Model;

public class Pessoa extends Model{
	static{
		validatePresenceOf("name","last_name");
	}
}
