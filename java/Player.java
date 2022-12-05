import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {
    public int play() {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4);
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
