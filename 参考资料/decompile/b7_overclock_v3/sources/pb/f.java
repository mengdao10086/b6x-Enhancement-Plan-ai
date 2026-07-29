package pb;

import com.google.android.exoplayer2.ParserException;
import hb.l;
import hd.c0;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f46553l = 27;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f46554m = 255;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f46555n = 65025;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f46556o = 65307;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f46557p = 1332176723;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f46558q = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f46560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f46561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f46562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f46563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f46564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f46565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f46566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f46567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f46568j = new int[255];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0 f46569k = new c0(255);

    public static boolean a(l lVar, byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        try {
            return lVar.h(bArr, i10, i11, z10);
        } catch (EOFException e10) {
            if (z10) {
                return false;
            }
            throw e10;
        }
    }

    public boolean b(l lVar, boolean z10) throws IOException {
        c();
        this.f46569k.O(27);
        if (!a(lVar, this.f46569k.d(), 0, 27, z10) || this.f46569k.I() != 1332176723) {
            return false;
        }
        int iG = this.f46569k.G();
        this.f46559a = iG;
        if (iG != 0) {
            if (z10) {
                return false;
            }
            throw new ParserException("unsupported bit stream revision");
        }
        this.f46560b = this.f46569k.G();
        this.f46561c = this.f46569k.t();
        this.f46562d = this.f46569k.v();
        this.f46563e = this.f46569k.v();
        this.f46564f = this.f46569k.v();
        int iG2 = this.f46569k.G();
        this.f46565g = iG2;
        this.f46566h = iG2 + 27;
        this.f46569k.O(iG2);
        lVar.t(this.f46569k.d(), 0, this.f46565g);
        for (int i10 = 0; i10 < this.f46565g; i10++) {
            this.f46568j[i10] = this.f46569k.G();
            this.f46567i += this.f46568j[i10];
        }
        return true;
    }

    public void c() {
        this.f46559a = 0;
        this.f46560b = 0;
        this.f46561c = 0L;
        this.f46562d = 0L;
        this.f46563e = 0L;
        this.f46564f = 0L;
        this.f46565g = 0;
        this.f46566h = 0;
        this.f46567i = 0;
    }

    public boolean d(l lVar) throws IOException {
        return e(lVar, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if (r10 == (-1)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r9.getPosition() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r9.b(1) == (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(hb.l r9, long r10) throws java.io.IOException {
        /*
            r8 = this;
            long r0 = r9.getPosition()
            long r2 = r9.i()
            r4 = 0
            r5 = 1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            hd.a.a(r0)
            hd.c0 r0 = r8.f46569k
            r1 = 4
            r0.O(r1)
        L1a:
            r2 = -1
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 == 0) goto L2b
            long r2 = r9.getPosition()
            r6 = 4
            long r2 = r2 + r6
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 >= 0) goto L51
        L2b:
            hd.c0 r2 = r8.f46569k
            byte[] r2 = r2.d()
            boolean r2 = a(r9, r2, r4, r1, r5)
            if (r2 == 0) goto L51
            hd.c0 r0 = r8.f46569k
            r0.S(r4)
            hd.c0 r0 = r8.f46569k
            long r2 = r0.I()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 != 0) goto L4d
            r9.n()
            return r5
        L4d:
            r9.o(r5)
            goto L1a
        L51:
            if (r0 == 0) goto L5b
            long r1 = r9.getPosition()
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 >= 0) goto L63
        L5b:
            int r1 = r9.b(r5)
            r2 = -1
            if (r1 == r2) goto L63
            goto L51
        L63:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.f.e(hb.l, long):boolean");
    }
}
