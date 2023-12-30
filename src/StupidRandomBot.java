import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StupidRandomBot extends Player{

    private static final Integer[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    @Override
    public String MakeMove() {
        StringBuilder builder = new StringBuilder();
        List<Integer> digits = new ArrayList<>(List.of(DIGITS.clone()));
        Collections.shuffle(digits);
        for(int i = 0; i < 4; i++){
            builder.append(digits.get(i));
        }
        return builder.toString();
    }

    @Override
    public void GetResult(List<Integer> result) {

    }
}
