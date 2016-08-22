import static org.fest.assertions.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

public class MainTest {

   private List<String> playerHands = Lists.newArrayList("paper", "rock", "scissors");

   @Test
   public void
   user_can_play_n_parties() throws IOException {
      ByteArrayInputStream threeHands = new ByteArrayInputStream(Joiner.on('\n').join(playerHands).getBytes());

      final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(threeHands));
      Main.playParties(playerHands.size(), bufferedReader);

      assertThat(bufferedReader.readLine()).isNull();
   }

   @Test
   public void
   user_can_play_only_the_defined_number_of_parties() throws IOException {
      final String additionalHand = "paper";
      final String MorePlayerHands = FluentIterable.from(playerHands).append(additionalHand).join(Joiner.on('\n'));

      ByteArrayInputStream fourHands = new ByteArrayInputStream(MorePlayerHands.getBytes());

      final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fourHands));
      Main.playParties(playerHands.size(), bufferedReader);

      assertThat(bufferedReader.readLine()).isEqualTo(additionalHand);
   }

   @Test
   public void
   it_sanitizes_input_of_number_of_parties() {
      assertThat(Main.positiveNumberOfParties("-1")).isEqualTo(1);
   }
}