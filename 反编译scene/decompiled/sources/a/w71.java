package a;

import android.text.Editable;
import android.widget.EditText;
import com.omarea.vtools.activities.ActivityAppComponents;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f7763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppComponents.b f3403a;

    public w71(ActivityAppComponents.b bVar, long j) {
        this.f3403a = bVar;
        this.f7763a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityAppComponents.b bVar = this.f3403a;
        if (bVar.f8494a.f6785a == this.f7763a) {
            ActivityAppComponents activityAppComponents = ActivityAppComponents.this;
            EditText editText = (EditText) activityAppComponents._$_findCachedViewById(t61.apps_search_box);
            f92.c(editText, "apps_search_box");
            Editable text = editText.getText();
            f92.c(text, "apps_search_box.text");
            activityAppComponents.m(text);
        }
    }
}
