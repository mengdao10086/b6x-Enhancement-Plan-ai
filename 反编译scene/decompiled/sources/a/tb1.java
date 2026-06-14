package a;

import android.view.View;
import android.widget.CompoundButton;
import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tb1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityFreezeApps f7485a;

    public tb1(ActivityFreezeApps activityFreezeApps) {
        this.f7485a = activityFreezeApps;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        boolean zIsChecked = ((CompoundButton) view).isChecked();
        this.f7485a.switchSuspendMode();
        Scene.f4798a.k(hz0.O, zIsChecked);
    }
}
