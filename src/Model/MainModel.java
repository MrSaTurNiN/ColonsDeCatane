package Model;

import java.awt.*;

/**
 * Created by Mahel Sif on 30/01/2016.
 */
public class MainModel {

    private Partie partie;
    private MenuModel menu;
    private MusicModel music;

    public MainModel() {
        music = new MusicModel();
        partie = new Partie();
        nouvellePartie();

    }

    public void nouvellePartie(){

       setNbJoueur(3);
       creerJoueur("Jean",Color.GREEN);
       creerJoueur("Jacques",Color.CYAN);
       creerJoueur("Yolo",Color.RED);

       partie.setOrdreJoueur();
       partie.setJoueurActif(partie.getListeJoueur().get(0));
       partie.setLaunched();
    }

    public void creerJoueur(String nomJoueur, Color colorJoueur){
        partie.creerJoueur(nomJoueur, colorJoueur);
        partie.getListCouleur().remove(partie.getJoueurActif().getCouleurJoueur());

    }

    public void setNbJoueur(int nbJoueur){
        partie.setNbJoueur(nbJoueur);
    }

    public Partie getPartie(){
        return partie;
    }
    public MusicModel getMusic() {
        return music;
    }

    public void setMusic(MusicModel music) {
        this.music = music;
    }

}
