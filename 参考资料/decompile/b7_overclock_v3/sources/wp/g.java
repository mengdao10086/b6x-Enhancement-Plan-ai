package wp;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;

/* JADX INFO: loaded from: classes5.dex */
public class g extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Provider f54793b;

    public g(Provider provider) {
        this.f54793b = provider;
    }

    @Override // wp.b
    public Signature a(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str, this.f54793b);
    }
}
