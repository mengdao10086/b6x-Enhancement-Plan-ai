package a;

import android.os.BatteryManager;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ba0 extends g92 implements v72<BatteryManager> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ba0 f5687a = new ba0();

    public ba0() {
        super(0);
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final BatteryManager i() {
        Object systemService = Scene.f4798a.c().getSystemService("batterymanager");
        if (systemService != null) {
            return (BatteryManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
    }
}
