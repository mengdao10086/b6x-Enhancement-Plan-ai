package ri;

import io.objectbox.BoxStore;
import java.util.Objects;
import xi.b0;
import xi.c0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d {
    public static /* synthetic */ void c(b0 b0Var, Class cls) {
        if (b0Var.isDisposed()) {
            return;
        }
        b0Var.onNext(cls);
    }

    public static /* synthetic */ void d(BoxStore boxStore, final b0 b0Var) throws Exception {
        pi.d dVarF = boxStore.O2().f(new pi.a() { // from class: ri.b
            @Override // pi.a
            public final void b(Object obj) {
                d.c(b0Var, (Class) obj);
            }
        });
        Objects.requireNonNull(dVarF);
        b0Var.b(new a(dVarF));
    }

    public static <T> z<Class> e(final BoxStore boxStore) {
        return z.r1(new c0() { // from class: ri.c
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                d.d(boxStore, b0Var);
            }
        });
    }
}
