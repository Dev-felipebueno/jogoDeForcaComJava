import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Teste {
    public static void teste(String[] args) {
        File listaDePalavras = new File("C:\\Users\\felip\\IdeaProjects\\untitled\\Palavras\\palavras");

        try (Scanner myReader = new Scanner(listaDePalavras)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}