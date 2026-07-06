package a;

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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i4 implements qd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f6373a = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f1310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l4 f1311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1312a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Resources f1313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f1314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ContextMenu.ContextMenuInfo f1315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f1317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1320a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1321b;
    public boolean k;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1309a = 0;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f1324e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public ArrayList<l4> e = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CopyOnWriteArrayList<WeakReference<v4>> f1319a = new CopyOnWriteArrayList<>();
    public boolean j = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<l4> f1318a = new ArrayList<>();
    public ArrayList<l4> b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1322c = true;
    public ArrayList<l4> c = new ArrayList<>();
    public ArrayList<l4> d = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1323d = true;

    public interface a {
        void a(i4 i4Var);

        boolean b(i4 i4Var, MenuItem menuItem);
    }

    public interface b {
        boolean c(l4 l4Var);
    }

    public i4(Context context) {
        this.f1312a = context;
        this.f1313a = context.getResources();
        b0(true);
    }

    public static int B(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = f6373a;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public static int n(ArrayList<l4> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).h() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean A() {
        return this.h;
    }

    public Resources C() {
        return this.f1313a;
    }

    public i4 D() {
        return this;
    }

    public ArrayList<l4> E() {
        if (!this.f1322c) {
            return this.b;
        }
        this.b.clear();
        int size = this.f1318a.size();
        for (int i = 0; i < size; i++) {
            l4 l4Var = this.f1318a.get(i);
            if (l4Var.isVisible()) {
                this.b.add(l4Var);
            }
        }
        this.f1322c = false;
        this.f1323d = true;
        return this.b;
    }

    public boolean F() {
        return this.j;
    }

    public boolean G() {
        return this.f1320a;
    }

    public boolean H() {
        return this.f1321b;
    }

    public void I(l4 l4Var) {
        this.f1323d = true;
        K(true);
    }

    public void J(l4 l4Var) {
        this.f1322c = true;
        K(true);
    }

    public void K(boolean z) {
        if (this.f1324e) {
            this.f = true;
            if (z) {
                this.g = true;
                return;
            }
            return;
        }
        if (z) {
            this.f1322c = true;
            this.f1323d = true;
        }
        i(z);
    }

    public boolean L(MenuItem menuItem, int i) {
        return M(menuItem, null, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[PHI: r1
  0x002d: PHI (r1v4 boolean) = (r1v2 boolean), (r1v1 boolean), (r1v5 boolean) binds: [B:35:0x0068, B:23:0x003c, B:16:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean M(android.view.MenuItem r7, a.v4 r8, int r9) {
        /*
            r6 = this;
            a.l4 r7 = (a.l4) r7
            r0 = 0
            if (r7 == 0) goto L6c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Lc
            goto L6c
        Lc:
            boolean r1 = r7.m()
            a.uf r2 = r7.c()
            r3 = 1
            if (r2 == 0) goto L1f
            boolean r4 = r2.a()
            if (r4 == 0) goto L1f
            r4 = r3
            goto L20
        L1f:
            r4 = r0
        L20:
            boolean r5 = r7.l()
            if (r5 == 0) goto L31
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L6b
        L2d:
            r6.e(r3)
            goto L6b
        L31:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L3f
            if (r4 == 0) goto L3a
            goto L3f
        L3a:
            r7 = r9 & 1
            if (r7 != 0) goto L6b
            goto L2d
        L3f:
            r9 = r9 & 4
            if (r9 != 0) goto L46
            r6.e(r0)
        L46:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L58
            a.c5 r9 = new a.c5
            android.content.Context r0 = r6.u()
            r9.<init>(r0, r6, r7)
            r7.z(r9)
        L58:
            android.view.SubMenu r7 = r7.getSubMenu()
            a.c5 r7 = (a.c5) r7
            if (r4 == 0) goto L63
            r2.f(r7)
        L63:
            boolean r7 = r6.j(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L6b
            goto L2d
        L6b:
            return r1
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i4.M(android.view.MenuItem, a.v4, int):boolean");
    }

    public final void N(int i, boolean z) {
        if (i < 0 || i >= this.f1318a.size()) {
            return;
        }
        this.f1318a.remove(i);
        if (z) {
            K(true);
        }
    }

    public void O(v4 v4Var) {
        for (WeakReference<v4> weakReference : this.f1319a) {
            v4 v4Var2 = weakReference.get();
            if (v4Var2 == null || v4Var2 == v4Var) {
                this.f1319a.remove(weakReference);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((c5) item.getSubMenu()).P(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((c5) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.f1310a = aVar;
    }

    public i4 S(int i) {
        this.f1309a = i;
        return this;
    }

    public void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1318a.size();
        d0();
        for (int i = 0; i < size; i++) {
            l4 l4Var = this.f1318a.get(i);
            if (l4Var.getGroupId() == groupId && l4Var.o() && l4Var.isCheckable()) {
                l4Var.u(l4Var == menuItem);
            }
        }
        c0();
    }

    public i4 U(int i) {
        W(0, null, i, null, null);
        return this;
    }

    public i4 V(Drawable drawable) {
        W(0, null, 0, drawable, null);
        return this;
    }

    public final void W(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resourcesC = C();
        if (view != null) {
            this.f1316a = view;
            this.f1317a = null;
            this.f1314a = null;
        } else {
            if (i > 0) {
                this.f1317a = resourcesC.getText(i);
            } else if (charSequence != null) {
                this.f1317a = charSequence;
            }
            if (i2 > 0) {
                this.f1314a = yb.d(u(), i2);
            } else if (drawable != null) {
                this.f1314a = drawable;
            }
            this.f1316a = null;
        }
        K(false);
    }

    public i4 X(int i) {
        W(i, null, 0, null, null);
        return this;
    }

    public i4 Y(CharSequence charSequence) {
        W(0, charSequence, 0, null, null);
        return this;
    }

    public i4 Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    public MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int iB = B(i3);
        l4 l4VarG = g(i, i2, i3, iB, charSequence, this.f1309a);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1315a;
        if (contextMenuInfo != null) {
            l4VarG.x(contextMenuInfo);
        }
        ArrayList<l4> arrayList = this.f1318a;
        arrayList.add(n(arrayList, iB), l4VarG);
        K(true);
        return l4VarG;
    }

    public void a0(boolean z) {
        this.k = z;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.f1313a.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f1313a.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.f1312a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1313a.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1313a.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        l4 l4Var = (l4) a(i, i2, i3, charSequence);
        c5 c5Var = new c5(this.f1312a, this, l4Var);
        l4Var.z(c5Var);
        return c5Var;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(v4 v4Var) {
        c(v4Var, this.f1312a);
    }

    public final void b0(boolean z) {
        this.f1321b = z && this.f1313a.getConfiguration().keyboard != 1 && fh.e(ViewConfiguration.get(this.f1312a), this.f1312a);
    }

    public void c(v4 v4Var, Context context) {
        this.f1319a.add(new WeakReference<>(v4Var));
        v4Var.f(context, this);
        this.f1323d = true;
    }

    public void c0() {
        this.f1324e = false;
        if (this.f) {
            this.f = false;
            K(this.g);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        l4 l4Var = this.f1311a;
        if (l4Var != null) {
            f(l4Var);
        }
        this.f1318a.clear();
        K(true);
    }

    public void clearHeader() {
        this.f1314a = null;
        this.f1317a = null;
        this.f1316a = null;
        K(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f1310a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void d0() {
        if (this.f1324e) {
            return;
        }
        this.f1324e = true;
        this.f = false;
        this.g = false;
    }

    public final void e(boolean z) {
        if (this.i) {
            return;
        }
        this.i = true;
        for (WeakReference<v4> weakReference : this.f1319a) {
            v4 v4Var = weakReference.get();
            if (v4Var == null) {
                this.f1319a.remove(weakReference);
            } else {
                v4Var.b(this, z);
            }
        }
        this.i = false;
    }

    public boolean f(l4 l4Var) {
        boolean zD = false;
        if (!this.f1319a.isEmpty() && this.f1311a == l4Var) {
            d0();
            for (WeakReference<v4> weakReference : this.f1319a) {
                v4 v4Var = weakReference.get();
                if (v4Var != null) {
                    zD = v4Var.d(this, l4Var);
                    if (zD) {
                        break;
                    }
                } else {
                    this.f1319a.remove(weakReference);
                }
            }
            c0();
            if (zD) {
                this.f1311a = null;
            }
        }
        return zD;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            l4 l4Var = this.f1318a.get(i2);
            if (l4Var.getItemId() == i) {
                return l4Var;
            }
            if (l4Var.hasSubMenu() && (menuItemFindItem = l4Var.getSubMenu().findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final l4 g(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new l4(this, i, i2, i3, i4, charSequence, i5);
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f1318a.get(i);
    }

    public boolean h(i4 i4Var, MenuItem menuItem) {
        a aVar = this.f1310a;
        return aVar != null && aVar.b(i4Var, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.k) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f1318a.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i(boolean z) {
        if (this.f1319a.isEmpty()) {
            return;
        }
        d0();
        for (WeakReference<v4> weakReference : this.f1319a) {
            v4 v4Var = weakReference.get();
            if (v4Var == null) {
                this.f1319a.remove(weakReference);
            } else {
                v4Var.i(z);
            }
        }
        c0();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return p(i, keyEvent) != null;
    }

    public final boolean j(c5 c5Var, v4 v4Var) {
        if (this.f1319a.isEmpty()) {
            return false;
        }
        boolean zJ = v4Var != null ? v4Var.j(c5Var) : false;
        for (WeakReference<v4> weakReference : this.f1319a) {
            v4 v4Var2 = weakReference.get();
            if (v4Var2 == null) {
                this.f1319a.remove(weakReference);
            } else if (!zJ) {
                zJ = v4Var2.j(c5Var);
            }
        }
        return zJ;
    }

    public boolean k(l4 l4Var) {
        boolean zK = false;
        if (this.f1319a.isEmpty()) {
            return false;
        }
        d0();
        for (WeakReference<v4> weakReference : this.f1319a) {
            v4 v4Var = weakReference.get();
            if (v4Var != null) {
                zK = v4Var.k(this, l4Var);
                if (zK) {
                    break;
                }
            } else {
                this.f1319a.remove(weakReference);
            }
        }
        c0();
        if (zK) {
            this.f1311a = l4Var;
        }
        return zK;
    }

    public int l(int i) {
        return m(i, 0);
    }

    public int m(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.f1318a.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int o(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f1318a.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public l4 p(int i, KeyEvent keyEvent) {
        ArrayList<l4> arrayList = this.e;
        arrayList.clear();
        q(arrayList, i, keyEvent);
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
        boolean zG = G();
        for (int i2 = 0; i2 < size; i2++) {
            l4 l4Var = arrayList.get(i2);
            char alphabeticShortcut = zG ? l4Var.getAlphabeticShortcut() : l4Var.getNumericShortcut();
            if ((alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) || (zG && alphabeticShortcut == '\b' && i == 67))) {
                return l4Var;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return L(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        l4 l4VarP = p(i, keyEvent);
        boolean zL = l4VarP != null ? L(l4VarP, i2) : false;
        if ((i2 & 2) != 0) {
            e(true);
        }
        return zL;
    }

    public void q(List<l4> list, int i, KeyEvent keyEvent) {
        boolean zG = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1318a.size();
            for (int i2 = 0; i2 < size; i2++) {
                l4 l4Var = this.f1318a.get(i2);
                if (l4Var.hasSubMenu()) {
                    ((i4) l4Var.getSubMenu()).q(list, i, keyEvent);
                }
                char alphabeticShortcut = zG ? l4Var.getAlphabeticShortcut() : l4Var.getNumericShortcut();
                if (((modifiers & 69647) == ((zG ? l4Var.getAlphabeticModifiers() : l4Var.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zG && alphabeticShortcut == '\b' && i == 67)) && l4Var.isEnabled()) {
                        list.add(l4Var);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<l4> arrayListE = E();
        if (this.f1323d) {
            boolean zH = false;
            for (WeakReference<v4> weakReference : this.f1319a) {
                v4 v4Var = weakReference.get();
                if (v4Var == null) {
                    this.f1319a.remove(weakReference);
                } else {
                    zH |= v4Var.h();
                }
            }
            if (zH) {
                this.c.clear();
                this.d.clear();
                int size = arrayListE.size();
                for (int i = 0; i < size; i++) {
                    l4 l4Var = arrayListE.get(i);
                    (l4Var.n() ? this.c : this.d).add(l4Var);
                }
            } else {
                this.c.clear();
                this.d.clear();
                this.d.addAll(E());
            }
            this.f1323d = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iL = l(i);
        if (iL >= 0) {
            int size = this.f1318a.size() - iL;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f1318a.get(iL).getGroupId() != i) {
                    break;
                }
                N(iL, false);
                i2 = i3;
            }
            K(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        N(o(i), true);
    }

    public ArrayList<l4> s() {
        r();
        return this.c;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1318a.size();
        for (int i2 = 0; i2 < size; i2++) {
            l4 l4Var = this.f1318a.get(i2);
            if (l4Var.getGroupId() == i) {
                l4Var.v(z2);
                l4Var.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.j = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1318a.size();
        for (int i2 = 0; i2 < size; i2++) {
            l4 l4Var = this.f1318a.get(i2);
            if (l4Var.getGroupId() == i) {
                l4Var.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f1318a.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            l4 l4Var = this.f1318a.get(i2);
            if (l4Var.getGroupId() == i && l4Var.A(z)) {
                z2 = true;
            }
        }
        if (z2) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f1320a = z;
        K(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1318a.size();
    }

    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f1312a;
    }

    public l4 v() {
        return this.f1311a;
    }

    public Drawable w() {
        return this.f1314a;
    }

    public CharSequence x() {
        return this.f1317a;
    }

    public View y() {
        return this.f1316a;
    }

    public ArrayList<l4> z() {
        r();
        return this.d;
    }
}
