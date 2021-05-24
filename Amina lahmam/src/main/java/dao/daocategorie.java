package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Categorie;
import models.Livre;

public class daocategorie {

	public static Categorie categotirParId(int id) throws ClassNotFoundException, SQLException {
		Categorie c=null;
		Connexion.Connect();
		ResultSet res = Connexion.Select("select * from categorie where id="+id);
		if(res.next()) {
			c=new Categorie(res.getInt(1), res.getString(2), res.getString(3), null);
		}
		Connexion.Disconnect();
		return c;
	}
	
	public static int getIdCatByName(String name) throws ClassNotFoundException, SQLException {
		int idcat=0;
		Connexion.Connect();
		ResultSet res = Connexion.Select("select id from categorie where nom='"+name+"'");
		if(res.next()) {
			idcat = res.getInt(1);
		}
		Connexion.Disconnect();
		return idcat;
	}
	
	public static ArrayList<Categorie> listeCategories() throws ClassNotFoundException, SQLException{
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		Connexion.Connect();
		ResultSet res = Connexion.Select("select * from categorie");
		while(res.next()) {
			Categorie c=new Categorie(res.getInt(1), res.getString(2), res.getString(3), null);
			categories.add(c);
		}
		Connexion.Disconnect();
		return categories;
	}
	
	
}