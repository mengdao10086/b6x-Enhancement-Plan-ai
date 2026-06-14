package a;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class g61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g61 f6176a = new g61();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f978a;
    public static final String b;

    static {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        f92.c(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
        String absolutePath = externalStorageDirectory.getAbsolutePath();
        f92.c(absolutePath, "Environment.getExternalS…eDirectory().absolutePath");
        f978a = absolutePath;
        b = f978a + "/backups/apps/";
    }

    public final String a() {
        return b;
    }

    public final String b() {
        return f978a;
    }
}
