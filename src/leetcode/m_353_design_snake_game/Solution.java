package leetcode.m_353_design_snake_game;

//https://leetcode.com/problems/design-snake-game/description/

import java.util.*;

class Cell {
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class SnakeGame {
    private final int height;
    private final int width;
    private final int[][] food;

    private int score;
    private int foodIndex;
    private final Deque<Cell> snakeBody = new ArrayDeque<>();
    private final Set<Cell> snakeBodyOccupiedCellsSet = new HashSet<>();

    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.food = food;

        Cell start = new Cell(0, 0);
        snakeBody.offer(start);
        snakeBodyOccupiedCellsSet.add(start);
    }

    public int move(String direction) {
        if (score == -1) {
            return -1;
        }

        Cell head = snakeBody.peekFirst();

        assert head != null;
        Cell nextHead = new Cell(head.x, head.y);
        switch (direction) {
            case "U":
                nextHead.x--;
                break;
            case "D":
                nextHead.x++;
                break;
            case "L":
                nextHead.y--;
                break;
            case "R":
                nextHead.y++;
                break;
        }

        if (nextHead.x < 0 || nextHead.x >= height || nextHead.y < 0 || nextHead.y >= width) {
            return -1;
        }

        if (foodIndex < food.length && nextHead.x == food[foodIndex][0] && nextHead.y == food[foodIndex][1]) {
            score++;
            foodIndex++;
        } else {
            Cell tail = snakeBody.pollLast();
            snakeBodyOccupiedCellsSet.remove(tail);
        }

        if (snakeBodyOccupiedCellsSet.contains(nextHead)) {
            return -1;
        }

        snakeBody.offerFirst(nextHead);
        snakeBodyOccupiedCellsSet.add(nextHead);
        return score;
    }

    public static void main(String[] args) {
//        String[] sequence = {"SnakeGame", "move", "move", "move", "move", "move", "move"};
//        String[][] input = {{}, {"R"}, {"D"}, {"R"}, {"U"}, {"L"}, {"U"}};
//        int width = 3, height = 2;
//        int[][] food = {{1, 2}, {0, 1}};

        String[] sequence = {"SnakeGame", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move", "move" };
        String[][] input = {{}, {"D" }, {"D" }, {"R" }, {"U" }, {"U" }, {"L" }, {"D" }, {"R" }, {"R" }, {"U" }, {"L" }, {"L" }, {"D" }, {"R" }, {"U" }};
        int width = 3, height = 3;
        int[][] food = {{2, 0}, {0, 0}, {0, 2}, {0, 1}, {2, 2}, {0, 1}};

        SnakeGame snakeGame = null;
        int inputIndex = 0;
        for (String s : sequence) {
            switch (s) {
                case "SnakeGame":
                    snakeGame = new SnakeGame(width, height, food);
                    inputIndex++;
                    break;
                case "move":
                    assert snakeGame != null;
                    System.out.println(snakeGame.move(input[inputIndex][0]));
                    inputIndex++;
                    break;
            }
        }
    }
}