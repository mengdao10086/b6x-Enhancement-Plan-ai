package xr;

import gm.n2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class q extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56001c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56002d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56003e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f56004f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f56005g = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f56007b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f56008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f56009b;

        public q b(BigInteger bigInteger) {
            this.f56008a = 2;
            throw new IllegalStateException("not fully implemented.");
        }

        public q c(BigInteger bigInteger) {
            this.f56008a = 3;
            throw new IllegalStateException("not fully implemented.");
        }

        public final q d() {
            return new q(this.f56008a, this.f56009b);
        }

        public q e() {
            this.f56008a = 1;
            this.f56009b = gm.d2.f29657b;
            return d();
        }

        public q f(BigInteger bigInteger, BigInteger bigInteger2) {
            this.f56008a = 4;
            this.f56009b = new gm.j2(new gm.h[]{new gm.f2(org.bouncycastle.util.b.b(32, bigInteger)), new gm.f2(org.bouncycastle.util.b.b(32, bigInteger2))});
            return d();
        }

        public q g(BigInteger bigInteger) {
            this.f56008a = 0;
            this.f56009b = new gm.f2(org.bouncycastle.util.b.c(bigInteger));
            return d();
        }

        public a h(int i10) {
            this.f56008a = i10;
            return this;
        }

        public a i(gm.h hVar) {
            this.f56009b = hVar;
            return this;
        }
    }

    public q(int i10, gm.h hVar) {
        this.f56006a = i10;
        this.f56007b = hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static xr.q A(java.lang.Object r3) {
        /*
            boolean r0 = r3 instanceof xr.q
            if (r0 == 0) goto L7
            xr.q r3 = (xr.q) r3
            return r3
        L7:
            gm.n0 r3 = gm.n0.T(r3)
            int r0 = r3.q()
            if (r0 == 0) goto L4a
            r1 = 1
            if (r0 == r1) goto L41
            r1 = 2
            if (r0 == r1) goto L4a
            r1 = 3
            if (r0 == r1) goto L4a
            r1 = 4
            if (r0 != r1) goto L26
            gm.c0 r0 = r3.U()
            gm.f0 r0 = gm.f0.J(r0)
            goto L52
        L26:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "unknown tag "
            r1.append(r2)
            int r3 = r3.q()
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L41:
            gm.c0 r0 = r3.U()
            gm.u r0 = gm.u.I(r0)
            goto L52
        L4a:
            gm.c0 r0 = r3.U()
            gm.z r0 = gm.z.I(r0)
        L52:
            xr.q$a r1 = new xr.q$a
            r1.<init>()
            int r3 = r3.q()
            xr.q$a r3 = r1.h(r3)
            xr.q$a r3 = r3.i(r0)
            xr.q r3 = xr.q.a.a(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: xr.q.A(java.lang.Object):xr.q");
    }

    public static a y() {
        return new a();
    }

    public gm.h B() {
        return this.f56007b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f56006a, this.f56007b);
    }

    @Override // xr.p
    public byte[] x() {
        byte[] bArr;
        int i10 = this.f56006a;
        if (i10 == 0) {
            throw new IllegalStateException("x Only not implemented");
        }
        if (i10 == 2) {
            byte[] bArrJ = gm.z.I(this.f56007b).J();
            bArr = new byte[bArrJ.length + 1];
            bArr[0] = 2;
            System.arraycopy(bArrJ, 0, bArr, 1, bArrJ.length);
        } else {
            if (i10 != 3) {
                if (i10 != 4) {
                    throw new IllegalStateException("unknown point choice");
                }
                gm.f0 f0VarJ = gm.f0.J(this.f56007b);
                return org.bouncycastle.util.a.C(new byte[]{4}, gm.z.I(f0VarJ.K(0)).J(), gm.z.I(f0VarJ.K(1)).J());
            }
            byte[] bArrJ2 = gm.z.I(this.f56007b).J();
            bArr = new byte[bArrJ2.length + 1];
            bArr[0] = 3;
            System.arraycopy(bArrJ2, 0, bArr, 1, bArrJ2.length);
        }
        return bArr;
    }

    public int z() {
        return this.f56006a;
    }
}
