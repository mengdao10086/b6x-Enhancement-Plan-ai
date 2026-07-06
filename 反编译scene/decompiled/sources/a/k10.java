package a;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k10 implements TextInputLayout.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q10 f6563a;

    public k10(q10 q10Var) {
        this.f6563a = q10Var;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.g
    public void a(TextInputLayout textInputLayout, int i) {
        EditText editText = textInputLayout.getEditText();
        if (editText == null || i != 2) {
            return;
        }
        editText.removeTextChangedListener(this.f6563a.f2524a);
        if (editText.getOnFocusChangeListener() == this.f6563a.f2525a) {
            editText.setOnFocusChangeListener(null);
        }
    }
}
