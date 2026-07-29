package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f30584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f30585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ConstraintLayout f30586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ListView f30587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ImageView f30588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f30589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final ProgressBar f30590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f30591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final Button f30592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final TextView f30593j;

    public g(@n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 ConstraintLayout constraintLayout, @n0 ListView listView, @n0 ImageView imageView, @n0 TextView textView, @n0 ProgressBar progressBar, @n0 TextView textView2, @n0 Button button, @n0 TextView textView3) {
        this.f30584a = linearLayout;
        this.f30585b = linearLayout2;
        this.f30586c = constraintLayout;
        this.f30587d = listView;
        this.f30588e = imageView;
        this.f30589f = textView;
        this.f30590g = progressBar;
        this.f30591h = textView2;
        this.f30592i = button;
        this.f30593j = textView3;
    }

    @n0
    public static g a(@n0 View view) {
        int i10 = R.id.area_device;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_progress;
            ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
            if (constraintLayout != null) {
                i10 = R.id.devices;
                ListView listView = (ListView) j2.c.a(view, i10);
                if (listView != null) {
                    i10 = R.id.iv_upgrade_progress;
                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                    if (imageView != null) {
                        i10 = R.id.ota_info_list;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.ota_progress;
                            ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
                            if (progressBar != null) {
                                i10 = R.id.ota_status;
                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                if (textView2 != null) {
                                    i10 = R.id.start_ota;
                                    Button button = (Button) j2.c.a(view, i10);
                                    if (button != null) {
                                        i10 = R.id.tv_upgrade_message;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            return new g((LinearLayout) view, linearLayout, constraintLayout, listView, imageView, textView, progressBar, textView2, button, textView3);
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
    public static g c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static g d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.cf_activity_upgrade_firmware, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f30584a;
    }
}
