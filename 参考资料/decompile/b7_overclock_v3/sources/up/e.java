package up;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/* JADX INFO: loaded from: classes5.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f52387a;

    public e(Provider provider) {
        this.f52387a = provider;
    }

    @Override // up.b
    public KeyFactory b(String str) throws NoSuchAlgorithmException {
        return KeyFactory.getInstance(str, this.f52387a);
    }
}
