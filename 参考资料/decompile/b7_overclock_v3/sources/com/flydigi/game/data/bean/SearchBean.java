package com.flydigi.game.data.bean;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class SearchBean {
    public int cur_page;
    public List<GameBean> list;
    public int total;
    public int total_page;

    public String toString() {
        return "SearchBean{total_page=" + this.total_page + ", current_page=" + this.cur_page + ", total=" + this.total + ", list=" + this.list + '}';
    }
}
