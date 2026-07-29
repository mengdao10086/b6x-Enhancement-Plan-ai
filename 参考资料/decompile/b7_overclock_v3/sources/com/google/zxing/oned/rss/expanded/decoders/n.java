package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes7.dex */
public final class n extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f21493d;

    public n(int i10, String str) {
        super(i10);
        this.f21491b = str;
        this.f21493d = false;
        this.f21492c = 0;
    }

    public String b() {
        return this.f21491b;
    }

    public int c() {
        return this.f21492c;
    }

    public boolean d() {
        return this.f21493d;
    }

    public n(int i10, String str, int i11) {
        super(i10);
        this.f21493d = true;
        this.f21492c = i11;
        this.f21491b = str;
    }
}
