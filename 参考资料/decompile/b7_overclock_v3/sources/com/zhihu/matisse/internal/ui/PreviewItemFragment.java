package com.zhihu.matisse.internal.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Item;
import g.p0;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;
import th.c;
import zh.d;

/* JADX INFO: loaded from: classes5.dex */
public class PreviewItemFragment extends Fragment {

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public static final String f25109d8 = "args_item";

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public ai.b f25110c8;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Item f25111a;

        public a(Item item) {
            this.f25111a = item;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(this.f25111a.f25099c, "video/*");
            try {
                PreviewItemFragment.this.x5(intent);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(PreviewItemFragment.this.X1(), R.string.error_no_video_activity, 0).show();
            }
        }
    }

    public class b implements ImageViewTouch.c {
        public b() {
        }

        @Override // it.sephiroth.android.library.imagezoom.ImageViewTouch.c
        public void a() {
            if (PreviewItemFragment.this.f25110c8 != null) {
                PreviewItemFragment.this.f25110c8.J0();
            }
        }
    }

    public static PreviewItemFragment F5(Item item) {
        PreviewItemFragment previewItemFragment = new PreviewItemFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(f25109d8, item);
        previewItemFragment.c5(bundle);
        return previewItemFragment;
    }

    public void G5() {
        if (k3() != null) {
            ((ImageViewTouch) k3().findViewById(R.id.image_view)).A();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void H3(Context context) {
        super.H3(context);
        if (context instanceof ai.b) {
            this.f25110c8 = (ai.b) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }

    @Override // androidx.fragment.app.Fragment
    public View O3(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_preview_item, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void S3() {
        super.S3();
        this.f25110c8 = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void j4(View view, @p0 Bundle bundle) throws Throwable {
        super.j4(view, bundle);
        Item item = (Item) T1().getParcelable(f25109d8);
        if (item == null) {
            return;
        }
        View viewFindViewById = view.findViewById(R.id.video_play_button);
        if (item.j()) {
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new a(item));
        } else {
            viewFindViewById.setVisibility(8);
        }
        ImageViewTouch imageViewTouch = (ImageViewTouch) view.findViewById(R.id.image_view);
        imageViewTouch.setDisplayType(ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        imageViewTouch.setSingleTapListener(new b());
        Point pointB = d.b(item.a(), w1());
        if (item.e()) {
            c.b().f51307p.c(X1(), pointB.x, pointB.y, imageViewTouch, item.a());
        } else {
            c.b().f51307p.a(X1(), pointB.x, pointB.y, imageViewTouch, item.a());
        }
    }
}
