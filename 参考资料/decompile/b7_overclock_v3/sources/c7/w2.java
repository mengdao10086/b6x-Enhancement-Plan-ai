package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class w2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final View f10544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f10545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10546c;

    public w2(@g.n0 View view, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f10544a = view;
        this.f10545b = textView;
        this.f10546c = textView2;
    }

    @g.n0
    public static w2 a(@g.n0 View view) {
        int i10 = R.id.tv_freq;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.tv_time;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                return new w2(view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static w2 b(@g.n0 LayoutInflater layoutInflater, @g.n0 ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, androidx.constraintlayout.widget.d.V1);
        layoutInflater.inflate(R.layout.device_view_stinger_test, viewGroup);
        return a(viewGroup);
    }

    @Override // j2.b
    @g.n0
    public View getRoot() {
        return this.f10544a;
    }
}
