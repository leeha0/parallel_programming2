package chapter13;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Table {

    String[] dishNames = {
        "donut"
        , "donut"
        , "burger"
    }; // donut이 더 자주 나온다.
    final int MAX_FOOD = 6;

    private ArrayList<String> dishes = new ArrayList<>();

    public void addForEx1(String dish) {
        // 테이블에 음식이 가득차있으면, 테이블에 음식을 추가하지 않는다.
        if (dishes.size() >= MAX_FOOD) {
            return;
        }
        dishes.add(dish);
        System.out.println("Dishes:" + dishes.toString());
    }

    public boolean removeForEx1(String dishName) {
        // 지정된 요리와 일치하는 요리를 테이블에서 제거한다.
        for (int i = 0; i < dishes.size(); i++) {
            if (dishName.equals(dishes.get(i))) {
                dishes.remove(i);
                return true;
            }
        }
        return false;
    }

    public synchronized void addForEx2(String dish) {
        // 테이블에 음식이 가득차있으면, 테이블에 음식을 추가하지 않는다.
        if (dishes.size() >= MAX_FOOD) {
            return;
        }
        dishes.add(dish);
        System.out.println("Dishes:" + dishes.toString());
    }

    public boolean removeEx2(String dishName) {
        synchronized (this) {
            // 손님 쓰레드가 테이블 객체의 락을 쥐고 기다리기 때문에 요리사가 음식을 하지 못한다.
            while (dishes.size() == 0) { // 0.5초마다 음식이 추가되었는지 확인한다.
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            // 지정된 요리와 일치하는 요리를 테이블에서 제거한다.
            for (int i = 0; i < dishes.size(); i++) {
                if (dishName.equals(dishes.get(i))) {
                    dishes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized void addForEx3(String dish) {
        while (dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting.");
            try {
                wait(); // COOK 쓰레드를 기다리게 한다.
                Thread.sleep(500); // COOK 쓰레드?
            } catch (InterruptedException e) {
            }
        }
        dishes.add(dish);
        // Table의 Waiting Pool은 COOK, CUST가 함께 사용하기 때문에 누굴 깨울지 알 수 없다
        notify(); // 기다리고 있는 CUST를 깨우기 위함;
        System.out.println("Dishes:" + dishes.toString());
    }

    public void removeForEx3(String dishName) {
        synchronized (this) {
            String name = Thread.currentThread().getName();

            while (dishes.size() == 0) { // 0.5초마다 음식이 추가되었는지 확인한다.
                System.out.println(name + " is waiting.");
                try {
                    wait(); // CUST쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

            while (true) {
                // 지정된 요리와 일치하는 요리를 테이블에서 제거한다.
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        // Table의 Waiting Pool은 COOK, CUST가 함께 사용하기 때문에 누굴 깨울지 알 수 없다
                        notify(); // 잠자고 있는 COOK을 깨우기 위함
                        return;
                    }
                }

                try {
                    System.out.println(name + " is waiting.");
                    wait(); // 원하는 음식이 없는 CUST쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCust = lock.newCondition();

    public void addForEx4(String dish) {
        lock.lock();

        try {
            while (dishes.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting.");
                try {
                    forCook.await(); // wait(); COOK 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

            dishes.add(dish);
            forCust.signal(); // notify(); 기다리고 있는 CUST를 깨우기 위함.
            System.out.println("Dishes:" + dishes.toString());
        } finally {
            lock.unlock();
        }
    }

    public void removeForEx4(String dishName) {
        lock.lock();
        String name = Thread.currentThread().getName();

        try {
            while (dishes.size() == 0) {
                System.out.println(name + " is waiting.");
                try {
                    forCust.await(); // wait(); CUST 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        forCook.signal(); // notify(); 잠자고 있는 COOK을 깨움
                        return;
                    }
                }

                try {
                    System.out.println(name + " is waiting.");
                    forCust.await(); // wait(); // CUST 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public int dishNum() {
        return dishNames.length;
    }
}
