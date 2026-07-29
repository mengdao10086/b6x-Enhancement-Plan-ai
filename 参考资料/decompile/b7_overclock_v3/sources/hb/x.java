package hb;

import com.google.android.exoplayer2.metadata.Metadata;
import g.p0;
import java.io.EOFException;
import java.io.IOException;
import zb.b;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hd.c0 f30925a = new hd.c0(10);

    @p0
    public Metadata a(l lVar, @p0 b.a aVar) throws IOException {
        Metadata metadataE = null;
        int i10 = 0;
        while (true) {
            try {
                lVar.t(this.f30925a.d(), 0, 10);
                this.f30925a.S(0);
                if (this.f30925a.J() != 4801587) {
                    break;
                }
                this.f30925a.T(3);
                int iF = this.f30925a.F();
                int i11 = iF + 10;
                if (metadataE == null) {
                    byte[] bArr = new byte[i11];
                    System.arraycopy(this.f30925a.d(), 0, bArr, 0, 10);
                    lVar.t(bArr, 10, iF);
                    metadataE = new zb.b(aVar).e(bArr, i11);
                } else {
                    lVar.j(iF);
                }
                i10 += i11;
            } catch (EOFException unused) {
            }
        }
        lVar.n();
        lVar.j(i10);
        return metadataE;
    }
}
