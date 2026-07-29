package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends f {
    public b(af.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    public void h(StringBuilder sb2, int i10) {
        if (i10 < 10000) {
            sb2.append("(3202)");
        } else {
            sb2.append("(3203)");
        }
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    public int i(int i10) {
        return i10 < 10000 ? i10 : i10 - 10000;
    }
}
