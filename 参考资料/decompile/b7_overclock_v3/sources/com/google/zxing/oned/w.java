package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;

/* JADX INFO: loaded from: classes7.dex */
public final class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f21514c = {1, 1, 2};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f21515a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f21516b = new v();

    public ve.k a(int i10, af.a aVar, int i11) throws NotFoundException {
        int[] iArrN = x.n(aVar, i11, false, f21514c);
        try {
            return this.f21516b.b(i10, aVar, iArrN);
        } catch (ReaderException unused) {
            return this.f21515a.b(i10, aVar, iArrN);
        }
    }
}
