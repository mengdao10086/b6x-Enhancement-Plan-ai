package a;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m20 implements TextInputLayout.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p20 f6761a;

    public m20(p20 p20Var) {
        this.f6761a = p20Var;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.f
    public void a(TextInputLayout textInputLayout) {
        EditText editText = textInputLayout.getEditText();
        textInputLayout.setEndIconVisible(true);
        textInputLayout.setEndIconCheckable(true);
        ((f20) this.f6761a).f837a.setChecked(!r4.g());
        editText.removeTextChangedListener(this.f6761a.f7076a);
        editText.addTextChangedListener(this.f6761a.f7076a);
    }
}
