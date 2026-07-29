package org.bouncycastle.cms.jcajce;

import gm.f2;
import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorException;
import so.g1;
import so.h1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class v implements g1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f44633j = jt.h.b("0c14416e6f6e796d6f75732053656e64657220202020");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f44634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PrivateKey f44635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f44636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f44637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map f44638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f44639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f44640i;

    public v(PrivateKey privateKey, byte[] bArr) {
        c cVar = new c(new b());
        this.f44636e = cVar;
        this.f44637f = cVar;
        this.f44638g = new HashMap();
        this.f44639h = false;
        this.f44635d = a.a(privateKey);
        this.f44634c = bArr;
    }

    public static byte[] h(h1 h1Var) throws IOException {
        return h1Var.c() != null ? new mm.y(h1Var.b(), h1Var.c()).v(gm.j.f29713a) : new f2(h1Var.d()).getEncoded();
    }

    public Key g(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        try {
            Key keyW = this.f44636e.w(bVar2.x(), this.f44636e.e(bVar, this.f44635d, f44633j, this.f44634c).b(bVar2, bArr));
            if (this.f44639h) {
                this.f44636e.y(bVar2, keyW);
            }
            return keyW;
        } catch (OperatorException e10) {
            throw new CMSException("exception unwrapping key: " + e10.getMessage(), e10);
        }
    }

    public v i(gm.y yVar, String str) {
        this.f44638g.put(yVar, str);
        return this;
    }

    public v j(String str) {
        this.f44637f = a.b(str);
        return this;
    }

    public v k(Provider provider) {
        this.f44637f = a.c(provider);
        return this;
    }

    public v l(boolean z10) {
        this.f44639h = z10;
        return this;
    }

    public v m(String str) {
        c cVar = new c(new m0(str));
        this.f44636e = cVar;
        this.f44637f = cVar;
        return this;
    }

    public v n(Provider provider) {
        c cVar = new c(new n0(provider));
        this.f44636e = cVar;
        this.f44637f = cVar;
        return this;
    }
}
