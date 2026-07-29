package com.chad.library.adapter.base.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SectionEntity<T> implements Serializable {
    public String header;
    public boolean isHeader;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public T f12763t;

    public SectionEntity(boolean z10, String str) {
        this.isHeader = z10;
        this.header = str;
        this.f12763t = null;
    }

    public SectionEntity(T t10) {
        this.isHeader = false;
        this.header = null;
        this.f12763t = t10;
    }
}
