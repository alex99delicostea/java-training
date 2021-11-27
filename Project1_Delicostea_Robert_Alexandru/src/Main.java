import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
         File file = new File("src/input.txt");
         BufferedReader br = new BufferedReader(new FileReader(file));
         String st;
         Strategy strategy;
         List<Hero> heroes = new ArrayList<>(20);
         Hero_Factory factory = new Hero_Factory();
         int n = Integer.parseInt(br.readLine());
         for(int i = 0; i < n; i++)
         {
              st=br.readLine();
              String[] arr = st.split(" ", 4);

              Heroes name = Heroes.valueOf(arr[0]);
              int life = Integer.parseInt(arr[1]);
              int x = Integer.parseInt(arr[2]);
              int y = Integer.parseInt(arr[3]);
              heroes.add(factory.getHero(life, name, x, y, i));

         }
         int m = Integer.parseInt(br.readLine());
         for(int i = 0; i < m; i++){
              st=br.readLine();
              String[] arr = st.split(" ", 2);
              int x_dev = Integer.parseInt(arr[0]);
              int y_dev = Integer.parseInt(arr[1]);
              heroes.get(i%n).setX(heroes.get(i%n).getX() + x_dev);
              heroes.get(i%n).setY(heroes.get(i%n).getY() + y_dev);
              for(int j = (i%n) + 1; j < n; j++){
                   if(heroes.get(i%n).getX() == heroes.get(j).getX() && heroes.get(i%n).getY() == heroes.get(j).getY()){
                       strategy = new Strategy(heroes.get(i%n));
                       strategy.execute_strategy(heroes.get(j));
                       strategy = new Strategy(heroes.get(j));
                       strategy.execute_strategy(heroes.get(i%n));
                   }
              }
         }


    }
}
