package book.k.code.list;

import java.util.Arrays;

public class MyList {
    private int[] nums;
    private int capacity = 10;
    private int size = 0;
    private int extendRatio = 2;

    public MyList() {
        nums = new int[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public int get(int index) {
        // 索引如果越界则抛出异常
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index outof bound");
        }
        return nums[index];
    }

    public void set(int index, int num) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index outof bound");
        }
        nums[index] = num;
    }

    /**
     * 尾部添加元素
     */
    public void add(int num) {
        // 元素数量超出容量时，触发扩容机制
        if (size == capacity()) extendCapacity();
        nums[size] = num;
        size++;
    }

    /**
     * 扩容列表
     */
    private void extendCapacity() {
        nums = Arrays.copyOf(nums, capacity() * extendRatio);
        capacity = nums.length;
    }

    /**
     * 中间插入元素
     */
    public void insert(int index, int num) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index outOf bound");
        }

        if (size == capacity()) extendCapacity();
        // 将索引 index 以及之后的元素都向后移动一位
        for (int j = size - 1; j >= index; j--) {
            nums[j + 1] = nums[j];
        }
        nums[index] = num;
        size++;
    }

    /**
     * 删除元素
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("error");
        }

        int num = nums[index];
        for (int i = index; i < size - 1; i++) {
            nums[i] = nums[i + 1];
        }
        size--;
        return num;
    }

    /**
     * 将列表转换为数组
     */
    public int[] toArray() {
        int size = size();

        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = get(i);
        }
        return nums;
    }
}
