package game;

import processing.core.PApplet;

import java.util.HashMap;

public class World {
    PApplet sketch;
    int width, height;

    Pixel[][] grid;

    int drawMode = 1;
    String[] modes = new String[]{"AIR", "SAND", "WATER", "WOOD"};

    int pointerRadius = 15;

    public static HashMap<Integer, Color> colors;

    static {
        colors = new HashMap<>();
        colors.put(0, new Color(50, 50, 50));       // air
        colors.put(5, new Color(242, 169, 24));     // sand
        colors.put(10, new Color(66, 135, 245));    // water
        colors.put(15, new Color(89, 54, 20));      // wood
    }

    public World(PApplet sketch, int width, int height) {
        this.sketch = sketch;
        this.width = width;
        this.height = height;

        this.grid = new Pixel[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (Math.random() < 1) {
                    grid[i][j] = new Pixel(i, j, 0);
                } else {
                    grid[i][j] = new Pixel(i, j, 10);
                }
            }
        }
    }

    private Pixel point(int x, int y) {
        if (x >= 0 && x < grid.length) {
            if (y >= 0 && y < grid[0].length) {
                return grid[x][y];
            }
        }
        return new Pixel(0, 0, -1);
    }

    private void setPoint(int x, int y, int c, boolean u) {
        if (x >= 0 && x < grid.length) {
            if (y >= 0 && y < grid[0].length) {
                grid[x][y].id = c;
                grid[x][y].updated = u;
                grid[x][y].lastDir = 0;
                grid[x][y].lifeTime = 0;
            }
        }
    }

    private void setPoint(int x, int y, int c) {
        setPoint(x, y, c, true);
    }


    public void show() {
        sketch.loadPixels();
        for (int i = width - 1; i >= 0; i--) {
            for (int j = height - 1; j >= 0; j--) {
                int index = i + (j * width);
                Color c = colors.get(grid[i][j].id);
                sketch.pixels[index] = sketch.color(c.r, c.g, c.b);
                grid[i][j].lifeTime++;
            }
        }
        sketch.updatePixels();

        sketch.stroke(255);
        sketch.noFill();
        sketch.strokeWeight(1);
        sketch.ellipse(sketch.mouseX, sketch.mouseY, pointerRadius * 2, pointerRadius * 2);

        sketch.textSize(10);
        sketch.fill(255);
        sketch.text(modes[drawMode], 10, 10);
    }

    public void update() {
        for (int j = height - 1; j >= 0; j--) {
            for (int i = width - 1; i >= 0; i--) {

                if (grid[i][j].id == 5 && !grid[i][j].updated) {  // sand update
                    if (point(i, j + 1).id == 0) {
                        setPoint(i, j, 0);
                        setPoint(i, j + 1, 5);
                    } else if (point(i - 1, j + 1).id == 0 && point(i + 1, j + 1).id == 0) {  // if space below and left or right are free
                        int move = Math.random() < 0.5 ? -1 : 1;
                        setPoint(i, j, 0);
                        setPoint(i + move, j + 1, 5);
                    } else if (point(i - 1, j + 1).id == 0) { //
                        setPoint(i, j, 0);
                        setPoint(i - 1, j + 1, 5);
                    } else if (point(i + 1, j + 1).id == 0) {
                        setPoint(i, j, 0);
                        setPoint(i + 1, j + 1, 5);
                    } else if (point(i, j + 1).id == 10) {
                        setPoint(i, j, 10);
                        setPoint(i, j + 1, 5);
                    }
                } else if (grid[i][j].id == 10 && !grid[i][j].updated) { // water update
                    if (point(i, j + 1).id == 0) {
                        setPoint(i, j + 1, 10);
                        setPoint(i, j, 0);
                    } else if (point(i - 1, j + 1).id == 0) {
                        setPoint(i - 1, j + 1, 10);
                        setPoint(i, j, 0);
                    } else if (point(i + 1, j + 1).id == 0) {
                        setPoint(i + 1, j + 1, 10);
                        setPoint(i, j, 0);
                    } else if (point(i - 1, j).id == 0) {
                        setPoint(i - 1, j, 10);
                        setPoint(i, j, 0);
                    } else if (point(i + 1, j).id == 0) {
                        setPoint(i + 1, j, 10);
                        setPoint(i, j, 0);
                    }

//                    if (point(i, j + 1).id == 0) {
//                        setPoint(i, j, 0);
//                        setPoint(i, j + 1, 10);
//                    } else if (point(i - 1, j + 1).id == 0) {
//                        setPoint(i, j, 0);
//                        setPoint(i - 1, j + 1, 10);
//                    } else if (point(i + 1, j + 1).id == 0) {
//                        setPoint(i, j, 0);
//                        setPoint(i + 1, j + 1, 10);
//                    } else if (point(i - 1, j).id == 0) {
//                        if (grid[i][j].lastDir < 1) {
//                            setPoint(i + 1, j, 10);
//                            setPoint(i, j, 0);
//                            point(i + 1, j).lastDir = 1;
//                        } else {
//                            if (point(i + 1, j).id == 0) {
//                                setPoint(i + 1, j, 10);
//                                setPoint(i, j, 0);
//                                point(i + 1, j).lastDir = 1;
//                            } else {
//                                setPoint(i - 1, j, 10);
//                                setPoint(i, j, 0);
//                                point(i - 1, j).lastDir = -1;
//                            }
//                        }
//                    } else if (point(i + 1, j).id == 0) {
//                        if (grid[i][j].lastDir > -1) {
//                            setPoint(i + 1, j, 10);
//                            setPoint(i, j, 0);
//                            point(i + 1, j).lastDir = 1;
//                        } else {
//                            if (point(i - 1, j).id == 0) {
//                                setPoint(i - 1, j, 10);
//                                setPoint(i, j, 0);
//                                point(i - 1, j).lastDir = -1;
//                            } else {
//                                setPoint(i + 1, j, 10);
//                                setPoint(i, j, 0);
//                                point(i + 1, j).lastDir = 1;
//                            }
//                        }
//                    } else if (point(i - 1, j).id == 0) {
//                        setPoint(i - 1, j, 10);
//                        setPoint(i, j, 0);
//                    } else if (point(i + 1, j).id == 0) {
//                        setPoint(i + 1, j, 10);
//                        setPoint(i, j, 0);
//                    }
                }
            }
        }

        for (int i = 0; i < width; i++) { // reset 'updated' property after all physics calculations
            for (int j = 0; j < height; j++) {
                grid[i][j].updated = false;
            }
        }

        if (sketch.mousePressed) { // draw on map
            if (sketch.mouseX > 0 && sketch.mouseX < width && sketch.mouseY > 0 && sketch.mouseY < height) {
//                grid[sketch.mouseX][sketch.mouseY].id = sketch.mouseButton == PApplet.LEFT ? 5 : 10;
                if (sketch.mouseButton == PApplet.RIGHT) {
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            if (PApplet.dist(i, j, sketch.mouseX, sketch.mouseY) < pointerRadius) {
                                grid[i][j].id = 0;
                            }
                        }
                    }
                } else {
                    if (drawMode == 1 || drawMode == 2) {
                        for (int i = 0; i < pointerRadius; i++) {
                            int x = (int) (Math.random() * width);
                            int y = (int) (Math.random() * height);

                            if (PApplet.dist(x, y, sketch.mouseX, sketch.mouseY) < pointerRadius) {
                                grid[x][y].id = drawMode * 5;
//                            grid[x][y].id = sketch.mouseButton == PApplet.LEFT ? 5 : 10;
                            } else {
                                i--;
                            }
                        }
                    } else if (drawMode == 0 || drawMode == 3) {
                        for (int i = 0; i < width; i++) {
                            for (int j = 0; j < height; j++) {
                                if (PApplet.dist(i, j, sketch.mouseX, sketch.mouseY) < pointerRadius) {
                                    grid[i][j].id = drawMode * 5;
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    public void keyPressed(int keyCode) {
        if (keyCode == 38) {
            changeMode(drawMode + 1);
        } else if (keyCode == 40) {
            changeMode(drawMode - 1);
        }
    }

    private void changeMode(int mode) {
        if (mode < 0) {
            drawMode = 0;
        } else if (mode >= modes.length) {
            drawMode = modes.length - 1;
        } else {
            drawMode = mode;
        }
    }

    public void mouseScroll(int amount) {
        pointerRadius = PApplet.constrain(pointerRadius + amount, 5, 50);
    }

    public void mousePressed(int mouseX, int mouseY) {
    }

    public void mouseReleased(int mouseX, int mouseY) {
    }
}

