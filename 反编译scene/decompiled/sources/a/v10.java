package a;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class v10 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e20 f7648a;

    public v10(e20 e20Var) {
        this.f7648a = e20Var;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        e20 e20Var = this.f7648a;
        AutoCompleteTextView autoCompleteTextViewX = e20Var.x(((f20) e20Var).f838a.getEditText());
        autoCompleteTextViewX.post(new t10(this, autoCompleteTextViewX));
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
