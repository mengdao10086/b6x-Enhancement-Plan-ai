package zr;

import java.io.IOException;
import java.io.Writer;
import org.bouncycastle.util.io.pem.PemGenerationException;

/* JADX INFO: loaded from: classes6.dex */
public class j extends lt.f {
    public j(Writer writer) {
        super(writer);
    }

    @Override // lt.f
    public void d(lt.c cVar) throws IOException {
        super.d(cVar);
    }

    public void i(Object obj) throws IOException {
        k(obj, null);
    }

    public void k(Object obj, f fVar) throws IOException {
        try {
            super.d(new bs.a(obj, fVar));
        } catch (PemGenerationException e10) {
            if (!(e10.getCause() instanceof IOException)) {
                throw e10;
            }
            throw ((IOException) e10.getCause());
        }
    }
}
