package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class o extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21494d = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21496c;

    public o(int i10, int i11, int i12) throws FormatException {
        super(i10);
        if (i11 < 0 || i11 > 10 || i12 < 0 || i12 > 10) {
            throw FormatException.b();
        }
        this.f21495b = i11;
        this.f21496c = i12;
    }

    public int b() {
        return this.f21495b;
    }

    public int c() {
        return this.f21496c;
    }

    public int d() {
        return (this.f21495b * 10) + this.f21496c;
    }

    public boolean e() {
        return this.f21495b == 10;
    }

    public boolean f() {
        return this.f21496c == 10;
    }
}
