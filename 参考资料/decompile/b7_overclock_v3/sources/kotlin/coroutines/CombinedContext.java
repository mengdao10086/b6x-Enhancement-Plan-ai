package kotlin.coroutines;

import ik.p;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.v0;
import kotlin.z1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1#2:197\n*E\n"})
@v0(version = "1.3")
public final class CombinedContext implements CoroutineContext, Serializable {

    @k
    private final CoroutineContext.a element;

    @k
    private final CoroutineContext left;

    @t0({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,196:1\n12990#2,3:197\n*S KotlinDebug\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n*L\n193#1:197,3\n*E\n"})
    public static final class Serialized implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public static final a f37752a = new a(null);
        private static final long serialVersionUID = 0;

        @k
        private final CoroutineContext[] elements;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }
        }

        public Serialized(@k CoroutineContext[] elements) {
            f0.p(elements, "elements");
            this.elements = elements;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContextL = EmptyCoroutineContext.f37755a;
            for (CoroutineContext coroutineContext : coroutineContextArr) {
                coroutineContextL = coroutineContextL.L(coroutineContext);
            }
            return coroutineContextL;
        }

        @k
        public final CoroutineContext[] a() {
            return this.elements;
        }
    }

    public CombinedContext(@k CoroutineContext left, @k CoroutineContext.a element) {
        f0.p(left, "left");
        f0.p(element, "element");
        this.left = left;
        this.element = element;
    }

    private final Object writeReplace() {
        int iO = o();
        final CoroutineContext[] coroutineContextArr = new CoroutineContext[iO];
        final Ref.IntRef intRef = new Ref.IntRef();
        k(z1.f38230a, new p<z1, CoroutineContext.a, z1>() { // from class: kotlin.coroutines.CombinedContext.writeReplace.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void b(@k z1 z1Var, @k CoroutineContext.a element) {
                f0.p(z1Var, "<anonymous parameter 0>");
                f0.p(element, "element");
                CoroutineContext[] coroutineContextArr2 = coroutineContextArr;
                Ref.IntRef intRef2 = intRef;
                int i10 = intRef2.element;
                intRef2.element = i10 + 1;
                coroutineContextArr2[i10] = element;
            }

            @Override // ik.p
            public /* bridge */ /* synthetic */ z1 r0(z1 z1Var, CoroutineContext.a aVar) {
                b(z1Var, aVar);
                return z1.f38230a;
            }
        });
        if (intRef.element == iO) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // kotlin.coroutines.CoroutineContext
    @k
    public CoroutineContext L(@k CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }

    public final boolean b(CoroutineContext.a aVar) {
        return f0.g(c(aVar.getKey()), aVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @l
    public <E extends CoroutineContext.a> E c(@k CoroutineContext.b<E> key) {
        f0.p(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e10 = (E) combinedContext.element.c(key);
            if (e10 != null) {
                return e10;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return (E) coroutineContext.c(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public boolean equals(@l Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.o() != o() || !combinedContext.i(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @k
    public CoroutineContext f(@k CoroutineContext.b<?> key) {
        f0.p(key, "key");
        if (this.element.c(key) != null) {
            return this.left;
        }
        CoroutineContext coroutineContextF = this.left.f(key);
        return coroutineContextF == this.left ? this : coroutineContextF == EmptyCoroutineContext.f37755a ? this.element : new CombinedContext(coroutineContextF, this.element);
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public final boolean i(CombinedContext combinedContext) {
        while (b(combinedContext.element)) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                f0.n(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((CoroutineContext.a) coroutineContext);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R k(R r10, @k p<? super R, ? super CoroutineContext.a, ? extends R> operation) {
        f0.p(operation, "operation");
        return operation.r0((Object) this.left.k(r10, operation), this.element);
    }

    public final int o() {
        int i10 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i10;
            }
            i10++;
        }
    }

    @k
    public String toString() {
        return '[' + ((String) k("", new p<String, CoroutineContext.a, String>() { // from class: kotlin.coroutines.CombinedContext.toString.1
            @Override // ik.p
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String r0(@k String acc, @k CoroutineContext.a element) {
                f0.p(acc, "acc");
                f0.p(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            }
        })) + ']';
    }
}
