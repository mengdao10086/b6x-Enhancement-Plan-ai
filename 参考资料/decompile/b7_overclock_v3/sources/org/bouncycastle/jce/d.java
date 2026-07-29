package org.bouncycastle.jce;

import java.security.cert.CertStoreParameters;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
public class d implements CertStoreParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Collection f45256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f45257b;

    public d(Collection collection) {
        this(collection, true);
    }

    public d(Collection collection, boolean z10) {
        this.f45256a = collection;
        this.f45257b = z10;
    }

    public Collection a() {
        return this.f45256a;
    }

    public boolean b() {
        return this.f45257b;
    }

    @Override // java.security.cert.CertStoreParameters
    public Object clone() {
        return this;
    }
}
