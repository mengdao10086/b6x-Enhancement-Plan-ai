package org.bouncycastle.operator.jcajce;

import cs.e0;
import gm.f0;
import gm.u1;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.jcajce.CompositePublicKey;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.RuntimeOperatorException;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OperatorHelper f45599a = new OperatorHelper(new org.bouncycastle.jcajce.util.c());

    public class a implements cs.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ X509CertificateHolder f45600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ X509Certificate f45601b;

        public a(X509CertificateHolder x509CertificateHolder, X509Certificate x509Certificate) {
            this.f45600a = x509CertificateHolder;
            this.f45601b = x509Certificate;
        }

        @Override // cs.h
        public cs.g a(zn.b bVar) throws OperatorCreationException {
            if (bVar.x().C(in.c.N)) {
                return c.this.i(bVar, this.f45601b.getPublicKey());
            }
            try {
                Signature signatureJ = c.this.f45599a.j(bVar);
                signatureJ.initVerify(this.f45601b.getPublicKey());
                Signature signatureJ2 = c.this.j(bVar, this.f45601b.getPublicKey());
                return signatureJ2 != null ? c.this.new d(bVar, signatureJ, signatureJ2) : c.this.new e(bVar, signatureJ);
            } catch (GeneralSecurityException e10) {
                throw new OperatorCreationException("exception on setup: " + e10, e10);
            }
        }

        @Override // cs.h
        public X509CertificateHolder c() {
            return this.f45600a;
        }

        @Override // cs.h
        public boolean d() {
            return true;
        }
    }

    public class b implements cs.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PublicKey f45603a;

        public b(PublicKey publicKey) {
            this.f45603a = publicKey;
        }

        @Override // cs.h
        public cs.g a(zn.b bVar) throws OperatorCreationException {
            if (bVar.x().C(in.c.N)) {
                return c.this.i(bVar, this.f45603a);
            }
            PublicKey publicKey = this.f45603a;
            if (!(publicKey instanceof CompositePublicKey)) {
                Signature signatureK = c.this.k(bVar, publicKey);
                Signature signatureJ = c.this.j(bVar, this.f45603a);
                return signatureJ != null ? c.this.new d(bVar, signatureK, signatureJ) : c.this.new e(bVar, signatureK);
            }
            List<PublicKey> listA = ((CompositePublicKey) publicKey).a();
            for (int i10 = 0; i10 != listA.size(); i10++) {
                try {
                    Signature signatureK2 = c.this.k(bVar, listA.get(i10));
                    Signature signatureJ2 = c.this.j(bVar, listA.get(i10));
                    return signatureJ2 != null ? c.this.new d(bVar, signatureK2, signatureJ2) : c.this.new e(bVar, signatureK2);
                } catch (OperatorCreationException unused) {
                }
            }
            throw new OperatorCreationException("no matching algorithm found for key");
        }

        @Override // cs.h
        public X509CertificateHolder c() {
            return null;
        }

        @Override // cs.h
        public boolean d() {
            return false;
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.operator.jcajce.c$c, reason: collision with other inner class name */
    public class C0514c implements cs.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Signature[] f45605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public OutputStream f45606b;

        public C0514c(Signature[] signatureArr) throws OperatorCreationException {
            this.f45605a = signatureArr;
            int i10 = 0;
            while (i10 < signatureArr.length && signatureArr[i10] == null) {
                i10++;
            }
            if (i10 == signatureArr.length) {
                throw new OperatorCreationException("no matching signature found in composite");
            }
            OutputStream outputStreamB = lq.f.b(signatureArr[i10]);
            while (true) {
                this.f45606b = outputStreamB;
                do {
                    i10++;
                    if (i10 == signatureArr.length) {
                        return;
                    }
                } while (signatureArr[i10] == null);
                outputStreamB = new kt.e(this.f45606b, lq.f.b(signatureArr[i10]));
            }
        }

        @Override // cs.g
        public zn.b a() {
            return new zn.b(in.c.N);
        }

        @Override // cs.g
        public OutputStream b() {
            return this.f45606b;
        }

        @Override // cs.g
        public boolean verify(byte[] bArr) {
            try {
                f0 f0VarJ = f0.J(bArr);
                boolean z10 = false;
                for (int i10 = 0; i10 != f0VarJ.size(); i10++) {
                    Signature[] signatureArr = this.f45605a;
                    if (signatureArr[i10] != null && !signatureArr[i10].verify(u1.S(f0VarJ.K(i10)).H())) {
                        z10 = true;
                    }
                }
                return !z10;
            } catch (SignatureException e10) {
                throw new RuntimeOperatorException("exception obtaining signature: " + e10.getMessage(), e10);
            }
        }
    }

    public class d extends e implements e0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Signature f45608e;

        public d(zn.b bVar, Signature signature, Signature signature2) {
            super(bVar, signature);
            this.f45608e = signature2;
        }

        @Override // cs.e0
        public boolean c(byte[] bArr, byte[] bArr2) {
            try {
                try {
                    this.f45608e.update(bArr);
                    return this.f45608e.verify(bArr2);
                } finally {
                    try {
                        this.f45608e.verify(bArr2);
                    } catch (Exception unused) {
                    }
                }
            } catch (SignatureException e10) {
                throw new RuntimeOperatorException("exception obtaining raw signature: " + e10.getMessage(), e10);
            }
        }

        @Override // org.bouncycastle.operator.jcajce.c.e, cs.g
        public boolean verify(byte[] bArr) {
            try {
                return super.verify(bArr);
            } finally {
                try {
                    this.f45608e.verify(bArr);
                } catch (Exception unused) {
                }
            }
        }
    }

    public class e implements cs.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final zn.b f45610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Signature f45611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OutputStream f45612c;

        public e(zn.b bVar, Signature signature) {
            this.f45610a = bVar;
            this.f45611b = signature;
            this.f45612c = lq.f.b(signature);
        }

        @Override // cs.g
        public zn.b a() {
            return this.f45610a;
        }

        @Override // cs.g
        public OutputStream b() {
            OutputStream outputStream = this.f45612c;
            if (outputStream != null) {
                return outputStream;
            }
            throw new IllegalStateException("verifier not initialised");
        }

        @Override // cs.g
        public boolean verify(byte[] bArr) {
            try {
                return this.f45611b.verify(bArr);
            } catch (SignatureException e10) {
                throw new RuntimeOperatorException("exception obtaining signature: " + e10.getMessage(), e10);
            }
        }
    }

    public cs.h e(PublicKey publicKey) throws OperatorCreationException {
        return new b(publicKey);
    }

    public cs.h f(X509Certificate x509Certificate) throws OperatorCreationException {
        try {
            return new a(new JcaX509CertificateHolder(x509Certificate), x509Certificate);
        } catch (CertificateEncodingException e10) {
            throw new OperatorCreationException("cannot process certificate: " + e10.getMessage(), e10);
        }
    }

    public cs.h g(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
        return f(this.f45599a.a(x509CertificateHolder));
    }

    public cs.h h(c1 c1Var) throws OperatorCreationException {
        return e(this.f45599a.b(c1Var));
    }

    public final cs.g i(zn.b bVar, PublicKey publicKey) throws OperatorCreationException {
        int i10 = 0;
        if (!(publicKey instanceof CompositePublicKey)) {
            f0 f0VarJ = f0.J(bVar.A());
            Signature[] signatureArr = new Signature[f0VarJ.size()];
            while (i10 != f0VarJ.size()) {
                try {
                    signatureArr[i10] = k(zn.b.z(f0VarJ.K(i10)), publicKey);
                } catch (Exception unused) {
                    signatureArr[i10] = null;
                }
                i10++;
            }
            return new C0514c(signatureArr);
        }
        List<PublicKey> listA = ((CompositePublicKey) publicKey).a();
        f0 f0VarJ2 = f0.J(bVar.A());
        Signature[] signatureArr2 = new Signature[f0VarJ2.size()];
        while (i10 != f0VarJ2.size()) {
            zn.b bVarZ = zn.b.z(f0VarJ2.K(i10));
            if (listA.get(i10) != null) {
                signatureArr2[i10] = k(bVarZ, listA.get(i10));
            } else {
                signatureArr2[i10] = null;
            }
            i10++;
        }
        return new C0514c(signatureArr2);
    }

    public final Signature j(zn.b bVar, PublicKey publicKey) {
        try {
            Signature signatureI = this.f45599a.i(bVar);
            if (signatureI == null) {
                return signatureI;
            }
            signatureI.initVerify(publicKey);
            return signatureI;
        } catch (Exception unused) {
            return null;
        }
    }

    public final Signature k(zn.b bVar, PublicKey publicKey) throws OperatorCreationException {
        try {
            Signature signatureJ = this.f45599a.j(bVar);
            signatureJ.initVerify(publicKey);
            return signatureJ;
        } catch (GeneralSecurityException e10) {
            throw new OperatorCreationException("exception on setup: " + e10, e10);
        }
    }

    public c l(String str) {
        this.f45599a = new OperatorHelper(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public c m(Provider provider) {
        this.f45599a = new OperatorHelper(new org.bouncycastle.jcajce.util.i(provider));
        return this;
    }
}
