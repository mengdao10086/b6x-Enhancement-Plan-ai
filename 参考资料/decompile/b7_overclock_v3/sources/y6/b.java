package y6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.cooperate.cjzc.bean.EntityCJZCConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f56468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<EntityCJZCConfig> f56469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56470c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f56471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f56472b;
    }

    public b(Context context, ArrayList<EntityCJZCConfig> arrayList) {
        this.f56468a = context;
        this.f56469b = arrayList;
    }

    public void a(int i10) {
        this.f56470c = i10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f56469b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f56469b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f56468a).inflate(R.layout.device_cjzc_item_config, (ViewGroup) null);
            view.setTag(Boolean.FALSE);
            aVar = new a();
            aVar.f56472b = (TextView) view.findViewById(R.id.name);
            aVar.f56471a = view.findViewById(R.id.layout_parent);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f56472b.setText(this.f56469b.get(i10).f());
        int i11 = this.f56470c;
        if (i11 == 0 || i11 == 2) {
            if (this.f56469b.get(i10).d() == 0) {
                aVar.f56471a.setVisibility(0);
            } else {
                aVar.f56471a.setVisibility(8);
            }
        } else if (i11 == 1) {
            if (this.f56469b.get(i10).d() == 0) {
                aVar.f56471a.setVisibility(8);
            } else {
                aVar.f56471a.setVisibility(0);
            }
        }
        return view;
    }
}
