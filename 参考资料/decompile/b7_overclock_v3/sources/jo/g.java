package jo;

import cs.o;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.cert.dane.DANEException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f36536a;

    public g(o oVar) {
        this.f36536a = oVar;
    }

    public f a(String str) throws DANEException {
        byte[] bArrM = Strings.m(str.substring(0, str.indexOf(64)));
        try {
            OutputStream outputStreamB = this.f36536a.b();
            outputStreamB.write(bArrM);
            outputStreamB.close();
            return new f(Strings.c(jt.h.h(this.f36536a.c())) + "._smimecert." + str.substring(str.indexOf(64) + 1));
        } catch (IOException e10) {
            throw new DANEException("Unable to calculate digest string: " + e10.getMessage(), e10);
        }
    }
}
