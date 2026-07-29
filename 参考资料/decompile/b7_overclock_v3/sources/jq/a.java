package jq;

import java.io.OutputStream;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes7.dex */
public class a implements KeyStore.LoadStoreParameter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyStore.ProtectionParameter f36827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final org.bouncycastle.crypto.util.j f36828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OutputStream f36829c;

    public a(OutputStream outputStream, org.bouncycastle.crypto.util.j jVar, KeyStore.ProtectionParameter protectionParameter) {
        this.f36829c = outputStream;
        this.f36828b = jVar;
        this.f36827a = protectionParameter;
    }

    public a(OutputStream outputStream, org.bouncycastle.crypto.util.j jVar, char[] cArr) {
        this(outputStream, jVar, new KeyStore.PasswordProtection(cArr));
    }

    public OutputStream a() {
        return this.f36829c;
    }

    public org.bouncycastle.crypto.util.j b() {
        return this.f36828b;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.f36827a;
    }
}
