package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CompletedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,662:1\n1#2:663\n*E\n"})
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.l
    public final Object f38281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.l
    public final m f38282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.l
    public final ik.l<Throwable, kotlin.z1> f38283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.l
    public final Object f38284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    @yt.l
    public final Throwable f38285e;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(@yt.l Object obj, @yt.l m mVar, @yt.l ik.l<? super Throwable, kotlin.z1> lVar, @yt.l Object obj2, @yt.l Throwable th2) {
        this.f38281a = obj;
        this.f38282b = mVar;
        this.f38283c = lVar;
        this.f38284d = obj2;
        this.f38285e = th2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b0 g(b0 b0Var, Object obj, m mVar, ik.l lVar, Object obj2, Throwable th2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = b0Var.f38281a;
        }
        if ((i10 & 2) != 0) {
            mVar = b0Var.f38282b;
        }
        m mVar2 = mVar;
        if ((i10 & 4) != 0) {
            lVar = b0Var.f38283c;
        }
        ik.l lVar2 = lVar;
        if ((i10 & 8) != 0) {
            obj2 = b0Var.f38284d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th2 = b0Var.f38285e;
        }
        return b0Var.f(obj, mVar2, lVar2, obj4, th2);
    }

    @yt.l
    public final Object a() {
        return this.f38281a;
    }

    @yt.l
    public final m b() {
        return this.f38282b;
    }

    @yt.l
    public final ik.l<Throwable, kotlin.z1> c() {
        return this.f38283c;
    }

    @yt.l
    public final Object d() {
        return this.f38284d;
    }

    @yt.l
    public final Throwable e() {
        return this.f38285e;
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return kotlin.jvm.internal.f0.g(this.f38281a, b0Var.f38281a) && kotlin.jvm.internal.f0.g(this.f38282b, b0Var.f38282b) && kotlin.jvm.internal.f0.g(this.f38283c, b0Var.f38283c) && kotlin.jvm.internal.f0.g(this.f38284d, b0Var.f38284d) && kotlin.jvm.internal.f0.g(this.f38285e, b0Var.f38285e);
    }

    @yt.k
    public final b0 f(@yt.l Object obj, @yt.l m mVar, @yt.l ik.l<? super Throwable, kotlin.z1> lVar, @yt.l Object obj2, @yt.l Throwable th2) {
        return new b0(obj, mVar, lVar, obj2, th2);
    }

    public final boolean h() {
        return this.f38285e != null;
    }

    public int hashCode() {
        Object obj = this.f38281a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        m mVar = this.f38282b;
        int iHashCode2 = (iHashCode + (mVar == null ? 0 : mVar.hashCode())) * 31;
        ik.l<Throwable, kotlin.z1> lVar = this.f38283c;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f38284d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.f38285e;
        return iHashCode4 + (th2 != null ? th2.hashCode() : 0);
    }

    public final void i(@yt.k p<?> pVar, @yt.k Throwable th2) {
        m mVar = this.f38282b;
        if (mVar != null) {
            pVar.m(mVar, th2);
        }
        ik.l<Throwable, kotlin.z1> lVar = this.f38283c;
        if (lVar != null) {
            pVar.q(lVar, th2);
        }
    }

    @yt.k
    public String toString() {
        return "CompletedContinuation(result=" + this.f38281a + ", cancelHandler=" + this.f38282b + ", onCancellation=" + this.f38283c + ", idempotentResume=" + this.f38284d + ", cancelCause=" + this.f38285e + ')';
    }

    public /* synthetic */ b0(Object obj, m mVar, ik.l lVar, Object obj2, Throwable th2, int i10, kotlin.jvm.internal.u uVar) {
        this(obj, (i10 & 2) != 0 ? null : mVar, (i10 & 4) != 0 ? null : lVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th2);
    }
}
