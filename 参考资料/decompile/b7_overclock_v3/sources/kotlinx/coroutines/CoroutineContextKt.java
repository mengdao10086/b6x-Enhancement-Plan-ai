package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes5.dex */
public final class CoroutineContextKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final String f38231a = " @";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z10) {
        boolean zC = c(coroutineContext);
        boolean zC2 = c(coroutineContext2);
        if (!zC && !zC2) {
            return coroutineContext.L(coroutineContext2);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f37755a;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.k(emptyCoroutineContext, new ik.p<CoroutineContext, CoroutineContext.a, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.CoroutineContext] */
            @Override // ik.p
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CoroutineContext r0(@yt.k CoroutineContext coroutineContext4, @yt.k CoroutineContext.a aVar) {
                if (!(aVar instanceof i0)) {
                    return coroutineContext4.L(aVar);
                }
                CoroutineContext.a aVarC = objectRef.element.c(aVar.getKey());
                if (aVarC != null) {
                    Ref.ObjectRef<CoroutineContext> objectRef2 = objectRef;
                    objectRef2.element = objectRef2.element.f(aVar.getKey());
                    return coroutineContext4.L(((i0) aVar).I(aVarC));
                }
                i0 i0VarI1 = (i0) aVar;
                if (z10) {
                    i0VarI1 = i0VarI1.i1();
                }
                return coroutineContext4.L(i0VarI1);
            }
        });
        if (zC2) {
            objectRef.element = ((CoroutineContext) objectRef.element).k(emptyCoroutineContext, new ik.p<CoroutineContext, CoroutineContext.a, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$1
                @Override // ik.p
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final CoroutineContext r0(@yt.k CoroutineContext coroutineContext4, @yt.k CoroutineContext.a aVar) {
                    return aVar instanceof i0 ? coroutineContext4.L(((i0) aVar).i1()) : coroutineContext4.L(aVar);
                }
            });
        }
        return coroutineContext3.L((CoroutineContext) objectRef.element);
    }

    @yt.l
    public static final String b(@yt.k CoroutineContext coroutineContext) {
        return null;
    }

    public static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.k(Boolean.FALSE, new ik.p<Boolean, CoroutineContext.a, Boolean>() { // from class: kotlinx.coroutines.CoroutineContextKt$hasCopyableElements$1
            @yt.k
            public final Boolean b(boolean z10, @yt.k CoroutineContext.a aVar) {
                return Boolean.valueOf(z10 || (aVar instanceof i0));
            }

            @Override // ik.p
            public /* bridge */ /* synthetic */ Boolean r0(Boolean bool, CoroutineContext.a aVar) {
                return b(bool.booleanValue(), aVar);
            }
        })).booleanValue();
    }

    @y1
    @yt.k
    public static final CoroutineContext d(@yt.k CoroutineContext coroutineContext, @yt.k CoroutineContext coroutineContext2) {
        return !c(coroutineContext2) ? coroutineContext.L(coroutineContext2) : a(coroutineContext, coroutineContext2, false);
    }

    @s1
    @yt.k
    public static final CoroutineContext e(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextA = a(o0Var.W(), coroutineContext, true);
        return (coroutineContextA == d1.a() || coroutineContextA.c(kotlin.coroutines.d.f37759u2) != null) ? coroutineContextA : coroutineContextA.L(d1.a());
    }

    @yt.l
    public static final k3<?> f(@yt.k zj.c cVar) {
        while (!(cVar instanceof z0) && (cVar = cVar.r()) != null) {
            if (cVar instanceof k3) {
                return (k3) cVar;
            }
        }
        return null;
    }

    @yt.l
    public static final k3<?> g(@yt.k kotlin.coroutines.c<?> cVar, @yt.k CoroutineContext coroutineContext, @yt.l Object obj) {
        if (!(cVar instanceof zj.c)) {
            return null;
        }
        if (!(coroutineContext.c(l3.f38907a) != null)) {
            return null;
        }
        k3<?> k3VarF = f((zj.c) cVar);
        if (k3VarF != null) {
            k3VarF.K1(coroutineContext, obj);
        }
        return k3VarF;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> T h(@yt.k kotlin.coroutines.c<?> r2, @yt.l java.lang.Object r3, @yt.k ik.a<? extends T> r4) {
        /*
            kotlin.coroutines.CoroutineContext r0 = r2.b()
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.c(r0, r3)
            kotlinx.coroutines.internal.o0 r1 = kotlinx.coroutines.internal.ThreadContextKt.f38768a
            if (r3 == r1) goto L11
            kotlinx.coroutines.k3 r2 = g(r2, r0, r3)
            goto L12
        L11:
            r2 = 0
        L12:
            r1 = 1
            java.lang.Object r4 = r4.o()     // Catch: java.lang.Throwable -> L29
            kotlin.jvm.internal.c0.d(r1)
            if (r2 == 0) goto L22
            boolean r2 = r2.J1()
            if (r2 == 0) goto L25
        L22:
            kotlinx.coroutines.internal.ThreadContextKt.a(r0, r3)
        L25:
            kotlin.jvm.internal.c0.c(r1)
            return r4
        L29:
            r4 = move-exception
            kotlin.jvm.internal.c0.d(r1)
            if (r2 == 0) goto L35
            boolean r2 = r2.J1()
            if (r2 == 0) goto L38
        L35:
            kotlinx.coroutines.internal.ThreadContextKt.a(r0, r3)
        L38:
            kotlin.jvm.internal.c0.c(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineContextKt.h(kotlin.coroutines.c, java.lang.Object, ik.a):java.lang.Object");
    }

    public static final <T> T i(@yt.k CoroutineContext coroutineContext, @yt.l Object obj, @yt.k ik.a<? extends T> aVar) {
        Object objC = ThreadContextKt.c(coroutineContext, obj);
        try {
            return aVar.o();
        } finally {
            kotlin.jvm.internal.c0.d(1);
            ThreadContextKt.a(coroutineContext, objC);
            kotlin.jvm.internal.c0.c(1);
        }
    }
}
