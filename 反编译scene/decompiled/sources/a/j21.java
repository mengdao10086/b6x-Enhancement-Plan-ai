package a;

import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j21 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l21 f6466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n50 f1496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1497a;

    public j21(l21 l21Var, View view, n50 n50Var) {
        this.f6466a = l21Var;
        this.f1497a = view;
        this.f1496a = n50Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f1496a.c()) {
            Toast.makeText(this.f1497a.getContext(), "所选的文件已被删除，请重新选择！", 0).show();
            return;
        }
        this.f6466a.b = this.f1496a;
        this.f6466a.f1723a.run();
    }
}
