package a;

import a.p80;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k21 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l21 f6566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n50 f1600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1601a;

    public k21(l21 l21Var, View view, n50 n50Var) {
        this.f6566a = l21Var;
        this.f1601a = view;
        this.f1600a = n50Var;
    }

    public static /* synthetic */ void b() {
    }

    public /* synthetic */ void a(n50 n50Var, View view) {
        if (!n50Var.c()) {
            Toast.makeText(view.getContext(), view.getContext().getString(u61.file_not_found), 0).show();
        } else {
            this.f6566a.b = n50Var;
            this.f6566a.f1726b.run();
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        p80.a aVar = p80.f2403a;
        Context context = this.f1601a.getContext();
        String string = this.f1601a.getContext().getString(u61.file_delete_selected);
        String strB = this.f1600a.b();
        final n50 n50Var = this.f1600a;
        final View view2 = this.f1601a;
        aVar.i(context, string, strB, new Runnable() { // from class: a.rz0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7345a.a(n50Var, view2);
            }
        }, new Runnable() { // from class: a.sz0
            @Override // java.lang.Runnable
            public final void run() {
                k21.b();
            }
        });
        return true;
    }
}
