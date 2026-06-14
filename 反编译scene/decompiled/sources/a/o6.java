package a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o6 extends t7 implements r6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s6 f6986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f2208a;
    public ListAdapter b;
    public final Rect c;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o6(s6 s6Var, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6986a = s6Var;
        this.c = new Rect();
        D(s6Var);
        J(true);
        O(0);
        L(new l6(this, s6Var));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S() {
        /*
            r8 = this;
            android.graphics.drawable.Drawable r0 = r8.g()
            r1 = 0
            if (r0 == 0) goto L26
            a.s6 r1 = r8.f6986a
            android.graphics.Rect r1 = r1.f2845a
            r0.getPadding(r1)
            a.s6 r0 = r8.f6986a
            boolean r0 = a.z8.b(r0)
            if (r0 == 0) goto L1d
            a.s6 r0 = r8.f6986a
            android.graphics.Rect r0 = r0.f2845a
            int r0 = r0.right
            goto L24
        L1d:
            a.s6 r0 = r8.f6986a
            android.graphics.Rect r0 = r0.f2845a
            int r0 = r0.left
            int r0 = -r0
        L24:
            r1 = r0
            goto L2e
        L26:
            a.s6 r0 = r8.f6986a
            android.graphics.Rect r0 = r0.f2845a
            r0.right = r1
            r0.left = r1
        L2e:
            a.s6 r0 = r8.f6986a
            int r0 = r0.getPaddingLeft()
            a.s6 r2 = r8.f6986a
            int r2 = r2.getPaddingRight()
            a.s6 r3 = r8.f6986a
            int r3 = r3.getWidth()
            a.s6 r4 = r8.f6986a
            int r5 = r4.f2840a
            r6 = -2
            if (r5 != r6) goto L78
            android.widget.ListAdapter r5 = r8.b
            android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
            android.graphics.drawable.Drawable r6 = r8.g()
            int r4 = r4.a(r5, r6)
            a.s6 r5 = r8.f6986a
            android.content.Context r5 = r5.getContext()
            android.content.res.Resources r5 = r5.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            int r5 = r5.widthPixels
            a.s6 r6 = r8.f6986a
            android.graphics.Rect r6 = r6.f2845a
            int r7 = r6.left
            int r5 = r5 - r7
            int r6 = r6.right
            int r5 = r5 - r6
            if (r4 <= r5) goto L70
            r4 = r5
        L70:
            int r5 = r3 - r0
            int r5 = r5 - r2
            int r4 = java.lang.Math.max(r4, r5)
            goto L7e
        L78:
            r4 = -1
            if (r5 != r4) goto L82
            int r4 = r3 - r0
            int r4 = r4 - r2
        L7e:
            r8.F(r4)
            goto L85
        L82:
            r8.F(r5)
        L85:
            a.s6 r4 = r8.f6986a
            boolean r4 = a.z8.b(r4)
            if (r4 == 0) goto L9a
            int r3 = r3 - r2
            int r0 = r8.z()
            int r3 = r3 - r0
            int r0 = r8.T()
            int r3 = r3 - r0
            int r1 = r1 + r3
            goto La0
        L9a:
            int r2 = r8.T()
            int r0 = r0 + r2
            int r1 = r1 + r0
        La0:
            r8.l(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.o6.S():void");
    }

    public int T() {
        return this.i;
    }

    public boolean U(View view) {
        return eh.P(view) && view.getGlobalVisibleRect(this.c);
    }

    @Override // a.r6
    public void f(int i) {
        this.i = i;
    }

    @Override // a.r6
    public void j(CharSequence charSequence) {
        this.f2208a = charSequence;
    }

    @Override // a.t7, a.r6
    public void n(ListAdapter listAdapter) {
        super.n(listAdapter);
        this.b = listAdapter;
    }

    @Override // a.r6
    public CharSequence o() {
        return this.f2208a;
    }

    @Override // a.r6
    public void p(int i, int i2) {
        ViewTreeObserver viewTreeObserver;
        boolean zA = a();
        S();
        I(2);
        super.c();
        ListView listViewE = e();
        listViewE.setChoiceMode(1);
        if (Build.VERSION.SDK_INT >= 17) {
            listViewE.setTextDirection(i);
            listViewE.setTextAlignment(i2);
        }
        P(this.f6986a.getSelectedItemPosition());
        if (zA || (viewTreeObserver = this.f6986a.getViewTreeObserver()) == null) {
            return;
        }
        m6 m6Var = new m6(this);
        viewTreeObserver.addOnGlobalLayoutListener(m6Var);
        K(new n6(this, m6Var));
    }
}
