package i0;

import android.annotation.SuppressLint;
import android.content.pm.PermissionInfo;
import android.os.Build;
import androidx.annotation.RestrictTo;
import g.n0;
import g.u;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    @v0(28)
    public static class a {
        @u
        public static int a(PermissionInfo permissionInfo) {
            return permissionInfo.getProtection();
        }

        @u
        public static int b(PermissionInfo permissionInfo) {
            return permissionInfo.getProtectionFlags();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface b {
    }

    /* JADX INFO: renamed from: i0.c$c, reason: collision with other inner class name */
    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface InterfaceC0374c {
    }

    @SuppressLint({"WrongConstant"})
    public static int a(@n0 PermissionInfo permissionInfo) {
        return Build.VERSION.SDK_INT >= 28 ? a.a(permissionInfo) : permissionInfo.protectionLevel & 15;
    }

    @SuppressLint({"WrongConstant"})
    public static int b(@n0 PermissionInfo permissionInfo) {
        return Build.VERSION.SDK_INT >= 28 ? a.b(permissionInfo) : permissionInfo.protectionLevel & (-16);
    }
}
