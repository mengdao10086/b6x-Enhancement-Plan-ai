package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__CollectionKt {

    public static final class a<T> implements f {

        /* JADX INFO: Incorrect field signature: TC; */
        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f38504a;

        /* JADX WARN: Incorrect types in method signature: (TC;)V */
        public a(Collection collection) {
            this.f38504a = collection;
        }

        @Override // kotlinx.coroutines.flow.f
        @yt.l
        public final Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            this.f38504a.add(t10);
            return z1.f38230a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T, C extends java.util.Collection<? super T>> java.lang.Object a(@yt.k kotlinx.coroutines.flow.e<? extends T> r4, @yt.k C r5, @yt.k kotlin.coroutines.c<? super C> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 r0 = (kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.u0.n(r6)
            goto L49
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.u0.n(r6)
            kotlinx.coroutines.flow.FlowKt__CollectionKt$a r6 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$a
            r6.<init>(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.a(r6, r0)
            if (r4 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.a(kotlinx.coroutines.flow.e, java.util.Collection, kotlin.coroutines.c):java.lang.Object");
    }

    @yt.l
    public static final <T> Object b(@yt.k e<? extends T> eVar, @yt.k List<T> list, @yt.k kotlin.coroutines.c<? super List<? extends T>> cVar) {
        return g.X1(eVar, list, cVar);
    }

    public static /* synthetic */ Object c(e eVar, List list, kotlin.coroutines.c cVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = new ArrayList();
        }
        return g.Y1(eVar, list, cVar);
    }

    @yt.l
    public static final <T> Object d(@yt.k e<? extends T> eVar, @yt.k Set<T> set, @yt.k kotlin.coroutines.c<? super Set<? extends T>> cVar) {
        return g.X1(eVar, set, cVar);
    }

    public static /* synthetic */ Object e(e eVar, Set set, kotlin.coroutines.c cVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            set = new LinkedHashSet();
        }
        return g.a2(eVar, set, cVar);
    }
}
