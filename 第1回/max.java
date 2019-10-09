public class max {

    public static double max(double[] array) {
        double y = array[0];
   
        for (int i = 0; i < array.length; i++) {
            if (y < array[i]) {
                y = array[i];
            }
        }
        return y;
    }
public static void main(String[] args) { 
    double[] array = new double[Integer.parseInt(args[0]) ];
    for (int i = 0; i < array.length; i++) {
        array[i]=Math.random();
    }

    long start = System.currentTimeMillis();
    double max= max(array); 
    long stop = System.currentTimeMillis();

    System.out.println("Max: "+max);
    System.out.println("Time: " + (double) (stop - start) + "s");
    }
}