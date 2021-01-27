package game;

import game.particle.Air;
import game.particle.Particle;
import game.particle.Sand;
import processing.core.PApplet;

public class Grid {
//
//    PApplet sketch;
//
//    final int numOfParticles;
//    int particlesX, particlesY;
//
//    Particle[] particles;
//
//    public Grid(PApplet sketch, int particlesX, int particlesY) {
//        this.sketch = sketch;
//        this.particlesX = particlesX;
//        this.particlesY = particlesY;
//        this.particles = new Particle[particlesX * particlesY];
//
//        for (int i = 0; i < particlesX; i++) {
//            for (int j = 0; j < particlesY; j++) {
//                int index = i + (j * particlesX);
//                if (Math.random() < 0.999) {
//                    this.particles[index] = new Air(sketch, i, j, 1, particlesX, particlesY);
//                } else {
//                    this.particles[index] = new Sand(sketch, i, j, 1, particlesX, particlesY);
//                }
//            }
//        }
//        this.numOfParticles = particlesX * particlesY;
//    }
//
//    private void swap(Particle[][] old, Particle[][] _new) {
//        for (int i = 0; i < old.length; i++) {
//            for (int j = 0; j < old[i].length; j++) {
//                _new[i][j] = old[i][j];
//            }
//        }
//    }
//
//    public void show() {
//        for (int i = 0; i < numOfParticles; i++) {
//            particles[i].update(particles);
//            particles[i].show();
//        }
//    }
}
