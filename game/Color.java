package game;

public class Color {
    public float r, g, b;

    public Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(Color c) {
        this(c.r, c.g, c.b);
    }
}
