package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c3;

/* JADX INFO: loaded from: classes5.dex */
public final class ThreadContextKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final o0 f38768a = new o0("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final ik.p<Object, CoroutineContext.a, Object> f38769b = new ik.p<Object, CoroutineContext.a, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // ik.p
        @yt.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object r0(@yt.l Object obj, @yt.k CoroutineContext.a aVar) {
            if (!(aVar instanceof c3)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? aVar : Integer.valueOf(iIntValue + 1);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final ik.p<c3<?>, CoroutineContext.a, c3<?>> f38770c = new ik.p<c3<?>, CoroutineContext.a, c3<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // ik.p
        @yt.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c3<?> r0(@yt.l c3<?> c3Var, @yt.k CoroutineContext.a aVar) {
            if (c3Var != null) {
                return c3Var;
            }
            if (aVar instanceof c3) {
                return (c3) aVar;
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final ik.p<z0, CoroutineContext.a, z0> f38771d = new ik.p<z0, CoroutineContext.a, z0>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // ik.p
        @yt.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final z0 r0(@yt.k z0 z0Var, @yt.k CoroutineContext.a aVar) {
            if (aVar instanceof c3) {
                c3<?> c3Var = (c3) aVar;
                z0Var.a(c3Var, c3Var.Y1(z0Var.f38868a));
            }
            return z0Var;
        }
    };

    public static final void a(@yt.k CoroutineContext coroutineContext, @yt.l Object obj) {
        if (obj == f38768a) {
            return;
        }
        if (obj instanceof z0) {
            ((z0) obj).b(coroutineContext);
            return;
        }
        Object objK = coroutineContext.k(null, f38770c);
        kotlin.jvm.internal.f0.n(objK, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((c3) objK).p1(coroutineContext, obj);
    }

    @yt.k
    public static final Object b(@yt.k CoroutineContext coroutineContext) {
        Object objK = coroutineContext.k(0, f38769b);
        kotlin.jvm.internal.f0.m(objK);
        return objK;
    }

    @yt.l
    public static final Object c(@yt.k CoroutineContext coroutineContext, @yt.l Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f38768a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.k(new z0(coroutineContext, ((Number) obj).intValue()), f38771d);
        }
        kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((c3) obj).Y1(coroutineContext);
    }
}
