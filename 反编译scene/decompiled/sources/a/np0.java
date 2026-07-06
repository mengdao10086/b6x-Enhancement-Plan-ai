package a;

import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class np0 {
    public np0() {
    }

    public /* synthetic */ np0(b92 b92Var) {
        this();
    }

    public final boolean a() {
        if (new File("/sbin/busybox").exists() || new File("/system/xbin/busybox").exists() || new File("/system/sbin/busybox").exists() || new File("/system/bin/busybox").exists() || new File("/vendor/bin/busybox").exists() || new File("/vendor/xbin/busybox").exists() || new File("/odm/bin/busybox").exists()) {
            return true;
        }
        try {
            Runtime.getRuntime().exec("busybox --help").destroy();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
