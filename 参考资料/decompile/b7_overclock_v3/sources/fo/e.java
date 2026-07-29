package fo;

import gm.c0;
import java.io.IOException;
import lm.s;
import lm.w;
import lm.y;
import org.bouncycastle.cert.CertIOException;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f28536a;

    public e(y yVar) {
        this.f28536a = yVar;
    }

    public e(byte[] bArr) throws IOException {
        this(d(bArr));
    }

    public static y d(byte[] bArr) throws IOException {
        try {
            return y.B(c0.D(bArr));
        } catch (ClassCastException e10) {
            throw new CertIOException("malformed data: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new CertIOException("malformed data: " + e11.getMessage(), e11);
        }
    }

    public s a() {
        return this.f28536a.y();
    }

    public w b() {
        return this.f28536a.A();
    }

    public boolean c() {
        return this.f28536a.A().C() != null;
    }

    public y e() {
        return this.f28536a;
    }
}
