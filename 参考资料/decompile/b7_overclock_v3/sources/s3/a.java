package s3;

import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.app.hubert.guide.model.HighLight;
import g.i0;
import p3.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HighLight f49445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @i0
    public int f49446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49448d;

    /* JADX INFO: renamed from: s3.a$a, reason: collision with other inner class name */
    public static class C0567a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f49449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f49450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f49451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f49452d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f49453e;

        public String toString() {
            return "MarginInfo{leftMargin=" + this.f49449a + ", topMargin=" + this.f49450b + ", rightMargin=" + this.f49451c + ", bottomMargin=" + this.f49452d + ", gravity=" + this.f49453e + '}';
        }
    }

    public a(@i0 int i10, int i11) {
        this.f49446b = i10;
        this.f49448d = i11;
    }

    public final View a(ViewGroup viewGroup, b bVar) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f49446b, viewGroup, false);
        d(viewInflate);
        e(viewInflate, bVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewInflate.getLayoutParams();
        C0567a c0567aB = b(this.f49448d, viewGroup, viewInflate);
        t3.a.c(c0567aB.toString());
        c(c0567aB, viewGroup, viewInflate);
        layoutParams.gravity = c0567aB.f49453e;
        layoutParams.leftMargin += c0567aB.f49449a;
        layoutParams.topMargin += c0567aB.f49450b;
        layoutParams.rightMargin += c0567aB.f49451c;
        layoutParams.bottomMargin += c0567aB.f49452d;
        viewInflate.setLayoutParams(layoutParams);
        return viewInflate;
    }

    public final C0567a b(int i10, ViewGroup viewGroup, View view) {
        C0567a c0567a = new C0567a();
        RectF rectFC = this.f49445a.c(viewGroup);
        if (i10 == 3) {
            c0567a.f49453e = 5;
            c0567a.f49451c = (int) ((viewGroup.getWidth() - rectFC.left) + this.f49447c);
            c0567a.f49450b = (int) rectFC.top;
        } else if (i10 == 5) {
            c0567a.f49449a = (int) (rectFC.right + this.f49447c);
            c0567a.f49450b = (int) rectFC.top;
        } else if (i10 == 48) {
            c0567a.f49453e = 80;
            c0567a.f49452d = (int) ((viewGroup.getHeight() - rectFC.top) + this.f49447c);
            c0567a.f49449a = (int) rectFC.left;
        } else if (i10 == 80) {
            c0567a.f49450b = (int) (rectFC.bottom + this.f49447c);
            c0567a.f49449a = (int) rectFC.left;
        }
        return c0567a;
    }

    public void c(C0567a c0567a, ViewGroup viewGroup, View view) {
    }

    @Deprecated
    public void d(View view) {
    }

    public void e(View view, b bVar) {
    }

    public a(@i0 int i10, int i11, int i12) {
        this.f49446b = i10;
        this.f49448d = i11;
        this.f49447c = i12;
    }
}
