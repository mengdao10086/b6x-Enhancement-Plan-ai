package a;

import android.view.View;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u91 implements ActivityCpuControl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f7578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityCpuControl.e f3161a;

    public u91(ActivityCpuControl.e eVar, View view) {
        this.f3161a = eVar;
        this.f7578a = view;
    }

    @Override // com.omarea.vtools.activities.ActivityCpuControl.b
    public void a(String str) {
        f92.d(str, "result");
        if (!f92.a(ActivityCpuControl.this.f5212a.s(this.f3161a.f8615a), str)) {
            ActivityCpuControl.this.f5212a.F(str, this.f3161a.f8615a);
            ActivityCpuControl.this.f5220b.clusters.get(this.f3161a.f8615a).governor = str;
        }
        ActivityCpuControl.this.a0((TextView) this.f7578a, str);
    }
}
