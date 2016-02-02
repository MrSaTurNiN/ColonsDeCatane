package lib;

/**
 * Script de Timer se stoppant à 0.
 */

public class GameTickCounter {
    private int t;

    public GameTickCounter() {
        this.t = 0;
    }

    public GameTickCounter(int t) {
        this.t = t;
    }

    public void set() {
        this.t = 0;
    }

    public void set(int t) {
        this.t = t;
    }

    public void add(int t) {
        this.t += t;
    }

    public int get() {
        return t;
    }

    public boolean isUp() {
        if (this.t > 0)
            this.t--;
        else
            return false;
        return true;
    }

    public boolean isActive() {
        return t > 0;
    }

    public void update() {
        if (this.t > 0)
            this.t--;
    }

    public void update(int t) {
        if (this.t > 0)
            this.t -= t;
    }
}
