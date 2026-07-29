package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f1870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f1871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayoutInflater f1872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j.a f1873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f1876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1877j;

    public a(Context context, int i10, int i11) {
        this.f1868a = context;
        this.f1871d = LayoutInflater.from(context);
        this.f1874g = i10;
        this.f1875h = i11;
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z10) {
        j.a aVar = this.f1873f;
        if (aVar != null) {
            aVar.b(eVar, z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public void c(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f1876i;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f1870c;
        int i10 = 0;
        if (eVar != null) {
            eVar.u();
            ArrayList<h> arrayListH = this.f1870c.H();
            int size = arrayListH.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                h hVar = arrayListH.get(i12);
                if (t(i11, hVar)) {
                    View childAt = viewGroup.getChildAt(i11);
                    h itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                    View viewR = r(hVar, childAt, viewGroup);
                    if (hVar != itemData) {
                        viewR.setPressed(false);
                        viewR.jumpDrawablesToCurrentState();
                    }
                    if (viewR != childAt) {
                        d(viewR, i11);
                    }
                    i11++;
                }
            }
            i10 = i11;
        }
        while (i10 < viewGroup.getChildCount()) {
            if (!p(viewGroup, i10)) {
                i10++;
            }
        }
    }

    public void d(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1876i).addView(view, i10);
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(e eVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(e eVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public int getId() {
        return this.f1877j;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1873f = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(Context context, e eVar) {
        this.f1869b = context;
        this.f1872e = LayoutInflater.from(context);
        this.f1870c = eVar;
    }

    public abstract void k(h hVar, k.a aVar);

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        j.a aVar = this.f1873f;
        e eVar = mVar;
        if (aVar == null) {
            return false;
        }
        if (mVar == null) {
            eVar = this.f1870c;
        }
        return aVar.c(eVar);
    }

    @Override // androidx.appcompat.view.menu.j
    public k m(ViewGroup viewGroup) {
        if (this.f1876i == null) {
            k kVar = (k) this.f1871d.inflate(this.f1874g, viewGroup, false);
            this.f1876i = kVar;
            kVar.e(this.f1870c);
            c(true);
        }
        return this.f1876i;
    }

    public k.a o(ViewGroup viewGroup) {
        return (k.a) this.f1871d.inflate(this.f1875h, viewGroup, false);
    }

    public boolean p(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public j.a q() {
        return this.f1873f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View r(h hVar, View view, ViewGroup viewGroup) {
        k.a aVarO = view instanceof k.a ? (k.a) view : o(viewGroup);
        k(hVar, aVarO);
        return (View) aVarO;
    }

    public void s(int i10) {
        this.f1877j = i10;
    }

    public boolean t(int i10, h hVar) {
        return true;
    }
}
