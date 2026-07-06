package a;

import android.widget.TextView;
import com.omarea.vtools.activities.ActivityQuickStart;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nf1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityQuickStart f6910a;

    public nf1(ActivityQuickStart activityQuickStart) {
        this.f6910a = activityQuickStart;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView = (TextView) this.f6910a.a(t61.start_state_text);
        f92.c(textView, "start_state_text");
        textView.setText(this.f6910a.getString(u61.freezer_qs_starting));
    }
}
