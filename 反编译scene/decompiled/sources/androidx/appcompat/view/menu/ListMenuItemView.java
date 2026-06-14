package androidx.appcompat.view.menu;

import a.c0;
import a.eh;
import a.l4;
import a.o8;
import a.t;
import a.w4;
import a.y;
import a.z;
import android.R;
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

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ListMenuItemView extends LinearLayout implements w4.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8142a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l4 f3999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f4000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LayoutInflater f4002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CheckBox f4003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f4004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinearLayout f4005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RadioButton f4006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f4007a;
    public Drawable b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ImageView f4008b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f4009b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4010b;
    public ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4011c;
    public boolean d;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        o8 o8VarV = o8.v(getContext(), attributeSet, c0.MenuView, i, 0);
        this.f4001a = o8VarV.g(c0.MenuView_android_itemBackground);
        this.f8142a = o8VarV.n(c0.MenuView_android_itemTextAppearance, -1);
        this.f4010b = o8VarV.a(c0.MenuView_preserveIconSpacing, false);
        this.f4000a = context;
        this.b = o8VarV.g(c0.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, t.dropDownListViewStyle, 0);
        this.f4011c = typedArrayObtainStyledAttributes.hasValue(0);
        o8VarV.w();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f4002a == null) {
            this.f4002a = LayoutInflater.from(getContext());
        }
        return this.f4002a;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f4008b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // a.w4.a
    public boolean a() {
        return false;
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.c;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        rect.top += this.c.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b(View view) {
        c(view, -1);
    }

    public final void c(View view, int i) {
        LinearLayout linearLayout = this.f4005a;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    public final void d() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(z.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f4003a = checkBox;
        b(checkBox);
    }

    @Override // a.w4.a
    public void e(l4 l4Var, int i) {
        this.f3999a = l4Var;
        setVisibility(l4Var.isVisible() ? 0 : 8);
        setTitle(l4Var.k(this));
        setCheckable(l4Var.isCheckable());
        h(l4Var.C(), l4Var.i());
        setIcon(l4Var.getIcon());
        setEnabled(l4Var.isEnabled());
        setSubMenuArrowVisible(l4Var.hasSubMenu());
        setContentDescription(l4Var.getContentDescription());
    }

    public final void f() {
        ImageView imageView = (ImageView) getInflater().inflate(z.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f4004a = imageView;
        c(imageView, 0);
    }

    public final void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(z.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f4006a = radioButton;
        b(radioButton);
    }

    @Override // a.w4.a
    public l4 getItemData() {
        return this.f3999a;
    }

    public void h(boolean z, char c) {
        int i = (z && this.f3999a.C()) ? 0 : 8;
        if (i == 0) {
            this.f4009b.setText(this.f3999a.j());
        }
        if (this.f4009b.getVisibility() != i) {
            this.f4009b.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        eh.m0(this, this.f4001a);
        TextView textView = (TextView) findViewById(y.title);
        this.f4007a = textView;
        int i = this.f8142a;
        if (i != -1) {
            textView.setTextAppearance(this.f4000a, i);
        }
        this.f4009b = (TextView) findViewById(y.shortcut);
        ImageView imageView = (ImageView) findViewById(y.submenuarrow);
        this.f4008b = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.b);
        }
        this.c = (ImageView) findViewById(y.group_divider);
        this.f4005a = (LinearLayout) findViewById(y.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f4004a != null && this.f4010b) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f4004a.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f4006a == null && this.f4003a == null) {
            return;
        }
        if (this.f3999a.o()) {
            if (this.f4006a == null) {
                g();
            }
            compoundButton = this.f4006a;
            compoundButton2 = this.f4003a;
        } else {
            if (this.f4003a == null) {
                d();
            }
            compoundButton = this.f4003a;
            compoundButton2 = this.f4006a;
        }
        if (z) {
            compoundButton.setChecked(this.f3999a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f4003a;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f4006a;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f3999a.o()) {
            if (this.f4006a == null) {
                g();
            }
            compoundButton = this.f4006a;
        } else {
            if (this.f4003a == null) {
                d();
            }
            compoundButton = this.f4003a;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.d = z;
        this.f4010b = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setVisibility((this.f4011c || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f3999a.B() || this.d;
        if (z || this.f4010b) {
            if (this.f4004a == null && drawable == null && !this.f4010b) {
                return;
            }
            if (this.f4004a == null) {
                f();
            }
            if (drawable == null && !this.f4010b) {
                this.f4004a.setVisibility(8);
                return;
            }
            ImageView imageView = this.f4004a;
            if (!z) {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.f4004a.getVisibility() != 0) {
                this.f4004a.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i;
        TextView textView;
        if (charSequence != null) {
            this.f4007a.setText(charSequence);
            if (this.f4007a.getVisibility() == 0) {
                return;
            }
            textView = this.f4007a;
            i = 0;
        } else {
            i = 8;
            if (this.f4007a.getVisibility() == 8) {
                return;
            } else {
                textView = this.f4007a;
            }
        }
        textView.setVisibility(i);
    }
}
