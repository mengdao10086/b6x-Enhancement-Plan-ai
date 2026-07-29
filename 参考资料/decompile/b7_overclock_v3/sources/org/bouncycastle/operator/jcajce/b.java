package org.bouncycastle.operator.jcajce;

import com.blankj.utilcode.util.i0;
import gm.d2;
import gm.f0;
import gm.j2;
import gm.t;
import gm.u1;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.List;
import org.bouncycastle.jcajce.CompositePrivateKey;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.RuntimeOperatorException;
import pn.a0;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OperatorHelper f45586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f45587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f45588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zn.b f45589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AlgorithmParameterSpec f45590e;

    public class a implements cs.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OutputStream f45591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Signature f45592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ zn.b f45593c;

        public a(Signature signature, zn.b bVar) {
            this.f45592b = signature;
            this.f45593c = bVar;
            this.f45591a = lq.f.b(signature);
        }

        @Override // cs.f
        public zn.b a() {
            return this.f45593c;
        }

        @Override // cs.f
        public OutputStream b() {
            return this.f45591a;
        }

        @Override // cs.f
        public byte[] getSignature() {
            try {
                return this.f45592b.sign();
            } catch (SignatureException e10) {
                throw new RuntimeOperatorException("exception obtaining signature: " + e10.getMessage(), e10);
            }
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.operator.jcajce.b$b, reason: collision with other inner class name */
    public class C0513b implements cs.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OutputStream f45595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OutputStream f45596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Signature[] f45597c;

        public C0513b(OutputStream outputStream, Signature[] signatureArr) {
            this.f45596b = outputStream;
            this.f45597c = signatureArr;
            this.f45595a = outputStream;
        }

        @Override // cs.f
        public zn.b a() {
            return b.this.f45589d;
        }

        @Override // cs.f
        public OutputStream b() {
            return this.f45595a;
        }

        @Override // cs.f
        public byte[] getSignature() {
            try {
                gm.i iVar = new gm.i();
                for (int i10 = 0; i10 != this.f45597c.length; i10++) {
                    iVar.a(new u1(this.f45597c[i10].sign()));
                }
                return new j2(iVar).v(gm.j.f29713a);
            } catch (IOException e10) {
                throw new RuntimeOperatorException("exception encoding signature: " + e10.getMessage(), e10);
            } catch (SignatureException e11) {
                throw new RuntimeOperatorException("exception obtaining signature: " + e11.getMessage(), e11);
            }
        }
    }

    public b(String str) {
        this.f45586a = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45588c = str;
        this.f45589d = new cs.l().a(str);
        this.f45590e = null;
    }

    public b(String str, AlgorithmParameterSpec algorithmParameterSpec) {
        zn.b bVar;
        this.f45586a = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45588c = str;
        if (algorithmParameterSpec instanceof PSSParameterSpec) {
            PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
            this.f45590e = pSSParameterSpec;
            bVar = new zn.b(s.G3, e(pSSParameterSpec));
        } else {
            if (!(algorithmParameterSpec instanceof cr.b)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unknown sigParamSpec: ");
                sb2.append(algorithmParameterSpec == null ? i0.f11859x : algorithmParameterSpec.getClass().getName());
                throw new IllegalArgumentException(sb2.toString());
            }
            cr.b bVar2 = (cr.b) algorithmParameterSpec;
            this.f45590e = bVar2;
            bVar = new zn.b(in.c.N, d(bVar2));
        }
        this.f45589d = bVar;
    }

    public static f0 d(cr.b bVar) {
        gm.h hVarE;
        cs.l lVar = new cs.l();
        gm.i iVar = new gm.i();
        List<String> listA = bVar.a();
        List<AlgorithmParameterSpec> listB = bVar.b();
        for (int i10 = 0; i10 != listA.size(); i10++) {
            AlgorithmParameterSpec algorithmParameterSpec = listB.get(i10);
            if (algorithmParameterSpec == null) {
                hVarE = lVar.a(listA.get(i10));
            } else {
                if (!(algorithmParameterSpec instanceof PSSParameterSpec)) {
                    throw new IllegalArgumentException("unrecognized parameterSpec");
                }
                hVarE = e((PSSParameterSpec) algorithmParameterSpec);
            }
            iVar.a(hVarE);
        }
        return new j2(iVar);
    }

    public static a0 e(PSSParameterSpec pSSParameterSpec) {
        cs.j jVar = new cs.j();
        zn.b bVarA = jVar.a(pSSParameterSpec.getDigestAlgorithm());
        if (bVarA.A() == null) {
            bVarA = new zn.b(bVarA.x(), d2.f29657b);
        }
        zn.b bVarA2 = jVar.a(((MGF1ParameterSpec) pSSParameterSpec.getMGFParameters()).getDigestAlgorithm());
        if (bVarA2.A() == null) {
            bVarA2 = new zn.b(bVarA2.x(), d2.f29657b);
        }
        return new a0(bVarA, new zn.b(s.E3, bVarA2), new t(pSSParameterSpec.getSaltLength()), new t(pSSParameterSpec.getTrailerField()));
    }

    public cs.f b(PrivateKey privateKey) throws OperatorCreationException {
        if (privateKey instanceof CompositePrivateKey) {
            return c((CompositePrivateKey) privateKey);
        }
        try {
            Signature signatureJ = this.f45586a.j(this.f45589d);
            zn.b bVar = this.f45589d;
            SecureRandom secureRandom = this.f45587b;
            if (secureRandom != null) {
                signatureJ.initSign(privateKey, secureRandom);
            } else {
                signatureJ.initSign(privateKey);
            }
            return new a(signatureJ, bVar);
        } catch (GeneralSecurityException e10) {
            throw new OperatorCreationException("cannot create signer: " + e10.getMessage(), e10);
        }
    }

    public final cs.f c(CompositePrivateKey compositePrivateKey) throws OperatorCreationException {
        try {
            List<PrivateKey> listA = compositePrivateKey.a();
            f0 f0VarJ = f0.J(this.f45589d.A());
            int size = f0VarJ.size();
            Signature[] signatureArr = new Signature[size];
            for (int i10 = 0; i10 != f0VarJ.size(); i10++) {
                signatureArr[i10] = this.f45586a.j(zn.b.z(f0VarJ.K(i10)));
                if (this.f45587b != null) {
                    signatureArr[i10].initSign(listA.get(i10), this.f45587b);
                } else {
                    signatureArr[i10].initSign(listA.get(i10));
                }
            }
            OutputStream outputStreamB = lq.f.b(signatureArr[0]);
            int i11 = 1;
            while (i11 != size) {
                kt.e eVar = new kt.e(outputStreamB, lq.f.b(signatureArr[i11]));
                i11++;
                outputStreamB = eVar;
            }
            return new C0513b(outputStreamB, signatureArr);
        } catch (GeneralSecurityException e10) {
            throw new OperatorCreationException("cannot create signer: " + e10.getMessage(), e10);
        }
    }

    public b f(String str) {
        this.f45586a = new OperatorHelper(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public b g(Provider provider) {
        this.f45586a = new OperatorHelper(new org.bouncycastle.jcajce.util.i(provider));
        return this;
    }

    public b h(SecureRandom secureRandom) {
        this.f45587b = secureRandom;
        return this;
    }
}
