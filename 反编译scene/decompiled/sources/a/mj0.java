package a;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1937a;

    public mj0(Context context) {
        f92.d(context, "context");
        this.f6814a = context;
        this.f1937a = context.getPackageName();
    }

    public final void a(String str) {
        String parent;
        f92.d(str, "absPath");
        File file = new File(str);
        if (file.exists()) {
            String str2 = this.f1937a;
            f92.c(str2, "packageName");
            if (ec2.C(str, str2, false, 2, null)) {
                file.setReadable(true, false);
                file.setExecutable(true, false);
                file.setWritable(true, false);
                String str3 = this.f1937a;
                f92.c(str3, "packageName");
                if (bc2.o(str, str3, false, 2, null) || (parent = file.getParent()) == null) {
                    return;
                }
                a(parent);
            }
        }
    }
}
