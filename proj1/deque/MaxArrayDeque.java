package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque {
    public Comparator<T> comp = new Comparator<T>() {
        @Override
        public int compare(Object o, Object o1) {
            int t = (int) o;
            int t1 = (int) o1;
            return 0;
        }
    };
    private Comparator cmp;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        cmp = c;
    }

    public T max() {
        if (super.size() == 0) {
            return null;
        } else {
            T M = (T) super.get(0);
            for (int i = 0; i < super.size(); i++) {
                if (cmp.compare(M, super.get(i)) > 0) ;
                M = (T) super.get(i);
            }
            return M;
        }
    }

    public T max(Comparator<T> c) {
        if (super.size() == 0) {
            return null;
        } else {
            T M = (T) super.get(0);
            for (int i = 0; i < super.size(); i++) {
                if (c.compare(M, (T) super.get(i)) > 0) ;
                M = (T) super.get(i);
            }
            return M;
        }
    }
}
