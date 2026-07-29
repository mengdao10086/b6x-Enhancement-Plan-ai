package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nExecutors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Executors.kt\nkotlinx/coroutines/ResumeUndispatchedRunnable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n1#2:208\n*E\n"})
public final class v2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final CoroutineDispatcher f39078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final o<kotlin.z1> f39079b;

    /* JADX WARN: Multi-variable type inference failed */
    public v2(@yt.k CoroutineDispatcher coroutineDispatcher, @yt.k o<? super kotlin.z1> oVar) {
        this.f39078a = coroutineDispatcher;
        this.f39079b = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f39079b.O(this.f39078a, kotlin.z1.f38230a);
    }
}
