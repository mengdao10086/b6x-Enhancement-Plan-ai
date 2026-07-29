package org.bouncycastle.est;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f44840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f44841c;

    public n(String str) {
        this.f44839a = str;
    }

    public m a() {
        return new m(this.f44839a, this.f44841c, this.f44840b);
    }

    public n b(g gVar) {
        this.f44840b = gVar;
        return this;
    }

    public n c(String str) {
        this.f44841c = str;
        return this;
    }
}
