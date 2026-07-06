package a;

import com.omarea.vtools.AccessibilitySceneMode;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r61 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AccessibilitySceneMode f7275a;

    public r61(AccessibilitySceneMode accessibilitySceneMode, Long l) {
        this.f7275a = accessibilitySceneMode;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (System.currentTimeMillis() - this.f7275a.f5065c <= this.f7275a.f5068d) {
            AccessibilitySceneMode.v(this.f7275a, null, 1, null);
        } else {
            this.f7275a.B();
        }
    }
}
