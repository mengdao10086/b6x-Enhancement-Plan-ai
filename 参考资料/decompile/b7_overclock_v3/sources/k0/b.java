package k0;

import android.database.CursorWindow;
import android.os.Build;
import g.n0;
import g.p0;
import g.u;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    @v0(15)
    public static class a {
        @u
        public static CursorWindow a(String str) {
            return new CursorWindow(str);
        }
    }

    /* JADX INFO: renamed from: k0.b$b, reason: collision with other inner class name */
    @v0(28)
    public static class C0417b {
        @u
        public static CursorWindow a(String str, long j10) {
            return new CursorWindow(str, j10);
        }
    }

    @n0
    public static CursorWindow a(@p0 String str, long j10) {
        return Build.VERSION.SDK_INT >= 28 ? C0417b.a(str, j10) : a.a(str);
    }
}
