package com.umeng.analytics.pro;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class bj implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f23364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f23365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f23367d;

    public bj(byte b10, boolean z10) {
        this.f23365b = b10;
        this.f23364a = false;
        this.f23366c = null;
        this.f23367d = z10;
    }

    public boolean a() {
        return this.f23364a;
    }

    public String b() {
        return this.f23366c;
    }

    public boolean c() {
        return this.f23365b == 12;
    }

    public boolean d() {
        byte b10 = this.f23365b;
        return b10 == 15 || b10 == 13 || b10 == 14;
    }

    public boolean e() {
        return this.f23367d;
    }

    public bj(byte b10) {
        this(b10, false);
    }

    public bj(byte b10, String str) {
        this.f23365b = b10;
        this.f23364a = true;
        this.f23366c = str;
        this.f23367d = false;
    }
}
