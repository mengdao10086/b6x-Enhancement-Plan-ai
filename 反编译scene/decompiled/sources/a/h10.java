package a;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h10 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q10 f6262a;

    public h10(q10 q10Var) {
        this.f6262a = q10Var;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (((f20) this.f6262a).f838a.getSuffixText() != null) {
            return;
        }
        this.f6262a.i(q10.l(editable));
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
