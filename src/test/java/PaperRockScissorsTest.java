import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PaperRockScissorsTest {

    private PaperRockScissors game;

    @Before
    public void setUp() throws Exception {
        game = PaperRockScissors.newGame().numberOfParties(5).play();
    }

    @Test
    public void
    paper_beats_rock() {
       assertPlayer(game.computer(Hand.ROCK).play(Hand.PAPER)).wins();
       assertPlayer(game.computer(Hand.PAPER).play(Hand.ROCK)).loses();
    }

    @Test
    public void
    rock_beats_scissors() {
       assertPlayer(game.computer(Hand.SCISSORS).play(Hand.ROCK)).wins();
       assertPlayer(game.computer(Hand.ROCK).play(Hand.SCISSORS)).loses();
    }

    @Test
    public void
    scissors_beats_paper() {
       assertPlayer(game.computer(Hand.PAPER).play(Hand.SCISSORS)).wins();
       assertPlayer(game.computer(Hand.SCISSORS).play(Hand.PAPER)).loses();
    }

    @Test
    public void
    there_is_draw_if_players_play_the_same_hand() {
       assertPlayer(game.computer(Hand.PAPER).play(Hand.PAPER)).draw();
       assertPlayer(game.computer(Hand.SCISSORS).play(Hand.SCISSORS)).draw();
       assertPlayer(game.computer(Hand.ROCK).play(Hand.ROCK)).draw();
    }

    @Test
    public void
    computer_chooses_hand_randomly() {
        PaperRockScissors mockedGame = Mockito.spy(game);
        Mockito.when(mockedGame.nextRandomHand()).thenReturn(Hand.ROCK, Hand.SCISSORS, Hand.PAPER);

        // dummy run because we spy on mock after its creation, so nextRandomHand has already been called.
        // without pre-defined value
       mockedGame.play(Hand.PAPER);

       assertPlayer(mockedGame.play(Hand.PAPER)).wins();
       assertPlayer(mockedGame.play(Hand.PAPER)).loses();
       assertPlayer(mockedGame.play(Hand.ROCK)).loses();
    }

    @Test
    public void
    fails_when_random_does_not_pick_a_hand_between_the_three_available() {
        for (int i = 0; i < 100_000; i++) {
            game.nextRandomHand(); // Throws an ArrayOutOfBondException if random integer is wrong
        }
    }

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

    @Test
    public void
    it_sanitizes_input_of_number_of_parties() {
        PaperRockScissors game = PaperRockScissors.newGame().numberOfParties(-5).play();

        Assertions.assertThat(game.numberOfParties()).isEqualTo(5);
    }

    private GameAssert assertPlayer(int paper) {
        return GameAssert.assertThat(paper);
    }


}
