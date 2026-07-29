package tp;

import gm.j;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.eac.EACException;
import org.bouncycastle.eac.EACIOException;
import sm.l;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sm.a f51570a;

    public b(sm.a aVar) {
        this.f51570a = aVar;
    }

    public b(byte[] bArr) throws IOException {
        this(c(bArr));
    }

    public static sm.a c(byte[] bArr) throws IOException {
        try {
            return sm.a.G(bArr);
        } catch (ClassCastException e10) {
            throw new EACIOException("malformed data: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new EACIOException("malformed data: " + e11.getMessage(), e11);
        } catch (ASN1ParsingException e12) {
            if (e12.getCause() instanceof IOException) {
                throw ((IOException) e12.getCause());
            }
            throw new EACIOException("malformed data: " + e12.getMessage(), e12);
        }
    }

    public l a() {
        return this.f51570a.y().F();
    }

    public boolean b(vp.a aVar) throws EACException {
        try {
            OutputStream outputStreamB = aVar.b();
            outputStreamB.write(this.f51570a.y().v(j.f29713a));
            outputStreamB.close();
            return aVar.verify(this.f51570a.I());
        } catch (Exception e10) {
            throw new EACException("unable to process signature: " + e10.getMessage(), e10);
        }
    }

    public sm.a d() {
        return this.f51570a;
    }
}
