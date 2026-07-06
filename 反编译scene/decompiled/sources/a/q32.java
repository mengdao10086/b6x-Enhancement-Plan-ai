package a;

import android.app.Activity;
import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q32 f7175a = new q32();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final p32 f2541a = b();

    public static q32 a() {
        return f7175a;
    }

    public final p32 b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new r32();
        }
        if (i >= 26) {
            if (w32.i()) {
                return new s32();
            }
            if (w32.j()) {
                return new u32();
            }
            if (w32.l()) {
                return new s32();
            }
            if (w32.m()) {
                return new t32();
            }
        }
        return null;
    }

    public void c(Activity activity) {
        p32 p32Var = this.f2541a;
        if (p32Var != null) {
            p32Var.a(activity);
        }
    }
}
