package a;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j10 implements TextInputLayout.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q10 f6462a;

    public j10(q10 q10Var) {
        this.f6462a = q10Var;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.f
    public void a(TextInputLayout textInputLayout) {
        EditText editText = textInputLayout.getEditText();
        textInputLayout.setEndIconVisible(editText.hasFocus() && q10.l(editText.getText()));
        textInputLayout.setEndIconCheckable(false);
        editText.setOnFocusChangeListener(this.f6462a.f2525a);
        editText.removeTextChangedListener(this.f6462a.f2524a);
        editText.addTextChangedListener(this.f6462a.f2524a);
    }
}
