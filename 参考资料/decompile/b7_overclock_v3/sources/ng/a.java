package ng;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f42128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f42129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f42130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f42131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f42132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f42133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f42134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f42135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f42136k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f42137l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f42138m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f42139n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a[] f42140o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f42142b;

    static {
        a aVar = new a(0, false);
        f42128c = aVar;
        a aVar2 = new a(1, true);
        f42129d = aVar2;
        a aVar3 = new a(2, false);
        f42130e = aVar3;
        a aVar4 = new a(3, true);
        f42131f = aVar4;
        a aVar5 = new a(4, false);
        f42132g = aVar5;
        a aVar6 = new a(5, true);
        f42133h = aVar6;
        a aVar7 = new a(6, false);
        f42134i = aVar7;
        a aVar8 = new a(7, true);
        f42135j = aVar8;
        a aVar9 = new a(8, false);
        f42136k = aVar9;
        a aVar10 = new a(9, true);
        f42137l = aVar10;
        a aVar11 = new a(10, false);
        f42138m = aVar11;
        a aVar12 = new a(10, true);
        f42139n = aVar12;
        f42140o = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12};
    }

    public a(int i10, boolean z10) {
        this.f42141a = i10;
        this.f42142b = z10;
    }

    public boolean a(a aVar) {
        int i10 = this.f42141a;
        int i11 = aVar.f42141a;
        return i10 < i11 || ((!this.f42142b || f42137l == this) && i10 == i11);
    }

    public a b() {
        return !this.f42142b ? f42140o[this.f42141a + 1] : this;
    }

    public a c() {
        if (!this.f42142b) {
            return this;
        }
        a aVar = f42140o[this.f42141a - 1];
        return !aVar.f42142b ? aVar : f42128c;
    }
}
