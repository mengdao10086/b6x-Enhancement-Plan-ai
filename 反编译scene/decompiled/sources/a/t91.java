package a;

import android.view.View;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t91 implements ActivityCpuControl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f7480a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityCpuControl.d f3005a;

    public t91(ActivityCpuControl.d dVar, View view) {
        this.f3005a = dVar;
        this.f7480a = view;
    }

    @Override // com.omarea.vtools.activities.ActivityCpuControl.b
    public void a(String str) {
        f92.d(str, "result");
        if (!f92.a(ActivityCpuControl.this.f5212a.o(this.f3005a.f8614a), str)) {
            ActivityCpuControl.this.f5212a.G(this.f3005a.f8614a, str);
            ActivityCpuControl.this.f5220b.clusters.get(this.f3005a.f8614a).max_freq = str;
        }
        ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
        activityCpuControl.a0((TextView) this.f7480a, activityCpuControl.d0(str));
    }
}
