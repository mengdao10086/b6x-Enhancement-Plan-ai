package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class c implements j, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f1914k = "ListMenuPresenter";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f1915l = "android:menu:list";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f1917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f1918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f1919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j.a f1923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f1924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1925j;

    public class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1926a = -1;

        public a() {
            a();
        }

        public void a() {
            h hVarY = c.this.f1918c.y();
            if (hVarY != null) {
                ArrayList<h> arrayListC = c.this.f1918c.C();
                int size = arrayListC.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (arrayListC.get(i10) == hVarY) {
                        this.f1926a = i10;
                        return;
                    }
                }
            }
            this.f1926a = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h getItem(int i10) {
            ArrayList<h> arrayListC = c.this.f1918c.C();
            int i11 = i10 + c.this.f1920e;
            int i12 = this.f1926a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return arrayListC.get(i11);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = c.this.f1918c.C().size() - c.this.f1920e;
            return this.f1926a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f1917b.inflate(cVar.f1922g, viewGroup, false);
            }
            ((k.a) view).h(getItem(i10), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(Context context, int i10) {
        this(i10, 0);
        this.f1916a = context;
        this.f1917b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f1924i == null) {
            this.f1924i = new a();
        }
        return this.f1924i;
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z10) {
        j.a aVar = this.f1923h;
        if (aVar != null) {
            aVar.b(eVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(boolean z10) {
        a aVar = this.f1924i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public int d() {
        return this.f1920e;
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
        return this.f1925j;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1923h = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(Context context, e eVar) {
        if (this.f1921f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1921f);
            this.f1916a = contextThemeWrapper;
            this.f1917b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f1916a != null) {
            this.f1916a = context;
            if (this.f1917b == null) {
                this.f1917b = LayoutInflater.from(context);
            }
        }
        this.f1918c = eVar;
        a aVar = this.f1924i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
        k((Bundle) parcelable);
    }

    public void k(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1919d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        new f(mVar).e(null);
        j.a aVar = this.f1923h;
        if (aVar == null) {
            return true;
        }
        aVar.c(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public k m(ViewGroup viewGroup) {
        if (this.f1919d == null) {
            this.f1919d = (ExpandedMenuView) this.f1917b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1924i == null) {
                this.f1924i = new a();
            }
            this.f1919d.setAdapter((ListAdapter) this.f1924i);
            this.f1919d.setOnItemClickListener(this);
        }
        return this.f1919d;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable n() {
        if (this.f1919d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        o(bundle);
        return bundle;
    }

    public void o(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f1919d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f1918c.P(this.f1924i.getItem(i10), this, 0);
    }

    public void p(int i10) {
        this.f1925j = i10;
    }

    public void q(int i10) {
        this.f1920e = i10;
        if (this.f1919d != null) {
            c(false);
        }
    }

    public c(int i10, int i11) {
        this.f1922g = i10;
        this.f1921f = i11;
    }
}
