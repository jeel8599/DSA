
class BubbleSortSolution{
    public void bubblesort(int[] arr){
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i=0;i<n;i++) System.out.print(arr[i] + " ");
    }
}

public class bubblesort {
    public static void main(String[] args){
        int[] arr = {7,4,1,2,8};

        BubbleSortSolution solution = new BubbleSortSolution();
        solution.bubblesort(arr);
    }
}
