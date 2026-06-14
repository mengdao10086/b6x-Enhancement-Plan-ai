package a;

import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class c22 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d22 f5754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ StringBuilder f325a;

    public c22(d22 d22Var, StringBuilder sb) {
        this.f5754a = d22Var;
        this.f325a = sb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView = this.f5754a.f463a;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        TextView textView2 = this.f5754a.f463a;
        if (textView2 != null) {
            textView2.setText(ec2.r0(this.f325a));
        }
    }
}
