package al;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o {
    public static /* synthetic */ boolean a(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Object obj2, Object obj3) {
        while (!atomicReferenceFieldUpdater.compareAndSet(obj, obj2, obj3)) {
            if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                return false;
            }
        }
        return true;
    }
}
