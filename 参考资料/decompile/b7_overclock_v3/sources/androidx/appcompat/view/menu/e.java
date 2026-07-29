package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.RestrictTo;
import androidx.core.view.w0;
import g.n0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class e implements r0.a {
    public static final String L = "MenuBuilder";
    public static final String M = "android:menu:presenters";
    public static final String N = "android:menu:actionviewstates";
    public static final String O = "android:menu:expandedactionview";
    public static final int[] P = {1, 4, 5, 3, 2, 0};
    public View A;
    public h I;
    public boolean K;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f1934l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Resources f1935m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1936n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1937o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f1938p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f1946x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f1947y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f1948z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1945w = 0;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public boolean F = false;
    public ArrayList<h> G = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<j>> H = new CopyOnWriteArrayList<>();
    public boolean J = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<h> f1939q = new ArrayList<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<h> f1940r = new ArrayList<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1941s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList<h> f1942t = new ArrayList<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<h> f1943u = new ArrayList<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1944v = true;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface a {
        boolean a(@n0 e eVar, @n0 MenuItem menuItem);

        void b(@n0 e eVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface b {
        boolean a(h hVar);
    }

    public e(Context context) {
        this.f1934l = context;
        this.f1935m = context.getResources();
        k0(true);
    }

    public static int E(int i10) {
        int i11 = ((-65536) & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = P;
            if (i11 < iArr.length) {
                return (i10 & 65535) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public static int q(ArrayList<h> arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).i() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    public CharSequence A() {
        return this.f1947y;
    }

    public View B() {
        return this.A;
    }

    public ArrayList<h> C() {
        u();
        return this.f1943u;
    }

    public boolean D() {
        return this.E;
    }

    public Resources F() {
        return this.f1935m;
    }

    public e G() {
        return this;
    }

    @n0
    public ArrayList<h> H() {
        if (!this.f1941s) {
            return this.f1940r;
        }
        this.f1940r.clear();
        int size = this.f1939q.size();
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = this.f1939q.get(i10);
            if (hVar.isVisible()) {
                this.f1940r.add(hVar);
            }
        }
        this.f1941s = false;
        this.f1944v = true;
        return this.f1940r;
    }

    public boolean I() {
        return this.J;
    }

    public boolean J() {
        return this.f1936n;
    }

    public boolean K() {
        return this.f1937o;
    }

    public void L(h hVar) {
        this.f1944v = true;
        N(true);
    }

    public void M(h hVar) {
        this.f1941s = true;
        N(true);
    }

    public void N(boolean z10) {
        if (this.B) {
            this.C = true;
            if (z10) {
                this.D = true;
                return;
            }
            return;
        }
        if (z10) {
            this.f1941s = true;
            this.f1944v = true;
        }
        j(z10);
    }

    public boolean O(MenuItem menuItem, int i10) {
        return P(menuItem, null, i10);
    }

    public boolean P(MenuItem menuItem, j jVar, int i10) {
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean zN = hVar.n();
        androidx.core.view.b bVarB = hVar.b();
        boolean z10 = bVarB != null && bVarB.b();
        if (hVar.m()) {
            zN |= hVar.expandActionView();
            if (zN) {
                f(true);
            }
        } else if (hVar.hasSubMenu() || z10) {
            if ((i10 & 4) == 0) {
                f(false);
            }
            if (!hVar.hasSubMenu()) {
                hVar.A(new m(x(), this, hVar));
            }
            m mVar = (m) hVar.getSubMenu();
            if (z10) {
                bVarB.g(mVar);
            }
            zN |= m(mVar, jVar);
            if (!zN) {
                f(true);
            }
        } else if ((i10 & 1) == 0) {
            f(true);
        }
        return zN;
    }

    public void Q(int i10) {
        R(i10, true);
    }

    public final void R(int i10, boolean z10) {
        if (i10 < 0 || i10 >= this.f1939q.size()) {
            return;
        }
        this.f1939q.remove(i10);
        if (z10) {
            N(true);
        }
    }

    public void S(j jVar) {
        for (WeakReference<j> weakReference : this.H) {
            j jVar2 = weakReference.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.H.remove(weakReference);
            }
        }
    }

    public void T(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(w());
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).T(bundle);
            }
        }
        int i11 = bundle.getInt(O);
        if (i11 <= 0 || (menuItemFindItem = findItem(i11)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void U(Bundle bundle) {
        k(bundle);
    }

    public void V(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(O, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).V(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(w(), sparseArray);
        }
    }

    public void W(Bundle bundle) {
        l(bundle);
    }

    public void X(a aVar) {
        this.f1938p = aVar;
    }

    public void Y(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1946x = contextMenuInfo;
    }

    public e Z(int i10) {
        this.f1945w = i10;
        return this;
    }

    public MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int iE = E(i12);
        h hVarH = h(i10, i11, i12, iE, charSequence, this.f1945w);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1946x;
        if (contextMenuInfo != null) {
            hVarH.y(contextMenuInfo);
        }
        ArrayList<h> arrayList = this.f1939q;
        arrayList.add(q(arrayList, iE), hVarH);
        N(true);
        return hVarH;
    }

    public void a0(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1939q.size();
        m0();
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = this.f1939q.get(i10);
            if (hVar.getGroupId() == groupId && hVar.p() && hVar.isCheckable()) {
                hVar.v(hVar == menuItem);
            }
        }
        l0();
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f1934l.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i15 = 0; i15 < size; i15++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i15);
            int i16 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i16 < 0 ? intent : intentArr[i16]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i14 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i14] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(j jVar) {
        c(jVar, this.f1934l);
    }

    public e b0(int i10) {
        d0(0, null, i10, null, null);
        return this;
    }

    public void c(j jVar, Context context) {
        this.H.add(new WeakReference<>(jVar));
        jVar.i(context, this);
        this.f1944v = true;
    }

    public e c0(Drawable drawable) {
        d0(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        h hVar = this.I;
        if (hVar != null) {
            g(hVar);
        }
        this.f1939q.clear();
        N(true);
    }

    public void clearHeader() {
        this.f1948z = null;
        this.f1947y = null;
        this.A = null;
        N(false);
    }

    @Override // android.view.Menu
    public void close() {
        f(true);
    }

    public void d() {
        a aVar = this.f1938p;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public final void d0(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources resourcesF = F();
        if (view != null) {
            this.A = view;
            this.f1947y = null;
            this.f1948z = null;
        } else {
            if (i10 > 0) {
                this.f1947y = resourcesF.getText(i10);
            } else if (charSequence != null) {
                this.f1947y = charSequence;
            }
            if (i11 > 0) {
                this.f1948z = h0.d.i(x(), i11);
            } else if (drawable != null) {
                this.f1948z = drawable;
            }
            this.A = null;
        }
        N(false);
    }

    public void e() {
        this.B = true;
        clear();
        clearHeader();
        this.H.clear();
        this.B = false;
        this.C = false;
        this.D = false;
        N(true);
    }

    public e e0(int i10) {
        d0(i10, null, 0, null, null);
        return this;
    }

    public final void f(boolean z10) {
        if (this.F) {
            return;
        }
        this.F = true;
        for (WeakReference<j> weakReference : this.H) {
            j jVar = weakReference.get();
            if (jVar == null) {
                this.H.remove(weakReference);
            } else {
                jVar.b(this, z10);
            }
        }
        this.F = false;
    }

    public e f0(CharSequence charSequence) {
        d0(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = this.f1939q.get(i11);
            if (hVar.getItemId() == i10) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (menuItemFindItem = hVar.getSubMenu().findItem(i10)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public boolean g(h hVar) {
        boolean zF = false;
        if (!this.H.isEmpty() && this.I == hVar) {
            m0();
            for (WeakReference<j> weakReference : this.H) {
                j jVar = weakReference.get();
                if (jVar != null) {
                    zF = jVar.f(this, hVar);
                    if (zF) {
                        break;
                    }
                } else {
                    this.H.remove(weakReference);
                }
            }
            l0();
            if (zF) {
                this.I = null;
            }
        }
        return zF;
    }

    public e g0(View view) {
        d0(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return this.f1939q.get(i10);
    }

    public final h h(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new h(this, i10, i11, i12, i13, charSequence, i14);
    }

    public void h0(boolean z10) {
        this.E = z10;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.K) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f1939q.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean i(@n0 e eVar, @n0 MenuItem menuItem) {
        a aVar = this.f1938p;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    public void i0(boolean z10) {
        this.K = z10;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return s(i10, keyEvent) != null;
    }

    public final void j(boolean z10) {
        if (this.H.isEmpty()) {
            return;
        }
        m0();
        for (WeakReference<j> weakReference : this.H) {
            j jVar = weakReference.get();
            if (jVar == null) {
                this.H.remove(weakReference);
            } else {
                jVar.c(z10);
            }
        }
        l0();
    }

    public void j0(boolean z10) {
        if (this.f1937o == z10) {
            return;
        }
        k0(z10);
        N(false);
    }

    public final void k(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(M);
        if (sparseParcelableArray == null || this.H.isEmpty()) {
            return;
        }
        for (WeakReference<j> weakReference : this.H) {
            j jVar = weakReference.get();
            if (jVar == null) {
                this.H.remove(weakReference);
            } else {
                int id2 = jVar.getId();
                if (id2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id2)) != null) {
                    jVar.j(parcelable);
                }
            }
        }
    }

    public final void k0(boolean z10) {
        this.f1937o = z10 && this.f1935m.getConfiguration().keyboard != 1 && w0.g(ViewConfiguration.get(this.f1934l), this.f1934l);
    }

    public final void l(Bundle bundle) {
        Parcelable parcelableN;
        if (this.H.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference<j> weakReference : this.H) {
            j jVar = weakReference.get();
            if (jVar == null) {
                this.H.remove(weakReference);
            } else {
                int id2 = jVar.getId();
                if (id2 > 0 && (parcelableN = jVar.n()) != null) {
                    sparseArray.put(id2, parcelableN);
                }
            }
        }
        bundle.putSparseParcelableArray(M, sparseArray);
    }

    public void l0() {
        this.B = false;
        if (this.C) {
            this.C = false;
            N(this.D);
        }
    }

    public final boolean m(m mVar, j jVar) {
        if (this.H.isEmpty()) {
            return false;
        }
        boolean zL = jVar != null ? jVar.l(mVar) : false;
        for (WeakReference<j> weakReference : this.H) {
            j jVar2 = weakReference.get();
            if (jVar2 == null) {
                this.H.remove(weakReference);
            } else if (!zL) {
                zL = jVar2.l(mVar);
            }
        }
        return zL;
    }

    public void m0() {
        if (this.B) {
            return;
        }
        this.B = true;
        this.C = false;
        this.D = false;
    }

    public boolean n(h hVar) {
        boolean zG = false;
        if (this.H.isEmpty()) {
            return false;
        }
        m0();
        for (WeakReference<j> weakReference : this.H) {
            j jVar = weakReference.get();
            if (jVar != null) {
                zG = jVar.g(this, hVar);
                if (zG) {
                    break;
                }
            } else {
                this.H.remove(weakReference);
            }
        }
        l0();
        if (zG) {
            this.I = hVar;
        }
        return zG;
    }

    public int o(int i10) {
        return p(i10, 0);
    }

    public int p(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (this.f1939q.get(i11).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return O(findItem(i10), i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        h hVarS = s(i10, keyEvent);
        boolean zO = hVarS != null ? O(hVarS, i11) : false;
        if ((i11 & 2) != 0) {
            f(true);
        }
        return zO;
    }

    public int r(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f1939q.get(i11).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        int iO = o(i10);
        if (iO >= 0) {
            int size = this.f1939q.size() - iO;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || this.f1939q.get(iO).getGroupId() != i10) {
                    break;
                }
                R(iO, false);
                i11 = i12;
            }
            N(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        R(r(i10), true);
    }

    public h s(int i10, KeyEvent keyEvent) {
        ArrayList<h> arrayList = this.G;
        arrayList.clear();
        t(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zJ = J();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = arrayList.get(i11);
            char alphabeticShortcut = zJ ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zJ && alphabeticShortcut == '\b' && i10 == 67))) {
                return hVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.f1939q.size();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = this.f1939q.get(i11);
            if (hVar.getGroupId() == i10) {
                hVar.w(z11);
                hVar.setCheckable(z10);
            }
        }
    }

    @Override // r0.a, android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.J = z10;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.f1939q.size();
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = this.f1939q.get(i11);
            if (hVar.getGroupId() == i10) {
                hVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        int size = this.f1939q.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            h hVar = this.f1939q.get(i11);
            if (hVar.getGroupId() == i10 && hVar.B(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            N(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f1936n = z10;
        N(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1939q.size();
    }

    public void t(List<h> list, int i10, KeyEvent keyEvent) {
        boolean zJ = J();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            int size = this.f1939q.size();
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = this.f1939q.get(i11);
                if (hVar.hasSubMenu()) {
                    ((e) hVar.getSubMenu()).t(list, i10, keyEvent);
                }
                char alphabeticShortcut = zJ ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if (((modifiers & r0.a.f47682e) == ((zJ ? hVar.getAlphabeticModifiers() : hVar.getNumericModifiers()) & r0.a.f47682e)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zJ && alphabeticShortcut == '\b' && i10 == 67)) && hVar.isEnabled()) {
                        list.add(hVar);
                    }
                }
            }
        }
    }

    public void u() {
        ArrayList<h> arrayListH = H();
        if (this.f1944v) {
            boolean zE = false;
            for (WeakReference<j> weakReference : this.H) {
                j jVar = weakReference.get();
                if (jVar == null) {
                    this.H.remove(weakReference);
                } else {
                    zE |= jVar.e();
                }
            }
            if (zE) {
                this.f1942t.clear();
                this.f1943u.clear();
                int size = arrayListH.size();
                for (int i10 = 0; i10 < size; i10++) {
                    h hVar = arrayListH.get(i10);
                    if (hVar.o()) {
                        this.f1942t.add(hVar);
                    } else {
                        this.f1943u.add(hVar);
                    }
                }
            } else {
                this.f1942t.clear();
                this.f1943u.clear();
                this.f1943u.addAll(H());
            }
            this.f1944v = false;
        }
    }

    public ArrayList<h> v() {
        u();
        return this.f1942t;
    }

    public String w() {
        return N;
    }

    public Context x() {
        return this.f1934l;
    }

    public h y() {
        return this.I;
    }

    public Drawable z() {
        return this.f1948z;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return a(0, 0, 0, this.f1935m.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f1935m.getString(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        h hVar = (h) a(i10, i11, i12, charSequence);
        m mVar = new m(this.f1934l, this, hVar);
        hVar.A(mVar);
        return mVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f1935m.getString(i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f1935m.getString(i13));
    }
}
