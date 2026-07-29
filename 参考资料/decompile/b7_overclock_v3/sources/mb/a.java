package mb;

import com.google.android.exoplayer2.ParserException;
import hb.l;
import java.io.IOException;
import java.util.ArrayDeque;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f40977h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f40978i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f40979j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f40980k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f40981l = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f40982m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f40983n = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f40984o = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f40985a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<b> f40986b = new ArrayDeque<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f40987c = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public mb.b f40988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f40989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f40990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f40991g;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f40992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f40993b;

        public b(int i10, long j10) {
            this.f40992a = i10;
            this.f40993b = j10;
        }
    }

    public static String f(l lVar, int i10) throws IOException {
        if (i10 == 0) {
            return "";
        }
        byte[] bArr = new byte[i10];
        lVar.readFully(bArr, 0, i10);
        while (i10 > 0 && bArr[i10 - 1] == 0) {
            i10--;
        }
        return new String(bArr, 0, i10);
    }

    @Override // mb.c
    public boolean a(l lVar) throws IOException {
        hd.a.k(this.f40988d);
        while (true) {
            b bVarPeek = this.f40986b.peek();
            if (bVarPeek != null && lVar.getPosition() >= bVarPeek.f40993b) {
                this.f40988d.a(this.f40986b.pop().f40992a);
                return true;
            }
            if (this.f40989e == 0) {
                long jD = this.f40987c.d(lVar, true, false, 4);
                if (jD == -2) {
                    jD = c(lVar);
                }
                if (jD == -1) {
                    return false;
                }
                this.f40990f = (int) jD;
                this.f40989e = 1;
            }
            if (this.f40989e == 1) {
                this.f40991g = this.f40987c.d(lVar, false, true, 8);
                this.f40989e = 2;
            }
            int iB = this.f40988d.b(this.f40990f);
            if (iB != 0) {
                if (iB == 1) {
                    long position = lVar.getPosition();
                    this.f40986b.push(new b(this.f40990f, this.f40991g + position));
                    this.f40988d.g(this.f40990f, position, this.f40991g);
                    this.f40989e = 0;
                    return true;
                }
                if (iB == 2) {
                    long j10 = this.f40991g;
                    if (j10 <= 8) {
                        this.f40988d.h(this.f40990f, e(lVar, (int) j10));
                        this.f40989e = 0;
                        return true;
                    }
                    throw new ParserException("Invalid integer size: " + this.f40991g);
                }
                if (iB == 3) {
                    long j11 = this.f40991g;
                    if (j11 <= 2147483647L) {
                        this.f40988d.d(this.f40990f, f(lVar, (int) j11));
                        this.f40989e = 0;
                        return true;
                    }
                    throw new ParserException("String element size: " + this.f40991g);
                }
                if (iB == 4) {
                    this.f40988d.f(this.f40990f, (int) this.f40991g, lVar);
                    this.f40989e = 0;
                    return true;
                }
                if (iB != 5) {
                    throw new ParserException("Invalid element type " + iB);
                }
                long j12 = this.f40991g;
                if (j12 == 4 || j12 == 8) {
                    this.f40988d.e(this.f40990f, d(lVar, (int) j12));
                    this.f40989e = 0;
                    return true;
                }
                throw new ParserException("Invalid float size: " + this.f40991g);
            }
            lVar.o((int) this.f40991g);
            this.f40989e = 0;
        }
    }

    @Override // mb.c
    public void b(mb.b bVar) {
        this.f40988d = bVar;
    }

    @RequiresNonNull({"processor"})
    public final long c(l lVar) throws IOException {
        lVar.n();
        while (true) {
            lVar.t(this.f40985a, 0, 4);
            int iC = g.c(this.f40985a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) g.a(this.f40985a, iC, false);
                if (this.f40988d.c(iA)) {
                    lVar.o(iC);
                    return iA;
                }
            }
            lVar.o(1);
        }
    }

    public final double d(l lVar, int i10) throws IOException {
        return i10 == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(lVar, i10));
    }

    public final long e(l lVar, int i10) throws IOException {
        lVar.readFully(this.f40985a, 0, i10);
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = (j10 << 8) | ((long) (this.f40985a[i11] & 255));
        }
        return j10;
    }

    @Override // mb.c
    public void reset() {
        this.f40989e = 0;
        this.f40986b.clear();
        this.f40987c.e();
    }
}
