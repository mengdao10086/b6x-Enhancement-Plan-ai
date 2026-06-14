package a;

import a.w4;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class f4 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6070a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ g4 f850a;

    public f4(g4 g4Var) {
        this.f850a = g4Var;
        a();
    }

    public void a() {
        l4 l4VarV = this.f850a.f966a.v();
        if (l4VarV != null) {
            ArrayList<l4> arrayListZ = this.f850a.f966a.z();
            int size = arrayListZ.size();
            for (int i = 0; i < size; i++) {
                if (arrayListZ.get(i) == l4VarV) {
                    this.f6070a = i;
                    return;
                }
            }
        }
        this.f6070a = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public l4 getItem(int i) {
        ArrayList<l4> arrayListZ = this.f850a.f966a.z();
        int i2 = i + this.f850a.f6167a;
        int i3 = this.f6070a;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return arrayListZ.get(i2);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.f850a.f966a.z().size() - this.f850a.f6167a;
        return this.f6070a < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            g4 g4Var = this.f850a;
            view = g4Var.f969a.inflate(g4Var.c, viewGroup, false);
        }
        ((w4.a) view).e(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
