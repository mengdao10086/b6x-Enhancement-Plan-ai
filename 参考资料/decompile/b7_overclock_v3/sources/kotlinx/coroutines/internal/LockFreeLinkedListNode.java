package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.z1;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,367:1\n73#1,3:369\n1#2:368\n*S KotlinDebug\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n*L\n134#1:369,3\n*E\n"})
@y1
public class LockFreeLinkedListNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38762a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38763b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38764c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");

    @yt.l
    @hk.v
    private volatile Object _next = this;

    @yt.l
    @hk.v
    private volatile Object _prev = this;

    @yt.l
    @hk.v
    private volatile Object _removedRef;

    @kotlin.s0
    public static abstract class a extends kotlinx.coroutines.internal.b<LockFreeLinkedListNode> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @hk.e
        @yt.k
        public final LockFreeLinkedListNode f38765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @hk.e
        @yt.l
        public LockFreeLinkedListNode f38766c;

        public a(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f38765b = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode, @yt.l Object obj) {
            boolean z10 = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z10 ? this.f38765b : this.f38766c;
            if (lockFreeLinkedListNode2 != null && al.o.a(LockFreeLinkedListNode.f38762a, lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z10) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.f38765b;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.f38766c;
                kotlin.jvm.internal.f0.m(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.s(lockFreeLinkedListNode4);
            }
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1\n*L\n1#1,367:1\n*E\n"})
    public static final class b extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ik.a<Boolean> f38767d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LockFreeLinkedListNode lockFreeLinkedListNode, ik.a<Boolean> aVar) {
            super(lockFreeLinkedListNode);
            this.f38767d = aVar;
        }

        @Override // kotlinx.coroutines.internal.b
        @yt.l
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object e(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f38767d.o().booleanValue()) {
                return null;
            }
            return v.a();
        }
    }

    private final void D(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public boolean B() {
        return w() instanceof i0;
    }

    @kotlin.s0
    @yt.k
    public final a F(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode, @yt.k ik.a<Boolean> aVar) {
        return new b(lockFreeLinkedListNode, aVar);
    }

    @yt.l
    public LockFreeLinkedListNode I() {
        Object objW = w();
        i0 i0Var = objW instanceof i0 ? (i0) objW : null;
        if (i0Var != null) {
            return i0Var.f38802a;
        }
        return null;
    }

    public boolean J() {
        return K() == null;
    }

    @yt.l
    @kotlin.s0
    public final LockFreeLinkedListNode K() {
        Object objW;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            objW = w();
            if (objW instanceof i0) {
                return ((i0) objW).f38802a;
            }
            if (objW == this) {
                return (LockFreeLinkedListNode) objW;
            }
            kotlin.jvm.internal.f0.n(objW, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) objW;
        } while (!al.o.a(f38762a, this, objW, lockFreeLinkedListNode.M()));
        lockFreeLinkedListNode.p(null);
        return null;
    }

    public final i0 M() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38764c;
        i0 i0Var = (i0) atomicReferenceFieldUpdater.get(this);
        if (i0Var != null) {
            return i0Var;
        }
        i0 i0Var2 = new i0(this);
        atomicReferenceFieldUpdater.lazySet(this, i0Var2);
        return i0Var2;
    }

    @kotlin.s0
    public final int O(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode, @yt.k LockFreeLinkedListNode lockFreeLinkedListNode2, @yt.k a aVar) {
        f38763b.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38762a;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        aVar.f38766c = lockFreeLinkedListNode2;
        if (al.o.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, aVar)) {
            return aVar.b(this) == null ? 1 : 2;
        }
        return 0;
    }

    public final void Q(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode, @yt.k LockFreeLinkedListNode lockFreeLinkedListNode2) {
    }

    public final void g(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (!z().k(lockFreeLinkedListNode, this)) {
        }
    }

    public final boolean j(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode, @yt.k ik.a<Boolean> aVar) {
        int iO;
        b bVar = new b(lockFreeLinkedListNode, aVar);
        do {
            iO = z().O(lockFreeLinkedListNode, this, bVar);
            if (iO == 1) {
                return true;
            }
        } while (iO != 2);
        return false;
    }

    @kotlin.s0
    public final boolean k(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode, @yt.k LockFreeLinkedListNode lockFreeLinkedListNode2) {
        f38763b.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38762a;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!al.o.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.s(lockFreeLinkedListNode2);
        return true;
    }

    public final boolean n(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode) {
        f38763b.lazySet(lockFreeLinkedListNode, this);
        f38762a.lazySet(lockFreeLinkedListNode, this);
        while (w() == this) {
            if (al.o.a(f38762a, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.s(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (al.o.a(r4, r3, r2, ((kotlinx.coroutines.internal.i0) r5).f38802a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode p(kotlinx.coroutines.internal.g0 r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f38763b
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f38762a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L20
            if (r0 != r2) goto L16
            return r2
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f38763b
            boolean r0 = al.o.a(r1, r8, r0, r2)
            if (r0 != 0) goto L1f
            goto L0
        L1f:
            return r2
        L20:
            boolean r6 = r8.B()
            if (r6 == 0) goto L27
            return r1
        L27:
            if (r5 != r9) goto L2a
            return r2
        L2a:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.g0
            if (r6 == 0) goto L34
            kotlinx.coroutines.internal.g0 r5 = (kotlinx.coroutines.internal.g0) r5
            r5.b(r2)
            goto L0
        L34:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.i0
            if (r6 == 0) goto L50
            if (r3 == 0) goto L47
            kotlinx.coroutines.internal.i0 r5 = (kotlinx.coroutines.internal.i0) r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = r5.f38802a
            boolean r2 = al.o.a(r4, r3, r2, r5)
            if (r2 != 0) goto L45
            goto L0
        L45:
            r2 = r3
            goto La
        L47:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f38763b
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto Lb
        L50:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.f0.n(r5, r3)
            r3 = r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.p(kotlinx.coroutines.internal.g0):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public final LockFreeLinkedListNode r(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.B()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) f38763b.get(lockFreeLinkedListNode);
        }
        return lockFreeLinkedListNode;
    }

    public final void s(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38763b;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (w() != lockFreeLinkedListNode) {
                return;
            }
        } while (!al.o.a(f38763b, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (B()) {
            lockFreeLinkedListNode.p(null);
        }
    }

    @yt.k
    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode.toString.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.o
            @yt.l
            public Object get() {
                return kotlinx.coroutines.r0.a(this.receiver);
            }
        } + '@' + kotlinx.coroutines.r0.b(this);
    }

    @yt.k
    public final Object w() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38762a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof g0)) {
                return obj;
            }
            ((g0) obj).b(this);
        }
    }

    @yt.k
    public final LockFreeLinkedListNode x() {
        return v.f(w());
    }

    @yt.k
    public final LockFreeLinkedListNode z() {
        LockFreeLinkedListNode lockFreeLinkedListNodeP = p(null);
        return lockFreeLinkedListNodeP == null ? r((LockFreeLinkedListNode) f38763b.get(this)) : lockFreeLinkedListNodeP;
    }
}
