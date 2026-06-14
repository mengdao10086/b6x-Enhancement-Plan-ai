package a;

import android.widget.Toast;
import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zb1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ac1 f8055a;

    public zb1(ac1 ac1Var) {
        this.f8055a = ac1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityFreezeApps.this.loadData();
        ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this).c();
        Toast.makeText(ActivityFreezeApps.this.getContext(), ActivityFreezeApps.this.getString(u61.freeze_shortcut_delete_desc), 1).show();
    }
}
