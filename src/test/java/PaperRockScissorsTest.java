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
      assertPlayer(Hand.PAPER.beats(Hand.ROCK)).wins();
      assertPlayer(Hand.ROCK.beats(Hand.PAPER)).loses();
   }

   @Test
   public void
   rock_beats_scissors() {
      assertPlayer(Hand.ROCK.beats(Hand.SCISSORS)).wins();
      assertPlayer(Hand.SCISSORS.beats(Hand.ROCK)).loses();
   }

   @Test
   public void
   scissors_beats_paper() {
      assertPlayer(Hand.SCISSORS.beats(Hand.PAPER)).wins();
      assertPlayer(Hand.PAPER.beats(Hand.SCISSORS)).loses();
   }

   @Test
   public void
   there_is_draw_if_players_play_the_same_hand() {
      assertPlayer(Hand.PAPER.beats(Hand.PAPER)).draw();
      assertPlayer(Hand.SCISSORS.beats(Hand.SCISSORS)).draw();
      assertPlayer(Hand.ROCK.beats(Hand.ROCK)).draw();
   }

   @Test
   public void
   fails_when_random_does_not_pick_a_hand_between_the_three_available() {
      for (int i = 0; i < 100_000; i++) {
         game.nextRandomHand(); // Throws an ArrayOutOfBondException if random integer is not in [0,2]
      }
   }


    /* Should be part of Main tests
    @Test(expected = GameOverException.class)
    public void
    user_can_play_n_parties() {
        int numberOfParties = 12;
        PaperRockScissors game = PaperRockScissors.newGame().numberOfParties(numberOfParties).play();

        for (int i = 0; i < numberOfParties; i++) {
           game.play(Hand.ROCK);
        }

        // Game is over
       game.play(Hand.ROCK);
    }
*/

/*     Should be part of main tests
    @Test
    public void
    it_sanitizes_input_of_number_of_parties() {
        PaperRockScissors game = PaperRockScissors.newGame().numberOfParties(-5).play();

        Assertions.assertThat(game.numberOfParties()).isEqualTo(5);
    }*/

   private GameAssert assertPlayer(int paper) {
      return GameAssert.assertThat(paper);
   }

}
