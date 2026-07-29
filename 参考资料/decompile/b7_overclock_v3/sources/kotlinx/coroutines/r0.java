package kotlinx.coroutines;

import kotlin.Result;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nDebugStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugStrings.kt\nkotlinx/coroutines/DebugStringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
public final class r0 {
    @yt.k
    public static final String a(@yt.k Object obj) {
        return obj.getClass().getSimpleName();
    }

    @yt.k
    public static final String b(@yt.k Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @yt.k
    public static final String c(@yt.k kotlin.coroutines.c<?> cVar) {
        Object objB;
        if (cVar instanceof kotlinx.coroutines.internal.k) {
            return cVar.toString();
        }
        try {
            Result.a aVar = Result.f37633a;
            objB = Result.b(cVar + '@' + b(cVar));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            objB = Result.b(kotlin.u0.a(th2));
        }
        if (Result.f(objB) != null) {
            objB = cVar.getClass().getName() + '@' + b(cVar);
        }
        return (String) objB;
    }
}
