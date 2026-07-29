package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n314#2,9:128\n323#2,2:141\n13#3:137\n19#3:140\n13579#4,2:138\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n*L\n71#1:128,9\n71#1:141,2\n78#1:137\n90#1:140\n83#1:138,2\n*E\n"})
public final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38461b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final u0<T>[] f38462a;

    @hk.v
    private volatile int notCompletedCount;

    @kotlin.jvm.internal.t0({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n11335#2:128\n11670#2,3:129\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n*L\n121#1:128\n121#1:129,3\n*E\n"})
    public final class a extends i2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.k
        public static final AtomicReferenceFieldUpdater f38463h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");

        @yt.l
        @hk.v
        private volatile Object _disposer;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.k
        public final o<List<? extends T>> f38464e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g1 f38465f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@yt.k o<? super List<? extends T>> oVar) {
            this.f38464e = oVar;
        }

        @Override // kotlinx.coroutines.e0
        public void R(@yt.l Throwable th2) {
            if (th2 != null) {
                Object objJ = this.f38464e.J(th2);
                if (objJ != null) {
                    this.f38464e.l0(objJ);
                    e<T>.b bVarV = V();
                    if (bVarV != null) {
                        bVarV.w();
                        return;
                    }
                    return;
                }
                return;
            }
            if (e.f38461b.decrementAndGet(e.this) == 0) {
                o<List<? extends T>> oVar = this.f38464e;
                u0[] u0VarArr = e.this.f38462a;
                ArrayList arrayList = new ArrayList(u0VarArr.length);
                for (u0 u0Var : u0VarArr) {
                    arrayList.add(u0Var.u());
                }
                Result.a aVar = Result.f37633a;
                oVar.x(Result.b(arrayList));
            }
        }

        @yt.l
        public final e<T>.b V() {
            return (b) f38463h.get(this);
        }

        @yt.k
        public final g1 W() {
            g1 g1Var = this.f38465f;
            if (g1Var != null) {
                return g1Var;
            }
            kotlin.jvm.internal.f0.S("handle");
            return null;
        }

        public final void Y(@yt.l e<T>.b bVar) {
            f38463h.set(this, bVar);
        }

        public final void a0(@yt.k g1 g1Var) {
            this.f38465f = g1Var;
        }

        @Override // ik.l
        public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
            R(th2);
            return kotlin.z1.f38230a;
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n13579#2,2:128\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n*L\n96#1:128,2\n*E\n"})
    public final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final e<T>.a[] f38467a;

        public b(@yt.k e<T>.a[] aVarArr) {
            this.f38467a = aVarArr;
        }

        @Override // ik.l
        public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
            s(th2);
            return kotlin.z1.f38230a;
        }

        @Override // kotlinx.coroutines.n
        public void s(@yt.l Throwable th2) {
            w();
        }

        @yt.k
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f38467a + ']';
        }

        public final void w() {
            for (e<T>.a aVar : this.f38467a) {
                aVar.W().dispose();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@yt.k u0<? extends T>[] u0VarArr) {
        this.f38462a = u0VarArr;
        this.notCompletedCount = u0VarArr.length;
    }

    @yt.l
    public final Object c(@yt.k kotlin.coroutines.c<? super List<? extends T>> cVar) {
        p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        int length = this.f38462a.length;
        a[] aVarArr = new a[length];
        for (int i10 = 0; i10 < length; i10++) {
            u0 u0Var = this.f38462a[i10];
            u0Var.start();
            a aVar = new a(pVar);
            aVar.a0(u0Var.L1(aVar));
            kotlin.z1 z1Var = kotlin.z1.f38230a;
            aVarArr[i10] = aVar;
        }
        e<T>.b bVar = new b(aVarArr);
        for (int i11 = 0; i11 < length; i11++) {
            aVarArr[i11].Y(bVar);
        }
        if (pVar.n()) {
            bVar.w();
        } else {
            pVar.B(bVar);
        }
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }
}
