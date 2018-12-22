package com.ming.MiddleLayer;

/**
 * @author ming
 * 对于中介者再次抽象
 */
public abstract class AbstractColleague {
    protected AbstractMiddleLayer middleLayer;
    public AbstractColleague(AbstractMiddleLayer middleLayer){
        this.middleLayer = middleLayer;
    }
}
