package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> Lc = new AListNoResizing<>();
        BuggyAList<Integer> Lb = new BuggyAList();
        Lc.addLast(4);
        Lb.addLast(4);
        Lc.addLast(5);
        Lb.addLast(5);
        Lc.addLast(6);
        Lb.addLast(6);
        assertEquals(Lc.removeLast(),Lb.removeLast());
        assertEquals(Lc.removeLast(),Lb.removeLast());
        assertEquals(Lc.removeLast(),Lb.removeLast());
    }
    @Test
    public void randomsizedTest() {
        AListNoResizing<Integer> Lc = new AListNoResizing<>();
        BuggyAList<Integer> Lb = new BuggyAList();

        int N = 5000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                //addLast
                int randVal = StdRandom.uniform(0, 700);
                Lc.addLast(randVal);
                Lb.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                assertEquals(Lc.size(), Lb.size());
            } else if (operationNumber == 2) {
                if (Lc.size() != 0)
                    assertEquals(Lc.removeLast(), Lb.removeLast());
            } else if (operationNumber == 3) {
                if (Lc.size() != 0)
                    assertEquals(Lc.getLast(), Lb.getLast());
            }
        }
    }
}
