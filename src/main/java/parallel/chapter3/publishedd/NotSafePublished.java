package parallel.chapter3.publishedd;

public class NotSafePublished {

    // 안전하지 않은 객체 공개
    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }

    public class Holder {

        private int n;

        public Holder(int n) {
            this.n = n;
        }

        public void assertSanity() {
            if (n != n)
                throw new AssertionError("This statement is false.");
        }
    }
}
