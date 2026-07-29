package androidx.work;

import androidx.work.ListenableFutureKt;
import androidx.work.o;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.d0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"Landroidx/work/o;", "Landroidx/work/o$b$c;", "a", "(Landroidx/work/o;Lkotlin/coroutines/c;)Ljava/lang/Object;", "work-runtime-ktx_release"}, k = 2, mv = {1, 5, 1})
public final class OperationKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@yt.k androidx.work.o r4, @yt.k kotlin.coroutines.c<? super androidx.work.o.b.c> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof androidx.work.OperationKt$await$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.work.OperationKt$await$1 r0 = (androidx.work.OperationKt$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.work.OperationKt$await$1 r0 = new androidx.work.OperationKt$await$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.google.common.util.concurrent.ListenableFuture r4 = (com.google.common.util.concurrent.ListenableFuture) r4
            kotlin.u0.n(r5)
            goto L88
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.u0.n(r5)
            com.google.common.util.concurrent.ListenableFuture r4 = r4.getResult()
            java.lang.String r5 = "result"
            kotlin.jvm.internal.f0.o(r4, r5)
            boolean r5 = r4.isDone()
            if (r5 == 0) goto L56
            java.lang.Object r4 = r4.get()     // Catch: java.util.concurrent.ExecutionException -> L4c
            goto L89
        L4c:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L54
            goto L55
        L54:
            r4 = r5
        L55:
            throw r4
        L56:
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.p r5 = new kotlinx.coroutines.p
            kotlin.coroutines.c r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.d(r0)
            r5.<init>(r2, r3)
            r5.Q()
            androidx.work.ListenableFutureKt$a r2 = new androidx.work.ListenableFutureKt$a
            r2.<init>(r5, r4)
            androidx.work.DirectExecutor r3 = androidx.work.DirectExecutor.INSTANCE
            r4.addListener(r2, r3)
            androidx.work.ListenableFutureKt$await$2$2 r2 = new androidx.work.ListenableFutureKt$await$2$2
            r2.<init>(r4)
            r5.B(r2)
            java.lang.Object r5 = r5.C()
            java.lang.Object r4 = yj.b.h()
            if (r5 != r4) goto L85
            zj.f.c(r0)
        L85:
            if (r5 != r1) goto L88
            return r1
        L88:
            r4 = r5
        L89:
            java.lang.String r5 = "result.await()"
            kotlin.jvm.internal.f0.o(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.OperationKt.a(androidx.work.o, kotlin.coroutines.c):java.lang.Object");
    }

    public static final Object b(o oVar, kotlin.coroutines.c<? super o.b.c> cVar) throws Throwable {
        Object objC;
        ListenableFuture<o.b.c> result = oVar.getResult();
        f0.o(result, "result");
        if (result.isDone()) {
            try {
                objC = result.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    throw e10;
                }
                throw cause;
            }
        } else {
            c0.e(0);
            kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
            pVar.Q();
            result.addListener(new ListenableFutureKt.a(pVar, result), DirectExecutor.INSTANCE);
            pVar.B(new ListenableFutureKt$await$2$2(result));
            objC = pVar.C();
            if (objC == yj.b.h()) {
                zj.f.c(cVar);
            }
            c0.e(1);
        }
        f0.o(objC, "result.await()");
        return objC;
    }
}
