package so;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class o extends r {
    public o(InputStream inputStream) throws CMSException {
        super(inputStream);
    }

    public o(byte[] bArr) throws CMSException {
        this(new ByteArrayInputStream(bArr));
    }

    public s0 b(cs.v vVar) throws CMSException {
        try {
            mm.m mVar = new mm.m((gm.g0) this.f50297a.a(16));
            mm.o oVarB = mVar.b();
            return new s0(oVarB.b(), vVar.a(mVar.a()).b(((gm.a0) oVarB.a(4)).a()));
        } catch (IOException e10) {
            throw new CMSException("IOException reading compressed content.", e10);
        }
    }
}
