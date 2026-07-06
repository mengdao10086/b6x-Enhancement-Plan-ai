package a;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mn1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l92 f6826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ln1 f1961a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1962a;

    public mn1(l92 l92Var, ln1 ln1Var, TextView textView) {
        this.f6826a = l92Var;
        this.f1961a = ln1Var;
        this.f1962a = textView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f6826a.f6687a > this.f1961a.a()) {
            l92 l92Var = this.f6826a;
            l92Var.f6687a--;
        }
        this.f1962a.setText(String.valueOf(this.f6826a.f6687a));
    }
}
