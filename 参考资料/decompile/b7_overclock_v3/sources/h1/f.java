package h1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.core.util.o;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f30211a;

    @v0(19)
    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f30212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f30213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f30214c = true;

        public a(TextView textView) {
            this.f30212a = textView;
            this.f30213b = new d(textView);
        }

        @Override // h1.f.b
        @n0
        public InputFilter[] a(@n0 InputFilter[] inputFilterArr) {
            return !this.f30214c ? i(inputFilterArr) : g(inputFilterArr);
        }

        @Override // h1.f.b
        public boolean b() {
            return this.f30214c;
        }

        @Override // h1.f.b
        public void c(boolean z10) {
            if (z10) {
                e();
            }
        }

        @Override // h1.f.b
        public void d(boolean z10) {
            this.f30214c = z10;
            e();
            l();
        }

        @Override // h1.f.b
        public void e() {
            this.f30212a.setTransformationMethod(f(this.f30212a.getTransformationMethod()));
        }

        @Override // h1.f.b
        @p0
        public TransformationMethod f(@p0 TransformationMethod transformationMethod) {
            return this.f30214c ? m(transformationMethod) : k(transformationMethod);
        }

        @n0
        public final InputFilter[] g(@n0 InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f30213b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f30213b;
            return inputFilterArr2;
        }

        public final SparseArray<InputFilter> h(@n0 InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                if (inputFilterArr[i10] instanceof d) {
                    sparseArray.put(i10, inputFilterArr[i10]);
                }
            }
            return sparseArray;
        }

        @n0
        public final InputFilter[] i(@n0 InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArrayH = h(inputFilterArr);
            if (sparseArrayH.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayH.size()];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (sparseArrayH.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void j(boolean z10) {
            this.f30214c = z10;
        }

        @p0
        public final TransformationMethod k(@p0 TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        public final void l() {
            this.f30212a.setFilters(a(this.f30212a.getFilters()));
        }

        @n0
        public final TransformationMethod m(@p0 TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }
    }

    public static class b {
        @n0
        public InputFilter[] a(@n0 InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        public boolean b() {
            return false;
        }

        public void c(boolean z10) {
        }

        public void d(boolean z10) {
        }

        public void e() {
        }

        @p0
        public TransformationMethod f(@p0 TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    @v0(19)
    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f30215a;

        public c(TextView textView) {
            this.f30215a = new a(textView);
        }

        @Override // h1.f.b
        @n0
        public InputFilter[] a(@n0 InputFilter[] inputFilterArr) {
            return g() ? inputFilterArr : this.f30215a.a(inputFilterArr);
        }

        @Override // h1.f.b
        public boolean b() {
            return this.f30215a.b();
        }

        @Override // h1.f.b
        public void c(boolean z10) {
            if (g()) {
                return;
            }
            this.f30215a.c(z10);
        }

        @Override // h1.f.b
        public void d(boolean z10) {
            if (g()) {
                this.f30215a.j(z10);
            } else {
                this.f30215a.d(z10);
            }
        }

        @Override // h1.f.b
        public void e() {
            if (g()) {
                return;
            }
            this.f30215a.e();
        }

        @Override // h1.f.b
        @p0
        public TransformationMethod f(@p0 TransformationMethod transformationMethod) {
            return g() ? transformationMethod : this.f30215a.f(transformationMethod);
        }

        public final boolean g() {
            return !androidx.emoji2.text.e.n();
        }
    }

    public f(@n0 TextView textView) {
        this(textView, true);
    }

    @n0
    public InputFilter[] a(@n0 InputFilter[] inputFilterArr) {
        return this.f30211a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f30211a.b();
    }

    public void c(boolean z10) {
        this.f30211a.c(z10);
    }

    public void d(boolean z10) {
        this.f30211a.d(z10);
    }

    public void e() {
        this.f30211a.e();
    }

    @p0
    public TransformationMethod f(@p0 TransformationMethod transformationMethod) {
        return this.f30211a.f(transformationMethod);
    }

    public f(@n0 TextView textView, boolean z10) {
        o.m(textView, "textView cannot be null");
        if (z10) {
            this.f30211a = new a(textView);
        } else {
            this.f30211a = new c(textView);
        }
    }
}
