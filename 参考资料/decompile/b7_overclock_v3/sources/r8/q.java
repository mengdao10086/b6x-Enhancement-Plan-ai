package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.flydigi.base.widget.ExpandableTextView;
import com.flydigi.game.R;
import com.flydigi.game.widget.DownloadStatusButton;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class q implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final DownloadStatusButton f47822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ExpandableTextView f47823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ImageButton f47824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ImageView f47825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final LinearLayout f47826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final ProgressBar f47827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final LinearLayout f47828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final TextView f47829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final TextView f47830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final TextView f47831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final TextView f47832l;

    public q(@n0 LinearLayout linearLayout, @n0 DownloadStatusButton downloadStatusButton, @n0 ExpandableTextView expandableTextView, @n0 ImageButton imageButton, @n0 ImageView imageView, @n0 LinearLayout linearLayout2, @n0 ProgressBar progressBar, @n0 LinearLayout linearLayout3, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4) {
        this.f47821a = linearLayout;
        this.f47822b = downloadStatusButton;
        this.f47823c = expandableTextView;
        this.f47824d = imageButton;
        this.f47825e = imageView;
        this.f47826f = linearLayout2;
        this.f47827g = progressBar;
        this.f47828h = linearLayout3;
        this.f47829i = textView;
        this.f47830j = textView2;
        this.f47831k = textView3;
        this.f47832l = textView4;
    }

    @n0
    public static q a(@n0 View view) {
        int i10 = R.id.download_status_btn;
        DownloadStatusButton downloadStatusButton = (DownloadStatusButton) j2.c.a(view, i10);
        if (downloadStatusButton != null) {
            i10 = R.id.expandable_text_view;
            ExpandableTextView expandableTextView = (ExpandableTextView) j2.c.a(view, i10);
            if (expandableTextView != null) {
                i10 = R.id.ib_delete_or_more;
                ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
                if (imageButton != null) {
                    i10 = R.id.iv_icon;
                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                    if (imageView != null) {
                        i10 = R.id.ll_game_status;
                        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.pb_download;
                            ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
                            if (progressBar != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view;
                                i10 = R.id.tv_name;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_size_ratio;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_speed;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.tv_update_time_or_size;
                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                            if (textView4 != null) {
                                                return new q(linearLayout2, downloadStatusButton, expandableTextView, imageButton, imageView, linearLayout, progressBar, linearLayout2, textView, textView2, textView3, textView4);
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
    public static q c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static q d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_view_download_game_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47821a;
    }
}
