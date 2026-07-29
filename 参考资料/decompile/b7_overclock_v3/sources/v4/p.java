package v4;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.f;
import g.n0;
import g.p0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class p<T> implements f.b<T>, s4.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f52702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f52703b;

    public static final class a extends s4.f<View, Object> {
        public a(@n0 View view) {
            super(view);
        }

        @Override // s4.p
        public void g(@n0 Object obj, @p0 t4.f<? super Object> fVar) {
        }

        @Override // s4.f
        public void k(@p0 Drawable drawable) {
        }

        @Override // s4.p
        public void n(@p0 Drawable drawable) {
        }
    }

    public p() {
    }

    @Override // com.bumptech.glide.f.b
    @p0
    public int[] a(@n0 T t10, int i10, int i11) {
        int[] iArr = this.f52702a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void b(@n0 View view) {
        if (this.f52702a == null && this.f52703b == null) {
            a aVar = new a(view);
            this.f52703b = aVar;
            aVar.m(this);
        }
    }

    @Override // s4.o
    public void e(int i10, int i11) {
        this.f52702a = new int[]{i10, i11};
        this.f52703b = null;
    }

    public p(@n0 View view) {
        a aVar = new a(view);
        this.f52703b = aVar;
        aVar.m(this);
    }
}
