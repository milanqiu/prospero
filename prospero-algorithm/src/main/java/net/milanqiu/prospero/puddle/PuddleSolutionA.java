package net.milanqiu.prospero.puddle;

/**
 * Creation Date: 2015-09-20
 * @author Milan Qiu
 */
public class PuddleSolutionA {

    /**
     * <pre>
     * 算法原理：
     * 首先，左右指针分别移至左右的第一个极点
     * 然后，从更低的那个极点开始，向右或向左找到下一个更高的点，该极点和该更高点之间的区域就会以该极点为水面高度积水
     * 循环直到左右指针会面
     * </pre>
     */
    public static int solve(int[] wallsHeight) {
        if (wallsHeight.length <= 2)
            return 0;

        int result = 0;
        int left = 0;
        int right = wallsHeight.length - 1;
        int leftHeight;
        int rightHeight;
        int fenceHeight;

        // 左右指针分别移至左右的第一个极点
        while ((left < wallsHeight.length-1) && (wallsHeight[left+1] >= wallsHeight[left])) left++;
        while ((right > 0) && (wallsHeight[right-1] >= wallsHeight[right])) right--;
        leftHeight = wallsHeight[left];
        rightHeight = wallsHeight[right];

        while (left < right) {
            if (leftHeight < rightHeight) {
                fenceHeight = leftHeight;
                // 寻找后一个更高的点
                while ((left+1 < right) && (wallsHeight[left+1] <= fenceHeight)) {
                    left++;
                    result += fenceHeight - wallsHeight[left];
                }
                left++;
                leftHeight = wallsHeight[left];
            } else {
                fenceHeight = rightHeight;
                // 寻找前一个更高的点
                while ((left < right-1) && (wallsHeight[right-1] <= fenceHeight)) {
                    right--;
                    result += fenceHeight - wallsHeight[right];
                }
                right--;
                rightHeight = wallsHeight[right];
            }
        }

        return result;
    }
}
