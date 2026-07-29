package xf;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.just.agentweb.AgentWebView;

/* JADX INFO: loaded from: classes7.dex */
public class f0 extends AgentWebView implements androidx.core.view.e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f55225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f55226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f55227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f55228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.core.view.f0 f55229k;

    public f0(Context context) {
        super(context);
        this.f55226h = new int[2];
        this.f55227i = new int[2];
        B();
    }

    public final void B() {
        this.f55229k = new androidx.core.view.f0(this);
        setNestedScrollingEnabled(true);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f55229k.a(f10, f11, z10);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f55229k.b(f10, f11);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.f55229k.c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f55229k.f(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean hasNestedScrollingParent() {
        return this.f55229k.k();
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean isNestedScrollingEnabled() {
        return this.f55229k.m();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int iC = androidx.core.view.b0.c(motionEvent);
        if (iC == 0) {
            this.f55228j = 0;
        }
        int y10 = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.f55228j);
        if (iC == 0) {
            this.f55225g = y10;
            startNestedScroll(2);
            return super.onTouchEvent(motionEvent);
        }
        if (iC != 1) {
            if (iC == 2) {
                int i10 = this.f55225g - y10;
                if (dispatchNestedPreScroll(0, i10, this.f55227i, this.f55226h)) {
                    i10 -= this.f55227i[1];
                    motionEventObtain.offsetLocation(0.0f, this.f55226h[1]);
                    this.f55228j += this.f55226h[1];
                }
                this.f55225g = y10 - this.f55226h[1];
                int scrollY = getScrollY();
                int iMax = Math.max(0, scrollY + i10) - scrollY;
                if (dispatchNestedScroll(0, iMax, 0, i10 - iMax, this.f55226h)) {
                    this.f55225g = this.f55225g - this.f55226h[1];
                    motionEventObtain.offsetLocation(0.0f, r1[1]);
                    this.f55228j += this.f55226h[1];
                }
                boolean zOnTouchEvent = super.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                return zOnTouchEvent;
            }
            if (iC != 3 && iC != 5) {
                return false;
            }
        }
        stopNestedScroll();
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, androidx.core.view.e0
    public void setNestedScrollingEnabled(boolean z10) {
        this.f55229k.p(z10);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean startNestedScroll(int i10) {
        return this.f55229k.r(i10);
    }

    @Override // android.view.View, androidx.core.view.e0
    public void stopNestedScroll() {
        this.f55229k.t();
    }

    public f0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f55226h = new int[2];
        this.f55227i = new int[2];
        B();
    }
}
