import java.util.ArrayList;

public class Game {
    FileIO fileIO = new FileIO();
    TextUI textUI = new TextUI();

    public void gameSetup() {
        /*
         check if game data exist
         otherwise start dialog
        */
        ArrayList<String> data = fileIO.readGameData();
        if (data == null) {
            data = textUI.getUserInputs("Skriv spiller navn. Tast Q for at afslutte", 6);
        }

        createPlayers(data);

    }

    public void createPlayers(ArrayList<String> data) {
        for (String p: data) {
            System.out.println(p);
//            Player p = new Player(p, 20000);
        }
    }
}
