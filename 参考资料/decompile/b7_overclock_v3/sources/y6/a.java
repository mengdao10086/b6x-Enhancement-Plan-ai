package y6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.cooperate.cjzc.bean.EntityCJZCAction;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f56461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<EntityCJZCAction> f56462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GridView f56463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f56464d;

    /* JADX INFO: renamed from: y6.a$a, reason: collision with other inner class name */
    public static class C0665a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f56465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImageView f56466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f56467c;
    }

    public a(Context context, ArrayList<EntityCJZCAction> arrayList, GridView gridView, int i10) {
        this.f56461a = context;
        this.f56462b = arrayList;
        this.f56463c = gridView;
        this.f56464d = i10;
    }

    public void a(int i10) {
        int firstVisiblePosition = this.f56463c.getFirstVisiblePosition();
        int lastVisiblePosition = this.f56463c.getLastVisiblePosition();
        if (i10 < firstVisiblePosition || i10 > lastVisiblePosition) {
            return;
        }
        ImageView imageView = (ImageView) this.f56463c.getChildAt(i10 - firstVisiblePosition).findViewById(R.id.image_key);
        int i11 = this.f56464d;
        if (i11 == 0 || i11 == 2) {
            imageView.setImageResource(x6.a.g(this.f56462b.get(i10).d()));
        } else if (i11 == 1) {
            imageView.setImageResource(x6.a.h(this.f56462b.get(i10).d()));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f56462b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f56462b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C0665a c0665a;
        if (view == null) {
            view = LayoutInflater.from(this.f56461a).inflate(R.layout.device_cjzc_item_action, (ViewGroup) null);
            view.setTag(Boolean.FALSE);
            c0665a = new C0665a();
            c0665a.f56465a = (TextView) view.findViewById(R.id.name);
            c0665a.f56466b = (ImageView) view.findViewById(R.id.image_action);
            c0665a.f56467c = (ImageView) view.findViewById(R.id.image_key);
            view.setTag(c0665a);
        } else {
            c0665a = (C0665a) view.getTag();
        }
        c0665a.f56465a.setText(this.f56462b.get(i10).c());
        c0665a.f56466b.setBackgroundResource(x6.a.b(this.f56462b.get(i10).b()));
        int i11 = this.f56464d;
        if (i11 == 0 || i11 == 2) {
            c0665a.f56467c.setImageResource(x6.a.g(this.f56462b.get(i10).d()));
        } else if (i11 == 1) {
            c0665a.f56467c.setImageResource(x6.a.h(this.f56462b.get(i10).d()));
        }
        return view;
    }
}
