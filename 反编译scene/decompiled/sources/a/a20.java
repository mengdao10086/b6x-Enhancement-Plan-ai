package a;

import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a20 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e20 f5561a;

    public a20(e20 e20Var) {
        this.f5561a = e20Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5561a.F((AutoCompleteTextView) ((f20) this.f5561a).f838a.getEditText());
    }
}
