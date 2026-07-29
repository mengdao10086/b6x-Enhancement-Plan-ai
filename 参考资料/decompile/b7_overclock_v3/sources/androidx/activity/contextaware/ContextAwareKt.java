package androidx.activity.contextaware;

import android.content.Context;
import e.c;
import ik.l;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import yj.b;
import yt.k;
import zj.f;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,93:1\n314#2,11:94\n*S KotlinDebug\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt\n*L\n81#1:94,11\n*E\n"})
public final class ContextAwareKt {

    @t0({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o<R> f1359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l<Context, R> f1360b;

        public a(o<R> oVar, l<Context, R> lVar) {
            this.f1359a = oVar;
            this.f1360b = lVar;
        }

        @Override // e.c
        public void a(@k Context context) {
            Object objB;
            f0.p(context, "context");
            kotlin.coroutines.c cVar = this.f1359a;
            l<Context, R> lVar = this.f1360b;
            try {
                Result.a aVar = Result.f37633a;
                objB = Result.b(lVar.i(context));
            } catch (Throwable th2) {
                Result.a aVar2 = Result.f37633a;
                objB = Result.b(u0.a(th2));
            }
            cVar.x(objB);
        }
    }

    @yt.l
    public static final <R> Object a(@k e.a aVar, @k l<Context, R> lVar, @k kotlin.coroutines.c<R> cVar) {
        Context contextL0 = aVar.l0();
        if (contextL0 != null) {
            return lVar.i(contextL0);
        }
        p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        a aVar2 = new a(pVar, lVar);
        aVar.r0(aVar2);
        pVar.B(new ContextAwareKt$withContextAvailable$2$1(aVar, aVar2));
        Object objC = pVar.C();
        if (objC == b.h()) {
            f.c(cVar);
        }
        return objC;
    }

    public static final <R> Object b(e.a aVar, l<Context, R> lVar, kotlin.coroutines.c<R> cVar) {
        Context contextL0 = aVar.l0();
        if (contextL0 != null) {
            return lVar.i(contextL0);
        }
        c0.e(0);
        p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        a aVar2 = new a(pVar, lVar);
        aVar.r0(aVar2);
        pVar.B(new ContextAwareKt$withContextAvailable$2$1(aVar, aVar2));
        z1 z1Var = z1.f38230a;
        Object objC = pVar.C();
        if (objC == b.h()) {
            f.c(cVar);
        }
        c0.e(1);
        return objC;
    }
}
