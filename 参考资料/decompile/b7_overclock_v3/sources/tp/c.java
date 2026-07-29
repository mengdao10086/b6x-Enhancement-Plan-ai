package tp;

import gm.j;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.eac.EACException;
import org.bouncycastle.eac.EACIOException;
import sm.l;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sm.b f51571a;

    public c(sm.b bVar) {
        this.f51571a = bVar;
    }

    public c(byte[] bArr) throws IOException {
        this(c(bArr));
    }

    public static sm.b c(byte[] bArr) throws IOException {
        try {
            return sm.b.z(bArr);
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
        return this.f51571a.B();
    }

    public boolean b(vp.a aVar) throws EACException {
        try {
            OutputStream outputStreamB = aVar.b();
            outputStreamB.write(this.f51571a.x().v(j.f29713a));
            outputStreamB.close();
            return aVar.verify(this.f51571a.y());
        } catch (Exception e10) {
            throw new EACException("unable to process signature: " + e10.getMessage(), e10);
        }
    }

    public sm.b d() {
        return this.f51571a;
    }
}
