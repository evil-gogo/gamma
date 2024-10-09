package companies.oracle.alternate_threads;

class Solution {
    static int counter = 1;

    public static void main(String[] args) {
        Object lock = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                while (counter <= 20) {
                    synchronized (lock) { // Acquire
                        System.out.println("Thread 1 " + counter);
                        counter++;
                        lock.notify(); // Release
                        try {
                            lock.wait(); // Wait
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                while (counter <= 20) {
                    synchronized (lock) { // Acquire
                        System.out.println("Thread 2 " + counter);
                        counter++;
                        lock.notify(); // Release
                        try {
                            if (counter <= 20) {
                                lock.wait(); // Wait
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        //thread1.setDaemon(true);
        thread1.start();


        //thread2.setDaemon(true);
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main Counter " + counter);
    }
}

//Thread 1 - 1
//Thread 2 - 2
//Thread 1 - 3
//Thread 2 - 4
//
//
//Till 20