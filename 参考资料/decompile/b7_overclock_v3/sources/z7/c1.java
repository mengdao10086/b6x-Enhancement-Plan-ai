package z7;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blankj.utilcode.util.j1;
import com.flydigi.data.bean.GameStrategyBean;
import com.flydigi.float_view.R;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class c1 extends k2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<GameStrategyBean.CategoryBean> f57808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f57809b;

    public c1(Context context, List<GameStrategyBean.CategoryBean> list) {
        this.f57809b = context;
        this.f57808a = list;
    }

    @Override // k2.a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // k2.a
    public int getCount() {
        return this.f57808a.size();
    }

    @Override // k2.a
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        ImageView imageView = new ImageView(this.f57809b);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.bumptech.glide.b.E(j1.a()).Y(new com.bumptech.glide.request.h().f().E0(R.drawable.ic_place_holder_w2h1)).t(this.f57808a.get(i10).url).s1(imageView);
        viewGroup.addView(imageView);
        return imageView;
    }

    @Override // k2.a
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
