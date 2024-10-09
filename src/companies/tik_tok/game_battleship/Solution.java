package companies.tik_tok.game_battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Ship {
    int size;
    List<int[]> position;
    boolean isShipHit;
    Character shipType;

    Ship(Character shipType, int size) {
        this.shipType = shipType;
        this.size = size;
        this.isShipHit = false;
        this.position = new ArrayList<>();
    }


    public boolean isSunk() {
        return isShipHit;
    }
}

class Grid {
    final int gridSize = 10;

    char[][] board;
    List<Ship> ships;

    Grid() {
        board = new char[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            Arrays.fill(board[i], '-');
        }
        ships = new ArrayList<>();
    }

    public void placeShip(Ship ship, int startX, int startY, boolean horizontal) throws Exception {
        if (horizontal) {
            if (startY + ship.size > gridSize) {
                throw new Exception("Ship doesn't fit!");
            }
            for (int i = 0; i < ship.size; i++) {
                board[startX][startY + i] = ship.shipType;
                ship.position.add(new int[]{startX, startY + i});
            }
        } else {
            if (startX + ship.size > gridSize) {
                throw new Exception("Ship doesn't fit!");
            }
            for (int i = 0; i < ship.size; i++) {
                board[startX + i][startY] = ship.shipType;
                ship.position.add(new int[]{startX + i, startY});
            }
        }
        ships.add(ship);
    }

    public boolean playerMove(int x, int y) {
        for (Ship ship : ships) {
            if (!ship.isShipHit) {
                List<int[]> shipPositions = ship.position;
                for (int[] shipPosition : shipPositions) {
                    if (shipPosition[0] == x && shipPosition[1] == y) {
                        ship.isShipHit = true;
                        break;
                    }
                }
                if (ship.isShipHit) {
                    for (int[] shipPosition : shipPositions) {
                        board[shipPosition[0]][shipPosition[1]] = 'H';
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public void printGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class Game {
    Grid grid;

    Game() {
        grid = new Grid();
    }

    public void start() throws Exception {
        Ship destroyer = new Ship('D', 2);
        Ship submarine = new Ship('S', 3);

        grid.placeShip(destroyer, 0, 0, true);
        grid.placeShip(submarine, 2, 2, false);

        grid.printGrid();

        Scanner sc = new Scanner(System.in);
        while (!grid.allShipsSunk()) {
            System.out.println("Enter your move (x y):");
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (grid.playerMove(x, y)) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss!");
            }
            grid.printGrid();
        }

        System.out.println("All ships sunk! You win!");
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.start();
    }
}

