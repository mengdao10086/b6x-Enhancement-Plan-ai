package a;

import android.widget.TextView;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oy1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ double f7066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ py1 f2343a;

    public oy1(py1 py1Var, double d) {
        this.f2343a = py1Var;
        this.f7066a = d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView = this.f2343a.f2476a;
        if (textView != null) {
            q92 q92Var = q92.f7191a;
            String str = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(this.f7066a)}, 1));
            f92.c(str, "java.lang.String.format(format, *args)");
            textView.setText(str);
        }
    }
}
