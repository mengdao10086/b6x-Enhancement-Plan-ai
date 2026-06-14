package a;

import a.p80;
import android.view.View;
import com.omarea.model.ProcessInfo;
import com.omarea.vtools.activities.ActivityProcess;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class if1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ProcessInfo f1359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityProcess f1360a;

    public if1(ActivityProcess activityProcess, ProcessInfo processInfo, p80.b bVar) {
        this.f1360a = activityProcess;
        this.f1359a = processInfo;
        this.f6406a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1360a.f5463a.e(this.f1359a);
        this.f6406a.c();
    }
}
