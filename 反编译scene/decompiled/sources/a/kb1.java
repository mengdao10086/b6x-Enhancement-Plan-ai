package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;
import com.omarea.vtools.activities.ActivityFpsSessions;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kb1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f1609a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSessions.e f1610a;
    public final /* synthetic */ CompoundButton b;

    public kb1(ActivityFpsSessions.e eVar, CompoundButton compoundButton, CompoundButton compoundButton2, p80.b bVar) {
        this.f1610a = eVar;
        this.f1609a = compoundButton;
        this.b = compoundButton2;
        this.f6590a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        hz0 hz0Var = hz0.f1282a;
        CompoundButton compoundButton = this.f1609a;
        f92.c(compoundButton, "autoUpload");
        hz0Var.F0(compoundButton.isChecked());
        CompoundButton compoundButton2 = this.b;
        f92.c(compoundButton2, "uploadHistory");
        if (!compoundButton2.isChecked()) {
            qf2 qf2Var = ActivityFpsSessions.this.f5282a;
            if (qf2Var != null) {
                of2.a(qf2Var, null, 1, null);
            }
            ActivityFpsSessions.this.f5282a = null;
        } else if (aj0.f5612a.a(ActivityFpsSessions.this)) {
            ActivityFpsSessions.this.G();
        } else {
            p80.f2403a.i(ActivityFpsSessions.this, (16 & 2) != 0 ? "" : "使用流量上传？", (16 & 4) != 0 ? "" : "你的设备似乎没有连接到WIFI，继续上传数据可能产生流量费用", (16 & 8) != 0 ? null : new jb1(this), (16 & 16) != 0 ? null : null);
        }
        this.f6590a.c();
    }
}
