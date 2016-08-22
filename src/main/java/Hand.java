import java.util.Optional;

public enum Hand {
    SCISSORS {
        public int versus(Hand other) {
            return winsVersus(other, PAPER);
        }
    },
    PAPER {
        public int versus(Hand other) {
            return winsVersus(other, ROCK);
        }
    },
    ROCK {
        public int versus(Hand other) {
            return winsVersus(other, SCISSORS);
        }
    };

    static final int POSSIBLE_HANDS = 3;

    public int beats(Hand other) {
        if (this.equals(other)) {
            return Constants.DRAW;
        }
        return this.versus(other);
    }

    protected abstract int versus(Hand other);

    private static int winsVersus(Hand other, Hand loser) {
        return loser.equals(other) ? Constants.WIN : Constants.LOSE;
    }

   public static Optional<Hand> toHand(String userHand) {
      for (final Hand hand : values()) {
         if (hand.correspondsTo(userHand)) {
            return Optional.of(hand);
         }
      }
      return Optional.empty();
   }

   protected boolean correspondsTo(String userHand) {
      return this.toString().equals(userHand);
   }

   private static class Constants {
        static final int WIN = 1;
        static final int LOSE = -1;
        static final int DRAW = 0;

    }
}
