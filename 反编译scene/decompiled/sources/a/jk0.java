package a;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jk0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g82 f6519a;

    public jk0(g82 g82Var) {
        this.f6519a = g82Var;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string;
        g82 g82Var = this.f6519a;
        if (editable == null || (string = editable.toString()) == null) {
            string = "";
        }
        g82Var.f(string);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
