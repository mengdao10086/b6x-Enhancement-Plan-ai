package kotlin;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.1")
public final class w implements Comparable<w> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38220f = 255;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f38224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f38225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f38219e = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final w f38221g = x.a();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public w(int i10, int i11, int i12) {
        this.f38222a = i10;
        this.f38223b = i11;
        this.f38224c = i12;
        this.f38225d = i(i10, i11, i12);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@yt.k w other) {
        kotlin.jvm.internal.f0.p(other, "other");
        return this.f38225d - other.f38225d;
    }

    public final int d() {
        return this.f38222a;
    }

    public final int e() {
        return this.f38223b;
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        w wVar = obj instanceof w ? (w) obj : null;
        return wVar != null && this.f38225d == wVar.f38225d;
    }

    public final int f() {
        return this.f38224c;
    }

    public final boolean g(int i10, int i11) {
        int i12 = this.f38222a;
        return i12 > i10 || (i12 == i10 && this.f38223b >= i11);
    }

    public final boolean h(int i10, int i11, int i12) {
        int i13;
        int i14 = this.f38222a;
        return i14 > i10 || (i14 == i10 && ((i13 = this.f38223b) > i11 || (i13 == i11 && this.f38224c >= i12)));
    }

    public int hashCode() {
        return this.f38225d;
    }

    public final int i(int i10, int i11, int i12) {
        boolean z10 = false;
        if (new qk.m(0, 255).p(i10) && new qk.m(0, 255).p(i11) && new qk.m(0, 255).p(i12)) {
            z10 = true;
        }
        if (z10) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + '.' + i11 + '.' + i12).toString());
    }

    @yt.k
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f38222a);
        sb2.append('.');
        sb2.append(this.f38223b);
        sb2.append('.');
        sb2.append(this.f38224c);
        return sb2.toString();
    }

    public w(int i10, int i11) {
        this(i10, i11, 0);
    }
}
