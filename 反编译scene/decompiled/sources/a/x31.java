package a;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final dm f3524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jl f3525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f3526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewPager f3527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TabLayout f3528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<Fragment> f3529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3530a;
    public ArrayList<View> b;

    public x31(TabLayout tabLayout, ViewPager viewPager, Activity activity, jl jlVar, int i) {
        f92.d(tabLayout, "tabLayout");
        f92.d(viewPager, "viewPager");
        f92.d(activity, "activity");
        f92.d(jlVar, "supportFragmentManager");
        this.f3528a = tabLayout;
        this.f3527a = viewPager;
        this.f3526a = activity;
        this.f3525a = jlVar;
        this.f7851a = i;
        this.f3529a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.f3524a = new w31(this, this.f3525a);
        this.f3528a.setupWithViewPager(this.f3527a);
        this.f3528a.c(new v31(this));
    }

    public /* synthetic */ x31(TabLayout tabLayout, ViewPager viewPager, Activity activity, jl jlVar, int i, int i2, b92 b92Var) {
        this(tabLayout, viewPager, activity, jlVar, (i2 & 16) != 0 ? 2131558637 : i);
    }

    public final dm f() {
        return this.f3524a;
    }

    public final String g(String str, Drawable drawable, Fragment fragment) {
        f92.d(str, "text");
        f92.d(drawable, "drawable");
        f92.d(fragment, "fragment");
        View viewInflate = LayoutInflater.from(this.f3526a).inflate(this.f7851a, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(2131361811);
        TextView textView = (TextView) viewInflate.findViewById(2131361824);
        String str2 = "tab_" + this.b.size();
        f92.c(textView, "textView");
        textView.setText(str);
        if (this.b.size() != 0) {
            f92.c(viewInflate, "layout");
            viewInflate.setAlpha(0.3f);
        }
        imageView.setImageDrawable(drawable);
        this.b.add(viewInflate);
        this.f3529a.add(fragment);
        this.f3524a.i();
        this.f3530a = false;
        return str2;
    }

    public final void h() {
        View viewD;
        int selectedTabPosition = this.f3528a.getSelectedTabPosition();
        if (selectedTabPosition > -1) {
            int i = 0;
            int tabCount = this.f3528a.getTabCount();
            while (i < tabCount) {
                TabLayout.g gVarU = this.f3528a.u(i);
                if (gVarU != null && (viewD = gVarU.d()) != null) {
                    viewD.setAlpha(i == selectedTabPosition ? 1.0f : 0.3f);
                }
                i++;
            }
        }
    }
}
