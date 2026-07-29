package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class ListFragment extends Fragment {

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public static final int f5808n8 = 16711681;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public static final int f5809o8 = 16711682;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public static final int f5810p8 = 16711683;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public final Handler f5811c8 = new Handler();

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public final Runnable f5812d8 = new a();

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public final AdapterView.OnItemClickListener f5813e8 = new b();

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public ListAdapter f5814f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public ListView f5815g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public View f5816h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public TextView f5817i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public View f5818j8;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public View f5819k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public CharSequence f5820l8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public boolean f5821m8;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.f5815g8;
            listView.focusableViewAvailable(listView);
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            ListFragment.this.J5((ListView) adapterView, view, i10, j10);
        }
    }

    public final void E5() {
        if (this.f5815g8 != null) {
            return;
        }
        View viewK3 = k3();
        if (viewK3 == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (viewK3 instanceof ListView) {
            this.f5815g8 = (ListView) viewK3;
        } else {
            TextView textView = (TextView) viewK3.findViewById(f5808n8);
            this.f5817i8 = textView;
            if (textView == null) {
                this.f5816h8 = viewK3.findViewById(R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.f5818j8 = viewK3.findViewById(f5809o8);
            this.f5819k8 = viewK3.findViewById(f5810p8);
            View viewFindViewById = viewK3.findViewById(R.id.list);
            if (!(viewFindViewById instanceof ListView)) {
                if (viewFindViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            ListView listView = (ListView) viewFindViewById;
            this.f5815g8 = listView;
            View view = this.f5816h8;
            if (view != null) {
                listView.setEmptyView(view);
            } else {
                CharSequence charSequence = this.f5820l8;
                if (charSequence != null) {
                    this.f5817i8.setText(charSequence);
                    this.f5815g8.setEmptyView(this.f5817i8);
                }
            }
        }
        this.f5821m8 = true;
        this.f5815g8.setOnItemClickListener(this.f5813e8);
        ListAdapter listAdapter = this.f5814f8;
        if (listAdapter != null) {
            this.f5814f8 = null;
            M5(listAdapter);
        } else if (this.f5818j8 != null) {
            O5(false, false);
        }
        this.f5811c8.post(this.f5812d8);
    }

    @p0
    public ListAdapter F5() {
        return this.f5814f8;
    }

    @g.n0
    public ListView G5() {
        E5();
        return this.f5815g8;
    }

    public long H5() {
        E5();
        return this.f5815g8.getSelectedItemId();
    }

    public int I5() {
        E5();
        return this.f5815g8.getSelectedItemPosition();
    }

    public void J5(@g.n0 ListView listView, @g.n0 View view, int i10, long j10) {
    }

    @g.n0
    public final ListAdapter K5() {
        ListAdapter listAdapterF5 = F5();
        if (listAdapterF5 != null) {
            return listAdapterF5;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void L5(@p0 CharSequence charSequence) {
        E5();
        TextView textView = this.f5817i8;
        if (textView == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        textView.setText(charSequence);
        if (this.f5820l8 == null) {
            this.f5815g8.setEmptyView(this.f5817i8);
        }
        this.f5820l8 = charSequence;
    }

    public void M5(@p0 ListAdapter listAdapter) {
        boolean z10 = this.f5814f8 != null;
        this.f5814f8 = listAdapter;
        ListView listView = this.f5815g8;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.f5821m8 || z10) {
                return;
            }
            O5(true, V4().getWindowToken() != null);
        }
    }

    public void N5(boolean z10) {
        O5(z10, true);
    }

    @Override // androidx.fragment.app.Fragment
    @p0
    public View O3(@g.n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        Context contextR4 = R4();
        FrameLayout frameLayout = new FrameLayout(contextR4);
        LinearLayout linearLayout = new LinearLayout(contextR4);
        linearLayout.setId(f5809o8);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(contextR4, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(contextR4);
        frameLayout2.setId(f5810p8);
        TextView textView = new TextView(contextR4);
        textView.setId(f5808n8);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(contextR4);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public final void O5(boolean z10, boolean z11) {
        E5();
        View view = this.f5818j8;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.f5821m8 == z10) {
            return;
        }
        this.f5821m8 = z10;
        if (z10) {
            if (z11) {
                view.startAnimation(AnimationUtils.loadAnimation(X1(), R.anim.fade_out));
                this.f5819k8.startAnimation(AnimationUtils.loadAnimation(X1(), R.anim.fade_in));
            } else {
                view.clearAnimation();
                this.f5819k8.clearAnimation();
            }
            this.f5818j8.setVisibility(8);
            this.f5819k8.setVisibility(0);
            return;
        }
        if (z11) {
            view.startAnimation(AnimationUtils.loadAnimation(X1(), R.anim.fade_in));
            this.f5819k8.startAnimation(AnimationUtils.loadAnimation(X1(), R.anim.fade_out));
        } else {
            view.clearAnimation();
            this.f5819k8.clearAnimation();
        }
        this.f5818j8.setVisibility(0);
        this.f5819k8.setVisibility(8);
    }

    public void P5(boolean z10) {
        O5(z10, false);
    }

    public void Q5(int i10) {
        E5();
        this.f5815g8.setSelection(i10);
    }

    @Override // androidx.fragment.app.Fragment
    public void R3() {
        this.f5811c8.removeCallbacks(this.f5812d8);
        this.f5815g8 = null;
        this.f5821m8 = false;
        this.f5819k8 = null;
        this.f5818j8 = null;
        this.f5816h8 = null;
        this.f5817i8 = null;
        super.R3();
    }

    @Override // androidx.fragment.app.Fragment
    public void j4(@g.n0 View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        E5();
    }
}
