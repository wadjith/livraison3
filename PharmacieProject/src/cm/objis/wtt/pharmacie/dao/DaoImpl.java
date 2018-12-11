package cm.objis.wtt.pharmacie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cm.objis.wtt.pharmacie.domaine.Produit;

public class DaoImpl implements IDao {
	
	
	@Override
	public void enregistrerProduitDao(Produit produit) throws SQLException {

		// Etape 1 : r�cup�ration de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : Cr�ation d'un objet  statement et preparation de la requete
		String sql = "INSERT INTO `produit`(`reference`,`libelle`,`prix`,`quantite`)" 
				+"VALUES (?,?,?,?)";
		
		PreparedStatement ps=  cn.prepareStatement(sql);
		ps.setString(1, produit.getReference());
		ps.setString(2, produit.getLibelle());
		ps.setDouble(3, produit.getPrix());
		ps.setInt(4, produit.getQuantite());
		
	
		// Etape 3 : ex�cution requ�te
		ps.executeUpdate();
		
		
	}

	@Override
	public List<Produit> listProduitDao() throws SQLException {
		
		 //cr�ation d'une collection de la collection des agriculteurs
		List<Produit> maListProduit= new ArrayList<Produit>();
	
		// Etape 1 : r�cup�ration de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : pr�paration requ�te
		String sql = "SELECT * FROM produit";
		
		Statement st = cn.createStatement();

		// Etape 3 : ex�cution requ�te
		ResultSet rs = st.executeQuery(sql);

		// Etape 4 :parcours Resultset (optionnel)
		while (rs.next()) {
			
			//recuperation des valeurs d'une ligne de la table, pour initialiser dans un objet Produit
			Produit produit =  new Produit();
			produit.setId(rs.getLong("id"));
			produit.setReference(rs.getString("reference"));
			produit.setLibelle(rs.getString("libelle"));
			produit.setPrix(rs.getDouble("prix"));
			produit.setQuantite(rs.getInt("quantite"));
			
			//ajout du produit dans List maListProduit
			maListProduit.add(produit); 
			
		}
		
		return maListProduit;
		
	}

	@Override
	public Produit rechercheProduitDao(String ref) throws SQLException {
		
		Produit produit= new Produit();
		
		// Etape 1 : r�cup�ration de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : pr�paration requ�te
		
		String sql = "SELECT * FROM produit WHERE reference = ?";
		
		PreparedStatement ps= cn.prepareStatement(sql);
		ps.setString(1, ref);
		ResultSet rs=ps.executeQuery();
		
		if (rs.next()) {
			produit.setId(rs.getLong("id"));
			produit.setReference(rs.getString("reference"));
			produit.setLibelle(rs.getString("libelle"));
			produit.setPrix(rs.getDouble("prix"));
			produit.setQuantite(rs.getInt("quantite"));
			
		}

		return produit;
	}
	
	

	@Override
	public boolean dejaEnregistreDao(String ref) throws SQLException {
		boolean result = false;

		// Etape 1 : r�cup�ration de la connexion
		Connection cn = ConnectionMYSQL.getInstance();

		// Etape 2 : pr�paration requ�te

		String sql = "SELECT * FROM produit WHERE reference = ?";

		PreparedStatement ps= cn.prepareStatement(sql);
		ps.setString(1, ref);
		ResultSet rs=ps.executeQuery();

		if (rs.next())  result = true;
		
		return result;
	}

	@Override
	public long nombreProduitDao() throws SQLException {
        long nbProduit = 0;
		
        // Etape 1 : r�cup�ration de la connexion
		Connection cn = ConnectionMYSQL.getInstance();
	
		// Etape 2 : pr�paration requ�te
		
		String sql = "SELECT COUNT(*) FROM produit";
		Statement st= cn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		rs.next();
		nbProduit = rs.getLong(1);
        
		return nbProduit;
	}

}
