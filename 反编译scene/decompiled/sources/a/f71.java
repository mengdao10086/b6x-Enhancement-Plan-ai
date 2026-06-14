package a;

import android.widget.Toast;
import com.omarea.vtools.activities.ActivityActionPage;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class f71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityActionPage.c f6080a;

    public f71(ActivityActionPage.c cVar) {
        this.f6080a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityActionPage activityActionPage = ActivityActionPage.this;
        Toast.makeText(activityActionPage, activityActionPage.getString(2131886981), 0).show();
    }
}
