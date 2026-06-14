package a;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gg0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hg0 f6204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f1007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1008a;

    public gg0(hg0 hg0Var, TextView textView, EditText editText) {
        this.f6204a = hg0Var;
        this.f1008a = textView;
        this.f1007a = editText;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        cg0 cg0Var = this.f6204a.f6310a;
        if (cg0Var != null) {
            cg0Var.openFileChooser(new fg0(this));
        }
    }
}
