package a;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gl1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i92 f6219a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l92 f1033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ m92 f1034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1035a;

    public gl1(i92 i92Var, m92 m92Var, l92 l92Var, TextView textView) {
        this.f6219a = i92Var;
        this.f1034a = m92Var;
        this.f1033a = l92Var;
        this.f1035a = textView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i92 i92Var = this.f6219a;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        i92Var.b = ((CompoundButton) view).isChecked();
        long j = (this.f1034a.f6785a / ((long) this.f1033a.f6687a)) * ((long) (this.f6219a.b ? 2 : 1));
        TextView textView = this.f1035a;
        StringBuilder sb = new StringBuilder();
        sb.append(j >= 0 ? "+" : "");
        sb.append(j);
        sb.append("mA");
        textView.setText(sb.toString());
    }
}
