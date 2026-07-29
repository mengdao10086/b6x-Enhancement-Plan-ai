package es;

import cs.y;
import java.io.OutputStream;
import org.bouncycastle.pkcs.PKCSException;
import pn.n;
import pn.r;
import zn.t;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f27112a;

    public a(d dVar) {
        this.f27112a = dVar;
    }

    public n a(char[] cArr, byte[] bArr) throws PKCSException {
        try {
            y yVarB = this.f27112a.b(cArr);
            OutputStream outputStreamB = yVarB.b();
            outputStreamB.write(bArr);
            outputStreamB.close();
            zn.b bVarA = yVarB.a();
            t tVar = new t(this.f27112a.a(), yVarB.d());
            r rVarY = r.y(bVarA.A());
            return new n(tVar, rVarY.x(), rVarY.z().intValue());
        } catch (Exception e10) {
            throw new PKCSException("unable to process data: " + e10.getMessage(), e10);
        }
    }
}
