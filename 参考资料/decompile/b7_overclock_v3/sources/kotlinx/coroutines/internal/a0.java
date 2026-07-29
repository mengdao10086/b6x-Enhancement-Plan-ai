package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.m2;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1963#2,14:135\n*S KotlinDebug\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n*L\n38#1:135,14\n*E\n"})
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a0 f38776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f38777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final m2 f38778c;

    static {
        a0 a0Var = new a0();
        f38776a = a0Var;
        f38777b = r0.f(b0.f38783a, true);
        f38778c = a0Var.a();
    }

    public final m2 a() {
        Object next;
        m2 m2VarF;
        try {
            List<z> listD = f38777b ? m.f38813a.d() : SequencesKt___SequencesKt.c3(SequencesKt__SequencesKt.e(ServiceLoader.load(z.class, z.class.getClassLoader()).iterator()));
            Iterator<T> it2 = listD.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int iC = ((z) next).c();
                    do {
                        Object next2 = it2.next();
                        int iC2 = ((z) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            z zVar = (z) next;
            return (zVar == null || (m2VarF = b0.f(zVar, listD)) == null) ? b0.b(null, null, 3, null) : m2VarF;
        } catch (Throwable th2) {
            return b0.b(th2, null, 2, null);
        }
    }
}
