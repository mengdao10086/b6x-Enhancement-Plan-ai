package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.w;
import g.n0;
import g.p0;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e extends q {
    public static final String M7 = "android:changeImageTransform:matrix";
    public static final String N7 = "android:changeImageTransform:bounds";
    public static final String[] O7 = {M7, N7};
    public static final TypeEvaluator<Matrix> P7 = new a();
    public static final Property<ImageView, Matrix> Q7 = new b(Matrix.class, "animatedTransform");

    public class a implements TypeEvaluator<Matrix> {
        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    public class b extends Property<ImageView, Matrix> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ImageView imageView, Matrix matrix) {
            g2.h.a(imageView, matrix);
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7850a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f7850a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7850a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public e() {
    }

    public static Matrix I0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f10 = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f11 = intrinsicHeight;
        float fMax = Math.max(width / f10, height / f11);
        int iRound = Math.round((width - (f10 * fMax)) / 2.0f);
        int iRound2 = Math.round((height - (f11 * fMax)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(fMax, fMax);
        matrix.postTranslate(iRound, iRound2);
        return matrix;
    }

    @n0
    public static Matrix J0(@n0 ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return new Matrix(imageView.getImageMatrix());
        }
        int i10 = c.f7850a[imageView.getScaleType().ordinal()];
        return i10 != 1 ? i10 != 2 ? new Matrix(imageView.getImageMatrix()) : I0(imageView) : M0(imageView);
    }

    public static Matrix M0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    public final void H0(g2.q qVar) {
        View view = qVar.f28973b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = qVar.f28972a;
            map.put(N7, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put(M7, J0(imageView));
        }
    }

    public final ObjectAnimator K0(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) Q7, (TypeEvaluator) new w.a(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    @n0
    public final ObjectAnimator L0(@n0 ImageView imageView) {
        Property<ImageView, Matrix> property = Q7;
        TypeEvaluator<Matrix> typeEvaluator = P7;
        Matrix matrix = g2.i.f28962a;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
    }

    @Override // androidx.transition.q
    @n0
    public String[] a0() {
        return O7;
    }

    @Override // androidx.transition.q
    public void j(@n0 g2.q qVar) {
        H0(qVar);
    }

    @Override // androidx.transition.q
    public void m(@n0 g2.q qVar) {
        H0(qVar);
    }

    @Override // androidx.transition.q
    @p0
    public Animator q(@n0 ViewGroup viewGroup, @p0 g2.q qVar, @p0 g2.q qVar2) {
        if (qVar == null || qVar2 == null) {
            return null;
        }
        Rect rect = (Rect) qVar.f28972a.get(N7);
        Rect rect2 = (Rect) qVar2.f28972a.get(N7);
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) qVar.f28972a.get(M7);
        Matrix matrix2 = (Matrix) qVar2.f28972a.get(M7);
        boolean z10 = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z10) {
            return null;
        }
        ImageView imageView = (ImageView) qVar2.f28973b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return L0(imageView);
        }
        if (matrix == null) {
            matrix = g2.i.f28962a;
        }
        if (matrix2 == null) {
            matrix2 = g2.i.f28962a;
        }
        Q7.set(imageView, matrix);
        return K0(imageView, matrix, matrix2);
    }

    public e(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
