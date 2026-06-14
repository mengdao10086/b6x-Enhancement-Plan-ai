package a;

import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ny1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ py1 f6958a;

    public ny1(py1 py1Var) {
        this.f6958a = py1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView = this.f6958a.f2476a;
        if (textView != null) {
            textView.setText("--");
        }
    }
}
