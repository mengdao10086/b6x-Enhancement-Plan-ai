package a;

import a.p80;
import android.view.View;
import com.omarea.model.ProcessInfo;
import com.omarea.vtools.activities.ActivityProcess;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lf1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6702a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ProcessInfo f1797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityProcess f1798a;

    public lf1(ActivityProcess activityProcess, ProcessInfo processInfo, p80.b bVar) {
        this.f1798a = activityProcess;
        this.f1797a = processInfo;
        this.f6702a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1798a.f5463a.c(this.f1797a.pid);
        this.f6702a.c();
    }
}
