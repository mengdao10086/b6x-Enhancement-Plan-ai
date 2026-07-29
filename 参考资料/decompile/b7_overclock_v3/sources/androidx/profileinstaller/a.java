package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import g.n0;
import g.v0;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: androidx.profileinstaller.a$a, reason: collision with other inner class name */
    @v0(api = 21)
    public static class C0061a {
        public static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    @v0(api = 24)
    public static class b {
        public static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    public static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z10 = true;
        for (File file2 : fileArrListFiles) {
            z10 = a(file2) && z10;
        }
        return z10;
    }

    public static void b(@n0 Context context, @n0 ProfileInstallReceiver.a aVar) {
        int i10 = Build.VERSION.SDK_INT;
        if (a(i10 >= 24 ? b.a(context) : i10 >= 23 ? C0061a.a(context) : context.getCacheDir())) {
            aVar.b(14, null);
        } else {
            aVar.b(15, null);
        }
    }
}
