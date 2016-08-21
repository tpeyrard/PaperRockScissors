import org.fest.assertions.api.Assertions;
import org.fest.assertions.api.IntegerAssert;

public final class GameAssert extends IntegerAssert {
    private GameAssert(Integer actual) {
        super(actual);
    }

    public static GameAssert assertThat(int result) {
        return new GameAssert(result);
    }


    public void wins() {
        Assertions.assertThat(actual).isEqualTo(1);
    }

    public void loses() {
        Assertions.assertThat(actual).isEqualTo(-1);
    }

    public void draw() {
        Assertions.assertThat(actual).isZero();
    }
}
