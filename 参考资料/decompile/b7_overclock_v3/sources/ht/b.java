package ht;

import gm.c2;
import gm.e1;
import gt.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import mm.k;
import mm.n;
import mm.v;
import mm.x0;
import mm.y0;
import mm.z0;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes6.dex */
public class b extends d {
    public a f(h hVar) throws CMSException {
        return g(hVar, null);
    }

    public a g(h hVar, InputStream inputStream) throws CMSException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (inputStream != null) {
            try {
                kt.c.b(inputStream, byteArrayOutputStream);
            } catch (IOException e10) {
                throw new CMSException("exception encapsulating content: " + e10.getMessage(), e10);
            }
        }
        return new a(new n(k.S2, new z0(this.f31444b != null ? new c2(this.f31444b.toString()) : null, this.f31443a, byteArrayOutputStream.size() != 0 ? new e1(byteArrayOutputStream.toByteArray()) : null, new v(new y0(new x0(hVar.l().q()))))));
    }

    public a h(h hVar, byte[] bArr) throws CMSException {
        return g(hVar, new ByteArrayInputStream(bArr));
    }
}
