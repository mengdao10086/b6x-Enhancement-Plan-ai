package h1;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import g.f0;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(19)
public final class c extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f30203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f30204b;

    public static class a {
        public boolean a(@n0 InputConnection inputConnection, @n0 Editable editable, @f0(from = 0) int i10, @f0(from = 0) int i11, boolean z10) {
            return androidx.emoji2.text.e.g(inputConnection, editable, i10, i11, z10);
        }

        public void b(@n0 EditorInfo editorInfo) {
            if (androidx.emoji2.text.e.n()) {
                androidx.emoji2.text.e.b().D(editorInfo);
            }
        }
    }

    public c(@n0 TextView textView, @n0 InputConnection inputConnection, @n0 EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    public final Editable a() {
        return this.f30203a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i10, int i11) {
        return this.f30204b.a(this, a(), i10, i11, false) || super.deleteSurroundingText(i10, i11);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i10, int i11) {
        return this.f30204b.a(this, a(), i10, i11, true) || super.deleteSurroundingTextInCodePoints(i10, i11);
    }

    public c(@n0 TextView textView, @n0 InputConnection inputConnection, @n0 EditorInfo editorInfo, @n0 a aVar) {
        super(inputConnection, false);
        this.f30203a = textView;
        this.f30204b = aVar;
        aVar.b(editorInfo);
    }
}
