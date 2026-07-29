package ms;

import java.security.SecureRandom;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class k extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f41636c;

    public k(SecureRandom secureRandom, o oVar) {
        super(secureRandom, 256);
        this.f41636c = oVar;
    }

    public o c() {
        return this.f41636c;
    }
}
