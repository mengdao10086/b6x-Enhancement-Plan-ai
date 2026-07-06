package a;

import a.p80;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7132a;

    public pn1(Context context) {
        f92.d(context, "context");
        this.f7132a = context;
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [T, a.p80$b] */
    public final void a(ln1 ln1Var) {
        f92.d(ln1Var, "dialogRequest");
        n92 n92Var = new n92();
        n92Var.f6891a = null;
        View viewInflate = LayoutInflater.from(this.f7132a).inflate(2131558532, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(t61.number_input_value);
        l92 l92Var = new l92();
        l92Var.f6687a = ln1Var.d();
        ((ImageButton) viewInflate.findViewById(t61.number_input_minus)).setOnClickListener(new mn1(l92Var, ln1Var, textView));
        ((ImageButton) viewInflate.findViewById(t61.number_input_plus)).setOnClickListener(new nn1(l92Var, ln1Var, textView));
        ((TextView) viewInflate.findViewById(t61.number_input_help)).setText(String.valueOf(ln1Var.a()) + " ~ " + String.valueOf(ln1Var.c()));
        textView.setText(String.valueOf(ln1Var.d()));
        p80.a aVar = p80.f2403a;
        Context context = this.f7132a;
        String string = context.getString(2131886519);
        f92.c(string, "context.getString(R.string.btn_confirm)");
        n92Var.f6891a = p80.a.j(aVar, context, viewInflate, new q80(string, new on1(textView, l92Var, ln1Var, n92Var), false), null, 8, null);
    }
}
