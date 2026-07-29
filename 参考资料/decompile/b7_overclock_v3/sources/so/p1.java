package so;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.cms.CMSRuntimeException;

/* JADX INFO: loaded from: classes5.dex */
public class p1 extends s0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gm.h f50285d;

    public p1(gm.y yVar, gm.h hVar) throws IOException {
        super(yVar);
        this.f50285d = hVar;
    }

    @Override // so.s0
    public void a() throws IOException {
        this.f50285d.b();
    }

    @Override // so.s0
    public InputStream b() {
        try {
            return e(this.f50285d);
        } catch (IOException e10) {
            throw new CMSRuntimeException("unable to convert content to stream: " + e10.getMessage(), e10);
        }
    }

    public gm.h d() {
        return this.f50285d;
    }

    public final InputStream e(gm.h hVar) throws IOException {
        int i10;
        byte[] bArrV = hVar.b().v(gm.j.f29713a);
        int i11 = 1;
        if ((bArrV[0] & 31) == 31) {
            do {
                i10 = bArrV[i11] & 128;
                i11++;
            } while (i10 != 0);
        }
        int i12 = i11 + 1;
        byte b10 = bArrV[i11];
        if ((b10 & 128) != 0) {
            i12 += b10 & 127;
        }
        return new ByteArrayInputStream(bArrV, i12, bArrV.length - i12);
    }
}
