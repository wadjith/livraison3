package cm.objis.wtt.pharmacie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cm.objis.wtt.pharmacie.util.DBParameter;

/**
 * Classe de cr�ation de la connexion � la Base de donn�es MySQL
 * @author thierry WADJI
 *
 */
public class ConnectionMYSQL {
	
	
	/**
	 * URL(jdbc:mysql://dbhost/dbname) d'acc�s � la base de donn�es
	 */
	public static String url;
	
	/**
	 * nom d'utilisateur de la base des donn�es
	 */
	public static String login;
	
	/**
	 * Mot de passe 
	 */
	public static String passwd;
	
	/**
	 * Objet de connection � la BD 
	 */
	public static Connection connection;
	
	static {
		
		url = "jdbc:mysql://"+DBParameter.getDbhost()+"/"+DBParameter.getDbname();
		login = DBParameter.getUsername();
		passwd = DBParameter.getPassword();
		
	}
	
	/**
	 * Methode de cr�ation d'une connection
	 * Elle ne prend rien en parametre
	 * @return Connection
	 */
	public static Connection getInstance() {
		
		if (connection==null) {
			
			try {
				
				connection = DriverManager.getConnection(url,login,passwd);
				
			}catch (SQLException e) {
				
				System.out.println("Probleme de connection"); 
				
			}
			
		}
		
		return connection;
		
	}

}
