package a;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o20 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p20 f6973a;

    public o20(p20 p20Var) {
        this.f6973a = p20Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText = ((f20) this.f6973a).f838a.getEditText();
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        editText.setTransformationMethod(this.f6973a.g() ? null : PasswordTransformationMethod.getInstance());
        if (selectionEnd >= 0) {
            editText.setSelection(selectionEnd);
        }
    }
}
