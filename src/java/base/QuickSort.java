package base;

/** 快速排序
 * @author sjf0115
 * @Date Created in 下午5:24 18-3-27
 */
public class QuickSort {

    /**
     * 分割点
     * @param array
     * @param start
     * @param end
     * @return
     */
    int partition(int array[], int start, int end){

        int x = array[end];
        int i = start - 1;
        int tmp;
        for(int j = start;j < end;j++){
            if(array[j] < x){
                i++;
                tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }

        tmp = array[i+1];
        array[i+1] = array[end];
        array[end] = tmp;

        return i+1;

    }

    /**
     * 快速排序
     * @param array
     * @param start
     * @param end
     */
    void quickSort(int array[], int start, int end){

        if(start > end || array == null){
            return;
        }
        int index = partition(array, start, end);
        quickSort(array, start, index-1);
        quickSort(array, index+1, end);

    }

    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();
        int array[] = {4,1,6,3,9,0};
        quickSort.quickSort(array, 0, 5);
        for(int num : array){
            System.out.println(num);
        }

    }
}
