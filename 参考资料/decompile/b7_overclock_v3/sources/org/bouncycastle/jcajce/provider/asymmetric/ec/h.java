package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureSpi;
import np.w1;

/* JADX INFO: loaded from: classes7.dex */
public class h extends org.bouncycastle.jcajce.provider.asymmetric.util.f {

    public static class a extends h {
        public a() {
            super(org.bouncycastle.crypto.util.f.d(), new rp.f(), rp.v.f49100a);
        }
    }

    public static class a0 extends h {
        public a0() {
            super(org.bouncycastle.crypto.util.f.c(), new rp.f(new rp.q(org.bouncycastle.crypto.util.f.c())), rp.z.f49116a);
        }
    }

    public static class b extends h {
        public b() {
            super(org.bouncycastle.crypto.util.f.e(), new rp.f(), rp.v.f49100a);
        }
    }

    public static class b0 extends h {
        public b0() {
            super(org.bouncycastle.crypto.util.f.g(), new rp.f(new rp.q(org.bouncycastle.crypto.util.f.g())), rp.z.f49116a);
        }
    }

    public static class c extends h {
        public c() {
            super(org.bouncycastle.crypto.util.f.f(), new rp.f(), rp.v.f49100a);
        }
    }

    public static class c0 extends h {
        public c0() {
            super(org.bouncycastle.crypto.util.f.h(), new rp.f(new rp.q(org.bouncycastle.crypto.util.f.h())), rp.z.f49116a);
        }
    }

    public static class d extends h {
        public d() {
            super(org.bouncycastle.crypto.util.f.g(), new rp.f(), rp.v.f49100a);
        }
    }

    public static class d0 extends h {
        public d0() {
            super(org.bouncycastle.crypto.util.f.i(), new rp.f(new rp.q(org.bouncycastle.crypto.util.f.i())), rp.z.f49116a);
        }
    }

    public static class e extends h {
        public e() {
            super(org.bouncycastle.crypto.util.f.h(), new rp.f(), rp.v.f49100a);
        }
    }

    public static class e0 extends h {
        public e0() {
            super(org.bouncycastle.crypto.util.f.j(), new rp.f(new rp.q(org.bouncycastle.crypto.util.f.j())), rp.z.f49116a);
        }
    }

    public static class f extends h {
        public f() {
            super(org.bouncycastle.crypto.util.f.i(), new rp.f(), rp.v.f49100a);
        }
    }

    public static class f0 extends h {
        public f0() {
            super(org.bouncycastle.crypto.util.f.d(), new rp.i(), rp.z.f49116a);
        }
    }

    public static class g extends h {
        public g() {
            super(org.bouncycastle.crypto.util.f.j(), new rp.f(), rp.v.f49100a);
        }
    }

    public static class g0 extends h {
        public g0() {
            super(org.bouncycastle.crypto.util.f.e(), new rp.i(), rp.z.f49116a);
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.h$h, reason: collision with other inner class name */
    public static class C0508h extends h {
        public C0508h() {
            super(org.bouncycastle.crypto.util.f.k(), new rp.f(), rp.v.f49100a);
        }
    }

    public static class h0 extends h {
        public h0() {
            super(org.bouncycastle.crypto.util.f.f(), new rp.i(), rp.z.f49116a);
        }
    }

    public static class i extends h {
        public i() {
            super(org.bouncycastle.crypto.util.f.c(), new rp.f(), rp.v.f49100a);
        }
    }

    public static class i0 extends h {
        public i0() {
            super(org.bouncycastle.crypto.util.f.k(), new rp.i(), rp.z.f49116a);
        }
    }

    public static class j extends h {
        public j() {
            super(org.bouncycastle.crypto.util.f.d(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class j0 extends h {
        public j0() {
            super(org.bouncycastle.crypto.util.f.c(), new rp.i(), rp.z.f49116a);
        }
    }

    public static class k extends h {
        public k() {
            super(org.bouncycastle.crypto.util.f.e(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class k0 extends h {
        public k0() {
            super(new zo.z(), new rp.f(), rp.v.f49100a);
        }
    }

    public static class l extends h {
        public l() {
            super(org.bouncycastle.crypto.util.f.f(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class m extends h {
        public m() {
            super(org.bouncycastle.crypto.util.f.k(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class n extends h {
        public n() {
            super(org.bouncycastle.crypto.util.f.c(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class o extends h {
        public o() {
            super(new zo.z(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class p extends h {
        public p() {
            super(org.bouncycastle.crypto.util.f.g(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class q extends h {
        public q() {
            super(org.bouncycastle.crypto.util.f.h(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class r extends h {
        public r() {
            super(org.bouncycastle.crypto.util.f.i(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class s extends h {
        public s() {
            super(org.bouncycastle.crypto.util.f.j(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class t extends h {
        public t() {
            super(new zo.j0(128), new rp.f(new rp.q(new zo.j0(128))), rp.z.f49116a);
        }
    }

    public static class u extends h {
        public u() {
            super(new zo.j0(256), new rp.f(new rp.q(new zo.j0(256))), rp.z.f49116a);
        }
    }

    public static class v extends h {
        public v() {
            super(new zo.w(), new rp.f(), rp.z.f49116a);
        }
    }

    public static class w extends h {
        public w() {
            super(org.bouncycastle.crypto.util.f.d(), new rp.f(new rp.q(org.bouncycastle.crypto.util.f.d())), rp.z.f49116a);
        }
    }

    public static class x extends h {
        public x() {
            super(org.bouncycastle.crypto.util.f.e(), new rp.f(new rp.q(org.bouncycastle.crypto.util.f.e())), rp.z.f49116a);
        }
    }

    public static class y extends h {
        public y() {
            super(org.bouncycastle.crypto.util.f.f(), new rp.f(new rp.q(org.bouncycastle.crypto.util.f.f())), rp.z.f49116a);
        }
    }

    public static class z extends h {
        public z() {
            super(org.bouncycastle.crypto.util.f.k(), new rp.f(new rp.q(org.bouncycastle.crypto.util.f.k())), rp.z.f49116a);
        }
    }

    public h(org.bouncycastle.crypto.s sVar, org.bouncycastle.crypto.p pVar, rp.b bVar) {
        super(sVar, pVar, bVar);
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        np.c cVarC = org.bouncycastle.jcajce.provider.asymmetric.util.i.c(privateKey);
        this.f45053a.reset();
        SecureRandom secureRandom = ((SignatureSpi) this).appRandom;
        if (secureRandom != null) {
            this.f45054b.a(true, new w1(cVarC, secureRandom));
        } else {
            this.f45054b.a(true, cVarC);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        np.c cVarA = org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(publicKey);
        this.f45053a.reset();
        this.f45054b.a(false, cVarA);
    }
}
