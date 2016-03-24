package Model;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
/**
 * Created by Drago on 24/03/2016.
 */
public class MusicModel {
    private AudioClip musicPrincipal;
    private AudioClip soundClic;
    private AudioClip musicMenu;
    private AudioClip soundDe;
    private Media musicGame;
    private MediaPlayer mediaPlayer;

    public MusicModel(){
        initMusic();
    }

    public void initMusic(){
        //musicPrincipal= new AudioClip(Paths.get("").toUri().toString()+"src/assets/music/principal.mp3");
        musicGame=new Media(Paths.get("").toUri().toString()+"src/assets/music/starwars.wav");
        setMediaPlayer(new MediaPlayer(musicGame));

//			soundClic= new AudioClip(Paths.get("").toUri().toString()+"src/assets/music/clic.mp3");
//			musicMenu= new AudioClip(Paths.get("").toUri().toString()+"src/assets/music/menu.mp3");
//			soundDe= new AudioClip(Paths.get("").toUri().toString()+"src/assets/music/de.mp3");


    }

    public AudioClip getMusicPrincipal() {
        return musicPrincipal;
    }

    public void setMusicPrincipal(AudioClip musicPrincipal) {
        this.musicPrincipal = musicPrincipal;
    }

    public AudioClip getClic() {
        return soundClic;
    }

    public void setClic(AudioClip clic) {
        this.soundClic = clic;
    }

    public AudioClip getMusicMenu() {
        return musicMenu;
    }

    public void setMusicMenu(AudioClip musicMenu) {
        this.musicMenu = musicMenu;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public void playLoop(){
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();
    }

    public AudioClip getSoundDe() {
        return soundDe;
    }

    public void setSoundDe(AudioClip soundDe) {
        this.soundDe = soundDe;
    }

}

