package com.zhou.concurrent;

/**
 * Created by Administrator on 2016/12/29.
 */
public class StopThreadUnsafe {

    public static class User{
        private int id;
        private String name;

        public User() {
            id =0;
            name ="0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public static User u = new User();

    public static class ChangeObjectThread extends Thread{

        @Override
        public void run() {
            while (true){
                synchronized (u){
                    int v = (int) (System.currentTimeMillis()/1000);
                    u.setId(v);

                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }

                Thread.yield();
            }
        }
    }

    /**
     * 使用手动停止线程
     */
    public static class ChangeObjectThread1 extends Thread{

        volatile boolean stopme = false;

        public void stopMe(){
            stopme = true;
        }
        @Override
        public void run() {
            while (true){
                if (stopme){
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (u){
                    int v = (int)(System.currentTimeMillis()/1000);
                    u.setId(v);

                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    u.setName(String.valueOf(v));
                }

                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (u){
                    if (u.getId()!=Integer.parseInt(u.getName())){
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true){
            Thread t = new ChangeObjectThread1();
            t.start();

//            t.stopMe();

            Thread.sleep(150);
            /**
             * 停止线程会导致数据不一致
             */
//            t.stop();

        }
    }
}
