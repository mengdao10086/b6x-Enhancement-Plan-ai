package a;

import android.text.Editable;
import android.widget.EditText;
import com.omarea.vtools.activities.ActivityApplications;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v81 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f7669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityApplications.e f3260a;

    public v81(ActivityApplications.e eVar, long j) {
        this.f3260a = eVar;
        this.f7669a = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ActivityApplications.e eVar = this.f3260a;
        if (eVar.f8565a.f6785a == this.f7669a) {
            ActivityApplications activityApplications = ActivityApplications.this;
            EditText editText = (EditText) activityApplications._$_findCachedViewById(t61.apps_search_box);
            f92.c(editText, "apps_search_box");
            Editable text = editText.getText();
            f92.c(text, "apps_search_box.text");
            activityApplications.p(text, (hr1) this.f3260a.f5180a.f6891a);
        }
    }
}
