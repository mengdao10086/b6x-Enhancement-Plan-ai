package org.bouncycastle.est;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f44782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f44783b;

    public c(b bVar, s sVar) {
        this.f44782a = bVar;
        this.f44783b = sVar;
    }

    public b a() {
        b bVar = this.f44782a;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("Response has no CSRAttributesResponse.");
    }

    public Object b() {
        return this.f44783b.d();
    }

    public s c() {
        return this.f44783b;
    }

    public boolean d() {
        return this.f44782a != null;
    }
}
