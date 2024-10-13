
// 排序算法

import java.util.Arrays;

public class Sort {
    //插入排序
    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; ++i) {
            // 记录有序序列最后一个元素的下标
            int end = i;
            // 待插入的元素
            int tem = arr[end + 1];
            // 单趟排
            while (end >= 0) {
                // 比插入的数大就向后移
                if (tem < arr[end]) {
                    arr[end + 1] = arr[end];
                    end--;
                }
                // 比插入的数小，跳出循环
                else {
                    break;
                }
            }
            // tem放到比插入的数小的数的后面
            arr[end + 1] = tem;
            // 代码执行到此位置有两种情况:
            // 1. 待插入元素找到应插入位置（break跳出循环到此）
            // 2. 待插入元素比当前有序序列中的所有元素都小（while循环结束后到此）
        }
    }

     //希尔排序
    public static void shellSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        while (gap > 1) {
            //每次对gap折半操作
            gap = gap / 2;
            //单趟排序
            for (int i = 0; i < n - gap; ++i) {
                int end = i;
                int tem = arr[end + gap];
                while (end >= 0) {
                    if (tem < arr[end]) {
                        arr[end + gap] = arr[end];
                        end -= gap;
                    } else {
                        break;
                    }
                }
                arr[end + gap] = tem;
            }
        }
    }

    //选择排序
    // public static void selectionSort(int[] arr) {
    //     int n = arr.length;
    //     for (int i = 0; i < n - 1; i++) {
    //         int minIndex = i;
    //         for (int j = i + 1; j < n; j++) {
    //             if (arr[j] < arr[minIndex]) {
    //                 minIndex = j;
    //             }
    //         }
    //         int temp = arr[minIndex];
    //         arr[minIndex] = arr[i];
    //         arr[i] = temp;
    //     }
    // }
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int begin = 0;
        int end = n - 1;
        while (begin < end) {
            int min = begin;
            int max = begin;
            for (int i = begin; i <= end; ++i) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            int temp1 = arr[min];
            int temp2 = arr[max];
            arr[min] = arr[begin];
            arr[begin] = temp1;
            if (begin == max) {
                max = min;
            }
            arr[max] = arr[end];
            arr[end] = temp2;
            ++begin;
            --end;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr)
    {
        int end = arr.length;
        while (end>0)
        {
            int flag = 0;
            for (int i = 1; i < end; ++i)
            {
                if (arr[i - 1] > arr[i])
                {
                    int tem = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tem;
                    flag = 1;
                }
            }
            if (flag == 0)
            {
                break;
            }
            --end;
        }
    }

    //堆排序

    //快速排序
    public static void quickSort(int[] array, int low, int high){
        int i,j,pivot;
        //结束条件
        if (low >= high) {
            return;
        }
        i = low;
        j = high;
        //选择的节点，这里选择的数组的第一数作为节点
        pivot = array[low];
        while (i < j){
            //从右往左找比节点小的数，循环结束要么找到了，要么i=j
            while (array[j] >= pivot && i < j){
                j--;
            }
            //从左往右找比节点大的数，循环结束要么找到了，要么i=j
            while (array[i] <= pivot && i < j){
                i++;
            }
            //如果i!=j说明都找到了，就交换这两个数
            if (i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //i==j一轮循环结束，交换节点的数和相遇点的数
        array[low] = array[i];
        array[i] = pivot;
        //数组“分两半”,再重复上面的操作
        quickSort(array,low,i - 1);
        quickSort(array,i + 1,high);
    }

    //归并排序
    public static int[] mergeSort(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mSort(nums,0,len-1,temp);
        return nums;
    }
    /**
     * 递归函数对nums[left...right]进行归并排序
     * @param nums 原数组
     * @param left 左边的索引
     * @param right 右边记录索引位置
     * @param temp
     */
    public static void mSort(int[] nums, int left, int right, int[] temp) {
        if (left == right){//当拆分到数组当中只要一个值的时候，结束递归
            return;
        }
        int mid = (left+right)/2;   //找到下次要拆分的中间值
        mSort(nums,left,mid,temp);//记录树左边的
        mSort(nums,mid+1,right,temp);//记录树右边的

        //合并两个区间
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i]; 
        //temp就是辅助列表，新列表的需要排序的值就是从辅助列表中拿到的
        }
        int i = left;       //给辅助数组里面的值标点
        int j = mid +1;
        for (int k = left; k <= right ; k++) {//k 就为当前要插入的位置
            if (i == mid + 1){
                nums[k] = temp[j];
                j++;
            }else if (j == right+1){
                nums[k] = temp[i];
                i++;
            }
            else if (temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }else {
                nums[k] = temp[j];
                j++;
            }
        }
    }
  
    //计数排序
    public static void countSort(int[] arr) {
        int max = 0;
        int min = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];
        }


        
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{5,7,9,1,3};
        // insertSort(nums1);
        // shellSort(nums1);
        // selectionSort(nums1);
        // bubbleSort(nums1);
        quickSort(nums1, 0, nums1.length-1);
        // mergeSort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}



