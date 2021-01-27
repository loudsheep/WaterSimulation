package game.particle;

import processing.core.PApplet;

import static game.particle.Particle.Type.*;

public class Sand { //extends Particle {
//
//    int[] color;
//
//    public Sand(PApplet sketch, int posX, int posY, int size, int dimX, int dimY) {
//        super(sketch, posX, posY, size, dimX, dimY, SAND);
//
//        double r = Math.random();
//
//        if (r < 0.75) {
//            color = new int[]{242, 166, 24};
//        } else if (r < 0.9) {
//            color = new int[]{242, 169, 24};
//        } else {
//            color = new int[]{242, 195, 24};
//        }
//
//        this.density = 0.5f;
//    }
//
//    @Override
//    public void show() {
//        sketch.noStroke();
//        sketch.fill(color[0], color[1], color[2]);
//        sketch.rect(posX * size, posY * size, size, size);
//    }
//
//    @Override
//    public void update(Particle[] particles) {
//        if (posY < dimY - 1) {
//            if (findOnPosition(particles, posX, posY + 1).type == AIR) {
//                posY++;
//            } else {
//                if (posX > 0 && posX < dimX - 1) {
//                    int choose = Math.random() < 0.5 ? -1 : 1;
//
//                    if (findOnPosition(particles, posX + choose, posY + 1).type == AIR) {
//                        posX += choose;
//                        posY++;
//                    } else if (findOnPosition(particles, posX - choose, posY + 1).type == AIR) {
//                        posY -= choose;
//                        posY++;
//                    }
//                }
//            }
//
//        }
//
////        if (posY < dimY - 1) {
////            if (particles[posX].type == Type.AIR) {
////                posY++;
////            } else {
////                if (posX > 0 && posX < dimX - 1) {
////                    int choose = Math.random() < 0.5 ? -1 : 1;
////
////                    if (particles[posX + choose].type == Type.AIR) {
////                        posX += choose;
////                        posY++;
////                    } else {
////                        if (particles[posX - choose].type == Type.AIR) {
////                            posX -= choose;
////                            posY++;
////                        }
////                    }
////                }
////            }
////        }
////        if (posY >= dimY - 1) {
////            posY = dimY - 1;
////        }
//    }
}
