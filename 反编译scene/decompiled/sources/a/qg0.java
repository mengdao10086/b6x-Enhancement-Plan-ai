package a;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qg0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rg0 f7210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f2568a;
    public final /* synthetic */ TextView b;

    public qg0(rg0 rg0Var, TextView textView, TextView textView2) {
        this.f7210a = rg0Var;
        this.f2568a = textView;
        this.b = textView2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        rg0 rg0Var = this.f7210a;
        TextView textView = this.f2568a;
        f92.c(textView, "valueView");
        TextView textView2 = this.b;
        f92.c(textView2, "textView");
        rg0Var.c(textView, textView2);
    }
}
