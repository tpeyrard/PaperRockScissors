import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class PaperRockScissorsTest {

   private PaperRockScissors game;

   @Before
   public void setUp() throws Exception {
      game = PaperRockScissors.newGame();
   }

   @Test
   public void
   paper_beats_rock() {
      HandAssert.assertThat(Hand.PAPER).beats(Hand.ROCK);
   }

   @Test
   public void
   rock_beats_scissors() {
      HandAssert.assertThat(Hand.ROCK).beats(Hand.SCISSORS);
   }

   @Test
   public void
   scissors_beats_paper() {
      HandAssert.assertThat(Hand.SCISSORS).beats(Hand.PAPER);
   }

   @Test
   public void
   there_is_draw_if_players_play_the_same_hand() {
      assertDraw(Hand.PAPER, Hand.PAPER);
      assertDraw(Hand.SCISSORS, Hand.SCISSORS);
      assertDraw(Hand.ROCK, Hand.ROCK);
   }

   private void assertDraw(Hand playerHand, Hand computerHand) {
      Assertions.assertThat(playerHand.beats(computerHand)).isEqualTo(0);
   }

   @Test
   public void
   fails_when_random_does_not_pick_a_hand_between_the_three_available() {
      for (int i = 0; i < 100_000; i++) {
         game.nextRandomHand(); // Throws an ArrayOutOfBondException if random integer is not in [0,2]
      }
   }

}
