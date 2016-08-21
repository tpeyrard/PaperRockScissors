import java.security.SecureRandom;

public class PaperRockScissors {
    private final SecureRandom secureRandom = new SecureRandom();
    private final int numberOfParties;
    private Hand computerHand;
    private int playedParties;

    public PaperRockScissors(int numberOfParties) {
        this.numberOfParties = numberOfParties;
        this.computerHand = nextRandomHand();
    }

    public static PaperRockScissorsBuilder newGame() {
        return new PaperRockScissorsBuilder();
    }

    public int paper() {
        return play(Hand.PAPER);
    }

    public int scissors() {
        return play(Hand.SCISSORS);
    }

    public int rock() {
        return play(Hand.ROCK);
    }

    public int play(Hand playerHand) {
        checkUserCanStillPlay();
        int result = playerHand.beats(computerHand);

        prepareForNextPossibleParty();
        return result;
    }

    private void checkUserCanStillPlay() {
        if (playedParties == numberOfParties) {
            throw new GameOverException("Game is over");
        }
    }

    private void prepareForNextPossibleParty() {
        playedParties++;
        computerHand = nextRandomHand();
    }

    Hand nextRandomHand() {
        int randomNumber = secureRandom.nextInt();
        return Hand.values()[Math.abs(randomNumber % Hand.POSSIBLE_HANDS)];
    }

    PaperRockScissors computer(Hand hand) {
        this.computerHand = hand;
        return this;
    }

    public int playedParties() {
        return playedParties;
    }

    public int numberOfParties() {
        return numberOfParties;
    }

    public static class PaperRockScissorsBuilder {
        private int numberOfParties = 1;

        public PaperRockScissorsBuilder numberOfParties(int numberOfParties) {
            this.numberOfParties = Math.abs(numberOfParties);
            return this;
        }

        public PaperRockScissors play() {
            return new PaperRockScissors(numberOfParties);
        }
    }
}
