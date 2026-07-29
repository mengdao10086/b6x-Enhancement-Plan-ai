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
public class p extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f35839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f35840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f35841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f35842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f35843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f35844h;

    public p(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f35837a = 0;
        this.f35838b = i10;
        this.f35839c = org.bouncycastle.util.a.p(bArr);
        this.f35840d = org.bouncycastle.util.a.p(bArr2);
        this.f35841e = org.bouncycastle.util.a.p(bArr3);
        this.f35842f = org.bouncycastle.util.a.p(bArr4);
        this.f35844h = org.bouncycastle.util.a.p(bArr5);
        this.f35843g = -1;
    }

    public p(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i11) {
        this.f35837a = 1;
        this.f35838b = i10;
        this.f35839c = org.bouncycastle.util.a.p(bArr);
        this.f35840d = org.bouncycastle.util.a.p(bArr2);
        this.f35841e = org.bouncycastle.util.a.p(bArr3);
        this.f35842f = org.bouncycastle.util.a.p(bArr4);
        this.f35844h = org.bouncycastle.util.a.p(bArr5);
        this.f35843g = i11;
    }

    public p(f0 f0Var) {
        int iQ;
        t tVarI = t.I(f0Var.K(0));
        if (!tVarI.L(0) && !tVarI.L(1)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f35837a = tVarI.Q();
        if (f0Var.size() != 2 && f0Var.size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        f0 f0VarJ = f0.J(f0Var.K(1));
        this.f35838b = t.I(f0VarJ.K(0)).Q();
        this.f35839c = org.bouncycastle.util.a.p(z.I(f0VarJ.K(1)).J());
        this.f35840d = org.bouncycastle.util.a.p(z.I(f0VarJ.K(2)).J());
        this.f35841e = org.bouncycastle.util.a.p(z.I(f0VarJ.K(3)).J());
        this.f35842f = org.bouncycastle.util.a.p(z.I(f0VarJ.K(4)).J());
        if (f0VarJ.size() == 6) {
            n0 n0VarT = n0.T(f0VarJ.K(5));
            if (n0VarT.q() != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            iQ = t.H(n0VarT, false).Q();
        } else {
            if (f0VarJ.size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            iQ = -1;
        }
        this.f35843g = iQ;
        if (f0Var.size() == 3) {
            this.f35844h = org.bouncycastle.util.a.p(z.H(n0.T(f0Var.K(2)), true).J());
        } else {
            this.f35844h = null;
        }
    }

    public static p z(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(f0.J(obj));
        }
        return null;
    }

    public int A() {
        return this.f35843g;
    }

    public byte[] B() {
        return org.bouncycastle.util.a.p(this.f35841e);
    }

    public byte[] C() {
        return org.bouncycastle.util.a.p(this.f35842f);
    }

    public byte[] D() {
        return org.bouncycastle.util.a.p(this.f35840d);
    }

    public byte[] E() {
        return org.bouncycastle.util.a.p(this.f35839c);
    }

    public int F() {
        return this.f35837a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(this.f35843g >= 0 ? new t(1L) : new t(0L));
        gm.i iVar2 = new gm.i();
        iVar2.a(new t(this.f35838b));
        iVar2.a(new f2(this.f35839c));
        iVar2.a(new f2(this.f35840d));
        iVar2.a(new f2(this.f35841e));
        iVar2.a(new f2(this.f35842f));
        if (this.f35843g >= 0) {
            iVar2.a(new n2(false, 0, (gm.h) new t(this.f35843g)));
        }
        iVar.a(new j2(iVar2));
        iVar.a(new n2(true, 0, (gm.h) new f2(this.f35844h)));
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f35844h);
    }

    public int y() {
        return this.f35838b;
    }
}
