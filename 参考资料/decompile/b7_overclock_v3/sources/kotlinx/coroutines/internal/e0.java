package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nOnDemandAllocatingPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPoolKt\n*L\n1#1,107:1\n41#1:108\n41#1:109\n35#1,7:110\n41#1:127\n1549#2:117\n1620#2,2:118\n1622#2:122\n1549#2:123\n1620#2,3:124\n101#3,2:120\n*S KotlinDebug\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n*L\n35#1:108\n54#1:109\n76#1:110,7\n92#1:127\n77#1:117\n77#1:118,2\n77#1:122\n91#1:123\n91#1:124,3\n79#1:120,2\n*E\n"})
public final class e0<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38793d = AtomicIntegerFieldUpdater.newUpdater(e0.class, "controlState");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<Integer, T> f38795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final AtomicReferenceArray f38796c;

    @hk.v
    private volatile int controlState;

    /* JADX WARN: Multi-variable type inference failed */
    public e0(int i10, @yt.k ik.l<? super Integer, ? extends T> lVar) {
        this.f38794a = i10;
        this.f38795b = lVar;
        this.f38796c = new AtomicReferenceArray(i10);
    }

    public final boolean a() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38793d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((Integer.MIN_VALUE & i10) != 0) {
                return false;
            }
            if (i10 >= this.f38794a) {
                return true;
            }
        } while (!f38793d.compareAndSet(this, i10, i10 + 1));
        this.f38796c.set(i10, this.f38795b.i(Integer.valueOf(i10)));
        return true;
    }

    @yt.k
    public final List<T> b() {
        int i10;
        Object andSet;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38793d;
        while (true) {
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & Integer.MIN_VALUE) != 0) {
                i10 = 0;
                break;
            }
            if (f38793d.compareAndSet(this, i10, Integer.MIN_VALUE | i10)) {
                break;
            }
        }
        qk.m mVarW1 = qk.v.W1(0, i10);
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(mVarW1, 10));
        Iterator<Integer> it2 = mVarW1.iterator();
        while (it2.hasNext()) {
            int iB = ((kotlin.collections.k0) it2).b();
            do {
                andSet = this.f38796c.getAndSet(iB, null);
            } while (andSet == null);
            arrayList.add(andSet);
        }
        return arrayList;
    }

    public final boolean c(int i10) {
        return (i10 & Integer.MIN_VALUE) != 0;
    }

    public final void d(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, ik.l<? super Integer, z1> lVar, Object obj) {
        while (true) {
            lVar.i(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    @yt.k
    public final String e() {
        int i10 = f38793d.get(this);
        qk.m mVarW1 = qk.v.W1(0, Integer.MAX_VALUE & i10);
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(mVarW1, 10));
        Iterator<Integer> it2 = mVarW1.iterator();
        while (it2.hasNext()) {
            arrayList.add(this.f38796c.get(((kotlin.collections.k0) it2).b()));
        }
        return arrayList.toString() + ((i10 & Integer.MIN_VALUE) != 0 ? "[closed]" : "");
    }

    public final int f() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38793d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & Integer.MIN_VALUE) != 0) {
                return 0;
            }
        } while (!f38793d.compareAndSet(this, i10, Integer.MIN_VALUE | i10));
        return i10;
    }

    @yt.k
    public String toString() {
        return "OnDemandAllocatingPool(" + e() + ')';
    }
}
