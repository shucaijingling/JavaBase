package main.java.com.test.pojo;

public class TestStreamVO {

    int testKey;

    String value;

    boolean flag;

    public TestStreamVO() {
    }

    public TestStreamVO(int testKey, String value) {
        this.testKey = testKey;
        this.value = value;
    }

    public int getTestKey() {
        return testKey;
    }

    public void setTestKey(int testKey) {
        this.testKey = testKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TestStreamVO{" +
                "testKey=" + testKey +
                ", value='" + value + '\'' +
                '}';
    }
}
