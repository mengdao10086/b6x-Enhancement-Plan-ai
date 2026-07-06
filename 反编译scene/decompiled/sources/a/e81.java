package a;

import android.widget.EditText;
import com.omarea.vtools.activities.ActivityAppContents;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e81 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f5978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppContents.e f706a;

    public e81(ActivityAppContents.e eVar, long j) {
        this.f706a = eVar;
        this.f5978a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityAppContents.e eVar = this.f706a;
        if (eVar.f8514a.f6785a == this.f5978a) {
            ActivityAppContents activityAppContents = ActivityAppContents.this;
            EditText editText = (EditText) activityAppContents._$_findCachedViewById(t61.apps_search_box);
            f92.c(editText, "apps_search_box");
            activityAppContents.w(editText.getText().toString());
        }
    }
}
