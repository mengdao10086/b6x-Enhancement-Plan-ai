package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.model.PowerStatAVG;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t51 extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ih0 f2963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f2964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f2965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<? extends PowerStatAVG> f2966a;
    public final List<PowerStatAVG> b;
    public boolean c;
    public boolean d;

    public final class a extends RecyclerView.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f7469a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TextView f2967a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f2968a;
        public View b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public TextView f2969b;
        public TextView c;
        public TextView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t51 t51Var, View view) {
            super(view);
            f92.d(view, "view");
        }

        public final TextView M() {
            TextView textView = this.f2969b;
            if (textView != null) {
                return textView;
            }
            f92.m("itemAvg");
            throw null;
        }

        public final ImageView N() {
            ImageView imageView = this.f7469a;
            if (imageView != null) {
                return imageView;
            }
            f92.m("itemIcon");
            throw null;
        }

        public final TextView O() {
            TextView textView = this.c;
            if (textView != null) {
                return textView;
            }
            f92.m("itemMax");
            throw null;
        }

        public final View P() {
            View view = this.b;
            if (view != null) {
                return view;
            }
            f92.m("itemModeDot");
            throw null;
        }

        public final TextView Q() {
            TextView textView = this.d;
            if (textView != null) {
                return textView;
            }
            f92.m("itemTimes");
            throw null;
        }

        public final TextView R() {
            TextView textView = this.f2967a;
            if (textView != null) {
                return textView;
            }
            f92.m("itemTitle");
            throw null;
        }

        public final String S() {
            String str = this.f2968a;
            if (str != null) {
                return str;
            }
            f92.m("packageName");
            throw null;
        }

        public final void T(TextView textView) {
            f92.d(textView, "<set-?>");
            this.f2969b = textView;
        }

        public final void U(ImageView imageView) {
            f92.d(imageView, "<set-?>");
            this.f7469a = imageView;
        }

        public final void V(TextView textView) {
            f92.d(textView, "<set-?>");
            this.c = textView;
        }

        public final void W(View view) {
            f92.d(view, "<set-?>");
            this.b = view;
        }

        public final void X(TextView textView) {
            f92.d(textView, "<set-?>");
            this.d = textView;
        }

        public final void Y(TextView textView) {
            f92.d(textView, "<set-?>");
            this.f2967a = textView;
        }

        public final void Z(String str) {
            f92.d(str, "<set-?>");
            this.f2968a = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t51(Context context, List<? extends PowerStatAVG> list) {
        f92.d(context, "context");
        f92.d(list, "data");
        this.f2965a = context;
        this.b = list;
        this.c = true;
        this.f2966a = C();
        this.f2963a = new ih0(this.f2965a, 0, 0, 6, null);
        this.f7468a = 3L;
        this.f2964a = new vj0();
    }

    public final void A(boolean z) {
        if (this.c != z) {
            this.c = z;
            this.f2966a = C();
            i();
        }
    }

    public final void B(boolean z) {
        if (this.d != z) {
            this.d = z;
            this.f2966a = C();
            i();
        }
    }

    public final List<PowerStatAVG> C() {
        List<PowerStatAVG> list;
        Comparator y51Var;
        if (this.c) {
            list = this.b;
            y51Var = new w51();
        } else if (this.d) {
            list = this.b;
            y51Var = new x51();
        } else {
            list = this.b;
            y51Var = new y51();
        }
        return i52.S(list, y51Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f2966a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, int i) {
        TextView textViewM;
        String str;
        f92.d(aVar, "holder");
        PowerStatAVG powerStatAVG = this.f2966a.get(i);
        View viewP = aVar.P();
        String str2 = powerStatAVG.mode;
        f92.c(str2, "batteryStats.mode");
        viewP.setVisibility(str2.length() == 0 ? 8 : 0);
        View viewP2 = aVar.P();
        su0 su0Var = wu0.f3480a;
        String str3 = powerStatAVG.mode;
        f92.c(str3, "batteryStats.mode");
        viewP2.setBackground(su0Var.h(str3));
        if (this.d) {
            textViewM = aVar.M();
            q92 q92Var = q92.f7191a;
            str = String.format("%.2fW, %d℃", Arrays.copyOf(new Object[]{Double.valueOf((-powerStatAVG.power) / ((double) 1000)), Integer.valueOf(powerStatAVG.avgTemperature)}, 2));
        } else {
            textViewM = aVar.M();
            q92 q92Var2 = q92.f7191a;
            str = String.format("%dmA, %d℃", Arrays.copyOf(new Object[]{Integer.valueOf(-powerStatAVG.current), Integer.valueOf(powerStatAVG.avgTemperature)}, 2));
        }
        f92.c(str, "java.lang.String.format(format, *args)");
        textViewM.setText(str);
        TextView textViewO = aVar.O();
        q92 q92Var3 = q92.f7191a;
        String str4 = String.format("%d℃", Arrays.copyOf(new Object[]{Integer.valueOf(powerStatAVG.maxTemperature)}, 1));
        f92.c(str4, "java.lang.String.format(format, *args)");
        textViewO.setText(str4);
        aVar.Q().setText(this.f2964a.c((this.f7468a * ((long) powerStatAVG.count)) / 60.0d));
        String str5 = powerStatAVG.packageName;
        f92.c(str5, "app");
        aVar.Z(str5);
        qc2.d(hf2.f6309a, qe2.b(), null, new v51(aVar, str5, null, this, powerStatAVG), 2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public a p(ViewGroup viewGroup, int i) {
        f92.d(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(this.f2965a).inflate(2131558624, (ViewGroup) null);
        f92.c(viewInflate, "convertView");
        a aVar = new a(this, viewInflate);
        View viewFindViewById = viewInflate.findViewById(t61.itemAvgIO);
        f92.c(viewFindViewById, "convertView.findViewById(R.id.itemAvgIO)");
        aVar.T((TextView) viewFindViewById);
        View viewFindViewById2 = viewInflate.findViewById(t61.itemModeDot);
        f92.c(viewFindViewById2, "convertView.findViewById(R.id.itemModeDot)");
        aVar.W(viewFindViewById2);
        View viewFindViewById3 = viewInflate.findViewById(t61.itemTemperature);
        f92.c(viewFindViewById3, "convertView.findViewById(R.id.itemTemperature)");
        aVar.V((TextView) viewFindViewById3);
        View viewFindViewById4 = viewInflate.findViewById(t61.itemCounts);
        f92.c(viewFindViewById4, "convertView.findViewById(R.id.itemCounts)");
        aVar.X((TextView) viewFindViewById4);
        View viewFindViewById5 = viewInflate.findViewById(t61.itemTitle);
        f92.c(viewFindViewById5, "convertView.findViewById(R.id.itemTitle)");
        aVar.Y((TextView) viewFindViewById5);
        View viewFindViewById6 = viewInflate.findViewById(t61.itemIcon);
        f92.c(viewFindViewById6, "convertView.findViewById(R.id.itemIcon)");
        aVar.U((ImageView) viewFindViewById6);
        return aVar;
    }
}
