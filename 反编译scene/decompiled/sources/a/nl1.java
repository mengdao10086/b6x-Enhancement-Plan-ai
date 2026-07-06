package a;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f6930a = Scene.f4798a.c();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedPreferences f2111a = Scene.f4798a.g();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BatteryManager f2112a;

    public nl1() {
        Object systemService = this.f6930a.getSystemService("batterymanager");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
        }
        this.f2112a = (BatteryManager) systemService;
    }

    public final long c() {
        return this.f2112a.getLongProperty(2);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Type inference failed for: r0v22, types: [T, a.p80$b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(android.content.Context r20) {
        /*
            Method dump skipped, instruction units count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.nl1.d(android.content.Context):void");
    }
}
