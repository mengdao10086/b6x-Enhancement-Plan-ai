package com.flydigi.game.data.bean;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class RecoGameBean {
    public int cur_page;
    public List<RecoGameEntity> datalist;
    public int total;
    public int total_page;

    public String toString() {
        return "RecoGameBean{total=" + this.total + ", total_page=" + this.total_page + ", cur_page=" + this.cur_page + ", list=" + this.datalist + '}';
    }
}
