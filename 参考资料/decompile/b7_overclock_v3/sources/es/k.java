package es;

import cs.t;
import gm.c0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.pkcs.PKCSException;
import org.bouncycastle.pkcs.PKCSIOException;
import pn.u;

/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pn.j f27128a;

    public k(pn.j jVar) {
        this.f27128a = jVar;
    }

    public k(byte[] bArr) throws IOException {
        this(e(bArr));
    }

    public static pn.j e(byte[] bArr) throws IOException {
        try {
            return pn.j.z(c0.D(bArr));
        } catch (ClassCastException e10) {
            throw new PKCSIOException("malformed data: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new PKCSIOException("malformed data: " + e11.getMessage(), e11);
        }
    }

    public u a(t tVar) throws PKCSException {
        try {
            return u.z(kt.c.e(tVar.a(this.f27128a.y()).b(new ByteArrayInputStream(this.f27128a.x()))));
        } catch (Exception e10) {
            throw new PKCSException("unable to read encrypted data: " + e10.getMessage(), e10);
        }
    }

    public byte[] b() throws IOException {
        return this.f27128a.getEncoded();
    }

    public byte[] c() {
        return this.f27128a.x();
    }

    public zn.b d() {
        return this.f27128a.y();
    }

    public pn.j f() {
        return this.f27128a;
    }
}
