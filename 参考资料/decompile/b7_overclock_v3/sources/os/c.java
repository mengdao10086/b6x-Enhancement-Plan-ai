package os;

import java.security.SecureRandom;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class c extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46211c;

    public c(int i10, SecureRandom secureRandom) {
        super(secureRandom, -1);
        g.b(i10);
        this.f46211c = i10;
    }

    public int c() {
        return this.f46211c;
    }
}
