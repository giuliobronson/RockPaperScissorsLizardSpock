import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String args[]) {

        try {
            Player player = new Player();
            Server server = new Server(5000);
            Game game = new Game();

            for(int i = 0; i < 15; i++) {
                int serverMove = player.play();
                int clientMove = server.getMessage(serverMove);
                
                game.check(clientMove, serverMove);
            }
        } 
        catch (IOException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}