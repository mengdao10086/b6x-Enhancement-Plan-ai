package h1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.e;
import g.n0;
import g.p0;
import g.v0;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(19)
public final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f30205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e.f f30206b;

    @v0(19)
    public static class a extends e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference<TextView> f30207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Reference<d> f30208b;

        public a(TextView textView, d dVar) {
            this.f30207a = new WeakReference(textView);
            this.f30208b = new WeakReference(dVar);
        }

        @Override // androidx.emoji2.text.e.f
        public void b() {
            CharSequence text;
            CharSequence charSequenceU;
            super.b();
            TextView textView = this.f30207a.get();
            if (c(textView, this.f30208b.get()) && textView.isAttachedToWindow() && text != (charSequenceU = androidx.emoji2.text.e.b().u((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceU);
                int selectionEnd = Selection.getSelectionEnd(charSequenceU);
                textView.setText(charSequenceU);
                if (charSequenceU instanceof Spannable) {
                    d.b((Spannable) charSequenceU, selectionStart, selectionEnd);
                }
            }
        }

        public final boolean c(@p0 TextView textView, @p0 InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(@n0 TextView textView) {
        this.f30205a = textView;
    }

    public static void b(Spannable spannable, int i10, int i11) {
        if (i10 >= 0 && i11 >= 0) {
            Selection.setSelection(spannable, i10, i11);
        } else if (i10 >= 0) {
            Selection.setSelection(spannable, i10);
        } else if (i11 >= 0) {
            Selection.setSelection(spannable, i11);
        }
    }

    public final e.f a() {
        if (this.f30206b == null) {
            this.f30206b = new a(this.f30205a, this);
        }
        return this.f30206b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        if (this.f30205a.isInEditMode()) {
            return charSequence;
        }
        int iF = androidx.emoji2.text.e.b().f();
        if (iF != 0) {
            boolean z10 = true;
            if (iF == 1) {
                if (i13 == 0 && i12 == 0 && spanned.length() == 0 && charSequence == this.f30205a.getText()) {
                    z10 = false;
                }
                if (!z10 || charSequence == null) {
                    return charSequence;
                }
                if (i10 != 0 || i11 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i10, i11);
                }
                return androidx.emoji2.text.e.b().v(charSequence, 0, charSequence.length());
            }
            if (iF != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.e.b().y(a());
        return charSequence;
    }
}
