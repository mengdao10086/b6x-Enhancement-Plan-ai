package ws;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.n;
import org.bouncycastle.crypto.y;
import org.bouncycastle.pqc.crypto.lms.LMOtsParameters;
import org.bouncycastle.pqc.crypto.lms.LMSigParameters;
import org.bouncycastle.pqc.crypto.lms.e;
import org.bouncycastle.pqc.crypto.lms.f;
import org.bouncycastle.pqc.crypto.lms.g;
import org.bouncycastle.pqc.crypto.lms.q;
import org.bouncycastle.pqc.crypto.lms.r;
import org.bouncycastle.pqc.crypto.lms.t;
import org.bouncycastle.pqc.crypto.lms.u;
import org.bouncycastle.pqc.crypto.lms.v;
import org.bouncycastle.pqc.jcajce.provider.lms.BCLMSPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.lms.BCLMSPublicKey;

/* JADX INFO: loaded from: classes6.dex */
public class c extends KeyPairGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f54798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.y f54799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public org.bouncycastle.crypto.d f54800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f54801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f54802e;

    public c() {
        super("LMS");
        this.f54800c = new r();
        this.f54801d = n.f();
        this.f54802e = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.f54802e) {
            q qVar = new q(new t(LMSigParameters.f45719f, LMOtsParameters.f45707j), this.f54801d);
            this.f54798a = qVar;
            this.f54800c.a(qVar);
            this.f54802e = true;
        }
        org.bouncycastle.crypto.c cVarB = this.f54800c.b();
        if (this.f54800c instanceof r) {
            return new KeyPair(new BCLMSPublicKey((v) cVarB.b()), new BCLMSPrivateKey((u) cVarB.a()));
        }
        return new KeyPair(new BCLMSPublicKey((g) cVarB.b()), new BCLMSPrivateKey((f) cVarB.a()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i10, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        org.bouncycastle.crypto.d eVar;
        if (algorithmParameterSpec instanceof et.c) {
            et.c cVar = (et.c) algorithmParameterSpec;
            this.f54798a = new q(new t(cVar.b(), cVar.a()), secureRandom);
            eVar = new r();
        } else {
            int i10 = 0;
            if (algorithmParameterSpec instanceof et.a) {
                et.c[] cVarArrA = ((et.a) algorithmParameterSpec).a();
                t[] tVarArr = new t[cVarArrA.length];
                while (i10 != cVarArrA.length) {
                    tVarArr[i10] = new t(cVarArrA[i10].b(), cVarArrA[i10].a());
                    i10++;
                }
                this.f54798a = new org.bouncycastle.pqc.crypto.lms.d(tVarArr, secureRandom);
                eVar = new e();
            } else if (algorithmParameterSpec instanceof et.d) {
                et.d dVar = (et.d) algorithmParameterSpec;
                this.f54798a = new q(new t(dVar.b(), dVar.a()), secureRandom);
                eVar = new r();
            } else {
                if (!(algorithmParameterSpec instanceof et.b)) {
                    throw new InvalidAlgorithmParameterException("parameter object not a LMSParameterSpec/LMSHSSParameterSpec");
                }
                et.d[] dVarArrA = ((et.b) algorithmParameterSpec).a();
                t[] tVarArr2 = new t[dVarArrA.length];
                while (i10 != dVarArrA.length) {
                    tVarArr2[i10] = new t(dVarArrA[i10].b(), dVarArrA[i10].a());
                    i10++;
                }
                this.f54798a = new org.bouncycastle.pqc.crypto.lms.d(tVarArr2, secureRandom);
                eVar = new e();
            }
        }
        this.f54800c = eVar;
        eVar.a(this.f54798a);
        this.f54802e = true;
    }
}
