package game.particle;

import processing.core.PApplet;

import static game.particle.Particle.Type.*;

public class Particle {
    public enum Type {
        SAND,
        WATER,
        AIR,
        NONE,
    }

    PApplet sketch;
    public int posX, posY;
    public int dimX, dimY;
    public int size;
    public float density;
    public Type type;
    public int id;

    public Particle(PApplet sketch, int posX, int posY, int size, int dimX, int dimY, int id) {
        this.sketch = sketch;
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.dimX = dimX;
        this.dimY = dimY;
        this.id = id;
    }

    public void show() {
        if (type == SAND) {
            sketch.noStroke();
            sketch.fill(242, 169, 24);
            sketch.rect(posX * size, posY * size, size, size);
        }
    }

    public void update(Particle[] particles) {
    }
}
