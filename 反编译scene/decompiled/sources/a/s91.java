package a;

import android.view.View;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class s91 implements ActivityCpuControl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f7375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityCpuControl.c f2862a;

    public s91(ActivityCpuControl.c cVar, View view) {
        this.f2862a = cVar;
        this.f7375a = view;
    }

    @Override // com.omarea.vtools.activities.ActivityCpuControl.b
    public void a(String str) {
        f92.d(str, "result");
        if (!f92.a(ActivityCpuControl.this.f5212a.p(this.f2862a.f8613a), str)) {
            ActivityCpuControl.this.f5212a.H(this.f2862a.f8613a, str);
            ActivityCpuControl.this.f5220b.clusters.get(this.f2862a.f8613a).min_freq = str;
        }
        ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
        activityCpuControl.a0((TextView) this.f7375a, activityCpuControl.d0(str));
    }
}
