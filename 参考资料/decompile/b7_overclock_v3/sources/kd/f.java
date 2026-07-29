package kd;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class f extends Property<ImageView, Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f37175a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f37175a = new Matrix();
    }

    @Override // android.util.Property
    @n0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(@n0 ImageView imageView) {
        this.f37175a.set(imageView.getImageMatrix());
        return this.f37175a;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@n0 ImageView imageView, @n0 Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
