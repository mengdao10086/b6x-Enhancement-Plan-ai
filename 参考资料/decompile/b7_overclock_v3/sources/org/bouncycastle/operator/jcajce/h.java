package org.bouncycastle.operator.jcajce;

import cs.s;
import cs.t;
import gm.y;
import gm.z;
import java.io.InputStream;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f45631a = new org.bouncycastle.jcajce.util.c();

    public class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cipher f45632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public zn.b f45633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f45634c;

        /* JADX INFO: renamed from: org.bouncycastle.operator.jcajce.h$a$a, reason: collision with other inner class name */
        public class C0516a implements s {
            public C0516a() {
            }

            @Override // cs.s
            public zn.b a() {
                return a.this.f45633b;
            }

            @Override // cs.s
            public InputStream b(InputStream inputStream) {
                return new lq.a(inputStream, a.this.f45632a);
            }
        }

        public a(byte[] bArr) {
            this.f45634c = bArr;
        }

        @Override // cs.t
        public s a(zn.b bVar) throws OperatorCreationException {
            Cipher cipher;
            AlgorithmParameterSpec jVar;
            this.f45633b = bVar;
            y yVarX = bVar.x();
            try {
                this.f45632a = h.this.f45631a.i(yVarX.L());
                SecretKeySpec secretKeySpec = new SecretKeySpec(this.f45634c, yVarX.L());
                gm.h hVarA = bVar.A();
                if (hVarA instanceof z) {
                    cipher = this.f45632a;
                    jVar = new IvParameterSpec(z.I(hVarA).J());
                } else {
                    qm.d dVarA = qm.d.A(hVarA);
                    cipher = this.f45632a;
                    jVar = new cr.j(dVarA.x(), dVarA.y());
                }
                cipher.init(2, secretKeySpec, jVar);
                return new C0516a();
            } catch (Exception e10) {
                throw new OperatorCreationException("unable to create InputDecryptor: " + e10.getMessage(), e10);
            }
        }
    }

    public t b(byte[] bArr) {
        return new a(org.bouncycastle.util.a.p(bArr));
    }

    public h c(String str) {
        this.f45631a = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public h d(Provider provider) {
        this.f45631a = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }
}
