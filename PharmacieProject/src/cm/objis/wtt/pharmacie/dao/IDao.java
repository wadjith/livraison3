package cm.objis.wtt.pharmacie.dao;

import java.sql.SQLException;
import java.util.List;

import cm.objis.wtt.pharmacie.domaine.Produit;


/**
 * 
 * Interface de communication avec la BD 
 * @author thierry WADJI
 *
 */
public interface IDao {
	
	
	
	/**
	 * Enregistre un produit dans la BD
	 * @param produit est un objet de type Produit
	 * @throws SQLException est g�n�r� s'il y'a une erreur
	 */
	public void enregistrerProduitDao(Produit produit) throws SQLException;
	
	/**
	 * 
	 * Liste les produits de la BD
	 * 
	 * @return List de Produit
	 * @throws SQLException est g�n�r� s'il y'a une erreur
	 */
	public List<Produit> listProduitDao() throws SQLException;
	
	
	/**
	 * @param ref r�f�rene du Produit
	 * @return Produit
	 * @throws SQLException est g�n�r� s'il y'a une erreur
	 */
	public Produit rechercheProduitDao(String ref) throws SQLException;
	
	
	/**
	 * Verifie si un produit de reference donn� est dej� enregistr� dans la BD
	 * 
	 * @param ref r�f�rence du produit
	 * @return True si un produit de reference(ref) esr dej� en BD ou False sinon 
	 * @throws SQLException est g�n�r� s'il y'a une erreur
	 */
	public boolean dejaEnregistreDao(String ref) throws SQLException;
	
	
	/**
	 * Calcul le nombre de produit dans la BD
	 * 
	 * @return long
	 * @throws SQLException est g�n�r� s'il y'a une erreur
	 */
	public long nombreProduitDao() throws SQLException;

}
