
class InsertionSortSolution{
    public void insertionsort(int[] arr){
        int n = arr.length;

        for(int i=0;i<n;i++){
            int j = i;
            int temp = arr[i];
            while(j > 0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }

        for(int i=0;i<n;i++) System.out.print(arr[i] + "  ");
    }
}

public class insertionsort {
    public static void main(String[] args){
        int[] arr = {7,4,1,2,8};

        InsertionSortSolution solution = new InsertionSortSolution();
        solution.insertionsort(arr);
    }
}
