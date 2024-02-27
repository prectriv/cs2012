public class Design {
    /**
     * Get the lowest and highest tempoerature and return a Temps object
     * @param temps is a list of double[][] of temps
     * @return a Temps object.
     */

    public static Temps getTemps(double[][] temps) {
        double answerLow = Double.POSITIVE_INFINITY;
        double answerHigh = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < temps.length; i++) {
            for (int col = 0; col < temps[i].length; col++) {
                if (temps[i][col] < answerLow) answerLow = temps[i][col];
                else if (temps[i][col] > answerHigh) answerHigh = temps[i][col];

            }

        }
        return new Temps(answerLow, answerHigh);
    }

}
