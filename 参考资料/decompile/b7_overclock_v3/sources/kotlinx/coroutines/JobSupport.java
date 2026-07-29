package kotlinx.coroutines;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 9 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 10 CompletionHandler.common.kt\nkotlinx/coroutines/CompletionHandler_commonKt\n+ 11 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 12 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 13 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1451:1\n705#1,2:1458\n366#1,2:1468\n368#1,4:1473\n372#1,4:1479\n376#1,2:1486\n366#1,2:1488\n368#1,4:1493\n372#1,4:1499\n376#1,2:1506\n177#1,2:1515\n706#1:1517\n177#1,2:1518\n177#1,2:1537\n177#1,2:1552\n705#1,2:1554\n705#1,2:1556\n177#1,2:1558\n705#1,2:1560\n177#1,2:1562\n177#1,2:1569\n177#1,2:1571\n1#2:1452\n1#2:1477\n1#2:1497\n28#3,4:1453\n28#3,4:1520\n28#3,4:1564\n28#3,4:1573\n20#4:1457\n20#4:1524\n20#4:1568\n20#4:1577\n288#5,2:1460\n288#5,2:1462\n19#6:1464\n162#7:1465\n162#7:1466\n153#7,4:1580\n75#8:1467\n75#8:1478\n75#8:1498\n75#8:1511\n341#9,3:1470\n344#9,3:1483\n341#9,3:1490\n344#9,3:1503\n341#9,3:1508\n344#9,3:1512\n47#10:1525\n22#11:1526\n22#11:1527\n13#11:1548\n13#11:1551\n13#11:1578\n13#11:1579\n13#11:1584\n13#11:1585\n134#12:1528\n73#12,3:1529\n135#12,5:1532\n314#13,9:1539\n323#13,2:1549\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n249#1:1458,2\n331#1:1468,2\n331#1:1473,4\n331#1:1479,4\n331#1:1486,2\n363#1:1488,2\n363#1:1493,4\n363#1:1499,4\n363#1:1506,2\n380#1:1515,2\n425#1:1517\n460#1:1518,2\n552#1:1537,2\n593#1:1552,2\n620#1:1554,2\n629#1:1556,2\n693#1:1558,2\n722#1:1560,2\n735#1:1562,2\n808#1:1569,2\n830#1:1571,2\n331#1:1477\n363#1:1497\n212#1:1453,4\n477#1:1520,4\n738#1:1564,4\n883#1:1573,4\n212#1:1457\n477#1:1524\n738#1:1568\n883#1:1577\n260#1:1460,2\n264#1:1462,2\n272#1:1464\n278#1:1465\n280#1:1466\n1217#1:1580,4\n283#1:1467\n331#1:1478\n363#1:1498\n371#1:1511\n331#1:1470,3\n331#1:1483,3\n363#1:1490,3\n363#1:1503,3\n367#1:1508,3\n367#1:1512,3\n482#1:1525\n494#1:1526\n504#1:1527\n560#1:1548\n576#1:1551\n923#1:1578\n973#1:1579\n1236#1:1584\n1258#1:1585\n525#1:1528\n525#1:1529,3\n525#1:1532,5\n558#1:1539,9\n558#1:1549,2\n*E\n"})
@kotlin.k(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
public class JobSupport implements c2, w, s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38244a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38245b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");

    @yt.l
    @hk.v
    private volatile Object _parentHandle;

    @yt.l
    @hk.v
    private volatile Object _state;

    @kotlin.jvm.internal.t0({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$AwaitContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1451:1\n1#2:1452\n*E\n"})
    public static final class a<T> extends p<T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @yt.k
        public final JobSupport f38246i;

        public a(@yt.k kotlin.coroutines.c<? super T> cVar, @yt.k JobSupport jobSupport) {
            super(cVar, 1);
            this.f38246i = jobSupport;
        }

        @Override // kotlinx.coroutines.p
        @yt.k
        public String S() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.p
        @yt.k
        public Throwable z(@yt.k c2 c2Var) {
            Throwable thE;
            Object objK0 = this.f38246i.K0();
            return (!(objK0 instanceof c) || (thE = ((c) objK0).e()) == null) ? objK0 instanceof c0 ? ((c0) objK0).f38294a : c2Var.Z() : thE;
        }
    }

    public static final class b extends i2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.k
        public final JobSupport f38247e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @yt.k
        public final c f38248f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final v f38249g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.l
        public final Object f38250h;

        public b(@yt.k JobSupport jobSupport, @yt.k c cVar, @yt.k v vVar, @yt.l Object obj) {
            this.f38247e = jobSupport;
            this.f38248f = cVar;
            this.f38249g = vVar;
            this.f38250h = obj;
        }

        @Override // kotlinx.coroutines.e0
        public void R(@yt.l Throwable th2) {
            this.f38247e.q0(this.f38248f, this.f38249g, this.f38250h);
        }

        @Override // ik.l
        public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
            R(th2);
            return kotlin.z1.f38230a;
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$Finishing\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1451:1\n1#2:1452\n*E\n"})
    public static final class c implements w1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public static final AtomicIntegerFieldUpdater f38251b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public static final AtomicReferenceFieldUpdater f38252c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public static final AtomicReferenceFieldUpdater f38253d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");

        @yt.l
        @hk.v
        private volatile Object _exceptionsHolder;

        @hk.v
        private volatile int _isCompleting;

        @yt.l
        @hk.v
        private volatile Object _rootCause;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final n2 f38254a;

        public c(@yt.k n2 n2Var, boolean z10, @yt.l Throwable th2) {
            this.f38254a = n2Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th2;
        }

        public final void a(@yt.k Throwable th2) {
            Throwable thE = e();
            if (thE == null) {
                l(th2);
                return;
            }
            if (th2 == thE) {
                return;
            }
            Object objD = d();
            if (objD == null) {
                k(th2);
                return;
            }
            if (objD instanceof Throwable) {
                if (th2 == objD) {
                    return;
                }
                ArrayList<Throwable> arrayListC = c();
                arrayListC.add(objD);
                arrayListC.add(th2);
                k(arrayListC);
                return;
            }
            if (objD instanceof ArrayList) {
                ((ArrayList) objD).add(th2);
                return;
            }
            throw new IllegalStateException(("State is " + objD).toString());
        }

        @Override // kotlinx.coroutines.w1
        @yt.k
        public n2 b() {
            return this.f38254a;
        }

        public final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        public final Object d() {
            return f38253d.get(this);
        }

        @yt.l
        public final Throwable e() {
            return (Throwable) f38252c.get(this);
        }

        public final boolean f() {
            return e() != null;
        }

        public final boolean g() {
            return f38251b.get(this) != 0;
        }

        public final boolean h() {
            return d() == j2.f38883h;
        }

        @yt.k
        public final List<Throwable> i(@yt.l Throwable th2) {
            ArrayList<Throwable> arrayListC;
            Object objD = d();
            if (objD == null) {
                arrayListC = c();
            } else if (objD instanceof Throwable) {
                ArrayList<Throwable> arrayListC2 = c();
                arrayListC2.add(objD);
                arrayListC = arrayListC2;
            } else {
                if (!(objD instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objD).toString());
                }
                arrayListC = (ArrayList) objD;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListC.add(0, thE);
            }
            if (th2 != null && !kotlin.jvm.internal.f0.g(th2, thE)) {
                arrayListC.add(th2);
            }
            k(j2.f38883h);
            return arrayListC;
        }

        @Override // kotlinx.coroutines.w1
        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z10) {
            f38251b.set(this, z10 ? 1 : 0);
        }

        public final void k(Object obj) {
            f38253d.set(this, obj);
        }

        public final void l(@yt.l Throwable th2) {
            f38252c.set(this, th2);
        }

        @yt.k
        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + b() + ']';
        }
    }

    public final class d extends i2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.k
        public final kotlinx.coroutines.selects.j<?> f38255e;

        public d(@yt.k kotlinx.coroutines.selects.j<?> jVar) {
            this.f38255e = jVar;
        }

        @Override // kotlinx.coroutines.e0
        public void R(@yt.l Throwable th2) {
            Object objK0 = JobSupport.this.K0();
            if (!(objK0 instanceof c0)) {
                objK0 = j2.h(objK0);
            }
            this.f38255e.n(JobSupport.this, objK0);
        }

        @Override // ik.l
        public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
            R(th2);
            return kotlin.z1.f38230a;
        }
    }

    public final class e extends i2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.k
        public final kotlinx.coroutines.selects.j<?> f38257e;

        public e(@yt.k kotlinx.coroutines.selects.j<?> jVar) {
            this.f38257e = jVar;
        }

        @Override // kotlinx.coroutines.e0
        public void R(@yt.l Throwable th2) {
            this.f38257e.n(JobSupport.this, kotlin.z1.f38230a);
        }

        @Override // ik.l
        public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
            R(th2);
            return kotlin.z1.f38230a;
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,367:1\n525#2:368\n*E\n"})
    public static final class f extends LockFreeLinkedListNode.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JobSupport f38259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f38260e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(LockFreeLinkedListNode lockFreeLinkedListNode, JobSupport jobSupport, Object obj) {
            super(lockFreeLinkedListNode);
            this.f38259d = jobSupport;
            this.f38260e = obj;
        }

        @Override // kotlinx.coroutines.internal.b
        @yt.l
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object e(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f38259d.K0() == this.f38260e) {
                return null;
            }
            return kotlinx.coroutines.internal.v.a();
        }
    }

    public JobSupport(boolean z10) {
        this._state = z10 ? j2.f38885j : j2.f38884i;
    }

    public static /* synthetic */ void D0() {
    }

    public static /* synthetic */ void H0() {
    }

    private final void T0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, kotlin.z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ <T extends i2> void e1(n2 n2Var, Throwable th2) throws Throwable {
        Object objW = n2Var.w();
        kotlin.jvm.internal.f0.n(objW, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeX = (LockFreeLinkedListNode) objW; !kotlin.jvm.internal.f0.g(lockFreeLinkedListNodeX, n2Var); lockFreeLinkedListNodeX = lockFreeLinkedListNodeX.x()) {
            kotlin.jvm.internal.f0.y(3, i1.a.f31577d5);
            if (lockFreeLinkedListNodeX instanceof LockFreeLinkedListNode) {
                i2 i2Var = (i2) lockFreeLinkedListNodeX;
                try {
                    i2Var.R(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        kotlin.o.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + i2Var + " for " + this, th3);
                        kotlin.z1 z1Var = kotlin.z1.f38230a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            M0(completionHandlerException);
        }
    }

    public static /* synthetic */ JobCancellationException t0(JobSupport jobSupport, String str, Throwable th2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            th2 = null;
        }
        if (str == null) {
            str = jobSupport.n0();
        }
        return new JobCancellationException(str, th2, jobSupport);
    }

    public static /* synthetic */ CancellationException w1(JobSupport jobSupport, Throwable th2, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return jobSupport.v1(th2, str);
    }

    public final Throwable A0(c cVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.f()) {
                return new JobCancellationException(n0(), null, this);
            }
            return null;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th2 = (Throwable) next;
        if (th2 != null) {
            return th2;
        }
        Throwable th3 = list.get(0);
        if (th3 instanceof TimeoutCancellationException) {
            Iterator<T> it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next2 = it3.next();
                Throwable th4 = (Throwable) next2;
                if (th4 != th3 && (th4 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th5 = (Throwable) obj;
            if (th5 != null) {
                return th5;
            }
        }
        return th3;
    }

    public final Object A1(Object obj, Object obj2) {
        return !(obj instanceof w1) ? j2.f38876a : ((!(obj instanceof j1) && !(obj instanceof i2)) || (obj instanceof v) || (obj2 instanceof c0)) ? B1((w1) obj, obj2) : y1((w1) obj, obj2) ? obj2 : j2.f38878c;
    }

    public boolean B0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, kotlinx.coroutines.JobSupport] */
    public final Object B1(w1 w1Var, Object obj) throws Throwable {
        n2 n2VarI0 = I0(w1Var);
        if (n2VarI0 == null) {
            return j2.f38878c;
        }
        c cVar = w1Var instanceof c ? (c) w1Var : null;
        if (cVar == null) {
            cVar = new c(n2VarI0, false, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (cVar) {
            if (cVar.g()) {
                return j2.f38876a;
            }
            cVar.j(true);
            if (cVar != w1Var && !al.o.a(f38244a, this, w1Var, cVar)) {
                return j2.f38878c;
            }
            boolean zF = cVar.f();
            c0 c0Var = obj instanceof c0 ? (c0) obj : null;
            if (c0Var != null) {
                cVar.a(c0Var.f38294a);
            }
            ?? E = Boolean.valueOf(zF ? false : true).booleanValue() ? cVar.e() : 0;
            objectRef.element = E;
            kotlin.z1 z1Var = kotlin.z1.f38230a;
            if (E != 0) {
                b1(n2VarI0, E);
            }
            v vVarV0 = v0(w1Var);
            return (vVarV0 == null || !D1(cVar, vVarV0, obj)) ? u0(cVar, obj) : j2.f38877b;
        }
    }

    @yt.k
    public final kotlinx.coroutines.selects.e<?> C0() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.f38261c;
        kotlin.jvm.internal.f0.n(jobSupport$onAwaitInternal$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        ik.q qVar = (ik.q) kotlin.jvm.internal.w0.q(jobSupport$onAwaitInternal$1, 3);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.f38262c;
        kotlin.jvm.internal.f0.n(jobSupport$onAwaitInternal$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.f(this, qVar, (ik.q) kotlin.jvm.internal.w0.q(jobSupport$onAwaitInternal$2, 3), null, 8, null);
    }

    @Override // kotlinx.coroutines.s2
    @yt.k
    public CancellationException C1() {
        Throwable thE;
        Object objK0 = K0();
        if (objK0 instanceof c) {
            thE = ((c) objK0).e();
        } else if (objK0 instanceof c0) {
            thE = ((c0) objK0).f38294a;
        } else {
            if (objK0 instanceof w1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objK0).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + t1(objK0), thE, this);
    }

    public final boolean D1(c cVar, v vVar, Object obj) {
        while (c2.a.g(vVar.f39076e, false, false, new b(this, cVar, vVar, obj), 1, null) == p2.f38929a) {
            vVar = a1(vVar);
            if (vVar == null) {
                return false;
            }
        }
        return true;
    }

    public boolean E0() {
        return false;
    }

    @Override // kotlinx.coroutines.c2
    @yt.k
    public final g1 F0(boolean z10, boolean z11, @yt.k ik.l<? super Throwable, kotlin.z1> lVar) {
        i2 i2VarY0 = Y0(lVar, z10);
        while (true) {
            Object objK0 = K0();
            if (objK0 instanceof j1) {
                j1 j1Var = (j1) objK0;
                if (!j1Var.isActive()) {
                    l1(j1Var);
                } else if (al.o.a(f38244a, this, objK0, i2VarY0)) {
                    return i2VarY0;
                }
            } else {
                if (!(objK0 instanceof w1)) {
                    if (z11) {
                        c0 c0Var = objK0 instanceof c0 ? (c0) objK0 : null;
                        lVar.i(c0Var != null ? c0Var.f38294a : null);
                    }
                    return p2.f38929a;
                }
                n2 n2VarB = ((w1) objK0).b();
                if (n2VarB == null) {
                    kotlin.jvm.internal.f0.n(objK0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    m1((i2) objK0);
                } else {
                    g1 g1Var = p2.f38929a;
                    if (z10 && (objK0 instanceof c)) {
                        synchronized (objK0) {
                            thE = ((c) objK0).e();
                            if (thE == null || ((lVar instanceof v) && !((c) objK0).g())) {
                                if (c0(objK0, n2VarB, i2VarY0)) {
                                    if (thE == null) {
                                        return i2VarY0;
                                    }
                                    g1Var = i2VarY0;
                                }
                            }
                            kotlin.z1 z1Var = kotlin.z1.f38230a;
                        }
                    }
                    if (thE != null) {
                        if (z11) {
                            lVar.i(thE);
                        }
                        return g1Var;
                    }
                    if (c0(objK0, n2VarB, i2VarY0)) {
                        return i2VarY0;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.w
    public final void G0(@yt.k s2 s2Var) throws Throwable {
        i0(s2Var);
    }

    public final n2 I0(w1 w1Var) {
        n2 n2VarB = w1Var.b();
        if (n2VarB != null) {
            return n2VarB;
        }
        if (w1Var instanceof j1) {
            return new n2();
        }
        if (w1Var instanceof i2) {
            m1((i2) w1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + w1Var).toString());
    }

    @yt.l
    public final u J0() {
        return (u) f38245b.get(this);
    }

    @yt.l
    public final Object K0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38244a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof kotlinx.coroutines.internal.g0)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.g0) obj).b(this);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext L(@yt.k CoroutineContext coroutineContext) {
        return c2.a.i(this, coroutineContext);
    }

    public boolean L0(@yt.k Throwable th2) {
        return false;
    }

    @Override // kotlinx.coroutines.c2
    @yt.k
    public final g1 L1(@yt.k ik.l<? super Throwable, kotlin.z1> lVar) {
        return F0(false, true, lVar);
    }

    public void M0(@yt.k Throwable th2) throws Throwable {
        throw th2;
    }

    public final void N0(@yt.l c2 c2Var) {
        if (c2Var == null) {
            q1(p2.f38929a);
            return;
        }
        c2Var.start();
        u uVarF2 = c2Var.f2(this);
        q1(uVarF2);
        if (n()) {
            uVarF2.dispose();
            q1(p2.f38929a);
        }
    }

    public final boolean O0(w1 w1Var) {
        return (w1Var instanceof c) && ((c) w1Var).f();
    }

    @yt.l
    public final Throwable P() {
        Object objK0 = K0();
        if (!(objK0 instanceof w1)) {
            return z0(objK0);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final boolean P0() {
        return K0() instanceof c0;
    }

    public boolean Q0() {
        return false;
    }

    public final boolean R0() {
        Object objK0;
        do {
            objK0 = K0();
            if (!(objK0 instanceof w1)) {
                return false;
            }
        } while (r1(objK0) < 0);
        return true;
    }

    public final Object S0(kotlin.coroutines.c<? super kotlin.z1> cVar) {
        p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        r.a(pVar, L1(new u2(pVar)));
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC == yj.b.h() ? objC : kotlin.z1.f38230a;
    }

    @Override // kotlinx.coroutines.c2
    @yt.l
    public final Object T(@yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        if (R0()) {
            Object objS0 = S0(cVar);
            return objS0 == yj.b.h() ? objS0 : kotlin.z1.f38230a;
        }
        f2.z(cVar.b());
        return kotlin.z1.f38230a;
    }

    public final Void U0(ik.l<Object, kotlin.z1> lVar) {
        while (true) {
            lVar.i(K0());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object V0(Object obj) throws Throwable {
        Object[] objArr = 0;
        Throwable thR0 = null;
        while (true) {
            Object objK0 = K0();
            if (objK0 instanceof c) {
                synchronized (objK0) {
                    if (((c) objK0).h()) {
                        return j2.f38879d;
                    }
                    boolean zF = ((c) objK0).f();
                    if (obj != null || !zF) {
                        if (thR0 == null) {
                            thR0 = r0(obj);
                        }
                        ((c) objK0).a(thR0);
                    }
                    Throwable thE = zF ^ true ? ((c) objK0).e() : null;
                    if (thE != null) {
                        b1(((c) objK0).b(), thE);
                    }
                    return j2.f38876a;
                }
            }
            if (!(objK0 instanceof w1)) {
                return j2.f38879d;
            }
            if (thR0 == null) {
                thR0 = r0(obj);
            }
            w1 w1Var = (w1) objK0;
            if (!w1Var.isActive()) {
                Object objA1 = A1(objK0, new c0(thR0, false, 2, objArr == true ? 1 : 0));
                if (objA1 == j2.f38876a) {
                    throw new IllegalStateException(("Cannot happen in " + objK0).toString());
                }
                if (objA1 != j2.f38878c) {
                    return objA1;
                }
            } else if (z1(w1Var, thR0)) {
                return j2.f38876a;
            }
        }
    }

    public final boolean W0(@yt.l Object obj) {
        Object objA1;
        do {
            objA1 = A1(K0(), obj);
            if (objA1 == j2.f38876a) {
                return false;
            }
            if (objA1 == j2.f38877b) {
                return true;
            }
        } while (objA1 == j2.f38878c);
        e0(objA1);
        return true;
    }

    @yt.l
    public final Object X0(@yt.l Object obj) {
        Object objA1;
        do {
            objA1 = A1(K0(), obj);
            if (objA1 == j2.f38876a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, z0(obj));
            }
        } while (objA1 == j2.f38878c);
        return objA1;
    }

    public final i2 Y0(ik.l<? super Throwable, kotlin.z1> lVar, boolean z10) {
        i2 b2Var;
        if (z10) {
            b2Var = lVar instanceof d2 ? (d2) lVar : null;
            if (b2Var == null) {
                b2Var = new a2(lVar);
            }
        } else {
            b2Var = lVar instanceof i2 ? (i2) lVar : null;
            if (b2Var == null) {
                b2Var = new b2(lVar);
            }
        }
        b2Var.T(this);
        return b2Var;
    }

    @Override // kotlinx.coroutines.c2
    @yt.k
    public final CancellationException Z() {
        Object objK0 = K0();
        if (!(objK0 instanceof c)) {
            if (objK0 instanceof w1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objK0 instanceof c0) {
                return w1(this, ((c0) objK0).f38294a, null, 1, null);
            }
            return new JobCancellationException(r0.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((c) objK0).e();
        if (thE != null) {
            CancellationException cancellationExceptionV1 = v1(thE, r0.a(this) + " is cancelling");
            if (cancellationExceptionV1 != null) {
                return cancellationExceptionV1;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @yt.k
    public String Z0() {
        return r0.a(this);
    }

    public final v a1(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.B()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.z();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.x();
            if (!lockFreeLinkedListNode.B()) {
                if (lockFreeLinkedListNode instanceof v) {
                    return (v) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof n2) {
                    return null;
                }
            }
        }
    }

    public final void b1(n2 n2Var, Throwable th2) throws Throwable {
        h1(th2);
        Object objW = n2Var.w();
        kotlin.jvm.internal.f0.n(objW, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeX = (LockFreeLinkedListNode) objW; !kotlin.jvm.internal.f0.g(lockFreeLinkedListNodeX, n2Var); lockFreeLinkedListNodeX = lockFreeLinkedListNodeX.x()) {
            if (lockFreeLinkedListNodeX instanceof d2) {
                i2 i2Var = (i2) lockFreeLinkedListNodeX;
                try {
                    i2Var.R(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        kotlin.o.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + i2Var + " for " + this, th3);
                        kotlin.z1 z1Var = kotlin.z1.f38230a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            M0(completionHandlerException);
        }
        m0(th2);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @yt.l
    public <E extends CoroutineContext.a> E c(@yt.k CoroutineContext.b<E> bVar) {
        return (E) c2.a.e(this, bVar);
    }

    public final boolean c0(Object obj, n2 n2Var, i2 i2Var) {
        int iO;
        f fVar = new f(i2Var, this, obj);
        do {
            iO = n2Var.z().O(i2Var, n2Var, fVar);
            if (iO == 1) {
                return true;
            }
        } while (iO != 2);
        return false;
    }

    public final void c1(n2 n2Var, Throwable th2) throws Throwable {
        Object objW = n2Var.w();
        kotlin.jvm.internal.f0.n(objW, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeX = (LockFreeLinkedListNode) objW; !kotlin.jvm.internal.f0.g(lockFreeLinkedListNodeX, n2Var); lockFreeLinkedListNodeX = lockFreeLinkedListNodeX.x()) {
            if (lockFreeLinkedListNodeX instanceof i2) {
                i2 i2Var = (i2) lockFreeLinkedListNodeX;
                try {
                    i2Var.R(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        kotlin.o.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + i2Var + " for " + this, th3);
                        kotlin.z1 z1Var = kotlin.z1.f38230a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            M0(completionHandlerException);
        }
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        h(null);
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean d(Throwable th2) throws Throwable {
        Throwable jobCancellationException;
        if (th2 == null || (jobCancellationException = w1(this, th2, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(n0(), null, this);
        }
        j0(jobCancellationException);
        return true;
    }

    public final void d0(Throwable th2, List<? extends Throwable> list) throws IllegalAccessException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th3 : list) {
            if (th3 != th2 && th3 != th2 && !(th3 instanceof CancellationException) && setNewSetFromMap.add(th3)) {
                kotlin.o.a(th2, th3);
            }
        }
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @yt.k
    public c2 d1(@yt.k c2 c2Var) {
        return c2.a.j(this, c2Var);
    }

    public void e0(@yt.l Object obj) {
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @yt.k
    public CoroutineContext f(@yt.k CoroutineContext.b<?> bVar) {
        return c2.a.h(this, bVar);
    }

    @yt.l
    public final Object f0(@yt.k kotlin.coroutines.c<Object> cVar) throws Throwable {
        Object objK0;
        do {
            objK0 = K0();
            if (!(objK0 instanceof w1)) {
                if (objK0 instanceof c0) {
                    throw ((c0) objK0).f38294a;
                }
                return j2.h(objK0);
            }
        } while (r1(objK0) < 0);
        return g0(cVar);
    }

    public final Object f1(Object obj, Object obj2) throws Throwable {
        if (obj2 instanceof c0) {
            throw ((c0) obj2).f38294a;
        }
        return obj2;
    }

    @Override // kotlinx.coroutines.c2
    @yt.k
    public final u f2(@yt.k w wVar) {
        g1 g1VarG = c2.a.g(this, true, false, new v(wVar), 2, null);
        kotlin.jvm.internal.f0.n(g1VarG, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (u) g1VarG;
    }

    public final Object g0(kotlin.coroutines.c<Object> cVar) {
        a aVar = new a(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), this);
        aVar.Q();
        r.a(aVar, L1(new t2(aVar)));
        Object objC = aVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }

    public final void g1(kotlinx.coroutines.selects.j<?> jVar, Object obj) {
        Object objK0;
        do {
            objK0 = K0();
            if (!(objK0 instanceof w1)) {
                if (!(objK0 instanceof c0)) {
                    objK0 = j2.h(objK0);
                }
                jVar.r(objK0);
                return;
            }
        } while (r1(objK0) < 0);
        jVar.d(L1(new d(jVar)));
    }

    @Override // kotlinx.coroutines.c2
    @yt.k
    public final kotlin.sequences.m<c2> getChildren() {
        return kotlin.sequences.q.b(new JobSupport$children$1(this, null));
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @yt.k
    public final CoroutineContext.b<?> getKey() {
        return c2.f38296x2;
    }

    @Override // kotlinx.coroutines.c2
    @yt.l
    public c2 getParent() {
        u uVarJ0 = J0();
        if (uVarJ0 != null) {
            return uVarJ0.getParent();
        }
        return null;
    }

    @Override // kotlinx.coroutines.c2
    public void h(@yt.l CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(n0(), null, this);
        }
        j0(cancellationException);
    }

    public final boolean h0(@yt.l Throwable th2) {
        return i0(th2);
    }

    public void h1(@yt.l Throwable th2) {
    }

    public final boolean i0(@yt.l Object obj) throws Throwable {
        Object objV0 = j2.f38876a;
        if (E0() && (objV0 = k0(obj)) == j2.f38877b) {
            return true;
        }
        if (objV0 == j2.f38876a) {
            objV0 = V0(obj);
        }
        if (objV0 == j2.f38876a || objV0 == j2.f38877b) {
            return true;
        }
        if (objV0 == j2.f38879d) {
            return false;
        }
        e0(objV0);
        return true;
    }

    @Override // kotlinx.coroutines.c2
    public boolean isActive() {
        Object objK0 = K0();
        return (objK0 instanceof w1) && ((w1) objK0).isActive();
    }

    @Override // kotlinx.coroutines.c2
    public final boolean isCancelled() {
        Object objK0 = K0();
        return (objK0 instanceof c0) || ((objK0 instanceof c) && ((c) objK0).f());
    }

    public void j0(@yt.k Throwable th2) throws Throwable {
        i0(th2);
    }

    public void j1(@yt.l Object obj) {
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <R> R k(R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) c2.a.d(this, r10, pVar);
    }

    public final Object k0(Object obj) {
        Object objA1;
        do {
            Object objK0 = K0();
            if (!(objK0 instanceof w1) || ((objK0 instanceof c) && ((c) objK0).g())) {
                return j2.f38876a;
            }
            objA1 = A1(objK0, new c0(r0(obj), false, 2, null));
        } while (objA1 == j2.f38878c);
        return objA1;
    }

    public void k1() {
    }

    public final void l1(j1 j1Var) {
        n2 n2Var = new n2();
        Object v1Var = n2Var;
        if (!j1Var.isActive()) {
            v1Var = new v1(n2Var);
        }
        al.o.a(f38244a, this, j1Var, v1Var);
    }

    public final boolean m0(Throwable th2) {
        if (Q0()) {
            return true;
        }
        boolean z10 = th2 instanceof CancellationException;
        u uVarJ0 = J0();
        return (uVarJ0 == null || uVarJ0 == p2.f38929a) ? z10 : uVarJ0.d(th2) || z10;
    }

    public final void m1(i2 i2Var) {
        i2Var.n(new n2());
        al.o.a(f38244a, this, i2Var, i2Var.x());
    }

    @Override // kotlinx.coroutines.c2
    public final boolean n() {
        return !(K0() instanceof w1);
    }

    @yt.k
    public String n0() {
        return "Job was cancelled";
    }

    public final void n1(kotlinx.coroutines.selects.j<?> jVar, Object obj) {
        if (R0()) {
            jVar.d(L1(new e(jVar)));
        } else {
            jVar.r(kotlin.z1.f38230a);
        }
    }

    public boolean o0(@yt.k Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        return i0(th2) && B0();
    }

    public final void o1(@yt.k i2 i2Var) {
        Object objK0;
        do {
            objK0 = K0();
            if (!(objK0 instanceof i2)) {
                if (!(objK0 instanceof w1) || ((w1) objK0).b() == null) {
                    return;
                }
                i2Var.J();
                return;
            }
            if (objK0 != i2Var) {
                return;
            }
        } while (!al.o.a(f38244a, this, objK0, j2.f38885j));
    }

    public final void p0(w1 w1Var, Object obj) throws Throwable {
        u uVarJ0 = J0();
        if (uVarJ0 != null) {
            uVarJ0.dispose();
            q1(p2.f38929a);
        }
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        Throwable th2 = c0Var != null ? c0Var.f38294a : null;
        if (!(w1Var instanceof i2)) {
            n2 n2VarB = w1Var.b();
            if (n2VarB != null) {
                c1(n2VarB, th2);
                return;
            }
            return;
        }
        try {
            ((i2) w1Var).R(th2);
        } catch (Throwable th3) {
            M0(new CompletionHandlerException("Exception in completion handler " + w1Var + " for " + this, th3));
        }
    }

    public final void q0(c cVar, v vVar, Object obj) {
        v vVarA1 = a1(vVar);
        if (vVarA1 == null || !D1(cVar, vVarA1, obj)) {
            e0(u0(cVar, obj));
        }
    }

    public final void q1(@yt.l u uVar) {
        f38245b.set(this, uVar);
    }

    public final Throwable r0(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th2 = (Throwable) obj;
            return th2 == null ? new JobCancellationException(n0(), null, this) : th2;
        }
        kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((s2) obj).C1();
    }

    public final int r1(Object obj) {
        if (obj instanceof j1) {
            if (((j1) obj).isActive()) {
                return 0;
            }
            if (!al.o.a(f38244a, this, obj, j2.f38885j)) {
                return -1;
            }
            k1();
            return 1;
        }
        if (!(obj instanceof v1)) {
            return 0;
        }
        if (!al.o.a(f38244a, this, obj, ((v1) obj).b())) {
            return -1;
        }
        k1();
        return 1;
    }

    @yt.k
    public final JobCancellationException s0(@yt.l String str, @yt.l Throwable th2) {
        if (str == null) {
            str = n0();
        }
        return new JobCancellationException(str, th2, this);
    }

    @Override // kotlinx.coroutines.c2
    @yt.k
    public final kotlinx.coroutines.selects.c s1() {
        JobSupport$onJoin$1 jobSupport$onJoin$1 = JobSupport$onJoin$1.f38263c;
        kotlin.jvm.internal.f0.n(jobSupport$onJoin$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.d(this, (ik.q) kotlin.jvm.internal.w0.q(jobSupport$onJoin$1, 3), null, 4, null);
    }

    @Override // kotlinx.coroutines.c2
    public final boolean start() {
        int iR1;
        do {
            iR1 = r1(K0());
            if (iR1 == 0) {
                return false;
            }
        } while (iR1 != 1);
        return true;
    }

    public final String t1(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof w1 ? ((w1) obj).isActive() ? "Active" : "New" : obj instanceof c0 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.f() ? "Cancelling" : cVar.g() ? "Completing" : "Active";
    }

    @yt.k
    public String toString() {
        return x1() + '@' + r0.b(this);
    }

    public final Object u0(c cVar, Object obj) throws Throwable {
        boolean zF;
        Throwable thA0;
        kotlin.jvm.internal.u uVar = null;
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        Throwable th2 = c0Var != null ? c0Var.f38294a : null;
        synchronized (cVar) {
            zF = cVar.f();
            List<Throwable> listI = cVar.i(th2);
            thA0 = A0(cVar, listI);
            if (thA0 != null) {
                d0(thA0, listI);
            }
        }
        if (thA0 != null && thA0 != th2) {
            obj = new c0(thA0, z, 2, uVar);
        }
        if (thA0 != null) {
            if (m0(thA0) || L0(thA0)) {
                kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((c0) obj).b();
            }
        }
        if (!zF) {
            h1(thA0);
        }
        j1(obj);
        al.o.a(f38244a, this, cVar, j2.g(obj));
        p0(cVar, obj);
        return obj;
    }

    public final v v0(w1 w1Var) {
        v vVar = w1Var instanceof v ? (v) w1Var : null;
        if (vVar != null) {
            return vVar;
        }
        n2 n2VarB = w1Var.b();
        if (n2VarB != null) {
            return a1(n2VarB);
        }
        return null;
    }

    @yt.k
    public final CancellationException v1(@yt.k Throwable th2, @yt.l String str) {
        CancellationException jobCancellationException = th2 instanceof CancellationException ? (CancellationException) th2 : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = n0();
            }
            jobCancellationException = new JobCancellationException(str, th2, this);
        }
        return jobCancellationException;
    }

    @yt.l
    public final Object w0() throws Throwable {
        Object objK0 = K0();
        if (!(!(objK0 instanceof w1))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (objK0 instanceof c0) {
            throw ((c0) objK0).f38294a;
        }
        return j2.h(objK0);
    }

    @yt.l
    public final Throwable x0() {
        Object objK0 = K0();
        if (objK0 instanceof c) {
            Throwable thE = ((c) objK0).e();
            if (thE != null) {
                return thE;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(objK0 instanceof w1)) {
            if (objK0 instanceof c0) {
                return ((c0) objK0).f38294a;
            }
            return null;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @y1
    @yt.k
    public final String x1() {
        return Z0() + '{' + t1(K0()) + '}';
    }

    public final boolean y0() {
        Object objK0 = K0();
        return (objK0 instanceof c0) && ((c0) objK0).a();
    }

    public final boolean y1(w1 w1Var, Object obj) throws Throwable {
        if (!al.o.a(f38244a, this, w1Var, j2.g(obj))) {
            return false;
        }
        h1(null);
        j1(obj);
        p0(w1Var, obj);
        return true;
    }

    public final Throwable z0(Object obj) {
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var != null) {
            return c0Var.f38294a;
        }
        return null;
    }

    public final boolean z1(w1 w1Var, Throwable th2) throws Throwable {
        n2 n2VarI0 = I0(w1Var);
        if (n2VarI0 == null) {
            return false;
        }
        if (!al.o.a(f38244a, this, w1Var, new c(n2VarI0, false, th2))) {
            return false;
        }
        b1(n2VarI0, th2);
        return true;
    }
}
