package a;

import android.view.View;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fa1 implements ActivityCpuControl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityCpuControl.q f877a;

    public fa1(ActivityCpuControl.q qVar, View view) {
        this.f877a = qVar;
        this.f6088a = view;
    }

    @Override // com.omarea.vtools.activities.ActivityCpuControl.b
    public void a(String str) {
        f92.d(str, "result");
        ActivityCpuControl.this.f5213a.q(str);
        ActivityCpuControl.this.f5220b.gpuMaxFreq = str;
        ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
        activityCpuControl.a0((TextView) this.f6088a, activityCpuControl.e0(str));
    }
}
