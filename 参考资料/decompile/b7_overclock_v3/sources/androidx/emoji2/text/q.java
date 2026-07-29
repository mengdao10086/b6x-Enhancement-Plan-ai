package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.annotation.RestrictTo;
import g.f0;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@v0(19)
public final class q extends j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public static Paint f5589f;

    public q(@n0 h hVar) {
        super(hVar);
    }

    @n0
    public static Paint f() {
        if (f5589f == null) {
            TextPaint textPaint = new TextPaint();
            f5589f = textPaint;
            textPaint.setColor(e.b().e());
            f5589f.setStyle(Paint.Style.FILL);
        }
        return f5589f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@n0 Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, @f0(from = 0) int i10, @f0(from = 0) int i11, float f10, int i12, int i13, int i14, @n0 Paint paint) {
        if (e.b().o()) {
            canvas.drawRect(f10, i12, f10 + e(), i14, f());
        }
        c().a(canvas, f10, i13, paint);
    }
}
