package a;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ni {
    public static int c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AccessibilityNodeInfo f2091a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6917a = -1;
    public int b = -1;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6918a = new a(1, null);
        public static final a b = new a(2, null);
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f2092a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final bj f2093a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Class<? extends ti> f2094a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Object f2095a;

        static {
            new a(4, null);
            new a(8, null);
            c = new a(16, null);
            new a(32, null);
            new a(64, null);
            new a(128, null);
            new a(256, null, ui.class);
            new a(512, null, ui.class);
            new a(1024, null, vi.class);
            new a(2048, null, vi.class);
            d = new a(4096, null);
            e = new a(8192, null);
            new a(16384, null);
            new a(32768, null);
            new a(65536, null);
            new a(131072, null, zi.class);
            f = new a(262144, null);
            g = new a(524288, null);
            h = new a(1048576, null);
            new a(2097152, null, aj.class);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, xi.class);
            i = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            j = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, yi.class);
            new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, wi.class);
            new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public a(int i2, CharSequence charSequence, Class<? extends ti> cls) {
            this(null, i2, charSequence, null, cls);
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(Object obj, int i2, CharSequence charSequence, bj bjVar, Class<? extends ti> cls) {
            this.f2092a = i2;
            this.f2093a = bjVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                obj = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            }
            this.f2095a = obj;
            this.f2094a = cls;
        }

        public a a(CharSequence charSequence, bj bjVar) {
            return new a(null, this.f2092a, charSequence, bjVar, this.f2094a);
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2095a).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2095a).getLabel();
            }
            return null;
        }

        public boolean d(View view, Bundle bundle) {
            ti tiVarNewInstance;
            if (this.f2093a == null) {
                return false;
            }
            ti tiVar = null;
            Class<? extends ti> cls = this.f2094a;
            if (cls != null) {
                try {
                    tiVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    tiVarNewInstance.a(bundle);
                    tiVar = tiVarNewInstance;
                } catch (Exception e3) {
                    e = e3;
                    tiVar = tiVarNewInstance;
                    Class<? extends ti> cls2 = this.f2094a;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                }
            }
            return this.f2093a.a(view, tiVar);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.f2095a;
            Object obj3 = ((a) obj).f2095a;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f2095a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f6919a;

        public b(Object obj) {
            this.f6919a = obj;
        }

        public static b a(int i, int i2, boolean z, int i3) {
            int i4 = Build.VERSION.SDK_INT;
            return i4 >= 21 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3)) : i4 >= 19 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z)) : new b(null);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f6920a;

        public c(Object obj) {
            this.f6920a = obj;
        }

        public static c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = Build.VERSION.SDK_INT;
            return i5 >= 21 ? new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2)) : i5 >= 19 ? new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z)) : new c(null);
        }
    }

    public ni(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2091a = accessibilityNodeInfo;
    }

    public static ni D0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new ni(accessibilityNodeInfo);
    }

    public static ni N() {
        return D0(AccessibilityNodeInfo.obtain());
    }

    public static ni O(View view) {
        return D0(AccessibilityNodeInfo.obtain(view));
    }

    public static ni P(ni niVar) {
        return D0(AccessibilityNodeInfo.obtain(niVar.f2091a));
    }

    public static String j(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
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
            case R.id.accessibilityActionImeEnter:
                return "ACTION_IME_ENTER";
            default:
                switch (i) {
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
                        switch (i) {
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
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static ClickableSpan[] q(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public boolean A() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2091a.isAccessibilityFocused();
        }
        return false;
    }

    public void A0(CharSequence charSequence) {
        this.f2091a.setText(charSequence);
    }

    public boolean B() {
        return this.f2091a.isCheckable();
    }

    public void B0(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2091a.setVisibleToUser(z);
        }
    }

    public boolean C() {
        return this.f2091a.isChecked();
    }

    public AccessibilityNodeInfo C0() {
        return this.f2091a;
    }

    public boolean D() {
        return this.f2091a.isClickable();
    }

    public boolean E() {
        return this.f2091a.isEnabled();
    }

    public boolean F() {
        return this.f2091a.isFocusable();
    }

    public boolean G() {
        return this.f2091a.isFocused();
    }

    public boolean H() {
        return this.f2091a.isLongClickable();
    }

    public boolean I() {
        return this.f2091a.isPassword();
    }

    public boolean J() {
        return this.f2091a.isScrollable();
    }

    public boolean K() {
        return this.f2091a.isSelected();
    }

    public boolean L() {
        return Build.VERSION.SDK_INT >= 26 ? this.f2091a.isShowingHintText() : l(4);
    }

    public boolean M() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2091a.isVisibleToUser();
        }
        return false;
    }

    public boolean Q(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2091a.performAction(i, bundle);
        }
        return false;
    }

    public void R() {
        this.f2091a.recycle();
    }

    public boolean S(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f2091a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2095a);
        }
        return false;
    }

    public final void T(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayV = v(view);
        if (sparseArrayV != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < sparseArrayV.size(); i++) {
                if (sparseArrayV.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sparseArrayV.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public void U(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2091a.setAccessibilityFocused(z);
        }
    }

    public final void V(int i, boolean z) {
        Bundle bundleS = s();
        if (bundleS != null) {
            int i2 = bundleS.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            bundleS.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    @Deprecated
    public void W(Rect rect) {
        this.f2091a.setBoundsInParent(rect);
    }

    public void X(Rect rect) {
        this.f2091a.setBoundsInScreen(rect);
    }

    public void Y(boolean z) {
        this.f2091a.setCheckable(z);
    }

    public void Z(boolean z) {
        this.f2091a.setChecked(z);
    }

    public void a(int i) {
        this.f2091a.addAction(i);
    }

    public void a0(CharSequence charSequence) {
        this.f2091a.setClassName(charSequence);
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2091a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2095a);
        }
    }

    public void b0(boolean z) {
        this.f2091a.setClickable(z);
    }

    public void c(View view) {
        this.f2091a.addChild(view);
    }

    public void c0(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2091a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f6919a);
        }
    }

    public void d(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2091a.addChild(view, i);
        }
    }

    public void d0(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2091a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f6920a);
        }
    }

    public final void e(ClickableSpan clickableSpan, Spanned spanned, int i) {
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    public void e0(CharSequence charSequence) {
        this.f2091a.setContentDescription(charSequence);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ni)) {
            return false;
        }
        ni niVar = (ni) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2091a;
        if (accessibilityNodeInfo == null) {
            if (niVar.f2091a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(niVar.f2091a)) {
            return false;
        }
        return this.b == niVar.b && this.f6917a == niVar.f6917a;
    }

    public void f(CharSequence charSequence, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i < 19 || i >= 26) {
            return;
        }
        g();
        T(view);
        ClickableSpan[] clickableSpanArrQ = q(charSequence);
        if (clickableSpanArrQ == null || clickableSpanArrQ.length <= 0) {
            return;
        }
        s().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", ra.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> sparseArrayT = t(view);
        for (int i2 = 0; clickableSpanArrQ != null && i2 < clickableSpanArrQ.length; i2++) {
            int iZ = z(clickableSpanArrQ[i2], sparseArrayT);
            sparseArrayT.put(iZ, new WeakReference<>(clickableSpanArrQ[i2]));
            e(clickableSpanArrQ[i2], (Spanned) charSequence, iZ);
        }
    }

    public void f0(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2091a.setDismissable(z);
        }
    }

    public final void g() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2091a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f2091a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f2091a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f2091a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    public void g0(boolean z) {
        this.f2091a.setEnabled(z);
    }

    public final List<Integer> h(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f2091a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f2091a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void h0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2091a.setError(charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2091a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public List<a> i() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f2091a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new a(actionList.get(i)));
        }
        return arrayList;
    }

    public void i0(boolean z) {
        this.f2091a.setFocusable(z);
    }

    public void j0(boolean z) {
        this.f2091a.setFocused(z);
    }

    public int k() {
        return this.f2091a.getActions();
    }

    public void k0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2091a.setHeading(z);
        } else {
            V(2, z);
        }
    }

    public final boolean l(int i) {
        Bundle bundleS = s();
        return bundleS != null && (bundleS.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    public void l0(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f2091a.setHintText(charSequence);
        } else if (i >= 19) {
            this.f2091a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    @Deprecated
    public void m(Rect rect) {
        this.f2091a.getBoundsInParent(rect);
    }

    public void m0(boolean z) {
        this.f2091a.setLongClickable(z);
    }

    public void n(Rect rect) {
        this.f2091a.getBoundsInScreen(rect);
    }

    public void n0(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2091a.setMaxTextLength(i);
        }
    }

    public int o() {
        return this.f2091a.getChildCount();
    }

    public void o0(CharSequence charSequence) {
        this.f2091a.setPackageName(charSequence);
    }

    public CharSequence p() {
        return this.f2091a.getClassName();
    }

    public void p0(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f2091a.setPaneTitle(charSequence);
        } else if (i >= 19) {
            this.f2091a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void q0(View view) {
        this.f6917a = -1;
        this.f2091a.setParent(view);
    }

    public CharSequence r() {
        return this.f2091a.getContentDescription();
    }

    public void r0(View view, int i) {
        this.f6917a = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2091a.setParent(view, i);
        }
    }

    public Bundle s() {
        return Build.VERSION.SDK_INT >= 19 ? this.f2091a.getExtras() : new Bundle();
    }

    public void s0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2091a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public final SparseArray<WeakReference<ClickableSpan>> t(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayV = v(view);
        if (sparseArrayV != null) {
            return sparseArrayV;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(ra.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    public void t0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2091a.setScreenReaderFocusable(z);
        } else {
            V(1, z);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m(rect);
        sb.append("; boundsInParent: " + rect);
        n(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(u());
        sb.append("; className: ");
        sb.append(p());
        sb.append("; text: ");
        sb.append(w());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; viewId: ");
        sb.append(x());
        sb.append("; checkable: ");
        sb.append(B());
        sb.append("; checked: ");
        sb.append(C());
        sb.append("; focusable: ");
        sb.append(F());
        sb.append("; focused: ");
        sb.append(G());
        sb.append("; selected: ");
        sb.append(K());
        sb.append("; clickable: ");
        sb.append(D());
        sb.append("; longClickable: ");
        sb.append(H());
        sb.append("; enabled: ");
        sb.append(E());
        sb.append("; password: ");
        sb.append(I());
        sb.append("; scrollable: " + J());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> listI = i();
            for (int i = 0; i < listI.size(); i++) {
                a aVar = listI.get(i);
                String strJ = j(aVar.b());
                if (strJ.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                    strJ = aVar.c().toString();
                }
                sb.append(strJ);
                if (i != listI.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int iK = k();
            while (iK != 0) {
                int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iK);
                iK &= ~iNumberOfTrailingZeros;
                sb.append(j(iNumberOfTrailingZeros));
                if (iK != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        return this.f2091a.getPackageName();
    }

    public void u0(boolean z) {
        this.f2091a.setScrollable(z);
    }

    public final SparseArray<WeakReference<ClickableSpan>> v(View view) {
        return (SparseArray) view.getTag(ra.tag_accessibility_clickable_spans);
    }

    public void v0(boolean z) {
        this.f2091a.setSelected(z);
    }

    public CharSequence w() {
        if (!y()) {
            return this.f2091a.getText();
        }
        List<Integer> listH = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> listH2 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> listH3 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> listH4 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f2091a.getText(), 0, this.f2091a.getText().length()));
        for (int i = 0; i < listH.size(); i++) {
            spannableString.setSpan(new li(listH4.get(i).intValue(), this, s().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listH.get(i).intValue(), listH2.get(i).intValue(), listH3.get(i).intValue());
        }
        return spannableString;
    }

    public void w0(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2091a.setShowingHintText(z);
        } else {
            V(4, z);
        }
    }

    public String x() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f2091a.getViewIdResourceName();
        }
        return null;
    }

    public void x0(View view) {
        this.b = -1;
        this.f2091a.setSource(view);
    }

    public final boolean y() {
        return !h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void y0(View view, int i) {
        this.b = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2091a.setSource(view, i);
        }
    }

    public final int z(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = c;
        c = i2 + 1;
        return i2;
    }

    public void z0(CharSequence charSequence) {
        if (td.a()) {
            this.f2091a.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f2091a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }
}
