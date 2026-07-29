package h1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.e;
import g.p0;
import g.v0;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(19)
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f30216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f30217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e.f f30218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f30219d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f30220e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f30221f = true;

    @v0(19)
    public static class a extends e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference<EditText> f30222a;

        public a(EditText editText) {
            this.f30222a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.e.f
        public void b() {
            super.b();
            g.e(this.f30222a.get(), 1);
        }
    }

    public g(EditText editText, boolean z10) {
        this.f30216a = editText;
        this.f30217b = z10;
    }

    public static void e(@p0 EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.e.b().u(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    public int a() {
        return this.f30220e;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    public final e.f b() {
        if (this.f30218c == null) {
            this.f30218c = new a(this.f30216a);
        }
        return this.f30218c;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public int c() {
        return this.f30219d;
    }

    public boolean d() {
        return this.f30221f;
    }

    public void f(int i10) {
        this.f30220e = i10;
    }

    public void g(boolean z10) {
        if (this.f30221f != z10) {
            if (this.f30218c != null) {
                androidx.emoji2.text.e.b().C(this.f30218c);
            }
            this.f30221f = z10;
            if (z10) {
                e(this.f30216a, androidx.emoji2.text.e.b().f());
            }
        }
    }

    public void h(int i10) {
        this.f30219d = i10;
    }

    public final boolean i() {
        return (this.f30221f && (this.f30217b || androidx.emoji2.text.e.n())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (this.f30216a.isInEditMode() || i() || i11 > i12 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iF = androidx.emoji2.text.e.b().f();
        if (iF != 0) {
            if (iF == 1) {
                androidx.emoji2.text.e.b().x((Spannable) charSequence, i10, i10 + i12, this.f30219d, this.f30220e);
                return;
            } else if (iF != 3) {
                return;
            }
        }
        androidx.emoji2.text.e.b().y(b());
    }
}
