package cn.com.factory;

import cn.com.bean.Page;

public class PageFactory {
    public static Page getPageInstance(int pageNum, int pageSize, int totalRecord){
        return new Page( pageNum, pageSize, totalRecord);
    }
}
