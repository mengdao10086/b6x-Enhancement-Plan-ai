package wo;

import fp.z;
import gm.d2;
import gm.f2;
import gm.h;
import gm.i;
import gm.j;
import gm.j2;
import gm.n2;
import gm.y;
import java.io.IOException;
import np.m1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.r;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.t;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public class d implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f54766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f54767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f54768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f54769d;

    public d(s sVar) {
        this.f54766a = new z(sVar);
    }

    @Override // org.bouncycastle.crypto.q
    public void a(r rVar) {
        b bVar = (b) rVar;
        this.f54767b = bVar.a();
        this.f54768c = bVar.c();
        this.f54769d = bVar.d();
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("output buffer too small");
        }
        i iVar = new i();
        iVar.a(new zn.b(this.f54767b, d2.f29657b));
        iVar.a(new n2(true, 2, (h) new f2(o.k(this.f54768c))));
        try {
            this.f54766a.a(new m1(this.f54769d, new j2(iVar).v(j.f29713a)));
            return this.f54766a.b(bArr, i10, i11);
        } catch (IOException e10) {
            throw new IllegalArgumentException("unable to initialise kdf: " + e10.getMessage());
        }
    }

    @Override // org.bouncycastle.crypto.t
    public s c() {
        return this.f54766a.c();
    }
}
