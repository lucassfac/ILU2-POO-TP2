package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.im.InputContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;

class EtalTest {
	private Gaulois vendeur;
	private String produit;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("INIT");
		Etal etal = new Etal();
		Gaulois gaul = new Gaulois("gaul", 6);
		etal.occuperEtal(gaul, "pommes", 6);
	}
	
	@Test
	void testIsEtalOccupe() {
		Etal etal = new Etal(); // assuming constructor sets etalOccupe
		Gaulois expresult = new Gaulois("gaul", 6);
		etal.occuperEtal(expresult, "pommes", 6);
		assertTrue(etal.isEtalOccupe());
	}

	@Test
	void testGetVendeur() {
		Etal etal = new Etal();
		Gaulois expresult = new Gaulois("gaul", 6);
		etal.occuperEtal(expresult, "pommes", 6);
		Gaulois result = etal.getVendeur();
		assertEquals(expresult, result);
	}

	@Test
	void testGetQuantite() {
		int expresult = 6;
		Etal etal = new Etal();
		Gaulois tmpGaul = new Gaulois("gaul", 6);
		etal.occuperEtal(tmpGaul, "pommes", 6);
		assertEquals(expresult, etal.getQuantite());
	}

	@Test
	void testGetProduit() {
		String expresult = "pommes";
		Etal etal = new Etal();
		Gaulois tmpGaul = new Gaulois("gaul", 6);
		etal.occuperEtal(tmpGaul, "pommes", 6);
		assertEquals(expresult, etal.getProduit());
	}

	@Test
	void testOccuperEtal() {
		testGetVendeur();
		testGetQuantite();
		testGetProduit();
	}

	@Test
	void testContientProduit() {
		String produit = "pommes";
		Etal etal = new Etal();
		Gaulois tmpGaul = new Gaulois("gaul", 6);
		etal.occuperEtal(tmpGaul, "pommes", 6);
		this.produit = produit;
		assertEquals(this.produit, produit);
	}

	@Test
	void testAcheterProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testLibererEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testEtatEtal() {
		fail("Not yet implemented");
	}

}
