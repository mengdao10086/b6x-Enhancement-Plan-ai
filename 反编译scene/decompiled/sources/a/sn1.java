package a;

import a.p80;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p80.b f7416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qn1 f2908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2909a;

    public sn1(Context context, qn1 qn1Var) {
        f92.d(context, "context");
        f92.d(qn1Var, "callback");
        this.f2909a = context;
        this.f2908a = qn1Var;
    }

    public final void c() {
        p80.b bVar = this.f7416a;
        if (bVar != null) {
            bVar.c();
        }
        this.f7416a = null;
    }

    public final void d() {
        c();
        View viewInflate = LayoutInflater.from(this.f2909a).inflate(2131558533, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(t61.dialog_email);
        TextView textView2 = (TextView) viewInflate.findViewById(t61.dialog_password);
        f92.c(textView, "emailInput");
        textView.setText(hz0.f1282a.B0());
        p80.a aVar = p80.f2403a;
        Context context = this.f2909a;
        String string = context.getString(2131886519);
        f92.c(string, "context.getString(R.string.btn_confirm)");
        this.f7416a = p80.a.j(aVar, context, viewInflate, new q80(string, new rn1(this, textView, textView2), false), null, 8, null);
    }
}
