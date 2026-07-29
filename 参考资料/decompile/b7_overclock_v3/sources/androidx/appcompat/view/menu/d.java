package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class d extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f1928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1929b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutInflater f1932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1933f;

    public d(e eVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f1931d = z10;
        this.f1932e = layoutInflater;
        this.f1928a = eVar;
        this.f1933f = i10;
        a();
    }

    public void a() {
        h hVarY = this.f1928a.y();
        if (hVarY != null) {
            ArrayList<h> arrayListC = this.f1928a.C();
            int size = arrayListC.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (arrayListC.get(i10) == hVarY) {
                    this.f1929b = i10;
                    return;
                }
            }
        }
        this.f1929b = -1;
    }

    public e b() {
        return this.f1928a;
    }

    public boolean c() {
        return this.f1930c;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public h getItem(int i10) {
        ArrayList<h> arrayListC = this.f1931d ? this.f1928a.C() : this.f1928a.H();
        int i11 = this.f1929b;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return arrayListC.get(i10);
    }

    public void e(boolean z10) {
        this.f1930c = z10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1929b < 0 ? (this.f1931d ? this.f1928a.C() : this.f1928a.H()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1932e.inflate(this.f1933f, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i11 = i10 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1928a.I() && groupId != (i11 >= 0 ? getItem(i11).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.f1930c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.h(getItem(i10), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
