package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.e;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@g.d
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class d implements e.InterfaceC0049e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5349b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f5350c = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f5351a;

    public d() {
        TextPaint textPaint = new TextPaint();
        this.f5351a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f5350c;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.e.InterfaceC0049e
    public boolean a(@n0 CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = Build.VERSION.SDK_INT;
        if (i13 < 23 && i12 > i13) {
            return false;
        }
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i10 < i11) {
            sbB.append(charSequence.charAt(i10));
            i10++;
        }
        return m0.k.a(this.f5351a, sbB.toString());
    }
}
