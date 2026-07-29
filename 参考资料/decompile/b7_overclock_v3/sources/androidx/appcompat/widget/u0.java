package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;

/* JADX INFO: loaded from: classes2.dex */
public interface u0 extends SpinnerAdapter {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f2713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LayoutInflater f2714c;

        public a(@g.n0 Context context) {
            this.f2712a = context;
            this.f2713b = LayoutInflater.from(context);
        }

        @g.n0
        public LayoutInflater a() {
            LayoutInflater layoutInflater = this.f2714c;
            return layoutInflater != null ? layoutInflater : this.f2713b;
        }

        @g.p0
        public Resources.Theme b() {
            LayoutInflater layoutInflater = this.f2714c;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void c(@g.p0 Resources.Theme theme) {
            if (theme == null) {
                this.f2714c = null;
            } else if (theme == this.f2712a.getTheme()) {
                this.f2714c = this.f2713b;
            } else {
                this.f2714c = LayoutInflater.from(new l.d(this.f2712a, theme));
            }
        }
    }

    @g.p0
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@g.p0 Resources.Theme theme);
}
