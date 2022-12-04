import java.util.HashMap;
import java.util.Map;

public class Game {
    private final int[][] payoff = {
        {0, -1, 1, 1, -1},
        {1, 0, -1, -1, 1},
        {-1, 1, 0, 1, -1},
        {-1, 1, -1, 0, 1},
        {1, -1, 1, -1, 0}
    };

    private final Map<String, Integer> history = new HashMap<String, Integer>();

    Game() {
        history.put("1", 0);
        history.put("2", 0);
        history.put("Tie", 0);
    }

    void check(int clientMove, int serverMove) {
        int result = payoff[clientMove][serverMove];
        if(result > 0) {
            history.put("1", history.get("1") + 1);
            System.out.println("Player 1 Wins");
        } 
        else if(result < 0) {
            history.put("2", history.get("1") + 1);
            System.out.println("Player 2 Wins");
        }
        else {
            history.put("Tie", history.get("1") + 1);
            System.out.println("Draw");
        }
    }
}
