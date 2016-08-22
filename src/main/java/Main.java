import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Map;
import java.util.MissingFormatArgumentException;

import com.google.common.collect.ImmutableMap;

public class Main {
   private static final Map<String, Hand> STRING_HAND_MAP = ImmutableMap.of(
         "ROCK", Hand.ROCK,
         "SCISSORS", Hand.SCISSORS,
         "PAPER", Hand.PAPER);

   public static void main(String[] args) throws IOException {
      if (args.length != 1) {
         throw new MissingFormatArgumentException("You need to specify the number of parties");
      }

      final int numberOfParties = numberOfParties(args[0]);

      System.out.println("Number of parties: " + numberOfParties);
      System.out.println("Enter either: rock, paper, scissors:");

      try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
         playParties(numberOfParties, bufferedReader);
      }
   }

   static int numberOfParties(String arg) {
      return Math.abs(Integer.parseInt(arg));
   }

   static void playParties(int numberOfParties, BufferedReader bufferedReader) throws IOException {
      PaperRockScissors game = PaperRockScissors.newGame();

      while (numberOfParties > 0) {
         String userInput = bufferedReader.readLine().toUpperCase(Locale.ENGLISH);
         Hand playerHand = STRING_HAND_MAP.get(userInput);
         if (playerHand == null) {
            System.out.println("Unknown hand");
            continue;
         }
         int result = game.play(playerHand);

         String winner;
         switch (result) {
            case -1:
               winner = "Computer";
               break;
            case 1:
               winner = "You";
               break;
            default:
               winner = "No one - Draw";
         }
         System.out.println("Winner = " + winner);
         numberOfParties--;
      }
   }
}
