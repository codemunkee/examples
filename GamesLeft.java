class GamesLeft {
    public static void main(String args[]) {
        int dGamesLeft, gGamesLeft;

        int dWon = 78;
        int dLost = 58;

        int gWon = 71;
        int gLost = 67;

        int dLeft = gamesLeft(dWon, dLost);
        int gLeft = gamesLeft(gWon, gLost);

        // games ahead or behind
        double dGamesBehind = gamesBehind(dWon, dLost, gWon, gLost);
        double gGamesBehind = gamesBehind(gWon, gLost, dWon, dLost);

        System.out.println();
        printRecord("Dodgers", dWon, dLost, dLeft);
        printRecord("Giants", gWon, gLost, gLeft);
        System.out.println();

        if (dGamesBehind == gGamesBehind) {
            System.out.println("Dodgers & Giants are tied in the standings.");
        } else if (dGamesBehind >= gGamesBehind) {
            System.out.println("Dodgers are " + dGamesBehind +
                               " games behind.");
        } else {
            System.out.println("Giants are " + gGamesBehind +
                               " games behind.");
        }
        System.out.println();

        System.out.println("Dodgers Magic Number: " +
                           magicNumber(dWon, gLost));

        toCatchUp("Dodgers", "Giants", gGamesBehind, dLeft, dWon, dLost,
                  gLeft, gWon, gLost);
    }

    private static void toCatchUp(String teamName, String oppTeamName,
                                  double oppGB, int gamesLeft, int gamesWon,
                                  int gamesLost, int oppGamesLeft,
                                  int oppGamesWon, int oppGamesLost) {

        System.out.printf("\nFor the %s to take the lead the remaining" +
                          " records would need to be: \n\n", oppTeamName);

        // increment through win loss potential results
        for (int wins=gamesLeft; wins > 0; wins--) {

            // losses is total games left minus the wins we're incremented on
            int losses = gamesLeft - wins;

            System.out.print(" " + teamName + " ");

            // print wins and losses for remaining games
            double winPct = (double) wins / (double) gamesLeft;
            //System.out.print(wins + ":" +  losses + "(" + winPct + ")");
            System.out.print(wins + ":" +  losses + " (" +
                             String.format( "%.3f", winPct ) + ")");

            // then total wins and losses
            int totalWins = gamesWon +  wins;
            int totalLosses = gamesLost +  losses;


            int oppWins = totalWins - oppGamesWon + 1;
            int oppTotalWins = oppGamesWon + oppWins;
            int oppLosses = oppGamesLeft - oppWins;
            int oppTotalLosses = oppGamesLost + oppLosses;


            if (oppLosses == -1) {
                System.out.print(" => " + oppTeamName + " ");
                System.out.print((oppWins - 1) + ":" + (oppLosses + 1) +
                                   " (1.000)");
                System.out.println(" tie");
            } else if (losses < oppGB + 1) {
                System.out.println(" => Impossible");
            } else {
                double oppWinPct = (double) oppWins / (double) oppGamesLeft;
                System.out.print(" => " + oppTeamName + " ");
                System.out.println(oppWins + ":" +  oppLosses + " (" +
                                 String.format( "%.3f", oppWinPct ) + ")");
            }
        }
    }

    private static int gamesLeft(int won, int lost) {
        return 162 - (won + lost);
    }

    private static double gamesBehind(int aWon, int aLost, int bWon,
                                      int bLost) {
        // returns the number of games ahead, games behind
        // a is team, b is team b
        double gamesBehind = (.5) * ((aWon - bWon) + (bLost - aLost));
        if (gamesBehind < 0) {
            return gamesBehind * -1;
        } else {
            return 0;
        }
    }

    private static int magicNumber(int wins, int losses) {
        return 162 + 1 - wins - losses;
    }

    private static void printRecord(String team, int wins, int losses,
                                    int gamesLeft) {
        double winPct = (float) wins / ((float) wins + (float) losses);
        System.out.println(team + " have " + wins + " wins and " + losses +
                           " losses (" + String.format( "%.3f", winPct ) +
                           ") with " + gamesLeft + " games left.");
    }

}
