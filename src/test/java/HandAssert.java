import org.fest.assertions.api.Assertions;
import org.fest.assertions.api.ObjectAssert;

public final class HandAssert extends ObjectAssert<Hand> {

   private HandAssert(Hand actual) {
      super(actual);
   }

   public static HandAssert assertThat(Hand result) {
        return new HandAssert(result);
    }

   public void beats(Hand other) {
      Assertions.assertThat(actual.beats(other)).isEqualTo(1);
   }
}
