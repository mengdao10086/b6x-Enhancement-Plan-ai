package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import g.n0;
import g.v0;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes2.dex */
public class r implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5590a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public Spannable f5591b;

    @v0(24)
    public static class a {
        public static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        public static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    public static class b {
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof y0.g;
        }
    }

    @v0(28)
    public static class c extends b {
        @Override // androidx.emoji2.text.r.b
        public boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof y0.g);
        }
    }

    public r(@n0 Spannable spannable) {
        this.f5591b = spannable;
    }

    public static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    public final void a() {
        Spannable spannable = this.f5591b;
        if (!this.f5590a && c().a(spannable)) {
            this.f5591b = new SpannableString(spannable);
        }
        this.f5590a = true;
    }

    public Spannable b() {
        return this.f5591b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f5591b.charAt(i10);
    }

    @Override // java.lang.CharSequence
    @n0
    @v0(api = 24)
    public IntStream chars() {
        return a.a(this.f5591b);
    }

    @Override // java.lang.CharSequence
    @n0
    @v0(api = 24)
    public IntStream codePoints() {
        return a.b(this.f5591b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f5591b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f5591b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f5591b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f5591b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f5591b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f5591b.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f5591b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f5591b.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    @n0
    public CharSequence subSequence(int i10, int i11) {
        return this.f5591b.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    @n0
    public String toString() {
        return this.f5591b.toString();
    }

    public r(@n0 Spanned spanned) {
        this.f5591b = new SpannableString(spanned);
    }

    public r(@n0 CharSequence charSequence) {
        this.f5591b = new SpannableString(charSequence);
    }
}
