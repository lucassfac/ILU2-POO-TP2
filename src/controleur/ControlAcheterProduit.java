package controleur;

import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}public boolean verifierIdentite(String nomAcheteur) {
        return controlVerifierIdentite.verifierIdentite(nomAcheteur);
    }

    public Gaulois[] donnerListeVendeursProduit(String produit) {
        return village.rechercherVendeursProduit(produit);
    }

    public String acheterProduit(String nomAcheteur, String nomVendeur, String produit, int quantite) {
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        if (etal == null) {
            return "Désolé, personne ne vend ce produit au marché.";
        }

        int stock = etal.getQuantite();
        if (stock == 0) {
            return nomAcheteur + " veut acheter " + quantite + " " + produit +
                   ", malheureusement il n'y en a plus !";
        } else if (stock < quantite) {
            etal.acheterProduit(stock);
            return nomAcheteur + " veut acheter " + quantite + " " + produit +
                   ", malheureusement " + nomVendeur + " n'en a plus que " + stock +
                   ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".";
        } else {
            etal.acheterProduit(quantite);
            return nomAcheteur + " achète " + quantite + " " + produit + " à " + nomVendeur;
        }
    }
}

