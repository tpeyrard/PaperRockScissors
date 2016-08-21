import com.google.common.collect.ImmutableMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Map;

public class Main {
    private static final Map<String, Hand> STRING_HAND_MAP = ImmutableMap.of(
            "ROCKS", Hand.ROCK,
            "SCISSORS", Hand.SCISSORS,
            "PAPER", Hand.PAPER);

    public static void main(String[] args) throws IOException {
        PaperRockScissors.PaperRockScissorsBuilder gameBuilder = PaperRockScissors.newGame();
        if (args.length == 1) {
            gameBuilder.numberOfParties(Integer.parseInt(args[0]));
        }
        PaperRockScissors game = gameBuilder.play();

        System.out.println("Number of parties: " + game.numberOfParties());
        System.out.println("Enter either: rock, paper, scissors:");

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (game.playedParties() != game.numberOfParties()) {
                String userInput = bufferedReader.readLine().toUpperCase(Locale.ENGLISH);
                Hand playerHand = STRING_HAND_MAP.get(userInput);
                if (playerHand == null) {
                    System.out.println("Unknown hand");
                    continue;
                }
                int result = game.play(playerHand);

                String winner;
                switch (result) {
                    case -1:
                        winner = "Computer";
                        break;
                    case 1:
                        winner = "You";
                        break;
                    default:
                        winner = "No one - Draw";
                }
                System.out.println("Winner = " + winner);
            }
        }
    }
}
