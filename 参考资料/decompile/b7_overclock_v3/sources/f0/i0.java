package f0;

import android.app.Service;
import android.os.Build;
import androidx.annotation.RestrictTo;
import g.n0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f27483a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f27484b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f27485c = 2;

    @v0(24)
    public static class a {
        @g.u
        public static void a(Service service, int i10) {
            service.stopForeground(i10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface b {
    }

    public static void a(@n0 Service service, int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(service, i10);
        } else {
            service.stopForeground((i10 & 1) != 0);
        }
    }
}
