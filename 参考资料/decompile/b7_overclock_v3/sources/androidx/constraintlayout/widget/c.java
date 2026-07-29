package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4198c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4199d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4200e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4201f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4202g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f4203h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f4204i = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f4205j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f4206k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f4207l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f4208m = -2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f4209n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f4210o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintLayout.b f4211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f4212b;

    public c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ConstraintLayout.b)) {
            throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
        }
        this.f4211a = (ConstraintLayout.b) layoutParams;
        this.f4212b = view;
    }

    public c A(float weight) {
        this.f4211a.L = weight;
        return this;
    }

    public c B(int anchor, int value) {
        switch (anchor) {
            case 1:
                ((ViewGroup.MarginLayoutParams) this.f4211a).leftMargin = value;
                return this;
            case 2:
                ((ViewGroup.MarginLayoutParams) this.f4211a).rightMargin = value;
                return this;
            case 3:
                ((ViewGroup.MarginLayoutParams) this.f4211a).topMargin = value;
                return this;
            case 4:
                ((ViewGroup.MarginLayoutParams) this.f4211a).bottomMargin = value;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.f4211a.setMarginStart(value);
                return this;
            case 7:
                this.f4211a.setMarginEnd(value);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public c C(int anchor) {
        switch (anchor) {
            case 1:
                ConstraintLayout.b bVar = this.f4211a;
                bVar.f4083f = -1;
                bVar.f4081e = -1;
                ((ViewGroup.MarginLayoutParams) bVar).leftMargin = -1;
                bVar.f4117w = Integer.MIN_VALUE;
                return this;
            case 2:
                ConstraintLayout.b bVar2 = this.f4211a;
                bVar2.f4087h = -1;
                bVar2.f4085g = -1;
                ((ViewGroup.MarginLayoutParams) bVar2).rightMargin = -1;
                bVar2.f4120y = Integer.MIN_VALUE;
                return this;
            case 3:
                ConstraintLayout.b bVar3 = this.f4211a;
                bVar3.f4091j = -1;
                bVar3.f4089i = -1;
                ((ViewGroup.MarginLayoutParams) bVar3).topMargin = -1;
                bVar3.f4119x = Integer.MIN_VALUE;
                return this;
            case 4:
                ConstraintLayout.b bVar4 = this.f4211a;
                bVar4.f4093k = -1;
                bVar4.f4095l = -1;
                ((ViewGroup.MarginLayoutParams) bVar4).bottomMargin = -1;
                bVar4.f4121z = Integer.MIN_VALUE;
                return this;
            case 5:
                this.f4211a.f4097m = -1;
                return this;
            case 6:
                ConstraintLayout.b bVar5 = this.f4211a;
                bVar5.f4109s = -1;
                bVar5.f4111t = -1;
                bVar5.setMarginStart(-1);
                this.f4211a.A = Integer.MIN_VALUE;
                return this;
            case 7:
                ConstraintLayout.b bVar6 = this.f4211a;
                bVar6.f4113u = -1;
                bVar6.f4115v = -1;
                bVar6.setMarginEnd(-1);
                this.f4211a.B = Integer.MIN_VALUE;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public c D() {
        ConstraintLayout.b bVar = this.f4211a;
        int i10 = bVar.f4083f;
        int i11 = bVar.f4085g;
        if (i10 == -1 && i11 == -1) {
            int i12 = bVar.f4109s;
            int i13 = bVar.f4113u;
            if (i12 != -1 || i13 != -1) {
                c cVar = new c(((ViewGroup) this.f4212b.getParent()).findViewById(i12));
                c cVar2 = new c(((ViewGroup) this.f4212b.getParent()).findViewById(i13));
                ConstraintLayout.b bVar2 = this.f4211a;
                if (i12 != -1 && i13 != -1) {
                    cVar.m(7, i13, 6, 0);
                    cVar2.m(6, i10, 7, 0);
                } else if (i10 != -1 || i13 != -1) {
                    int i14 = bVar2.f4087h;
                    if (i14 != -1) {
                        cVar.m(7, i14, 7, 0);
                    } else {
                        int i15 = bVar2.f4081e;
                        if (i15 != -1) {
                            cVar2.m(6, i15, 6, 0);
                        }
                    }
                }
            }
            C(6);
            C(7);
        } else {
            c cVar3 = new c(((ViewGroup) this.f4212b.getParent()).findViewById(i10));
            c cVar4 = new c(((ViewGroup) this.f4212b.getParent()).findViewById(i11));
            ConstraintLayout.b bVar3 = this.f4211a;
            if (i10 != -1 && i11 != -1) {
                cVar3.m(2, i11, 1, 0);
                cVar4.m(1, i10, 2, 0);
            } else if (i10 != -1 || i11 != -1) {
                int i16 = bVar3.f4087h;
                if (i16 != -1) {
                    cVar3.m(2, i16, 2, 0);
                } else {
                    int i17 = bVar3.f4081e;
                    if (i17 != -1) {
                        cVar4.m(1, i17, 1, 0);
                    }
                }
            }
            C(1);
            C(2);
        }
        return this;
    }

    public c E() {
        ConstraintLayout.b bVar = this.f4211a;
        int i10 = bVar.f4091j;
        int i11 = bVar.f4093k;
        if (i10 != -1 || i11 != -1) {
            c cVar = new c(((ViewGroup) this.f4212b.getParent()).findViewById(i10));
            c cVar2 = new c(((ViewGroup) this.f4212b.getParent()).findViewById(i11));
            ConstraintLayout.b bVar2 = this.f4211a;
            if (i10 != -1 && i11 != -1) {
                cVar.m(4, i11, 3, 0);
                cVar2.m(3, i10, 4, 0);
            } else if (i10 != -1 || i11 != -1) {
                int i12 = bVar2.f4095l;
                if (i12 != -1) {
                    cVar.m(4, i12, 4, 0);
                } else {
                    int i13 = bVar2.f4089i;
                    if (i13 != -1) {
                        cVar2.m(3, i13, 3, 0);
                    }
                }
            }
        }
        C(3);
        C(4);
        return this;
    }

    public c F(float rotation) {
        this.f4212b.setRotation(rotation);
        return this;
    }

    public c G(float rotationX) {
        this.f4212b.setRotationX(rotationX);
        return this;
    }

    public c H(float rotationY) {
        this.f4212b.setRotationY(rotationY);
        return this;
    }

    public c I(float scaleX) {
        this.f4212b.setScaleY(scaleX);
        return this;
    }

    public c J(float scaleY) {
        return this;
    }

    public final String K(int side) {
        switch (side) {
            case 1:
                return xc.d.f55080k0;
            case 2:
                return xc.d.f55082m0;
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return xc.d.f55084n0;
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public c L(float transformPivotX, float transformPivotY) {
        this.f4212b.setPivotX(transformPivotX);
        this.f4212b.setPivotY(transformPivotY);
        return this;
    }

    public c M(float transformPivotX) {
        this.f4212b.setPivotX(transformPivotX);
        return this;
    }

    public c N(float transformPivotY) {
        this.f4212b.setPivotY(transformPivotY);
        return this;
    }

    public c O(float translationX, float translationY) {
        this.f4212b.setTranslationX(translationX);
        this.f4212b.setTranslationY(translationY);
        return this;
    }

    public c P(float translationX) {
        this.f4212b.setTranslationX(translationX);
        return this;
    }

    public c Q(float translationY) {
        this.f4212b.setTranslationY(translationY);
        return this;
    }

    public c R(float translationZ) {
        this.f4212b.setTranslationZ(translationZ);
        return this;
    }

    public c S(float bias) {
        this.f4211a.H = bias;
        return this;
    }

    public c T(int chainStyle) {
        this.f4211a.O = chainStyle;
        return this;
    }

    public c U(float weight) {
        this.f4211a.M = weight;
        return this;
    }

    public c V(int visibility) {
        this.f4212b.setVisibility(visibility);
        return this;
    }

    public c a(int leftId, int rightId) {
        m(1, leftId, leftId == 0 ? 1 : 2, 0);
        m(2, rightId, rightId == 0 ? 2 : 1, 0);
        if (leftId != 0) {
            new c(((ViewGroup) this.f4212b.getParent()).findViewById(leftId)).m(2, this.f4212b.getId(), 1, 0);
        }
        if (rightId != 0) {
            new c(((ViewGroup) this.f4212b.getParent()).findViewById(rightId)).m(1, this.f4212b.getId(), 2, 0);
        }
        return this;
    }

    public c b(int leftId, int rightId) {
        m(6, leftId, leftId == 0 ? 6 : 7, 0);
        m(7, rightId, rightId == 0 ? 7 : 6, 0);
        if (leftId != 0) {
            new c(((ViewGroup) this.f4212b.getParent()).findViewById(leftId)).m(7, this.f4212b.getId(), 6, 0);
        }
        if (rightId != 0) {
            new c(((ViewGroup) this.f4212b.getParent()).findViewById(rightId)).m(6, this.f4212b.getId(), 7, 0);
        }
        return this;
    }

    public c c(int topId, int bottomId) {
        m(3, topId, topId == 0 ? 3 : 4, 0);
        m(4, bottomId, bottomId == 0 ? 4 : 3, 0);
        if (topId != 0) {
            new c(((ViewGroup) this.f4212b.getParent()).findViewById(topId)).m(4, this.f4212b.getId(), 3, 0);
        }
        if (bottomId != 0) {
            new c(((ViewGroup) this.f4212b.getParent()).findViewById(bottomId)).m(3, this.f4212b.getId(), 4, 0);
        }
        return this;
    }

    public c d(float alpha) {
        this.f4212b.setAlpha(alpha);
        return this;
    }

    public void e() {
    }

    public c f(int firstID, int firstSide, int firstMargin, int secondId, int secondSide, int secondMargin, float bias) {
        if (firstMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (secondMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (bias <= 0.0f || bias > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (firstSide == 1 || firstSide == 2) {
            m(1, firstID, firstSide, firstMargin);
            m(2, secondId, secondSide, secondMargin);
            this.f4211a.G = bias;
        } else if (firstSide == 6 || firstSide == 7) {
            m(6, firstID, firstSide, firstMargin);
            m(7, secondId, secondSide, secondMargin);
            this.f4211a.G = bias;
        } else {
            m(3, firstID, firstSide, firstMargin);
            m(4, secondId, secondSide, secondMargin);
            this.f4211a.H = bias;
        }
        return this;
    }

    public c g(int toView) {
        if (toView == 0) {
            f(0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            f(toView, 2, 0, toView, 1, 0, 0.5f);
        }
        return this;
    }

    public c h(int leftId, int leftSide, int leftMargin, int rightId, int rightSide, int rightMargin, float bias) {
        m(1, leftId, leftSide, leftMargin);
        m(2, rightId, rightSide, rightMargin);
        this.f4211a.G = bias;
        return this;
    }

    public c i(int toView) {
        if (toView == 0) {
            f(0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            f(toView, 7, 0, toView, 6, 0, 0.5f);
        }
        return this;
    }

    public c j(int startId, int startSide, int startMargin, int endId, int endSide, int endMargin, float bias) {
        m(6, startId, startSide, startMargin);
        m(7, endId, endSide, endMargin);
        this.f4211a.G = bias;
        return this;
    }

    public c k(int toView) {
        if (toView == 0) {
            f(0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            f(toView, 4, 0, toView, 3, 0, 0.5f);
        }
        return this;
    }

    public c l(int topId, int topSide, int topMargin, int bottomId, int bottomSide, int bottomMargin, float bias) {
        m(3, topId, topSide, topMargin);
        m(4, bottomId, bottomSide, bottomMargin);
        this.f4211a.H = bias;
        return this;
    }

    public c m(int startSide, int endID, int endSide, int margin) {
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    ConstraintLayout.b bVar = this.f4211a;
                    bVar.f4081e = endID;
                    bVar.f4083f = -1;
                } else {
                    if (endSide != 2) {
                        throw new IllegalArgumentException("Left to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.b bVar2 = this.f4211a;
                    bVar2.f4083f = endID;
                    bVar2.f4081e = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.f4211a).leftMargin = margin;
                return this;
            case 2:
                if (endSide == 1) {
                    ConstraintLayout.b bVar3 = this.f4211a;
                    bVar3.f4085g = endID;
                    bVar3.f4087h = -1;
                } else {
                    if (endSide != 2) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.b bVar4 = this.f4211a;
                    bVar4.f4087h = endID;
                    bVar4.f4085g = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.f4211a).rightMargin = margin;
                return this;
            case 3:
                if (endSide == 3) {
                    ConstraintLayout.b bVar5 = this.f4211a;
                    bVar5.f4089i = endID;
                    bVar5.f4091j = -1;
                    bVar5.f4097m = -1;
                    bVar5.f4099n = -1;
                    bVar5.f4101o = -1;
                } else {
                    if (endSide != 4) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.b bVar6 = this.f4211a;
                    bVar6.f4091j = endID;
                    bVar6.f4089i = -1;
                    bVar6.f4097m = -1;
                    bVar6.f4099n = -1;
                    bVar6.f4101o = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.f4211a).topMargin = margin;
                return this;
            case 4:
                if (endSide == 4) {
                    ConstraintLayout.b bVar7 = this.f4211a;
                    bVar7.f4095l = endID;
                    bVar7.f4093k = -1;
                    bVar7.f4097m = -1;
                    bVar7.f4099n = -1;
                    bVar7.f4101o = -1;
                } else {
                    if (endSide != 3) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.b bVar8 = this.f4211a;
                    bVar8.f4093k = endID;
                    bVar8.f4095l = -1;
                    bVar8.f4097m = -1;
                    bVar8.f4099n = -1;
                    bVar8.f4101o = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.f4211a).bottomMargin = margin;
                return this;
            case 5:
                if (endSide == 5) {
                    ConstraintLayout.b bVar9 = this.f4211a;
                    bVar9.f4097m = endID;
                    bVar9.f4095l = -1;
                    bVar9.f4093k = -1;
                    bVar9.f4089i = -1;
                    bVar9.f4091j = -1;
                }
                if (endSide == 3) {
                    ConstraintLayout.b bVar10 = this.f4211a;
                    bVar10.f4099n = endID;
                    bVar10.f4095l = -1;
                    bVar10.f4093k = -1;
                    bVar10.f4089i = -1;
                    bVar10.f4091j = -1;
                } else {
                    if (endSide != 4) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.b bVar11 = this.f4211a;
                    bVar11.f4101o = endID;
                    bVar11.f4095l = -1;
                    bVar11.f4093k = -1;
                    bVar11.f4089i = -1;
                    bVar11.f4091j = -1;
                }
                this.f4211a.D = margin;
                return this;
            case 6:
                if (endSide == 6) {
                    ConstraintLayout.b bVar12 = this.f4211a;
                    bVar12.f4111t = endID;
                    bVar12.f4109s = -1;
                } else {
                    if (endSide != 7) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.b bVar13 = this.f4211a;
                    bVar13.f4109s = endID;
                    bVar13.f4111t = -1;
                }
                this.f4211a.setMarginStart(margin);
                return this;
            case 7:
                if (endSide == 7) {
                    ConstraintLayout.b bVar14 = this.f4211a;
                    bVar14.f4115v = endID;
                    bVar14.f4113u = -1;
                } else {
                    if (endSide != 6) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.b bVar15 = this.f4211a;
                    bVar15.f4113u = endID;
                    bVar15.f4115v = -1;
                }
                this.f4211a.setMarginEnd(margin);
                return this;
            default:
                throw new IllegalArgumentException(K(startSide) + " to " + K(endSide) + " unknown");
        }
    }

    public c n(int height) {
        this.f4211a.Q = height;
        return this;
    }

    public c o(int width) {
        this.f4211a.P = width;
        return this;
    }

    public c p(int height) {
        ((ViewGroup.MarginLayoutParams) this.f4211a).height = height;
        return this;
    }

    public c q(int height) {
        this.f4211a.U = height;
        return this;
    }

    public c r(int width) {
        this.f4211a.T = width;
        return this;
    }

    public c s(int height) {
        this.f4211a.S = height;
        return this;
    }

    public c t(int width) {
        this.f4211a.R = width;
        return this;
    }

    public c u(int width) {
        ((ViewGroup.MarginLayoutParams) this.f4211a).width = width;
        return this;
    }

    public c v(String ratio) {
        this.f4211a.I = ratio;
        return this;
    }

    public c w(float elevation) {
        this.f4212b.setElevation(elevation);
        return this;
    }

    public c x(int anchor, int value) {
        switch (anchor) {
            case 1:
                this.f4211a.f4117w = value;
                return this;
            case 2:
                this.f4211a.f4120y = value;
                return this;
            case 3:
                this.f4211a.f4119x = value;
                return this;
            case 4:
                this.f4211a.f4121z = value;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.f4211a.A = value;
                return this;
            case 7:
                this.f4211a.B = value;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public c y(float bias) {
        this.f4211a.G = bias;
        return this;
    }

    public c z(int chainStyle) {
        this.f4211a.N = chainStyle;
        return this;
    }
}
