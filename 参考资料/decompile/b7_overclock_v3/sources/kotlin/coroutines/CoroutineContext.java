package kotlin.coroutines;

import ik.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.f0;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
public interface CoroutineContext {

    public static final class DefaultImpls {
        @k
        public static CoroutineContext a(@k CoroutineContext coroutineContext, @k CoroutineContext context) {
            f0.p(context, "context");
            return context == EmptyCoroutineContext.f37755a ? coroutineContext : (CoroutineContext) context.k(coroutineContext, new p<CoroutineContext, a, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext$plus$1
                @Override // ik.p
                @k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final CoroutineContext r0(@k CoroutineContext acc, @k CoroutineContext.a element) {
                    CombinedContext combinedContext;
                    f0.p(acc, "acc");
                    f0.p(element, "element");
                    CoroutineContext coroutineContextF = acc.f(element.getKey());
                    EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f37755a;
                    if (coroutineContextF == emptyCoroutineContext) {
                        return element;
                    }
                    d.b bVar = d.f37759u2;
                    d dVar = (d) coroutineContextF.c(bVar);
                    if (dVar == null) {
                        combinedContext = new CombinedContext(coroutineContextF, element);
                    } else {
                        CoroutineContext coroutineContextF2 = coroutineContextF.f(bVar);
                        if (coroutineContextF2 == emptyCoroutineContext) {
                            return new CombinedContext(element, dVar);
                        }
                        combinedContext = new CombinedContext(new CombinedContext(coroutineContextF2, element), dVar);
                    }
                    return combinedContext;
                }
            });
        }
    }

    public interface a extends CoroutineContext {

        /* JADX INFO: renamed from: kotlin.coroutines.CoroutineContext$a$a, reason: collision with other inner class name */
        public static final class C0431a {
            public static <R> R a(@k a aVar, R r10, @k p<? super R, ? super a, ? extends R> operation) {
                f0.p(operation, "operation");
                return operation.r0(r10, aVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @l
            public static <E extends a> E b(@k a aVar, @k b<E> key) {
                f0.p(key, "key");
                if (!f0.g(aVar.getKey(), key)) {
                    return null;
                }
                f0.n(aVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return aVar;
            }

            @k
            public static CoroutineContext c(@k a aVar, @k b<?> key) {
                f0.p(key, "key");
                return f0.g(aVar.getKey(), key) ? EmptyCoroutineContext.f37755a : aVar;
            }

            @k
            public static CoroutineContext d(@k a aVar, @k CoroutineContext context) {
                f0.p(context, "context");
                return DefaultImpls.a(aVar, context);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        @l
        <E extends a> E c(@k b<E> bVar);

        @Override // kotlin.coroutines.CoroutineContext
        @k
        CoroutineContext f(@k b<?> bVar);

        @k
        b<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        <R> R k(R r10, @k p<? super R, ? super a, ? extends R> pVar);
    }

    public interface b<E extends a> {
    }

    @k
    CoroutineContext L(@k CoroutineContext coroutineContext);

    @l
    <E extends a> E c(@k b<E> bVar);

    @k
    CoroutineContext f(@k b<?> bVar);

    <R> R k(R r10, @k p<? super R, ? super a, ? extends R> pVar);
}
