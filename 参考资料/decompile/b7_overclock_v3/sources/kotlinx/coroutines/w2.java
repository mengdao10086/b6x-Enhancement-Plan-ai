package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class w2 {

    @kotlin.jvm.internal.t0({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n*L\n1#1,18:1\n*E\n"})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.a<kotlin.z1> f39080a;

        public a(ik.a<kotlin.z1> aVar) {
            this.f39080a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f39080a.o();
        }
    }

    @yt.k
    public static final Runnable a(@yt.k ik.a<kotlin.z1> aVar) {
        return new a(aVar);
    }
}
