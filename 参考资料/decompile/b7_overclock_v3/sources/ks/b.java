package ks;

import java.security.SecureRandom;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class b extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f39112c;

    public b(SecureRandom secureRandom, f fVar) {
        super(secureRandom, 1);
        this.f39112c = fVar;
    }

    public f c() {
        return this.f39112c;
    }
}
