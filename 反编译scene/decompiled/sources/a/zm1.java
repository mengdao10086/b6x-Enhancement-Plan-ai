package a;

import a.p80;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final om1 f8082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p80.b f3868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final u90 f3869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3870a;

    public zm1(Context context, u90 u90Var, om1 om1Var) {
        f92.d(context, "context");
        f92.d(u90Var, "progressBarDialog");
        f92.d(om1Var, "callback");
        this.f3870a = context;
        this.f3869a = u90Var;
        this.f8082a = om1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, android.widget.Button] */
    public final void f(String str) {
        AlertDialog alertDialogE;
        p80.b bVar = this.f3868a;
        if (bVar == null || (alertDialogE = bVar.e()) == null) {
            return;
        }
        n92 n92Var = new n92();
        Window window = alertDialogE.getWindow();
        f92.b(window);
        f92.c(window, "this.window!!");
        ?? r0 = (Button) window.getDecorView().findViewById(2131362070);
        n92Var.f6891a = r0;
        Button button = (Button) r0;
        f92.c(button, "btn");
        Object tag = button.getTag();
        if ((tag != null ? tag.toString() : null) == str) {
            return;
        }
        Button button2 = (Button) n92Var.f6891a;
        f92.c(button2, "btn");
        button2.setTag(str);
        if (h(str)) {
            qc2.d(xd2.a(qe2.b()), null, null, new rm1(alertDialogE, n92Var, null, this, str), 3, null);
        } else {
            ((Button) n92Var.f6891a).setText(2131886519);
        }
    }

    public final void g() {
        p80.b bVar = this.f3868a;
        if (bVar != null) {
            bVar.c();
        }
        this.f3868a = null;
    }

    public final boolean h(String str) {
        return new nb2("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$").f(str);
    }

    public final void i(String str, String str2) {
        u90.e(this.f3869a, null, 1, null);
        qc2.d(xd2.a(qe2.b()), null, null, new tm1(this, str, str2, null), 3, null);
    }

    public final void j() {
        g();
        View viewInflate = LayoutInflater.from(this.f3870a).inflate(2131558531, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(t61.dialog_email);
        TextView textView2 = (TextView) viewInflate.findViewById(t61.dialog_password);
        f92.c(textView, "emailInput");
        textView.setText(hz0.f1282a.B0());
        viewInflate.findViewById(t61.reset_pwd).setOnClickListener(new um1(this));
        viewInflate.findViewById(2131363046).setOnClickListener(new vm1(this));
        p80.a aVar = p80.f2403a;
        Context context = this.f3870a;
        String string = context.getString(2131886519);
        f92.c(string, "context.getString(R.string.btn_confirm)");
        p80.b bVarJ = p80.a.j(aVar, context, viewInflate, new q80(string, new wm1(this, textView, textView2), false), null, 8, null);
        bVarJ.i(false);
        this.f3868a = bVarJ;
        textView.setOnFocusChangeListener(new xm1(this, textView));
        textView.setOnEditorActionListener(new ym1(this, textView));
        String string2 = textView.getText().toString();
        if (string2.length() > 0) {
            f(string2);
        }
    }
}
