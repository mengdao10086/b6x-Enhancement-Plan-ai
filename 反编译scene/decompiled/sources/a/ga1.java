package a;

import android.view.View;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ga1 implements ActivityCpuControl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityCpuControl.r f986a;

    public ga1(ActivityCpuControl.r rVar, View view) {
        this.f986a = rVar;
        this.f6189a = view;
    }

    @Override // com.omarea.vtools.activities.ActivityCpuControl.b
    public void a(String str) {
        f92.d(str, "result");
        if (!f92.a(ActivityCpuControl.this.f5213a.e(), str)) {
            ActivityCpuControl.this.f5213a.p(str);
            ActivityCpuControl.this.f5220b.adrenoGovernor = str;
            ActivityCpuControl.this.a0((TextView) this.f6189a, str);
        }
    }
}
