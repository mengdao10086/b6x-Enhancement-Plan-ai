package pp;

import java.security.SecureRandom;
import np.n1;
import org.bouncycastle.crypto.n;
import org.bouncycastle.crypto.prng.X931SecureRandom;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f46981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f46982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f46983c;

    public m() {
        this(n.f(), false);
    }

    public m(SecureRandom secureRandom, boolean z10) {
        this.f46981a = secureRandom;
        this.f46982b = new a(secureRandom, z10);
    }

    public m(e eVar) {
        this.f46981a = null;
        this.f46982b = eVar;
    }

    public X931SecureRandom a(org.bouncycastle.crypto.f fVar, n1 n1Var, boolean z10) {
        if (this.f46983c == null) {
            this.f46983c = new byte[fVar.c()];
            o.z(System.currentTimeMillis(), this.f46983c, 0);
        }
        fVar.a(true, n1Var);
        return new X931SecureRandom(this.f46981a, new l(fVar, this.f46983c, this.f46982b.get(fVar.c() * 8)), z10);
    }

    public m b(byte[] bArr) {
        this.f46983c = org.bouncycastle.util.a.p(bArr);
        return this;
    }
}
