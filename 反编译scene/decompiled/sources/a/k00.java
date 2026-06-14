package a;

import android.util.Log;
import android.view.ViewGroup;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k00 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f6559a;

    public k00(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6559a = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int iY;
        BaseTransientBottomBar baseTransientBottomBar = this.f6559a;
        if (baseTransientBottomBar.f4663a == null || baseTransientBottomBar.f4657a == null || (iY = (this.f6559a.y() - this.f6559a.B()) + ((int) this.f6559a.f4663a.getTranslationY())) >= this.f6559a.e) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f6559a.f4663a.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(BaseTransientBottomBar.f4652a, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
            return;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += this.f6559a.e - iY;
        this.f6559a.f4663a.requestLayout();
    }
}
