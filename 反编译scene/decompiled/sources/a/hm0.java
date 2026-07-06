package a;

import android.os.IBinder;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class hm0 {
    public static IBinder a(String str) {
        return (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, str);
    }
}
