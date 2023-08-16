
class SelectionSortSolution{
    public void selectionsort(int[] arr){
        int n = arr.length;
        int min_index = 0;

        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE;
            min_index = i;
            for(int j=i;j<n;j++){
                if(min > arr[j]){
                    min = Math.min(min,arr[j]);
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }

        for(int i=0;i<n;i++) System.out.print(arr[i] + " ");

    }
}

public class selectionsort {
    public static void main(String[] args){
        int[] arr = {7,4,1,2,8};

        SelectionSortSolution solution = new SelectionSortSolution();
        solution.selectionsort(arr);
    }
}
