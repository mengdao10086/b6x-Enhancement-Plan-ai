package a;

import a.v4;
import a.w4;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class x3 implements v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4 f3515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v4.a f3516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public w4 f3517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f3518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LayoutInflater f3519a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Context f3520b;

    public x3(Context context, int i, int i2) {
        this.f3518a = context;
        this.f3519a = LayoutInflater.from(context);
        this.f7849a = i;
        this.b = i2;
    }

    public void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f3517a).addView(view, i);
    }

    @Override // a.v4
    public void b(i4 i4Var, boolean z) {
        v4.a aVar = this.f3516a;
        if (aVar != null) {
            aVar.b(i4Var, z);
        }
    }

    public abstract void c(l4 l4Var, w4.a aVar);

    @Override // a.v4
    public boolean d(i4 i4Var, l4 l4Var) {
        return false;
    }

    public w4.a e(ViewGroup viewGroup) {
        return (w4.a) this.f3519a.inflate(this.b, viewGroup, false);
    }

    @Override // a.v4
    public void f(Context context, i4 i4Var) {
        this.f3520b = context;
        LayoutInflater.from(context);
        this.f3515a = i4Var;
    }

    @Override // a.v4
    public void g(v4.a aVar) {
        this.f3516a = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.v4
    public void i(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f3517a;
        if (viewGroup == null) {
            return;
        }
        i4 i4Var = this.f3515a;
        int i = 0;
        if (i4Var != null) {
            i4Var.r();
            ArrayList<l4> arrayListE = this.f3515a.E();
            int size = arrayListE.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                l4 l4Var = arrayListE.get(i3);
                if (q(i2, l4Var)) {
                    View childAt = viewGroup.getChildAt(i2);
                    l4 itemData = childAt instanceof w4.a ? ((w4.a) childAt).getItemData() : null;
                    View viewN = n(l4Var, childAt, viewGroup);
                    if (l4Var != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        a(viewN, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!l(viewGroup, i)) {
                i++;
            }
        }
    }

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
    @Override // a.v4
    public boolean j(c5 c5Var) {
        v4.a aVar = this.f3516a;
        i4 i4Var = c5Var;
        if (aVar == null) {
            return false;
        }
        if (c5Var == null) {
            i4Var = this.f3515a;
        }
        return aVar.c(i4Var);
    }

    @Override // a.v4
    public boolean k(i4 i4Var, l4 l4Var) {
        return false;
    }

    public boolean l(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public v4.a m() {
        return this.f3516a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(l4 l4Var, View view, ViewGroup viewGroup) {
        w4.a aVarE = view instanceof w4.a ? (w4.a) view : e(viewGroup);
        c(l4Var, aVarE);
        return (View) aVarE;
    }

    public w4 o(ViewGroup viewGroup) {
        if (this.f3517a == null) {
            w4 w4Var = (w4) this.f3519a.inflate(this.f7849a, viewGroup, false);
            this.f3517a = w4Var;
            w4Var.d(this.f3515a);
            i(true);
        }
        return this.f3517a;
    }

    public void p(int i) {
    }

    public abstract boolean q(int i, l4 l4Var);
}
