package a;

import a.p80;
import android.view.View;
import com.omarea.model.ProcessInfo;
import com.omarea.vtools.activities.ActivityProcess;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ff1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ProcessInfo f897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityProcess f898a;

    public ff1(ActivityProcess activityProcess, ProcessInfo processInfo, p80.b bVar) {
        this.f898a = activityProcess;
        this.f897a = processInfo;
        this.f6101a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6101a.c();
        p80.a aVar = p80.f2403a;
        ActivityProcess activityProcess = this.f898a;
        qc2.d(xd2.a(qe2.b()), null, null, new ef1(this, aVar.F(activityProcess, activityProcess.getString(u61.process_force_empty)), null), 3, null);
    }
}
