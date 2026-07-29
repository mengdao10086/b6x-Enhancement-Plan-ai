package tg;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import mg.i;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: tg.a$a, reason: collision with other inner class name */
    public static class C0581a implements AppBarLayout.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sg.a f51275a;

        public C0581a(sg.a aVar) {
            this.f51275a = aVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.h, com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i10) {
            this.f51275a.a(i10 >= 0, appBarLayout.getTotalScrollRange() + i10 <= 0);
        }
    }

    public static void a(View view, i iVar, sg.a aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                iVar.h().p0(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        ((AppBarLayout) childAt).e(new C0581a(aVar));
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
