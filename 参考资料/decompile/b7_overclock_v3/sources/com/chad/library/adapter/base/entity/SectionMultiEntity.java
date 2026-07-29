package com.chad.library.adapter.base.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SectionMultiEntity<T> implements Serializable, MultiItemEntity {
    public String header;
    public boolean isHeader;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public T f12764t;

    public SectionMultiEntity(boolean z10, String str) {
        this.isHeader = z10;
        this.header = str;
        this.f12764t = null;
    }

    public SectionMultiEntity(T t10) {
        this.isHeader = false;
        this.header = null;
        this.f12764t = t10;
    }
}
