package com.umeng.analytics.pro;

/* JADX INFO: loaded from: classes5.dex */
public class bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f23422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f23423c;

    public bq() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(bq bqVar) {
        return this.f23422b == bqVar.f23422b && this.f23423c == bqVar.f23423c;
    }

    public String toString() {
        return "<TField name:'" + this.f23421a + "' type:" + ((int) this.f23422b) + " field-id:" + ((int) this.f23423c) + ">";
    }

    public bq(String str, byte b10, short s10) {
        this.f23421a = str;
        this.f23422b = b10;
        this.f23423c = s10;
    }
}
