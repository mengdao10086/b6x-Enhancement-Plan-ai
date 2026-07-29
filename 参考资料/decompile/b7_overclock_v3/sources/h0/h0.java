package h0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f30120a = "PackageManagerCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f30121b = "android.intent.action.AUTO_REVOKE_PERMISSIONS";

    @v0(30)
    public static class a {
        public static boolean a(@g.n0 Context context) {
            return !context.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface b {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean a(@g.n0 PackageManager packageManager) {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = i10 >= 30;
        boolean z11 = i10 >= 23 && i10 < 30;
        boolean z12 = b(packageManager) != null;
        if (z10) {
            return true;
        }
        return z11 && z12;
    }

    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String b(@g.n0 PackageManager packageManager) {
        String str = null;
        Iterator<ResolveInfo> it2 = packageManager.queryIntentActivities(new Intent(f30121b).setData(Uri.fromParts("package", "com.example", null)), 0).iterator();
        while (it2.hasNext()) {
            String str2 = it2.next().activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", str2) == 0) {
                if (str != null) {
                    return str;
                }
                str = str2;
            }
        }
        return str;
    }

    @g.n0
    public static ListenableFuture<Integer> c(@g.n0 Context context) {
        androidx.concurrent.futures.a<Integer> aVarU = androidx.concurrent.futures.a.u();
        if (!androidx.core.os.b0.a(context)) {
            aVarU.p(0);
            return aVarU;
        }
        if (!a(context.getPackageManager())) {
            aVarU.p(1);
            return aVarU;
        }
        int i10 = context.getApplicationInfo().targetSdkVersion;
        if (i10 < 30) {
            aVarU.p(0);
            return aVarU;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31) {
            if (a.a(context)) {
                aVarU.p(Integer.valueOf(i10 >= 31 ? 5 : 4));
            } else {
                aVarU.p(2);
            }
            return aVarU;
        }
        if (i11 == 30) {
            aVarU.p(Integer.valueOf(a.a(context) ? 4 : 2));
            return aVarU;
        }
        final n0 n0Var = new n0(context);
        aVarU.addListener(new Runnable() { // from class: h0.g0
            @Override // java.lang.Runnable
            public final void run() {
                n0Var.b();
            }
        }, Executors.newSingleThreadExecutor());
        n0Var.a(aVarU);
        return aVarU;
    }
}
