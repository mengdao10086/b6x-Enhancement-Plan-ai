package a;

import android.graphics.drawable.Drawable;
import android.widget.AutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class y10 implements TextInputLayout.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e20 f7940a;

    public y10(e20 e20Var) {
        this.f7940a = e20Var;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.f
    public void a(TextInputLayout textInputLayout) {
        AutoCompleteTextView autoCompleteTextViewX = this.f7940a.x(textInputLayout.getEditText());
        this.f7940a.D(autoCompleteTextViewX);
        this.f7940a.u(autoCompleteTextViewX);
        this.f7940a.E(autoCompleteTextViewX);
        autoCompleteTextViewX.setThreshold(0);
        autoCompleteTextViewX.removeTextChangedListener(this.f7940a.f643a);
        autoCompleteTextViewX.addTextChangedListener(this.f7940a.f643a);
        textInputLayout.setEndIconCheckable(true);
        textInputLayout.setErrorIconDrawable((Drawable) null);
        textInputLayout.setTextInputAccessibilityDelegate(this.f7940a.f646a);
        textInputLayout.setEndIconVisible(true);
    }
}
