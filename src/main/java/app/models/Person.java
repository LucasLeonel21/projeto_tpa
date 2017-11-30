package app.models;

import org.javalite.activejdbc.Model;

public class Person extends Model{
	static{
		validatePresenceOf("name","last_name");
	}
}
