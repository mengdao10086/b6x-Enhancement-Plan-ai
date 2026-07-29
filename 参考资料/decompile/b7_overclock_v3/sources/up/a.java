package up;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public class a implements b {
    @Override // up.b
    public KeyFactory b(String str) throws NoSuchAlgorithmException {
        return KeyFactory.getInstance(str);
    }
}
