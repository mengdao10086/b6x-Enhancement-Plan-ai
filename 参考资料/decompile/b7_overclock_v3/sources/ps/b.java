package ps;

import java.security.SecureRandom;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class b extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f47021c;

    public b(SecureRandom secureRandom, e eVar) {
        super(secureRandom, eVar.d()[eVar.d().length - 1] - eVar.d()[0]);
        this.f47021c = eVar;
    }

    public e c() {
        return this.f47021c;
    }
}
