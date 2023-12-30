public class Main {
    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        for(int i=0; i<4; i++){
            System.out.print(game.get_secret().get(i));
        }
        System.out.println();
        //game.Menu();
        Player player = new MaybeDecentBot();
        PlayerProxy proxy = new PlayerProxy(game, player);
        proxy.Start();

    }
}

