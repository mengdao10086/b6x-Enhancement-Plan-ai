package org.bouncycastle.jcajce.util;

import java.security.Provider;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes5.dex */
public class b extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Provider f45252b;

    public b() {
        super(w());
    }

    public static synchronized Provider w() {
        Provider provider = Security.getProvider(BouncyCastleProvider.f45329b);
        if (provider instanceof BouncyCastleProvider) {
            return provider;
        }
        if (f45252b != null) {
            return f45252b;
        }
        f45252b = new BouncyCastleProvider();
        return f45252b;
    }
}
