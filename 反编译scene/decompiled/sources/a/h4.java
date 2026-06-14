package a;

import a.w4;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h4 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6272a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4 f1119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LayoutInflater f1120a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1121b;
    public final boolean c;

    public h4(i4 i4Var, LayoutInflater layoutInflater, boolean z, int i) {
        this.c = z;
        this.f1120a = layoutInflater;
        this.f1119a = i4Var;
        this.b = i;
        a();
    }

    public void a() {
        l4 l4VarV = this.f1119a.v();
        if (l4VarV != null) {
            ArrayList<l4> arrayListZ = this.f1119a.z();
            int size = arrayListZ.size();
            for (int i = 0; i < size; i++) {
                if (arrayListZ.get(i) == l4VarV) {
                    this.f6272a = i;
                    return;
                }
            }
        }
        this.f6272a = -1;
    }

    public i4 b() {
        return this.f1119a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public l4 getItem(int i) {
        ArrayList<l4> arrayListZ = this.c ? this.f1119a.z() : this.f1119a.E();
        int i2 = this.f6272a;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return arrayListZ.get(i);
    }

    public void d(boolean z) {
        this.f1121b = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<l4> arrayListZ = this.c ? this.f1119a.z() : this.f1119a.E();
        int i = this.f6272a;
        int size = arrayListZ.size();
        return i < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1120a.inflate(this.b, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1119a.F() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        w4.a aVar = (w4.a) view;
        if (this.f1121b) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
