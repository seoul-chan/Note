package Algorithm;

import java.util.Arrays;

class MaxHeap {
    private int[] data;
    private int size;

    public MaxHeap(){
        this.data = new int[101];
        this.size = 1;
        this.data[0] = 0;
    }

    public MaxHeap(int data){
        this.data = new int[data+1];
        this.size = 1;
        this.data[0] = 0;
    }  
    public void insert(int newInt){
        int pointer=0;
        if(isFull()){
            System.out.println("Heap is Full -> " + newInt);
        } else {
            this.data[size] = newInt;
            pointer = size;
            size++;

            while (pointer>1&&this.data[pointer/2]<this.data[pointer]) {
                int temp = this.data[pointer/2];
                this.data[pointer/2] = this.data[pointer];
                this.data[pointer] = temp;

                pointer/=2;
            }
        }
    }
    public int remove(){
        int pointer=1, delete=0;

        if(isEmpty()){
            System.out.println("Heap is Empty!!");
        } else {
            delete = this.data[1];
            this.data[1] = this.data[--size];
            this.data[size]=0;
            
            while(pointer*2<size){
                int max = this.data[pointer*2];
                int maxPoin = pointer*2;

                if(pointer*2+1<size&&this.data[pointer*2+1]>max){
                    max = this.data[pointer*2+1];
                    maxPoin = pointer*2+1;
                }
                
                if(this.data[pointer]>max) break;

                int temp = max;
                this.data[maxPoin] = this.data[pointer];
                this.data[pointer] = temp;

                pointer=maxPoin;
            }
        }
        return delete;
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

public class MaxHeapArray {
    public static void main(String[] args) {
        int count = 10;
        MaxHeap heap = new MaxHeap(count);
        
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
