package os;

import java.security.SecureRandom;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f46212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SecureRandom f46213h;

    @Override // org.bouncycastle.crypto.d
    public void a(y yVar) {
        c cVar = (c) yVar;
        this.f46213h = cVar.a();
        this.f46212g = cVar.c();
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        byte[] bArrC = c(this.f46212g);
        byte[] bArrD = d(this.f46212g);
        int i10 = this.f46212g;
        if (i10 == 5) {
            i.l(bArrD, bArrC, this.f46213h);
        } else {
            if (i10 != 6) {
                throw new IllegalArgumentException("unknown security category: " + this.f46212g);
            }
            j.m(bArrD, bArrC, this.f46213h);
        }
        return new org.bouncycastle.crypto.c((np.c) new f(this.f46212g, bArrD), (np.c) new e(this.f46212g, bArrC));
    }

    public final byte[] c(int i10) {
        return new byte[g.b(i10)];
    }

    public final byte[] d(int i10) {
        return new byte[g.c(i10)];
    }
}
