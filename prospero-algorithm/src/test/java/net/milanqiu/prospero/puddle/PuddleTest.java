package net.milanqiu.prospero.puddle;

import org.junit.Assert;
import org.junit.Test;

/**
 * Creation Date: 2015-09-20
 * @author Milan Qiu
 */
public class PuddleTest {

    private static final int TEST_DATA_COUNT = 9;

    private int[][] inputsWallsHeight = new int[][] {
            new int[] {},
            new int[] {5, 5},
            new int[] {3, 5, 5, 2},
            new int[] {3, 5, 5, 7, 5, 2},
            new int[] {5, 3, 5, 5, 7},
            new int[] {2, 5, 1, 2, 3, 4, 7, 7, 6},
            new int[] {2, 5, 1, 3, 1, 2, 1, 7, 7, 6},
            new int[] {2, 5, 1, 3, 1, 2, 1, 7, 3, 7, 4, 6},
            new int[] {6, 1, 4, 6, 7, 5, 1, 6, 4},
    };

    private int[] outputsVolume = new int[] {
            0,
            0,
            0,
            0,
            2,
            10,
            17,
            23,
            13,
    };

    @Test
    public void test_SolutionPerfect() throws Exception {
        for (int i = 0; i < TEST_DATA_COUNT; i++) {
            Assert.assertEquals(outputsVolume[i], PuddleSolutionPerfect.solve(inputsWallsHeight[i]));
        }
    }

    @Test
    public void test_SolutionA() throws Exception {
        for (int i = 0; i < TEST_DATA_COUNT; i++) {
            Assert.assertEquals(outputsVolume[i], PuddleSolutionA.solve(inputsWallsHeight[i]));
        }
    }
}
