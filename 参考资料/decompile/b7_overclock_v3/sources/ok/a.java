package ok;

import ik.q;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.reflect.n;
import kotlin.z1;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f43407a = new a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: ok.a$a, reason: collision with other inner class name */
    @t0({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$observable$1\n*L\n1#1,70:1\n*E\n"})
    public static final class C0487a<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q<n<?>, T, T, z1> f43408b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0487a(T t10, q<? super n<?>, ? super T, ? super T, z1> qVar) {
            super(t10);
            this.f43408b = qVar;
        }

        @Override // ok.c
        public void c(@k n<?> property, T t10, T t11) {
            f0.p(property, "property");
            this.f43408b.A(property, t10, t11);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$vetoable$1\n*L\n1#1,70:1\n*E\n"})
    public static final class b<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q<n<?>, T, T, Boolean> f43409b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(T t10, q<? super n<?>, ? super T, ? super T, Boolean> qVar) {
            super(t10);
            this.f43409b = qVar;
        }

        @Override // ok.c
        public boolean d(@k n<?> property, T t10, T t11) {
            f0.p(property, "property");
            return this.f43409b.A(property, t10, t11).booleanValue();
        }
    }

    @k
    public final <T> f<Object, T> a() {
        return new ok.b();
    }

    @k
    public final <T> f<Object, T> b(T t10, @k q<? super n<?>, ? super T, ? super T, z1> onChange) {
        f0.p(onChange, "onChange");
        return new C0487a(t10, onChange);
    }

    @k
    public final <T> f<Object, T> c(T t10, @k q<? super n<?>, ? super T, ? super T, Boolean> onChange) {
        f0.p(onChange, "onChange");
        return new b(t10, onChange);
    }
}
