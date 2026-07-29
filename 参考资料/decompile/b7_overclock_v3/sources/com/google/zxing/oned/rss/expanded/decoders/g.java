package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21482d = 4;

    public g(af.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws NotFoundException, FormatException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(01)");
        int length = sb2.length();
        sb2.append(b().f(4, 4));
        g(sb2, 8, length);
        return b().a(sb2, 48);
    }
}
