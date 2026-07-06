package a;

import android.widget.Toast;
import com.omarea.krscript.model.AutoRunTask;
import com.omarea.vtools.activities.ActivityActionPage;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d71 implements AutoRunTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e71 f5868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f503a;

    public d71(e71 e71Var) {
        this.f5868a = e71Var;
        this.f503a = ActivityActionPage.this.f5095a;
    }

    @Override // com.omarea.krscript.model.AutoRunTask
    public String getKey() {
        return this.f503a;
    }

    @Override // com.omarea.krscript.model.AutoRunTask
    public void onCompleted(Boolean bool) {
        if (!f92.a(bool, Boolean.TRUE)) {
            ActivityActionPage activityActionPage = ActivityActionPage.this;
            Toast.makeText(activityActionPage, activityActionPage.getString(2131886894), 0).show();
        }
    }
}
