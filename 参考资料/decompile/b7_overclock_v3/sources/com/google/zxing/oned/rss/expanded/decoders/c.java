package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21470d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f21471e = 2;

    public c(af.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws NotFoundException, FormatException {
        if (c().l() < 48) {
            throw NotFoundException.b();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 8);
        int iF = b().f(48, 2);
        sb2.append("(392");
        sb2.append(iF);
        sb2.append(')');
        sb2.append(b().c(50, null).b());
        return sb2.toString();
    }
}
