package a;

import android.widget.TextView;
import com.omarea.vtools.activities.ActivityStartSplash;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vf1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityStartSplash.h f7691a;

    public vf1(ActivityStartSplash.h hVar) {
        this.f7691a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView = (TextView) ActivityStartSplash.this._$_findCachedViewById(t61.start_state_text);
        f92.c(textView, "start_state_text");
        textView.setText(ActivityStartSplash.this.getString(u61.user_activate_sync));
    }
}
