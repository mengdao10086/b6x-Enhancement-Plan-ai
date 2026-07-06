package a;

import android.text.Editable;
import android.widget.EditText;
import com.omarea.vtools.activities.ActivityAppActivities;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f7666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppActivities.b f3259a;

    public v71(ActivityAppActivities.b bVar, long j) {
        this.f3259a = bVar;
        this.f7666a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityAppActivities.b bVar = this.f3259a;
        if (bVar.f8485a.f6785a == this.f7666a) {
            ActivityAppActivities activityAppActivities = ActivityAppActivities.this;
            EditText editText = (EditText) activityAppActivities._$_findCachedViewById(t61.apps_search_box);
            f92.c(editText, "apps_search_box");
            Editable text = editText.getText();
            f92.c(text, "apps_search_box.text");
            activityAppActivities.k(text);
        }
    }
}
