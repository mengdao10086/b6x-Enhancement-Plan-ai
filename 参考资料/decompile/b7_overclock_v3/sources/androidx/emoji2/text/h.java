package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.RestrictTo;
import com.blankj.utilcode.util.i0;
import g.f0;
import g.n0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@g.d
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@v0(19)
public class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5516d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5517e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5518f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<androidx.emoji2.text.flatbuffer.n> f5519g = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final o f5521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f5522c = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public h(@n0 o oVar, @f0(from = 0) int i10) {
        this.f5521b = oVar;
        this.f5520a = i10;
    }

    public void a(@n0 Canvas canvas, float f10, float f11, @n0 Paint paint) {
        Typeface typefaceJ = this.f5521b.j();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceJ);
        canvas.drawText(this.f5521b.f(), this.f5520a * 2, 2, f10, f11, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i10) {
        return h().F(i10);
    }

    public int c() {
        return h().I();
    }

    public short d() {
        return h().L();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int e() {
        return this.f5522c;
    }

    public short f() {
        return h().S();
    }

    public int g() {
        return h().T();
    }

    public final androidx.emoji2.text.flatbuffer.n h() {
        ThreadLocal<androidx.emoji2.text.flatbuffer.n> threadLocal = f5519g;
        androidx.emoji2.text.flatbuffer.n nVar = threadLocal.get();
        if (nVar == null) {
            nVar = new androidx.emoji2.text.flatbuffer.n();
            threadLocal.set(nVar);
        }
        this.f5521b.g().J(nVar, this.f5520a);
        return nVar;
    }

    public short i() {
        return h().U();
    }

    @n0
    public Typeface j() {
        return this.f5521b.j();
    }

    public short k() {
        return h().X();
    }

    public boolean l() {
        return h().O();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void m() {
        this.f5522c = 0;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void n(boolean z10) {
        this.f5522c = z10 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(g()));
        sb2.append(", codepoints:");
        int iC = c();
        for (int i10 = 0; i10 < iC; i10++) {
            sb2.append(Integer.toHexString(b(i10)));
            sb2.append(i0.f11861z);
        }
        return sb2.toString();
    }
}
