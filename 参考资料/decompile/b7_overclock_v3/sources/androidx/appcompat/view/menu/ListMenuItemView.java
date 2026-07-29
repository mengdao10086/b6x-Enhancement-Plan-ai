package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.y0;
import androidx.core.view.u0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f1850r = "ListMenuItemView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f1851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f1852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f1853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f1854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CheckBox f1855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f1856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f1857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f1858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f1859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f1860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1861k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f1862l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1863m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f1864n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1865o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayoutInflater f1866p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1867q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f1866p == null) {
            this.f1866p = LayoutInflater.from(getContext());
        }
        return this.f1866p;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f1857g;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1858h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1858h.getLayoutParams();
        rect.top += this.f1858h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b(View view, int i10) {
        LinearLayout linearLayout = this.f1859i;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void c(boolean z10, char c10) {
        int i10 = (z10 && this.f1851a.D()) ? 0 : 8;
        if (i10 == 0) {
            this.f1856f.setText(this.f1851a.k());
        }
        if (this.f1856f.getVisibility() != i10) {
            this.f1856f.setVisibility(i10);
        }
    }

    public final void d() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f1855e = checkBox;
        a(checkBox);
    }

    public final void e() {
        ImageView imageView = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f1852b = imageView;
        b(imageView, 0);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean g() {
        return this.f1867q;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.f1851a;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void h(h hVar, int i10) {
        this.f1851a = hVar;
        setVisibility(hVar.isVisible() ? 0 : 8);
        setTitle(hVar.l(this));
        setCheckable(hVar.isCheckable());
        c(hVar.D(), hVar.j());
        setIcon(hVar.getIcon());
        setEnabled(hVar.isEnabled());
        setSubMenuArrowVisible(hVar.hasSubMenu());
        setContentDescription(hVar.getContentDescription());
    }

    public final void i() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f1853c = radioButton;
        a(radioButton);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        u0.I1(this, this.f1860j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f1854d = textView;
        int i10 = this.f1861k;
        if (i10 != -1) {
            textView.setTextAppearance(this.f1862l, i10);
        }
        this.f1856f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f1857g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1864n);
        }
        this.f1858h = (ImageView) findViewById(R.id.group_divider);
        this.f1859i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f1852b != null && this.f1863m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1852b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z10 && this.f1853c == null && this.f1855e == null) {
            return;
        }
        if (this.f1851a.p()) {
            if (this.f1853c == null) {
                i();
            }
            compoundButton = this.f1853c;
            compoundButton2 = this.f1855e;
        } else {
            if (this.f1855e == null) {
                d();
            }
            compoundButton = this.f1855e;
            compoundButton2 = this.f1853c;
        }
        if (z10) {
            compoundButton.setChecked(this.f1851a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f1855e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1853c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f1851a.p()) {
            if (this.f1853c == null) {
                i();
            }
            compoundButton = this.f1853c;
        } else {
            if (this.f1855e == null) {
                d();
            }
            compoundButton = this.f1855e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f1867q = z10;
        this.f1863m = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f1858h;
        if (imageView != null) {
            imageView.setVisibility((this.f1865o || !z10) ? 8 : 0);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setIcon(Drawable drawable) {
        boolean z10 = this.f1851a.C() || this.f1867q;
        if (z10 || this.f1863m) {
            ImageView imageView = this.f1852b;
            if (imageView == null && drawable == null && !this.f1863m) {
                return;
            }
            if (imageView == null) {
                e();
            }
            if (drawable == null && !this.f1863m) {
                this.f1852b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f1852b;
            if (!z10) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f1852b.getVisibility() != 0) {
                this.f1852b.setVisibility(0);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f1854d.getVisibility() != 8) {
                this.f1854d.setVisibility(8);
            }
        } else {
            this.f1854d.setText(charSequence);
            if (this.f1854d.getVisibility() != 0) {
                this.f1854d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        y0 y0VarG = y0.G(getContext(), attributeSet, R.styleable.MenuView, i10, 0);
        this.f1860j = y0VarG.h(R.styleable.MenuView_android_itemBackground);
        this.f1861k = y0VarG.u(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f1863m = y0VarG.a(R.styleable.MenuView_preserveIconSpacing, false);
        this.f1862l = context;
        this.f1864n = y0VarG.h(R.styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f1865o = typedArrayObtainStyledAttributes.hasValue(0);
        y0VarG.I();
        typedArrayObtainStyledAttributes.recycle();
    }
}
