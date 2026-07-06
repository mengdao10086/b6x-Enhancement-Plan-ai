package a;

import android.text.Editable;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l10 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q10 f6663a;

    public l10(q10 q10Var) {
        this.f6663a = q10Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Editable text = ((f20) this.f6663a).f838a.getEditText().getText();
        if (text != null) {
            text.clear();
        }
    }
}
