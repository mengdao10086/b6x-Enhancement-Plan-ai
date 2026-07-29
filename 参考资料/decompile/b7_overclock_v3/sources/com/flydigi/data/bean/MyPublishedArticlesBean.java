package com.flydigi.data.bean;

import com.flydigi.data.bean.community.ArticleBean;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class MyPublishedArticlesBean {

    @SerializedName("list")
    private List<ArticleBean> list;

    @SerializedName("page")
    private int page;

    @SerializedName("total")
    private int total;

    @SerializedName("total_page")
    private int totalPage;

    public List<ArticleBean> getList() {
        return this.list;
    }

    public int getPage() {
        return this.page;
    }

    public int getTotal() {
        return this.total;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setList(List<ArticleBean> list) {
        this.list = list;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
