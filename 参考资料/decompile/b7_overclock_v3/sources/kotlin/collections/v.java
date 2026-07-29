package kotlin.collections;

import java.util.Iterator;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public class v extends u {
    public static final <T> void d0(@yt.k Iterator<? extends T> it2, @yt.k ik.l<? super T, z1> operation) {
        kotlin.jvm.internal.f0.p(it2, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        while (it2.hasNext()) {
            operation.i(it2.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    public static final <T> Iterator<T> e0(Iterator<? extends T> it2) {
        kotlin.jvm.internal.f0.p(it2, "<this>");
        return it2;
    }

    @yt.k
    public static final <T> Iterator<h0<T>> f0(@yt.k Iterator<? extends T> it2) {
        kotlin.jvm.internal.f0.p(it2, "<this>");
        return new j0(it2);
    }
}
