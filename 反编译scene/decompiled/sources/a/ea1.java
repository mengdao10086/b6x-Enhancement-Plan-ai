package a;

import android.view.View;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ea1 implements ActivityCpuControl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f5983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityCpuControl.p f713a;

    public ea1(ActivityCpuControl.p pVar, View view) {
        this.f713a = pVar;
        this.f5983a = view;
    }

    @Override // com.omarea.vtools.activities.ActivityCpuControl.b
    public void a(String str) {
        f92.d(str, "result");
        ActivityCpuControl.this.f5213a.r(str);
        ActivityCpuControl.this.f5220b.gpuMinFreq = str;
        ActivityCpuControl activityCpuControl = ActivityCpuControl.this;
        activityCpuControl.a0((TextView) this.f5983a, activityCpuControl.e0(str));
    }
}
