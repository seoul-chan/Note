package Algorithm;

import java.util.Arrays;

class MinHeap{
    private int[] data;
    private int size;

    //1.
    public MinHeap(){
        this.data = new int[101];
        this.size = 1;
        this.data[0] = 0;
    }
    public MinHeap(int data){
        this.data = new int[data+1];
        this.size = 1;
        this.data[0] = 0;
    }
    //2.
    public void insert(int newInt){
        int pointer=0;

        if(isFull()){       //3.
            System.out.println("Heap is Full -> " + newInt);
        } else {
            this.data[size] = newInt;
            pointer = size;
            size++;

            while (pointer>1 && this.data[pointer/2]>this.data[pointer]) {    //4.
                int temp = this.data[pointer/2];
                this.data[pointer/2] = this.data[pointer];
                this.data[pointer] = temp;
    
                pointer/=2;   //4-1.
            }
        }
    }
    //5.
    public int remove(){   
        int pointer = 1, delete = 0;

        if(isEmpty()){  //6.
            System.out.println("Heap is Enpty");
        } else {
            delete = this.data[1];
            this.data[1] = this.data[--size];
            this.data[size]=0;
            //7.
            while(pointer*2<size){
                int min = this.data[pointer*2];     //8.
                int minPoin = pointer * 2;
                //9.
                if(pointer*2+1<size&&this.data[pointer*2+1]<min){
                    min = this.data[pointer*2+1];
                    minPoin = pointer*2+1;
                }

                if(this.data[pointer]<min) break;   //10.
                //11.
                int temp = min;
                this.data[minPoin] = this.data[pointer];
                this.data[pointer] = temp;

                pointer = minPoin;  //12.
            }
        }
        return delete;      //13.
    }
    public boolean isFull(){
        return size==this.data.length;
    }
    public boolean isEmpty(){
        return size==1;
    }
    public void order(){
        System.out.println();
        System.out.print(Arrays.toString(this.data));
        System.out.println();
    }

}

public class MinHeapArray {
    public static void main(String[] args) {
        int count = 10;
        MinHeap heap = new MinHeap(count);
       
        for(int i=0;i<count;i++){
            int value = (int)(Math.random()*100)+1;
            System.out.print(" " + value);
            heap.insert(value);
        }

        heap.order();

        for(int i=0;i<count;i++){
            System.out.print(" "+heap.remove());
        }
    }
}
