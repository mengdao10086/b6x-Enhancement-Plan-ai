package a;

import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qh1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rh1 f7213a;

    public qh1(rh1 rh1Var) {
        this.f7213a = rh1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            TextView textView = this.f7213a.f2744a;
            f92.c(textView, "timeoutView");
            textView.setText(String.valueOf(this.f7213a.f7300a.f6687a));
        } catch (Exception unused) {
        }
    }
}
