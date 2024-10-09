package companies.kotak;

import java.util.*;

class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Coordinates coordinates = (Coordinates) obj;
        return x == coordinates.x && y == coordinates.y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class Player {
    String playerId;
    Set<Coordinates> coordinatesSet;

    HashMap<Integer, Set<Coordinates>> shipsAtCoordinates;

    public Player(String playerId) {
        this.playerId = playerId;
        coordinatesSet = new HashSet<>();
        shipsAtCoordinates = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Player{" +
                "coordinatesSet=" + coordinatesSet +
                '}';
    }
}

class Solution {
    int N;
    int[][] grid;
    Player[] players;

    int playerTurnId;

    public void initGame(int N) {
        this.N = N;
        grid = new int[N][N];
        players = new Player[2];

        initializePlayers();

        playerTurnId = 0;
        //System.out.println(Arrays.toString(players));
    }


    public void addShip(String id, int size, int xA, int yA, int xB, int yB) {
        String shipIdA = "A-" + id;
        createShip(shipIdA, xA, yA, size);

        playerTurnId = (playerTurnId == 0 ? 1 : 0);

        String shipIdB = "B-" + id;
        createShip(shipIdB, xB, yB, size);
    }

    public void startGame() {
        Coordinates missileFiredAtCoordinates1 = new Coordinates(3, 0);
        hitMissile(missileFiredAtCoordinates1);

        Coordinates missileFiredAtCoordinates2 = new Coordinates(4, 5);
        hitMissile(missileFiredAtCoordinates2);

        Coordinates missileFiredAtCoordinates3 = new Coordinates(5, 3);
        hitMissile(missileFiredAtCoordinates3);
    }

    public void hitMissile(Coordinates missileFiredAtCoordinates) {
        Player player = players[playerTurnId];
        boolean isHit = isShipPresentAtCoordinate(player, missileFiredAtCoordinates);
        System.out.println("Player " + player.playerId + "'s turn: Missile fired at " + missileFiredAtCoordinates +
                ": " + (isHit ? "\"Hit\"" : "\"Miss\"") + " Ships Remaining " + "Player A : " + players[0].shipsAtCoordinates.size()
                + " Player B : " + players[1].shipsAtCoordinates.size());

        playerTurnId = (playerTurnId == 0 ? 1 : 0);
    }

    public void viewBattleField(boolean showContent) {
        if (showContent) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(grid[i][j] + "\t");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(i + "" + j + "\t");
                }
                System.out.println();
            }
        }
    }

    public void initializePlayers() {
        players[0] = new Player("A");
        players[1] = new Player("B");

        int columnsPerPlayer = N / 2;
        //Player A
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < columnsPerPlayer; column++) {
                players[0].coordinatesSet.add(new Coordinates(row, column));
            }
        }

        //Player B
        for (int row = 0; row < N; row++) {
            for (int column = columnsPerPlayer; column < N; column++) {
                players[1].coordinatesSet.add(new Coordinates(row, column));
            }
        }
    }

    public boolean isShipPresentAtCoordinate(Player player, Coordinates missileFiredAtCoordinates) {
        HashMap<Integer, Set<Coordinates>> shipsAtCoordinates = player.shipsAtCoordinates;

        for (int i = 0; i < shipsAtCoordinates.size(); i++) {
            Set<Coordinates> shipCoordinates = shipsAtCoordinates.get(i);
            if (shipCoordinates != null && shipCoordinates.contains(missileFiredAtCoordinates)) {
                shipsAtCoordinates.remove(i);
                return true;
            }
        }
        return false;
    }

    public void createShip(String id, int x, int y, int size) {
        int playerId = id.charAt(0) == 'A' ? 0 : 1;
        int shipId = Integer.parseInt(id.substring(4));
        Player player = players[playerId];

        for (int i = x; i < x + size && i < N; i++) {
            for (int j = y; j < y + size && j < N; j++) {
                grid[i][j] = shipId;
                if (player.shipsAtCoordinates.get(shipId) == null) {
                    player.shipsAtCoordinates.put(shipId, new HashSet<>());
                }
                player.shipsAtCoordinates.get(shipId).add(new Coordinates(i, j));
            }
        }
    }

    public static void main(String[] args) {
        int N = 6;
        Solution solution = new Solution();
        solution.initGame(N);

        solution.addShip("SH1", 2, 1, 5, 4, 4);

        solution.startGame();
        solution.viewBattleField(false);
        solution.viewBattleField(true);

        solution.startGame();
    }
}
