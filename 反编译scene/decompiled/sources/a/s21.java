package a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class s21 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7355a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<HashMap<String, String>> f2830a;

    public s21(Context context, ArrayList<HashMap<String, String>> arrayList) {
        this.f7355a = context;
        this.f2830a = arrayList;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<String, String> getItem(int i) {
        return this.f2830a.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<HashMap<String, String>> arrayList = this.f2830a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        r21 r21Var;
        if (view == null) {
            r21Var = new r21(this);
            viewInflate = View.inflate(this.f7355a, 2131558636, null);
            r21Var.f7264a = (TextView) viewInflate.findViewById(t61.itemPath);
            r21Var.b = (TextView) viewInflate.findViewById(t61.itemType);
            r21Var.c = (TextView) viewInflate.findViewById(t61.itemSize);
            r21Var.d = (TextView) viewInflate.findViewById(t61.itemUsed);
            r21Var.e = (TextView) viewInflate.findViewById(t61.itemPriority);
            viewInflate.setTag(r21Var);
        } else {
            viewInflate = view;
            r21Var = (r21) view.getTag();
        }
        r21Var.f7264a.setText(getItem(i).get("path"));
        r21Var.b.setText(getItem(i).get("type"));
        r21Var.c.setText(getItem(i).get("size"));
        r21Var.d.setText(getItem(i).get("used"));
        r21Var.e.setText(getItem(i).get("priority"));
        return viewInflate;
    }
}
