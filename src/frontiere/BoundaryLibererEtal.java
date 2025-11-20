package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marche aujourd'hui !");
		}
		String[] donnees = controlLibererEtal.libererEtal(nomVendeur);
		String etalOccupe = donnees[0];
		if(etalOccupe == "true") {
			System.out.println("Vous avez vendu " + donnees[4] + " sur " + donnees[3] + " " + donnees[2] + ".");
			System.out.println("En revoir " + nomVendeur + " , passez une bonne journee.");
		}
		
	}

}
