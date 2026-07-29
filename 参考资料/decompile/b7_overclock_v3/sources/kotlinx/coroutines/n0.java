package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class n0 extends kotlin.coroutines.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final a f38910c = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f38911b;

    public static final class a implements CoroutineContext.b<n0> {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public n0(@yt.k String str) {
        super(f38910c);
        this.f38911b = str;
    }

    public static /* synthetic */ n0 j2(n0 n0Var, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = n0Var.f38911b;
        }
        return n0Var.i2(str);
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n0) && kotlin.jvm.internal.f0.g(this.f38911b, ((n0) obj).f38911b);
    }

    @yt.k
    public final String h2() {
        return this.f38911b;
    }

    public int hashCode() {
        return this.f38911b.hashCode();
    }

    @yt.k
    public final n0 i2(@yt.k String str) {
        return new n0(str);
    }

    @yt.k
    public final String k2() {
        return this.f38911b;
    }

    @yt.k
    public String toString() {
        return "CoroutineName(" + this.f38911b + ')';
    }
}
