package a;

import a.v4;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g4 implements v4, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f4 f965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4 f966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v4.a f967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LayoutInflater f969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExpandedMenuView f970a;
    public int b;
    public int c;

    public g4(int i, int i2) {
        this.c = i;
        this.b = i2;
    }

    public g4(Context context, int i) {
        this(i, 0);
        this.f968a = context;
        this.f969a = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f965a == null) {
            this.f965a = new f4(this);
        }
        return this.f965a;
    }

    @Override // a.v4
    public void b(i4 i4Var, boolean z) {
        v4.a aVar = this.f967a;
        if (aVar != null) {
            aVar.b(i4Var, z);
        }
    }

    public w4 c(ViewGroup viewGroup) {
        if (this.f970a == null) {
            this.f970a = (ExpandedMenuView) this.f969a.inflate(z.abc_expanded_menu_layout, viewGroup, false);
            if (this.f965a == null) {
                this.f965a = new f4(this);
            }
            this.f970a.setAdapter((ListAdapter) this.f965a);
            this.f970a.setOnItemClickListener(this);
        }
        return this.f970a;
    }

    @Override // a.v4
    public boolean d(i4 i4Var, l4 l4Var) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // a.v4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(android.content.Context r3, a.i4 r4) {
        /*
            r2 = this;
            int r0 = r2.b
            if (r0 == 0) goto L14
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.b
            r0.<init>(r3, r1)
            r2.f968a = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L11:
            r2.f969a = r3
            goto L23
        L14:
            android.content.Context r0 = r2.f968a
            if (r0 == 0) goto L23
            r2.f968a = r3
            android.view.LayoutInflater r0 = r2.f969a
            if (r0 != 0) goto L23
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L11
        L23:
            r2.f966a = r4
            a.f4 r3 = r2.f965a
            if (r3 == 0) goto L2c
            r3.notifyDataSetChanged()
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g4.f(android.content.Context, a.i4):void");
    }

    @Override // a.v4
    public void g(v4.a aVar) {
        this.f967a = aVar;
    }

    @Override // a.v4
    public boolean h() {
        return false;
    }

    @Override // a.v4
    public void i(boolean z) {
        f4 f4Var = this.f965a;
        if (f4Var != null) {
            f4Var.notifyDataSetChanged();
        }
    }

    @Override // a.v4
    public boolean j(c5 c5Var) {
        if (!c5Var.hasVisibleItems()) {
            return false;
        }
        new j4(c5Var).d(null);
        v4.a aVar = this.f967a;
        if (aVar == null) {
            return true;
        }
        aVar.c(c5Var);
        return true;
    }

    @Override // a.v4
    public boolean k(i4 i4Var, l4 l4Var) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f966a.M(this.f965a.getItem(i), this, 0);
    }
}
