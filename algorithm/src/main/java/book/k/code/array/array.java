package book.k.code.array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class array {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        int i = randomAccess(ints);
        System.out.println(i);


//        remove(ints, 1);
//        System.out.println(Arrays.toString(ints));

        int find = find(ints, 4);
        System.out.println(find);

        int[] extend = extend(ints, 3);
        System.out.println(extend.length);
        System.out.println(Arrays.toString(extend));

    }

    //随机获取数组中的元素
    static int randomAccess(int[] nums) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);

        return nums[randomIndex];
    }

    //插入
    static void insert(int[] nums, int num, int index) {
        // 把索引 index 以及之后的所有元素向后移动一位
        for (int i = nums.length - 1; i > index; i++) {
            nums[i] = nums[i - 1];
        }
        nums[index] = num;
    }

    //删除
    static void remove(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            //index 及之后的元素向前移动
            nums[i] = nums[i + 1];
        }
    }

    // find index which element equals target
    static int find(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //enlarge array
    static int[] extend(int[] nums, int enlarge) {

        int[] newArray = new int[nums.length + enlarge];

        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[i];
        }
        return newArray;
    }

}


