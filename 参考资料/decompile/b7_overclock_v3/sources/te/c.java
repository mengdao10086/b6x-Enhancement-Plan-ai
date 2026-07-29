package te;

import g.v0;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f51087c;

    public c(int i10, int i11, boolean z10) {
        this.f51085a = i10;
        this.f51086b = i11;
        this.f51087c = z10;
    }

    public static c a(int i10, int i11) {
        return new c(i10, i11, true);
    }

    public static c b(int i10, int i11) {
        return new c(i10, i11, false);
    }
}
