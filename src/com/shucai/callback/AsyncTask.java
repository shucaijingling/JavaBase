package com.shucai.callback;


public class AsyncTask {

    public void excute(Callback callback) {
        new Thread(() -> {

            try {
                Thread.sleep(2000);
                System.out.println("async task complete");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String result = "callback - data - 1314";
            callback.onComplete(result);
        }).start();
    }
}
