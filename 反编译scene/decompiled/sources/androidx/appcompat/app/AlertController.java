package androidx.appcompat.app;

import a.c0;
import a.eh;
import a.g0;
import a.h0;
import a.i0;
import a.j0;
import a.k0;
import a.m7;
import a.r0;
import a.t;
import a.y;
import a.y1;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class AlertController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final y1 f3959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f3961a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f3962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Message f3963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f3965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Window f3966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Button f3967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f3968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ListAdapter f3969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ListView f3970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f3971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NestedScrollView f3972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f3973a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f3975b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Message f3976b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f3977b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Button f3978b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f3979b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f3980b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3981b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Drawable f3982c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Message f3983c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Button f3984c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f3985c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public Drawable f3986d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public CharSequence f3987d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public CharSequence f3988e;
    public int f;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3974a = false;
    public int g = 0;
    public int h = -1;
    public int o = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View.OnClickListener f3964a = new g0(this);

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8138a;
        public final int b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.RecycleListView);
            this.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(c0.RecycleListView_paddingBottomNoButtons, -1);
            this.f8138a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(c0.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f8138a, getPaddingRight(), z2 ? getPaddingBottom() : this.b);
        }
    }

    public AlertController(Context context, y1 y1Var, Window window) {
        this.f3960a = context;
        this.f3959a = y1Var;
        this.f3966a = window;
        this.f3962a = new r0(y1Var);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, c0.AlertDialog, t.alertDialogStyle, 0);
        this.i = typedArrayObtainStyledAttributes.getResourceId(c0.AlertDialog_android_layout, 0);
        this.j = typedArrayObtainStyledAttributes.getResourceId(c0.AlertDialog_buttonPanelSideLayout, 0);
        this.k = typedArrayObtainStyledAttributes.getResourceId(c0.AlertDialog_listLayout, 0);
        this.l = typedArrayObtainStyledAttributes.getResourceId(c0.AlertDialog_multiChoiceItemLayout, 0);
        this.m = typedArrayObtainStyledAttributes.getResourceId(c0.AlertDialog_singleChoiceItemLayout, 0);
        this.n = typedArrayObtainStyledAttributes.getResourceId(c0.AlertDialog_listItemLayout, 0);
        this.f3981b = typedArrayObtainStyledAttributes.getBoolean(c0.AlertDialog_showTitle, true);
        this.f8137a = typedArrayObtainStyledAttributes.getDimensionPixelSize(c0.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        y1Var.d(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void f(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(t.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public int c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f3960a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f3970a;
    }

    public void e() {
        this.f3959a.setContentView(j());
        y();
    }

    public boolean g(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f3972a;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public boolean h(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f3972a;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public final ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final int j() {
        int i = this.j;
        return (i != 0 && this.o == 1) ? i : this.i;
    }

    public void k(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f3962a.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.f3988e = charSequence;
            this.f3983c = message;
            this.f3982c = drawable;
        } else if (i == -2) {
            this.f3987d = charSequence;
            this.f3976b = message;
            this.f3975b = drawable;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f3985c = charSequence;
            this.f3963a = message;
            this.f3961a = drawable;
        }
    }

    public void l(View view) {
        this.f3977b = view;
    }

    public void m(int i) {
        this.f3986d = null;
        this.g = i;
        ImageView imageView = this.f3968a;
        if (imageView != null) {
            if (i == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f3968a.setImageResource(this.g);
            }
        }
    }

    public void n(Drawable drawable) {
        this.f3986d = drawable;
        this.g = 0;
        ImageView imageView = this.f3968a;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f3968a.setImageDrawable(drawable);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f3980b = charSequence;
        TextView textView = this.f3979b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void p(ViewGroup viewGroup, View view, int i, int i2) {
        View viewFindViewById = this.f3966a.findViewById(y.scrollIndicatorUp);
        View viewFindViewById2 = this.f3966a.findViewById(y.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            eh.y0(view, i, i2);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 == null) {
                return;
            }
        } else {
            if (viewFindViewById != null && (i & 1) == 0) {
                viewGroup.removeView(viewFindViewById);
                viewFindViewById = null;
            }
            if (viewFindViewById2 != null && (i & 2) == 0) {
                viewGroup.removeView(viewFindViewById2);
                viewFindViewById2 = null;
            }
            if (viewFindViewById == null && viewFindViewById2 == null) {
                return;
            }
            if (this.f3980b != null) {
                this.f3972a.setOnScrollChangeListener(new h0(this, viewFindViewById, viewFindViewById2));
                this.f3972a.post(new i0(this, viewFindViewById, viewFindViewById2));
                return;
            }
            ListView listView = this.f3970a;
            if (listView != null) {
                listView.setOnScrollListener(new j0(this, viewFindViewById, viewFindViewById2));
                this.f3970a.post(new k0(this, viewFindViewById, viewFindViewById2));
                return;
            } else {
                if (viewFindViewById != null) {
                    viewGroup.removeView(viewFindViewById);
                }
                if (viewFindViewById2 == null) {
                    return;
                }
            }
        }
        viewGroup.removeView(viewFindViewById2);
    }

    public void q(CharSequence charSequence) {
        this.f3973a = charSequence;
        TextView textView = this.f3971a;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i) {
        this.f3965a = null;
        this.b = i;
        this.f3974a = false;
    }

    public void s(View view) {
        this.f3965a = view;
        this.b = 0;
        this.f3974a = false;
    }

    public void t(View view, int i, int i2, int i3, int i4) {
        this.f3965a = view;
        this.b = 0;
        this.f3974a = true;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public final void u(ViewGroup viewGroup) {
        int i;
        Button button;
        Button button2 = (Button) viewGroup.findViewById(R.id.button1);
        this.f3967a = button2;
        button2.setOnClickListener(this.f3964a);
        if (TextUtils.isEmpty(this.f3985c) && this.f3961a == null) {
            this.f3967a.setVisibility(8);
            i = 0;
        } else {
            this.f3967a.setText(this.f3985c);
            Drawable drawable = this.f3961a;
            if (drawable != null) {
                int i2 = this.f8137a;
                drawable.setBounds(0, 0, i2, i2);
                this.f3967a.setCompoundDrawables(this.f3961a, null, null, null);
            }
            this.f3967a.setVisibility(0);
            i = 1;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button2);
        this.f3978b = button3;
        button3.setOnClickListener(this.f3964a);
        if (TextUtils.isEmpty(this.f3987d) && this.f3975b == null) {
            this.f3978b.setVisibility(8);
        } else {
            this.f3978b.setText(this.f3987d);
            Drawable drawable2 = this.f3975b;
            if (drawable2 != null) {
                int i3 = this.f8137a;
                drawable2.setBounds(0, 0, i3, i3);
                this.f3978b.setCompoundDrawables(this.f3975b, null, null, null);
            }
            this.f3978b.setVisibility(0);
            i |= 2;
        }
        Button button4 = (Button) viewGroup.findViewById(R.id.button3);
        this.f3984c = button4;
        button4.setOnClickListener(this.f3964a);
        if (TextUtils.isEmpty(this.f3988e) && this.f3982c == null) {
            this.f3984c.setVisibility(8);
        } else {
            this.f3984c.setText(this.f3988e);
            Drawable drawable3 = this.f3982c;
            if (drawable3 != null) {
                int i4 = this.f8137a;
                drawable3.setBounds(0, 0, i4, i4);
                this.f3984c.setCompoundDrawables(this.f3982c, null, null, null);
            }
            this.f3984c.setVisibility(0);
            i |= 4;
        }
        if (z(this.f3960a)) {
            if (i == 1) {
                button = this.f3967a;
            } else if (i == 2) {
                button = this.f3978b;
            } else if (i == 4) {
                button = this.f3984c;
            }
            b(button);
        }
        if (i != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f3966a.findViewById(y.scrollView);
        this.f3972a = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f3972a.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f3979b = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f3980b;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f3972a.removeView(this.f3979b);
        if (this.f3970a == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f3972a.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f3972a);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f3970a, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void w(ViewGroup viewGroup) {
        View viewInflate = this.f3965a;
        if (viewInflate == null) {
            viewInflate = this.b != 0 ? LayoutInflater.from(this.f3960a).inflate(this.b, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !a(viewInflate)) {
            this.f3966a.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f3966a.findViewById(y.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f3974a) {
            frameLayout.setPadding(this.c, this.d, this.e, this.f);
        }
        if (this.f3970a != null) {
            ((m7.a) viewGroup.getLayoutParams()).f6778a = 0.0f;
        }
    }

    public final void x(ViewGroup viewGroup) {
        if (this.f3977b != null) {
            viewGroup.addView(this.f3977b, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f3966a.findViewById(y.title_template).setVisibility(8);
            return;
        }
        this.f3968a = (ImageView) this.f3966a.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f3973a)) || !this.f3981b) {
            this.f3966a.findViewById(y.title_template).setVisibility(8);
            this.f3968a.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f3966a.findViewById(y.alertTitle);
        this.f3971a = textView;
        textView.setText(this.f3973a);
        int i = this.g;
        if (i != 0) {
            this.f3968a.setImageResource(i);
            return;
        }
        Drawable drawable = this.f3986d;
        if (drawable != null) {
            this.f3968a.setImageDrawable(drawable);
        } else {
            this.f3971a.setPadding(this.f3968a.getPaddingLeft(), this.f3968a.getPaddingTop(), this.f3968a.getPaddingRight(), this.f3968a.getPaddingBottom());
            this.f3968a.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f3966a.findViewById(y.parentPanel);
        View viewFindViewById4 = viewFindViewById3.findViewById(y.topPanel);
        View viewFindViewById5 = viewFindViewById3.findViewById(y.contentPanel);
        View viewFindViewById6 = viewFindViewById3.findViewById(y.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(y.customPanel);
        w(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(y.topPanel);
        View viewFindViewById8 = viewGroup.findViewById(y.contentPanel);
        View viewFindViewById9 = viewGroup.findViewById(y.buttonPanel);
        ViewGroup viewGroupI = i(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupI2 = i(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupI3 = i(viewFindViewById9, viewFindViewById6);
        v(viewGroupI2);
        u(viewGroupI3);
        x(viewGroupI);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupI == null || viewGroupI.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (viewGroupI3 == null || viewGroupI3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupI2 != null && (viewFindViewById2 = viewGroupI2.findViewById(y.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            NestedScrollView nestedScrollView = this.f3972a;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f3980b == null && this.f3970a == null) ? null : viewGroupI.findViewById(y.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupI2 != null && (viewFindViewById = viewGroupI2.findViewById(y.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f3970a;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z2, z3);
        }
        if (!z) {
            View view = this.f3970a;
            if (view == null) {
                view = this.f3972a;
            }
            if (view != null) {
                p(viewGroupI2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f3970a;
        if (listView2 == null || (listAdapter = this.f3969a) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i = this.h;
        if (i > -1) {
            listView2.setItemChecked(i, true);
            listView2.setSelection(i);
        }
    }
}
