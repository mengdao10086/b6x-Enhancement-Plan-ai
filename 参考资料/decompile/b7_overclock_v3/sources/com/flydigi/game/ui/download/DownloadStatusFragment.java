package com.flydigi.game.ui.download;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.b1;
import com.flydigi.base.common.FZFragment;
import com.flydigi.game.R;
import com.flydigi.game.data.bean.DeviceSpaceBean;
import com.flydigi.game.ui.download.DownloadStatusFragment;
import dl.e;
import g.p0;
import il.d;
import net.lucode.hackware.magicindicator.MagicIndicator;
import o5.l;
import o5.n;
import xi.b0;
import xi.c0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class DownloadStatusFragment extends FZFragment {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public MagicIndicator f15846o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public ViewPager f15847p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public u8.a f15848q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public c f15849r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public ProgressBar f15850s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public TextView f15851t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public TextView f15852u8;

    public class a extends m5.a<DeviceSpaceBean> {
        public a() {
        }

        @Override // m5.a, xi.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(DeviceSpaceBean deviceSpaceBean) {
            super.onNext(deviceSpaceBean);
            DownloadStatusFragment.this.f15850s8.setProgress((int) (((r1 - deviceSpaceBean.usable) / deviceSpaceBean.total) * 100.0f));
            DownloadStatusFragment.this.f15851t8.setText(String.format(DownloadStatusFragment.this.c3(R.string.game_already_use), n.b(deviceSpaceBean.total - deviceSpaceBean.usable, true)));
            DownloadStatusFragment.this.f15852u8.setText(String.format(DownloadStatusFragment.this.c3(R.string.game_left), n.b(deviceSpaceBean.usable, true)));
        }
    }

    public class b extends il.a {

        public class a extends ll.b {
            public a(Context context) {
                super(context);
            }

            @Override // ll.b, ll.e, il.d
            public void a(int i10, int i11) {
                super.a(i10, i11);
                setTypeface(Typeface.defaultFromStyle(0));
            }

            @Override // ll.b, ll.e, il.d
            public void c(int i10, int i11) {
                super.c(i10, i11);
                setTypeface(Typeface.defaultFromStyle(1));
            }
        }

        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(int i10, View view) {
            DownloadStatusFragment.this.f15847p8.setCurrentItem(i10);
        }

        @Override // il.a
        public int a() {
            return DownloadStatusFragment.this.f15848q8.getCount();
        }

        @Override // il.a
        public il.c b(Context context) {
            jl.b bVar = new jl.b(context);
            bVar.setMode(0);
            bVar.setColors(Integer.valueOf(DownloadStatusFragment.this.V2().getColor(R.color.colorPrimary)));
            bVar.setLineHeight(b1.b(2.0f));
            return bVar;
        }

        @Override // il.a
        public d c(Context context, final int i10) {
            a aVar = new a(DownloadStatusFragment.this.H1());
            aVar.setSelectedColor(DownloadStatusFragment.this.V2().getColor(R.color.colorPrimary));
            aVar.setNormalColor(DownloadStatusFragment.this.V2().getColor(R.color.colorTextPrimary));
            aVar.setTextSize(14.0f);
            aVar.setText(DownloadStatusFragment.this.f15848q8.getPageTitle(i10));
            aVar.setOnClickListener(new View.OnClickListener() { // from class: t8.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f50922a.j(i10, view);
                }
            });
            return aVar;
        }
    }

    public interface c {
        void x1();
    }

    public static /* synthetic */ void g6(b0 b0Var) throws Exception {
        b0Var.onNext(new DeviceSpaceBean(Environment.getExternalStorageDirectory().getTotalSpace(), Environment.getExternalStorageDirectory().getUsableSpace()));
    }

    public static DownloadStatusFragment h6() {
        return new DownloadStatusFragment();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@k Context context) {
        super.H3(context);
        this.f15849r8 = (c) context;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.game_fragment_download;
    }

    @Override // androidx.fragment.app.Fragment
    public void N3(Menu menu, MenuInflater menuInflater) {
        super.N3(menu, menuInflater);
        menuInflater.inflate(R.menu.main_download_status_menu, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean Y3(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            I5();
        }
        if (itemId != R.id.menu_download_manager) {
            return true;
        }
        DownloadSettingActivity.j4(this.f13317d8);
        return true;
    }

    public final void f6() {
        this.f13321h8.setText(R.string.game_download_manager);
        z.r1(new c0() { // from class: t8.b
            @Override // xi.c0
            public final void a(b0 b0Var) throws Exception {
                DownloadStatusFragment.g6(b0Var);
            }
        }).s0(m5.c0.t()).s0(l.d()).c(new a());
        this.f15847p8.setOffscreenPageLimit(3);
        u8.a aVar = new u8.a(H1(), U1());
        this.f15848q8 = aVar;
        this.f15847p8.setAdapter(aVar);
        hl.a aVar2 = new hl.a(H1());
        aVar2.setAdjustMode(true);
        aVar2.setAdapter(new b());
        this.f15846o8.setNavigator(aVar2);
        e.a(this.f15846o8, this.f15847p8);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        J5(view);
        this.f15846o8 = (MagicIndicator) F5(R.id.magic_indicator);
        this.f15847p8 = (ViewPager) F5(R.id.vp_download);
        this.f15850s8 = (ProgressBar) F5(R.id.pb_storage);
        this.f15851t8 = (TextView) F5(R.id.tv_storage_used);
        this.f15852u8 = (TextView) F5(R.id.tv_storage_free);
        f6();
    }
}
