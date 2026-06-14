package a;

import android.view.View;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i21 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l21 f6370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n50 f1305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1306a;

    public i21(l21 l21Var, n50 n50Var, View view) {
        this.f6370a = l21Var;
        this.f1305a = n50Var;
        this.f1306a = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f1305a.c()) {
            Toast.makeText(this.f1306a.getContext(), this.f1306a.getContext().getString(u61.file_not_found), 0).show();
            return;
        }
        if (this.f1305a.g() && (this.f1305a.f() > 0 || this.f1305a.a() > 0)) {
            this.f6370a.j(this.f1305a);
        } else {
            View view2 = this.f1306a;
            Snackbar.W(view2, view2.getContext().getString(u61.file_dir_empty), -1).M();
        }
    }
}
