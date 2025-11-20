package frontiere;

import java.util.Iterator;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infos = controlAfficherMarche.donnerInfosMarche();
		if(infos.length == 0) {
			System.out.println("Le marche est vide revenez plus tard");
			return;
		}
		System.out.println(nomAcheteur + ", vous trouverez au marché :");
		for (int i = 0; i < infos.length; i += 3) {
            String vendeur = infos[i];
            String quantite = infos[i + 1];
            String produit = infos[i + 2];
            System.out.println("- " + vendeur + " qui vend " + quantite + " " + produit);
        }
	}
}
