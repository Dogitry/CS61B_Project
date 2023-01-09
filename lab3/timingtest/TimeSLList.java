package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList <Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int opCount=0,time=0,N=0;
        SLList<Integer> L=new SLList<>();
        int opMax = 128001;
        int checkPoint=1000;
        int M =10000;
        for(N=0;N< opMax;N++) {
            L.addLast(0);
            if(N==checkPoint){
                Ns.addLast(N);
                Stopwatch sw = new Stopwatch();
                for(opCount=0;opCount<M;opCount++) {
                    L.getLast();
                }
                times.addLast(sw.elapsedTime());
                opCounts.addLast(M);
                checkPoint*=2;
            }
        }
        printTimingTable(Ns,times,opCounts);
        }

}
