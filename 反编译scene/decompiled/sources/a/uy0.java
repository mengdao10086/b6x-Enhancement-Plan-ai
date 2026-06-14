package a;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uy0 {
    public uy0() {
    }

    public /* synthetic */ uy0(b92 b92Var) {
        this();
    }

    public static /* synthetic */ vy0 b(uy0 uy0Var, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "user_configure.db";
        }
        return uy0Var.a(context, str);
    }

    public final vy0 a(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "dbName");
        File databasePath = context.getDatabasePath(str);
        f92.c(databasePath, "context.getDatabasePath(dbName)");
        String absolutePath = databasePath.getAbsolutePath();
        f92.c(absolutePath, "targetPath");
        String packageName = context.getPackageName();
        f92.c(packageName, "context.packageName");
        String strT = bc2.t(absolutePath, packageName, vy0.b, false, 4, null);
        s60.f7366a.a("cp -f " + strT + ' ' + absolutePath + " && chmod 777 " + absolutePath + "\ncp -f " + strT + "-journal " + absolutePath + "-journal && chmod 777 " + absolutePath + "-journal");
        return new vy0(context, str, null);
    }
}
