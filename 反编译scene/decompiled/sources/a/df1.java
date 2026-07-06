package a;

import a.p80;
import android.view.View;
import com.omarea.model.ProcessInfo;
import com.omarea.vtools.activities.ActivityProcess;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class df1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f5893a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ProcessInfo f552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityProcess f553a;

    public df1(ActivityProcess activityProcess, ProcessInfo processInfo, p80.b bVar) {
        this.f553a = activityProcess;
        this.f552a = processInfo;
        this.f5893a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        iz1 iz1Var = new iz1(this.f553a.getBaseContext());
        ProcessInfo processInfo = this.f552a;
        int i = processInfo.pid;
        String str = processInfo.friendlyName;
        f92.c(str, "detail.friendlyName");
        iz1Var.k(i, str);
        this.f5893a.c();
    }
}
