package game;

public class Pixel {
    int id;
    int x, y;
    boolean updated;
    int lastDir;
    int lifeTime = 0;

    public Pixel(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
}
