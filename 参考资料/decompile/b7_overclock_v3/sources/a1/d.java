package a1;

import a1.g;
import android.R;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RestrictTo;
import androidx.core.os.a;
import com.blankj.utilcode.util.i0;
import g.f0;
import g.n0;
import g.p0;
import g.r0;
import g.u;
import g.v0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final int A = 32;
    public static final int B = 64;
    public static final int C = 128;
    public static final int D = 256;
    public static final int E = 512;
    public static final int F = 1024;
    public static final int G = 2048;
    public static final int H = 4096;
    public static final int I = 8192;
    public static final int J = 16384;
    public static final int K = 32768;
    public static final int L = 65536;
    public static final int M = 131072;
    public static final int N = 262144;
    public static final int O = 524288;
    public static final int P = 1048576;
    public static final int Q = 2097152;
    public static final String R = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String S = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String T = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String U = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String V = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String W = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final String X = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String Y = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String Z = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f64a0 = "ACTION_ARGUMENT_MOVE_WINDOW_X";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f65b0 = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f66c0 = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f67d = "AccessibilityNodeInfo.roleDescription";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f68d0 = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f69e = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f70e0 = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f71f = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f72f0 = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f73g = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f74g0 = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f75h = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f76h0 = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f77i = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f78i0 = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f79j = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f80j0 = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f81k = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f82k0 = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f83l = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f84l0 = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f85m = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f86m0 = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f87n = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f88n0 = 20000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f89o = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static int f90o0 = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f91p = "androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f92q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f93r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f94s = 4;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f95t = 8;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f96u = 32;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f97v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f98w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f99x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f100y = 8;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f101z = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int f103b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f104c = -1;

    public static class a {
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;

        @n0
        public static final a H;

        @n0
        public static final a I;

        @n0
        public static final a J;

        @n0
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;

        @n0
        public static final a Q;

        @n0
        public static final a R;

        @n0
        public static final a S;

        @n0
        public static final a T;

        @n0
        public static final a U;

        @n0
        public static final a V;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f105e = "A11yActionCompat";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<? extends g.a> f129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final a1.g f130d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f106f = new a(1, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f107g = new a(2, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f108h = new a(4, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f109i = new a(8, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f110j = new a(16, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f111k = new a(32, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f112l = new a(64, null);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f113m = new a(128, null);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f114n = new a(256, (CharSequence) null, (Class<? extends g.a>) g.b.class);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f115o = new a(512, (CharSequence) null, (Class<? extends g.a>) g.b.class);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f116p = new a(1024, (CharSequence) null, (Class<? extends g.a>) g.c.class);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f117q = new a(2048, (CharSequence) null, (Class<? extends g.a>) g.c.class);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f118r = new a(4096, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f119s = new a(8192, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f120t = new a(16384, null);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f121u = new a(32768, null);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f122v = new a(65536, null);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f123w = new a(131072, (CharSequence) null, (Class<? extends g.a>) g.C0007g.class);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f124x = new a(262144, null);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f125y = new a(524288, null);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f126z = new a(1048576, null);
        public static final a A = new a(2097152, (CharSequence) null, (Class<? extends g.a>) g.h.class);

        static {
            int i10 = Build.VERSION.SDK_INT;
            B = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            C = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, g.e.class);
            D = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            E = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            F = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            G = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            H = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            I = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            J = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            K = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            L = new a(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            M = new a(i10 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, g.f.class);
            N = new a(i10 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, g.d.class);
            O = new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            P = new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            Q = new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            R = new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            S = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            T = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            U = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            V = new a(i10 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        }

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public a a(CharSequence charSequence, a1.g gVar) {
            return new a(null, this.f128b, charSequence, gVar, this.f129c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f127a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f127a).getLabel();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean d(View view, Bundle bundle) {
            g.a aVarNewInstance;
            if (this.f130d == null) {
                return false;
            }
            g.a aVar = null;
            Class<? extends g.a> cls = this.f129c;
            if (cls != null) {
                try {
                    aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception unused) {
                }
                try {
                    aVarNewInstance.a(bundle);
                    aVar = aVarNewInstance;
                } catch (Exception unused2) {
                    aVar = aVarNewInstance;
                    Class<? extends g.a> cls2 = this.f129c;
                    String name = cls2 == null ? i0.f11859x : cls2.getName();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to execute command with argument class ViewCommandArgument: ");
                    sb2.append(name);
                }
            }
            return this.f130d.a(view, aVar);
        }

        public boolean equals(@p0 Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f127a;
            return obj2 == null ? aVar.f127a == null : obj2.equals(aVar.f127a);
        }

        public int hashCode() {
            Object obj = this.f127a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        @n0
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AccessibilityActionCompat: ");
            String strO = d.o(this.f128b);
            if (strO.equals("ACTION_UNKNOWN") && c() != null) {
                strO = c().toString();
            }
            sb2.append(strO);
            return sb2.toString();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public a(int i10, CharSequence charSequence, a1.g gVar) {
            this(null, i10, charSequence, gVar, null);
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(int i10, CharSequence charSequence, Class<? extends g.a> cls) {
            this(null, i10, charSequence, null, cls);
        }

        public a(Object obj, int i10, CharSequence charSequence, a1.g gVar, Class<? extends g.a> cls) {
            this.f128b = i10;
            this.f130d = gVar;
            if (obj == null) {
                this.f127a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            } else {
                this.f127a = obj;
            }
            this.f129c = cls;
        }
    }

    @v0(19)
    public static class b {
        @u
        public static Bundle a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtras();
        }
    }

    @v0(33)
    public static class c {
        @u
        public static AccessibilityNodeInfo.ExtraRenderingInfo a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        @u
        public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        @u
        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, boolean z10) {
            accessibilityNodeInfo.setTextSelectable(z10);
        }
    }

    /* JADX INFO: renamed from: a1.d$d, reason: collision with other inner class name */
    public static class C0006d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f131b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f132c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f133d = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f134a;

        public C0006d(Object obj) {
            this.f134a = obj;
        }

        public static C0006d e(int i10, int i11, boolean z10) {
            return new C0006d(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
        }

        public static C0006d f(int i10, int i11, boolean z10, int i12) {
            return new C0006d(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
        }

        public int a() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f134a).getColumnCount();
        }

        public int b() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f134a).getRowCount();
        }

        public int c() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f134a).getSelectionMode();
        }

        public boolean d() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f134a).isHierarchical();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f135a;

        public e(Object obj) {
            this.f135a = obj;
        }

        public static e g(int i10, int i11, int i12, int i13, boolean z10) {
            return new e(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10));
        }

        public static e h(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            return new e(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11));
        }

        public int a() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f135a).getColumnIndex();
        }

        public int b() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f135a).getColumnSpan();
        }

        public int c() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f135a).getRowIndex();
        }

        public int d() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f135a).getRowSpan();
        }

        @Deprecated
        public boolean e() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f135a).isHeading();
        }

        public boolean f() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f135a).isSelected();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f136b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f137c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f138d = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f139a;

        public f(Object obj) {
            this.f139a = obj;
        }

        public static f e(int i10, float f10, float f11, float f12) {
            return new f(AccessibilityNodeInfo.RangeInfo.obtain(i10, f10, f11, f12));
        }

        public float a() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f139a).getCurrent();
        }

        public float b() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f139a).getMax();
        }

        public float c() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f139a).getMin();
        }

        public int d() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f139a).getType();
        }
    }

    @Deprecated
    public d(Object obj) {
        this.f102a = (AccessibilityNodeInfo) obj;
    }

    public static d H0() {
        return g2(AccessibilityNodeInfo.obtain());
    }

    public static d I0(d dVar) {
        return g2(AccessibilityNodeInfo.obtain(dVar.f102a));
    }

    public static d J0(View view) {
        return g2(AccessibilityNodeInfo.obtain(view));
    }

    public static d K0(View view, int i10) {
        return h2(AccessibilityNodeInfo.obtain(view, i10));
    }

    public static d g2(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    public static d h2(Object obj) {
        if (obj != null) {
            return new d(obj);
        }
        return null;
    }

    public static String o(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i10) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i10) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] x(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public CharSequence A() {
        return this.f102a.getContentDescription();
    }

    public boolean A0() {
        return Build.VERSION.SDK_INT >= 28 ? this.f102a.isScreenReaderFocusable() : r(1);
    }

    public void A1(long j10) {
        b.a(this.f102a).putLong(f91p, j10);
    }

    public int B() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f102a.getDrawingOrder();
        }
        return 0;
    }

    public boolean B0() {
        return this.f102a.isScrollable();
    }

    public void B1(int i10) {
        this.f102a.setMovementGranularities(i10);
    }

    public CharSequence C() {
        return this.f102a.getError();
    }

    public boolean C0() {
        return this.f102a.isSelected();
    }

    public void C1(boolean z10) {
        this.f102a.setMultiLine(z10);
    }

    @p0
    public AccessibilityNodeInfo.ExtraRenderingInfo D() {
        if (Build.VERSION.SDK_INT >= 33) {
            return c.a(this.f102a);
        }
        return null;
    }

    public boolean D0() {
        return Build.VERSION.SDK_INT >= 26 ? this.f102a.isShowingHintText() : r(4);
    }

    public void D1(CharSequence charSequence) {
        this.f102a.setPackageName(charSequence);
    }

    public Bundle E() {
        return b.a(this.f102a);
    }

    public boolean E0() {
        return Build.VERSION.SDK_INT >= 29 ? this.f102a.isTextEntryKey() : r(8);
    }

    public void E1(@p0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f102a.setPaneTitle(charSequence);
        } else {
            b.a(this.f102a).putCharSequence(f69e, charSequence);
        }
    }

    @p0
    public CharSequence F() {
        return Build.VERSION.SDK_INT >= 26 ? this.f102a.getHintText() : b.a(this.f102a).getCharSequence(f73g);
    }

    public boolean F0() {
        if (Build.VERSION.SDK_INT >= 33) {
            return c.b(this.f102a);
        }
        return false;
    }

    public void F1(View view) {
        this.f103b = -1;
        this.f102a.setParent(view);
    }

    @Deprecated
    public Object G() {
        return this.f102a;
    }

    public boolean G0() {
        return this.f102a.isVisibleToUser();
    }

    public void G1(View view, int i10) {
        this.f103b = i10;
        this.f102a.setParent(view, i10);
    }

    public int H() {
        return this.f102a.getInputType();
    }

    public void H1(boolean z10) {
        this.f102a.setPassword(z10);
    }

    public d I() {
        return h2(this.f102a.getLabelFor());
    }

    public void I1(f fVar) {
        this.f102a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) fVar.f139a);
    }

    public d J() {
        return h2(this.f102a.getLabeledBy());
    }

    @SuppressLint({"GetterSetterNames"})
    public void J1(boolean z10) {
        V0(32, z10);
    }

    public int K() {
        return this.f102a.getLiveRegion();
    }

    public void K1(@p0 CharSequence charSequence) {
        b.a(this.f102a).putCharSequence(f67d, charSequence);
    }

    public int L() {
        return this.f102a.getMaxTextLength();
    }

    public boolean L0(int i10) {
        return this.f102a.performAction(i10);
    }

    public void L1(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f102a.setScreenReaderFocusable(z10);
        } else {
            V0(1, z10);
        }
    }

    public long M() {
        return b.a(this.f102a).getLong(f91p);
    }

    public boolean M0(int i10, Bundle bundle) {
        return this.f102a.performAction(i10, bundle);
    }

    public void M1(boolean z10) {
        this.f102a.setScrollable(z10);
    }

    public int N() {
        return this.f102a.getMovementGranularities();
    }

    @Deprecated
    public void N0() {
    }

    public void N1(boolean z10) {
        this.f102a.setSelected(z10);
    }

    public final SparseArray<WeakReference<ClickableSpan>> O(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayU = U(view);
        if (sparseArrayU != null) {
            return sparseArrayU;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(androidx.core.R.id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    public boolean O0() {
        return this.f102a.refresh();
    }

    public void O1(boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f102a.setShowingHintText(z10);
        } else {
            V0(4, z10);
        }
    }

    public CharSequence P() {
        return this.f102a.getPackageName();
    }

    public boolean P0(a aVar) {
        return this.f102a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f127a);
    }

    public void P1(View view) {
        this.f104c = -1;
        this.f102a.setSource(view);
    }

    @p0
    public CharSequence Q() {
        return Build.VERSION.SDK_INT >= 28 ? this.f102a.getPaneTitle() : b.a(this.f102a).getCharSequence(f69e);
    }

    public boolean Q0(View view) {
        return this.f102a.removeChild(view);
    }

    public void Q1(View view, int i10) {
        this.f104c = i10;
        this.f102a.setSource(view, i10);
    }

    public d R() {
        return h2(this.f102a.getParent());
    }

    public boolean R0(View view, int i10) {
        return this.f102a.removeChild(view, i10);
    }

    public void R1(@p0 CharSequence charSequence) {
        if (androidx.core.os.a.h()) {
            this.f102a.setStateDescription(charSequence);
        } else {
            b.a(this.f102a).putCharSequence(f87n, charSequence);
        }
    }

    public f S() {
        AccessibilityNodeInfo.RangeInfo rangeInfo = this.f102a.getRangeInfo();
        if (rangeInfo != null) {
            return new f(rangeInfo);
        }
        return null;
    }

    public final void S0(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayU = U(view);
        if (sparseArrayU != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < sparseArrayU.size(); i10++) {
                if (sparseArrayU.valueAt(i10).get() == null) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                sparseArrayU.remove(((Integer) arrayList.get(i11)).intValue());
            }
        }
    }

    public void S1(CharSequence charSequence) {
        this.f102a.setText(charSequence);
    }

    @p0
    public CharSequence T() {
        return b.a(this.f102a).getCharSequence(f67d);
    }

    public void T0(boolean z10) {
        this.f102a.setAccessibilityFocused(z10);
    }

    public void T1(boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f102a.setTextEntryKey(z10);
        } else {
            V0(8, z10);
        }
    }

    public final SparseArray<WeakReference<ClickableSpan>> U(View view) {
        return (SparseArray) view.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
    }

    public void U0(@n0 List<String> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f102a.setAvailableExtraData(list);
        }
    }

    public void U1(boolean z10) {
        if (Build.VERSION.SDK_INT >= 33) {
            c.c(this.f102a, z10);
        }
    }

    @p0
    public CharSequence V() {
        return androidx.core.os.a.h() ? this.f102a.getStateDescription() : b.a(this.f102a).getCharSequence(f87n);
    }

    public final void V0(int i10, boolean z10) {
        Bundle bundleE = E();
        if (bundleE != null) {
            int i11 = bundleE.getInt(f75h, 0) & (~i10);
            if (!z10) {
                i10 = 0;
            }
            bundleE.putInt(f75h, i10 | i11);
        }
    }

    public void V1(int i10, int i11) {
        this.f102a.setTextSelection(i10, i11);
    }

    public CharSequence W() {
        if (!i0()) {
            return this.f102a.getText();
        }
        List<Integer> listI = i(f79j);
        List<Integer> listI2 = i(f81k);
        List<Integer> listI3 = i(f83l);
        List<Integer> listI4 = i(f77i);
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f102a.getText(), 0, this.f102a.getText().length()));
        for (int i10 = 0; i10 < listI.size(); i10++) {
            spannableString.setSpan(new a1.a(listI4.get(i10).intValue(), this, E().getInt(f85m)), listI.get(i10).intValue(), listI2.get(i10).intValue(), listI3.get(i10).intValue());
        }
        return spannableString;
    }

    @Deprecated
    public void W0(Rect rect) {
        this.f102a.setBoundsInParent(rect);
    }

    public void W1(@p0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f102a.setTooltipText(charSequence);
        } else {
            b.a(this.f102a).putCharSequence(f71f, charSequence);
        }
    }

    public int X() {
        return this.f102a.getTextSelectionEnd();
    }

    public void X0(Rect rect) {
        this.f102a.setBoundsInScreen(rect);
    }

    public void X1(@n0 g gVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f102a.setTouchDelegateInfo(gVar.f140a);
        }
    }

    public int Y() {
        return this.f102a.getTextSelectionStart();
    }

    public void Y0(boolean z10) {
        this.f102a.setCanOpenPopup(z10);
    }

    public void Y1(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f102a.setTraversalAfter(view);
        }
    }

    @p0
    public CharSequence Z() {
        return Build.VERSION.SDK_INT >= 28 ? this.f102a.getTooltipText() : b.a(this.f102a).getCharSequence(f71f);
    }

    public void Z0(boolean z10) {
        this.f102a.setCheckable(z10);
    }

    public void Z1(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f102a.setTraversalAfter(view, i10);
        }
    }

    public void a(int i10) {
        this.f102a.addAction(i10);
    }

    @p0
    public g a0() {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        if (Build.VERSION.SDK_INT < 29 || (touchDelegateInfo = this.f102a.getTouchDelegateInfo()) == null) {
            return null;
        }
        return new g(touchDelegateInfo);
    }

    public void a1(boolean z10) {
        this.f102a.setChecked(z10);
    }

    public void a2(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f102a.setTraversalBefore(view);
        }
    }

    public void b(a aVar) {
        this.f102a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f127a);
    }

    public d b0() {
        if (Build.VERSION.SDK_INT >= 22) {
            return h2(this.f102a.getTraversalAfter());
        }
        return null;
    }

    public void b1(CharSequence charSequence) {
        this.f102a.setClassName(charSequence);
    }

    public void b2(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f102a.setTraversalBefore(view, i10);
        }
    }

    public void c(View view) {
        this.f102a.addChild(view);
    }

    public d c0() {
        if (Build.VERSION.SDK_INT >= 22) {
            return h2(this.f102a.getTraversalBefore());
        }
        return null;
    }

    public void c1(boolean z10) {
        this.f102a.setClickable(z10);
    }

    @r0(markerClass = {a.b.class})
    public void c2(@p0 String str) {
        if (androidx.core.os.a.k()) {
            this.f102a.setUniqueId(str);
        } else {
            b.a(this.f102a).putString(f89o, str);
        }
    }

    public void d(View view, int i10) {
        this.f102a.addChild(view, i10);
    }

    @p0
    @r0(markerClass = {a.b.class})
    public String d0() {
        return androidx.core.os.a.k() ? this.f102a.getUniqueId() : b.a(this.f102a).getString(f89o);
    }

    public void d1(Object obj) {
        this.f102a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((C0006d) obj).f134a);
    }

    public void d2(String str) {
        this.f102a.setViewIdResourceName(str);
    }

    public final void e(ClickableSpan clickableSpan, Spanned spanned, int i10) {
        i(f79j).add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        i(f81k).add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        i(f83l).add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        i(f77i).add(Integer.valueOf(i10));
    }

    public String e0() {
        return this.f102a.getViewIdResourceName();
    }

    public void e1(Object obj) {
        this.f102a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((e) obj).f135a);
    }

    public void e2(boolean z10) {
        this.f102a.setVisibleToUser(z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f102a;
        if (accessibilityNodeInfo == null) {
            if (dVar.f102a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(dVar.f102a)) {
            return false;
        }
        return this.f104c == dVar.f104c && this.f103b == dVar.f103b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void f(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            h();
            S0(view);
            ClickableSpan[] clickableSpanArrX = x(charSequence);
            if (clickableSpanArrX == null || clickableSpanArrX.length <= 0) {
                return;
            }
            E().putInt(f85m, androidx.core.R.id.accessibility_action_clickable_span);
            SparseArray<WeakReference<ClickableSpan>> sparseArrayO = O(view);
            for (int i10 = 0; i10 < clickableSpanArrX.length; i10++) {
                int iJ0 = j0(clickableSpanArrX[i10], sparseArrayO);
                sparseArrayO.put(iJ0, new WeakReference<>(clickableSpanArrX[i10]));
                e(clickableSpanArrX[i10], (Spanned) charSequence, iJ0);
            }
        }
    }

    public h f0() {
        return h.v(this.f102a.getWindow());
    }

    public void f1(CharSequence charSequence) {
        this.f102a.setContentDescription(charSequence);
    }

    public AccessibilityNodeInfo f2() {
        return this.f102a;
    }

    public boolean g() {
        return this.f102a.canOpenPopup();
    }

    public int g0() {
        return this.f102a.getWindowId();
    }

    public void g1(boolean z10) {
        this.f102a.setContentInvalid(z10);
    }

    public final void h() {
        b.a(this.f102a).remove(f79j);
        b.a(this.f102a).remove(f81k);
        b.a(this.f102a).remove(f83l);
        b.a(this.f102a).remove(f77i);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean h0() {
        return r(32);
    }

    public void h1(boolean z10) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f102a.setContextClickable(z10);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f102a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final List<Integer> i(String str) {
        ArrayList<Integer> integerArrayList = b.a(this.f102a).getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        b.a(this.f102a).putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final boolean i0() {
        return !i(f79j).isEmpty();
    }

    public void i1(boolean z10) {
        this.f102a.setDismissable(z10);
    }

    public List<d> j(String str) {
        ArrayList arrayList = new ArrayList();
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = this.f102a.findAccessibilityNodeInfosByText(str);
        int size = listFindAccessibilityNodeInfosByText.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(g2(listFindAccessibilityNodeInfosByText.get(i10)));
        }
        return arrayList;
    }

    public final int j0(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                if (clickableSpan.equals(sparseArray.valueAt(i10).get())) {
                    return sparseArray.keyAt(i10);
                }
            }
        }
        int i11 = f90o0;
        f90o0 = i11 + 1;
        return i11;
    }

    public void j1(int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f102a.setDrawingOrder(i10);
        }
    }

    public List<d> k(String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = this.f102a.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        Iterator<AccessibilityNodeInfo> it2 = listFindAccessibilityNodeInfosByViewId.iterator();
        while (it2.hasNext()) {
            arrayList.add(g2(it2.next()));
        }
        return arrayList;
    }

    public boolean k0() {
        return this.f102a.isAccessibilityFocused();
    }

    public void k1(boolean z10) {
        this.f102a.setEditable(z10);
    }

    public d l(int i10) {
        return h2(this.f102a.findFocus(i10));
    }

    public boolean l0() {
        return this.f102a.isCheckable();
    }

    public void l1(boolean z10) {
        this.f102a.setEnabled(z10);
    }

    public d m(int i10) {
        return h2(this.f102a.focusSearch(i10));
    }

    public boolean m0() {
        return this.f102a.isChecked();
    }

    public void m1(CharSequence charSequence) {
        this.f102a.setError(charSequence);
    }

    public List<a> n() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f102a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    public boolean n0() {
        return this.f102a.isClickable();
    }

    public void n1(boolean z10) {
        this.f102a.setFocusable(z10);
    }

    public boolean o0() {
        return this.f102a.isContentInvalid();
    }

    public void o1(boolean z10) {
        this.f102a.setFocused(z10);
    }

    @Deprecated
    public int p() {
        return this.f102a.getActions();
    }

    public boolean p0() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f102a.isContextClickable();
        }
        return false;
    }

    public void p1(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f102a.setHeading(z10);
        } else {
            V0(2, z10);
        }
    }

    @n0
    public List<String> q() {
        return Build.VERSION.SDK_INT >= 26 ? this.f102a.getAvailableExtraData() : Collections.emptyList();
    }

    public boolean q0() {
        return this.f102a.isDismissable();
    }

    public void q1(@p0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f102a.setHintText(charSequence);
        } else {
            b.a(this.f102a).putCharSequence(f73g, charSequence);
        }
    }

    public final boolean r(int i10) {
        Bundle bundleE = E();
        return bundleE != null && (bundleE.getInt(f75h, 0) & i10) == i10;
    }

    public boolean r0() {
        return this.f102a.isEditable();
    }

    public void r1(boolean z10) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f102a.setImportantForAccessibility(z10);
        }
    }

    @Deprecated
    public void s(Rect rect) {
        this.f102a.getBoundsInParent(rect);
    }

    public boolean s0() {
        return this.f102a.isEnabled();
    }

    public void s1(int i10) {
        this.f102a.setInputType(i10);
    }

    public void t(Rect rect) {
        this.f102a.getBoundsInScreen(rect);
    }

    public boolean t0() {
        return this.f102a.isFocusable();
    }

    public void t1(View view) {
        this.f102a.setLabelFor(view);
    }

    @n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        s(rect);
        sb2.append("; boundsInParent: " + rect);
        t(rect);
        sb2.append("; boundsInScreen: " + rect);
        sb2.append("; packageName: ");
        sb2.append(P());
        sb2.append("; className: ");
        sb2.append(w());
        sb2.append("; text: ");
        sb2.append(W());
        sb2.append("; contentDescription: ");
        sb2.append(A());
        sb2.append("; viewId: ");
        sb2.append(e0());
        sb2.append("; uniqueId: ");
        sb2.append(d0());
        sb2.append("; checkable: ");
        sb2.append(l0());
        sb2.append("; checked: ");
        sb2.append(m0());
        sb2.append("; focusable: ");
        sb2.append(t0());
        sb2.append("; focused: ");
        sb2.append(u0());
        sb2.append("; selected: ");
        sb2.append(C0());
        sb2.append("; clickable: ");
        sb2.append(n0());
        sb2.append("; longClickable: ");
        sb2.append(x0());
        sb2.append("; enabled: ");
        sb2.append(s0());
        sb2.append("; password: ");
        sb2.append(z0());
        sb2.append("; scrollable: " + B0());
        sb2.append("; [");
        List<a> listN = n();
        for (int i10 = 0; i10 < listN.size(); i10++) {
            a aVar = listN.get(i10);
            String strO = o(aVar.b());
            if (strO.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                strO = aVar.c().toString();
            }
            sb2.append(strO);
            if (i10 != listN.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public d u(int i10) {
        return h2(this.f102a.getChild(i10));
    }

    public boolean u0() {
        return this.f102a.isFocused();
    }

    public void u1(View view, int i10) {
        this.f102a.setLabelFor(view, i10);
    }

    public int v() {
        return this.f102a.getChildCount();
    }

    public boolean v0() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.f102a.isHeading();
        }
        if (r(2)) {
            return true;
        }
        e eVarZ = z();
        return eVarZ != null && eVarZ.e();
    }

    public void v1(View view) {
        this.f102a.setLabeledBy(view);
    }

    public CharSequence w() {
        return this.f102a.getClassName();
    }

    public boolean w0() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f102a.isImportantForAccessibility();
        }
        return true;
    }

    public void w1(View view, int i10) {
        this.f102a.setLabeledBy(view, i10);
    }

    public boolean x0() {
        return this.f102a.isLongClickable();
    }

    public void x1(int i10) {
        this.f102a.setLiveRegion(i10);
    }

    public C0006d y() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo = this.f102a.getCollectionInfo();
        if (collectionInfo != null) {
            return new C0006d(collectionInfo);
        }
        return null;
    }

    public boolean y0() {
        return this.f102a.isMultiLine();
    }

    public void y1(boolean z10) {
        this.f102a.setLongClickable(z10);
    }

    public e z() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.f102a.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new e(collectionItemInfo);
        }
        return null;
    }

    public boolean z0() {
        return this.f102a.isPassword();
    }

    public void z1(int i10) {
        this.f102a.setMaxTextLength(i10);
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AccessibilityNodeInfo.TouchDelegateInfo f140a;

        public g(@n0 Map<Region, View> map) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f140a = new AccessibilityNodeInfo.TouchDelegateInfo(map);
            } else {
                this.f140a = null;
            }
        }

        @p0
        public Region a(@f0(from = 0) int i10) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f140a.getRegionAt(i10);
            }
            return null;
        }

        @f0(from = 0)
        public int b() {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f140a.getRegionCount();
            }
            return 0;
        }

        @p0
        public d c(@n0 Region region) {
            AccessibilityNodeInfo targetForRegion;
            if (Build.VERSION.SDK_INT < 29 || (targetForRegion = this.f140a.getTargetForRegion(region)) == null) {
                return null;
            }
            return d.g2(targetForRegion);
        }

        public g(@n0 AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.f140a = touchDelegateInfo;
        }
    }

    public d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f102a = accessibilityNodeInfo;
    }
}
