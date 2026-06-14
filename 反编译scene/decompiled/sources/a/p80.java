package a;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class p80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final a f2403a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(b92 b92Var) {
            this();
        }

        public static /* synthetic */ b B(a aVar, Context context, CharSequence charSequence, CharSequence charSequence2, Runnable runnable, int i, Object obj) {
            if ((i & 8) != 0) {
                runnable = null;
            }
            return aVar.y(context, charSequence, charSequence2, runnable);
        }

        public static /* synthetic */ b C(a aVar, Context context, String str, Runnable runnable, int i, Object obj) {
            if ((i & 4) != 0) {
                runnable = null;
            }
            return aVar.z(context, str, runnable);
        }

        public static /* synthetic */ b D(a aVar, Context context, String str, String str2, View view, Runnable runnable, int i, Object obj) {
            String str3 = (i & 2) != 0 ? "" : str;
            String str4 = (i & 4) != 0 ? "" : str2;
            if ((i & 16) != 0) {
                runnable = null;
            }
            return aVar.A(context, str3, str4, view, runnable);
        }

        public static /* synthetic */ b G(a aVar, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return aVar.F(context, str);
        }

        public static /* synthetic */ b b(a aVar, Context context, String str, String str2, Runnable runnable, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "";
            }
            if ((i & 4) != 0) {
                str2 = "";
            }
            if ((i & 8) != 0) {
                runnable = null;
            }
            return aVar.a(context, str, str2, runnable);
        }

        public static /* synthetic */ b j(a aVar, Context context, View view, q80 q80Var, q80 q80Var2, int i, Object obj) {
            if ((i & 2) != 0) {
                view = null;
            }
            if ((i & 4) != 0) {
                q80Var = null;
            }
            if ((i & 8) != 0) {
                q80Var2 = null;
            }
            return aVar.e(context, view, q80Var, q80Var2);
        }

        public static /* synthetic */ b s(a aVar, Context context, int i, boolean z, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                z = true;
            }
            return aVar.q(context, i, z);
        }

        public static /* synthetic */ b t(a aVar, Context context, View view, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return aVar.r(context, view, z);
        }

        public static /* synthetic */ int x(a aVar, Context context, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return aVar.w(context, i);
        }

        public final b A(Context context, String str, String str2, View view, Runnable runnable) {
            f92.d(context, "context");
            f92.d(str, "title");
            f92.d(str2, "message");
            f92.d(view, "contentView");
            View viewU = u(context, y20.dialog_help_info, str, str2, view);
            b bVarT = t(this, context, viewU, false, 4, null);
            viewU.findViewById(x20.btn_confirm).setOnClickListener(new l80(bVarT, runnable));
            return bVarT;
        }

        public final boolean E(Context context) {
            int iL = x0.l();
            if (iL != -100 && iL != -1) {
                return iL == 2;
            }
            Object systemService = context.getSystemService("uimode");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.UiModeManager");
            }
            UiModeManager uiModeManager = (UiModeManager) systemService;
            Resources resources = context.getResources();
            f92.c(resources, "context.resources");
            return uiModeManager.getNightMode() == 2 || ((resources.getConfiguration().uiMode & 48) == 32);
        }

        public final b F(Context context, String str) {
            f92.d(context, "context");
            View viewInflate = LayoutInflater.from(context).inflate(y20.dialog_loading, (ViewGroup) null);
            if (str != null) {
                View viewFindViewById = viewInflate.findViewById(x20.dialog_text);
                f92.c(viewFindViewById, "findViewById<TextView>(R.id.dialog_text)");
                ((TextView) viewFindViewById).setText(str);
            }
            f92.c(viewInflate, "view");
            return r(context, viewInflate, false);
        }

        public final b H(Context context, int i, String str, String str2, Runnable runnable, Runnable runnable2) {
            View viewU = u(context, i, str, str2, null);
            b bVarT = t(this, context, viewU, false, 4, null);
            View viewFindViewById = viewU.findViewById(x20.btn_cancel);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new m80(bVarT, runnable2));
            }
            View viewFindViewById2 = viewU.findViewById(x20.btn_confirm);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setOnClickListener(new n80(bVarT, runnable));
            }
            return bVarT;
        }

        public final void I(int i) {
            p80.f7094a = i;
        }

        public final b J(View view, b bVar) {
            Window window = bVar.e().getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            if (decorView != null) {
                decorView.setOnTouchListener(new o80(view, bVar));
            }
            return bVar;
        }

        public final void K(Window window, Activity activity) {
            ColorDrawable colorDrawable;
            f92.d(window, "dialogWindow");
            f92.d(activity, "bgActivity");
            Window window2 = activity.getWindow();
            f92.c(window2, "bgActivity.window");
            boolean z = (window2.getAttributes().flags & 1048576) != 0;
            Bitmap bitmapD = z ? null : s90.d(activity);
            if (bitmapD != null) {
                window.setBackgroundDrawable(new BitmapDrawable(activity.getResources(), bitmapD));
                return;
            }
            try {
                int iX = x(p80.f2403a, activity, 0, 2, null);
                if (iX != 0) {
                    window.setBackgroundDrawable(new ColorDrawable(iX));
                    return;
                }
                if (window.isFloating()) {
                    window.setBackgroundDrawable(new ColorDrawable(iX));
                    window.setDimAmount(0.9f);
                    return;
                }
                if (!z) {
                    a aVar = p80.f2403a;
                    Context context = window.getContext();
                    f92.c(context, "context");
                    colorDrawable = aVar.E(context) ? new ColorDrawable(Color.argb(255, 18, 18, 18)) : new ColorDrawable(Color.argb(255, 245, 245, 245));
                }
                window.setBackgroundDrawable(colorDrawable);
            } catch (Exception unused) {
                window.setBackgroundDrawable(new ColorDrawable(Color.argb(255, 245, 245, 245)));
            }
        }

        public final void L(Activity activity) {
            f92.d(activity, "activity");
        }

        public final b M(Context context, String str, String str2, Runnable runnable, Runnable runnable2) {
            f92.d(context, "context");
            f92.d(str, "title");
            f92.d(str2, "message");
            return H(context, y20.dialog_warning, str, str2, runnable, runnable2);
        }

        public final b a(Context context, String str, String str2, Runnable runnable) {
            f92.d(context, "context");
            f92.d(str, "title");
            f92.d(str2, "message");
            return H(context, y20.dialog_alert, str, str2, runnable, null);
        }

        public final b c(AlertDialog.Builder builder) {
            f92.d(builder, "builder");
            AlertDialog alertDialogCreate = builder.create();
            d(alertDialogCreate);
            f92.c(alertDialogCreate, "dialog");
            return new b(alertDialogCreate, null);
        }

        public final b d(AlertDialog alertDialog) {
            if (alertDialog != null && !alertDialog.isShowing()) {
                Window window = alertDialog.getWindow();
                if (window != null) {
                    window.setWindowAnimations(a30.windowAnim);
                }
                alertDialog.show();
            }
            if (alertDialog != null) {
                return new b(alertDialog, null);
            }
            return null;
        }

        public final b e(Context context, View view, q80 q80Var, q80 q80Var2) {
            f92.d(context, "context");
            return f(context, "", "", view, q80Var, q80Var2);
        }

        public final b f(Context context, String str, String str2, View view, q80 q80Var, q80 q80Var2) {
            f92.d(context, "context");
            f92.d(str, "title");
            f92.d(str2, "message");
            View viewU = u(context, y20.dialog_confirm, str, str2, view);
            b bVarT = t(this, context, viewU, false, 4, null);
            TextView textView = (TextView) viewU.findViewById(x20.btn_confirm);
            if (q80Var != null && textView != null) {
                textView.setText(q80Var.c());
            }
            if (textView != null) {
                textView.setOnClickListener(new h80(q80Var, bVarT));
            }
            TextView textView2 = (TextView) viewU.findViewById(x20.btn_cancel);
            if (q80Var2 != null && textView2 != null) {
                textView2.setText(q80Var2.c());
            }
            textView2.setOnClickListener(new i80(q80Var2, bVarT));
            return bVarT;
        }

        public final b g(Context context, String str, String str2, View view, Runnable runnable, Runnable runnable2) {
            f92.d(context, "context");
            f92.d(str, "title");
            f92.d(str2, "message");
            View viewU = u(context, y20.dialog_confirm, str, str2, view);
            b bVarT = t(this, context, viewU, false, 4, null);
            viewU.findViewById(x20.btn_cancel).setOnClickListener(new f80(bVarT, runnable2));
            viewU.findViewById(x20.btn_confirm).setOnClickListener(new g80(bVarT, runnable));
            return bVarT;
        }

        public final b h(Context context, String str, String str2, q80 q80Var, q80 q80Var2) {
            f92.d(context, "context");
            f92.d(str, "title");
            f92.d(str2, "message");
            return f(context, str, str2, null, q80Var, q80Var2);
        }

        public final b i(Context context, String str, String str2, Runnable runnable, Runnable runnable2) {
            f92.d(context, "context");
            f92.d(str, "title");
            f92.d(str2, "message");
            return H(context, y20.dialog_confirm, str, str2, runnable, runnable2);
        }

        public final b o(Activity activity, String str, String str2, Runnable runnable, Runnable runnable2) {
            f92.d(activity, "context");
            f92.d(str, "title");
            f92.d(str2, "message");
            return H(activity, y20.dialog_confirm, str, str2, runnable, runnable2);
        }

        public final b q(Context context, int i, boolean z) {
            f92.d(context, "context");
            View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
            f92.c(viewInflate, "LayoutInflater.from(context).inflate(view, null)");
            return r(context, viewInflate, z);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final a.p80.b r(android.content.Context r6, android.view.View r7, boolean r8) {
            /*
                r5 = this;
                java.lang.String r0 = "context"
                a.f92.d(r6, r0)
                java.lang.String r0 = "view"
                a.f92.d(r7, r0)
                boolean r0 = r6 instanceof android.app.Activity
                java.lang.String r1 = "context.window"
                if (r0 == 0) goto L27
                r2 = r6
                android.app.Activity r2 = (android.app.Activity) r2
                android.view.Window r2 = r2.getWindow()
                a.f92.c(r2, r1)
                android.view.WindowManager$LayoutParams r2 = r2.getAttributes()
                int r2 = r2.flags
                r3 = 1048576(0x100000, float:1.469368E-39)
                r2 = r2 & r3
                if (r2 != 0) goto L27
                r2 = 1
                goto L28
            L27:
                r2 = 0
            L28:
                if (r2 == 0) goto L32
                android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
                int r3 = a.a30.custom_alert_dialog
                r2.<init>(r6, r3)
                goto L37
            L32:
                android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
                r2.<init>(r6)
            L37:
                android.app.AlertDialog$Builder r2 = r2.setView(r7)
                android.app.AlertDialog$Builder r2 = r2.setCancelable(r8)
                android.app.AlertDialog r2 = r2.create()
                java.lang.String r3 = "dialog"
                if (r0 == 0) goto L7c
                r2.show()
                a.f92.c(r2, r3)
                android.view.Window r0 = r2.getWindow()
                if (r0 == 0) goto L99
                a.p80$a r3 = a.p80.f2403a
                java.lang.String r4 = "this"
                a.f92.c(r0, r4)
                r4 = r6
                android.app.Activity r4 = (android.app.Activity) r4
                r3.K(r0, r4)
                android.view.View r0 = r0.getDecorView()
                android.view.Window r3 = r4.getWindow()
                a.f92.c(r3, r1)
                android.view.View r1 = r3.getDecorView()
                java.lang.String r3 = "context.window.decorView"
                a.f92.c(r1, r3)
                int r1 = r1.getSystemUiVisibility()
                r0.setSystemUiVisibility(r1)
                goto L99
            L7c:
                a.f92.c(r2, r3)
                android.view.Window r0 = r2.getWindow()
                if (r0 == 0) goto L8a
                int r1 = a.a30.windowAnim2
                r0.setWindowAnimations(r1)
            L8a:
                r2.show()
                android.view.Window r0 = r2.getWindow()
                if (r0 == 0) goto L99
                r1 = 17170445(0x106000d, float:2.461195E-38)
                r0.setBackgroundDrawableResource(r1)
            L99:
                a.p80$b r0 = new a.p80$b
                r0.<init>(r2, r6)
                r0.i(r8)
                r5.J(r7, r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: a.p80.a.r(android.content.Context, android.view.View, boolean):a.p80$b");
        }

        public final View u(Context context, int i, String str, String str2, View view) {
            FrameLayout frameLayout;
            View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(x20.confirm_title);
            if (textView != null) {
                if (str.length() == 0) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str);
                }
            }
            TextView textView2 = (TextView) viewInflate.findViewById(x20.confirm_message);
            if (textView2 != null) {
                if (str2.length() == 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(str2);
                }
            }
            if (view != null && (frameLayout = (FrameLayout) viewInflate.findViewById(x20.confirm_custom_view)) != null) {
                frameLayout.addView(view);
            }
            f92.c(viewInflate, "view");
            return viewInflate;
        }

        public final int v() {
            return p80.f7094a;
        }

        public final int w(Context context, int i) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.background});
            f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrsArray)");
            int color = typedArrayObtainStyledAttributes.getColor(0, i);
            typedArrayObtainStyledAttributes.recycle();
            return color;
        }

        public final b y(Context context, CharSequence charSequence, CharSequence charSequence2, Runnable runnable) {
            f92.d(context, "context");
            f92.d(charSequence, "title");
            f92.d(charSequence2, "message");
            View viewInflate = LayoutInflater.from(context).inflate(y20.dialog_help_info, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(x20.confirm_title);
            f92.b(viewFindViewById);
            TextView textView = (TextView) viewFindViewById;
            if (charSequence.length() > 0) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            View viewFindViewById2 = viewInflate.findViewById(x20.confirm_message);
            f92.b(viewFindViewById2);
            TextView textView2 = (TextView) viewFindViewById2;
            if (charSequence2.length() > 0) {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            f92.c(viewInflate, "dialog");
            b bVarR = r(context, viewInflate, runnable == null);
            View viewFindViewById3 = viewInflate.findViewById(x20.btn_confirm);
            f92.b(viewFindViewById3);
            if (runnable != null) {
                bVarR.h(new j80(runnable, bVarR));
            }
            viewFindViewById3.setOnClickListener(new k80(runnable, bVarR));
            return bVarR;
        }

        public final b z(Context context, String str, Runnable runnable) {
            f92.d(context, "context");
            f92.d(str, "message");
            String string = context.getString(z20.help_title);
            f92.c(string, "context.getString(R.string.help_title)");
            return y(context, string, str, runnable);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AlertDialog f7095a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Context f2404a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<DialogInterface.OnDismissListener> f2405a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2406a;

        public b(AlertDialog alertDialog, Context context) {
            f92.d(alertDialog, "d");
            this.f7095a = alertDialog;
            this.f2405a = new ArrayList();
            a aVar = p80.f2403a;
            aVar.I(aVar.v() + 1);
            this.f7095a.setOnDismissListener(new r80(this));
            Context context2 = e().getContext();
            f92.c(context2, "dialog.context");
            this.f2404a = context2;
            this.f2406a = true;
        }

        public final void c() {
            try {
                this.f7095a.dismiss();
            } catch (Exception unused) {
            }
        }

        public final Context d() {
            return this.f2404a;
        }

        public final AlertDialog e() {
            return this.f7095a;
        }

        public final boolean f() {
            return this.f2406a;
        }

        public final boolean g() {
            return this.f7095a.isShowing();
        }

        public final b h(DialogInterface.OnDismissListener onDismissListener) {
            f92.d(onDismissListener, "onDismissListener");
            this.f2405a.add(onDismissListener);
            return this;
        }

        public final b i(boolean z) {
            this.f2406a = z;
            this.f7095a.setCancelable(z);
            return this;
        }
    }
}
