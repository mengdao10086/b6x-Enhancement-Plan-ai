package a;

import com.omarea.ui.fps.FrameTimeView2;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cx1 implements ha0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dx1 f5837a;

    public cx1(dx1 dx1Var) {
        this.f5837a = dx1Var;
    }

    @Override // a.ha0
    public boolean eventFilter(aa0 aa0Var) {
        f92.d(aa0Var, "eventType");
        return aa0Var == aa0.DAEMON_FRAME_TIME;
    }

    @Override // a.ha0
    public boolean isAsync() {
        return false;
    }

    @Override // a.ha0
    public void onReceive(aa0 aa0Var, HashMap<String, Object> map) {
        f92.d(aa0Var, "eventType");
        FrameTimeView2 frameTimeView2 = this.f5837a.f623a;
        Object obj = map != null ? map.get("fps") : null;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        Object obj2 = map.get("data");
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Int>");
        }
        frameTimeView2.i(dDoubleValue, (Integer[]) obj2);
    }

    @Override // a.ha0
    public void onSubscribe() {
    }

    @Override // a.ha0
    public void onUnsubscribe() {
    }
}
