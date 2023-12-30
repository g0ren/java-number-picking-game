import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaybeDecentBot extends Player{

    private List<List<Integer>> _results = new ArrayList<>();
    private List<String> _moves = new ArrayList<>();
    private List<String> _symbols;

    public MaybeDecentBot(){
        this._symbols=Arrays.asList("1234567890".split(""));
    }

    private String guess(){
        //System.out.println("_symbols is " + this._symbols.getClass());
        while (true){
            Collections.shuffle(this._symbols);
            String guess = this._symbols.get(0)
                    + this._symbols.get(1)
                    + this._symbols.get(2)
                    + this._symbols.get(3);
            if (!this._moves.contains(guess)){
                return guess;
            }
        }
    }

    @Override
    public String MakeMove() {
        if (this._results.isEmpty() || this._moves.isEmpty()){
            String myGuess = this.guess();
            this._moves.add(myGuess);
            return myGuess;
        } else if (this._results.get(this._results.size()-1).get(0) == 0) {
            List<String> lastMove = Arrays.asList(this._moves
                    .get(this._moves.size() - 1)
                    .split(""));
            this._symbols = new ArrayList<>(this._symbols.stream()
                    .filter(i -> !lastMove.contains(i))
                    .toList());
            String myGuess = this.guess();
            this._moves.add(myGuess);
            return myGuess;
        } else if (this._results.get(this._results.size()-1).get(0) == 4) {
            this._symbols = new ArrayList<>(List.of(this._moves.get(this._moves.size() - 1).split("")));
            String myGuess = this.guess();
            this._moves.add(myGuess);
            return myGuess;
        } else { // for now
            String myGuess = this.guess();
            this._moves.add(myGuess);
            return myGuess;
        }
    }

    @Override
    public void GetResult(List<Integer> result) {
        _results.add(result);
    }
}
