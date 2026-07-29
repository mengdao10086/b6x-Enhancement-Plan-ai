package com.google.android.exoplayer2.extractor.flv;

import ab.a;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.source.u;
import hb.d0;
import hd.c0;
import hd.w;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends TagPayloadReader {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f17102e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f17103f = 7;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f17104g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f17105h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f17106i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f17107j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f17108k = {5512, 11025, 22050, u.f18441j};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17111d;

    public a(d0 d0Var) {
        super(d0Var);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(c0 c0Var) throws TagPayloadReader.UnsupportedFormatException {
        if (this.f17109b) {
            c0Var.T(1);
        } else {
            int iG = c0Var.G();
            int i10 = (iG >> 4) & 15;
            this.f17111d = i10;
            if (i10 == 2) {
                this.f17101a.f(new Format.b().e0(w.D).H(1).f0(f17108k[(iG >> 2) & 3]).E());
                this.f17110c = true;
            } else if (i10 == 7 || i10 == 8) {
                this.f17101a.f(new Format.b().e0(i10 == 7 ? w.H : w.I).H(1).f0(8000).E());
                this.f17110c = true;
            } else if (i10 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f17111d);
            }
            this.f17109b = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(c0 c0Var, long j10) throws ParserException {
        if (this.f17111d == 2) {
            int iA = c0Var.a();
            this.f17101a.d(c0Var, iA);
            this.f17101a.a(j10, 1, iA, 0, null);
            return true;
        }
        int iG = c0Var.G();
        if (iG != 0 || this.f17110c) {
            if (this.f17111d == 10 && iG != 1) {
                return false;
            }
            int iA2 = c0Var.a();
            this.f17101a.d(c0Var, iA2);
            this.f17101a.a(j10, 1, iA2, 0, null);
            return true;
        }
        int iA3 = c0Var.a();
        byte[] bArr = new byte[iA3];
        c0Var.k(bArr, 0, iA3);
        a.c cVarG = ab.a.g(bArr);
        this.f17101a.f(new Format.b().e0(w.A).I(cVarG.f371c).H(cVarG.f370b).f0(cVarG.f369a).T(Collections.singletonList(bArr)).E());
        this.f17110c = true;
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void d() {
    }
}
