package ml;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import il.d;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgeAnchor;

/* JADX INFO: loaded from: classes5.dex */
public class a extends FrameLayout implements il.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f41263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f41264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f41265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f41266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f41267e;

    public a(Context context) {
        super(context);
        this.f41265c = true;
    }

    @Override // il.d
    public void a(int i10, int i11) {
        d dVar = this.f41263a;
        if (dVar != null) {
            dVar.a(i10, i11);
        }
    }

    @Override // il.d
    public void b(int i10, int i11, float f10, boolean z10) {
        d dVar = this.f41263a;
        if (dVar != null) {
            dVar.b(i10, i11, f10, z10);
        }
    }

    @Override // il.d
    public void c(int i10, int i11) {
        d dVar = this.f41263a;
        if (dVar != null) {
            dVar.c(i10, i11);
        }
        if (this.f41265c) {
            setBadgeView(null);
        }
    }

    @Override // il.d
    public void d(int i10, int i11, float f10, boolean z10) {
        d dVar = this.f41263a;
        if (dVar != null) {
            dVar.d(i10, i11, f10, z10);
        }
    }

    public boolean e() {
        return this.f41265c;
    }

    public View getBadgeView() {
        return this.f41264b;
    }

    @Override // il.b
    public int getContentBottom() {
        d dVar = this.f41263a;
        return dVar instanceof il.b ? ((il.b) dVar).getContentBottom() : getBottom();
    }

    @Override // il.b
    public int getContentLeft() {
        return this.f41263a instanceof il.b ? getLeft() + ((il.b) this.f41263a).getContentLeft() : getLeft();
    }

    @Override // il.b
    public int getContentRight() {
        return this.f41263a instanceof il.b ? getLeft() + ((il.b) this.f41263a).getContentRight() : getRight();
    }

    @Override // il.b
    public int getContentTop() {
        d dVar = this.f41263a;
        return dVar instanceof il.b ? ((il.b) dVar).getContentTop() : getTop();
    }

    public d getInnerPagerTitleView() {
        return this.f41263a;
    }

    public b getXBadgeRule() {
        return this.f41266d;
    }

    public b getYBadgeRule() {
        return this.f41267e;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        Object obj = this.f41263a;
        if (!(obj instanceof View) || this.f41264b == null) {
            return;
        }
        int[] iArr = new int[14];
        View view = (View) obj;
        iArr[0] = view.getLeft();
        iArr[1] = view.getTop();
        iArr[2] = view.getRight();
        iArr[3] = view.getBottom();
        d dVar = this.f41263a;
        if (dVar instanceof il.b) {
            il.b bVar = (il.b) dVar;
            iArr[4] = bVar.getContentLeft();
            iArr[5] = bVar.getContentTop();
            iArr[6] = bVar.getContentRight();
            iArr[7] = bVar.getContentBottom();
        } else {
            for (int i14 = 4; i14 < 8; i14++) {
                iArr[i14] = iArr[i14 - 4];
            }
        }
        iArr[8] = view.getWidth() / 2;
        iArr[9] = view.getHeight() / 2;
        iArr[10] = iArr[4] / 2;
        iArr[11] = iArr[5] / 2;
        iArr[12] = iArr[6] + ((iArr[2] - iArr[6]) / 2);
        iArr[13] = iArr[7] + ((iArr[3] - iArr[7]) / 2);
        b bVar2 = this.f41266d;
        if (bVar2 != null) {
            int iB = iArr[bVar2.a().ordinal()] + this.f41266d.b();
            View view2 = this.f41264b;
            view2.offsetLeftAndRight(iB - view2.getLeft());
        }
        b bVar3 = this.f41267e;
        if (bVar3 != null) {
            int iB2 = iArr[bVar3.a().ordinal()] + this.f41267e.b();
            View view3 = this.f41264b;
            view3.offsetTopAndBottom(iB2 - view3.getTop());
        }
    }

    public void setAutoCancelBadge(boolean z10) {
        this.f41265c = z10;
    }

    public void setBadgeView(View view) {
        if (this.f41264b == view) {
            return;
        }
        this.f41264b = view;
        removeAllViews();
        if (this.f41263a instanceof View) {
            addView((View) this.f41263a, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f41264b != null) {
            addView(this.f41264b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void setInnerPagerTitleView(d dVar) {
        if (this.f41263a == dVar) {
            return;
        }
        this.f41263a = dVar;
        removeAllViews();
        if (this.f41263a instanceof View) {
            addView((View) this.f41263a, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f41264b != null) {
            addView(this.f41264b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void setXBadgeRule(b bVar) {
        BadgeAnchor badgeAnchorA;
        if (bVar != null && (badgeAnchorA = bVar.a()) != BadgeAnchor.LEFT && badgeAnchorA != BadgeAnchor.RIGHT && badgeAnchorA != BadgeAnchor.CONTENT_LEFT && badgeAnchorA != BadgeAnchor.CONTENT_RIGHT && badgeAnchorA != BadgeAnchor.CENTER_X && badgeAnchorA != BadgeAnchor.LEFT_EDGE_CENTER_X && badgeAnchorA != BadgeAnchor.RIGHT_EDGE_CENTER_X) {
            throw new IllegalArgumentException("x badge rule is wrong.");
        }
        this.f41266d = bVar;
    }

    public void setYBadgeRule(b bVar) {
        BadgeAnchor badgeAnchorA;
        if (bVar != null && (badgeAnchorA = bVar.a()) != BadgeAnchor.TOP && badgeAnchorA != BadgeAnchor.BOTTOM && badgeAnchorA != BadgeAnchor.CONTENT_TOP && badgeAnchorA != BadgeAnchor.CONTENT_BOTTOM && badgeAnchorA != BadgeAnchor.CENTER_Y && badgeAnchorA != BadgeAnchor.TOP_EDGE_CENTER_Y && badgeAnchorA != BadgeAnchor.BOTTOM_EDGE_CENTER_Y) {
            throw new IllegalArgumentException("y badge rule is wrong.");
        }
        this.f41267e = bVar;
    }
}
