package a;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kd0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ he0 f6595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ nd0 f1619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AlertDialog f1620a;

    public kd0(nd0 nd0Var, he0 he0Var, AlertDialog alertDialog) {
        this.f1619a = nd0Var;
        this.f6595a = he0Var;
        this.f1620a = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f1619a.f6902a.f7008a.J1(this.f1619a.f6902a.f2231a, this.f1619a.f6902a.f2233a, this.f1619a.f6902a.f2232a, this.f6595a.c(this.f1619a.f6902a.f2234a));
            AlertDialog alertDialog = this.f1620a;
            f92.b(alertDialog);
            alertDialog.dismiss();
        } catch (Exception e) {
            Context contextP = this.f1619a.f6902a.f7008a.p();
            f92.b(contextP);
            Toast.makeText(contextP, "" + e.getMessage(), 1).show();
        }
    }
}
