package a;

import android.content.Context;
import com.omarea.Scene;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ua0 implements ha0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean[] f3162a;

    public ua0(Context context) {
        f92.d(context, "context");
        this.f7580a = context;
        this.f3162a = new boolean[]{false, false, false, false, false, false};
    }

    @Override // a.ha0
    public boolean eventFilter(aa0 aa0Var) {
        f92.d(aa0Var, "eventType");
        return aa0Var == aa0.SCREEN_OFF || aa0Var == aa0.SCREEN_ON || aa0Var == aa0.ACCESSIBILITY_SERVICE;
    }

    @Override // a.ha0
    public boolean isAsync() {
        return false;
    }

    @Override // a.ha0
    public void onReceive(aa0 aa0Var, HashMap<String, Object> map) {
        f92.d(aa0Var, "eventType");
        if (Scene.f4798a.b(hz0.f1282a.T(), false)) {
            return;
        }
        Scene.f4798a.i(new ta0(this, aa0Var));
    }

    @Override // a.ha0
    public void onSubscribe() {
    }

    @Override // a.ha0
    public void onUnsubscribe() {
    }
}
