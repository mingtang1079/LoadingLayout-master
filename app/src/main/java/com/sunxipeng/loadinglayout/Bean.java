package com.sunxipeng.loadinglayout;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
public class Bean {

    public  String name;
    List<String> mStrings;

    public Bean(String mName, List<String> mStrings) {
        name = mName;
        this.mStrings = mStrings;
    }

    public Bean() {

    }
}
