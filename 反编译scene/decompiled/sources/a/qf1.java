package a;

import android.widget.TextView;
import com.omarea.vtools.activities.ActivityStartSplash;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qf1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityStartSplash.a f7208a;

    public qf1(ActivityStartSplash.a aVar) {
        this.f7208a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView = (TextView) this.f7208a.f8871a._$_findCachedViewById(t61.start_state_text);
        f92.c(textView, "context.start_state_text");
        textView.setText(this.f7208a.f8871a.getString(u61.scene_permissions_checking));
        this.f7208a.f8871a.P();
    }
}
