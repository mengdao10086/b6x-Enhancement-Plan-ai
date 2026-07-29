package h1;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(19)
public class h implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final TransformationMethod f30223a;

    public h(@p0 TransformationMethod transformationMethod) {
        this.f30223a = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f30223a;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(@p0 CharSequence charSequence, @n0 View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f30223a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || androidx.emoji2.text.e.b().f() != 1) ? charSequence : androidx.emoji2.text.e.b().u(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z10, int i10, Rect rect) {
        TransformationMethod transformationMethod = this.f30223a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z10, i10, rect);
        }
    }
}
