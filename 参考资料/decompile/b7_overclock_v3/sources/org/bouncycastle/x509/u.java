package org.bouncycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Collection;
import org.bouncycastle.x509.util.StreamParsingException;
import org.bouncycastle.x509.w;

/* JADX INFO: loaded from: classes6.dex */
public class u implements ot.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Provider f46143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f46144b;

    public u(Provider provider, v vVar) {
        this.f46143a = provider;
        this.f46144b = vVar;
    }

    public static u b(w.a aVar) {
        return new u(aVar.b(), (v) aVar.a());
    }

    public static u c(String str) throws NoSuchParserException {
        try {
            return b(w.g("X509StreamParser", str));
        } catch (NoSuchAlgorithmException e10) {
            throw new NoSuchParserException(e10.getMessage());
        }
    }

    public static u d(String str, String str2) throws NoSuchParserException, NoSuchProviderException {
        return e(str, w.i(str2));
    }

    public static u e(String str, Provider provider) throws NoSuchParserException {
        try {
            return b(w.h("X509StreamParser", str, provider));
        } catch (NoSuchAlgorithmException e10) {
            throw new NoSuchParserException(e10.getMessage());
        }
    }

    @Override // ot.b
    public Collection a() throws StreamParsingException {
        return this.f46144b.c();
    }

    public Provider f() {
        return this.f46143a;
    }

    public void g(InputStream inputStream) {
        this.f46144b.a(inputStream);
    }

    public void h(byte[] bArr) {
        this.f46144b.a(new ByteArrayInputStream(bArr));
    }

    @Override // ot.b
    public Object read() throws StreamParsingException {
        return this.f46144b.b();
    }
}
