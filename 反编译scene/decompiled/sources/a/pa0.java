package a;

import com.omarea.Scene;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pa0 implements ha0 {
    public final boolean b;

    public pa0(boolean z) {
        this.b = z;
    }

    @Override // a.ha0
    public boolean eventFilter(aa0 aa0Var) {
        f92.d(aa0Var, "eventType");
        switch (na0.f6892a[aa0Var.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    @Override // a.ha0
    public boolean isAsync() {
        return this.b;
    }

    @Override // a.ha0
    public void onReceive(aa0 aa0Var, HashMap<String, Object> map) {
        j50 j50Var;
        f92.d(aa0Var, "eventType");
        if (e50.f677a.r0()) {
            switch (na0.b[aa0Var.ordinal()]) {
                case 1:
                    j50Var = j50.BOOT_COMPLETED;
                    break;
                case 2:
                    j50Var = j50.BATTERY_LOW;
                    break;
                case 3:
                    j50Var = j50.BATTERY_FULL;
                    break;
                case 4:
                    j50Var = j50.BATTERY_CAPACITY_CHANGED;
                    break;
                case 5:
                    j50Var = j50.POWER_CONNECTED;
                    break;
                case 6:
                    j50Var = j50.POWER_DISCONNECTED;
                    break;
                case 7:
                    j50Var = j50.SCREEN_OFF;
                    break;
                case 8:
                    j50Var = j50.SCREEN_ON;
                    break;
                case 9:
                    j50Var = j50.APP_SWITCH;
                    break;
                default:
                    return;
            }
            Scene.f4798a.a(new oa0(j50Var, null));
        }
    }

    @Override // a.ha0
    public void onSubscribe() {
    }

    @Override // a.ha0
    public void onUnsubscribe() {
    }
}
