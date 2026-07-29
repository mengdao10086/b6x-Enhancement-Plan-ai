package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes5.dex */
final class SafePublicationLazyImpl<T> implements z<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f37634a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> f37635b = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");

    @yt.l
    private volatile Object _value;

    /* JADX INFO: renamed from: final, reason: not valid java name */
    @yt.k
    private final Object f0final;

    @yt.l
    private volatile ik.a<? extends T> initializer;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public SafePublicationLazyImpl(@yt.k ik.a<? extends T> initializer) {
        kotlin.jvm.internal.f0.p(initializer, "initializer");
        this.initializer = initializer;
        t1 t1Var = t1.f38139a;
        this._value = t1Var;
        this.f0final = t1Var;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.z
    public boolean a() {
        return this._value != t1.f38139a;
    }

    @Override // kotlin.z
    public T getValue() {
        T t10 = (T) this._value;
        t1 t1Var = t1.f38139a;
        if (t10 != t1Var) {
            return t10;
        }
        ik.a<? extends T> aVar = this.initializer;
        if (aVar != null) {
            T tO = aVar.o();
            if (al.o.a(f37635b, this, t1Var, tO)) {
                this.initializer = null;
                return tO;
            }
        }
        return (T) this._value;
    }

    @yt.k
    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
