package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.flow.u;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n28#2,4:144\n20#3:137\n20#3:142\n20#3:148\n1#4:143\n13579#5,2:149\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n*L\n30#1:133,4\n45#1:138,4\n76#1:144,4\n30#1:137\n45#1:142\n76#1:148\n95#1:149,2\n*E\n"})
public abstract class a<S extends c<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public S[] f38709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f38710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f38711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public o f38712d;

    @yt.k
    public final u<Integer> I() {
        o oVar;
        synchronized (this) {
            oVar = this.f38712d;
            if (oVar == null) {
                oVar = new o(this.f38710b);
                this.f38712d = oVar;
            }
        }
        return oVar;
    }

    @yt.k
    public final S g() {
        S s10;
        o oVar;
        synchronized (this) {
            S[] sArr = this.f38709a;
            if (sArr == null) {
                sArr = (S[]) i(2);
                this.f38709a = sArr;
            } else if (this.f38710b >= sArr.length) {
                Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                f0.o(objArrCopyOf, "copyOf(this, newSize)");
                this.f38709a = (S[]) ((c[]) objArrCopyOf);
                sArr = (S[]) ((c[]) objArrCopyOf);
            }
            int i10 = this.f38711c;
            do {
                s10 = sArr[i10];
                if (s10 == null) {
                    s10 = (S) h();
                    sArr[i10] = s10;
                }
                i10++;
                if (i10 >= sArr.length) {
                    i10 = 0;
                }
                f0.n(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } while (!s10.a(this));
            this.f38711c = i10;
            this.f38710b++;
            oVar = this.f38712d;
        }
        if (oVar != null) {
            oVar.f0(1);
        }
        return s10;
    }

    @yt.k
    public abstract S h();

    @yt.k
    public abstract S[] i(int i10);

    public final void j(@yt.k ik.l<? super S, z1> lVar) {
        c[] cVarArr;
        if (this.f38710b == 0 || (cVarArr = this.f38709a) == null) {
            return;
        }
        for (c cVar : cVarArr) {
            if (cVar != null) {
                lVar.i(cVar);
            }
        }
    }

    public final void l(@yt.k S s10) {
        o oVar;
        int i10;
        kotlin.coroutines.c<z1>[] cVarArrB;
        synchronized (this) {
            int i11 = this.f38710b - 1;
            this.f38710b = i11;
            oVar = this.f38712d;
            if (i11 == 0) {
                this.f38711c = 0;
            }
            f0.n(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            cVarArrB = s10.b(this);
        }
        for (kotlin.coroutines.c<z1> cVar : cVarArrB) {
            if (cVar != null) {
                Result.a aVar = Result.f37633a;
                cVar.x(Result.b(z1.f38230a));
            }
        }
        if (oVar != null) {
            oVar.f0(-1);
        }
    }

    public final int m() {
        return this.f38710b;
    }

    @yt.l
    public final S[] n() {
        return this.f38709a;
    }
}
