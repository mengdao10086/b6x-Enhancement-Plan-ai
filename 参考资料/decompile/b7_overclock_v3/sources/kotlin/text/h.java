package kotlin.text;

import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final String f38180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final qk.m f38181b;

    public h(@yt.k String value, @yt.k qk.m range) {
        f0.p(value, "value");
        f0.p(range, "range");
        this.f38180a = value;
        this.f38181b = range;
    }

    public static /* synthetic */ h d(h hVar, String str, qk.m mVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = hVar.f38180a;
        }
        if ((i10 & 2) != 0) {
            mVar = hVar.f38181b;
        }
        return hVar.c(str, mVar);
    }

    @yt.k
    public final String a() {
        return this.f38180a;
    }

    @yt.k
    public final qk.m b() {
        return this.f38181b;
    }

    @yt.k
    public final h c(@yt.k String value, @yt.k qk.m range) {
        f0.p(value, "value");
        f0.p(range, "range");
        return new h(value, range);
    }

    @yt.k
    public final qk.m e() {
        return this.f38181b;
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return f0.g(this.f38180a, hVar.f38180a) && f0.g(this.f38181b, hVar.f38181b);
    }

    @yt.k
    public final String f() {
        return this.f38180a;
    }

    public int hashCode() {
        return (this.f38180a.hashCode() * 31) + this.f38181b.hashCode();
    }

    @yt.k
    public String toString() {
        return "MatchGroup(value=" + this.f38180a + ", range=" + this.f38181b + ')';
    }
}
