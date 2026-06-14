package a;

import android.app.Activity;
import android.view.View;
import com.omarea.vtools.activities.ActivityPerfOptions;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zo1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dp1 f8085a;

    public zo1(dp1 dp1Var) {
        this.f8085a = dp1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityPerfOptions.a aVar = ActivityPerfOptions.f8803a;
        Activity activityG = this.f8085a.g();
        String str = this.f8085a.e;
        String string = this.f8085a.g().getString(u61.schedule_feature_cpus);
        f92.c(string, "context.getString(R.string.schedule_feature_cpus)");
        aVar.a(activityG, 2131820553, str, string);
    }
}
