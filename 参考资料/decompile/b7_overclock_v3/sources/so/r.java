package so;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mm.o f50297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputStream f50298b;

    public r(InputStream inputStream) throws CMSException {
        this.f50298b = inputStream;
        try {
            gm.g0 g0Var = (gm.g0) new gm.j0(inputStream).j();
            if (g0Var == null) {
                throw new CMSException("No content found.");
            }
            this.f50297a = new mm.o(g0Var);
        } catch (IOException e10) {
            throw new CMSException("IOException reading content.", e10);
        } catch (ClassCastException e11) {
            throw new CMSException("Unexpected object reading content.", e11);
        }
    }

    public void a() throws IOException {
        this.f50298b.close();
    }
}
