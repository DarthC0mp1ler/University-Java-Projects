import javax.swing.*;
        import java.awt.*;
        import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadShapes extends JPanel {

    ArrayList<Figures> listRead;


    public ReadShapes(){
        listRead = new ArrayList<>();
        setPreferredSize(new Dimension(500,500));
        read();
    }

    public void read(){
        Path file = Paths.get("fig");
        try {
            BufferedReader buf = Files.newBufferedReader(file);
            while(true){
                String s = null;
                try {
                    s = buf.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(s == null)break;
                String[] sarr = s.split(" ");
                add(sarr);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(String[] arr){
        if(arr[0].equals("Square")){
            listRead.add(new Square(
                    Integer.parseInt(arr[1]),
                    Integer.parseInt(arr[2]),
                    Integer.parseInt(arr[3]),
                    Integer.parseInt(arr[4]),
                    new Color(
                            Integer.parseInt(arr[5]),
                            Integer.parseInt(arr[6]),
                            Integer.parseInt(arr[7])
                    )
            ));
        } else if(arr[0].equals("Rectangle")){
            listRead.add(new Rectangle(
                    Integer.parseInt(arr[1]),
                    Integer.parseInt(arr[2]),
                    Integer.parseInt(arr[3]),
                    Integer.parseInt(arr[4]),
                    new Color(
                            Integer.parseInt(arr[5]),
                            Integer.parseInt(arr[6]),
                            Integer.parseInt(arr[7])
                    )
            ));
        } else if (arr[0].equals("Circle")){
            listRead.add(new Circle(
                    Integer.parseInt(arr[1]),
                    Integer.parseInt(arr[2]),
                    Integer.parseInt(arr[3]),
                    Integer.parseInt(arr[4]),
                    new Color(
                            Integer.parseInt(arr[5]),
                            Integer.parseInt(arr[6]),
                            Integer.parseInt(arr[7])
                    )
            ));
        }

    }

    @Override
    public void paintComponent(Graphics g){
        if(listRead != null)
            for (Figures f: listRead) {
                f.draw(g, getWidth(), getHeight());
            }
    }
}
