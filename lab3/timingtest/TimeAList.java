package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> L = new AList<>();
        AList<Integer> Ns = new AList<>();
        AList <Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int N=0,time=0,opCount=0;
        Stopwatch sw = new Stopwatch();
        int opMax = 100000;
        int checkPoint=1000;
        for(opCount=0;opCount< opMax;opCount++) {
            L.addLast(0);
            N++;
            if(N==checkPoint){
                    Ns.addLast(N);
                    times.addLast(sw.elapsedTime());
                    opCounts.addLast(opCount+1);
                    checkPoint*=2;
            }
        }
        printTimingTable(Ns,times,opCounts);
        // TODO: YOUR CODE HERE
    }
}
