package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.daolivre;
import models.Livre;

public class servicelivre {

		 public static ArrayList<Livre> listelivre() throws ClassNotFoundException, SQLException{
			 return daolivre.listeLivres();
		 }
}
