import java.util.Random;

class Case1 {
    static double case1(double[] input) {
        double result = 0;
        for (int i = 0; i < input.length; i++) {
            result += Math.sin(input[i]) / Math.cos(input[i]);
        }
        return result;
    }
};

class Case2 {
    static double case2 ( double[] input){
        double result = 0;
        for (int i = 0; i < input.length; i++) {
            result += Math.sin(input[i]) / Math.cos(input[i]);
        }
        return result;
    }
};

class Case3 {
    static double case3 ( double[] input){
        double result = 0;
        for (int i = 0; i < input.length; i++) {
            result += Math.sin(input[i]) / Math.cos(input[i]);
        }
        return result;
    }
};

class Case4{
    static double case4 ( double[] input){
        double result = 0;
        for (int i = 0; i < input.length; i++) {
            result += Math.sin(input[i]) / Math.cos(input[i]);
        }
        return result;
    }
};

public class CompileStashingAdvantage {

    static double blackhole;


    static double method1(double[] input, int phase) {

        if (phase == 1) {
            return Case1.case1(input);
        } else {
            if (phase == 2) {
                return Case2.case2(input);
            } else {
                if (phase == 3) {
                    return Case3.case3(input);
                } else {
                    return Case4.case4(input);
                }
            }
        }

    }
    public static void main(String[] args) {

        double[] input = new double[5000];
        for (int j=0; j < input.length ; j++ ) {
            input[j] = 0.1 + 0.9 * Math.random();
        }


        long[] times;


        int duration = 90000;
        int warmedup = 60000;
        times = new long[duration];
        long worsetime = 0;

        int phase_chnage_iteration_pase = 5000;

        int phase = 1;

        for (int j=0; j < duration ; j++ ) {
            long l = java.lang.System.nanoTime();

            if (( j > warmedup ) && ((j - warmedup) % phase_chnage_iteration_pase ==0) && (phase < 4)) {
                phase++;
            }
            blackhole = method1(input, phase);

            times[j] = java.lang.System.nanoTime() - l;

            if (j == warmedup)
                worsetime = times[j];
            worsetime = Math.max(worsetime, times[j]);
        }

        long cummultive = 0;
        for (int j=warmedup; j < duration; j++ ) {


            cummultive += times[j];
        }
        cummultive = cummultive  / (duration - warmedup);

        System.out.println("Score: " + cummultive + " ns / op");
        System.out.println("Worse time: " + worsetime + " ns");

    }
}
