package wo;

import gm.f2;
import gm.h;
import gm.i;
import gm.j;
import gm.j2;
import gm.n2;
import gm.y;
import java.io.IOException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.q;
import org.bouncycastle.crypto.r;
import org.bouncycastle.crypto.s;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public class c implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f54761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f54762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f54763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f54764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f54765e;

    public c(s sVar) {
        this.f54761a = sVar;
    }

    @Override // org.bouncycastle.crypto.q
    public void a(r rVar) {
        b bVar = (b) rVar;
        this.f54762b = bVar.a();
        this.f54763c = bVar.c();
        this.f54764d = bVar.d();
        this.f54765e = bVar.b();
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        boolean z10;
        int i12 = i11;
        int i13 = i10;
        if (bArr.length - i12 < i13) {
            throw new OutputLengthException("output buffer too small");
        }
        long j10 = i12;
        int iH = this.f54761a.h();
        if (j10 > 8589934591L) {
            throw new IllegalArgumentException("Output length too large");
        }
        long j11 = iH;
        int i14 = (int) (((j10 + j11) - 1) / j11);
        byte[] bArr2 = new byte[this.f54761a.h()];
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i16 < i14) {
            s sVar = this.f54761a;
            byte[] bArr3 = this.f54764d;
            sVar.update(bArr3, i15, bArr3.length);
            i iVar = new i();
            i iVar2 = new i();
            iVar2.a(this.f54762b);
            iVar2.a(new f2(o.k(i17)));
            iVar.a(new j2(iVar2));
            if (this.f54765e != null) {
                z10 = true;
                iVar.a(new n2(true, i15, (h) new f2(this.f54765e)));
            } else {
                z10 = true;
            }
            iVar.a(new n2(z10, 2, new f2(o.k(this.f54763c))));
            try {
                byte[] bArrV = new j2(iVar).v(j.f29713a);
                this.f54761a.update(bArrV, 0, bArrV.length);
                this.f54761a.c(bArr2, 0);
                if (i12 > iH) {
                    System.arraycopy(bArr2, 0, bArr, i13, iH);
                    i13 += iH;
                    i12 -= iH;
                } else {
                    System.arraycopy(bArr2, 0, bArr, i13, i12);
                }
                i17++;
                i16++;
                i15 = 0;
            } catch (IOException e10) {
                throw new IllegalArgumentException("unable to encode parameter info: " + e10.getMessage());
            }
        }
        this.f54761a.reset();
        return (int) j10;
    }

    public s c() {
        return this.f54761a;
    }
}
