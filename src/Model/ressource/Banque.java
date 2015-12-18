package Model.ressource;

/**
 * Created by jpabegg on 18/12/15.
 */
public class Banque extends DeckRessource{
    public Banque(){
        super();
        initBanque();
    }
    private void initBanque(){
        for (int i = 0; i < 19; i++) {
            obtenirRessource(Ressource.Argile);
            obtenirRessource(Ressource.Ble);
            obtenirRessource(Ressource.Bois);
            obtenirRessource(Ressource.Minerai);
            obtenirRessource(Ressource.Laine);
        }
    }
}
