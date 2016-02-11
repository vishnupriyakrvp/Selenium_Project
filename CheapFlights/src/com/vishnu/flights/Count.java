package com.vishnu.flights;

import java.util.ArrayList;
import java.util.List;


public class Count {

    public static int N=6;

    public static void main(String[] args){

        List<Integer> listOfNum=new ArrayList <Integer>(N);

        listOfNum.add(1);
        listOfNum.add(5);
        listOfNum.add(9);
        listOfNum.add(1);
        listOfNum.add(9);
        listOfNum.add(5);
        sortList(listOfNum);
        System.out.println(listOfNum);

    }

    public static void sortList(List<Integer> ls){
        int count_1=0;
        int count_5=0;
        int count_9=0;


        for(int i=0;i<N;i++){
            if(ls.get(i)==1)
                count_1++;
            if(ls.get(i)==5)
                count_5++;
            if(ls.get(i)==9)
                count_9++;

        }
        int j=0;
        for(int i=1;i<=count_1;i++){
            ls.remove(j);
            ls.add(j,1);
            j++;
        }
        for(int i=1;i<=count_5;i++){
            ls.remove(j);
            ls.add(j,5);
            j++;
        }
        for(int i=1;i<=count_9;i++){
            ls.remove(j);
            ls.add(j,9);
            j++;
        }

    }
}

