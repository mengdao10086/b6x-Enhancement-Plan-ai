package y7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.flydigi.float_view.R;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class c extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f56489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ListView f56490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f56491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f56492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f56493e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f56494f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f56495g = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f56496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f56497b;
    }

    public c(Context context, ListView listView, List<String> list, int i10) {
        this.f56489a = context;
        this.f56490b = listView;
        this.f56491c = list;
        this.f56492d = i10;
    }

    public void a(int i10) {
        int firstVisiblePosition = this.f56490b.getFirstVisiblePosition();
        int lastVisiblePosition = this.f56490b.getLastVisiblePosition();
        if (i10 < firstVisiblePosition || i10 > lastVisiblePosition) {
            return;
        }
        this.f56490b.getChildAt(i10 - firstVisiblePosition).findViewById(R.id.rl_child).setVisibility(8);
    }

    public void b(int i10) {
        int i11;
        int firstVisiblePosition = this.f56490b.getFirstVisiblePosition();
        int lastVisiblePosition = this.f56490b.getLastVisiblePosition();
        if (i10 < firstVisiblePosition || i10 > lastVisiblePosition || (i11 = i10 - firstVisiblePosition) >= this.f56490b.getCount()) {
            return;
        }
        this.f56490b.getChildAt(i11).findViewById(R.id.rl_child).setVisibility(0);
    }

    public void c(int i10) {
        int firstVisiblePosition = this.f56490b.getFirstVisiblePosition();
        int lastVisiblePosition = this.f56490b.getLastVisiblePosition();
        if (this.f56494f != null) {
            if (this.f56492d == 1) {
                this.f56493e.setBackgroundResource(R.color.lib_color_12);
            } else {
                this.f56493e.setBackgroundResource(R.color.lib_color_13);
            }
            this.f56494f.setVisibility(4);
            this.f56495g.setTextColor(this.f56489a.getResources().getColor(R.color.lib_color_10));
        }
        if (i10 < firstVisiblePosition || i10 > lastVisiblePosition) {
            return;
        }
        View childAt = this.f56490b.getChildAt(i10 - firstVisiblePosition);
        childAt.setBackgroundResource(R.color.lib_color_16);
        ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_img);
        imageView.setVisibility(0);
        TextView textView = (TextView) childAt.findViewById(R.id.tv_name);
        textView.setTextColor(this.f56489a.getResources().getColor(R.color.colorPrimary));
        if (this.f56492d == 1) {
            imageView.setBackgroundResource(R.drawable.float_view_icon_selected_green_empty);
        } else {
            imageView.setBackgroundResource(R.drawable.float_view_icon_selected_green_solid);
        }
        this.f56493e = childAt;
        this.f56495g = textView;
        this.f56494f = imageView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f56491c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f56491c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f56489a).inflate(R.layout.floatview_item_common_select_name, (ViewGroup) null);
            aVar = new a();
            aVar.f56496a = (ImageView) view.findViewById(R.id.iv_img);
            aVar.f56497b = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        try {
            aVar.f56497b.setText(this.f56491c.get(i10));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return view;
    }
}
