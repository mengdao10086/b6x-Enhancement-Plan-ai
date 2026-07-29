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
public class b extends FlexibleDividerDecoration {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public InterfaceC0284b f25080l;

    public static class a extends FlexibleDividerDecoration.d<a> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public InterfaceC0284b f25081j;

        /* JADX INFO: renamed from: com.yqritc.recyclerviewflexibledivider.b$a$a, reason: collision with other inner class name */
        public class C0282a implements InterfaceC0284b {
            public C0282a() {
            }

            @Override // com.yqritc.recyclerviewflexibledivider.b.InterfaceC0284b
            public int a(int i10, RecyclerView recyclerView) {
                return 0;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.b.InterfaceC0284b
            public int b(int i10, RecyclerView recyclerView) {
                return 0;
            }
        }

        /* JADX INFO: renamed from: com.yqritc.recyclerviewflexibledivider.b$a$b, reason: collision with other inner class name */
        public class C0283b implements InterfaceC0284b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f25083a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f25084b;

            public C0283b(int i10, int i11) {
                this.f25083a = i10;
                this.f25084b = i11;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.b.InterfaceC0284b
            public int a(int i10, RecyclerView recyclerView) {
                return this.f25084b;
            }

            @Override // com.yqritc.recyclerviewflexibledivider.b.InterfaceC0284b
            public int b(int i10, RecyclerView recyclerView) {
                return this.f25083a;
            }
        }

        public a(Context context) {
            super(context);
            this.f25081j = new C0282a();
        }

        public a A(int i10, int i11) {
            return B(new C0283b(i10, i11));
        }

        public a B(InterfaceC0284b interfaceC0284b) {
            this.f25081j = interfaceC0284b;
            return this;
        }

        public a C(@q int i10) {
            return D(i10, i10);
        }

        public a D(@q int i10, @q int i11) {
            return A(this.f25056b.getDimensionPixelSize(i10), this.f25056b.getDimensionPixelSize(i11));
        }

        public b y() {
            i();
            return new b(this);
        }

        public a z(int i10) {
            return A(i10, i10);
        }
    }

    /* JADX INFO: renamed from: com.yqritc.recyclerviewflexibledivider.b$b, reason: collision with other inner class name */
    public interface InterfaceC0284b {
        int a(int i10, RecyclerView recyclerView);

        int b(int i10, RecyclerView recyclerView);
    }

    public b(a aVar) {
        super(aVar);
        this.f25080l = aVar.f25081j;
    }

    @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration
    public Rect i(int i10, RecyclerView recyclerView, View view) {
        Rect rect = new Rect(0, 0, 0, 0);
        int iY0 = (int) u0.y0(view);
        int iZ0 = (int) u0.z0(view);
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        rect.top = recyclerView.getPaddingTop() + this.f25080l.b(i10, recyclerView) + iZ0;
        rect.bottom = ((recyclerView.getHeight() - recyclerView.getPaddingBottom()) - this.f25080l.a(i10, recyclerView)) + iZ0;
        int iP = p(i10, recyclerView);
        boolean zL = l(recyclerView);
        if (this.f25042a != FlexibleDividerDecoration.DividerType.DRAWABLE) {
            int i11 = iP / 2;
            if (zL) {
                rect.left = ((view.getLeft() - ((ViewGroup.MarginLayoutParams) pVar).leftMargin) - i11) + iY0;
            } else {
                rect.left = view.getRight() + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i11 + iY0;
            }
            rect.right = rect.left;
        } else if (zL) {
            int left = (view.getLeft() - ((ViewGroup.MarginLayoutParams) pVar).leftMargin) + iY0;
            rect.right = left;
            rect.left = left - iP;
        } else {
            int right = view.getRight() + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + iY0;
            rect.left = right;
            rect.right = right + iP;
        }
        if (this.f25049h) {
            if (zL) {
                rect.left += iP;
                rect.right += iP;
            } else {
                rect.left -= iP;
                rect.right -= iP;
            }
        }
        return rect;
    }

    @Override // com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration
    public void m(Rect rect, int i10, RecyclerView recyclerView) {
        if (this.f25049h) {
            rect.set(0, 0, 0, 0);
        } else if (l(recyclerView)) {
            rect.set(p(i10, recyclerView), 0, 0, 0);
        } else {
            rect.set(0, 0, p(i10, recyclerView), 0);
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
            return fVar.a(i10, recyclerView).getIntrinsicWidth();
        }
        throw new RuntimeException("failed to get size");
    }
}
