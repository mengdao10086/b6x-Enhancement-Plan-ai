package wh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.f;
import androidx.viewpager.widget.ViewPager;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.PreviewItemFragment;
import com.zhihu.matisse.internal.ui.widget.CheckRadioView;
import com.zhihu.matisse.internal.ui.widget.CheckView;
import com.zhihu.matisse.internal.ui.widget.IncapableDialog;
import g.p0;
import xh.c;
import zh.d;
import zh.e;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends f implements View.OnClickListener, ViewPager.j, ai.b {
    public static final String L7 = "extra_default_bundle";
    public static final String M7 = "extra_result_bundle";
    public static final String N7 = "extra_result_apply";
    public static final String O7 = "extra_result_original_enable";
    public static final String P7 = "checkState";
    public c C1;
    public TextView C2;
    public LinearLayout F7;
    public CheckRadioView G7;
    public boolean H7;
    public FrameLayout I7;
    public FrameLayout J7;
    public CheckView K1;
    public TextView K2;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public th.c f54701k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public ViewPager f54702v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public TextView f54703v2;
    public final vh.c K0 = new vh.c(this);
    public int E7 = -1;
    public boolean K7 = false;

    /* JADX INFO: renamed from: wh.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0638a implements View.OnClickListener {
        public ViewOnClickListenerC0638a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            Item itemE = aVar.C1.e(aVar.f54702v1.getCurrentItem());
            if (a.this.K0.l(itemE)) {
                a.this.K0.r(itemE);
                a aVar2 = a.this;
                if (aVar2.f54701k1.f51297f) {
                    aVar2.K1.setCheckedNum(Integer.MIN_VALUE);
                } else {
                    aVar2.K1.setChecked(false);
                }
            } else if (a.this.d4(itemE)) {
                a.this.K0.a(itemE);
                a aVar3 = a.this;
                if (aVar3.f54701k1.f51297f) {
                    aVar3.K1.setCheckedNum(aVar3.K0.e(itemE));
                } else {
                    aVar3.K1.setChecked(true);
                }
            }
            a.this.g4();
            a aVar4 = a.this;
            ai.c cVar = aVar4.f54701k1.f51309r;
            if (cVar != null) {
                cVar.a(aVar4.K0.d(), a.this.K0.c());
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iE4 = a.this.e4();
            if (iE4 > 0) {
                IncapableDialog.b6("", a.this.getString(R.string.error_over_original_count, new Object[]{Integer.valueOf(iE4), Integer.valueOf(a.this.f54701k1.f51312u)})).Z5(a.this.n3(), IncapableDialog.class.getName());
                return;
            }
            a aVar = a.this;
            aVar.H7 = true ^ aVar.H7;
            aVar.G7.setChecked(a.this.H7);
            a aVar2 = a.this;
            if (!aVar2.H7) {
                aVar2.G7.setColor(-1);
            }
            a aVar3 = a.this;
            ai.a aVar4 = aVar3.f54701k1.f51313v;
            if (aVar4 != null) {
                aVar4.onCheck(aVar3.H7);
            }
        }
    }

    @Override // ai.b
    public void J0() {
        if (this.f54701k1.f51311t) {
            if (this.K7) {
                this.J7.animate().setInterpolator(new l1.b()).translationYBy(this.J7.getMeasuredHeight()).start();
                this.I7.animate().translationYBy(-this.I7.getMeasuredHeight()).setInterpolator(new l1.b()).start();
            } else {
                this.J7.animate().setInterpolator(new l1.b()).translationYBy(-this.J7.getMeasuredHeight()).start();
                this.I7.animate().setInterpolator(new l1.b()).translationYBy(this.I7.getMeasuredHeight()).start();
            }
            this.K7 = !this.K7;
        }
    }

    public final boolean d4(Item item) {
        th.b bVarJ = this.K0.j(item);
        th.b.a(this, bVarJ);
        return bVarJ == null;
    }

    public final int e4() {
        int iF = this.K0.f();
        int i10 = 0;
        for (int i11 = 0; i11 < iF; i11++) {
            Item item = this.K0.b().get(i11);
            if (item.g() && d.e(item.f25100d) > this.f54701k1.f51312u) {
                i10++;
            }
        }
        return i10;
    }

    public void f4(boolean z10) {
        Intent intent = new Intent();
        intent.putExtra(M7, this.K0.i());
        intent.putExtra(N7, z10);
        intent.putExtra("extra_result_original_enable", this.H7);
        setResult(-1, intent);
    }

    public final void g4() {
        int iF = this.K0.f();
        if (iF == 0) {
            this.C2.setText(R.string.button_apply_default);
            this.C2.setEnabled(false);
        } else if (iF == 1 && this.f54701k1.h()) {
            this.C2.setText(R.string.button_apply_default);
            this.C2.setEnabled(true);
        } else {
            this.C2.setEnabled(true);
            this.C2.setText(getString(R.string.button_apply, new Object[]{Integer.valueOf(iF)}));
        }
        if (!this.f54701k1.f51310s) {
            this.F7.setVisibility(8);
        } else {
            this.F7.setVisibility(0);
            h4();
        }
    }

    public final void h4() {
        this.G7.setChecked(this.H7);
        if (!this.H7) {
            this.G7.setColor(-1);
        }
        if (e4() <= 0 || !this.H7) {
            return;
        }
        IncapableDialog.b6("", getString(R.string.error_over_original_size, new Object[]{Integer.valueOf(this.f54701k1.f51312u)})).Z5(n3(), IncapableDialog.class.getName());
        this.G7.setChecked(false);
        this.G7.setColor(-1);
        this.H7 = false;
    }

    public void i4(Item item) {
        if (item.e()) {
            this.K2.setVisibility(0);
            this.K2.setText(d.e(item.f25100d) + "M");
        } else {
            this.K2.setVisibility(8);
        }
        if (item.j()) {
            this.F7.setVisibility(8);
        } else if (this.f54701k1.f51310s) {
            this.F7.setVisibility(0);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        f4(false);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_back) {
            onBackPressed();
        } else if (view.getId() == R.id.button_apply) {
            f4(true);
            finish();
        }
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        setTheme(th.c.b().f51295d);
        super.onCreate(bundle);
        if (!th.c.b().f51308q) {
            setResult(0);
            finish();
            return;
        }
        setContentView(R.layout.activity_media_preview);
        if (e.b()) {
            getWindow().addFlags(67108864);
        }
        th.c cVarB = th.c.b();
        this.f54701k1 = cVarB;
        if (cVarB.c()) {
            setRequestedOrientation(this.f54701k1.f51296e);
        }
        if (bundle == null) {
            this.K0.n(getIntent().getBundleExtra(L7));
            this.H7 = getIntent().getBooleanExtra("extra_result_original_enable", false);
        } else {
            this.K0.n(bundle);
            this.H7 = bundle.getBoolean("checkState");
        }
        this.f54703v2 = (TextView) findViewById(R.id.button_back);
        this.C2 = (TextView) findViewById(R.id.button_apply);
        this.K2 = (TextView) findViewById(R.id.size);
        this.f54703v2.setOnClickListener(this);
        this.C2.setOnClickListener(this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        this.f54702v1 = viewPager;
        viewPager.e(this);
        c cVar = new c(n3(), null);
        this.C1 = cVar;
        this.f54702v1.setAdapter(cVar);
        CheckView checkView = (CheckView) findViewById(R.id.check_view);
        this.K1 = checkView;
        checkView.setCountable(this.f54701k1.f51297f);
        this.I7 = (FrameLayout) findViewById(R.id.bottom_toolbar);
        this.J7 = (FrameLayout) findViewById(R.id.top_toolbar);
        this.K1.setOnClickListener(new ViewOnClickListenerC0638a());
        this.F7 = (LinearLayout) findViewById(R.id.originalLayout);
        this.G7 = (CheckRadioView) findViewById(R.id.original);
        this.F7.setOnClickListener(new b());
        g4();
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrolled(int i10, float f10, int i11) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageSelected(int i10) {
        c cVar = (c) this.f54702v1.getAdapter();
        int i11 = this.E7;
        if (i11 != -1 && i11 != i10) {
            ((PreviewItemFragment) cVar.instantiateItem((ViewGroup) this.f54702v1, i11)).G5();
            Item itemE = cVar.e(i10);
            if (this.f54701k1.f51297f) {
                int iE = this.K0.e(itemE);
                this.K1.setCheckedNum(iE);
                if (iE > 0) {
                    this.K1.setEnabled(true);
                } else {
                    this.K1.setEnabled(true ^ this.K0.m());
                }
            } else {
                boolean zL = this.K0.l(itemE);
                this.K1.setChecked(zL);
                if (zL) {
                    this.K1.setEnabled(true);
                } else {
                    this.K1.setEnabled(true ^ this.K0.m());
                }
            }
            i4(itemE);
        }
        this.E7 = i10;
    }

    @Override // androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.K0.o(bundle);
        bundle.putBoolean("checkState", this.H7);
        super.onSaveInstanceState(bundle);
    }
}
