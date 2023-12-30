import java.util.*;

public class Game {
    private static final Integer[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<Integer> get_secret() {
        return _secret;
    }

    private List<Integer> _secret = new ArrayList<>();

    public void Generate(){
        List<Integer> digits = new ArrayList<>(List.of(DIGITS.clone()));
        Collections.shuffle(digits);
        for(int i = 0; i < 4; i++){
            this._secret.add(digits.get(i));
        }
    }

    public ArrayList<Integer> Check(String guess){
        int contains = 0;
        int properPlace = 0;

        ArrayList<Integer> guessInts = new ArrayList<>();
        for(String s : guess.split("")){
            guessInts.add(Integer.parseInt(s));
        }
        for(int i = 0; i < 4; i++){
            if(this._secret.contains(guessInts.get(i))){
                contains++;
            }
            if(Objects.equals(this._secret.get(i), guessInts.get(i))){
                properPlace++;
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(contains, properPlace));

        return result;
    }

    public void Menu(){
        Scanner sc= new Scanner(System.in);
        ArrayList<Integer> result;
        while (true){
            System.out.println("Enter your guess");
            String guess = sc.nextLine();
            result = this.Check(guess);
            System.out.println("Contains " + result.get(0) + ", of which on proper place " + result.get(1));
            if(result.get(1)==4){
                System.out.println("Congratulations");
                break;
            }
        }
    }

    Game(){
        this.Generate();
    }

}
