package a;

import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r12 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f7261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ WindowManager f2682a;

    public r12(WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        this.f7261a = layoutParams;
        this.f2682a = windowManager;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f7261a.flags = 1080;
        View viewA = u12.f3107a.a();
        f92.b(viewA);
        viewA.setBackgroundColor(Color.argb(128, 255, 255, 255));
        this.f2682a.updateViewLayout(u12.f3107a.a(), this.f7261a);
        return true;
    }
}
