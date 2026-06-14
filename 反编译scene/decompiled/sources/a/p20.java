package a;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p20 extends f20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextWatcher f7076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextInputLayout.f f2375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextInputLayout.g f2376a;

    public p20(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f7076a = new l20(this);
        this.f2375a = new m20(this);
        this.f2376a = new n20(this);
    }

    public static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    @Override // a.f20
    public void a() {
        ((f20) this).f838a.setEndIconDrawable(r2.d(((f20) this).f6066a, cv.design_password_eye));
        TextInputLayout textInputLayout = ((f20) this).f838a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(hv.password_toggle_content_description));
        ((f20) this).f838a.setEndIconOnClickListener(new o20(this));
        ((f20) this).f838a.e(this.f2375a);
        ((f20) this).f838a.f(this.f2376a);
        EditText editText = ((f20) this).f838a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public final boolean g() {
        EditText editText = ((f20) this).f838a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
