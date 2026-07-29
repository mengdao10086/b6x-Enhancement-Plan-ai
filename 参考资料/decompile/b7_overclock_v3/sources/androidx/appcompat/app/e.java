package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import g.c1;
import g.d1;
import g.n0;
import g.p0;
import g.v;

/* JADX INFO: loaded from: classes2.dex */
public class e extends j implements DialogInterface {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1628g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f1629h = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AlertController f1630f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AlertController.f f1631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1632b;

        public a(@n0 Context context) {
            this(context, e.n(context, 0));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public a A(boolean z10) {
            this.f1631a.Q = z10;
            return this;
        }

        public a B(@g.e int i10, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1500v = fVar.f1479a.getResources().getTextArray(i10);
            AlertController.f fVar2 = this.f1631a;
            fVar2.f1502x = onClickListener;
            fVar2.I = i11;
            fVar2.H = true;
            return this;
        }

        public a C(Cursor cursor, int i10, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.K = cursor;
            fVar.f1502x = onClickListener;
            fVar.I = i10;
            fVar.L = str;
            fVar.H = true;
            return this;
        }

        public a D(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1501w = listAdapter;
            fVar.f1502x = onClickListener;
            fVar.I = i10;
            fVar.H = true;
            return this;
        }

        public a E(CharSequence[] charSequenceArr, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1500v = charSequenceArr;
            fVar.f1502x = onClickListener;
            fVar.I = i10;
            fVar.H = true;
            return this;
        }

        public a F(@c1 int i10) {
            AlertController.f fVar = this.f1631a;
            fVar.f1484f = fVar.f1479a.getText(i10);
            return this;
        }

        public a G(int i10) {
            AlertController.f fVar = this.f1631a;
            fVar.f1504z = null;
            fVar.f1503y = i10;
            fVar.E = false;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public a H(View view, int i10, int i11, int i12, int i13) {
            AlertController.f fVar = this.f1631a;
            fVar.f1504z = view;
            fVar.f1503y = 0;
            fVar.E = true;
            fVar.A = i10;
            fVar.B = i11;
            fVar.C = i12;
            fVar.D = i13;
            return this;
        }

        public e I() {
            e eVarCreate = create();
            eVarCreate.show();
            return eVarCreate;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1501w = listAdapter;
            fVar.f1502x = onClickListener;
            return this;
        }

        public a b(boolean z10) {
            this.f1631a.f1496r = z10;
            return this;
        }

        public a c(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.f fVar = this.f1631a;
            fVar.K = cursor;
            fVar.L = str;
            fVar.f1502x = onClickListener;
            return this;
        }

        @n0
        public e create() {
            e eVar = new e(this.f1631a.f1479a, this.f1632b);
            this.f1631a.a(eVar.f1630f);
            eVar.setCancelable(this.f1631a.f1496r);
            if (this.f1631a.f1496r) {
                eVar.setCanceledOnTouchOutside(true);
            }
            eVar.setOnCancelListener(this.f1631a.f1497s);
            eVar.setOnDismissListener(this.f1631a.f1498t);
            DialogInterface.OnKeyListener onKeyListener = this.f1631a.f1499u;
            if (onKeyListener != null) {
                eVar.setOnKeyListener(onKeyListener);
            }
            return eVar;
        }

        public a d(@p0 View view) {
            this.f1631a.f1485g = view;
            return this;
        }

        public a e(@v int i10) {
            this.f1631a.f1481c = i10;
            return this;
        }

        public a f(@p0 Drawable drawable) {
            this.f1631a.f1482d = drawable;
            return this;
        }

        public a g(@g.f int i10) {
            TypedValue typedValue = new TypedValue();
            this.f1631a.f1479a.getTheme().resolveAttribute(i10, typedValue, true);
            this.f1631a.f1481c = typedValue.resourceId;
            return this;
        }

        @n0
        public Context getContext() {
            return this.f1631a.f1479a;
        }

        @Deprecated
        public a h(boolean z10) {
            this.f1631a.N = z10;
            return this;
        }

        public a i(@g.e int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1500v = fVar.f1479a.getResources().getTextArray(i10);
            this.f1631a.f1502x = onClickListener;
            return this;
        }

        public a j(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1500v = charSequenceArr;
            fVar.f1502x = onClickListener;
            return this;
        }

        public a k(@c1 int i10) {
            AlertController.f fVar = this.f1631a;
            fVar.f1486h = fVar.f1479a.getText(i10);
            return this;
        }

        public a l(@p0 CharSequence charSequence) {
            this.f1631a.f1486h = charSequence;
            return this;
        }

        public a m(@g.e int i10, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1500v = fVar.f1479a.getResources().getTextArray(i10);
            AlertController.f fVar2 = this.f1631a;
            fVar2.J = onMultiChoiceClickListener;
            fVar2.F = zArr;
            fVar2.G = true;
            return this;
        }

        public a n(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.K = cursor;
            fVar.J = onMultiChoiceClickListener;
            fVar.M = str;
            fVar.L = str2;
            fVar.G = true;
            return this;
        }

        public a o(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1500v = charSequenceArr;
            fVar.J = onMultiChoiceClickListener;
            fVar.F = zArr;
            fVar.G = true;
            return this;
        }

        public a p(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1490l = charSequence;
            fVar.f1492n = onClickListener;
            return this;
        }

        public a q(Drawable drawable) {
            this.f1631a.f1491m = drawable;
            return this;
        }

        public a r(@c1 int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1493o = fVar.f1479a.getText(i10);
            this.f1631a.f1495q = onClickListener;
            return this;
        }

        public a s(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1493o = charSequence;
            fVar.f1495q = onClickListener;
            return this;
        }

        public a setNegativeButton(@c1 int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1490l = fVar.f1479a.getText(i10);
            this.f1631a.f1492n = onClickListener;
            return this;
        }

        public a setPositiveButton(@c1 int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1487i = fVar.f1479a.getText(i10);
            this.f1631a.f1489k = onClickListener;
            return this;
        }

        public a setTitle(@p0 CharSequence charSequence) {
            this.f1631a.f1484f = charSequence;
            return this;
        }

        public a setView(View view) {
            AlertController.f fVar = this.f1631a;
            fVar.f1504z = view;
            fVar.f1503y = 0;
            fVar.E = false;
            return this;
        }

        public a t(Drawable drawable) {
            this.f1631a.f1494p = drawable;
            return this;
        }

        public a u(DialogInterface.OnCancelListener onCancelListener) {
            this.f1631a.f1497s = onCancelListener;
            return this;
        }

        public a v(DialogInterface.OnDismissListener onDismissListener) {
            this.f1631a.f1498t = onDismissListener;
            return this;
        }

        public a w(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f1631a.O = onItemSelectedListener;
            return this;
        }

        public a x(DialogInterface.OnKeyListener onKeyListener) {
            this.f1631a.f1499u = onKeyListener;
            return this;
        }

        public a y(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1631a;
            fVar.f1487i = charSequence;
            fVar.f1489k = onClickListener;
            return this;
        }

        public a z(Drawable drawable) {
            this.f1631a.f1488j = drawable;
            return this;
        }

        public a(@n0 Context context, @d1 int i10) {
            this.f1631a = new AlertController.f(new ContextThemeWrapper(context, e.n(context, i10)));
            this.f1632b = i10;
        }
    }

    public e(@n0 Context context) {
        this(context, 0);
    }

    public static int n(@n0 Context context, @d1 int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button l(int i10) {
        return this.f1630f.c(i10);
    }

    public ListView m() {
        return this.f1630f.e();
    }

    public void o(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f1630f.l(i10, charSequence, onClickListener, null, null);
    }

    @Override // androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1630f.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.f1630f.h(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.f1630f.i(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public void p(int i10, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.f1630f.l(i10, charSequence, onClickListener, null, drawable);
    }

    public void q(int i10, CharSequence charSequence, Message message) {
        this.f1630f.l(i10, charSequence, null, message, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void r(int i10) {
        this.f1630f.m(i10);
    }

    public void s(View view) {
        this.f1630f.n(view);
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1630f.s(charSequence);
    }

    public void u(int i10) {
        this.f1630f.o(i10);
    }

    public void v(Drawable drawable) {
        this.f1630f.p(drawable);
    }

    public void w(int i10) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i10, typedValue, true);
        this.f1630f.o(typedValue.resourceId);
    }

    public void x(CharSequence charSequence) {
        this.f1630f.q(charSequence);
    }

    public void y(View view) {
        this.f1630f.u(view);
    }

    public void z(View view, int i10, int i11, int i12, int i13) {
        this.f1630f.v(view, i10, i11, i12, i13);
    }

    public e(@n0 Context context, @d1 int i10) {
        super(context, n(context, i10));
        this.f1630f = new AlertController(getContext(), this, getWindow());
    }

    public e(@n0 Context context, boolean z10, @p0 DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z10);
        setOnCancelListener(onCancelListener);
    }
}
