package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import hb.d0;
import hd.c0;
import hd.w;
import hd.y;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends TagPayloadReader {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f17112h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f17113i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f17114j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f17115k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f17116l = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f17117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f17118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f17120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17122g;

    public b(d0 d0Var) {
        super(d0Var);
        this.f17117b = new c0(y.f31231b);
        this.f17118c = new c0(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(c0 c0Var) throws TagPayloadReader.UnsupportedFormatException {
        int iG = c0Var.G();
        int i10 = (iG >> 4) & 15;
        int i11 = iG & 15;
        if (i11 == 7) {
            this.f17122g = i10;
            return i10 != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i11);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(c0 c0Var, long j10) throws ParserException {
        int iG = c0Var.G();
        long jP = j10 + (((long) c0Var.p()) * 1000);
        if (iG == 0 && !this.f17120e) {
            c0 c0Var2 = new c0(new byte[c0Var.a()]);
            c0Var.k(c0Var2.d(), 0, c0Var.a());
            id.a aVarB = id.a.b(c0Var2);
            this.f17119d = aVarB.f32133b;
            this.f17101a.f(new Format.b().e0(w.f31190j).I(aVarB.f32137f).j0(aVarB.f32134c).Q(aVarB.f32135d).a0(aVarB.f32136e).T(aVarB.f32132a).E());
            this.f17120e = true;
            return false;
        }
        if (iG != 1 || !this.f17120e) {
            return false;
        }
        int i10 = this.f17122g == 1 ? 1 : 0;
        if (!this.f17121f && i10 == 0) {
            return false;
        }
        byte[] bArrD = this.f17118c.d();
        bArrD[0] = 0;
        bArrD[1] = 0;
        bArrD[2] = 0;
        int i11 = 4 - this.f17119d;
        int i12 = 0;
        while (c0Var.a() > 0) {
            c0Var.k(this.f17118c.d(), i11, this.f17119d);
            this.f17118c.S(0);
            int iK = this.f17118c.K();
            this.f17117b.S(0);
            this.f17101a.d(this.f17117b, 4);
            this.f17101a.d(c0Var, iK);
            i12 = i12 + 4 + iK;
        }
        this.f17101a.a(jP, i10, i12, 0, null);
        this.f17121f = true;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void d() {
        this.f17121f = false;
    }
}
