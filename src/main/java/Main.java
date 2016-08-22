import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.MissingFormatArgumentException;
import java.util.Optional;

public class Main {

   public static void main(String[] args) throws IOException {
      if (args.length != 1) {
         throw new MissingFormatArgumentException("You need to specify the number of parties");
      }

      final int numberOfParties = positiveNumberOfParties(args[0]);

      System.out.println("Number of parties: " + numberOfParties);
      System.out.println("Enter either: rock, paper, scissors:");

      try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
         playParties(numberOfParties, bufferedReader);
      }
   }

   static int positiveNumberOfParties(String arg) {
      return Math.abs(Integer.parseInt(arg));
   }

   static void playParties(int numberOfParties, BufferedReader bufferedReader) throws IOException {
      PaperRockScissors game = PaperRockScissors.newGame();

      while (numberOfParties > 0) {
         String userInput = bufferedReader.readLine().toUpperCase(Locale.ENGLISH);
         final Optional<Hand> playerHand = toHand(userInput);

         if (!playerHand.isPresent()) {
            System.out.println("Unknown hand");
            continue;
         }

         int result = game.play(playerHand.get());

         System.out.println("Winner = " + theWinnerIs(result));

         numberOfParties--;
      }
   }

   private static String theWinnerIs(int playerResult) {
      switch (playerResult) {
         case Hand.Constants.WIN:
            return  "You";
         case Hand.Constants.LOSE:
            return "Computer";
         default:
            return "No one - Draw";
      }
   }

   private static Optional<Hand> toHand(String userHand) {
      for (final Hand hand : Hand.values()) {
         if (hand.correspondsTo(userHand)) {
            return Optional.of(hand);
         }
      }
      return Optional.empty();
   }
}
