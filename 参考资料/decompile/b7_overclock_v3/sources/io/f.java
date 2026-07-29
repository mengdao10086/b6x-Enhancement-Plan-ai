package io;

import cs.s;
import go.q;
import java.io.InputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.jcajce.util.i;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes5.dex */
public class f implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PrivateKey f32594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.a f32595b = new io.a(new org.bouncycastle.jcajce.util.c());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Provider f32596c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f32597d = null;

    public class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f32598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Cipher f32599b;

        public a(zn.b bVar, Cipher cipher) {
            this.f32598a = bVar;
            this.f32599b = cipher;
        }

        @Override // cs.s
        public zn.b a() {
            return this.f32598a;
        }

        @Override // cs.s
        public InputStream b(InputStream inputStream) {
            return new lq.a(inputStream, this.f32599b);
        }
    }

    public f(PrivateKey privateKey) {
        this.f32594a = privateKey;
    }

    @Override // go.q
    public s a(zn.b bVar, zn.b bVar2, byte[] bArr) throws CRMFException {
        return new a(bVar2, this.f32595b.d(b(bVar, bVar2, bArr), bVar2));
    }

    public final Key b(zn.b bVar, zn.b bVar2, byte[] bArr) throws CRMFException {
        try {
            org.bouncycastle.operator.jcajce.e eVar = new org.bouncycastle.operator.jcajce.e(bVar, this.f32594a);
            Provider provider = this.f32596c;
            if (provider != null) {
                eVar.f(provider);
            }
            String str = this.f32597d;
            if (str != null) {
                eVar.e(str);
            }
            return new SecretKeySpec((byte[]) eVar.b(bVar2, bArr).b(), bVar2.x().L());
        } catch (OperatorException e10) {
            throw new CRMFException("key invalid in message: " + e10.getMessage(), e10);
        }
    }

    public f c(String str) {
        this.f32595b = new io.a(new org.bouncycastle.jcajce.util.g(str));
        this.f32596c = null;
        this.f32597d = str;
        return this;
    }

    public f d(Provider provider) {
        this.f32595b = new io.a(new i(provider));
        this.f32596c = provider;
        this.f32597d = null;
        return this;
    }
}
