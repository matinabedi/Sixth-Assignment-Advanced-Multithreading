package sbu.cs.CalculatePi;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PiCalculator {

    public static class CalculateSegment implements Runnable {

        private  int i;
        private  MathContext mc;
        private BigDecimal ans;
        private BigDecimal kasr;
        private BigDecimal b1;
        private BigDecimal b2;
        private BigDecimal b3;
        private BigDecimal b4;
        private BigDecimal bsum;

        public CalculateSegment(int i, int mc) {
            this.i = i;
            this.mc = new MathContext(mc);
        }

        @Override
        public void run() {
             kasr=new BigDecimal("1");
             kasr= kasr.divide(new BigDecimal("16").pow(i),mc);

             b1= new BigDecimal(4);
             b1= b1.divide(new BigDecimal(8*i+1),mc);

             b2= new BigDecimal(-2);
             b2= b2.divide(new BigDecimal(8*i+4),mc);

             b3= new BigDecimal(-1);
             b3= b3.divide(new BigDecimal(8*i+5),mc);

             b4= new BigDecimal(-1);
             b4= b4.divide(new BigDecimal(8*i+6),mc);
             bsum=b1.add(b2).add(b3).add(b4);
             ans= kasr.multiply(bsum);
             addToSum(ans);
        }
    }

    private static BigDecimal sum = BigDecimal.ZERO;

    public static synchronized void addToSum(BigDecimal value) {
        sum = sum.add(value);
    }

    public static String calculate(int floatingPoint) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        floatingPoint=floatingPoint+1;
        for (int i = 0; i < 10000; i++) {
            CalculateSegment task = new CalculateSegment(i, floatingPoint);
            threadPool.execute(task);
        }

        threadPool.shutdown();
        try {
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sum.round(new MathContext(floatingPoint)).toString();
    }

    public static void main(String[] args) {
        System.out.println(calculate(7));
    }
}
