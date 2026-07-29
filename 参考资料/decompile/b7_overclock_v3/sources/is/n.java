package is;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.t;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes6.dex */
public class n extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f35828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f35829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f35830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f35831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f35832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f35833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f35834h;

    public n(long j10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f35827a = 0;
        this.f35828b = j10;
        this.f35830d = org.bouncycastle.util.a.p(bArr);
        this.f35831e = org.bouncycastle.util.a.p(bArr2);
        this.f35832f = org.bouncycastle.util.a.p(bArr3);
        this.f35833g = org.bouncycastle.util.a.p(bArr4);
        this.f35834h = org.bouncycastle.util.a.p(bArr5);
        this.f35829c = -1L;
    }

    public n(long j10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, long j11) {
        this.f35827a = 1;
        this.f35828b = j10;
        this.f35830d = org.bouncycastle.util.a.p(bArr);
        this.f35831e = org.bouncycastle.util.a.p(bArr2);
        this.f35832f = org.bouncycastle.util.a.p(bArr3);
        this.f35833g = org.bouncycastle.util.a.p(bArr4);
        this.f35834h = org.bouncycastle.util.a.p(bArr5);
        this.f35829c = j11;
    }

    public n(f0 f0Var) {
        long jT;
        t tVarI = t.I(f0Var.K(0));
        if (!tVarI.L(0) && !tVarI.L(1)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f35827a = tVarI.Q();
        if (f0Var.size() != 2 && f0Var.size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        f0 f0VarJ = f0.J(f0Var.K(1));
        this.f35828b = t.I(f0VarJ.K(0)).T();
        this.f35830d = org.bouncycastle.util.a.p(z.I(f0VarJ.K(1)).J());
        this.f35831e = org.bouncycastle.util.a.p(z.I(f0VarJ.K(2)).J());
        this.f35832f = org.bouncycastle.util.a.p(z.I(f0VarJ.K(3)).J());
        this.f35833g = org.bouncycastle.util.a.p(z.I(f0VarJ.K(4)).J());
        if (f0VarJ.size() == 6) {
            n0 n0VarT = n0.T(f0VarJ.K(5));
            if (n0VarT.q() != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            jT = t.H(n0VarT, false).T();
        } else {
            if (f0VarJ.size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            jT = -1;
        }
        this.f35829c = jT;
        if (f0Var.size() == 3) {
            this.f35834h = org.bouncycastle.util.a.p(z.H(n0.T(f0Var.K(2)), true).J());
        } else {
            this.f35834h = null;
        }
    }

    public static n z(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(f0.J(obj));
        }
        return null;
    }

    public long A() {
        return this.f35829c;
    }

    public byte[] B() {
        return org.bouncycastle.util.a.p(this.f35832f);
    }

    public byte[] C() {
        return org.bouncycastle.util.a.p(this.f35833g);
    }

    public byte[] D() {
        return org.bouncycastle.util.a.p(this.f35831e);
    }

    public byte[] E() {
        return org.bouncycastle.util.a.p(this.f35830d);
    }

    public int F() {
        return this.f35827a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(this.f35829c >= 0 ? new t(1L) : new t(0L));
        gm.i iVar2 = new gm.i();
        iVar2.a(new t(this.f35828b));
        iVar2.a(new f2(this.f35830d));
        iVar2.a(new f2(this.f35831e));
        iVar2.a(new f2(this.f35832f));
        iVar2.a(new f2(this.f35833g));
        if (this.f35829c >= 0) {
            iVar2.a(new n2(false, 0, (gm.h) new t(this.f35829c)));
        }
        iVar.a(new j2(iVar2));
        iVar.a(new n2(true, 0, (gm.h) new f2(this.f35834h)));
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f35834h);
    }

    public long y() {
        return this.f35828b;
    }
}
