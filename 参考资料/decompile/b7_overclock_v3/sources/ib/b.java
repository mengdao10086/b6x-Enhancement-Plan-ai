package ib;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.j;
import hb.a0;
import hb.d0;
import hb.f;
import hb.k;
import hb.l;
import hb.m;
import hb.p;
import hb.q;
import hb.z;
import hd.u0;
import hd.w;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements k {
    public static final int A = 16000;
    public static final int B = 8000;
    public static final int C = 20000;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f32003t = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int[] f32005v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f32008y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f32009z = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f32010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f32011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f32012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f32013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f32014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f32015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f32016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f32017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f32018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f32019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f32020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m f32021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d0 f32022p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a0 f32023q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f32024r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final q f32002s = new q() { // from class: ib.a
        @Override // hb.q
        public final k[] a() {
            return b.q();
        }

        @Override // hb.q
        public /* synthetic */ k[] b(Uri uri, Map map) {
            return p.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f32004u = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte[] f32006w = u0.w0("#!AMR\n");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final byte[] f32007x = u0.w0("#!AMR-WB\n");

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f32005v = iArr;
        f32008y = iArr[8];
    }

    public b() {
        this(0);
    }

    public static byte[] d() {
        byte[] bArr = f32006w;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public static byte[] e() {
        byte[] bArr = f32007x;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public static int h(int i10) {
        return f32004u[i10];
    }

    public static int j(int i10) {
        return f32005v[i10];
    }

    public static int k(int i10, long j10) {
        return (int) ((((long) (i10 * 8)) * 1000000) / j10);
    }

    public static /* synthetic */ k[] q() {
        return new k[]{new b()};
    }

    public static boolean t(l lVar, byte[] bArr) throws IOException {
        lVar.n();
        byte[] bArr2 = new byte[bArr.length];
        lVar.t(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // hb.k
    public void b(long j10, long j11) {
        this.f32013g = 0L;
        this.f32014h = 0;
        this.f32015i = 0;
        if (j10 != 0) {
            a0 a0Var = this.f32023q;
            if (a0Var instanceof f) {
                this.f32020n = ((f) a0Var).c(j10);
                return;
            }
        }
        this.f32020n = 0L;
    }

    @Override // hb.k
    public void c(m mVar) {
        this.f32021o = mVar;
        this.f32022p = mVar.d(0, 1);
        mVar.k();
    }

    @Override // hb.k
    public int f(l lVar, z zVar) throws IOException {
        g();
        if (lVar.getPosition() == 0 && !v(lVar)) {
            throw new ParserException("Could not find AMR header.");
        }
        r();
        int iW = w(lVar);
        s(lVar.getLength(), iW);
        return iW;
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    public final void g() {
        hd.a.k(this.f32022p);
        u0.k(this.f32021o);
    }

    @Override // hb.k
    public boolean i(l lVar) throws IOException {
        return v(lVar);
    }

    public final a0 l(long j10) {
        return new f(j10, this.f32017k, k(this.f32018l, j.f16899v), this.f32018l);
    }

    public final int m(int i10) throws ParserException {
        if (o(i10)) {
            return this.f32012f ? f32005v[i10] : f32004u[i10];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal AMR ");
        sb2.append(this.f32012f ? "WB" : "NB");
        sb2.append(" frame type ");
        sb2.append(i10);
        throw new ParserException(sb2.toString());
    }

    public final boolean n(int i10) {
        return !this.f32012f && (i10 < 12 || i10 > 14);
    }

    public final boolean o(int i10) {
        return i10 >= 0 && i10 <= 15 && (p(i10) || n(i10));
    }

    public final boolean p(int i10) {
        return this.f32012f && (i10 < 10 || i10 > 13);
    }

    @RequiresNonNull({"trackOutput"})
    public final void r() {
        if (this.f32024r) {
            return;
        }
        this.f32024r = true;
        boolean z10 = this.f32012f;
        this.f32022p.f(new Format.b().e0(z10 ? w.V : w.U).W(f32008y).H(1).f0(z10 ? 16000 : 8000).E());
    }

    @Override // hb.k
    public void release() {
    }

    @RequiresNonNull({"extractorOutput"})
    public final void s(long j10, int i10) {
        int i11;
        if (this.f32016j) {
            return;
        }
        if ((this.f32011e & 1) == 0 || j10 == -1 || !((i11 = this.f32018l) == -1 || i11 == this.f32014h)) {
            a0.b bVar = new a0.b(g.f56663b);
            this.f32023q = bVar;
            this.f32021o.o(bVar);
            this.f32016j = true;
            return;
        }
        if (this.f32019m >= 20 || i10 == -1) {
            a0 a0VarL = l(j10);
            this.f32023q = a0VarL;
            this.f32021o.o(a0VarL);
            this.f32016j = true;
        }
    }

    public final int u(l lVar) throws IOException {
        lVar.n();
        lVar.t(this.f32010d, 0, 1);
        byte b10 = this.f32010d[0];
        if ((b10 & 131) <= 0) {
            return m((b10 >> 3) & 15);
        }
        throw new ParserException("Invalid padding bits for frame header " + ((int) b10));
    }

    public final boolean v(l lVar) throws IOException {
        byte[] bArr = f32006w;
        if (t(lVar, bArr)) {
            this.f32012f = false;
            lVar.o(bArr.length);
            return true;
        }
        byte[] bArr2 = f32007x;
        if (!t(lVar, bArr2)) {
            return false;
        }
        this.f32012f = true;
        lVar.o(bArr2.length);
        return true;
    }

    @RequiresNonNull({"trackOutput"})
    public final int w(l lVar) throws IOException {
        if (this.f32015i == 0) {
            try {
                int iU = u(lVar);
                this.f32014h = iU;
                this.f32015i = iU;
                if (this.f32018l == -1) {
                    this.f32017k = lVar.getPosition();
                    this.f32018l = this.f32014h;
                }
                if (this.f32018l == this.f32014h) {
                    this.f32019m++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iE = this.f32022p.e(lVar, this.f32015i, true);
        if (iE == -1) {
            return -1;
        }
        int i10 = this.f32015i - iE;
        this.f32015i = i10;
        if (i10 > 0) {
            return 0;
        }
        this.f32022p.a(this.f32020n + this.f32013g, 1, this.f32014h, 0, null);
        this.f32013g += j.f16899v;
        return 0;
    }

    public b(int i10) {
        this.f32011e = i10;
        this.f32010d = new byte[1];
        this.f32018l = -1;
    }
}
