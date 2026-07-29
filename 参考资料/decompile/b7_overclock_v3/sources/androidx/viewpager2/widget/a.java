package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import g.n0;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f8233b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayoutManager f8234a;

    /* JADX INFO: renamed from: androidx.viewpager2.widget.a$a, reason: collision with other inner class name */
    public class C0078a implements Comparator<int[]> {
        public C0078a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f8233b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public a(@n0 LinearLayoutManager linearLayoutManager) {
        this.f8234a = linearLayoutManager;
    }

    public static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (c(viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a() {
        int top2;
        int i10;
        int bottom;
        int i11;
        int iY = this.f8234a.Y();
        if (iY == 0) {
            return true;
        }
        boolean z10 = this.f8234a.Q2() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, iY, 2);
        for (int i12 = 0; i12 < iY; i12++) {
            View viewX = this.f8234a.X(i12);
            if (viewX == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = viewX.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f8233b;
            int[] iArr2 = iArr[i12];
            if (z10) {
                top2 = viewX.getLeft();
                i10 = marginLayoutParams.leftMargin;
            } else {
                top2 = viewX.getTop();
                i10 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top2 - i10;
            int[] iArr3 = iArr[i12];
            if (z10) {
                bottom = viewX.getRight();
                i11 = marginLayoutParams.rightMargin;
            } else {
                bottom = viewX.getBottom();
                i11 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i11;
        }
        Arrays.sort(iArr, new C0078a());
        for (int i13 = 1; i13 < iY; i13++) {
            if (iArr[i13 - 1][1] != iArr[i13][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[iY - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    public final boolean b() {
        int iY = this.f8234a.Y();
        for (int i10 = 0; i10 < iY; i10++) {
            if (c(this.f8234a.X(i10))) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return (!a() || this.f8234a.Y() <= 1) && b();
    }
}
