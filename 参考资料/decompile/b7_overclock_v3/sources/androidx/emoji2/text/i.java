package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.e;
import androidx.emoji2.text.o;
import g.f0;
import g.n0;
import g.p0;
import g.v0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@g.d
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(19)
public final class i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5523f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5524g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5525h = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final e.l f5526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final o f5527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public e.InterfaceC0049e f5528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final int[] f5530e;

    @v0(19)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f5531a = -1;

        public static int a(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    i10--;
                    if (i10 < 0) {
                        return z10 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i11--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i11--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z10 = true;
                    }
                }
                return i10;
            }
        }

        public static int b(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    if (i10 >= length) {
                        if (z10) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i11--;
                        i10++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i11--;
                        i10++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i10++;
                        z10 = true;
                    }
                }
                return i10;
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f5532i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f5533j = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5534a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o.a f5535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o.a f5536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public o.a f5537d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5538e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5539f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f5540g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f5541h;

        public b(o.a aVar, boolean z10, int[] iArr) {
            this.f5535b = aVar;
            this.f5536c = aVar;
            this.f5540g = z10;
            this.f5541h = iArr;
        }

        public static boolean d(int i10) {
            return i10 == 65039;
        }

        public static boolean f(int i10) {
            return i10 == 65038;
        }

        public int a(int i10) {
            o.a aVarA = this.f5536c.a(i10);
            int iG = 3;
            if (this.f5534a == 2) {
                if (aVarA != null) {
                    this.f5536c = aVarA;
                    this.f5539f++;
                } else if (f(i10)) {
                    iG = g();
                } else if (!d(i10)) {
                    if (this.f5536c.b() == null) {
                        iG = g();
                    } else if (this.f5539f != 1 || h()) {
                        this.f5537d = this.f5536c;
                        g();
                    } else {
                        iG = g();
                    }
                }
                iG = 2;
            } else if (aVarA == null) {
                iG = g();
            } else {
                this.f5534a = 2;
                this.f5536c = aVarA;
                this.f5539f = 1;
                iG = 2;
            }
            this.f5538e = i10;
            return iG;
        }

        public h b() {
            return this.f5536c.b();
        }

        public h c() {
            return this.f5537d.b();
        }

        public boolean e() {
            return this.f5534a == 2 && this.f5536c.b() != null && (this.f5539f > 1 || h());
        }

        public final int g() {
            this.f5534a = 1;
            this.f5536c = this.f5535b;
            this.f5539f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.f5536c.b().l() || d(this.f5538e)) {
                return true;
            }
            if (this.f5540g) {
                if (this.f5541h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f5541h, this.f5536c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public i(@n0 o oVar, @n0 e.l lVar, @n0 e.InterfaceC0049e interfaceC0049e, boolean z10, @p0 int[] iArr) {
        this.f5526a = lVar;
        this.f5527b = oVar;
        this.f5528c = interfaceC0049e;
        this.f5529d = z10;
        this.f5530e = iArr;
    }

    public static boolean b(@n0 Editable editable, @n0 KeyEvent keyEvent, boolean z10) {
        j[] jVarArr;
        if (i(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!h(selectionStart, selectionEnd) && (jVarArr = (j[]) editable.getSpans(selectionStart, selectionEnd, j.class)) != null && jVarArr.length > 0) {
            for (j jVar : jVarArr) {
                int spanStart = editable.getSpanStart(jVar);
                int spanEnd = editable.getSpanEnd(jVar);
                if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean e(@n0 InputConnection inputConnection, @n0 Editable editable, @f0(from = 0) int i10, @f0(from = 0) int i11, boolean z10) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i10 >= 0 && i11 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (h(selectionStart, selectionEnd)) {
                return false;
            }
            if (z10) {
                iMax = a.a(editable, selectionStart, Math.max(i10, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i11, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i10, 0);
                iMin = Math.min(selectionEnd + i11, editable.length());
            }
            j[] jVarArr = (j[]) editable.getSpans(iMax, iMin, j.class);
            if (jVarArr != null && jVarArr.length > 0) {
                for (j jVar : jVarArr) {
                    int spanStart = editable.getSpanStart(jVar);
                    int spanEnd = editable.getSpanEnd(jVar);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    public static boolean f(@n0 Editable editable, int i10, @n0 KeyEvent keyEvent) {
        if (!(i10 != 67 ? i10 != 112 ? false : b(editable, keyEvent, true) : b(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    public static boolean h(int i10, int i11) {
        return i10 == -1 || i11 == -1 || i10 != i11;
    }

    public static boolean i(@n0 KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public final void a(@n0 Spannable spannable, h hVar, int i10, int i11) {
        spannable.setSpan(this.f5526a.a(hVar), i10, i11, 33);
    }

    public int c(@n0 CharSequence charSequence) {
        return d(charSequence, this.f5527b.h());
    }

    public int d(@n0 CharSequence charSequence, int i10) {
        b bVar = new b(this.f5527b.i(), this.f5529d, this.f5530e);
        int length = charSequence.length();
        int iCharCount = 0;
        int i11 = 0;
        int i12 = 0;
        while (iCharCount < length) {
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            int iA = bVar.a(iCodePointAt);
            h hVarB = bVar.b();
            if (iA == 1) {
                iCharCount += Character.charCount(iCodePointAt);
                i12 = 0;
            } else if (iA == 2) {
                iCharCount += Character.charCount(iCodePointAt);
            } else if (iA == 3) {
                hVarB = bVar.c();
                if (hVarB.d() <= i10) {
                    i11++;
                }
            }
            if (hVarB != null && hVarB.d() <= i10) {
                i12++;
            }
        }
        if (i11 != 0) {
            return 2;
        }
        if (!bVar.e() || bVar.b().d() > i10) {
            return i12 == 0 ? 0 : 2;
        }
        return 1;
    }

    public final boolean g(CharSequence charSequence, int i10, int i11, h hVar) {
        if (hVar.e() == 0) {
            hVar.n(this.f5528c.a(charSequence, i10, i11, hVar.i()));
        }
        return hVar.e() == 2;
    }

    public CharSequence j(@n0 CharSequence charSequence, @f0(from = 0) int i10, @f0(from = 0) int i11, @f0(from = 0) int i12, boolean z10) {
        int iCharCount;
        j[] jVarArr;
        boolean z11 = charSequence instanceof p;
        if (z11) {
            ((p) charSequence).a();
        }
        r rVar = null;
        if (z11) {
            rVar = new r((Spannable) charSequence);
        } else {
            try {
                if (charSequence instanceof Spannable) {
                    rVar = new r((Spannable) charSequence);
                } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i10 - 1, i11 + 1, j.class) <= i11) {
                    rVar = new r(charSequence);
                }
            } finally {
                if (z11) {
                    ((p) charSequence).d();
                }
            }
        }
        if (rVar != null && (jVarArr = (j[]) rVar.getSpans(i10, i11, j.class)) != null && jVarArr.length > 0) {
            for (j jVar : jVarArr) {
                int spanStart = rVar.getSpanStart(jVar);
                int spanEnd = rVar.getSpanEnd(jVar);
                if (spanStart != i11) {
                    rVar.removeSpan(jVar);
                }
                i10 = Math.min(spanStart, i10);
                i11 = Math.max(spanEnd, i11);
            }
        }
        if (i10 != i11 && i10 < charSequence.length()) {
            if (i12 != Integer.MAX_VALUE && rVar != null) {
                i12 -= ((j[]) rVar.getSpans(0, rVar.length(), j.class)).length;
            }
            b bVar = new b(this.f5527b.i(), this.f5529d, this.f5530e);
            r rVar2 = rVar;
            int iCodePointAt = Character.codePointAt(charSequence, i10);
            int i13 = 0;
            loop1: while (true) {
                iCharCount = i10;
                while (i10 < i11 && i13 < i12) {
                    int iA = bVar.a(iCodePointAt);
                    if (iA == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i11) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i10 = iCharCount;
                    } else if (iA == 2) {
                        i10 += Character.charCount(iCodePointAt);
                        if (i10 < i11) {
                            iCodePointAt = Character.codePointAt(charSequence, i10);
                        }
                    } else if (iA == 3) {
                        if (z10 || !g(charSequence, iCharCount, i10, bVar.c())) {
                            if (rVar2 == null) {
                                rVar2 = new r((Spannable) new SpannableString(charSequence));
                            }
                            a(rVar2, bVar.c(), iCharCount, i10);
                            i13++;
                        }
                    }
                }
                break loop1;
            }
            if (bVar.e() && i13 < i12 && (z10 || !g(charSequence, iCharCount, i10, bVar.b()))) {
                if (rVar2 == null) {
                    rVar2 = new r(charSequence);
                }
                a(rVar2, bVar.b(), iCharCount, i10);
            }
            if (rVar2 != null) {
                return rVar2.b();
            }
            if (z11) {
                ((p) charSequence).d();
            }
            return charSequence;
        }
        if (z11) {
            ((p) charSequence).d();
        }
        return charSequence;
    }
}
