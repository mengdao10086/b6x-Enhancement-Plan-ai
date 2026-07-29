package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.internal.o0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,731:1\n28#2,4:732\n28#2,4:738\n28#2,4:760\n28#2,4:767\n28#2,4:779\n28#2,4:793\n28#2,4:807\n20#3:736\n20#3:742\n20#3:764\n20#3:771\n20#3:783\n20#3:797\n20#3:811\n329#4:737\n1#5:743\n94#6,2:744\n96#6,2:747\n98#6:750\n94#6,2:772\n96#6,2:775\n98#6:778\n94#6,2:800\n96#6,2:803\n98#6:806\n13579#7:746\n13580#7:749\n13579#7:774\n13580#7:777\n13579#7:802\n13580#7:805\n314#8,9:751\n323#8,2:765\n314#8,9:784\n323#8,2:798\n*S KotlinDebug\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n*L\n351#1:732,4\n391#1:738,4\n485#1:760,4\n506#1:767,4\n626#1:779,4\n661#1:793,4\n689#1:807,4\n351#1:736\n391#1:742\n485#1:764\n506#1:771\n626#1:783\n661#1:797\n689#1:811\n373#1:737\n453#1:744,2\n453#1:747,2\n453#1:750\n529#1:772,2\n529#1:775,2\n529#1:778\n676#1:800,2\n676#1:803,2\n676#1:806\n453#1:746\n453#1:749\n529#1:774\n529#1:777\n676#1:802\n676#1:805\n483#1:751,9\n483#1:765,2\n660#1:784,9\n660#1:798,2\n*E\n"})
public class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<p> implements i<T>, kotlinx.coroutines.flow.a<T>, kotlinx.coroutines.flow.internal.i<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f38644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f38645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final BufferOverflow f38646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.l
    public Object[] f38647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f38648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f38649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f38650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f38651l;

    public static final class a implements g1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @hk.e
        @yt.k
        public final SharedFlowImpl<?> f38652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @hk.e
        public long f38653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @hk.e
        @yt.l
        public final Object f38654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @hk.e
        @yt.k
        public final kotlin.coroutines.c<z1> f38655d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@yt.k SharedFlowImpl<?> sharedFlowImpl, long j10, @yt.l Object obj, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            this.f38652a = sharedFlowImpl;
            this.f38653b = j10;
            this.f38654c = obj;
            this.f38655d = cVar;
        }

        @Override // kotlinx.coroutines.g1
        public void dispose() {
            this.f38652a.C(this);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38656a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f38656a = iArr;
        }
    }

    public SharedFlowImpl(int i10, int i11, @yt.k BufferOverflow bufferOverflow) {
        this.f38644e = i10;
        this.f38645f = i11;
        this.f38646g = bufferOverflow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <T> java.lang.Object E(kotlinx.coroutines.flow.SharedFlowImpl<T> r8, kotlinx.coroutines.flow.f<? super T> r9, kotlin.coroutines.c<?> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.E(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.f, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ <T> Object K(SharedFlowImpl<T> sharedFlowImpl, T t10, kotlin.coroutines.c<? super z1> cVar) {
        Object objL;
        return (!sharedFlowImpl.z(t10) && (objL = sharedFlowImpl.L(t10, cVar)) == yj.b.h()) ? objL : z1.f38230a;
    }

    public static /* synthetic */ void R() {
    }

    public final Object B(p pVar, kotlin.coroutines.c<? super z1> cVar) {
        z1 z1Var;
        kotlinx.coroutines.p pVar2 = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar2.Q();
        synchronized (this) {
            if (Z(pVar) < 0) {
                pVar.f38732b = pVar2;
            } else {
                Result.a aVar = Result.f37633a;
                pVar2.x(Result.b(z1.f38230a));
            }
            z1Var = z1.f38230a;
        }
        Object objC = pVar2.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC == yj.b.h() ? objC : z1Var;
    }

    public final void C(a aVar) {
        synchronized (this) {
            if (aVar.f38653b < P()) {
                return;
            }
            Object[] objArr = this.f38647h;
            f0.m(objArr);
            if (o.f(objArr, aVar.f38653b) != aVar) {
                return;
            }
            o.g(objArr, aVar.f38653b, o.f38730a);
            D();
            z1 z1Var = z1.f38230a;
        }
    }

    public final void D() {
        if (this.f38645f != 0 || this.f38651l > 1) {
            Object[] objArr = this.f38647h;
            f0.m(objArr);
            while (this.f38651l > 0 && o.f(objArr, (P() + ((long) V())) - 1) == o.f38730a) {
                this.f38651l--;
                o.g(objArr, P() + ((long) V()), null);
            }
        }
    }

    public final void F(long j10) {
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        if (this.f38710b != 0 && (cVarArr = this.f38709a) != null) {
            for (kotlinx.coroutines.flow.internal.c cVar : cVarArr) {
                if (cVar != null) {
                    p pVar = (p) cVar;
                    long j11 = pVar.f38731a;
                    if (j11 >= 0 && j11 < j10) {
                        pVar.f38731a = j10;
                    }
                }
            }
        }
        this.f38649j = j10;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    @yt.k
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public p h() {
        return new p();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    @yt.k
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public p[] i(int i10) {
        return new p[i10];
    }

    public final void J() {
        Object[] objArr = this.f38647h;
        f0.m(objArr);
        o.g(objArr, P(), null);
        this.f38650k--;
        long jP = P() + 1;
        if (this.f38648i < jP) {
            this.f38648i = jP;
        }
        if (this.f38649j < jP) {
            F(jP);
        }
    }

    public final Object L(T t10, kotlin.coroutines.c<? super z1> cVar) {
        kotlin.coroutines.c<z1>[] cVarArrN;
        a aVar;
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        kotlin.coroutines.c<z1>[] cVarArrN2 = kotlinx.coroutines.flow.internal.b.f38713a;
        synchronized (this) {
            if (X(t10)) {
                Result.a aVar2 = Result.f37633a;
                pVar.x(Result.b(z1.f38230a));
                cVarArrN = N(cVarArrN2);
                aVar = null;
            } else {
                a aVar3 = new a(this, ((long) V()) + P(), t10, pVar);
                M(aVar3);
                this.f38651l++;
                if (this.f38645f == 0) {
                    cVarArrN2 = N(cVarArrN2);
                }
                cVarArrN = cVarArrN2;
                aVar = aVar3;
            }
        }
        if (aVar != null) {
            kotlinx.coroutines.r.a(pVar, aVar);
        }
        for (kotlin.coroutines.c<z1> cVar2 : cVarArrN) {
            if (cVar2 != null) {
                Result.a aVar4 = Result.f37633a;
                cVar2.x(Result.b(z1.f38230a));
            }
        }
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC == yj.b.h() ? objC : z1.f38230a;
    }

    public final void M(Object obj) {
        int iV = V();
        Object[] objArrW = this.f38647h;
        if (objArrW == null) {
            objArrW = W(null, 0, 2);
        } else if (iV >= objArrW.length) {
            objArrW = W(objArrW, iV, objArrW.length * 2);
        }
        o.g(objArrW, P() + ((long) iV), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [kotlin.coroutines.c<kotlin.z1>[]] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r6v2 */
    public final kotlin.coroutines.c<z1>[] N(kotlin.coroutines.c<z1>[] cVarArr) {
        kotlinx.coroutines.flow.internal.c[] cVarArr2;
        p pVar;
        kotlin.coroutines.c<? super z1> cVar;
        int length = cVarArr.length;
        if (this.f38710b != 0 && (cVarArr2 = this.f38709a) != null) {
            int i10 = 0;
            int length2 = cVarArr2.length;
            cVarArr = cVarArr;
            while (i10 < length2) {
                kotlinx.coroutines.flow.internal.c cVar2 = cVarArr2[i10];
                if (cVar2 != null && (cVar = (pVar = (p) cVar2).f38732b) != null && Z(pVar) >= 0) {
                    int length3 = cVarArr.length;
                    cVarArr = cVarArr;
                    if (length >= length3) {
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) cVarArr, Math.max(2, cVarArr.length * 2));
                        f0.o(objArrCopyOf, "copyOf(this, newSize)");
                        cVarArr = objArrCopyOf;
                    }
                    ((kotlin.coroutines.c[]) cVarArr)[length] = cVar;
                    pVar.f38732b = null;
                    length++;
                }
                i10++;
                cVarArr = cVarArr;
            }
        }
        return (kotlin.coroutines.c[]) cVarArr;
    }

    public final long O() {
        return P() + ((long) this.f38650k);
    }

    public final long P() {
        return Math.min(this.f38649j, this.f38648i);
    }

    public final T Q() {
        Object[] objArr = this.f38647h;
        f0.m(objArr);
        return (T) o.f(objArr, (this.f38648i + ((long) U())) - 1);
    }

    public final Object S(long j10) {
        Object[] objArr = this.f38647h;
        f0.m(objArr);
        Object objF = o.f(objArr, j10);
        return objF instanceof a ? ((a) objF).f38654c : objF;
    }

    public final long T() {
        return P() + ((long) this.f38650k) + ((long) this.f38651l);
    }

    public final int U() {
        return (int) ((P() + ((long) this.f38650k)) - this.f38648i);
    }

    public final int V() {
        return this.f38650k + this.f38651l;
    }

    public final Object[] W(Object[] objArr, int i10, int i11) {
        if (!(i11 > 0)) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr2 = new Object[i11];
        this.f38647h = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long jP = P();
        for (int i12 = 0; i12 < i10; i12++) {
            long j10 = ((long) i12) + jP;
            o.g(objArr2, j10, o.f(objArr, j10));
        }
        return objArr2;
    }

    public final boolean X(T t10) {
        if (m() == 0) {
            return Y(t10);
        }
        if (this.f38650k >= this.f38645f && this.f38649j <= this.f38648i) {
            int i10 = b.f38656a[this.f38646g.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 == 2) {
                return true;
            }
        }
        M(t10);
        int i11 = this.f38650k + 1;
        this.f38650k = i11;
        if (i11 > this.f38645f) {
            J();
        }
        if (U() > this.f38644e) {
            b0(this.f38648i + 1, this.f38649j, O(), T());
        }
        return true;
    }

    public final boolean Y(T t10) {
        if (this.f38644e == 0) {
            return true;
        }
        M(t10);
        int i10 = this.f38650k + 1;
        this.f38650k = i10;
        if (i10 > this.f38644e) {
            J();
        }
        this.f38649j = P() + ((long) this.f38650k);
        return true;
    }

    public final long Z(p pVar) {
        long j10 = pVar.f38731a;
        if (j10 < O()) {
            return j10;
        }
        if (this.f38645f <= 0 && j10 <= P() && this.f38651l != 0) {
            return j10;
        }
        return -1L;
    }

    @Override // kotlinx.coroutines.flow.n, kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<?> cVar) {
        return E(this, fVar, cVar);
    }

    public final Object a0(p pVar) {
        Object obj;
        kotlin.coroutines.c<z1>[] cVarArrC0 = kotlinx.coroutines.flow.internal.b.f38713a;
        synchronized (this) {
            long jZ = Z(pVar);
            if (jZ < 0) {
                obj = o.f38730a;
            } else {
                long j10 = pVar.f38731a;
                Object objS = S(jZ);
                pVar.f38731a = jZ + 1;
                cVarArrC0 = c0(j10);
                obj = objS;
            }
        }
        for (kotlin.coroutines.c<z1> cVar : cVarArrC0) {
            if (cVar != null) {
                Result.a aVar = Result.f37633a;
                cVar.x(Result.b(z1.f38230a));
            }
        }
        return obj;
    }

    @Override // kotlinx.coroutines.flow.n
    @yt.k
    public List<T> b() {
        synchronized (this) {
            int iU = U();
            if (iU == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            ArrayList arrayList = new ArrayList(iU);
            Object[] objArr = this.f38647h;
            f0.m(objArr);
            for (int i10 = 0; i10 < iU; i10++) {
                arrayList.add(o.f(objArr, this.f38648i + ((long) i10)));
            }
            return arrayList;
        }
    }

    public final void b0(long j10, long j11, long j12, long j13) {
        long jMin = Math.min(j11, j10);
        for (long jP = P(); jP < jMin; jP++) {
            Object[] objArr = this.f38647h;
            f0.m(objArr);
            o.g(objArr, jP, null);
        }
        this.f38648i = j10;
        this.f38649j = j11;
        this.f38650k = (int) (j12 - jMin);
        this.f38651l = (int) (j13 - j12);
    }

    @Override // kotlinx.coroutines.flow.internal.i
    @yt.k
    public e<T> c(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return o.e(this, coroutineContext, i10, bufferOverflow);
    }

    @yt.k
    public final kotlin.coroutines.c<z1>[] c0(long j10) {
        long j11;
        long j12;
        long j13;
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        if (j10 > this.f38649j) {
            return kotlinx.coroutines.flow.internal.b.f38713a;
        }
        long jP = P();
        long j14 = ((long) this.f38650k) + jP;
        if (this.f38645f == 0 && this.f38651l > 0) {
            j14++;
        }
        if (this.f38710b != 0 && (cVarArr = this.f38709a) != null) {
            for (kotlinx.coroutines.flow.internal.c cVar : cVarArr) {
                if (cVar != null) {
                    long j15 = ((p) cVar).f38731a;
                    if (j15 >= 0 && j15 < j14) {
                        j14 = j15;
                    }
                }
            }
        }
        if (j14 <= this.f38649j) {
            return kotlinx.coroutines.flow.internal.b.f38713a;
        }
        long jO = O();
        int iMin = m() > 0 ? Math.min(this.f38651l, this.f38645f - ((int) (jO - j14))) : this.f38651l;
        kotlin.coroutines.c<z1>[] cVarArr2 = kotlinx.coroutines.flow.internal.b.f38713a;
        long j16 = ((long) this.f38651l) + jO;
        if (iMin > 0) {
            cVarArr2 = new kotlin.coroutines.c[iMin];
            Object[] objArr = this.f38647h;
            f0.m(objArr);
            long j17 = jO;
            int i10 = 0;
            while (true) {
                if (jO >= j16) {
                    j11 = j14;
                    j12 = j16;
                    break;
                }
                Object objF = o.f(objArr, jO);
                j11 = j14;
                o0 o0Var = o.f38730a;
                if (objF != o0Var) {
                    f0.n(objF, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) objF;
                    int i11 = i10 + 1;
                    j12 = j16;
                    cVarArr2[i10] = aVar.f38655d;
                    o.g(objArr, jO, o0Var);
                    o.g(objArr, j17, aVar.f38654c);
                    j13 = 1;
                    j17++;
                    if (i11 >= iMin) {
                        break;
                    }
                    i10 = i11;
                } else {
                    j12 = j16;
                    j13 = 1;
                }
                jO += j13;
                j14 = j11;
                j16 = j12;
            }
            jO = j17;
        } else {
            j11 = j14;
            j12 = j16;
        }
        int i12 = (int) (jO - jP);
        long j18 = m() == 0 ? jO : j11;
        long jMax = Math.max(this.f38648i, jO - ((long) Math.min(this.f38644e, i12)));
        if (this.f38645f == 0 && jMax < j12) {
            Object[] objArr2 = this.f38647h;
            f0.m(objArr2);
            if (f0.g(o.f(objArr2, jMax), o.f38730a)) {
                jO++;
                jMax++;
            }
        }
        b0(jMax, j18, jO, j12);
        D();
        return (cVarArr2.length == 0) ^ true ? N(cVarArr2) : cVarArr2;
    }

    public final long d0() {
        long j10 = this.f38648i;
        if (j10 < this.f38649j) {
            this.f38649j = j10;
        }
        return j10;
    }

    @Override // kotlinx.coroutines.flow.i, kotlinx.coroutines.flow.f
    @yt.l
    public Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return K(this, t10, cVar);
    }

    @Override // kotlinx.coroutines.flow.i
    public void k() {
        synchronized (this) {
            b0(O(), this.f38649j, O(), T());
            z1 z1Var = z1.f38230a;
        }
    }

    @Override // kotlinx.coroutines.flow.i
    public boolean z(T t10) {
        int i10;
        boolean z10;
        kotlin.coroutines.c<z1>[] cVarArrN = kotlinx.coroutines.flow.internal.b.f38713a;
        synchronized (this) {
            if (X(t10)) {
                cVarArrN = N(cVarArrN);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (kotlin.coroutines.c<z1> cVar : cVarArrN) {
            if (cVar != null) {
                Result.a aVar = Result.f37633a;
                cVar.x(Result.b(z1.f38230a));
            }
        }
        return z10;
    }
}
