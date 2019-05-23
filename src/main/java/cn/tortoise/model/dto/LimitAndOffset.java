package cn.tortoise.model.dto;

import cn.tortoise.constant.CommonConstant;

import javax.servlet.http.HttpServletRequest;

public class LimitAndOffset {
    private Integer limit;
    private Integer offset;

    HttpServletRequest request;

    public LimitAndOffset(HttpServletRequest request){
        this.request = request;
        get();
    }

    private void get(){
        try {
            offset = Integer.valueOf(request.getParameter("offset"));
            limit = Integer.valueOf(request.getParameter("limit"));
        } catch (Exception e) {
            offset = 0;
            limit = CommonConstant.MAX_QUERY_NUM;
        }
    }

    public int getLimit(){
        return limit;
    }

    public int getOffset(){
        return offset;
    }
}
