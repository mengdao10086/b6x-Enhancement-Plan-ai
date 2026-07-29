package com.google.zxing.pdf417.decoder;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21572f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21577e = -1;

    public d(int i10, int i11, int i12, int i13) {
        this.f21573a = i10;
        this.f21574b = i11;
        this.f21575c = i12;
        this.f21576d = i13;
    }

    public int a() {
        return this.f21575c;
    }

    public int b() {
        return this.f21574b;
    }

    public int c() {
        return this.f21577e;
    }

    public int d() {
        return this.f21573a;
    }

    public int e() {
        return this.f21576d;
    }

    public int f() {
        return this.f21574b - this.f21573a;
    }

    public boolean g() {
        return h(this.f21577e);
    }

    public boolean h(int i10) {
        return i10 != -1 && this.f21575c == (i10 % 3) * 3;
    }

    public void i(int i10) {
        this.f21577e = i10;
    }

    public void j() {
        this.f21577e = ((this.f21576d / 30) * 3) + (this.f21575c / 3);
    }

    public String toString() {
        return this.f21577e + "|" + this.f21576d;
    }
}
