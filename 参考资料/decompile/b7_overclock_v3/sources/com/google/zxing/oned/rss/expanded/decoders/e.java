package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21475f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f21476g = 20;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f21477h = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f21479e;

    public e(af.a aVar, String str, String str2) {
        super(aVar);
        this.f21478d = str2;
        this.f21479e = str;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws NotFoundException {
        if (c().l() != 84) {
            throw NotFoundException.b();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 8);
        j(sb2, 48, 20);
        k(sb2, 68);
        return sb2.toString();
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    public void h(StringBuilder sb2, int i10) {
        sb2.append('(');
        sb2.append(this.f21479e);
        sb2.append(i10 / 100000);
        sb2.append(')');
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    public int i(int i10) {
        return i10 % 100000;
    }

    public final void k(StringBuilder sb2, int i10) {
        int iF = b().f(i10, 16);
        if (iF == 38400) {
            return;
        }
        sb2.append('(');
        sb2.append(this.f21478d);
        sb2.append(')');
        int i11 = iF % 32;
        int i12 = iF / 32;
        int i13 = (i12 % 12) + 1;
        int i14 = i12 / 12;
        if (i14 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i14);
        if (i13 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i13);
        if (i11 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i11);
    }
}
