package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final TextView f2580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final h1.f f2581b;

    public l(@g.n0 TextView textView) {
        this.f2580a = textView;
        this.f2581b = new h1.f(textView, false);
    }

    @g.n0
    public InputFilter[] a(@g.n0 InputFilter[] inputFilterArr) {
        return this.f2581b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f2581b.b();
    }

    public void c(@g.p0 AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f2580a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i10, 0);
        try {
            int i11 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(i11) ? typedArrayObtainStyledAttributes.getBoolean(i11, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void d(boolean z10) {
        this.f2581b.c(z10);
    }

    public void e(boolean z10) {
        this.f2581b.d(z10);
    }

    @g.p0
    public TransformationMethod f(@g.p0 TransformationMethod transformationMethod) {
        return this.f2581b.f(transformationMethod);
    }
}
