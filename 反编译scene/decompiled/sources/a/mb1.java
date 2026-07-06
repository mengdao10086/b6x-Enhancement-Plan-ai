package a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.model.AppInfo;
import com.omarea.vtools.activities.ActivityFpsSessions;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mb1 implements e01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityFpsSessions f6789a;

    public mb1(ActivityFpsSessions activityFpsSessions) {
        this.f6789a = activityFpsSessions;
    }

    @Override // a.e01
    public void a(View view, int i) {
        f92.d(view, "view");
        RecyclerView recyclerView = (RecyclerView) this.f6789a._$_findCachedViewById(t61.chart_apps_list);
        f92.c(recyclerView, "chart_apps_list");
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppIconList");
        }
        f01 f01Var = (f01) adapter;
        AppInfo appInfoD = f01Var.D(i);
        String packageName = appInfoD.getPackageName();
        if (this.f6789a.b) {
            this.f6789a.x(appInfoD);
        } else {
            f01Var.I(packageName);
            this.f6789a.E(packageName);
        }
    }
}
