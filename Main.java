import game.World;
import game.particle.*;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class Main extends PApplet {

    World w;

    public void settings() {
        size(600, 400);
    }

    public void setup() {
        background(50);
        w = new World(this, width, height);
//        frameRate(1);
    }

    public void draw() {
        background(50);
        w.show();
        w.update();
    }

    public void mousePressed() {
        w.mousePressed(mouseX, mouseY);
    }

    public void mouseReleased() {
        w.mouseReleased(mouseX, mouseY);
    }

    public void mouseWheel(MouseEvent e) {
        w.mouseScroll(e.getCount());
    }

    public void keyPressed() {
        w.keyPressed(keyCode);
    }

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }
}
