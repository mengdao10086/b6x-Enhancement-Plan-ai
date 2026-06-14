package a;

import android.view.View;
import android.widget.Toast;
import com.omarea.ui.BlurViewRecyclerView;
import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cc1 implements yz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dc1 f5779a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ jp f379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zz0 f380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ BlurViewRecyclerView f381a;

    public cc1(BlurViewRecyclerView blurViewRecyclerView, jp jpVar, dc1 dc1Var, zz0 zz0Var) {
        this.f381a = blurViewRecyclerView;
        this.f379a = jpVar;
        this.f5779a = dc1Var;
        this.f380a = zz0Var;
    }

    @Override // a.yz0
    public void a(View view, int i) {
        f92.d(view, "view");
        if (f92.a(e50.f677a.y0(), "basic")) {
            Toast.makeText(this.f381a.getContext(), u61.only_adb_or_root_mode, 0).show();
        } else {
            if (this.f379a.r()) {
                return;
            }
            ActivityFreezeApps.this.showOptions(this.f380a.C(i));
        }
    }
}
