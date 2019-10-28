import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException; // IO : InputOutput
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RandomizeShapes extends JPanel implements ActionListener {

    ArrayList<Figures> shapesList;
    int counter = 0;
    Timer timer;

    public RandomizeShapes(){
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.BLACK);

        shapesList = new ArrayList<>();
         timer = new Timer(500,this);
         timer.start();
     }


     public synchronized void add(Figures f){
         shapesList.add(f);
         counter++;
     }
     public void write(){
         Path file = Paths.get("fig");
         try {
             BufferedWriter buf = Files.newBufferedWriter(file);
             for (Figures f: shapesList) {
                 buf.write(f.toString());
             }
             buf.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     public boolean isFilled(){
         return counter == Main.shapesQuantity;
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        int cnt = (int)(Math.random()*3);
        switch(cnt){
            case 0:
                add(new Circle());
                break;
            case 1:
                add(new Rectangle());
                break;
            case 2:
                add(new Circle());
                break;
        }
        if(isFilled()){
            timer.stop();
            write();
            ReadShapes readShapes = new ReadShapes();
            JFrame fr2 = new JFrame("READ");
            fr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr2.setVisible(true);
            fr2.add(readShapes);
            fr2.setLocation(500,0);
            fr2.pack();
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
            for (Figures f : shapesList) {
                f.draw(g, getWidth(), getHeight());
            }
    }
}
