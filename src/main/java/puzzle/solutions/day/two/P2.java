package puzzle.solutions.day.two;

import static puzzle.solutions.utils.Utils.isNullOrBlank;

public class P2 {

    public static int solve(String games) {
        if (isNullOrBlank(games)) {
            return 0;
        }
        return process(games);
    }

    private static int process(String games) {
        String[] gamesArr = games.split("\n");
        int result = 0;
        for (int i = 0; i < gamesArr.length; i++) {
            String game = gamesArr[i];
            String trimPrefix = game.substring(game.indexOf(":") + 2);
            String[] cubeSet = trimPrefix.split(";");
            int maxRed = 1, maxBlue = 1, maxGreen = 1;
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
            result += (maxRed * maxGreen * maxBlue);
        }
        return result;
    }

}
