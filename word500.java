import java.util.Scanner;
import java.util.Random;
public class word500 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        wordBank w = new wordBank();
        System.out.println("====================");
        System.out.println("|      WORD500     |");
        System.out.println("====================");
        int indx = r.nextInt(502);
        String answer = w.words[indx];
        int tries = 0;
        int green=0, yellow=0, red=0;
        boolean isRunning=true;
        String guess;
        while(isRunning){
            if(tries>=8){
                System.out.println("The word was "+answer);
                isRunning = false;
                break;
            }
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
                    System.out.println("BINGO!");
                    System.out.println("The word was "+answer+"!");
                    isRunning = false;
                    break;
                }
                else if(guess.charAt(i) == answer.charAt(i)){
                    green++;
                }
                else if(answer.indexOf(guess.charAt(i)) != -1){
                    yellow++;
                }
                else{
                    red++;
                }
            }
            if(isRunning){
            System.out.println("🟩:"+green+" 🟨:"+yellow+" 🟥:"+red);
                green=yellow=red=0;
            }
        }
    sc.close();
    }
}

