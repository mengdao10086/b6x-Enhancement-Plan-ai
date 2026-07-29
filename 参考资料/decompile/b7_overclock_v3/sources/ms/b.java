package ms;

import java.security.SecureRandom;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class b extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f41597c;

    public b(SecureRandom secureRandom, e eVar) {
        super(secureRandom, 128);
        this.f41597c = eVar;
    }

    public e c() {
        return this.f41597c;
    }
}
