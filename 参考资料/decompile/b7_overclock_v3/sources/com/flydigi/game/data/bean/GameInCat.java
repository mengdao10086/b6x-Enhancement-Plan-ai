package com.flydigi.game.data.bean;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class GameInCat {
    public int cateid;
    public String catename;
    public int cur_page;
    public List<GameBean> list;
    public int total;
    public int total_page;
    public long version;

    public String toString() {
        return "GameInCat{total=" + this.total + ", total_page=" + this.total_page + ", cur_page=" + this.cur_page + ", catename='" + this.catename + "', cateid=" + this.cateid + ", list=" + this.list + '}';
    }
}
