package sp;

import java.io.OutputStream;
import org.bouncycastle.dvcs.DVCSException;
import zn.t;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cs.o f50377a;

    public l(cs.o oVar) {
        this.f50377a = oVar;
    }

    public k a(byte[] bArr) throws DVCSException {
        try {
            OutputStream outputStreamB = this.f50377a.b();
            outputStreamB.write(bArr);
            outputStreamB.close();
            return new k(new t(this.f50377a.a(), this.f50377a.c()));
        } catch (Exception e10) {
            throw new DVCSException("unable to build MessageImprint: " + e10.getMessage(), e10);
        }
    }
}
