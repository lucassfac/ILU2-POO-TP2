package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
        if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
            System.out.println("Je suis désolée " + nomAcheteur +
                               " mais il faut être un habitant de notre village pour commercer ici.");
            return;
        }

        String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");

        Gaulois[] vendeurs = controlAcheterProduit.donnerListeVendeursProduit(produit);
        if (vendeurs == null || vendeurs.length == 0) {
            System.out.println("Désolé, personne ne vend ce produit au marché.");
            return;
        }

        System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
        for (int i = 0; i < vendeurs.length; i++) {
            System.out.println((i + 1) + " - " + vendeurs[i].getNom());
        }

        int choix = Clavier.entrerEntier("Votre choix :");
        Gaulois nomVendeur = vendeurs[choix - 1];

        System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur.getNom());
        System.out.println("Bonjour " + nomAcheteur);

        int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");

        String resultat = controlAcheterProduit.acheterProduit(nomAcheteur, nomVendeur.getNom(), produit, quantite);
        System.out.println(resultat);
	}
}
