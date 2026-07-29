package kotlinx.coroutines.debug.internal;

import hk.v;
import ik.p;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r0;
import kotlin.collections.t;
import kotlin.coroutines.CoroutineContext;
import kotlin.d1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.w0;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.u0;
import kotlin.w;
import kotlin.z1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.internal.k0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,609:1\n144#1:627\n145#1,4:629\n150#1,5:634\n144#1:639\n145#1,4:641\n150#1,5:646\n1#2:610\n1#2:628\n1#2:640\n766#3:611\n857#3,2:612\n1208#3,2:614\n1238#3,4:616\n1855#3,2:654\n350#3,7:662\n1819#3,8:669\n603#4:620\n603#4:633\n603#4:645\n603#4:651\n1295#4,2:652\n37#5,2:621\n37#5,2:623\n37#5,2:625\n1627#6,6:656\n1735#6,6:677\n*S KotlinDebug\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n238#1:627\n238#1:629,4\n238#1:634,5\n245#1:639\n245#1:641,4\n245#1:646,5\n238#1:628\n245#1:640\n104#1:611\n104#1:612,2\n105#1:614,2\n105#1:616,4\n299#1:654,2\n408#1:662,7\n496#1:669,8\n148#1:620\n238#1:633\n245#1:645\n279#1:651\n280#1:652,2\n204#1:621,2\n205#1:623,2\n206#1:625,2\n347#1:656,6\n547#1:677,6\n*E\n"})
public final class DebugProbesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final DebugProbesImpl f38422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final StackTraceElement f38423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final SimpleDateFormat f38424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static Thread f38425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public static final ConcurrentWeakMap<a<?>, Boolean> f38426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f38427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f38428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static final ik.l<Boolean, z1> f38429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public static final ConcurrentWeakMap<zj.c, DebugCoroutineInfoImpl> f38430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public static final b f38431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @k
    public static final c f38432k;

    public static final class a<T> implements kotlin.coroutines.c<T>, zj.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @hk.e
        @k
        public final kotlin.coroutines.c<T> f38433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @hk.e
        @k
        public final DebugCoroutineInfoImpl f38434b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@k kotlin.coroutines.c<? super T> cVar, @k DebugCoroutineInfoImpl debugCoroutineInfoImpl) {
            this.f38433a = cVar;
            this.f38434b = debugCoroutineInfoImpl;
        }

        @Override // zj.c
        @l
        public StackTraceElement D() {
            i iVarA = a();
            if (iVarA != null) {
                return iVarA.D();
            }
            return null;
        }

        public final i a() {
            return this.f38434b.d();
        }

        @Override // kotlin.coroutines.c
        @k
        public CoroutineContext b() {
            return this.f38433a.b();
        }

        @Override // zj.c
        @l
        public zj.c r() {
            i iVarA = a();
            if (iVarA != null) {
                return iVarA.r();
            }
            return null;
        }

        @k
        public String toString() {
            return this.f38433a.toString();
        }

        @Override // kotlin.coroutines.c
        public void x(@k Object obj) {
            DebugProbesImpl.f38422a.E(this);
            this.f38433a.x(obj);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public static final AtomicIntegerFieldUpdater f38435a = AtomicIntegerFieldUpdater.newUpdater(b.class, "installations");

        @v
        private volatile int installations;

        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public static final AtomicLongFieldUpdater f38436a = AtomicLongFieldUpdater.newUpdater(c.class, "sequenceNumber");

        @v
        private volatile long sequenceNumber;

        public c() {
        }

        public /* synthetic */ c(u uVar) {
            this();
        }
    }

    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n1#1,328:1\n148#2:329\n*E\n"})
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return uj.g.l(Long.valueOf(((a) t10).f38434b.f38419b), Long.valueOf(((a) t11).f38434b.f38419b));
        }
    }

    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n1#1,328:1\n279#2:329\n*E\n"})
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return uj.g.l(Long.valueOf(((a) t10).f38434b.f38419b), Long.valueOf(((a) t11).f38434b.f38419b));
        }
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        f38422a = debugProbesImpl;
        f38423b = new b.a().b();
        f38424c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        u uVar = null;
        f38426e = new ConcurrentWeakMap<>(false, 1, uVar);
        f38427f = true;
        f38428g = true;
        f38429h = debugProbesImpl.t();
        f38430i = new ConcurrentWeakMap<>(true);
        f38431j = new b(uVar);
        f38432k = new c(uVar);
    }

    public static /* synthetic */ void s(c2 c2Var) {
    }

    public final boolean A(StackTraceElement stackTraceElement) {
        return kotlin.text.u.v2(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, null);
    }

    public final a<?> B(kotlin.coroutines.c<?> cVar) {
        zj.c cVar2 = cVar instanceof zj.c ? (zj.c) cVar : null;
        if (cVar2 != null) {
            return C(cVar2);
        }
        return null;
    }

    public final a<?> C(zj.c cVar) {
        while (!(cVar instanceof a)) {
            cVar = cVar.r();
            if (cVar == null) {
                return null;
            }
        }
        return (a) cVar;
    }

    public final void D(PrintStream printStream, List<StackTraceElement> list) {
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            printStream.print("\n\tat " + ((StackTraceElement) it2.next()));
        }
    }

    public final void E(a<?> aVar) {
        zj.c cVarI;
        f38426e.remove(aVar);
        zj.c cVarF = aVar.f38434b.f();
        if (cVarF == null || (cVarI = I(cVarF)) == null) {
            return;
        }
        f38430i.remove(cVarI);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @k
    public final <T> kotlin.coroutines.c<T> F(@k kotlin.coroutines.c<? super T> cVar) {
        if (z() && B(cVar) == null) {
            return e(cVar, f38428g ? O(J(new Exception())) : null);
        }
        return cVar;
    }

    public final void G(@k kotlin.coroutines.c<?> cVar) {
        S(cVar, kotlinx.coroutines.debug.internal.d.f38455b);
    }

    public final void H(@k kotlin.coroutines.c<?> cVar) {
        S(cVar, kotlinx.coroutines.debug.internal.d.f38456c);
    }

    public final zj.c I(zj.c cVar) {
        do {
            cVar = cVar.r();
            if (cVar == null) {
                return null;
            }
        } while (cVar.D() == null);
        return cVar;
    }

    public final <T extends Throwable> List<StackTraceElement> J(T t10) {
        StackTraceElement[] stackTrace = t10.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i11 = length2 - 1;
                if (f0.g(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i10 = length2;
                    break;
                }
                if (i11 < 0) {
                    break;
                }
                length2 = i11;
            }
        }
        int i12 = i10 + 1;
        if (!f38427f) {
            int i13 = length - i12;
            ArrayList arrayList = new ArrayList(i13);
            for (int i14 = 0; i14 < i13; i14++) {
                arrayList.add(stackTrace[i14 + i12]);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i12) + 1);
        while (i12 < length) {
            if (A(stackTrace[i12])) {
                arrayList2.add(stackTrace[i12]);
                int i15 = i12 + 1;
                while (i15 < length && A(stackTrace[i15])) {
                    i15++;
                }
                int i16 = i15 - 1;
                int i17 = i16;
                while (i17 > i12 && stackTrace[i17].getFileName() == null) {
                    i17--;
                }
                if (i17 > i12 && i17 < i16) {
                    arrayList2.add(stackTrace[i17]);
                }
                arrayList2.add(stackTrace[i16]);
                i12 = i15;
            } else {
                arrayList2.add(stackTrace[i12]);
                i12++;
            }
        }
        return arrayList2;
    }

    public final void K(boolean z10) {
        f38428g = z10;
    }

    public final void L(boolean z10) {
        f38427f = z10;
    }

    public final void M() {
        f38425d = vj.b.b((21 & 1) != 0, (21 & 2) != 0 ? false : true, (21 & 4) != 0 ? null : null, (21 & 8) != 0 ? null : "Coroutines Debugger Cleaner", (21 & 16) != 0 ? -1 : 0, new ik.a<z1>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$startWeakRefCleanerThread$1
            public final void b() {
                DebugProbesImpl.f38430i.n();
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        });
    }

    public final void N() throws InterruptedException {
        Thread thread = f38425d;
        if (thread == null) {
            return;
        }
        f38425d = null;
        thread.interrupt();
        thread.join();
    }

    public final i O(List<StackTraceElement> list) {
        i iVar = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                iVar = new i(iVar, listIterator.previous());
            }
        }
        return new i(iVar, f38423b);
    }

    public final String P(Object obj) {
        return kotlinx.coroutines.debug.internal.e.b(obj.toString());
    }

    public final void Q() throws InterruptedException {
        ik.l<Boolean, z1> lVar;
        if (!z()) {
            throw new IllegalStateException("Agent was not installed".toString());
        }
        if (b.f38435a.decrementAndGet(f38431j) != 0) {
            return;
        }
        N();
        f38426e.clear();
        f38430i.clear();
        if (kotlinx.coroutines.debug.internal.a.f38439a.a() || (lVar = f38429h) == null) {
            return;
        }
        lVar.i(Boolean.FALSE);
    }

    public final void R(zj.c cVar, String str) {
        boolean z10;
        if (z()) {
            ConcurrentWeakMap<zj.c, DebugCoroutineInfoImpl> concurrentWeakMap = f38430i;
            DebugCoroutineInfoImpl debugCoroutineInfoImplRemove = concurrentWeakMap.remove(cVar);
            if (debugCoroutineInfoImplRemove != null) {
                z10 = false;
            } else {
                a<?> aVarC = C(cVar);
                if (aVarC == null || (debugCoroutineInfoImplRemove = aVarC.f38434b) == null) {
                    return;
                }
                z10 = true;
                zj.c cVarF = debugCoroutineInfoImplRemove.f();
                zj.c cVarI = cVarF != null ? I(cVarF) : null;
                if (cVarI != null) {
                    concurrentWeakMap.remove(cVarI);
                }
            }
            f0.n(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            debugCoroutineInfoImplRemove.j(str, (kotlin.coroutines.c) cVar, z10);
            zj.c cVarI2 = I(cVar);
            if (cVarI2 == null) {
                return;
            }
            concurrentWeakMap.put(cVarI2, debugCoroutineInfoImplRemove);
        }
    }

    public final void S(kotlin.coroutines.c<?> cVar, String str) {
        if (z()) {
            if (f0.g(str, kotlinx.coroutines.debug.internal.d.f38455b) && w.f38221g.h(1, 3, 30)) {
                zj.c cVar2 = cVar instanceof zj.c ? (zj.c) cVar : null;
                if (cVar2 == null) {
                    return;
                }
                R(cVar2, str);
                return;
            }
            a<?> aVarB = B(cVar);
            if (aVarB == null) {
                return;
            }
            T(aVarB, cVar, str);
        }
    }

    public final void T(a<?> aVar, kotlin.coroutines.c<?> cVar, String str) {
        if (z()) {
            aVar.f38434b.j(str, cVar, true);
        }
    }

    public final void d(c2 c2Var, Map<c2, DebugCoroutineInfoImpl> map, StringBuilder sb2, String str) {
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = map.get(c2Var);
        if (debugCoroutineInfoImpl != null) {
            StackTraceElement stackTraceElement = (StackTraceElement) CollectionsKt___CollectionsKt.B2(debugCoroutineInfoImpl.h());
            sb2.append(str + r(c2Var) + ", continuation is " + debugCoroutineInfoImpl.g() + " at line " + stackTraceElement + '\n');
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append('\t');
            str = sb3.toString();
        } else if (!(c2Var instanceof k0)) {
            sb2.append(str + r(c2Var) + '\n');
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append('\t');
            str = sb4.toString();
        }
        Iterator<c2> it2 = c2Var.getChildren().iterator();
        while (it2.hasNext()) {
            d(it2.next(), map, sb2, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> kotlin.coroutines.c<T> e(kotlin.coroutines.c<? super T> cVar, i iVar) {
        if (!z()) {
            return cVar;
        }
        a<?> aVar = new a<>(cVar, new DebugCoroutineInfoImpl(cVar.b(), iVar, c.f38436a.incrementAndGet(f38432k)));
        ConcurrentWeakMap<a<?>, Boolean> concurrentWeakMap = f38426e;
        concurrentWeakMap.put(aVar, Boolean.TRUE);
        if (!z()) {
            concurrentWeakMap.clear();
        }
        return aVar;
    }

    public final void f(@k PrintStream printStream) {
        synchronized (printStream) {
            f38422a.j(printStream);
            z1 z1Var = z1.f38230a;
        }
    }

    @k
    public final List<kotlinx.coroutines.debug.internal.c> g() {
        if (z()) {
            return SequencesKt___SequencesKt.c3(SequencesKt___SequencesKt.p1(SequencesKt___SequencesKt.K2(CollectionsKt___CollectionsKt.v1(q()), new d()), new ik.l<a<?>, kotlinx.coroutines.debug.internal.c>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1
                @Override // ik.l
                @l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final c i(@k DebugProbesImpl.a<?> aVar) {
                    CoroutineContext coroutineContextC;
                    if (DebugProbesImpl.f38422a.y(aVar) || (coroutineContextC = aVar.f38434b.c()) == null) {
                        return null;
                    }
                    return new c(aVar.f38434b, coroutineContextC);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    @k
    public final Object[] h() {
        String strK2;
        List<kotlinx.coroutines.debug.internal.c> listG = g();
        int size = listG.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        for (kotlinx.coroutines.debug.internal.c cVar : listG) {
            CoroutineContext coroutineContextA = cVar.a();
            n0 n0Var = (n0) coroutineContextA.c(n0.f38910c);
            Long lValueOf = null;
            String strP = (n0Var == null || (strK2 = n0Var.k2()) == null) ? null : P(strK2);
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) coroutineContextA.c(CoroutineDispatcher.f38234b);
            String strP2 = coroutineDispatcher != null ? P(coroutineDispatcher) : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n                {\n                    \"name\": ");
            sb2.append(strP);
            sb2.append(",\n                    \"id\": ");
            m0 m0Var = (m0) coroutineContextA.c(m0.f38908c);
            if (m0Var != null) {
                lValueOf = Long.valueOf(m0Var.k2());
            }
            sb2.append(lValueOf);
            sb2.append(",\n                    \"dispatcher\": ");
            sb2.append(strP2);
            sb2.append(",\n                    \"sequenceNumber\": ");
            sb2.append(cVar.f());
            sb2.append(",\n                    \"state\": \"");
            sb2.append(cVar.g());
            sb2.append("\"\n                } \n                ");
            arrayList3.add(StringsKt__IndentKt.p(sb2.toString()));
            arrayList2.add(cVar.d());
            arrayList.add(cVar.e());
        }
        return new Object[]{'[' + CollectionsKt___CollectionsKt.h3(arrayList3, null, null, null, 0, null, null, 63, null) + ']', arrayList.toArray(new Thread[0]), arrayList2.toArray(new zj.c[0]), listG.toArray(new kotlinx.coroutines.debug.internal.c[0])};
    }

    public final <R> List<R> i(final p<? super a<?>, ? super CoroutineContext, ? extends R> pVar) {
        if (z()) {
            return SequencesKt___SequencesKt.c3(SequencesKt___SequencesKt.p1(SequencesKt___SequencesKt.K2(CollectionsKt___CollectionsKt.v1(q()), new d()), new ik.l<a<?>, R>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // ik.l
                @l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final R i(@k DebugProbesImpl.a<?> aVar) {
                    CoroutineContext coroutineContextC;
                    if (DebugProbesImpl.f38422a.y(aVar) || (coroutineContextC = aVar.f38434b.c()) == null) {
                        return null;
                    }
                    return pVar.r0(aVar, coroutineContextC);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final void j(PrintStream printStream) {
        if (!z()) {
            throw new IllegalStateException("Debug probes are not installed".toString());
        }
        printStream.print("Coroutines dump " + f38424c.format(Long.valueOf(System.currentTimeMillis())));
        for (a aVar : SequencesKt___SequencesKt.K2(SequencesKt___SequencesKt.p0(CollectionsKt___CollectionsKt.v1(q()), new ik.l<a<?>, Boolean>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$2
            @Override // ik.l
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(@k DebugProbesImpl.a<?> aVar2) {
                return Boolean.valueOf(!DebugProbesImpl.f38422a.y(aVar2));
            }
        }), new e())) {
            DebugCoroutineInfoImpl debugCoroutineInfoImpl = aVar.f38434b;
            List<StackTraceElement> listH = debugCoroutineInfoImpl.h();
            DebugProbesImpl debugProbesImpl = f38422a;
            List<StackTraceElement> listN = debugProbesImpl.n(debugCoroutineInfoImpl.g(), debugCoroutineInfoImpl.lastObservedThread, listH);
            printStream.print("\n\nCoroutine " + aVar.f38433a + ", state: " + ((f0.g(debugCoroutineInfoImpl.g(), kotlinx.coroutines.debug.internal.d.f38455b) && listN == listH) ? debugCoroutineInfoImpl.g() + " (Last suspension stacktrace, not an actual stacktrace)" : debugCoroutineInfoImpl.g()));
            if (listH.isEmpty()) {
                printStream.print("\n\tat " + f38423b);
                debugProbesImpl.D(printStream, debugCoroutineInfoImpl.e());
            } else {
                debugProbesImpl.D(printStream, listN);
            }
        }
    }

    @k
    public final List<DebuggerInfo> k() {
        if (z()) {
            return SequencesKt___SequencesKt.c3(SequencesKt___SequencesKt.p1(SequencesKt___SequencesKt.K2(CollectionsKt___CollectionsKt.v1(q()), new d()), new ik.l<a<?>, DebuggerInfo>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1
                @Override // ik.l
                @l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final DebuggerInfo i(@k DebugProbesImpl.a<?> aVar) {
                    CoroutineContext coroutineContextC;
                    if (DebugProbesImpl.f38422a.y(aVar) || (coroutineContextC = aVar.f38434b.c()) == null) {
                        return null;
                    }
                    return new DebuggerInfo(aVar.f38434b, coroutineContextC);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    @k
    public final List<StackTraceElement> l(@k kotlinx.coroutines.debug.internal.c cVar, @k List<StackTraceElement> list) {
        return n(cVar.g(), cVar.e(), list);
    }

    @k
    public final String m(@k kotlinx.coroutines.debug.internal.c cVar) {
        List<StackTraceElement> listL = l(cVar, cVar.h());
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : listL) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n                {\n                    \"declaringClass\": \"");
            sb2.append(stackTraceElement.getClassName());
            sb2.append("\",\n                    \"methodName\": \"");
            sb2.append(stackTraceElement.getMethodName());
            sb2.append("\",\n                    \"fileName\": ");
            String fileName = stackTraceElement.getFileName();
            sb2.append(fileName != null ? P(fileName) : null);
            sb2.append(",\n                    \"lineNumber\": ");
            sb2.append(stackTraceElement.getLineNumber());
            sb2.append("\n                }\n                ");
            arrayList.add(StringsKt__IndentKt.p(sb2.toString()));
        }
        return '[' + CollectionsKt___CollectionsKt.h3(arrayList, null, null, null, 0, null, null, 63, null) + ']';
    }

    public final List<StackTraceElement> n(String str, Thread thread, List<StackTraceElement> list) {
        Object objB;
        if (!f0.g(str, kotlinx.coroutines.debug.internal.d.f38455b) || thread == null) {
            return list;
        }
        try {
            Result.a aVar = Result.f37633a;
            objB = Result.b(thread.getStackTrace());
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            objB = Result.b(u0.a(th2));
        }
        if (Result.l(objB)) {
            objB = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) objB;
        if (stackTraceElementArr == null) {
            return list;
        }
        int length = stackTraceElementArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i10];
            if (f0.g(stackTraceElement.getClassName(), kotlinx.coroutines.internal.n0.f38817a) && f0.g(stackTraceElement.getMethodName(), "resumeWith") && f0.g(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                break;
            }
            i10++;
        }
        Pair<Integer, Integer> pairO = o(i10, stackTraceElementArr, list);
        int iIntValue = pairO.a().intValue();
        int iIntValue2 = pairO.b().intValue();
        if (iIntValue == -1) {
            return list;
        }
        ArrayList arrayList = new ArrayList((((list.size() + i10) - iIntValue) - 1) - iIntValue2);
        int i11 = i10 - iIntValue2;
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(stackTraceElementArr[i12]);
        }
        int size = list.size();
        for (int i13 = iIntValue + 1; i13 < size; i13++) {
            arrayList.add(list.get(i13));
        }
        return arrayList;
    }

    public final Pair<Integer, Integer> o(int i10, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        for (int i11 = 0; i11 < 3; i11++) {
            int iP = f38422a.p((i10 - 1) - i11, stackTraceElementArr, list);
            if (iP != -1) {
                return d1.a(Integer.valueOf(iP), Integer.valueOf(i11));
            }
        }
        return d1.a(-1, 0);
    }

    public final int p(int i10, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt___ArraysKt.qf(stackTraceElementArr, i10);
        if (stackTraceElement == null) {
            return -1;
        }
        int i11 = 0;
        for (StackTraceElement stackTraceElement2 : list) {
            if (f0.g(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && f0.g(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && f0.g(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public final Set<a<?>> q() {
        return f38426e.keySet();
    }

    public final String r(c2 c2Var) {
        return c2Var instanceof JobSupport ? ((JobSupport) c2Var).x1() : c2Var.toString();
    }

    public final ik.l<Boolean, z1> t() {
        Object objB;
        try {
            Result.a aVar = Result.f37633a;
            Object objNewInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            f0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            objB = Result.b((ik.l) w0.q(objNewInstance, 1));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            objB = Result.b(u0.a(th2));
        }
        if (Result.l(objB)) {
            objB = null;
        }
        return (ik.l) objB;
    }

    public final boolean u() {
        return f38428g;
    }

    public final boolean v() {
        return f38427f;
    }

    @k
    public final String w(@k c2 c2Var) {
        if (!z()) {
            throw new IllegalStateException("Debug probes are not installed".toString());
        }
        Set<a<?>> setQ = q();
        ArrayList<a> arrayList = new ArrayList();
        for (Object obj : setQ) {
            if (((a) obj).f38433a.b().c(c2.f38296x2) != null) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(t.Y(arrayList, 10)), 16));
        for (a aVar : arrayList) {
            linkedHashMap.put(f2.B(aVar.f38433a.b()), aVar.f38434b);
        }
        StringBuilder sb2 = new StringBuilder();
        f38422a.d(c2Var, linkedHashMap, sb2, "");
        String string = sb2.toString();
        f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void x() {
        ik.l<Boolean, z1> lVar;
        if (b.f38435a.incrementAndGet(f38431j) > 1) {
            return;
        }
        M();
        if (kotlinx.coroutines.debug.internal.a.f38439a.a() || (lVar = f38429h) == null) {
            return;
        }
        lVar.i(Boolean.TRUE);
    }

    public final boolean y(a<?> aVar) {
        c2 c2Var;
        CoroutineContext coroutineContextC = aVar.f38434b.c();
        if (coroutineContextC == null || (c2Var = (c2) coroutineContextC.c(c2.f38296x2)) == null || !c2Var.n()) {
            return false;
        }
        f38426e.remove(aVar);
        return true;
    }

    public final boolean z() {
        return b.f38435a.get(f38431j) > 0;
    }
}
