package zk;

import ik.l;
import ik.p;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.y1;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nCancellable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n1#1,68:1\n49#1,6:69\n49#1,6:75\n49#1,6:81\n*S KotlinDebug\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n17#1:69,6\n29#1:75,6\n38#1:81,6\n*E\n"})
public final class a {
    public static final void a(c<?> cVar, Throwable th2) throws Throwable {
        Result.a aVar = Result.f37633a;
        cVar.x(Result.b(u0.a(th2)));
        throw th2;
    }

    public static final void b(c<?> cVar, ik.a<z1> aVar) throws Throwable {
        try {
            aVar.o();
        } catch (Throwable th2) {
            a(cVar, th2);
        }
    }

    @y1
    public static final <T> void c(@k l<? super c<? super T>, ? extends Object> lVar, @k c<? super T> cVar) throws Throwable {
        try {
            c cVarD = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.b(lVar, cVar));
            Result.a aVar = Result.f37633a;
            kotlinx.coroutines.internal.l.e(cVarD, Result.b(z1.f38230a), null, 2, null);
        } catch (Throwable th2) {
            a(cVar, th2);
        }
    }

    public static final <R, T> void d(@k p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, @k c<? super T> cVar, @yt.l l<? super Throwable, z1> lVar) throws Throwable {
        try {
            c cVarD = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.c(pVar, r10, cVar));
            Result.a aVar = Result.f37633a;
            kotlinx.coroutines.internal.l.d(cVarD, Result.b(z1.f38230a), lVar);
        } catch (Throwable th2) {
            a(cVar, th2);
        }
    }

    public static final void e(@k c<? super z1> cVar, @k c<?> cVar2) throws Throwable {
        try {
            c cVarD = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
            Result.a aVar = Result.f37633a;
            kotlinx.coroutines.internal.l.e(cVarD, Result.b(z1.f38230a), null, 2, null);
        } catch (Throwable th2) {
            a(cVar2, th2);
        }
    }

    public static /* synthetic */ void f(p pVar, Object obj, c cVar, l lVar, int i10, Object obj2) throws Throwable {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        d(pVar, obj, cVar, lVar);
    }
}
