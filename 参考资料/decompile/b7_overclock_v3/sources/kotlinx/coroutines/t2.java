package kotlinx.coroutines;

import kotlin.Result;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/ResumeAwaitOnCompletion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1451:1\n1#2:1452\n*E\n"})
public final class t2<T> extends i2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final p<T> f39073e;

    /* JADX WARN: Multi-variable type inference failed */
    public t2(@yt.k p<? super T> pVar) {
        this.f39073e = pVar;
    }

    @Override // kotlinx.coroutines.e0
    public void R(@yt.l Throwable th2) {
        Object objK0 = S().K0();
        if (objK0 instanceof c0) {
            p<T> pVar = this.f39073e;
            Result.a aVar = Result.f37633a;
            pVar.x(Result.b(kotlin.u0.a(((c0) objK0).f38294a)));
        } else {
            p<T> pVar2 = this.f39073e;
            Result.a aVar2 = Result.f37633a;
            pVar2.x(Result.b(j2.h(objK0)));
        }
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        R(th2);
        return kotlin.z1.f38230a;
    }
}
