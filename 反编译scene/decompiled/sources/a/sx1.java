package a;

import com.omarea.Scene;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sx1 implements ha0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ py1 f7442a;

    public sx1(py1 py1Var) {
        this.f7442a = py1Var;
    }

    @Override // a.ha0
    public boolean eventFilter(aa0 aa0Var) {
        f92.d(aa0Var, "eventType");
        return aa0Var == aa0.APP_SWITCH || aa0Var == aa0.SCREEN_OFF || aa0Var == aa0.SCREEN_ON || aa0Var == aa0.SCENE_MODE_ACTION || aa0Var == aa0.POWER_CONNECTED || aa0Var == aa0.POWER_DISCONNECTED;
    }

    @Override // a.ha0
    public boolean isAsync() {
        return false;
    }

    @Override // a.ha0
    public void onReceive(aa0 aa0Var, HashMap<String, Object> map) {
        f92.d(aa0Var, "eventType");
        if (this.f7442a.f2466a > 0) {
            if (aa0Var != aa0.SCREEN_OFF && aa0Var != aa0.SCREEN_ON && aa0Var != aa0.POWER_CONNECTED && aa0Var != aa0.POWER_DISCONNECTED && aa0Var != aa0.SCENE_MODE_ACTION) {
                if (!(fa0.f867a.j().length() > 0) || !(!f92.a(fa0.f867a.j(), this.f7442a.f2478a))) {
                    return;
                }
            }
            Scene.f4798a.i(new rx1(this, aa0Var));
        }
    }

    @Override // a.ha0
    public void onSubscribe() {
    }

    @Override // a.ha0
    public void onUnsubscribe() {
    }
}
