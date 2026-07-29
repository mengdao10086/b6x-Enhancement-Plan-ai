package up;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/* JADX INFO: loaded from: classes5.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f52386a;

    public d(String str) {
        this.f52386a = str;
    }

    @Override // up.b
    public KeyFactory b(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyFactory.getInstance(str, this.f52386a);
    }
}
