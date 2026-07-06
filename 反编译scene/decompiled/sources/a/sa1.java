package a;

import android.content.Intent;
import android.view.View;
import com.omarea.vtools.activities.ActivityFpsSession;
import com.omarea.vtools.activities.ActivityThreadsStat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sa1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f7377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSession f2868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2869a;

    public sa1(long j, String str, ActivityFpsSession activityFpsSession) {
        this.f7377a = j;
        this.f2869a = str;
        this.f2868a = activityFpsSession;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityFpsSession activityFpsSession = this.f2868a;
        Intent intent = new Intent(this.f2868a.getContext(), (Class<?>) ActivityThreadsStat.class);
        intent.putExtra("sessionId", this.f7377a);
        intent.putExtra("appName", this.f2869a);
        m42 m42Var = m42.f6769a;
        activityFpsSession.startActivity(intent);
    }
}
