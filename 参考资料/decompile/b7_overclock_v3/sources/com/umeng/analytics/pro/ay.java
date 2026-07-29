package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ay extends ByteArrayOutputStream {
    public ay(int i10) {
        super(i10);
    }

    public byte[] a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int b() {
        return ((ByteArrayOutputStream) this).count;
    }

    public ay() {
    }
}
