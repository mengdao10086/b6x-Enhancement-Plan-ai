package kotlinx.coroutines.internal;

import java.lang.reflect.InvocationTargetException;
import kotlin.coroutines.CoroutineContext;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nOnUndeliveredElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,44:1\n75#2:45\n*S KotlinDebug\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n*L\n22#1:45\n*E\n"})
public final class OnUndeliveredElementKt {
    @yt.k
    public static final <E> ik.l<Throwable, z1> a(@yt.k final ik.l<? super E, z1> lVar, final E e10, @yt.k final CoroutineContext coroutineContext) {
        return new ik.l<Throwable, z1>() { // from class: kotlinx.coroutines.internal.OnUndeliveredElementKt$bindCancellationFun$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(@yt.k Throwable th2) throws IllegalAccessException, InvocationTargetException {
                OnUndeliveredElementKt.b(lVar, e10, coroutineContext);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) throws IllegalAccessException, InvocationTargetException {
                b(th2);
                return z1.f38230a;
            }
        };
    }

    public static final <E> void b(@yt.k ik.l<? super E, z1> lVar, E e10, @yt.k CoroutineContext coroutineContext) throws IllegalAccessException, InvocationTargetException {
        UndeliveredElementException undeliveredElementExceptionC = c(lVar, e10, null);
        if (undeliveredElementExceptionC != null) {
            kotlinx.coroutines.l0.b(coroutineContext, undeliveredElementExceptionC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.l
    public static final <E> UndeliveredElementException c(@yt.k ik.l<? super E, z1> lVar, E e10, @yt.l UndeliveredElementException undeliveredElementException) throws IllegalAccessException, InvocationTargetException {
        try {
            lVar.i(e10);
        } catch (Throwable th2) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th2) {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e10, th2);
            }
            kotlin.o.a(undeliveredElementException, th2);
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(ik.l lVar, Object obj, UndeliveredElementException undeliveredElementException, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(lVar, obj, undeliveredElementException);
    }
}
