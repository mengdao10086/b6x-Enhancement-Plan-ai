package a;

import android.widget.AutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class z10 implements TextInputLayout.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e20 f8026a;

    public z10(e20 e20Var) {
        this.f8026a = e20Var;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.g
    public void a(TextInputLayout textInputLayout, int i) {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
        if (autoCompleteTextView == null || i != 3) {
            return;
        }
        autoCompleteTextView.removeTextChangedListener(this.f8026a.f643a);
        if (autoCompleteTextView.getOnFocusChangeListener() == this.f8026a.f644a) {
            autoCompleteTextView.setOnFocusChangeListener(null);
        }
        autoCompleteTextView.setOnTouchListener(null);
        if (e20.c) {
            autoCompleteTextView.setOnDismissListener(null);
        }
    }
}
