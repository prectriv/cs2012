public class Main {
    public static void main(String[] args) {
        double[][] numbers = new double[3][4]; // no size given size in type info, so we can make it however we choose.
        numbers[1] = new double[]{1.0d, 2.0d}; // Size can be changed via assignment statements
        numbers[2][1] = 5.0d;                  // setting specific segment of the array

        double[] newRow = {10.0d, 11.0d, 12.0d};
        double[][] numbers2 = {
                {1.0d, 2.0d, 3.0d},
                {4.0d, 5.0d, 6.0d},
                {7.0d, 8.0d, 9.0d},
                newRow
            };
        //looping through it - nested for loop.

        for(int i = 0; i < numbers2.length; i++){
            //double[] row = numbers2[i];
            for(int col = 0; col < numbers2[i].length/* could be row instead*/; col++){
                System.out.println(numbers2[i][col]);
            };
        };
    }
}