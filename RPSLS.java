import java.util.Random;
import java.util.Scanner;
public class RPSLS {
    enum Move { ROCK, PAPER, SCISSORS, LIZARD, SPOCK }
    public static int winner(Move a, Move b) 
    {
        if (a == b) 
        {
            return 0;
        }
        boolean aBeatsB = switch (a) 
        {
            case ROCK -> (b == Move.SCISSORS || b == Move.LIZARD);
            case PAPER -> (b == Move.ROCK || b == Move.SPOCK);
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD);
            case LIZARD -> (b == Move.SPOCK || b == Move.PAPER);
            case SPOCK -> (b == Move.SCISSORS || b == Move.ROCK);
        };
        return aBeatsB ? 1 : -1;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int playerScore = 0;
        int computerScore = 0;
        for (int round = 1; round <= 5; round++) 
            {
            System.out.println("--- Round " + round + " ---");
            System.out.print("Enter your move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
            String input = sc.next().toUpperCase();
            Move playerMove;
            try 
            {
                playerMove = Move.valueOf(input);
            } catch (IllegalArgumentException e) 
            {
                System.out.println("Invalid move. You forfeit this round.");
                computerScore++;
                continue;
            }
            Move computerMove = Move.values()[rand.nextInt(Move.values().length)];
            System.out.println("Computer chose: " + computerMove);
            int result = winner(playerMove, computerMove);
            if (result == 1) 
            {
                System.out.println("You win this round!");
                playerScore++;
            } 
            else if (result == -1) 
            {
                System.out.println("Computer wins this round!");
                computerScore++;
            } 
            else 
            {
                System.out.println("This round is a tie!");
            }
        }
        System.out.println("\n=== Final Score ===");
        System.out.println("Player: " + playerScore + " | Computer: " + computerScore);
        if (playerScore > computerScore) 
        {
            System.out.println("Overall Winner: Player!");
        } 
        else if (computerScore > playerScore) 
        {
            System.out.println("Overall Winner: Computer!");
        } 
        else 
        {
            System.out.println("Overall Result: It's a Tie!");
        }
        sc.close();
    }
}