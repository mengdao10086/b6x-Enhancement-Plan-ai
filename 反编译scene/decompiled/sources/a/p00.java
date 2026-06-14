package a;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p00 implements u00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f7069a;

    public p00(BaseTransientBottomBar baseTransientBottomBar) {
        this.f7069a = baseTransientBottomBar;
    }

    @Override // a.u00
    public void onViewAttachedToWindow(View view) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.f7069a.f4663a.getRootWindowInsets()) == null) {
            return;
        }
        this.f7069a.e = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
        this.f7069a.T();
    }

    @Override // a.u00
    public void onViewDetachedFromWindow(View view) {
        if (this.f7069a.E()) {
            BaseTransientBottomBar.f8316a.post(new o00(this));
        }
    }
}
