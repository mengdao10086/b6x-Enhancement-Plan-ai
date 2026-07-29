package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewGroupKt {

    public static final class a implements kotlin.sequences.m<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4782a;

        public a(ViewGroup viewGroup) {
            this.f4782a = viewGroup;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<View> iterator() {
            return ViewGroupKt.k(this.f4782a);
        }
    }

    public static final class b implements Iterator<View>, jk.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4784b;

        public b(ViewGroup viewGroup) {
            this.f4784b = viewGroup;
        }

        @Override // java.util.Iterator
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public View next() {
            ViewGroup viewGroup = this.f4784b;
            int i10 = this.f4783a;
            this.f4783a = i10 + 1;
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4783a < this.f4784b.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.f4784b;
            int i10 = this.f4783a - 1;
            this.f4783a = i10;
            viewGroup.removeViewAt(i10);
        }
    }

    public static final boolean a(@yt.k ViewGroup viewGroup, @yt.k View view) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        kotlin.jvm.internal.f0.p(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void b(@yt.k ViewGroup viewGroup, @yt.k ik.l<? super View, z1> action) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            kotlin.jvm.internal.f0.o(childAt, "getChildAt(index)");
            action.i(childAt);
        }
    }

    public static final void c(@yt.k ViewGroup viewGroup, @yt.k ik.p<? super Integer, ? super View, z1> action) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            Integer numValueOf = Integer.valueOf(i10);
            View childAt = viewGroup.getChildAt(i10);
            kotlin.jvm.internal.f0.o(childAt, "getChildAt(index)");
            action.r0(numValueOf, childAt);
        }
    }

    @yt.k
    public static final View d(@yt.k ViewGroup viewGroup, int i10) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i10);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + viewGroup.getChildCount());
    }

    @yt.k
    public static final kotlin.sequences.m<View> e(@yt.k ViewGroup viewGroup) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        return new a(viewGroup);
    }

    @yt.k
    public static final kotlin.sequences.m<View> f(@yt.k ViewGroup viewGroup) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        return kotlin.sequences.q.b(new ViewGroupKt$descendants$1(viewGroup, null));
    }

    @yt.k
    public static final qk.m g(@yt.k ViewGroup viewGroup) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        return qk.v.W1(0, viewGroup.getChildCount());
    }

    public static final int h(@yt.k ViewGroup viewGroup) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        return viewGroup.getChildCount();
    }

    public static final boolean i(@yt.k ViewGroup viewGroup) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean j(@yt.k ViewGroup viewGroup) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        return viewGroup.getChildCount() != 0;
    }

    @yt.k
    public static final Iterator<View> k(@yt.k ViewGroup viewGroup) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        return new b(viewGroup);
    }

    public static final void l(@yt.k ViewGroup viewGroup, @yt.k View view) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        kotlin.jvm.internal.f0.p(view, "view");
        viewGroup.removeView(view);
    }

    public static final void m(@yt.k ViewGroup viewGroup, @yt.k View view) {
        kotlin.jvm.internal.f0.p(viewGroup, "<this>");
        kotlin.jvm.internal.f0.p(view, "view");
        viewGroup.addView(view);
    }

    public static final void n(@yt.k ViewGroup.MarginLayoutParams marginLayoutParams, @g.t0 int i10) {
        kotlin.jvm.internal.f0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i10, i10, i10, i10);
    }

    public static final void o(@yt.k ViewGroup.MarginLayoutParams marginLayoutParams, @g.t0 int i10, @g.t0 int i11, @g.t0 int i12, @g.t0 int i13) {
        kotlin.jvm.internal.f0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i10, i11, i12, i13);
    }

    public static /* synthetic */ void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = marginLayoutParams.leftMargin;
        }
        if ((i14 & 2) != 0) {
            i11 = marginLayoutParams.topMargin;
        }
        if ((i14 & 4) != 0) {
            i12 = marginLayoutParams.rightMargin;
        }
        if ((i14 & 8) != 0) {
            i13 = marginLayoutParams.bottomMargin;
        }
        kotlin.jvm.internal.f0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i10, i11, i12, i13);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @g.v0(17)
    public static final void q(@yt.k ViewGroup.MarginLayoutParams marginLayoutParams, @g.t0 int i10, @g.t0 int i11, @g.t0 int i12, @g.t0 int i13) {
        kotlin.jvm.internal.f0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i10);
        marginLayoutParams.topMargin = i11;
        marginLayoutParams.setMarginEnd(i12);
        marginLayoutParams.bottomMargin = i13;
    }

    public static /* synthetic */ void r(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = marginLayoutParams.getMarginStart();
        }
        if ((i14 & 2) != 0) {
            i11 = marginLayoutParams.topMargin;
        }
        if ((i14 & 4) != 0) {
            i12 = marginLayoutParams.getMarginEnd();
        }
        if ((i14 & 8) != 0) {
            i13 = marginLayoutParams.bottomMargin;
        }
        kotlin.jvm.internal.f0.p(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i10);
        marginLayoutParams.topMargin = i11;
        marginLayoutParams.setMarginEnd(i12);
        marginLayoutParams.bottomMargin = i13;
    }
}
