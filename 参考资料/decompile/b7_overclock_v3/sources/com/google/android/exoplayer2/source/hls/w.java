package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import g.p0;
import hb.a0;
import hb.d0;
import hb.z;
import hd.c0;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements hb.k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f18119j = Pattern.compile("LOCAL:([^,]+)");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f18120k = Pattern.compile("MPEGTS:(-?\\d+)");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f18121l = 6;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f18122m = 9;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final String f18123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hd.p0 f18124e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public hb.m f18126g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f18128i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0 f18125f = new c0();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f18127h = new byte[1024];

    public w(@p0 String str, hd.p0 p0Var) {
        this.f18123d = str;
        this.f18124e = p0Var;
    }

    @RequiresNonNull({"output"})
    public final d0 a(long j10) {
        d0 d0VarD = this.f18126g.d(0, 3);
        d0VarD.f(new Format.b().e0(hd.w.f31177c0).V(this.f18123d).i0(j10).E());
        this.f18126g.k();
        return d0VarD;
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        throw new IllegalStateException();
    }

    @Override // hb.k
    public void c(hb.m mVar) {
        this.f18126g = mVar;
        mVar.o(new a0.b(ya.g.f56663b));
    }

    @RequiresNonNull({"output"})
    public final void d() throws ParserException {
        c0 c0Var = new c0(this.f18127h);
        zc.i.e(c0Var);
        long jF = 0;
        long jD = 0;
        for (String strQ = c0Var.q(); !TextUtils.isEmpty(strQ); strQ = c0Var.q()) {
            if (strQ.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f18119j.matcher(strQ);
                if (!matcher.find()) {
                    throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + strQ);
                }
                Matcher matcher2 = f18120k.matcher(strQ);
                if (!matcher2.find()) {
                    throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + strQ);
                }
                jD = zc.i.d((String) hd.a.g(matcher.group(1)));
                jF = hd.p0.f(Long.parseLong((String) hd.a.g(matcher2.group(1))));
            }
        }
        Matcher matcherA = zc.i.a(c0Var);
        if (matcherA == null) {
            a(0L);
            return;
        }
        long jD2 = zc.i.d((String) hd.a.g(matcherA.group(1)));
        long jB = this.f18124e.b(hd.p0.j((jF + jD2) - jD));
        d0 d0VarA = a(jB - jD2);
        this.f18125f.Q(this.f18127h, this.f18128i);
        d0VarA.d(this.f18125f, this.f18128i);
        d0VarA.a(jB, 1, this.f18128i, 0, null);
    }

    @Override // hb.k
    public int f(hb.l lVar, z zVar) throws IOException {
        hd.a.g(this.f18126g);
        int length = (int) lVar.getLength();
        int i10 = this.f18128i;
        byte[] bArr = this.f18127h;
        if (i10 == bArr.length) {
            this.f18127h = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f18127h;
        int i11 = this.f18128i;
        int i12 = lVar.read(bArr2, i11, bArr2.length - i11);
        if (i12 != -1) {
            int i13 = this.f18128i + i12;
            this.f18128i = i13;
            if (length == -1 || i13 != length) {
                return 0;
            }
        }
        d();
        return -1;
    }

    @Override // hb.k
    public boolean i(hb.l lVar) throws IOException {
        lVar.h(this.f18127h, 0, 6, false);
        this.f18125f.Q(this.f18127h, 6);
        if (zc.i.b(this.f18125f)) {
            return true;
        }
        lVar.h(this.f18127h, 6, 3, false);
        this.f18125f.Q(this.f18127h, 9);
        return zc.i.b(this.f18125f);
    }

    @Override // hb.k
    public void release() {
    }
}
