package wp;

import java.security.NoSuchAlgorithmException;
import java.security.Signature;

/* JADX INFO: loaded from: classes5.dex */
public class a extends b {
    @Override // wp.b
    public Signature a(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str);
    }
}
