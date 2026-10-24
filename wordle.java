import java.util.Scanner;
import java.util.Random;
public class wordle {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        wordBank w = new wordBank();
        int index = r.nextInt(502);
        String answer = w.words[index];
        System.out.println("====================");
        System.out.println("       WORDLE       ");
        System.out.println("====================");
        boolean isRunning = true;
        int tries=0;
        while(isRunning){
            if(tries >= 6){
                break;
            }
            System.out.println();
            String guess;
            while(true){
            guess = sc.nextLine().toUpperCase();
            if(guess.length() != 5 || !guess.matches("[a-zA-Z]+")){
                System.out.println("The word must be 5 leter alphabetical word only!");
            }
            else{
                break;
            }
            }
            tries++;
            for(int i=0; i<5; i++){
                if(guess.equalsIgnoreCase(answer)){
                    System.out.println("🟩🟩🟩🟩🟩");
                    System.out.println("BINGO!");
                    isRunning = false;
                    break;
                }
                else if(guess.charAt(i) == answer.charAt(i)){
                    System.out.print("🟩");
                }
                else if(answer.indexOf(guess.charAt(i)) != -1){
                    System.out.print("🟨");
                }
                else{
                    System.out.print("⬛");
                }
            }

        }

        System.out.println("\nWord was "+answer);
        sc.close();
    }
    
}
