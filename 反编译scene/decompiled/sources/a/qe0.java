package a;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qe0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ se0 f7203a;

    public qe0(se0 se0Var) {
        this.f7203a = se0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            Context contextP = this.f7203a.p();
            f92.b(contextP);
            Object systemService = contextP.getSystemService("clipboard");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            TextView textView = (TextView) this.f7203a.D1(mb0.shell_output);
            f92.c(textView, "shell_output");
            ClipData clipDataNewPlainText = ClipData.newPlainText("text", textView.getText().toString());
            f92.c(clipDataNewPlainText, "ClipData.newPlainText(\"t…l_output.text.toString())");
            ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
            Toast.makeText(this.f7203a.p(), this.f7203a.J(ob0.copy_success), 0).show();
        } catch (Exception unused) {
            Toast.makeText(this.f7203a.p(), this.f7203a.J(ob0.copy_fail), 0).show();
        }
    }
}
