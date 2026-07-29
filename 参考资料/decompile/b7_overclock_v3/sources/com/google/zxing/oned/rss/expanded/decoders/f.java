package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public abstract class f extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21480d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f21481e = 15;

    public f(af.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws NotFoundException {
        if (c().l() != 60) {
            throw NotFoundException.b();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 5);
        j(sb2, 45, 15);
        return sb2.toString();
    }
}
