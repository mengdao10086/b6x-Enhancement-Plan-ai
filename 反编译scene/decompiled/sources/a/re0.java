package a;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.omarea.krscript.model.RunnableNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class re0 implements je0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ se0 f2733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RunnableNode f2734a;

    public re0(se0 se0Var, RunnableNode runnableNode, n92 n92Var) {
        this.f2733a = se0Var;
        this.f2734a = runnableNode;
        this.f7292a = n92Var;
    }

    @Override // a.je0
    public void a() {
        if (this.f2734a.getAutoOff()) {
            this.f2733a.O1();
        }
    }

    @Override // a.je0
    public void b() {
        this.f2733a.y = false;
        se0.F1(this.f2733a).run();
        if (((ImageButton) this.f2733a.D1(mb0.btn_hide)) != null) {
            ImageButton imageButton = (ImageButton) this.f2733a.D1(mb0.btn_hide);
            f92.c(imageButton, "btn_hide");
            imageButton.setVisibility(8);
            Button button = (Button) this.f2733a.D1(mb0.btn_exit);
            f92.c(button, "btn_exit");
            button.setVisibility(0);
            ProgressBar progressBar = (ProgressBar) this.f2733a.D1(mb0.action_progress);
            f92.c(progressBar, "action_progress");
            progressBar.setVisibility(8);
        }
        this.f2733a.z1(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.je0
    public void c(Runnable runnable) {
        Button button;
        int i;
        this.f2733a.y = true;
        if (!this.f2734a.getInterruptable() || runnable == 0) {
            button = (Button) this.f2733a.D1(mb0.btn_exit);
            f92.c(button, "btn_exit");
            i = 8;
        } else {
            button = (Button) this.f2733a.D1(mb0.btn_exit);
            f92.c(button, "btn_exit");
            i = 0;
        }
        button.setVisibility(i);
        this.f7292a.f6891a = runnable;
    }
}
