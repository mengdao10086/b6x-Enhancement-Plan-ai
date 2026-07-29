package kotlinx.coroutines.selects;

import hk.v;
import ik.p;
import ik.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.s0;
import kotlin.z1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.internal.l0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.selects.b;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,873:1\n1#2:874\n2624#3,3:875\n1855#3,2:888\n1855#3,2:896\n1855#3,2:898\n314#4,9:878\n323#4,2:890\n19#5:887\n153#6,4:892\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n505#1:875,3\n569#1:888,2\n726#1:896,2\n751#1:898,2\n545#1:878,9\n545#1:890,2\n561#1:887\n711#1:892,4\n*E\n"})
@s0
public class SelectImplementation<R> extends kotlinx.coroutines.m implements b<R>, k<R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38997f = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final CoroutineContext f38998a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public Object f39000c;

    @yt.l
    @v
    private volatile Object state = SelectKt.f39017f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public List<SelectImplementation<R>.a> f38999b = new ArrayList(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f39001d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public Object f39002e = SelectKt.f39020i;

    @t0({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,873:1\n1#2:874\n*E\n"})
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @hk.e
        @yt.k
        public final Object f39003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final q<Object, j<?>, Object, z1> f39004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final q<Object, Object, Object, Object> f39005c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.l
        public final Object f39006d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.k
        public final Object f39007e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @hk.e
        @yt.l
        public final q<j<?>, Object, Object, ik.l<Throwable, z1>> f39008f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @hk.e
        @yt.l
        public Object f39009g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @hk.e
        public int f39010h = -1;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@yt.k Object obj, @yt.k q<Object, ? super j<?>, Object, z1> qVar, @yt.k q<Object, Object, Object, ? extends Object> qVar2, @yt.l Object obj2, @yt.k Object obj3, @yt.l q<? super j<?>, Object, Object, ? extends ik.l<? super Throwable, z1>> qVar3) {
            this.f39003a = obj;
            this.f39004b = qVar;
            this.f39005c = qVar2;
            this.f39006d = obj2;
            this.f39007e = obj3;
            this.f39008f = qVar3;
        }

        @yt.l
        public final ik.l<Throwable, z1> a(@yt.k j<?> jVar, @yt.l Object obj) {
            q<j<?>, Object, Object, ik.l<Throwable, z1>> qVar = this.f39008f;
            if (qVar != null) {
                return qVar.A(jVar, this.f39006d, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f39009g;
            SelectImplementation<R> selectImplementation = SelectImplementation.this;
            if (obj instanceof l0) {
                ((l0) obj).q(this.f39010h, null, selectImplementation.b());
                return;
            }
            g1 g1Var = obj instanceof g1 ? (g1) obj : null;
            if (g1Var != null) {
                g1Var.dispose();
            }
        }

        @yt.l
        public final Object c(@yt.l Object obj, @yt.k kotlin.coroutines.c<? super R> cVar) {
            Object obj2 = this.f39007e;
            if (this.f39006d == SelectKt.l()) {
                f0.n(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((ik.l) obj2).i(cVar);
            }
            f0.n(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((p) obj2).r0(obj, cVar);
        }

        @yt.l
        public final Object d(@yt.l Object obj) {
            return this.f39005c.A(this.f39003a, this.f39006d, obj);
        }

        public final boolean e(@yt.k SelectImplementation<R> selectImplementation) {
            this.f39004b.A(this.f39003a, selectImplementation, this.f39006d);
            return selectImplementation.f39002e == SelectKt.f39020i;
        }
    }

    public SelectImplementation(@yt.k CoroutineContext coroutineContext) {
        this.f38998a = coroutineContext;
    }

    @s0
    public static /* synthetic */ <R> Object S(SelectImplementation<R> selectImplementation, kotlin.coroutines.c<? super R> cVar) {
        return selectImplementation.a0() ? selectImplementation.Q(cVar) : selectImplementation.T(cVar);
    }

    public static /* synthetic */ void f0(SelectImplementation selectImplementation, a aVar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        selectImplementation.e0(aVar, z10);
    }

    public final void M(Object obj) {
        List<SelectImplementation<R>.a> list = this.f38999b;
        f0.m(list);
        boolean z10 = false;
        if ((list instanceof Collection) && list.isEmpty()) {
            z10 = true;
        } else {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((a) it2.next()).f39003a == obj) {
                    break;
                }
            }
            z10 = true;
        }
        if (z10) {
            return;
        }
        throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
    }

    public final void O(SelectImplementation<R>.a aVar) {
        List<SelectImplementation<R>.a> list = this.f38999b;
        if (list == null) {
            return;
        }
        for (SelectImplementation<R>.a aVar2 : list) {
            if (aVar2 != aVar) {
                aVar2.b();
            }
        }
        f38997f.set(this, SelectKt.f39018g);
        this.f39002e = SelectKt.f39020i;
        this.f38999b = null;
    }

    public final Object Q(kotlin.coroutines.c<? super R> cVar) {
        Object obj = f38997f.get(this);
        f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        SelectImplementation<R>.a aVar = (a) obj;
        Object obj2 = this.f39002e;
        O(aVar);
        return aVar.c(aVar.d(obj2), cVar);
    }

    @yt.l
    @s0
    public Object R(@yt.k kotlin.coroutines.c<? super R> cVar) {
        return S(this, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object T(kotlin.coroutines.c<? super R> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.u0.n(r6)
            goto L57
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.selects.SelectImplementation r2 = (kotlinx.coroutines.selects.SelectImplementation) r2
            kotlin.u0.n(r6)
            goto L4b
        L3c:
            kotlin.u0.n(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.k0(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r2 = r5
        L4b:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.Q(r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.T(kotlin.coroutines.c):java.lang.Object");
    }

    public final SelectImplementation<R>.a V(Object obj) {
        List<SelectImplementation<R>.a> list = this.f38999b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((a) next).f39003a == obj) {
                obj2 = next;
                break;
            }
        }
        SelectImplementation<R>.a aVar = (a) obj2;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    public final boolean W() {
        Object obj = f38997f.get(this);
        return obj == SelectKt.f39017f || (obj instanceof List);
    }

    public final boolean Y() {
        return f38997f.get(this) == SelectKt.f39019h;
    }

    public final boolean a0() {
        return f38997f.get(this) instanceof a;
    }

    @Override // kotlinx.coroutines.selects.j
    @yt.k
    public CoroutineContext b() {
        return this.f38998a;
    }

    public final void c0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @Override // kotlinx.coroutines.selects.j
    public void d(@yt.k g1 g1Var) {
        this.f39000c = g1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d0(kotlinx.coroutines.selects.SelectImplementation<R>.a r5, java.lang.Object r6, kotlin.coroutines.c<? super R> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.u0.n(r7)     // Catch: java.lang.Throwable -> L29
            goto L43
        L29:
            r5 = move-exception
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.u0.n(r7)
            java.lang.Object r6 = r5.d(r6)     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r7 = r5.c(r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r7 != r1) goto L43
            return r1
        L43:
            return r7
        L44:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.d0(kotlinx.coroutines.selects.SelectImplementation$a, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.b
    public <P, Q> void e(@yt.k g<? super P, ? extends Q> gVar, @yt.k p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        b.a.a(this, gVar, pVar);
    }

    @hk.h(name = "register")
    public final void e0(@yt.k SelectImplementation<R>.a aVar, boolean z10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38997f;
        if (atomicReferenceFieldUpdater.get(this) instanceof a) {
            return;
        }
        if (!z10) {
            M(aVar.f39003a);
        }
        if (!aVar.e(this)) {
            atomicReferenceFieldUpdater.set(this, aVar);
            return;
        }
        if (!z10) {
            List<SelectImplementation<R>.a> list = this.f38999b;
            f0.m(list);
            list.add(aVar);
        }
        aVar.f39009g = this.f39000c;
        aVar.f39010h = this.f39001d;
        this.f39000c = null;
        this.f39001d = -1;
    }

    @Override // kotlinx.coroutines.selects.b
    @s1
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @kotlin.t0(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @bk.h
    public void f(long j10, @yt.k ik.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        b.a.b(this, j10, lVar);
    }

    @Override // kotlinx.coroutines.m3
    public void g(@yt.k l0<?> l0Var, int i10) {
        this.f39000c = l0Var;
        this.f39001d = i10;
    }

    public final void g0(Object obj) {
        SelectImplementation<R>.a aVarV = V(obj);
        f0.m(aVarV);
        aVarV.f39009g = null;
        aVarV.f39010h = -1;
        e0(aVarV, true);
    }

    @yt.k
    public final TrySelectDetailedResult h0(@yt.k Object obj, @yt.l Object obj2) {
        return SelectKt.d(i0(obj, obj2));
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
        s(th2);
        return z1.f38230a;
    }

    public final int i0(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38997f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof o) {
                SelectImplementation<R>.a aVarV = V(obj);
                if (aVarV == null) {
                    continue;
                } else {
                    ik.l<Throwable, z1> lVarA = aVarV.a(this, obj2);
                    if (al.o.a(atomicReferenceFieldUpdater, this, obj3, aVarV)) {
                        this.f39002e = obj2;
                        if (SelectKt.o((o) obj3, lVarA)) {
                            return 0;
                        }
                        this.f39002e = null;
                        return 2;
                    }
                }
            } else {
                if (f0.g(obj3, SelectKt.f39018g) ? true : obj3 instanceof a) {
                    return 3;
                }
                if (f0.g(obj3, SelectKt.f39019h)) {
                    return 2;
                }
                if (f0.g(obj3, SelectKt.f39017f)) {
                    if (al.o.a(atomicReferenceFieldUpdater, this, obj3, s.k(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (al.o.a(atomicReferenceFieldUpdater, this, obj3, CollectionsKt___CollectionsKt.z4((Collection) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.selects.b
    public <P, Q> void j(@yt.k g<? super P, ? extends Q> gVar, P p10, @yt.k p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        f0(this, new a(gVar.b(), gVar.a(), gVar.d(), p10, pVar, gVar.c()), false, 1, null);
    }

    public final void j0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, ? extends Object> lVar, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!al.o.a(atomicReferenceFieldUpdater, obj, obj2, lVar.i(obj2)));
    }

    @Override // kotlinx.coroutines.selects.b
    public void k(@yt.k c cVar, @yt.k ik.l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        f0(this, new a(cVar.b(), cVar.a(), cVar.d(), SelectKt.l(), lVar, cVar.c()), false, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        r0 = r0.C();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (r0 != yj.b.h()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        zj.f.c(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        if (r0 != yj.b.h()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
    
        return kotlin.z1.f38230a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k0(kotlin.coroutines.c<? super kotlin.z1> r6) {
        /*
            r5 = this;
            kotlinx.coroutines.p r0 = new kotlinx.coroutines.p
            kotlin.coroutines.c r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.d(r6)
            r2 = 1
            r0.<init>(r1, r2)
            r0.Q()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = D()
        L11:
            java.lang.Object r2 = r1.get(r5)
            kotlinx.coroutines.internal.o0 r3 = kotlinx.coroutines.selects.SelectKt.j()
            if (r2 != r3) goto L29
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = D()
            boolean r2 = al.o.a(r3, r5, r2, r0)
            if (r2 == 0) goto L11
            r0.B(r5)
            goto L65
        L29:
            boolean r3 = r2 instanceof java.util.List
            if (r3 == 0) goto L52
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = D()
            kotlinx.coroutines.internal.o0 r4 = kotlinx.coroutines.selects.SelectKt.j()
            boolean r3 = al.o.a(r3, r5, r2, r4)
            if (r3 == 0) goto L11
            r3 = r2
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L44:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L11
            java.lang.Object r3 = r2.next()
            J(r5, r3)
            goto L44
        L52:
            boolean r1 = r2 instanceof kotlinx.coroutines.selects.SelectImplementation.a
            if (r1 == 0) goto L7c
            kotlin.z1 r1 = kotlin.z1.f38230a
            kotlinx.coroutines.selects.SelectImplementation$a r2 = (kotlinx.coroutines.selects.SelectImplementation.a) r2
            java.lang.Object r3 = B(r5)
            ik.l r2 = r2.a(r5, r3)
            r0.R(r1, r2)
        L65:
            java.lang.Object r0 = r0.C()
            java.lang.Object r1 = yj.b.h()
            if (r0 != r1) goto L72
            zj.f.c(r6)
        L72:
            java.lang.Object r6 = yj.b.h()
            if (r0 != r6) goto L79
            return r0
        L79:
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        L7c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unexpected state: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.k0(kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.j
    public boolean n(@yt.k Object obj, @yt.l Object obj2) {
        return i0(obj, obj2) == 0;
    }

    @Override // kotlinx.coroutines.selects.b
    public <Q> void p(@yt.k e<? extends Q> eVar, @yt.k p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        f0(this, new a(eVar.b(), eVar.a(), eVar.d(), null, pVar, eVar.c()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.j
    public void r(@yt.l Object obj) {
        this.f39002e = obj;
    }

    @Override // kotlinx.coroutines.n
    public void s(@yt.l Throwable th2) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38997f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.f39018g) {
                return;
            }
        } while (!al.o.a(atomicReferenceFieldUpdater, this, obj, SelectKt.f39019h));
        List<SelectImplementation<R>.a> list = this.f38999b;
        if (list == null) {
            return;
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            ((a) it2.next()).b();
        }
        this.f39002e = SelectKt.f39020i;
        this.f38999b = null;
    }
}
