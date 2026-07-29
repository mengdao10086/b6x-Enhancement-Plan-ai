package u4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import g.i1;
import g.n0;
import g.p0;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f51929a = "AppVersionSignature";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap<String, c4.b> f51930b = new ConcurrentHashMap();

    @p0
    public static PackageInfo a(@n0 Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot resolve info for");
            sb2.append(context.getPackageName());
            return null;
        }
    }

    @n0
    public static String b(@p0 PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @n0
    public static c4.b c(@n0 Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, c4.b> concurrentMap = f51930b;
        c4.b bVar = concurrentMap.get(packageName);
        if (bVar != null) {
            return bVar;
        }
        c4.b bVarD = d(context);
        c4.b bVarPutIfAbsent = concurrentMap.putIfAbsent(packageName, bVarD);
        return bVarPutIfAbsent == null ? bVarD : bVarPutIfAbsent;
    }

    @n0
    public static c4.b d(@n0 Context context) {
        return new e(b(a(context)));
    }

    @i1
    public static void e() {
        f51930b.clear();
    }
}
