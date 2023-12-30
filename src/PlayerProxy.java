import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PlayerProxy {
   public List<Integer> result = new ArrayList<>();
   public String guess = new String();

   Game game;
   Player player;
   int count = 0;

   public void Start() throws InterruptedException {
      while (true){
         this.guess = player.MakeMove();
         this.result = game.Check(this.guess);
         player.GetResult(this.result);
         System.out.println(this.count + ". Bot guess " + this.guess
                 + ": contains " + this.result.get(0)
                 + ", of which in proper place " +this.result.get(1));
         if (this.result.get(1) == 4){
            System.out.println("Number " + this.guess
                    + " guessed correctly in " + this.count + " attempts");
            break;
         }else{
            this.count++;
         }
         //TimeUnit.SECONDS.sleep(1);
      }
   }

   PlayerProxy(Game game, Player player){
      this.game = game;
      this.player = player;
   }
}

