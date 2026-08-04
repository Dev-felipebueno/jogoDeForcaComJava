import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class JogoDeForca {
    public ArrayList<Character> selecionarPalavraSecreta(){
        Random escolhePalavra = new Random();
        File objArquivoDePalavras = new File("C:\\Users\\felip\\IdeaProjects\\untitled\\Palavras\\palavras");
        ArrayList<String> listaDePalavras = new ArrayList<String>();
        try (Scanner lerArquivo = new Scanner(objArquivoDePalavras)){
            while (lerArquivo.hasNextLine()){
                listaDePalavras.add(lerArquivo.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("Arquivo Não Encontrado");
            e.printStackTrace();
        }
        String palavraSecreta = listaDePalavras.get(escolhePalavra.nextInt(listaDePalavras.size())).toUpperCase();
        ArrayList<Character> letras = new ArrayList<Character>();
        for(int i = 0; i < palavraSecreta.length(); i++){
            char letra = palavraSecreta.charAt(i);
            letras.add(letra);
        }
        return letras;
    }

    public void jogo(ArrayList<Character> selecionarPalavraSecreta) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> listaDeChutes = new ArrayList<Character>();
        int erros = 0;
        while (true) {
            Boolean ganhou = true;
            for (char letra : selecionarPalavraSecreta) {
                if (listaDeChutes.contains(letra)) {
                    System.out.print(letra + " ");
                } else {
                    System.out.print("_ ");
                    ganhou = false;
                }
            }
            System.out.println();
            if (ganhou == true){
                System.out.println("parabens");
                break;
            }

            System.out.print("Digite Uma Letra: ");
            char chute = scanner.next().toUpperCase().charAt(0);
            if (!listaDeChutes.contains(chute)){
                listaDeChutes.add(chute);
            }else{
                System.out.println("Essa Letra Ja Foi Digitada. Por Favor Tente Outra");
                continue;
            }


        }
    }



}

