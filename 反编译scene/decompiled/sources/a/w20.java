package a;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w20 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final v20 f3357a = new v20(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h50 f7747a = new h50(14754, "3.0.3", "2026.05.31 11:58");

    public w20(Context context) {
        f92.d(context, "context");
        this.f3358a = context;
    }

    public final boolean b() {
        return !c();
    }

    public final boolean c() {
        try {
            ApplicationInfo applicationInfo = this.f3358a.getPackageManager().getApplicationInfo(this.f3358a.getPackageName(), 128);
            f92.c(applicationInfo, "context.packageManager.g…T_META_DATA\n            )");
            f92.b(applicationInfo.metaData);
            return !r0.getBoolean("free_version");
        } catch (Exception unused) {
            return false;
        }
    }
}
