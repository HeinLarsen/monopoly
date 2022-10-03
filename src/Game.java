import java.util.ArrayList;

public class Game {
    FileIO fileIO = new FileIO();
    TextUI textUI = new TextUI();
    private int startValue = 30000;
    private ArrayList<Player> players = new ArrayList<>();


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

        for (String s: data) {
            String[] values = s.split(",");

            int amount;

            if (values.length > 1) {
                amount = Integer.parseInt(values[1]);
            } else {
                amount = startValue;
            }

            Player p = new Player(values[0], amount);
            players.add(p);

        }
    }

    public  void showPlayers() {
        for (Player p: players) {
            System.out.println(p);
        }
    }
}
