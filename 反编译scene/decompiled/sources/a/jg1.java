package a;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import com.omarea.ui.BlurViewLinearLayout;
import com.omarea.ui.ZRamStateView;
import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jg1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ k92 f1534a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s21 f1535a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivitySwap.a f1536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1537a;
    public final /* synthetic */ int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ k92 f1538b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ String f1539b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f1540b;
    public final /* synthetic */ k92 c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final /* synthetic */ String f1541c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final /* synthetic */ boolean f1542c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public jg1(ActivitySwap.a aVar, int i, k92 k92Var, k92 k92Var2, int i2, k92 k92Var3, String str, String str2, s21 s21Var, String str3, String str4, boolean z, boolean z2, String str5, String str6, String str7) {
        this.f1536a = aVar;
        this.f6507a = i;
        this.f1534a = k92Var;
        this.f1538b = k92Var2;
        this.b = i2;
        this.c = k92Var3;
        this.f1537a = str;
        this.f1539b = str2;
        this.f1535a = s21Var;
        this.f1541c = str3;
        this.d = str4;
        this.f1540b = z;
        this.f1542c = z2;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        String string;
        TextView textView2;
        String string2;
        TextView textView3;
        String string3;
        try {
            TextView textView4 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.txt_swap_size_display);
            f92.c(textView4, "txt_swap_size_display");
            textView4.setText(String.valueOf(this.f6507a) + "MB");
            ((ZRamStateView) ActivitySwap.this._$_findCachedViewById(t61.swap_usage)).d(this.f1534a.f6587a, this.f1538b.f6587a);
            ((ZRamStateView) ActivitySwap.this._$_findCachedViewById(t61.zram_usage)).d((float) this.b, this.c.f6587a);
            float f = 0;
            if (this.f1534a.f6587a > f) {
                TextView textView5 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.swap_usage_ratio);
                f92.c(textView5, "swap_usage_ratio");
                textView5.setText(String.valueOf(100 - ((int) ((this.f1538b.f6587a * 100) / this.f1534a.f6587a))) + "%");
            } else {
                TextView textView6 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.swap_usage_ratio);
                f92.c(textView6, "swap_usage_ratio");
                textView6.setText("0%");
            }
            if (this.b <= 0 || this.c.f6587a <= f) {
                TextView textView7 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.zram_usage_ratio);
                f92.c(textView7, "zram_usage_ratio");
                textView7.setText("0%");
            } else {
                TextView textView8 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.zram_usage_ratio);
                f92.c(textView8, "zram_usage_ratio");
                textView8.setText(String.valueOf(100 - ((int) ((this.c.f6587a * 100) / this.b))) + "%");
            }
            if (ActivitySwap.this.f5510a.j()) {
                TextView textView9 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.zram_stat_title);
                f92.c(textView9, "zram_stat_title");
                textView9.setText(ActivitySwap.this.getString(u61.swao_memcompress_stat));
                TextView textView10 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.zram_stat_desc);
                f92.c(textView10, "zram_stat_desc");
                textView10.setVisibility(8);
            }
            TextView textView11 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.swap_swappiness_display);
            f92.c(textView11, "swap_swappiness_display");
            textView11.setText(this.f1537a);
            TextView textView12 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.watermark_scale_factor_display);
            f92.c(textView12, "watermark_scale_factor_display");
            textView12.setText(this.f1539b);
            ListView listView = (ListView) ActivitySwap.this._$_findCachedViewById(t61.list_swaps);
            f92.c(listView, "list_swaps");
            listView.setAdapter((ListAdapter) this.f1535a);
            TextView textView13 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.txt_mem);
            f92.c(textView13, "txt_mem");
            textView13.setText(this.f1541c);
            if (this.d.length() > 0) {
                Button button = (Button) ActivitySwap.this._$_findCachedViewById(t61.btn_swap_close);
                f92.c(button, "btn_swap_close");
                button.setVisibility(0);
                Button button2 = (Button) ActivitySwap.this._$_findCachedViewById(t61.btn_swap_create);
                f92.c(button2, "btn_swap_create");
                button2.setVisibility(8);
                textView = (TextView) ActivitySwap.this._$_findCachedViewById(t61.swap_state);
                f92.c(textView, "swap_state");
                string = ActivitySwap.this.getString(u61.swap_state_using);
            } else {
                Button button3 = (Button) ActivitySwap.this._$_findCachedViewById(t61.btn_swap_close);
                f92.c(button3, "btn_swap_close");
                button3.setVisibility(8);
                Button button4 = (Button) ActivitySwap.this._$_findCachedViewById(t61.btn_swap_create);
                f92.c(button4, "btn_swap_create");
                button4.setVisibility(0);
                if (this.f1540b) {
                    textView = (TextView) ActivitySwap.this._$_findCachedViewById(t61.swap_state);
                    f92.c(textView, "swap_state");
                    string = ActivitySwap.this.getString(u61.swap_state_created);
                } else {
                    textView = (TextView) ActivitySwap.this._$_findCachedViewById(t61.swap_state);
                    f92.c(textView, "swap_state");
                    string = ActivitySwap.this.getString(u61.swap_state_undefined);
                }
            }
            textView.setText(string);
            if (this.f1542c) {
                textView2 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.zram_state);
                f92.c(textView2, "zram_state");
                string2 = ActivitySwap.this.getString(u61.swap_state_using);
            } else {
                textView2 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.zram_state);
                f92.c(textView2, "zram_state");
                string2 = ActivitySwap.this.getString(u61.swap_state_created);
            }
            textView2.setText(string2);
            Switch r1 = (Switch) ActivitySwap.this._$_findCachedViewById(t61.swap_auto_lmk);
            f92.c(r1, "swap_auto_lmk");
            r1.setChecked(ActivitySwap.l(ActivitySwap.this).getBoolean(hz0.f1282a.q0(), false));
            sl0 sl0Var = new sl0();
            if (!sl0Var.c() || ActivitySwap.this.f5513a.b()) {
                BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) ActivitySwap.this._$_findCachedViewById(t61.swap_auto_lmk_wrap);
                f92.c(blurViewLinearLayout, "swap_auto_lmk_wrap");
                blurViewLinearLayout.setVisibility(8);
            } else {
                TextView textView14 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.swap_lmk_current);
                f92.c(textView14, "swap_lmk_current");
                textView14.setText(sl0Var.b());
                BlurViewLinearLayout blurViewLinearLayout2 = (BlurViewLinearLayout) ActivitySwap.this._$_findCachedViewById(t61.swap_auto_lmk_wrap);
                f92.c(blurViewLinearLayout2, "swap_auto_lmk_wrap");
                blurViewLinearLayout2.setVisibility(0);
            }
            LinearLayout linearLayout = (LinearLayout) ActivitySwap.this._$_findCachedViewById(t61.extra_free_view);
            f92.c(linearLayout, "extra_free_view");
            linearLayout.setVisibility(y60.f7952a.d("/proc/sys/vm/extra_free_kbytes") ? 0 : 8);
            TextView textView15 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.extra_free_kbytes_display);
            f92.c(textView15, "extra_free_kbytes_display");
            textView15.setText(this.e);
            TextView textView16 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.zram0_stat);
            f92.c(textView16, "zram0_stat");
            textView16.setText(this.f);
            TextView textView17 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.txt_swap_io);
            f92.c(textView17, "txt_swap_io");
            textView17.setText(ActivitySwap.this.D());
            TextView textView18 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.txt_zram_size_display);
            f92.c(textView18, "txt_zram_size_display");
            textView18.setText(this.b + "MB");
            TextView textView19 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.zram_compact_algorithm);
            f92.c(textView19, "zram_compact_algorithm");
            textView19.setText(this.g);
            if (this.d.length() > 0) {
                textView3 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.txt_swap_auto_start);
                f92.c(textView3, "txt_swap_auto_start");
                string3 = ActivitySwap.l(ActivitySwap.this).getBoolean(hz0.f1282a.s0(), false) ? ActivitySwap.this.getString(u61.swap_restart_retain) : ActivitySwap.this.getString(u61.swap_restart_restore);
            } else {
                textView3 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.txt_swap_auto_start);
                f92.c(textView3, "txt_swap_auto_start");
                string3 = "--";
            }
            textView3.setText(string3);
            TextView textView20 = (TextView) ActivitySwap.this._$_findCachedViewById(t61.txt_zram_auto_start);
            f92.c(textView20, "txt_zram_auto_start");
            textView20.setText(ActivitySwap.l(ActivitySwap.this).getBoolean(hz0.f1282a.y0(), false) ? ActivitySwap.this.getString(u61.swap_restart_retain) : ActivitySwap.this.getString(u61.swap_restart_restore));
        } catch (Exception unused) {
        }
    }
}
