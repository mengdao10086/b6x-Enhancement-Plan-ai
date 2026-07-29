package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.flydigi.base.widget.ratingbar.CBRatingBar;
import com.flydigi.game.R;
import com.flydigi.game.widget.DownloadStatusButton;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class v implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final CBRatingBar f47842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final DownloadStatusButton f47843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ImageView f47844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final LinearLayout f47845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final LinearLayout f47846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final ProgressBar f47847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final LinearLayout f47848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final TextView f47849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final TextView f47850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final TextView f47851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final TextView f47852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final TextView f47853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final TextView f47854n;

    public v(@n0 LinearLayout linearLayout, @n0 CBRatingBar cBRatingBar, @n0 DownloadStatusButton downloadStatusButton, @n0 ImageView imageView, @n0 LinearLayout linearLayout2, @n0 LinearLayout linearLayout3, @n0 ProgressBar progressBar, @n0 LinearLayout linearLayout4, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4, @n0 TextView textView5, @n0 TextView textView6) {
        this.f47841a = linearLayout;
        this.f47842b = cBRatingBar;
        this.f47843c = downloadStatusButton;
        this.f47844d = imageView;
        this.f47845e = linearLayout2;
        this.f47846f = linearLayout3;
        this.f47847g = progressBar;
        this.f47848h = linearLayout4;
        this.f47849i = textView;
        this.f47850j = textView2;
        this.f47851k = textView3;
        this.f47852l = textView4;
        this.f47853m = textView5;
        this.f47854n = textView6;
    }

    @n0
    public static v a(@n0 View view) {
        int i10 = R.id.cb_score;
        CBRatingBar cBRatingBar = (CBRatingBar) j2.c.a(view, i10);
        if (cBRatingBar != null) {
            i10 = R.id.download_status_btn;
            DownloadStatusButton downloadStatusButton = (DownloadStatusButton) j2.c.a(view, i10);
            if (downloadStatusButton != null) {
                i10 = R.id.iv_icon;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.ll_game_info;
                    LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.ll_game_status;
                        LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R.id.pb_download;
                            ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
                            if (progressBar != null) {
                                LinearLayout linearLayout3 = (LinearLayout) view;
                                i10 = R.id.tv_info;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_name;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_score;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.tv_size;
                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                            if (textView4 != null) {
                                                i10 = R.id.tv_size_ratio;
                                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                                if (textView5 != null) {
                                                    i10 = R.id.tv_speed;
                                                    TextView textView6 = (TextView) j2.c.a(view, i10);
                                                    if (textView6 != null) {
                                                        return new v(linearLayout3, cBRatingBar, downloadStatusButton, imageView, linearLayout, linearLayout2, progressBar, linearLayout3, textView, textView2, textView3, textView4, textView5, textView6);
                                                    }
                                                }
                                            }
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

    @n0
    public static v c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static v d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_view_game_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47841a;
    }
}
