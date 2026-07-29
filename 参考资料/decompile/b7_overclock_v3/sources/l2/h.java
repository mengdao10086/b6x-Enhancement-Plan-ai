package l2;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.work.l;
import g.i1;
import g.n0;
import g.v0;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f39372b = "androidx.work.workdb";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f39371a = l.f("WrkDbPathHelper");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f39373c = {"-journal", "-shm", "-wal"};

    @i1
    @n0
    public static File a(@n0 Context context) {
        return Build.VERSION.SDK_INT < 23 ? b(context) : c(context, f39372b);
    }

    @i1
    @n0
    public static File b(@n0 Context context) {
        return context.getDatabasePath(f39372b);
    }

    @v0(23)
    public static File c(@n0 Context context, @n0 String filePath) {
        return new File(context.getNoBackupFilesDir(), filePath);
    }

    @n0
    public static String d() {
        return f39372b;
    }

    public static void e(@n0 Context context) {
        File fileB = b(context);
        if (Build.VERSION.SDK_INT < 23 || !fileB.exists()) {
            return;
        }
        l.c().a(f39371a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
        Map<File, File> mapF = f(context);
        for (File file : mapF.keySet()) {
            File file2 = mapF.get(file);
            if (file.exists() && file2 != null) {
                if (file2.exists()) {
                    l.c().h(f39371a, String.format("Over-writing contents of %s", file2), new Throwable[0]);
                }
                l.c().a(f39371a, file.renameTo(file2) ? String.format("Migrated %s to %s", file, file2) : String.format("Renaming %s to %s failed", file, file2), new Throwable[0]);
            }
        }
    }

    @i1
    @n0
    public static Map<File, File> f(@n0 Context context) {
        HashMap map = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            File fileB = b(context);
            File fileA = a(context);
            map.put(fileB, fileA);
            for (String str : f39373c) {
                map.put(new File(fileB.getPath() + str), new File(fileA.getPath() + str));
            }
        }
        return map;
    }
}
