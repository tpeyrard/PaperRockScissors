import java.security.SecureRandom;

public final class PaperRockScissors {
   private final SecureRandom SECURE_RANDOM = new SecureRandom();

   private PaperRockScissors() {
   }

   public static PaperRockScissors newGame() {
      return new PaperRockScissors();
   }

   public Winner play(Hand playerHand) {
      return theWinnerIs(playerHand.beats(nextRandomHand()));
   }

   static Winner theWinnerIs(int playerResult) {
      switch (playerResult) {
         case Hand.Constants.WIN:
            return  Winner.PLAYER;
         case Hand.Constants.LOSE:
            return Winner.COMPUTER;
         default:
            return Winner.DRAW;
      }
   }

   Hand nextRandomHand() {
      int randomNumber = SECURE_RANDOM.nextInt();
      return Hand.values()[Math.abs(randomNumber % Hand.POSSIBLE_HANDS)];
   }

}
