package com.community.controller.entity;

import com.community.entity.Result;

import java.util.*;

public class LayuiResult extends Result {
    private long count;
    private List<?> data;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }


}
