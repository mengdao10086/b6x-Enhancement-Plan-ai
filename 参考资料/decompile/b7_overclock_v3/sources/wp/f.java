package wp;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;

/* JADX INFO: loaded from: classes5.dex */
public class f extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54792b;

    public f(String str) {
        this.f54792b = str;
    }

    @Override // wp.b
    public Signature a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return Signature.getInstance(str, this.f54792b);
    }
}
