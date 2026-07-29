package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes5.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f44706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x f44707b;

    public u(c cVar, x xVar) {
        this.f44706a = cVar;
        this.f44707b = xVar;
    }

    public byte[] a() {
        return this.f44707b.a(this.f44706a.b());
    }

    public c b() {
        return this.f44706a;
    }
}
