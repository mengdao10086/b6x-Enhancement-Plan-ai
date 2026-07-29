package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.l
    public final Object f38391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public final ik.l<Throwable, kotlin.z1> f38392b;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(@yt.l Object obj, @yt.k ik.l<? super Throwable, kotlin.z1> lVar) {
        this.f38391a = obj;
        this.f38392b = lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ d0 d(d0 d0Var, Object obj, ik.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = d0Var.f38391a;
        }
        if ((i10 & 2) != 0) {
            lVar = d0Var.f38392b;
        }
        return d0Var.c(obj, lVar);
    }

    @yt.l
    public final Object a() {
        return this.f38391a;
    }

    @yt.k
    public final ik.l<Throwable, kotlin.z1> b() {
        return this.f38392b;
    }

    @yt.k
    public final d0 c(@yt.l Object obj, @yt.k ik.l<? super Throwable, kotlin.z1> lVar) {
        return new d0(obj, lVar);
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return kotlin.jvm.internal.f0.g(this.f38391a, d0Var.f38391a) && kotlin.jvm.internal.f0.g(this.f38392b, d0Var.f38392b);
    }

    public int hashCode() {
        Object obj = this.f38391a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f38392b.hashCode();
    }

    @yt.k
    public String toString() {
        return "CompletedWithCancellation(result=" + this.f38391a + ", onCancellation=" + this.f38392b + ')';
    }
}
