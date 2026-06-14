package a;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jg0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kg0 f6506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1533a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ TextView c;

    public jg0(kg0 kg0Var, TextView textView, TextView textView2, TextView textView3) {
        this.f6506a = kg0Var;
        this.f1533a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        kg0 kg0Var = this.f6506a;
        TextView textView = this.f1533a;
        f92.c(textView, "textView");
        TextView textView2 = this.b;
        f92.c(textView2, "valueView");
        TextView textView3 = this.c;
        f92.c(textView3, "countView");
        kg0Var.d(textView, textView2, textView3);
    }
}
