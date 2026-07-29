package qb;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import hb.a0;
import hb.d0;
import hb.k;
import hb.l;
import hb.m;
import hb.z;
import hd.c0;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements k {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f47193l = 9;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f47194m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f47195n = 1380139777;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f47196o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f47197p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f47198q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f47199r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f47200s = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Format f47201d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d0 f47203f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f47205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f47206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f47207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f47208k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f47202e = new c0(9);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f47204g = 0;

    public a(Format format) {
        this.f47201d = format;
    }

    public final boolean a(l lVar) throws IOException {
        this.f47202e.O(8);
        if (!lVar.e(this.f47202e.d(), 0, 8, true)) {
            return false;
        }
        if (this.f47202e.o() != 1380139777) {
            throw new IOException("Input not RawCC");
        }
        this.f47205h = this.f47202e.G();
        return true;
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        this.f47204g = 0;
    }

    @Override // hb.k
    public void c(m mVar) {
        mVar.o(new a0.b(g.f56663b));
        d0 d0VarD = mVar.d(0, 3);
        this.f47203f = d0VarD;
        d0VarD.f(this.f47201d);
        mVar.k();
    }

    @RequiresNonNull({"trackOutput"})
    public final void d(l lVar) throws IOException {
        while (this.f47207j > 0) {
            this.f47202e.O(3);
            lVar.readFully(this.f47202e.d(), 0, 3);
            this.f47203f.d(this.f47202e, 3);
            this.f47208k += 3;
            this.f47207j--;
        }
        int i10 = this.f47208k;
        if (i10 > 0) {
            this.f47203f.a(this.f47206i, 1, i10, 0, null);
        }
    }

    public final boolean e(l lVar) throws IOException {
        int i10 = this.f47205h;
        if (i10 == 0) {
            this.f47202e.O(5);
            if (!lVar.e(this.f47202e.d(), 0, 5, true)) {
                return false;
            }
            this.f47206i = (this.f47202e.I() * 1000) / 45;
        } else {
            if (i10 != 1) {
                throw new ParserException("Unsupported version number: " + this.f47205h);
            }
            this.f47202e.O(9);
            if (!lVar.e(this.f47202e.d(), 0, 9, true)) {
                return false;
            }
            this.f47206i = this.f47202e.z();
        }
        this.f47207j = this.f47202e.G();
        this.f47208k = 0;
        return true;
    }

    @Override // hb.k
    public int f(l lVar, z zVar) throws IOException {
        hd.a.k(this.f47203f);
        while (true) {
            int i10 = this.f47204g;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException();
                    }
                    d(lVar);
                    this.f47204g = 1;
                    return 0;
                }
                if (!e(lVar)) {
                    this.f47204g = 0;
                    return -1;
                }
                this.f47204g = 2;
            } else {
                if (!a(lVar)) {
                    return -1;
                }
                this.f47204g = 1;
            }
        }
    }

    @Override // hb.k
    public boolean i(l lVar) throws IOException {
        this.f47202e.O(8);
        lVar.t(this.f47202e.d(), 0, 8);
        return this.f47202e.o() == 1380139777;
    }

    @Override // hb.k
    public void release() {
    }
}
