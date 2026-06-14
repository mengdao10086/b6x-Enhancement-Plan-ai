package a;

import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n20 implements TextInputLayout.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p20 f6866a;

    public n20(p20 p20Var) {
        this.f6866a = p20Var;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.g
    public void a(TextInputLayout textInputLayout, int i) {
        EditText editText = textInputLayout.getEditText();
        if (editText == null || i != 1) {
            return;
        }
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editText.removeTextChangedListener(this.f6866a.f7076a);
    }
}
