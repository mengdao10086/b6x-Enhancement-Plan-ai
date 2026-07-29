package com.yqritc.recyclerviewflexibledivider;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u0;
import androidx.recyclerview.widget.RecyclerView;
import com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration;
import g.q;

/* JADX INFO: loaded from: classes5.dex */
public class a extends FlexibleDividerDecoration {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f25074l;

    /* JADX INFO: renamed from: com.yqritc.recyclerviewflexibledivider.a$a, reason: collision with other inner class name */
    public static class C0280a extends FlexibleDividerDecoration.d<C0280a> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public b f25075j;

        /* JADX INFO: renamed from: com.yqritc.recyclerviewflexibledivider.a$a$a, reason: collision with other inner class name */
        public class C0281a implements b {
            public C0281a() {
            }

            @Override // com.yqritc.recyclerviewflexibledivider.a.b
            public int a(int i10, RecyclerView recyclerView) {
                return 0;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.a.b
            public int b(int i10, RecyclerView recyclerView) {
                return 0;
            }
        }

        /* JADX INFO: renamed from: com.yqritc.recyclerviewflexibledivider.a$a$b */
        public class b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f25077a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f25078b;

            public b(int i10, int i11) {
                this.f25077a = i10;
                this.f25078b = i11;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.a.b
            public int a(int i10, RecyclerView recyclerView) {
                return this.f25078b;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.a.b
            public int b(int i10, RecyclerView recyclerView) {
                return this.f25077a;
            }
        }

        public C0280a(Context context) {
            super(context);
            this.f25075j = new C0281a();
        }

        public C0280a A(int i10, int i11) {
            return B(new b(i10, i11));
        }

        public C0280a B(b bVar) {
            this.f25075j = bVar;
            return this;
        }

        public C0280a C(@q int i10) {
            return D(i10, i10);
        }

        public C0280a D(@q int i10, @q int i11) {
            return A(this.f25056b.getDimensionPixelSize(i10), this.f25056b.getDimensionPixelSize(i11));
        }

        public a y() {
            i();
            return new a(this);
        }

        public C0280a z(int i10) {
            return A(i10, i10);
        }
    }

    public interface b {
        int a(int i10, RecyclerView recyclerView);

        int b(int i10, RecyclerView recyclerView);
    }

    public a(C0280a c0280a) {
        super(c0280a);
        this.f25074l = c0280a.f25075j;
    }

    @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration
    public Rect i(int i10, RecyclerView recyclerView, View view) {
        Rect rect = new Rect(0, 0, 0, 0);
        int iY0 = (int) u0.y0(view);
        int iZ0 = (int) u0.z0(view);
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        rect.left = recyclerView.getPaddingLeft() + this.f25074l.b(i10, recyclerView) + iY0;
        rect.right = ((recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f25074l.a(i10, recyclerView)) + iY0;
        int iP = p(i10, recyclerView);
        boolean zL = l(recyclerView);
        if (this.f25042a != FlexibleDividerDecoration.DividerType.DRAWABLE) {
            int i11 = iP / 2;
            if (zL) {
                rect.top = ((view.getTop() - ((ViewGroup.MarginLayoutParams) pVar).topMargin) - i11) + iZ0;
            } else {
                rect.top = view.getBottom() + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i11 + iZ0;
            }
            rect.bottom = rect.top;
        } else if (zL) {
            int top2 = (view.getTop() - ((ViewGroup.MarginLayoutParams) pVar).topMargin) + iZ0;
            rect.bottom = top2;
            rect.top = top2 - iP;
        } else {
            int bottom = view.getBottom() + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + iZ0;
            rect.top = bottom;
            rect.bottom = bottom + iP;
        }
        if (this.f25049h) {
            if (zL) {
                rect.top += iP;
                rect.bottom += iP;
            } else {
                rect.top -= iP;
                rect.bottom -= iP;
            }
        }
        return rect;
    }

    @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration
    public void m(Rect rect, int i10, RecyclerView recyclerView) {
        if (this.f25049h) {
            rect.set(0, 0, 0, 0);
        } else if (l(recyclerView)) {
            rect.set(0, p(i10, recyclerView), 0, 0);
        } else {
            rect.set(0, 0, 0, p(i10, recyclerView));
        }
    }

    public final int p(int i10, RecyclerView recyclerView) {
        FlexibleDividerDecoration.g gVar = this.f25044c;
        if (gVar != null) {
            return (int) gVar.a(i10, recyclerView).getStrokeWidth();
        }
        FlexibleDividerDecoration.h hVar = this.f25047f;
        if (hVar != null) {
            return hVar.a(i10, recyclerView);
        }
        FlexibleDividerDecoration.f fVar = this.f25046e;
        if (fVar != null) {
            return fVar.a(i10, recyclerView).getIntrinsicHeight();
        }
        throw new RuntimeException("failed to get size");
    }
}
