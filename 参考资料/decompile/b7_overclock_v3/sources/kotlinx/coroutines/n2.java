package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1451:1\n341#2,6:1452\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n*L\n1363#1:1452,6\n*E\n"})
public final class n2 extends kotlinx.coroutines.internal.u implements w1 {
    @yt.k
    public final String W(@yt.k String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("List{");
        sb2.append(str);
        sb2.append("}[");
        Object objW = w();
        kotlin.jvm.internal.f0.n(objW, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        boolean z10 = true;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeX = (LockFreeLinkedListNode) objW; !kotlin.jvm.internal.f0.g(lockFreeLinkedListNodeX, this); lockFreeLinkedListNodeX = lockFreeLinkedListNodeX.x()) {
            if (lockFreeLinkedListNodeX instanceof i2) {
                i2 i2Var = (i2) lockFreeLinkedListNodeX;
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(", ");
                }
                sb2.append(i2Var);
            }
        }
        sb2.append("]");
        String string = sb2.toString();
        kotlin.jvm.internal.f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // kotlinx.coroutines.w1
    @yt.k
    public n2 b() {
        return this;
    }

    @Override // kotlinx.coroutines.w1
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @yt.k
    public String toString() {
        return super.toString();
    }
}
