package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public abstract class m0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final T[] f37917c;

    public m0(int i10) {
        this.f37915a = i10;
        this.f37917c = (T[]) new Object[i10];
    }

    public static /* synthetic */ void d() {
    }

    public final void a(@yt.k T spreadArgument) {
        f0.p(spreadArgument, "spreadArgument");
        T[] tArr = this.f37917c;
        int i10 = this.f37916b;
        this.f37916b = i10 + 1;
        tArr[i10] = spreadArgument;
    }

    public final int b() {
        return this.f37916b;
    }

    public abstract int c(@yt.k T t10);

    public final void e(int i10) {
        this.f37916b = i10;
    }

    public final int f() {
        int iC = 0;
        kotlin.collections.k0 it2 = new qk.m(0, this.f37915a - 1).iterator();
        while (it2.hasNext()) {
            T t10 = this.f37917c[it2.b()];
            iC += t10 != null ? c(t10) : 1;
        }
        return iC;
    }

    @yt.k
    public final T g(@yt.k T values, @yt.k T result) {
        f0.p(values, "values");
        f0.p(result, "result");
        kotlin.collections.k0 it2 = new qk.m(0, this.f37915a - 1).iterator();
        int i10 = 0;
        int i11 = 0;
        while (it2.hasNext()) {
            int iB = it2.b();
            T t10 = this.f37917c[iB];
            if (t10 != null) {
                if (i10 < iB) {
                    int i12 = iB - i10;
                    System.arraycopy(values, i10, result, i11, i12);
                    i11 += i12;
                }
                int iC = c(t10);
                System.arraycopy(t10, 0, result, i11, iC);
                i11 += iC;
                i10 = iB + 1;
            }
        }
        int i13 = this.f37915a;
        if (i10 < i13) {
            System.arraycopy(values, i10, result, i11, i13 - i10);
        }
        return result;
    }
}
