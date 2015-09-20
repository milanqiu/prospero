package net.milanqiu.prospero.puddle;

/**
 * Creation Date: 2015-09-20
 * @author Milan Qiu
 */
public class PuddleSolutionPerfect {

    /**
     * <pre>
     * 算法原理：
     * 首先，左右指针指向墙的两端
     * 然后，将更低的那个指针向右或向左移动一格，如果移动后更高，则重新判断左右指针的高低关系，如果移动后更低，则该位置积水
     * 循环直到左右指针会面
     * </pre>
     */
    public static int solve(int[] wallsHeight) {
        if (wallsHeight.length <= 2)
            return 0;

        int result = 0;
        int left = 0;
        int right = wallsHeight.length - 1;
        int leftFenceHeight = wallsHeight[left];
        int rightFenceHeight = wallsHeight[right];

        while (left+1 < right) {
            if (leftFenceHeight < rightFenceHeight) {
                left++;
                if (leftFenceHeight <= wallsHeight[left])
                    leftFenceHeight = wallsHeight[left];
                else
                    result += leftFenceHeight - wallsHeight[left];
            } else {
                right--;
                if (rightFenceHeight <= wallsHeight[right])
                    rightFenceHeight = wallsHeight[right];
                else
                    result += rightFenceHeight - wallsHeight[right];
            }
        }

        return result;
    }
}
