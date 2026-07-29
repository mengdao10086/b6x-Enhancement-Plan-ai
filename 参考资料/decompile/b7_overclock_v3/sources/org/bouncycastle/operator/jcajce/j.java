package org.bouncycastle.operator.jcajce;

import co.r;
import cr.m;
import cs.q;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import javax.crypto.Cipher;
import mm.q0;
import mm.x;
import org.bouncycastle.crypto.util.e;
import org.bouncycastle.operator.OperatorException;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class j extends cs.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f45642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f45644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f45645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OperatorHelper f45646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PublicKey f45647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SecureRandom f45648h;

    public j(PublicKey publicKey, String str, int i10, byte[] bArr, byte[] bArr2) {
        super(new zn.b(s.f46798d5, new x(new zn.b(fn.a.f28528h, new q0(new zn.b(r.f11187r1, new zn.b(kn.d.f37592c)), (i10 + 7) / 8)), l.c(str, i10))));
        this.f45646f = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45647g = publicKey;
        this.f45642b = str;
        this.f45643c = i10;
        this.f45644d = org.bouncycastle.util.a.p(bArr);
        this.f45645e = org.bouncycastle.util.a.p(bArr2);
    }

    public j(X509Certificate x509Certificate, String str, int i10, byte[] bArr, byte[] bArr2) {
        this(x509Certificate.getPublicKey(), str, i10, bArr, bArr2);
    }

    @Override // cs.x
    public byte[] b(q qVar) throws OperatorException {
        Cipher cipherD = this.f45646f.d(a().x(), new HashMap());
        try {
            cipherD.init(3, this.f45647g, new m.b(this.f45642b, this.f45643c, new e.b(l.c(this.f45642b, this.f45643c), this.f45644d, this.f45645e).a().a()).a(), this.f45648h);
            return cipherD.wrap(m.a(qVar));
        } catch (Exception e10) {
            throw new OperatorException("Unable to wrap contents key: " + e10.getMessage(), e10);
        }
    }

    public j c(String str) {
        this.f45646f = new OperatorHelper(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public j d(Provider provider) {
        this.f45646f = new OperatorHelper(new org.bouncycastle.jcajce.util.i(provider));
        return this;
    }

    public j e(SecureRandom secureRandom) {
        this.f45648h = secureRandom;
        return this;
    }
}
