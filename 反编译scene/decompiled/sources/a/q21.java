package a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q21 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f2536a;

    public q21(Context context, String[] strArr) {
        this.f2536a = strArr;
        this.f7171a = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2536a.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f2536a[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.f7171a, 2131558639, null);
        }
        ((TextView) view).setText(getItem(i).toString());
        return view;
    }
}
