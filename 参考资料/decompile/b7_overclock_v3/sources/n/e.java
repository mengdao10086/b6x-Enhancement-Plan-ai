package n;

import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class e {
    public abstract void a(@n0 Runnable runnable);

    public void b(@n0 Runnable runnable) {
        if (c()) {
            runnable.run();
        } else {
            d(runnable);
        }
    }

    public abstract boolean c();

    public abstract void d(@n0 Runnable runnable);
}
