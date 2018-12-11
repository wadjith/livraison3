package cm.objis.wtt.pharmacie.service;

import java.sql.SQLException;
import java.util.List;

import cm.objis.wtt.pharmacie.domaine.Produit;

/**
 * 
 * Interface de service de sur les produits
 * @author thierry WADJI
 *
 */
public interface IService {
	
	
	/**
	 * M�thode d'enregistrement de produit
	 * 
	 * @param produit est un objet de la classe Produit
	 * @throws SQLException est g�n�r� s'il y'a une erreur
	 */
	public void enregistrerProduitService(Produit produit) throws SQLException;
	
	
	/**
	 * M�thode de listing des produits enregistr�s en BD
	 * 
	 * @return List de Produit
	 * @throws SQLException est g�n�r� s'il y'a une erreur
	 */
	public List<Produit> listProduitService() throws SQLException;
	
	
	/**
	 * M�thode de recherche de produit par sa r�f�rence
	 * 
	 * @param ref r�f�rence du produit
	 * @return Produit objet de la classe Produit
	 * @throws SQLException est g�n�r� s'il y'a une erreur
	 */
	public Produit rechercheProduitService(String ref) throws SQLException;
	
	
	/**
	 * M�thode qui v�rifie si un produit de r�f�rence donn� est d�j� enregistr� en BD
	 * 
	 * @param ref r�f�rence du produit
	 * @return true si le produit est dej� enregistr� en BD et false au cas contraire
	 * @throws SQLException est g�n�r� s'il y'a une erreur
	 */
	public boolean dejaEnregistreService(String ref) throws SQLException;
	
	
	/**
	 * Calcul le nombre d'enregistrement de produit
	 * 
	 * @return long nombre de produit
	 * @throws SQLException est g�n�r� s'il y'a une erreur
	 */
	public long nombreProduitService() throws SQLException;

}
