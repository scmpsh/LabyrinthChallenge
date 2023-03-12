package override.bot;

import override.logic.Direction;
import override.logic.GameState;
import override.logic.LabyrinthPlayer;

import static override.logic.GameState.*;

public class LabyrinthBot implements LabyrinthPlayer {

    private int myNumber;
    private int opNumber;
    private int w;
    private int h;

    @Override
    public void takeYourNumber(int number) {
        myNumber = number;
        if (myNumber == -1) {
            opNumber = -2;
        } else {
            opNumber = -1;
        }
    }

    @Override
    public Direction step(GameState gameState) {
        int[][] map = gameState.getMap();
        saveMyCurrentPosition(gameState);

        if ((w + 1) != WALL_NUMBER && (w + 1) != WIDTH && (w + 1) != opNumber) {
            return Direction.BOTTOM;
        } else {
            if ((w - 1) != WALL_NUMBER && (w - 1) != 0 && (w - 1) != opNumber) {
                return Direction.UP;
            }
            if ((h + 1) != WALL_NUMBER && (h + 1) != HEIGHT && (h + 1) != opNumber) {
                return Direction.RIGHT;
            }
            if ((h - 1) != WALL_NUMBER && (h - 1) != 0 && (h - 1) != opNumber) {
                return Direction.LEFT;
            }
        }

        if ((w - 1) != WALL_NUMBER && (w - 1) != 0 && (w - 1) != opNumber) {
            return Direction.UP;
        } else {
            if ((w + 1) != WALL_NUMBER && (w + 1) != WIDTH && (w + 1) != opNumber) {
                return Direction.BOTTOM;
            }
            if ((h + 1) != WALL_NUMBER && (h + 1) != HEIGHT && (h + 1) != opNumber) {
                return Direction.RIGHT;
            }
            if ((h - 1) != WALL_NUMBER && (h - 1) != 0 && (h - 1) != opNumber) {
                return Direction.LEFT;
            }
        }

        if ((h + 1) != WALL_NUMBER && (h + 1) != HEIGHT && (h + 1) != opNumber) {
            return Direction.RIGHT;
        } else {
            if ((h - 1) != WALL_NUMBER && (h - 1) != 0 && (h - 1) != opNumber) {
                return Direction.LEFT;
            }
            if ((w + 1) != WALL_NUMBER && (w + 1) != WIDTH && (w + 1) != opNumber) {
                return Direction.BOTTOM;
            }
            if ((w - 1) != WALL_NUMBER && (w - 1) != 0 && (w - 1) != opNumber) {
                return Direction.UP;
            }
        }

        if ((h - 1) != WALL_NUMBER && (h - 1) != 0 && (h - 1) != opNumber) {
            return Direction.LEFT;
        } else {
            if ((h + 1) != WALL_NUMBER && (h + 1) != HEIGHT && (h + 1) != opNumber) {
                return Direction.RIGHT;
            }
            if ((w + 1) != WALL_NUMBER && (w + 1) != WIDTH && (w + 1) != opNumber) {
                return Direction.BOTTOM;
            }
            if ((w - 1) != WALL_NUMBER && (w - 1) != 0 && (w - 1) != opNumber) {
                return Direction.UP;
            }
        }

        return Direction.NONE;
    }

    private void saveMyCurrentPosition(GameState gameState) {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (gameState.getMap()[i][j] == myNumber) {
                    w = i;
                    h = j;
                }
            }
        }
    }

    @Override
    public String getTelegramNick() {
        return "@scmpsh";
    }
}
