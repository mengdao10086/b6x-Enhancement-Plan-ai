package a;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g30 f7786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PackageManager f3437a;

    public wg0(Context context) {
        f92.d(context, "context");
        this.f3436a = context;
        this.f7786a = new g30(h60.f6280a.b(this.f3436a, 2131820560));
        this.f3437a = this.f3436a.getPackageManager();
    }

    public final String a(String str) {
        int iB = new fb0(this.f3436a).b();
        return s60.f7366a.c("appops get --user " + iB + ' ' + str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<a.vg0> b(java.lang.String r16) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.wg0.b(java.lang.String):java.util.List");
    }

    public final PackageInfo c(String str) {
        try {
            return this.f3437a.getPackageInfo(str, 4096);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String[] d(String str) {
        f92.d(str, "packageName");
        PackageInfo packageInfoC = c(str);
        if (packageInfoC == null) {
            return null;
        }
        String[] strArr = packageInfoC.requestedPermissions;
        f92.c(strArr, "packageInfo.requestedPermissions");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            f92.c(str2, "it");
            if (bc2.x(str2, "android.permission", false, 2, null)) {
                arrayList.add(str2);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<a.vg0> e(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.wg0.e(java.lang.String):java.util.List");
    }

    public final String f(String str) {
        String strT = bc2.t(str, "android:", "", false, 4, null);
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (strT == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = strT.toUpperCase(locale);
        f92.c(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public final void g(String str, String str2, ug0 ug0Var) {
        s60 s60Var;
        StringBuilder sb;
        String str3;
        f92.d(str, "packageName");
        f92.d(str2, "permission");
        f92.d(ug0Var, "mode");
        String strPermissionToOp = AppOpsManager.permissionToOp(str2);
        if (strPermissionToOp == null) {
            strPermissionToOp = this.f7786a.j(str2) ? this.f7786a.i(str2) : null;
        }
        if (strPermissionToOp != null) {
            String string = ug0Var.toString();
            Locale locale = Locale.getDefault();
            f92.c(locale, "Locale.getDefault()");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = string.toLowerCase(locale);
            f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String strF = f(strPermissionToOp);
            int iB = new fb0(this.f3436a).b();
            if (ug0Var == ug0.ALLOW || ug0Var == ug0.FOREGROUND) {
                s60Var = s60.f7366a;
                sb = new StringBuilder();
                str3 = "pm grant --user ";
            } else {
                s60Var = s60.f7366a;
                sb = new StringBuilder();
                str3 = "pm revoke --user ";
            }
            sb.append(str3);
            sb.append(iB);
            sb.append(' ');
            sb.append(str);
            sb.append(' ');
            sb.append(str2);
            sb.append("\nappops set --user ");
            sb.append(iB);
            sb.append(' ');
            sb.append(str);
            sb.append(' ');
            sb.append(strF);
            sb.append(' ');
            sb.append(lowerCase);
            s60Var.c(sb.toString());
        }
    }
}
