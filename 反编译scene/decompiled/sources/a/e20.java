package a;

import a.nz;
import android.R;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class e20 extends f20 {
    public static final boolean c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public iz f640a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StateListDrawable f642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextWatcher f643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View.OnFocusChangeListener f644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AccessibilityManager f645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextInputLayout.e f646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextInputLayout.f f647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.g f648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f649a;
    public ValueAnimator b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f650b;

    static {
        c = Build.VERSION.SDK_INT >= 21;
    }

    public e20(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f643a = new v10(this);
        this.f644a = new w10(this);
        this.f646a = new x10(this, ((f20) this).f838a);
        this.f647a = new y10(this);
        this.f648a = new z10(this);
        this.f649a = false;
        this.f650b = false;
        this.f5959a = Long.MAX_VALUE;
    }

    public final void A() {
        this.b = y(67, 0.0f, 1.0f);
        ValueAnimator valueAnimatorY = y(50, 1.0f, 0.0f);
        this.f641a = valueAnimatorY;
        valueAnimatorY.addListener(new d20(this));
    }

    public final boolean B() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f5959a;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    public final void C(boolean z) {
        if (this.f650b != z) {
            this.f650b = z;
            this.b.cancel();
            this.f641a.start();
        }
    }

    public final void D(AutoCompleteTextView autoCompleteTextView) {
        Drawable drawable;
        if (c) {
            int boxBackgroundMode = ((f20) this).f838a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                drawable = this.f640a;
            } else if (boxBackgroundMode != 1) {
                return;
            } else {
                drawable = this.f642a;
            }
            autoCompleteTextView.setDropDownBackgroundDrawable(drawable);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void E(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new b20(this, autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f644a);
        if (c) {
            autoCompleteTextView.setOnDismissListener(new c20(this));
        }
    }

    public final void F(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (B()) {
            this.f649a = false;
        }
        if (this.f649a) {
            this.f649a = false;
            return;
        }
        if (c) {
            C(!this.f650b);
        } else {
            this.f650b = !this.f650b;
            ((f20) this).f837a.toggle();
        }
        if (!this.f650b) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    @Override // a.f20
    public void a() {
        float dimensionPixelOffset = ((f20) this).f6066a.getResources().getDimensionPixelOffset(bv.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = ((f20) this).f6066a.getResources().getDimensionPixelOffset(bv.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = ((f20) this).f6066a.getResources().getDimensionPixelOffset(bv.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        iz izVarZ = z(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        iz izVarZ2 = z(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f640a = izVarZ;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f642a = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, izVarZ);
        this.f642a.addState(new int[0], izVarZ2);
        ((f20) this).f838a.setEndIconDrawable(r2.d(((f20) this).f6066a, c ? cv.mtrl_dropdown_arrow : cv.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = ((f20) this).f838a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(hv.exposed_dropdown_menu_content_description));
        ((f20) this).f838a.setEndIconOnClickListener(new a20(this));
        ((f20) this).f838a.e(this.f647a);
        ((f20) this).f838a.f(this.f648a);
        A();
        eh.t0(((f20) this).f837a, 2);
        this.f645a = (AccessibilityManager) ((f20) this).f6066a.getSystemService("accessibility");
    }

    @Override // a.f20
    public boolean b(int i) {
        return i != 0;
    }

    @Override // a.f20
    public boolean d() {
        return true;
    }

    public final void u(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int boxBackgroundMode = ((f20) this).f838a.getBoxBackgroundMode();
        iz boxBackground = ((f20) this).f838a.getBoxBackground();
        int iC = iw.c(autoCompleteTextView, zu.colorControlHighlight);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            w(autoCompleteTextView, iC, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            v(autoCompleteTextView, iC, iArr, boxBackground);
        }
    }

    public final void v(AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, iz izVar) {
        int boxBackgroundColor = ((f20) this).f838a.getBoxBackgroundColor();
        int[] iArr2 = {iw.f(i, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (c) {
            eh.m0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), izVar, izVar));
            return;
        }
        iz izVar2 = new iz(izVar.B());
        izVar2.U(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{izVar, izVar2});
        int iD = eh.D(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int iC = eh.C(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        eh.m0(autoCompleteTextView, layerDrawable);
        eh.w0(autoCompleteTextView, iD, paddingTop, iC, paddingBottom);
    }

    public final void w(AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, iz izVar) {
        LayerDrawable layerDrawable;
        int iC = iw.c(autoCompleteTextView, zu.colorSurface);
        iz izVar2 = new iz(izVar.B());
        int iF = iw.f(i, iC, 0.1f);
        izVar2.U(new ColorStateList(iArr, new int[]{iF, 0}));
        if (c) {
            izVar2.setTint(iC);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iF, iC});
            iz izVar3 = new iz(izVar.B());
            izVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, izVar2, izVar3), izVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{izVar2, izVar});
        }
        eh.m0(autoCompleteTextView, layerDrawable);
    }

    public final AutoCompleteTextView x(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public final ValueAnimator y(int i, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(kv.f6644a);
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.addUpdateListener(new u10(this));
        return valueAnimatorOfFloat;
    }

    public final iz z(float f, float f2, float f3, int i) {
        nz.a aVarA = nz.a();
        aVarA.z(f);
        aVarA.D(f);
        aVarA.r(f2);
        aVarA.v(f2);
        nz nzVarM = aVarA.m();
        iz izVarM = iz.m(((f20) this).f6066a, f3);
        izVarM.setShapeAppearanceModel(nzVarM);
        izVarM.W(0, i, 0, i);
        return izVarM;
    }
}
