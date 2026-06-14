package a;

import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ll1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ml1 f6720a;

    public ll1(ml1 ml1Var) {
        this.f6720a = ml1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ml1 ml1Var = this.f6720a;
        int i = 2;
        ml1Var.f1947a.f6785a = ml1Var.f1948a.f2112a.getLongProperty(2);
        try {
            long j = this.f6720a.f1947a.f6785a / ((long) this.f6720a.f1946a.f6687a);
            if (!this.f6720a.f6820a.b) {
                i = 1;
            }
            long j2 = j * ((long) i);
            TextView textView = this.f6720a.f1950a;
            StringBuilder sb = new StringBuilder();
            sb.append(j2 >= 0 ? "+" : "");
            sb.append(j2);
            sb.append("mA");
            textView.setText(sb.toString());
        } catch (Exception unused) {
        }
    }
}
