import java.util.LinkedList;
public class Fib {
    /**
     * Makes the fib sequence 0 1 1 2 3 5 ... f(n-2)+f(n-1)
     * @param n n >= 2
     * @return
     */
    public static int[] fib(int n){

        int[] answer = new int[n+1];
        answer[0] = 0;
        answer[1] = 1;

        for(int i = 2; i < answer.length ; i++){
            answer[i] = answer[i-1] + answer[i-2];
        }

        return answer;
    }

    public static LinkedList<Integer> fib2(int n){
        LinkedList<Integer> answer = new LinkedList<Integer>();
        answer.add(0);
        answer.add(1);
        for(int i = 2; i < n+1; i++){
            answer.add(answer.get( i - 1) + answer.get(i - 2));
        }
        return answer;
    }

    /**
     * Find the biggest number in a list
     * @param list a list of integers
     * @return the biggest number in the list or the smallest possible int if the list is empty
     */
    public static int biggest(LinkedList<Integer> list){
        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < list.size(); i++){
            if(answer < list.get(i)){   // I accidentally had > before and didn't realize, oops! My test helped me see that I made a mistake.
                answer = list.get(i);  // I'm glad I wrote the test before I wrote more code that depended on biggest()
            }
        }
        return answer;
    }


}
