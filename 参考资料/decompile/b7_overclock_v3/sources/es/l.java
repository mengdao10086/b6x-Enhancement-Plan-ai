package es;

import cs.d0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import pn.u;

/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f27129a;

    public l(u uVar) {
        this.f27129a = uVar;
    }

    public l(byte[] bArr) {
        this(u.z(bArr));
    }

    public k a(d0 d0Var) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream outputStreamB = d0Var.b(byteArrayOutputStream);
            outputStreamB.write(this.f27129a.getEncoded());
            outputStreamB.close();
            return new k(new pn.j(d0Var.a(), byteArrayOutputStream.toByteArray()));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode privateKeyInfo");
        }
    }
}
