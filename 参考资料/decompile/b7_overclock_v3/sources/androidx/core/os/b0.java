package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {

    @v0(24)
    public static class a {
        @g.u
        public static boolean a(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    public static boolean a(@n0 Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(context);
        }
        return true;
    }
}
