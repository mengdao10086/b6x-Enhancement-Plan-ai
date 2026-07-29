package jq;

import java.io.OutputStream;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes7.dex */
public class c implements KeyStore.LoadStoreParameter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f36833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KeyStore.ProtectionParameter f36834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f36835c;

    public c(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
        this(outputStream, protectionParameter, false);
    }

    public c(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter, boolean z10) {
        this.f36833a = outputStream;
        this.f36834b = protectionParameter;
        this.f36835c = z10;
    }

    public c(OutputStream outputStream, char[] cArr) {
        this(outputStream, cArr, false);
    }

    public c(OutputStream outputStream, char[] cArr, boolean z10) {
        this(outputStream, new KeyStore.PasswordProtection(cArr), z10);
    }

    public OutputStream a() {
        return this.f36833a;
    }

    public boolean b() {
        return this.f36835c;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.f36834b;
    }
}
