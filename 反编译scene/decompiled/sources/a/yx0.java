package a;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yx0 {
    public yx0() {
    }

    public /* synthetic */ yx0(b92 b92Var) {
        this();
    }

    public final zx0 a(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "dbName");
        if (!f92.a(str, "default_cloud.db")) {
            File databasePath = context.getDatabasePath(str);
            f92.c(databasePath, "context.getDatabasePath(dbName)");
            String absolutePath = databasePath.getAbsolutePath();
            f92.c(absolutePath, "targetPath");
            String packageName = context.getPackageName();
            f92.c(packageName, "context.packageName");
            String strT = bc2.t(absolutePath, packageName, zx0.d, false, 4, null);
            s60.f7366a.a("cp -f " + strT + ' ' + absolutePath + " && chmod 777 " + absolutePath + "\ncp -f " + strT + "-journal " + absolutePath + "-journal && chmod 777 " + absolutePath + "-journal");
        }
        return new zx0(context, str, null);
    }

    public final void b() {
        s60.f7366a.a("pm clear " + zx0.d + " && am start-service com.xiaomi.joyose/com.xiaomi.joyose.smartop.SmartOpService");
        e60 e60Var = e60.f698a;
        String str = ay0.f5653a;
        f92.c(str, "JoyoseConfig.PATH");
        e60Var.q(str);
    }
}
