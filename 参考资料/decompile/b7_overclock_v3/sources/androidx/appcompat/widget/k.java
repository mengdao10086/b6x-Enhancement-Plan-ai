package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final EditText f2578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final h1.a f2579b;

    public k(@g.n0 EditText editText) {
        this.f2578a = editText;
        this.f2579b = new h1.a(editText, false);
    }

    @g.p0
    public KeyListener a(@g.p0 KeyListener keyListener) {
        return b(keyListener) ? this.f2579b.b(keyListener) : keyListener;
    }

    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    public boolean c() {
        return this.f2579b.d();
    }

    public void d(@g.p0 AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f2578a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i10, 0);
        try {
            int i11 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(i11) ? typedArrayObtainStyledAttributes.getBoolean(i11, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            f(z10);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @g.p0
    public InputConnection e(@g.p0 InputConnection inputConnection, @g.n0 EditorInfo editorInfo) {
        return this.f2579b.e(inputConnection, editorInfo);
    }

    public void f(boolean z10) {
        this.f2579b.g(z10);
    }
}
