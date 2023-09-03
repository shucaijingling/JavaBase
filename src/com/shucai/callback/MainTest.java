package com.shucai.callback;

public class MainTest {

    public static void main(String[] args) {

        AsyncTask task = new AsyncTask();
        task.excute(new Callback() {
            @Override
            public void onComplete(String result) {
                System.out.println("result: " + result);
            }
        });
    }
}
