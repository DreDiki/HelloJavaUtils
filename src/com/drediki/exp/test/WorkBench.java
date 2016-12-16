package com.drediki.exp.test;

import com.drediki.exp.Magazine;
import com.drediki.exp.MagazineList;

/**
 * Created by DreDiki on 2016/12/1.
 */
public class WorkBench {
    public static void main(String [] blablablabla){
        long duration ;
        //Test Magazine;
        RandomInit randomInit = new RandomInit();
        MagazineList rack = new MagazineList();
        for(int i = 0;i<100000;i++){
            rack.add(new Magazine(randomInit.createRandomName()));
        }
        duration = System.currentTimeMillis();
        rack.sort();
        duration = System.currentTimeMillis() - duration;
//        pl(rack);
        pl(duration);
    }



    public static void p(Object o){
        System.out.print(o);
    }
    public static void pl(Object o){
        System.out.println(o);
    }
}
