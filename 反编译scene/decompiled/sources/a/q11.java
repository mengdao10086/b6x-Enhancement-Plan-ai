package a;

import android.view.View;
import android.widget.Button;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q11 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n11 f2528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Button f2529a;

    public q11(Button button, n11 n11Var, int i) {
        this.f2529a = button;
        this.f2528a = n11Var;
        this.f7168a = i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        m11 m11Var = this.f2528a.b;
        if (m11Var == null) {
            return true;
        }
        m11Var.a(this.f2529a, this.f7168a);
        return true;
    }
}
