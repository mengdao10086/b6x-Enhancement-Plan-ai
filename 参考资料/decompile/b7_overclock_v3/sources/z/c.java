package z;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.k;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class c extends k {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f57582v = "CircularFlow";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f57583w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static float f57584x;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConstraintLayout f57585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f57586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f57587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f57588o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f57589p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f57590q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f57591r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f57592s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Float f57593t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f57594u;

    public c(Context context) {
        super(context);
    }

    public static float[] Q(float[] array, int index) {
        float[] fArr = new float[array.length - 1];
        int i10 = 0;
        for (int i11 = 0; i11 < array.length; i11++) {
            if (i11 != index) {
                fArr[i10] = array[i11];
                i10++;
            }
        }
        return fArr;
    }

    public static int[] R(int[] array, int index) {
        int[] iArr = new int[array.length - 1];
        int i10 = 0;
        for (int i11 = 0; i11 < array.length; i11++) {
            if (i11 != index) {
                iArr[i10] = array[i11];
                i10++;
            }
        }
        return iArr;
    }

    private void setAngles(String idList) {
        if (idList == null) {
            return;
        }
        int i10 = 0;
        this.f57590q = 0;
        while (true) {
            int iIndexOf = idList.indexOf(44, i10);
            if (iIndexOf == -1) {
                K(idList.substring(i10).trim());
                return;
            } else {
                K(idList.substring(i10, iIndexOf).trim());
                i10 = iIndexOf + 1;
            }
        }
    }

    private void setRadius(String idList) {
        if (idList == null) {
            return;
        }
        int i10 = 0;
        this.f57589p = 0;
        while (true) {
            int iIndexOf = idList.indexOf(44, i10);
            if (iIndexOf == -1) {
                L(idList.substring(i10).trim());
                return;
            } else {
                L(idList.substring(i10, iIndexOf).trim());
                i10 = iIndexOf + 1;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.a
    public int A(View view) {
        int iA = super.A(view);
        if (iA == -1) {
            return iA;
        }
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.H(this.f57585l);
        dVar.F(view.getId(), 8);
        dVar.r(this.f57585l);
        float[] fArr = this.f57587n;
        if (iA < fArr.length) {
            this.f57587n = P(fArr, iA);
            this.f57590q--;
        }
        int[] iArr = this.f57588o;
        if (iA < iArr.length) {
            this.f57588o = S(iArr, iA);
            this.f57589p--;
        }
        N();
        return iA;
    }

    public final void K(String angleString) {
        float[] fArr;
        if (angleString == null || angleString.length() == 0 || this.f4171c == null || (fArr = this.f57587n) == null) {
            return;
        }
        if (this.f57590q + 1 > fArr.length) {
            this.f57587n = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.f57587n[this.f57590q] = Integer.parseInt(angleString);
        this.f57590q++;
    }

    public final void L(String radiusString) {
        int[] iArr;
        if (radiusString == null || radiusString.length() == 0 || this.f4171c == null || (iArr = this.f57588o) == null) {
            return;
        }
        if (this.f57589p + 1 > iArr.length) {
            this.f57588o = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.f57588o[this.f57589p] = (int) (Integer.parseInt(radiusString) * this.f4171c.getResources().getDisplayMetrics().density);
        this.f57589p++;
    }

    public void M(View view, int radius, float angle) {
        if (s(view.getId())) {
            return;
        }
        o(view);
        this.f57590q++;
        float[] angles = getAngles();
        this.f57587n = angles;
        angles[this.f57590q - 1] = angle;
        this.f57589p++;
        int[] radius2 = getRadius();
        this.f57588o = radius2;
        radius2[this.f57589p - 1] = (int) (radius * this.f4171c.getResources().getDisplayMetrics().density);
        N();
    }

    public final void N() {
        this.f57585l = (ConstraintLayout) getParent();
        for (int i10 = 0; i10 < this.f4170b; i10++) {
            View viewS = this.f57585l.s(this.f4169a[i10]);
            if (viewS != null) {
                int i11 = f57583w;
                float f10 = f57584x;
                int[] iArr = this.f57588o;
                if (iArr == null || i10 >= iArr.length) {
                    Integer num = this.f57594u;
                    if (num == null || num.intValue() == -1) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Added radius to view with id: ");
                        sb2.append(this.f4177i.get(Integer.valueOf(viewS.getId())));
                    } else {
                        this.f57589p++;
                        if (this.f57588o == null) {
                            this.f57588o = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f57588o = radius;
                        radius[this.f57589p - 1] = i11;
                    }
                } else {
                    i11 = iArr[i10];
                }
                float[] fArr = this.f57587n;
                if (fArr == null || i10 >= fArr.length) {
                    Float f11 = this.f57593t;
                    if (f11 == null || f11.floatValue() == -1.0f) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Added angle to view with id: ");
                        sb3.append(this.f4177i.get(Integer.valueOf(viewS.getId())));
                    } else {
                        this.f57590q++;
                        if (this.f57587n == null) {
                            this.f57587n = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f57587n = angles;
                        angles[this.f57590q - 1] = f10;
                    }
                } else {
                    f10 = fArr[i10];
                }
                ConstraintLayout.b bVar = (ConstraintLayout.b) viewS.getLayoutParams();
                bVar.f4107r = f10;
                bVar.f4103p = this.f57586m;
                bVar.f4105q = i11;
                viewS.setLayoutParams(bVar);
            }
        }
        p();
    }

    public boolean O(View view) {
        return s(view.getId()) && x(view.getId()) != -1;
    }

    public final float[] P(float[] angles, int index) {
        return (angles == null || index < 0 || index >= this.f57590q) ? angles : Q(angles, index);
    }

    public final int[] S(int[] radius, int index) {
        return (radius == null || index < 0 || index >= this.f57589p) ? radius : R(radius, index);
    }

    public void T(View view, float angle) {
        if (!O(view)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("It was not possible to update angle to view with id: ");
            sb2.append(view.getId());
            return;
        }
        int iX = x(view.getId());
        if (iX > this.f57587n.length) {
            return;
        }
        float[] angles = getAngles();
        this.f57587n = angles;
        angles[iX] = angle;
        N();
    }

    public void U(View view, int radius) {
        if (!O(view)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("It was not possible to update radius to view with id: ");
            sb2.append(view.getId());
            return;
        }
        int iX = x(view.getId());
        if (iX > this.f57588o.length) {
            return;
        }
        int[] radius2 = getRadius();
        this.f57588o = radius2;
        radius2[iX] = (int) (radius * this.f4171c.getResources().getDisplayMetrics().density);
        N();
    }

    public void V(View view, int radius, float angle) {
        if (!O(view)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("It was not possible to update radius and angle to view with id: ");
            sb2.append(view.getId());
            return;
        }
        int iX = x(view.getId());
        if (getAngles().length > iX) {
            float[] angles = getAngles();
            this.f57587n = angles;
            angles[iX] = angle;
        }
        if (getRadius().length > iX) {
            int[] radius2 = getRadius();
            this.f57588o = radius2;
            radius2[iX] = (int) (radius * this.f4171c.getResources().getDisplayMetrics().density);
        }
        N();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f57587n, this.f57590q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f57588o, this.f57589p);
    }

    @Override // androidx.constraintlayout.widget.k, androidx.constraintlayout.widget.a, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f57591r;
        if (str != null) {
            this.f57587n = new float[1];
            setAngles(str);
        }
        String str2 = this.f57592s;
        if (str2 != null) {
            this.f57588o = new int[1];
            setRadius(str2);
        }
        Float f10 = this.f57593t;
        if (f10 != null) {
            setDefaultAngle(f10.floatValue());
        }
        Integer num = this.f57594u;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        N();
    }

    public void setDefaultAngle(float angle) {
        f57584x = angle;
    }

    public void setDefaultRadius(int radius) {
        f57583w = radius;
    }

    @Override // androidx.constraintlayout.widget.k, androidx.constraintlayout.widget.a
    public void y(AttributeSet attrs) {
        super.y(attrs);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f57586m = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f57591r = string;
                    setAngles(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f57592s = string2;
                    setRadius(string2);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, f57584x));
                    this.f57593t = fValueOf;
                    setDefaultAngle(fValueOf.floatValue());
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, f57583w));
                    this.f57594u = numValueOf;
                    setDefaultRadius(numValueOf.intValue());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public c(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public c(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
