package a;

import android.os.Build;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i6 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s6 f6379a;

    public i6(s6 s6Var) {
        this.f6379a = s6Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.f6379a.getInternalPopup().a()) {
            this.f6379a.b();
        }
        ViewTreeObserver viewTreeObserver = this.f6379a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }
}
