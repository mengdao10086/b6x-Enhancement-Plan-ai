package l0;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import g.n0;
import g.u;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: l0.a$a, reason: collision with other inner class name */
    @v0(28)
    public static class C0440a {
        @u
        public static void a(SQLiteCursor sQLiteCursor, boolean z10) {
            sQLiteCursor.setFillWindowForwardOnly(z10);
        }
    }

    public static void a(@n0 SQLiteCursor sQLiteCursor, boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            C0440a.a(sQLiteCursor, z10);
        }
    }
}
