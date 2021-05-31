package parallel.chapter4;

import parallel.annotation.NotThreadSafe;

@NotThreadSafe
public class MutablePoint {

    public int x, y;

    public MutablePoint(int x, int y) {
        this.x = 0;
        this.y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
