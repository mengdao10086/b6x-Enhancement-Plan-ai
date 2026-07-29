package org.bouncycastle.cms.jcajce;

import java.security.Key;
import java.security.Provider;
import javax.crypto.SecretKey;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorException;
import so.y0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class r implements y0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecretKey f44622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f44623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f44624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f44625f;

    public r(SecretKey secretKey) {
        c cVar = new c(new b());
        this.f44623d = cVar;
        this.f44624e = cVar;
        this.f44625f = false;
        this.f44622c = secretKey;
    }

    public Key g(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        try {
            Key keyW = this.f44623d.w(bVar2.x(), this.f44623d.p(bVar, this.f44622c).b(bVar2, bArr));
            if (this.f44625f) {
                this.f44623d.y(bVar2, keyW);
            }
            return keyW;
        } catch (OperatorException e10) {
            throw new CMSException("exception unwrapping key: " + e10.getMessage(), e10);
        }
    }

    public r h(String str) {
        this.f44624e = new c(new m0(str));
        return this;
    }

    public r i(Provider provider) {
        this.f44624e = new c(new n0(provider));
        return this;
    }

    public r j(boolean z10) {
        this.f44625f = z10;
        return this;
    }

    public r k(String str) {
        c cVar = new c(new m0(str));
        this.f44623d = cVar;
        this.f44624e = cVar;
        return this;
    }

    public r l(Provider provider) {
        c cVar = new c(new n0(provider));
        this.f44623d = cVar;
        this.f44624e = cVar;
        return this;
    }
}
