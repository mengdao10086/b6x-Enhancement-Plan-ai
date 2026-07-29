package com.flydigi.base.widget.recyclerview.layoutmanager;

/* JADX INFO: loaded from: classes2.dex */
public class e extends c {
    @Override // com.flydigi.base.widget.recyclerview.layoutmanager.c, androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i10, int i11) {
        int i12;
        ViewPagerLayoutManager viewPagerLayoutManager = (ViewPagerLayoutManager) this.f13657a.getLayoutManager();
        if (viewPagerLayoutManager == null || this.f13657a.getAdapter() == null) {
            return false;
        }
        if (!viewPagerLayoutManager.H3() && (viewPagerLayoutManager.L7 == viewPagerLayoutManager.I3() || viewPagerLayoutManager.L7 == viewPagerLayoutManager.L3())) {
            return false;
        }
        int minFlingVelocity = this.f13657a.getMinFlingVelocity();
        this.f13658b.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (viewPagerLayoutManager.I7 == 1 && Math.abs(i11) > minFlingVelocity) {
            int iC3 = viewPagerLayoutManager.C3();
            i12 = ((float) this.f13658b.getFinalY()) * viewPagerLayoutManager.E3() > viewPagerLayoutManager.S7 ? 1 : 0;
            this.f13657a.L1(viewPagerLayoutManager.S2() ? iC3 - i12 : iC3 + i12);
            return true;
        }
        if (viewPagerLayoutManager.I7 == 0 && Math.abs(i10) > minFlingVelocity) {
            int iC32 = viewPagerLayoutManager.C3();
            i12 = ((float) this.f13658b.getFinalX()) * viewPagerLayoutManager.E3() > viewPagerLayoutManager.S7 ? 1 : 0;
            this.f13657a.L1(viewPagerLayoutManager.S2() ? iC32 - i12 : iC32 + i12);
        }
        return true;
    }
}
