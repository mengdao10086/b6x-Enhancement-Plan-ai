package kotlinx.coroutines.flow.internal;

import ik.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.s0;
import kotlin.z1;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.internal.k0;

/* JADX INFO: loaded from: classes5.dex */
public final class SafeCollector_commonKt {
    @hk.h(name = "checkContext")
    public static final void a(@yt.k final SafeCollector<?> safeCollector, @yt.k CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.k(0, new p<Integer, CoroutineContext.a, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @yt.k
            public final Integer b(int i10, @yt.k CoroutineContext.a aVar) {
                CoroutineContext.b<?> key = aVar.getKey();
                CoroutineContext.a aVarC = safeCollector.collectContext.c(key);
                if (key != c2.f38296x2) {
                    return Integer.valueOf(aVar != aVarC ? Integer.MIN_VALUE : i10 + 1);
                }
                c2 c2Var = (c2) aVarC;
                f0.n(aVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                c2 c2VarB = SafeCollector_commonKt.b((c2) aVar, c2Var);
                if (c2VarB == c2Var) {
                    if (c2Var != null) {
                        i10++;
                    }
                    return Integer.valueOf(i10);
                }
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + c2VarB + ", expected child of " + c2Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }

            @Override // ik.p
            public /* bridge */ /* synthetic */ Integer r0(Integer num, CoroutineContext.a aVar) {
                return b(num.intValue(), aVar);
            }
        })).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @yt.l
    public static final c2 b(@yt.l c2 c2Var, @yt.l c2 c2Var2) {
        while (c2Var != null) {
            if (c2Var == c2Var2 || !(c2Var instanceof k0)) {
                return c2Var;
            }
            c2Var = c2Var.getParent();
        }
        return null;
    }

    @s0
    @yt.k
    public static final <T> kotlinx.coroutines.flow.e<T> c(@kotlin.b @yt.k p<? super kotlinx.coroutines.flow.f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return new SafeCollector_commonKt$unsafeFlow$1(pVar);
    }
}
