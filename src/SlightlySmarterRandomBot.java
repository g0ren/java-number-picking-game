import java.util.*;

public class SlightlySmarterRandomBot extends Player{

    private static final Integer[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private ArrayList<String> options = new ArrayList<>();

    private void generateOptions(){

        for (int i = 0; i < 10000; i++) {
            ArrayList<String> number = new ArrayList<> (Arrays.asList(new String[]{
                    i / 1000 + "",
                    i % 1000 / 100 + "",
                    i % 100 / 10 + "",
                    i % 10 + ""
            }));
            if(number.stream().distinct().count() == (long) number.size()){
                StringBuilder sb = new StringBuilder();
                for(String n : number){
                    sb.append(n);
                }
                this.options.add(sb.toString());
            }
        }
    }

    SlightlySmarterRandomBot(){
        this.generateOptions();
        Collections.shuffle(this.options);
    }

    @Override
    public String MakeMove() {
        return this.options.remove(0);
    }

    @Override
    public void GetResult(List<Integer> result) {

    }
}
