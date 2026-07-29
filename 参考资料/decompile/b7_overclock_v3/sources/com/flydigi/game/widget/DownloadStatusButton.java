package com.flydigi.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.flydigi.base.common.i;
import com.flydigi.game.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public class DownloadStatusButton extends i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f15944f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f15945g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f15946h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f15947i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f15948j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f15949k = 6;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f15950l = 7;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f15951m = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f15953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f15954e;

    public interface a {
        void a();

        void b();

        void c();

        void open();

        void order();

        void pause();

        void resume();
    }

    public DownloadStatusButton(@n0 Context context) {
        super(context);
        this.f15952c = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        a aVar = this.f15954e;
        if (aVar != null) {
            switch (this.f15952c) {
                case 1:
                    aVar.b();
                    break;
                case 2:
                    aVar.pause();
                    setStatus(6);
                    break;
                case 3:
                    aVar.open();
                    break;
                case 4:
                    this.f15953d.setText(R.string.game_installing);
                    this.f15954e.c();
                    break;
                case 5:
                    aVar.a();
                    break;
                case 6:
                    aVar.resume();
                    break;
                case 7:
                    aVar.order();
                    break;
            }
        }
    }

    @Override // com.flydigi.base.common.i
    public void f(AttributeSet attributeSet) {
        TextView textView = (TextView) findViewById(R.id.tv_status);
        this.f15953d = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: z8.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57926a.j(view);
            }
        });
        setStatus(this.f15952c);
    }

    @Override // com.flydigi.base.common.i
    public int getLayoutId() {
        return R.layout.game_view_download_status;
    }

    public void setOnOperateListener(a aVar) {
        this.f15954e = aVar;
    }

    public void setStatus(int i10) {
        int i11 = R.string.download;
        int i12 = R.color.colorPrimary;
        int i13 = R.drawable.main_down_status_stroke;
        switch (i10) {
            case 2:
                i11 = R.string.pause;
                break;
            case 3:
                i11 = R.string.open;
                i12 = R.color.white;
                i13 = R.drawable.main_down_status_solid;
                break;
            case 4:
                i11 = R.string.install;
                break;
            case 5:
                i11 = R.string.update;
                break;
            case 6:
                i11 = R.string.continue_;
                break;
            case 7:
                i11 = R.string.game_order;
                i12 = R.color.white;
                i13 = R.drawable.main_down_status_solid;
                break;
            case 8:
                i11 = R.string.game_ordered;
                i12 = R.color.color_000000_a10;
                i13 = R.drawable.game_bg_game_action_disabled;
                break;
        }
        setEnabled(i10 != 8);
        this.f15952c = i10;
        TextView textView = this.f15953d;
        if (textView != null) {
            textView.setText(i11);
            this.f15953d.setTextColor(getResources().getColor(i12));
            this.f15953d.setBackgroundResource(i13);
        }
    }

    public DownloadStatusButton(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15952c = 1;
    }

    public DownloadStatusButton(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f15952c = 1;
    }
}
