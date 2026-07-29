package io.objectbox.kotlin;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import ii.l;
import io.objectbox.BoxStore;
import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.u0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086\b\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086\b\u001a3\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u0004*\u00020\u00012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {i1.a.f31577d5, "Lio/objectbox/BoxStore;", "Lii/a;", "b", "", "Lkotlin/reflect/d;", "clazz", "c", i1.a.X4, "Ljava/util/concurrent/Callable;", "callable", "a", "(Lio/objectbox/BoxStore;Ljava/util/concurrent/Callable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "objectbox-kotlin"}, k = 2, mv = {1, 7, 1})
public final class b {

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", i1.a.X4, CommonNetImpl.RESULT, "", com.umeng.analytics.pro.d.O, "Lkotlin/z1;", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 7, 1})
    public static final class a<T> implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlin.coroutines.c<V> f32779a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlin.coroutines.c<? super V> cVar) {
            this.f32779a = cVar;
        }

        @Override // ii.l
        public final void a(@yt.l V v10, @yt.l Throwable th2) {
            if (th2 != null) {
                kotlin.coroutines.c<V> cVar = this.f32779a;
                Result.a aVar = Result.f37633a;
                cVar.x(Result.b(u0.a(th2)));
            } else {
                kotlin.coroutines.c<V> cVar2 = this.f32779a;
                Result.a aVar2 = Result.f37633a;
                cVar2.x(Result.b(v10));
            }
        }
    }

    @yt.l
    public static final <V> Object a(@k BoxStore boxStore, @k Callable<V> callable, @k kotlin.coroutines.c<? super V> cVar) throws Throwable {
        kotlin.coroutines.h hVar = new kotlin.coroutines.h(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        boxStore.n(callable, new a(hVar));
        Object objA = hVar.a();
        if (objA == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objA;
    }

    public static final /* synthetic */ <T> ii.a<T> b(BoxStore boxStore) {
        f0.p(boxStore, "<this>");
        f0.y(4, i1.a.f31577d5);
        ii.a<T> aVarI = boxStore.i(Object.class);
        f0.o(aVarI, "boxFor(T::class.java)");
        return aVarI;
    }

    @k
    public static final <T> ii.a<T> c(@k BoxStore boxStore, @k kotlin.reflect.d<T> clazz) {
        f0.p(boxStore, "<this>");
        f0.p(clazz, "clazz");
        ii.a<T> aVarI = boxStore.i(hk.a.e(clazz));
        f0.o(aVarI, "boxFor(clazz.java)");
        return aVarI;
    }
}
