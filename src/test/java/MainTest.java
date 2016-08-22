import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class MainTest {

/*   @Test
   public void
   user_can_play_n_parties() throws IOException {
      int numberOfParties = 12;
      Main.playParties(numberOfParties, new BufferedReader(new InputStreamReader(System.in)));

      for (int i = 0; i < numberOfParties; i++) {
         game.play(Hand.ROCK);
      }

      // Game is over
      game.play(Hand.ROCK);
   }*/

   @Test
   public void
   it_sanitizes_input_of_number_of_parties() {
      assertThat(Main.numberOfParties("-1")).isEqualTo(1);
   }
}