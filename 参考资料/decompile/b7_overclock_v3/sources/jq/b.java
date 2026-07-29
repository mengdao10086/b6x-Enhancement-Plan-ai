package jq;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes7.dex */
public class b implements KeyStore.LoadStoreParameter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f36830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OutputStream f36831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KeyStore.ProtectionParameter f36832c;

    public b(InputStream inputStream, OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
        this.f36830a = inputStream;
        this.f36831b = outputStream;
        this.f36832c = protectionParameter;
    }

    public b(InputStream inputStream, KeyStore.ProtectionParameter protectionParameter) {
        this(inputStream, null, protectionParameter);
    }

    public b(InputStream inputStream, char[] cArr) {
        this(inputStream, new KeyStore.PasswordProtection(cArr));
    }

    public b(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
        this(null, outputStream, protectionParameter);
    }

    public b(OutputStream outputStream, char[] cArr) {
        this(outputStream, new KeyStore.PasswordProtection(cArr));
    }

    public InputStream a() {
        if (this.f36831b == null) {
            return this.f36830a;
        }
        throw new UnsupportedOperationException("parameter configured for storage OutputStream present");
    }

    public OutputStream b() {
        OutputStream outputStream = this.f36831b;
        if (outputStream != null) {
            return outputStream;
        }
        throw new UnsupportedOperationException("parameter not configured for storage - no OutputStream");
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.f36832c;
    }
}
