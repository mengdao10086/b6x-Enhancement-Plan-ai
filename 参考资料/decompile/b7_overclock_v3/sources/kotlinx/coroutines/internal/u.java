package kotlinx.coroutines.internal;

import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public class u extends LockFreeLinkedListNode {
    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean B() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @yt.l
    public LockFreeLinkedListNode I() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public /* bridge */ /* synthetic */ boolean J() {
        return ((Boolean) T()).booleanValue();
    }

    public final /* synthetic */ <T extends LockFreeLinkedListNode> void R(ik.l<? super T, z1> lVar) {
        Object objW = w();
        kotlin.jvm.internal.f0.n(objW, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        for (LockFreeLinkedListNode lockFreeLinkedListNodeX = (LockFreeLinkedListNode) objW; !kotlin.jvm.internal.f0.g(lockFreeLinkedListNodeX, this); lockFreeLinkedListNodeX = lockFreeLinkedListNodeX.x()) {
            kotlin.jvm.internal.f0.y(3, i1.a.f31577d5);
            if (lockFreeLinkedListNodeX instanceof LockFreeLinkedListNode) {
                lVar.i(lockFreeLinkedListNodeX);
            }
        }
    }

    public final boolean S() {
        return w() == this;
    }

    @yt.k
    public final Void T() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    public final void V() {
        Object objW = w();
        kotlin.jvm.internal.f0.n(objW, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) objW;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = this;
        while (!kotlin.jvm.internal.f0.g(lockFreeLinkedListNode, this)) {
            LockFreeLinkedListNode lockFreeLinkedListNodeX = lockFreeLinkedListNode.x();
            lockFreeLinkedListNode.Q(lockFreeLinkedListNode2, lockFreeLinkedListNodeX);
            lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            lockFreeLinkedListNode = lockFreeLinkedListNodeX;
        }
        Object objW2 = w();
        kotlin.jvm.internal.f0.n(objW2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        Q(lockFreeLinkedListNode2, (LockFreeLinkedListNode) objW2);
    }
}
