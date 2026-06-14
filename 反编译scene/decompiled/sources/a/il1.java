package a;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class il1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i92 f6425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l92 f1382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ m92 f1383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1384a;
    public final /* synthetic */ TextView b;

    public il1(l92 l92Var, TextView textView, m92 m92Var, i92 i92Var, TextView textView2) {
        this.f1382a = l92Var;
        this.f1384a = textView;
        this.f1383a = m92Var;
        this.f6425a = i92Var;
        this.b = textView2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        l92 l92Var = this.f1382a;
        int i2 = l92Var.f6687a;
        if (i2 == -1) {
            l92Var.f6687a = 1;
        } else {
            if (i2 < 0) {
                i = i2 / 10;
            } else if (i2 < 100000000) {
                i = i2 * 10;
            }
            l92Var.f6687a = i;
        }
        this.f1384a.setText(String.valueOf(this.f1382a.f6687a));
        long j = (this.f1383a.f6785a / ((long) this.f1382a.f6687a)) * ((long) (this.f6425a.b ? 2 : 1));
        TextView textView = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append(j >= 0 ? "+" : "");
        sb.append(j);
        sb.append("mA");
        textView.setText(sb.toString());
    }
}
