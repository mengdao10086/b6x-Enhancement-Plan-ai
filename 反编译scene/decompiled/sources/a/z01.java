package a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.omarea.model.CpuCoreInfo;
import com.omarea.ui.CpuChartBarView;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class z01 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<CpuCoreInfo> f3784a;

    public z01(Context context, ArrayList<CpuCoreInfo> arrayList) {
        f92.d(context, "context");
        this.f3783a = context;
        this.f3784a = arrayList;
        this.f8023a = f92.a(e50.f677a.y0(), "basic") ? 2131558627 : 2131558626;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CpuCoreInfo getItem(int i) {
        ArrayList<CpuCoreInfo> arrayList = this.f3784a;
        f92.b(arrayList);
        CpuCoreInfo cpuCoreInfo = arrayList.get(i);
        f92.c(cpuCoreInfo, "list!![position]");
        return cpuCoreInfo;
    }

    public final z01 b(ArrayList<CpuCoreInfo> arrayList) {
        f92.d(arrayList, "list");
        ArrayList<CpuCoreInfo> arrayList2 = this.f3784a;
        f92.b(arrayList2);
        arrayList2.clear();
        this.f3784a.addAll(arrayList);
        notifyDataSetChanged();
        return this;
    }

    public final String c(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 3) {
            return str.length() == 0 ? "0" : str;
        }
        String strSubstring = str.substring(0, str.length() - 3);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<CpuCoreInfo> arrayList = this.f3784a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) throws InterruptedException {
        String str;
        f92.d(viewGroup, "parent");
        if (view == null) {
            view = View.inflate(this.f3783a, this.f8023a, null);
            f92.c(view, "View.inflate(context, layoutId, null)");
        }
        CpuCoreInfo item = getItem(i);
        TextView textView = (TextView) view.findViewById(t61.cpu_core_index);
        if (textView != null) {
            textView.setText("CPU" + (i + 1));
        }
        CpuChartBarView cpuChartBarView = (CpuChartBarView) view.findViewById(t61.core_cpu_loading_chart);
        if (cpuChartBarView != null) {
            cpuChartBarView.a(100.0f, (100 - ((float) item.loadRatio)) + 0.5f);
            cpuChartBarView.invalidate();
        }
        TextView textView2 = (TextView) view.findViewById(t61.cpu_core_load);
        if (textView2 != null) {
            textView2.setText(String.valueOf((int) item.loadRatio) + "%");
        }
        TextView textView3 = (TextView) view.findViewById(t61.cpu_core_current_freq);
        if (textView3 != null) {
            String strC = c(item.currentFreq);
            if (f92.a(strC, "0")) {
                str = "离线";
            } else {
                str = strC + "MHz";
            }
            textView3.setText(str);
        }
        ((TextView) view.findViewById(t61.cpu_core_freq_ranage)).setText(c(item.minFreq) + "~" + c(item.maxFreq) + "MHz");
        return view;
    }
}
