import static org.fest.assertions.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class MainTest {

   @Test
   public void
   user_can_play_n_parties() throws IOException {
      ByteArrayInputStream threeParties = new ByteArrayInputStream("paper\nrock\nscissors".getBytes());

      final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(threeParties));
      Main.playParties(3, bufferedReader);

      assertThat(bufferedReader.readLine()).isNull();
   }

   @Test
   public void
   it_sanitizes_input_of_number_of_parties() {
      assertThat(Main.numberOfParties("-1")).isEqualTo(1);
   }
}