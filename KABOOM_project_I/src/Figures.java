import java.awt.*;

public class Figures {
    int height, width, x, y;
    Color color;

    public Figures(int height, int width, int x, int y, Color color){
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public Figures(int height, int x, int y, Color color){
        this.height = height;
        this.width = height;
        this.x = x;
        this.y = y;
        this.color = color;
    }
    static Color getCol(){
        return new Color(
                (int)(Math.random()*255),
                (int)(Math.random()*255),
                (int)(Math.random()*255)
        );
    }

    public void draw(Graphics g, int w, int h){ }

    @Override
    public String toString(){
        return height + " " + width + " "  + x + " " + y + " " +
                color.getRed() + " " +  color.getGreen() + " "  +  color.getBlue() +  "\n";
    }
}
//==============================================================================

class Square extends Figures {

    public Square() {
        super((int)(2 + Math.random()*10),
                (int)(1 + Math.random()*10),
                (int)(1 + Math.random()*10),
                getCol());
        System.out.println(this);
    }

    public Square(int height, int width, int x, int y, Color color) {
        super(height, width, x, y, color);
    }

    public void draw(Graphics g, int w, int h ){

        g.setColor(color);
        if(w/x + w/width > w) w = w - w/width;
        if(h/y + h/height > h) h = h - h/height;
        g.fillRect(w/x,h/y,w/width,h/height);
    }

    @Override
    public String toString() {
        return "Square " + super.toString(); // go to line 25
    }
}
//==============================================================================
class Rectangle extends Figures {

    public Rectangle() {
        super((int)(2 + Math.random()*10),
                (int)(2 + Math.random()*10),
                (int)(1 + Math.random()*10),
                (int)(1 + Math.random()*10),
                getCol());
    }

    public Rectangle(int height, int width, int x, int y, Color color) {
        super(height, width, x, y, color);
    }

    public void draw(Graphics g, int w, int h){
        g.setColor(color);
        if(w/x + w/width > w) w = w - w/width;
        if(h/y + h/height > h) h = h - h/height;
        g.fillRect(w/x,h/y,w/width,h/height);
    }

    @Override
    public String toString() {
        return "Rectangle " + super.toString();
    }
}
//==============================================================================

class Circle extends Figures {

    public Circle() {
        super(
                (int)(2 + Math.random()*10) ,
                (int)(1 + Math.random()*10),
                (int)(1 + Math.random()*10),
                getCol()
        );
    }

    public Circle(int height, int width, int x, int y, Color color) {
        super(height, width, x, y, color);
    }

    public void draw(Graphics g, int w, int h){
        g.setColor(color);
        if(w/x + w/width > w) w = w - w/width;
        if(h/y + h/height > h) h = h - h/height;
        g.fillOval(w/x,h/y,w/width,h/height);
    }

    @Override
    public String toString() {
        return "Circle " + super.toString();
    }


}

