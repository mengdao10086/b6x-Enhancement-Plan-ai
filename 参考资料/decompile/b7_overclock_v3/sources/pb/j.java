package pb;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import g.i1;
import g.p0;
import hb.f0;
import hd.c0;
import hd.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import pb.i;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends i {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public a f46592r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f46593s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f46594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public f0.d f46595u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @p0
    public f0.b f46596v;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f0.d f46597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f0.b f46598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f46599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f0.c[] f46600d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f46601e;

        public a(f0.d dVar, f0.b bVar, byte[] bArr, f0.c[] cVarArr, int i10) {
            this.f46597a = dVar;
            this.f46598b = bVar;
            this.f46599c = bArr;
            this.f46600d = cVarArr;
            this.f46601e = i10;
        }
    }

    @i1
    public static void n(c0 c0Var, long j10) {
        if (c0Var.b() < c0Var.f() + 4) {
            c0Var.P(Arrays.copyOf(c0Var.d(), c0Var.f() + 4));
        } else {
            c0Var.R(c0Var.f() + 4);
        }
        byte[] bArrD = c0Var.d();
        bArrD[c0Var.f() - 4] = (byte) (j10 & 255);
        bArrD[c0Var.f() - 3] = (byte) ((j10 >>> 8) & 255);
        bArrD[c0Var.f() - 2] = (byte) ((j10 >>> 16) & 255);
        bArrD[c0Var.f() - 1] = (byte) ((j10 >>> 24) & 255);
    }

    public static int o(byte b10, a aVar) {
        return !aVar.f46600d[p(b10, aVar.f46601e, 1)].f30851a ? aVar.f46597a.f30861g : aVar.f46597a.f30862h;
    }

    @i1
    public static int p(byte b10, int i10, int i11) {
        return (b10 >> i11) & (255 >>> (8 - i10));
    }

    public static boolean r(c0 c0Var) {
        try {
            return f0.l(1, c0Var, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // pb.i
    public void e(long j10) {
        super.e(j10);
        this.f46594t = j10 != 0;
        f0.d dVar = this.f46595u;
        this.f46593s = dVar != null ? dVar.f30861g : 0;
    }

    @Override // pb.i
    public long f(c0 c0Var) {
        if ((c0Var.d()[0] & 1) == 1) {
            return -1L;
        }
        int iO = o(c0Var.d()[0], (a) hd.a.k(this.f46592r));
        long j10 = this.f46594t ? (this.f46593s + iO) / 4 : 0;
        n(c0Var, j10);
        this.f46594t = true;
        this.f46593s = iO;
        return j10;
    }

    @Override // pb.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean i(c0 c0Var, long j10, i.b bVar) throws IOException {
        if (this.f46592r != null) {
            hd.a.g(bVar.f46590a);
            return false;
        }
        a aVarQ = q(c0Var);
        this.f46592r = aVarQ;
        if (aVarQ == null) {
            return true;
        }
        f0.d dVar = aVarQ.f46597a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f30864j);
        arrayList.add(aVarQ.f46599c);
        bVar.f46590a = new Format.b().e0(w.R).G(dVar.f30859e).Z(dVar.f30858d).H(dVar.f30856b).f0(dVar.f30857c).T(arrayList).E();
        return true;
    }

    @Override // pb.i
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f46592r = null;
            this.f46595u = null;
            this.f46596v = null;
        }
        this.f46593s = 0;
        this.f46594t = false;
    }

    @i1
    @p0
    public a q(c0 c0Var) throws IOException {
        f0.d dVar = this.f46595u;
        if (dVar == null) {
            this.f46595u = f0.j(c0Var);
            return null;
        }
        f0.b bVar = this.f46596v;
        if (bVar == null) {
            this.f46596v = f0.h(c0Var);
            return null;
        }
        byte[] bArr = new byte[c0Var.f()];
        System.arraycopy(c0Var.d(), 0, bArr, 0, c0Var.f());
        return new a(dVar, bVar, bArr, f0.k(c0Var, dVar.f30856b), f0.a(r4.length - 1));
    }
}
