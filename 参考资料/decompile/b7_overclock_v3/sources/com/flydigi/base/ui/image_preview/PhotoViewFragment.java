package com.flydigi.base.ui.image_preview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.bumptech.glide.h;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.g;
import com.flydigi.base.R;
import com.flydigi.base.common.FZLazyFragment;
import com.github.chrisbanes.photoview.PhotoView;
import g.p0;
import s4.p;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoViewFragment extends FZLazyFragment {

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public static final String f13391s8 = "url";

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public PhotoView f13392p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public ProgressBar f13393q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public String f13394r8;

    public class a implements g<Drawable> {
        public a() {
        }

        @Override // com.bumptech.glide.request.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean e(Drawable drawable, Object obj, p<Drawable> pVar, DataSource dataSource, boolean z10) {
            PhotoViewFragment.this.c6();
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean d(@p0 GlideException glideException, Object obj, p<Drawable> pVar, boolean z10) {
            PhotoViewFragment.this.c6();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d6(View view) {
        this.f13317d8.finish();
    }

    public static PhotoViewFragment e6(String str) {
        PhotoViewFragment photoViewFragment = new PhotoViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        photoViewFragment.c5(bundle);
        return photoViewFragment;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        if (T1() != null) {
            this.f13394r8 = T1().getString("url");
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.main_layout_fragment_image_view;
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        h<Drawable> hVarT = com.bumptech.glide.b.G(this).t(this.f13394r8);
        int i10 = R.drawable.ic_place_holder_w2h1;
        hVarT.E0(i10).x(i10).u1(new a()).s1(this.f13392p8);
    }

    public final void c6() {
        this.f13393q8.setVisibility(8);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.f13392p8 = (PhotoView) F5(R.id.photo_view);
        this.f13393q8 = (ProgressBar) F5(R.id.pb_loading);
        this.f13392p8.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.base.ui.image_preview.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13407a.d6(view2);
            }
        });
    }
}
