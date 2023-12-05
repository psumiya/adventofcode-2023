package puzzle.solutions.day.two;

import static puzzle.solutions.utils.Utils.isNullOrBlank;

public class P1 {

    public static int solve(String games, int red, int green, int blue) {
        if (isNullOrBlank(games)) {
            return 0;
        }
        return process(games, red, green, blue);
    }

    private static int process(String games, int red, int green, int blue) {
        int maxRed = 0, maxBlue = 0, maxGreen = 0;
        String[] gamesArr = games.split("\n");
        for (int i = 0; i < gamesArr.length; i++) {
            String game = gamesArr[i];
            String trimPrefix = game.substring(game.indexOf(":") + 2);
            String[] cubeSet = trimPrefix.split(";");
            for (String cubesGroup : cubeSet) {
                String[] cubes = cubesGroup.split(",");
                for (String cube : cubes) {
                    if (cube.contains("red")) {
                        int count = Integer.valueOf(cube.replaceAll("red", "").trim());
                        if (count > maxRed) {
                            maxRed = count;
                        }
                    } else if (cube.contains("green")) {
                        int count = Integer.valueOf(cube.replaceAll("green", "").trim());
                        if (count > maxGreen) {
                            maxGreen = count;
                        }
                    } else if (cube.contains("blue")) {
                        int count = Integer.valueOf(cube.replaceAll("blue", "").trim());
                        if (count > maxBlue) {
                            maxBlue = count;
                        }
                    } else {
                        throw new RuntimeException("Unexpected cube color found, game=" + cube);
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < gamesArr.length; i++) {
            String game = gamesArr[i];
            String trimPrefix = game.substring(game.indexOf(":") + 2);
            String[] cubeSet = trimPrefix.split(";");
            boolean isGamePossible = true;
            for (String cubesGroup : cubeSet) {
                String[] cubes = cubesGroup.split(",");
                for (String cube : cubes) {
                    if (cube.contains("red")) {
                        int count = Integer.valueOf(cube.replaceAll("red", "").trim());
                        if (count > red) {
                            isGamePossible = false;
                            break;
                        }
                    } else if (cube.contains("green")) {
                        int count = Integer.valueOf(cube.replaceAll("green", "").trim());
                        if (count > green) {
                            isGamePossible = false;
                            break;
                        }
                    } else if (cube.contains("blue")) {
                        int count = Integer.valueOf(cube.replaceAll("blue", "").trim());
                        if (count > blue) {
                            isGamePossible = false;
                            break;
                        }
                    } else {
                        throw new RuntimeException("Unexpected cube color found, game=" + cube);
                    }
                }
                if (!isGamePossible) {
                    break;
                }
            }
            if (isGamePossible) {
                String indexStr = game.substring(5, game.indexOf(":"));
                int index = Integer.parseInt(indexStr);
                result += index;
            }
        }
        return result;
    }

}
