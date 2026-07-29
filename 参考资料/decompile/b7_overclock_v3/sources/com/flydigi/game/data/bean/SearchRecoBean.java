package com.flydigi.game.data.bean;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class SearchRecoBean {
    public List<String> category;
    public List<String> catename;
    public String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f15821id;
    public String link;
    public String pkgname;
    public String size;
    public int star;
    public String thumb;
    public String title;

    public String toString() {
        return "SearchRecoBean{id='" + this.f15821id + "', title='" + this.title + "', thumb='" + this.thumb + "', star=" + this.star + ", description='" + this.description + "', link='" + this.link + "', pkgname='" + this.pkgname + "', size='" + this.size + "', category=" + this.category + ", catename=" + this.catename + '}';
    }
}
