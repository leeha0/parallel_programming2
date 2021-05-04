package liveness.starvation;

public class Starvation {

    static class Together {

        public synchronized void eat(Person person) {
            try {
                System.out.println(person.getPersonName() + " is eating");
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    interface Person {

        String getPersonName();
    }

    static class HeavyEater extends Thread implements Person {

        private final String name;
        private final Together together;

        public HeavyEater(String name, Together together) {
            this.name = name;
            this.together = together;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                together.eat(this);
            }
        }

        @Override
        public String getPersonName() {
            return name;
        }
    }

    static class LittleEater extends Thread implements Person {

        private final String name;
        private final Together together;

        public LittleEater(String name, Together together) {
            this.name = name;
            this.together = together;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                together.eat(this);
            }
//            try {
//                Thread.sleep(5000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            together.eat(this);
        }

        @Override
        public String getPersonName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Together together = new Together();

        LittleEater p1 = new LittleEater("이하영", together);
        p1.setPriority(Thread.MIN_PRIORITY);
        p1.start();

        HeavyEater p2 = new HeavyEater("장윤진", together);
        p2.setPriority(Thread.MAX_PRIORITY);
        p2.start();
    }
}
