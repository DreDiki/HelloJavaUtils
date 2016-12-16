package com.drediki.exp.chainmail;

/**
 * Created by DreDiki on 2016/12/16.
 * @deprecated use java comparable instead;
 */
@Deprecated
public interface MyCompare <E> {
    /**
     * Comapre = =
     * @return 0 for Equal ; <0 for a<b ; >0 for a>b
     */
    int Compare(E a,E b);
}