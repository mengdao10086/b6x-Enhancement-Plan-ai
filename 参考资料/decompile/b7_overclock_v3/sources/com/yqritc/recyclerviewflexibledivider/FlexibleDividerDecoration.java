package com.yqritc.recyclerviewflexibledivider;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import g.n;
import g.q;
import g.v;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FlexibleDividerDecoration extends RecyclerView.n {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25040j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f25041k = {android.R.attr.listDivider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DividerType f25042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f25043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f25044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f25045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f25046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f25047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f25050i;

    public enum DividerType {
        DRAWABLE,
        PAINT,
        COLOR
    }

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Drawable f25051a;

        public a(Drawable drawable) {
            this.f25051a = drawable;
        }

        @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.f
        public Drawable a(int i10, RecyclerView recyclerView) {
            return this.f25051a;
        }
    }

    public class b implements h {
        public b() {
        }

        @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.h
        public int a(int i10, RecyclerView recyclerView) {
            return 2;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25054a;

        static {
            int[] iArr = new int[DividerType.values().length];
            f25054a = iArr;
            try {
                iArr[DividerType.DRAWABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25054a[DividerType.PAINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25054a[DividerType.COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class d<T extends d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f25055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Resources f25056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f25057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e f25058d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f f25059e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public h f25060f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public i f25061g = new a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f25062h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f25063i = false;

        public class a implements i {
            public a() {
            }

            @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.i
            public boolean a(int i10, RecyclerView recyclerView) {
                return false;
            }
        }

        public class b implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Paint f25065a;

            public b(Paint paint) {
                this.f25065a = paint;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.g
            public Paint a(int i10, RecyclerView recyclerView) {
                return this.f25065a;
            }
        }

        public class c implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f25067a;

            public c(int i10) {
                this.f25067a = i10;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.e
            public int a(int i10, RecyclerView recyclerView) {
                return this.f25067a;
            }
        }

        /* JADX INFO: renamed from: com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration$d$d, reason: collision with other inner class name */
        public class C0279d implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Drawable f25069a;

            public C0279d(Drawable drawable) {
                this.f25069a = drawable;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.f
            public Drawable a(int i10, RecyclerView recyclerView) {
                return this.f25069a;
            }
        }

        public class e implements h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f25071a;

            public e(int i10) {
                this.f25071a = i10;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.h
            public int a(int i10, RecyclerView recyclerView) {
                return this.f25071a;
            }
        }

        public d(Context context) {
            this.f25055a = context;
            this.f25056b = context.getResources();
        }

        public void i() {
            if (this.f25057c != null) {
                if (this.f25058d != null) {
                    throw new IllegalArgumentException("Use setColor method of Paint class to specify line color. Do not provider ColorProvider if you set PaintProvider.");
                }
                if (this.f25060f != null) {
                    throw new IllegalArgumentException("Use setStrokeWidth method of Paint class to specify line size. Do not provider SizeProvider if you set PaintProvider.");
                }
            }
        }

        public T j(int i10) {
            return (T) k(new c(i10));
        }

        public T k(e eVar) {
            this.f25058d = eVar;
            return this;
        }

        public T l(@n int i10) {
            return (T) j(h0.d.f(this.f25055a, i10));
        }

        public T m(@v int i10) {
            return (T) n(h0.d.i(this.f25055a, i10));
        }

        public T n(Drawable drawable) {
            return (T) o(new C0279d(drawable));
        }

        public T o(f fVar) {
            this.f25059e = fVar;
            return this;
        }

        public T p(Paint paint) {
            return (T) q(new b(paint));
        }

        public T q(g gVar) {
            this.f25057c = gVar;
            return this;
        }

        public T r(boolean z10) {
            this.f25063i = z10;
            return this;
        }

        public T s() {
            this.f25062h = true;
            return this;
        }

        public T t(int i10) {
            return (T) u(new e(i10));
        }

        public T u(h hVar) {
            this.f25060f = hVar;
            return this;
        }

        public T v(@q int i10) {
            return (T) t(this.f25056b.getDimensionPixelSize(i10));
        }

        public T w(i iVar) {
            this.f25061g = iVar;
            return this;
        }
    }

    public interface e {
        int a(int i10, RecyclerView recyclerView);
    }

    public interface f {
        Drawable a(int i10, RecyclerView recyclerView);
    }

    public interface g {
        Paint a(int i10, RecyclerView recyclerView);
    }

    public interface h {
        int a(int i10, RecyclerView recyclerView);
    }

    public interface i {
        boolean a(int i10, RecyclerView recyclerView);
    }

    public FlexibleDividerDecoration(d dVar) {
        DividerType dividerType = DividerType.DRAWABLE;
        this.f25042a = dividerType;
        if (dVar.f25057c != null) {
            this.f25042a = DividerType.PAINT;
            this.f25044c = dVar.f25057c;
        } else if (dVar.f25058d != null) {
            this.f25042a = DividerType.COLOR;
            this.f25045d = dVar.f25058d;
            this.f25050i = new Paint();
            n(dVar);
        } else {
            this.f25042a = dividerType;
            if (dVar.f25059e == null) {
                TypedArray typedArrayObtainStyledAttributes = dVar.f25055a.obtainStyledAttributes(f25041k);
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
                typedArrayObtainStyledAttributes.recycle();
                this.f25046e = new a(drawable);
            } else {
                this.f25046e = dVar.f25059e;
            }
            this.f25047f = dVar.f25060f;
        }
        this.f25043b = dVar.f25061g;
        this.f25048g = dVar.f25062h;
        this.f25049h = dVar.f25063i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        int iP0 = recyclerView.p0(view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        int iK = k(recyclerView);
        if (this.f25048g || iP0 < itemCount - iK) {
            int iJ = j(iP0, recyclerView);
            if (this.f25043b.a(iJ, recyclerView)) {
                return;
            }
            m(rect, iJ, recyclerView);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(android.graphics.Canvas r17, androidx.recyclerview.widget.RecyclerView r18, androidx.recyclerview.widget.RecyclerView.b0 r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            androidx.recyclerview.widget.RecyclerView$g r2 = r18.getAdapter()
            if (r2 != 0) goto Lb
            return
        Lb:
            int r2 = r2.getItemCount()
            int r3 = r0.k(r1)
            int r4 = r18.getChildCount()
            r5 = -1
            r6 = 0
        L19:
            if (r6 >= r4) goto Lb9
            android.view.View r7 = r1.getChildAt(r6)
            int r8 = r1.p0(r7)
            if (r8 >= r5) goto L29
            r7 = r17
            goto Lb5
        L29:
            boolean r5 = r0.f25048g
            if (r5 != 0) goto L32
            int r5 = r2 - r3
            if (r8 < r5) goto L32
            goto L38
        L32:
            boolean r5 = r0.o(r8, r1)
            if (r5 == 0) goto L3c
        L38:
            r7 = r17
            goto Lb4
        L3c:
            int r5 = r0.j(r8, r1)
            com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration$i r9 = r0.f25043b
            boolean r9 = r9.a(r5, r1)
            if (r9 == 0) goto L49
            goto L38
        L49:
            android.graphics.Rect r7 = r0.i(r5, r1, r7)
            int[] r9 = com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.c.f25054a
            com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration$DividerType r10 = r0.f25042a
            int r10 = r10.ordinal()
            r9 = r9[r10]
            r10 = 1
            if (r9 == r10) goto La6
            r10 = 2
            if (r9 == r10) goto L8c
            r10 = 3
            if (r9 == r10) goto L61
            goto L38
        L61:
            android.graphics.Paint r9 = r0.f25050i
            com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration$e r10 = r0.f25045d
            int r10 = r10.a(r5, r1)
            r9.setColor(r10)
            android.graphics.Paint r9 = r0.f25050i
            com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration$h r10 = r0.f25047f
            int r5 = r10.a(r5, r1)
            float r5 = (float) r5
            r9.setStrokeWidth(r5)
            int r5 = r7.left
            float r10 = (float) r5
            int r5 = r7.top
            float r11 = (float) r5
            int r5 = r7.right
            float r12 = (float) r5
            int r5 = r7.bottom
            float r13 = (float) r5
            android.graphics.Paint r14 = r0.f25050i
            r9 = r17
            r9.drawLine(r10, r11, r12, r13, r14)
            goto L38
        L8c:
            com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration$g r9 = r0.f25044c
            android.graphics.Paint r15 = r9.a(r5, r1)
            r0.f25050i = r15
            int r5 = r7.left
            float r11 = (float) r5
            int r5 = r7.top
            float r12 = (float) r5
            int r5 = r7.right
            float r13 = (float) r5
            int r5 = r7.bottom
            float r14 = (float) r5
            r10 = r17
            r10.drawLine(r11, r12, r13, r14, r15)
            goto L38
        La6:
            com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration$f r9 = r0.f25046e
            android.graphics.drawable.Drawable r5 = r9.a(r5, r1)
            r5.setBounds(r7)
            r7 = r17
            r5.draw(r7)
        Lb4:
            r5 = r8
        Lb5:
            int r6 = r6 + 1
            goto L19
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration.f(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$b0):void");
    }

    public abstract Rect i(int i10, RecyclerView recyclerView, View view);

    public final int j(int i10, RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return i10;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        return gridLayoutManager.L3().getSpanGroupIndex(i10, gridLayoutManager.H3());
    }

    public final int k(RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return 1;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        GridLayoutManager.c cVarL3 = gridLayoutManager.L3();
        int iH3 = gridLayoutManager.H3();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i10 = itemCount - 1; i10 >= 0; i10--) {
            if (cVarL3.getSpanIndex(i10, iH3) == 0) {
                return itemCount - i10;
            }
        }
        return 1;
    }

    public boolean l(RecyclerView recyclerView) {
        RecyclerView.o layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).S2();
        }
        return false;
    }

    public abstract void m(Rect rect, int i10, RecyclerView recyclerView);

    public final void n(d dVar) {
        h hVar = dVar.f25060f;
        this.f25047f = hVar;
        if (hVar == null) {
            this.f25047f = new b();
        }
    }

    public final boolean o(int i10, RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return false;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        return gridLayoutManager.L3().getSpanIndex(i10, gridLayoutManager.H3()) > 0;
    }
}
