package org.bouncycastle.jce.provider;

import java.io.OutputStream;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes5.dex */
public class j implements KeyStore.LoadStoreParameter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f45466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KeyStore.ProtectionParameter f45467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f45468c;

    public OutputStream a() {
        return this.f45466a;
    }

    public boolean b() {
        return this.f45468c;
    }

    public void c(OutputStream outputStream) {
        this.f45466a = outputStream;
    }

    public void d(char[] cArr) {
        this.f45467b = new KeyStore.PasswordProtection(cArr);
    }

    public void e(KeyStore.ProtectionParameter protectionParameter) {
        this.f45467b = protectionParameter;
    }

    public void f(boolean z10) {
        this.f45468c = z10;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.f45467b;
    }
}
