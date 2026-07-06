package a;

import android.app.Activity;
import android.view.View;
import com.omarea.vtools.activities.ActivityPerfOptions;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ap1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dp1 f5630a;

    public ap1(dp1 dp1Var) {
        this.f5630a = dp1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityPerfOptions.a aVar = ActivityPerfOptions.f8803a;
        Activity activityG = this.f5630a.g();
        m30 m30VarB = new tr0(this.f5630a.g()).b();
        String string = this.f5630a.g().getString(u61.schedule_env);
        f92.c(string, "context.getString(R.string.schedule_env)");
        aVar.b(activityG, m30VarB, "features/env.conf", string);
    }
}
