package kotlinx.coroutines.internal;

import kotlin.Result;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoaderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f38816a;

    static {
        Object objB;
        try {
            Result.a aVar = Result.f37633a;
            objB = Result.b(Class.forName("android.os.Build"));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            objB = Result.b(kotlin.u0.a(th2));
        }
        f38816a = Result.m(objB);
    }

    public static final boolean a() {
        return f38816a;
    }
}
