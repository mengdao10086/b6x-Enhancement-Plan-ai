package androidx.lifecycle;

import androidx.lifecycle.Transformations;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Ref;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@hk.h(name = "Transformations")
public final class Transformations {

    public static final class a implements k0, kotlin.jvm.internal.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f6132a;

        public a(ik.l function) {
            kotlin.jvm.internal.f0.p(function, "function");
            this.f6132a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f6132a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f6132a.i(obj);
        }

        public final boolean equals(@yt.l Object obj) {
            if ((obj instanceof k0) && (obj instanceof kotlin.jvm.internal.a0)) {
                return kotlin.jvm.internal.f0.g(a(), ((kotlin.jvm.internal.a0) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    @g.k0
    @hk.h(name = "distinctUntilChanged")
    @g.j
    @yt.k
    public static final <X> LiveData<X> a(@yt.k LiveData<X> liveData) {
        kotlin.jvm.internal.f0.p(liveData, "<this>");
        final h0 h0Var = new h0();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (liveData.j()) {
            h0Var.r(liveData.f());
            booleanRef.element = false;
        }
        h0Var.s(liveData, new a(new ik.l<X, z1>() { // from class: androidx.lifecycle.Transformations$distinctUntilChanged$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(X x10) {
                X xF = h0Var.f();
                if (booleanRef.element || ((xF == null && x10 != null) || !(xF == null || kotlin.jvm.internal.f0.g(xF, x10)))) {
                    booleanRef.element = false;
                    h0Var.r(x10);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Object obj) {
                b(obj);
                return z1.f38230a;
            }
        }));
        return h0Var;
    }

    @g.k0
    @hk.h(name = "map")
    @g.j
    @yt.k
    public static final <X, Y> LiveData<Y> b(@yt.k LiveData<X> liveData, @yt.k final ik.l<X, Y> transform) {
        kotlin.jvm.internal.f0.p(liveData, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        final h0 h0Var = new h0();
        h0Var.s(liveData, new a(new ik.l<X, z1>() { // from class: androidx.lifecycle.Transformations$map$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final void b(X x10) {
                h0Var.r((Y) transform.i(x10));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Object obj) {
                b(obj);
                return z1.f38230a;
            }
        }));
        return h0Var;
    }

    @g.k0
    @hk.h(name = "map")
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @g.j
    public static final /* synthetic */ LiveData c(LiveData liveData, final p.a mapFunction) {
        kotlin.jvm.internal.f0.p(liveData, "<this>");
        kotlin.jvm.internal.f0.p(mapFunction, "mapFunction");
        final h0 h0Var = new h0();
        h0Var.s(liveData, new a(new ik.l<Object, z1>() { // from class: androidx.lifecycle.Transformations$map$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Object obj) {
                h0Var.r(mapFunction.apply(obj));
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Object obj) {
                b(obj);
                return z1.f38230a;
            }
        }));
        return h0Var;
    }

    @g.k0
    @hk.h(name = "switchMap")
    @g.j
    @yt.k
    public static final <X, Y> LiveData<Y> d(@yt.k LiveData<X> liveData, @yt.k final ik.l<X, LiveData<Y>> transform) {
        kotlin.jvm.internal.f0.p(liveData, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        final h0 h0Var = new h0();
        h0Var.s(liveData, new k0<X>() { // from class: androidx.lifecycle.Transformations$switchMap$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @yt.l
            public LiveData<Y> f6133a;

            @yt.l
            public final LiveData<Y> a() {
                return this.f6133a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // androidx.lifecycle.k0
            public void b(X x10) {
                LiveData<Y> liveData2 = (LiveData) transform.i(x10);
                Object obj = this.f6133a;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    h0<Y> h0Var2 = h0Var;
                    kotlin.jvm.internal.f0.m(obj);
                    h0Var2.t(obj);
                }
                this.f6133a = liveData2;
                if (liveData2 != 0) {
                    h0<Y> h0Var3 = h0Var;
                    kotlin.jvm.internal.f0.m(liveData2);
                    final h0<Y> h0Var4 = h0Var;
                    h0Var3.s(liveData2, new Transformations.a(new ik.l<Y, z1>() { // from class: androidx.lifecycle.Transformations$switchMap$1$onChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void b(Y y10) {
                            h0Var4.r(y10);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // ik.l
                        public /* bridge */ /* synthetic */ z1 i(Object obj2) {
                            b(obj2);
                            return z1.f38230a;
                        }
                    }));
                }
            }

            public final void c(@yt.l LiveData<Y> liveData2) {
                this.f6133a = liveData2;
            }
        });
        return h0Var;
    }

    @g.k0
    @hk.h(name = "switchMap")
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @g.j
    public static final /* synthetic */ LiveData e(LiveData liveData, final p.a switchMapFunction) {
        kotlin.jvm.internal.f0.p(liveData, "<this>");
        kotlin.jvm.internal.f0.p(switchMapFunction, "switchMapFunction");
        final h0 h0Var = new h0();
        h0Var.s(liveData, new k0<Object>() { // from class: androidx.lifecycle.Transformations$switchMap$2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @yt.l
            public LiveData<Object> f6136a;

            @yt.l
            public final LiveData<Object> a() {
                return this.f6136a;
            }

            @Override // androidx.lifecycle.k0
            public void b(Object obj) {
                LiveData<Object> liveDataApply = switchMapFunction.apply(obj);
                LiveData<Object> liveData2 = this.f6136a;
                if (liveData2 == liveDataApply) {
                    return;
                }
                if (liveData2 != null) {
                    h0<Object> h0Var2 = h0Var;
                    kotlin.jvm.internal.f0.m(liveData2);
                    h0Var2.t(liveData2);
                }
                this.f6136a = liveDataApply;
                if (liveDataApply != null) {
                    h0<Object> h0Var3 = h0Var;
                    kotlin.jvm.internal.f0.m(liveDataApply);
                    final h0<Object> h0Var4 = h0Var;
                    h0Var3.s(liveDataApply, new Transformations.a(new ik.l<Object, z1>() { // from class: androidx.lifecycle.Transformations$switchMap$2$onChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void b(Object obj2) {
                            h0Var4.r(obj2);
                        }

                        @Override // ik.l
                        public /* bridge */ /* synthetic */ z1 i(Object obj2) {
                            b(obj2);
                            return z1.f38230a;
                        }
                    }));
                }
            }

            public final void c(@yt.l LiveData<Object> liveData2) {
                this.f6136a = liveData2;
            }
        });
        return h0Var;
    }
}
