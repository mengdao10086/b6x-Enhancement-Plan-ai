package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.model.PowerStatSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class s11 extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r11 f2816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f2817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yj0 f2818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SimpleDateFormat f2820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<PowerStatSession> f2821a;
    public r11 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final SimpleDateFormat f2822b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<PowerStatSession> f2823b;
    public boolean c;

    public final class a extends RecyclerView.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageButton f7352a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TextView f2824a;
        public View b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public ImageButton f2825b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public TextView f2826b;
        public View c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public TextView f2827c;
        public TextView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s11 s11Var, View view) {
            super(view);
            f92.d(view, "view");
        }

        public final ImageButton M() {
            return this.f2825b;
        }

        public final ImageButton N() {
            return this.f7352a;
        }

        public final TextView O() {
            return this.f2826b;
        }

        public final TextView P() {
            return this.f2827c;
        }

        public final View Q() {
            return this.c;
        }

        public final TextView R() {
            return this.d;
        }

        public final TextView S() {
            return this.f2824a;
        }

        public final View T() {
            return this.b;
        }

        public final void U(ImageButton imageButton) {
            this.f2825b = imageButton;
        }

        public final void V(ImageButton imageButton) {
            this.f7352a = imageButton;
        }

        public final void W(TextView textView) {
            this.f2826b = textView;
        }

        public final void X(TextView textView) {
            this.f2827c = textView;
        }

        public final void Y(ImageView imageView) {
        }

        public final void Z(View view) {
            this.c = view;
        }

        public final void a0(TextView textView) {
            this.d = textView;
        }

        public final void b0(TextView textView) {
            this.f2824a = textView;
        }

        public final void c0(View view) {
            this.b = view;
        }
    }

    public s11(Context context, ArrayList<PowerStatSession> arrayList, int i) {
        f92.d(context, "context");
        f92.d(arrayList, "list");
        this.f2819a = context;
        this.f2823b = arrayList;
        this.f7351a = i;
        this.f2821a = arrayList;
        this.f2820a = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.f2822b = new SimpleDateFormat("HH:mm:ss");
        this.f2818a = new yj0();
        this.f2817a = new vj0();
    }

    public final ArrayList<PowerStatSession> A(int i) {
        if (i == 0) {
            return this.f2823b;
        }
        ArrayList<PowerStatSession> arrayList = this.f2823b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((long) ((PowerStatSession) obj).used) * 3000 <= ((long) i)) {
                arrayList2.add(obj);
            }
        }
        return new ArrayList<>(arrayList2);
    }

    public final PowerStatSession B(int i) {
        PowerStatSession powerStatSession = this.f2821a.get(i);
        f92.c(powerStatSession, "filterResult[position]");
        return powerStatSession;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, int i) {
        f92.d(aVar, "holder");
        ((RecyclerView.d0) aVar).f4387a.setOnClickListener(new t11(this, i, aVar));
        ImageButton imageButtonM = aVar.M();
        if (imageButtonM != null) {
            imageButtonM.setOnClickListener(new u11(this, i));
        }
        ImageButton imageButtonN = aVar.N();
        if (imageButtonN != null) {
            imageButtonN.setOnClickListener(new v11(this, i));
        }
        J(i, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public a p(ViewGroup viewGroup, int i) {
        f92.d(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(this.f2819a).inflate(2131558623, viewGroup, false);
        f92.c(viewInflate, "convertView");
        a aVar = new a(this, viewInflate);
        aVar.Y((ImageView) viewInflate.findViewById(2131361811));
        aVar.c0(viewInflate.findViewById(t61.NewTag));
        aVar.b0((TextView) viewInflate.findViewById(2131361824));
        aVar.X((TextView) viewInflate.findViewById(t61.ItemEnd));
        aVar.a0((TextView) viewInflate.findViewById(t61.ItemStart));
        aVar.W((TextView) viewInflate.findViewById(t61.ItemCenter));
        aVar.V((ImageButton) viewInflate.findViewById(t61.delete));
        aVar.U((ImageButton) viewInflate.findViewById(t61.confirm));
        aVar.Z(viewInflate.findViewById(t61.Selected));
        return aVar;
    }

    public final void E(int i) {
        PowerStatSession powerStatSession = this.f2821a.get(i);
        f92.c(powerStatSession, "this.filterResult[position]");
        PowerStatSession powerStatSession2 = powerStatSession;
        this.f2821a.remove(i);
        if (this.f2823b.contains(powerStatSession2)) {
            this.f2823b.remove(powerStatSession2);
        }
        i();
    }

    public final void F(ArrayList<PowerStatSession> arrayList) {
        f92.d(arrayList, "items");
        Object[] array = arrayList.toArray();
        f92.c(array, "items.toArray()");
        for (Object obj : array) {
            if (i52.v(this.f2823b, obj)) {
                ArrayList<PowerStatSession> arrayList2 = this.f2823b;
                if (arrayList2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                }
                r92.a(arrayList2).remove(obj);
            }
            if (i52.v(this.f2821a, obj)) {
                ArrayList<PowerStatSession> arrayList3 = this.f2821a;
                if (arrayList3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                }
                r92.a(arrayList3).remove(obj);
            }
        }
        i();
    }

    public final ArrayList<PowerStatSession> G(int i) {
        this.f2821a = A(i);
        i();
        return this.f2821a;
    }

    public final void H(r11 r11Var) {
        this.f2816a = r11Var;
    }

    public final void I(r11 r11Var) {
        this.b = r11Var;
    }

    public final void J(int i, a aVar) {
        TextView textViewS;
        SimpleDateFormat simpleDateFormat;
        View viewQ;
        float f;
        f92.d(aVar, "viewHolder");
        PowerStatSession powerStatSessionB = B(i);
        TextView textViewR = aVar.R();
        if (textViewR != null) {
            q92 q92Var = q92.f7191a;
            String str = String.format("%.2fW  %.1f%%/h", Arrays.copyOf(new Object[]{Double.valueOf(powerStatSessionB.avgPower / ((double) (-1000))), Double.valueOf((powerStatSessionB.avgPower * 100.0d) / fa0.f867a.l())}, 2));
            f92.c(str, "java.lang.String.format(format, *args)");
            textViewR.setText(str);
        }
        TextView textViewO = aVar.O();
        if (textViewO != null) {
            textViewO.setText(this.f2817a.d((((long) powerStatSessionB.used) * 3000) / 60000.0d) + " / " + this.f2817a.d((powerStatSessionB.endTime - powerStatSessionB.beginTime) / 60000.0d));
        }
        String strD = powerStatSessionB.avgPower < ((double) 0) ? this.f2817a.d((fa0.f867a.l() / (-powerStatSessionB.avgPower)) * ((double) 60) * 0.9d) : "--";
        TextView textViewP = aVar.P();
        if (textViewP != null) {
            textViewP.setText(this.f2819a.getString(u61.power_predict) + ": " + strD);
        }
        if (this.f2818a.a(powerStatSessionB.beginTime)) {
            View viewT = aVar.T();
            if (viewT != null) {
                viewT.setVisibility(0);
            }
            textViewS = aVar.S();
            if (textViewS != null) {
                simpleDateFormat = this.f2822b;
                textViewS.setText(simpleDateFormat.format(Long.valueOf(powerStatSessionB.beginTime)));
            }
        } else {
            View viewT2 = aVar.T();
            if (viewT2 != null) {
                viewT2.setVisibility(8);
            }
            textViewS = aVar.S();
            if (textViewS != null) {
                simpleDateFormat = this.f2820a;
                textViewS.setText(simpleDateFormat.format(Long.valueOf(powerStatSessionB.beginTime)));
            }
        }
        if (i == this.f7351a) {
            viewQ = aVar.Q();
            if (viewQ != null) {
                f = 0.7f;
                viewQ.setAlpha(f);
            }
        } else {
            viewQ = aVar.Q();
            if (viewQ != null) {
                f = 0.0f;
                viewQ.setAlpha(f);
            }
        }
        if (this.c && this.f7351a == i) {
            ImageButton imageButtonN = aVar.N();
            if (imageButtonN != null) {
                imageButtonN.setVisibility(8);
            }
            ImageButton imageButtonM = aVar.M();
            if (imageButtonM != null) {
                imageButtonM.setVisibility(0);
                return;
            }
            return;
        }
        ImageButton imageButtonN2 = aVar.N();
        if (imageButtonN2 != null) {
            imageButtonN2.setVisibility(0);
        }
        ImageButton imageButtonM2 = aVar.M();
        if (imageButtonM2 != null) {
            imageButtonM2.setVisibility(8);
        }
    }

    public final void K(int i, boolean z) {
        int i2 = this.f7351a;
        if (i2 == i && this.c == z) {
            return;
        }
        this.c = z;
        if (i2 != -1) {
            this.f7351a = i;
            j(i2);
        }
        this.f7351a = i;
        j(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f2821a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i) {
        return i;
    }
}
