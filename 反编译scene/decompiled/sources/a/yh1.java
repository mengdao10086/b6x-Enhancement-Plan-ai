package a;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yh1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ di1 f7984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f3717a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ EditText c;

    public yh1(di1 di1Var, EditText editText, EditText editText2, EditText editText3) {
        this.f7984a = di1Var;
        this.f3717a = editText;
        this.b = editText2;
        this.c = editText3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3717a.setText(String.valueOf(2160));
        this.b.setText(String.valueOf(this.f7984a.l(2160)));
        this.c.setText(String.valueOf(this.f7984a.k(2160)));
    }
}
