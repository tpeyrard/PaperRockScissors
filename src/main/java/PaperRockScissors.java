import java.security.SecureRandom;

public final class PaperRockScissors {
   private final SecureRandom SECURE_RANDOM = new SecureRandom();

   private PaperRockScissors() {
   }

   public static PaperRockScissors newGame() {
      return new PaperRockScissors();
   }

   public int play(Hand playerHand) {
      return playerHand.beats(nextRandomHand());
   }

   Hand nextRandomHand() {
      int randomNumber = SECURE_RANDOM.nextInt();
      return Hand.values()[Math.abs(randomNumber % Hand.POSSIBLE_HANDS)];
   }

}
