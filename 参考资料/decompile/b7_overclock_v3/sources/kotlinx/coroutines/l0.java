package kotlinx.coroutines;

import java.lang.reflect.InvocationTargetException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.k0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,110:1\n75#2:111\n*S KotlinDebug\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n38#1:111\n*E\n"})
public final class l0 {

    @kotlin.jvm.internal.t0({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class a extends kotlin.coroutines.a implements k0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.p<CoroutineContext, Throwable, kotlin.z1> f38896b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(ik.p<? super CoroutineContext, ? super Throwable, kotlin.z1> pVar, k0.b bVar) {
            super(bVar);
            this.f38896b = pVar;
        }

        @Override // kotlinx.coroutines.k0
        public void V1(@yt.k CoroutineContext coroutineContext, @yt.k Throwable th2) {
            this.f38896b.r0(coroutineContext, th2);
        }
    }

    @yt.k
    public static final k0 a(@yt.k ik.p<? super CoroutineContext, ? super Throwable, kotlin.z1> pVar) {
        return new a(pVar, k0.f38888w2);
    }

    @y1
    public static final void b(@yt.k CoroutineContext coroutineContext, @yt.k Throwable th2) {
        try {
            k0 k0Var = (k0) coroutineContext.c(k0.f38888w2);
            if (k0Var != null) {
                k0Var.V1(coroutineContext, th2);
            } else {
                kotlinx.coroutines.internal.i.a(coroutineContext, th2);
            }
        } catch (Throwable th3) {
            kotlinx.coroutines.internal.i.a(coroutineContext, c(th2, th3));
        }
    }

    @yt.k
    public static final Throwable c(@yt.k Throwable th2, @yt.k Throwable th3) throws IllegalAccessException, InvocationTargetException {
        if (th2 == th3) {
            return th2;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th3);
        kotlin.o.a(runtimeException, th2);
        return runtimeException;
    }
}
