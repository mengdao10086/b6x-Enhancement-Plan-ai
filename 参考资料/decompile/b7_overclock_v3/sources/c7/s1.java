package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import com.guanaj.easyswipemenulibrary.EasySwipeMenuLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class s1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f10447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final EasySwipeMenuLayout f10449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageButton f10450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f10451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ImageButton f10452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ImageButton f10453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10455j;

    public s1(@g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView, @g.n0 LinearLayout linearLayout2, @g.n0 EasySwipeMenuLayout easySwipeMenuLayout, @g.n0 ImageButton imageButton, @g.n0 ImageView imageView2, @g.n0 ImageButton imageButton2, @g.n0 ImageButton imageButton3, @g.n0 LinearLayout linearLayout3, @g.n0 TextView textView) {
        this.f10446a = linearLayout;
        this.f10447b = imageView;
        this.f10448c = linearLayout2;
        this.f10449d = easySwipeMenuLayout;
        this.f10450e = imageButton;
        this.f10451f = imageView2;
        this.f10452g = imageButton2;
        this.f10453h = imageButton3;
        this.f10454i = linearLayout3;
        this.f10455j = textView;
    }

    @g.n0
    public static s1 a(@g.n0 View view) {
        int i10 = R.id.cb_select;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.content;
            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout != null) {
                i10 = R.id.easy_swipe_menu;
                EasySwipeMenuLayout easySwipeMenuLayout = (EasySwipeMenuLayout) j2.c.a(view, i10);
                if (easySwipeMenuLayout != null) {
                    i10 = R.id.iv_delete;
                    ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
                    if (imageButton != null) {
                        i10 = R.id.iv_device_type;
                        ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                        if (imageView2 != null) {
                            i10 = R.id.iv_rename;
                            ImageButton imageButton2 = (ImageButton) j2.c.a(view, i10);
                            if (imageButton2 != null) {
                                i10 = R.id.iv_upload_download;
                                ImageButton imageButton3 = (ImageButton) j2.c.a(view, i10);
                                if (imageButton3 != null) {
                                    i10 = R.id.right;
                                    LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                                    if (linearLayout2 != null) {
                                        i10 = R.id.tv_name;
                                        TextView textView = (TextView) j2.c.a(view, i10);
                                        if (textView != null) {
                                            return new s1((LinearLayout) view, imageView, linearLayout, easySwipeMenuLayout, imageButton, imageView2, imageButton2, imageButton3, linearLayout2, textView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static s1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static s1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_item_config_sync_game_config, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10446a;
    }
}
