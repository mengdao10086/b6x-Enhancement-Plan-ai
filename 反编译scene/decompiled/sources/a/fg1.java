package a;

import android.widget.Button;
import com.omarea.vtools.activities.ActivityStartSplash;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fg1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityStartSplash.n f6103a;

    public fg1(ActivityStartSplash.n nVar) {
        this.f6103a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Button button;
        String string;
        try {
            if (this.f6103a.f8883a.f6687a > 0) {
                l92 l92Var = this.f6103a.f8883a;
                l92Var.f6687a--;
                button = this.f6103a.f5495a;
                f92.c(button, "btnConfirm");
                string = String.valueOf(this.f6103a.f8883a.f6687a) + "s";
            } else {
                this.f6103a.f5497a.cancel();
                button = this.f6103a.f5495a;
                f92.c(button, "btnConfirm");
                string = ActivityStartSplash.this.getString(u61.agree);
            }
            button.setText(string);
        } catch (Exception unused) {
        }
    }
}
