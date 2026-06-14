package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.model.ChargeStatSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r01 extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public q01 f2669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f2670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yj0 f2671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SimpleDateFormat f2673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<ChargeStatSession> f2674a;
    public q01 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final SimpleDateFormat f2675b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<ChargeStatSession> f2676b;
    public boolean c;

    public final class a extends RecyclerView.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageButton f7259a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TextView f2677a;
        public View b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public ImageButton f2678b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public TextView f2679b;
        public View c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public TextView f2680c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r01 r01Var, View view) {
            super(view);
            f92.d(view, "view");
        }

        public final ImageButton M() {
            return this.f2678b;
        }

        public final ImageButton N() {
            return this.f7259a;
        }

        public final TextView O() {
            return this.f2679b;
        }

        public final View P() {
            return this.c;
        }

        public final TextView Q() {
            return this.f2680c;
        }

        public final TextView R() {
            return this.f2677a;
        }

        public final View S() {
            return this.b;
        }

        public final void T(ImageButton imageButton) {
            this.f2678b = imageButton;
        }

        public final void U(ImageButton imageButton) {
            this.f7259a = imageButton;
        }

        public final void V(TextView textView) {
            this.f2679b = textView;
        }

        public final void W(TextView textView) {
        }

        public final void X(ImageView imageView) {
        }

        public final void Y(View view) {
            this.c = view;
        }

        public final void Z(TextView textView) {
            this.f2680c = textView;
        }

        public final void a0(TextView textView) {
            this.f2677a = textView;
        }

        public final void b0(View view) {
            this.b = view;
        }
    }

    public r01(Context context, ArrayList<ChargeStatSession> arrayList, int i) {
        f92.d(context, "context");
        f92.d(arrayList, "list");
        this.f2672a = context;
        this.f2676b = arrayList;
        this.f7258a = i;
        this.f2674a = arrayList;
        this.f2673a = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.f2675b = new SimpleDateFormat("HH:mm:ss");
        this.f2671a = new yj0();
        this.f2670a = new vj0();
    }

    public final ArrayList<ChargeStatSession> A(int i) {
        if (i == 0) {
            return this.f2676b;
        }
        ArrayList<ChargeStatSession> arrayList = this.f2676b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((ChargeStatSession) obj).capacityRatio <= i) {
                arrayList2.add(obj);
            }
        }
        return new ArrayList<>(arrayList2);
    }

    public final ChargeStatSession B(int i) {
        ChargeStatSession chargeStatSession = this.f2674a.get(i);
        f92.c(chargeStatSession, "filterResult[position]");
        return chargeStatSession;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, int i) {
        f92.d(aVar, "holder");
        ((RecyclerView.d0) aVar).f4387a.setOnClickListener(new s01(this, i, aVar));
        ImageButton imageButtonM = aVar.M();
        if (imageButtonM != null) {
            imageButtonM.setOnClickListener(new t01(this, i));
        }
        ImageButton imageButtonN = aVar.N();
        if (imageButtonN != null) {
            imageButtonN.setOnClickListener(new u01(this, i));
        }
        J(i, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public a p(ViewGroup viewGroup, int i) {
        f92.d(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(this.f2672a).inflate(2131558623, viewGroup, false);
        f92.c(viewInflate, "convertView");
        a aVar = new a(this, viewInflate);
        aVar.X((ImageView) viewInflate.findViewById(2131361811));
        aVar.b0(viewInflate.findViewById(t61.NewTag));
        aVar.a0((TextView) viewInflate.findViewById(2131361824));
        aVar.W((TextView) viewInflate.findViewById(t61.ItemEnd));
        aVar.Z((TextView) viewInflate.findViewById(t61.ItemStart));
        aVar.V((TextView) viewInflate.findViewById(t61.ItemCenter));
        aVar.U((ImageButton) viewInflate.findViewById(t61.delete));
        aVar.T((ImageButton) viewInflate.findViewById(t61.confirm));
        aVar.Y(viewInflate.findViewById(t61.Selected));
        return aVar;
    }

    public final void E(int i) {
        ChargeStatSession chargeStatSession = this.f2674a.get(i);
        f92.c(chargeStatSession, "this.filterResult[position]");
        ChargeStatSession chargeStatSession2 = chargeStatSession;
        this.f2674a.remove(i);
        if (this.f2676b.contains(chargeStatSession2)) {
            this.f2676b.remove(chargeStatSession2);
        }
        i();
    }

    public final void F(ArrayList<ChargeStatSession> arrayList) {
        f92.d(arrayList, "items");
        Object[] array = arrayList.toArray();
        f92.c(array, "items.toArray()");
        for (Object obj : array) {
            if (i52.v(this.f2676b, obj)) {
                ArrayList<ChargeStatSession> arrayList2 = this.f2676b;
                if (arrayList2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                }
                r92.a(arrayList2).remove(obj);
            }
            if (i52.v(this.f2674a, obj)) {
                ArrayList<ChargeStatSession> arrayList3 = this.f2674a;
                if (arrayList3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                }
                r92.a(arrayList3).remove(obj);
            }
        }
        i();
    }

    public final void G(q01 q01Var) {
        this.f2669a = q01Var;
    }

    public final void H(q01 q01Var) {
        this.b = q01Var;
    }

    public final ArrayList<ChargeStatSession> I(int i) {
        this.f2674a = A(i);
        i();
        return this.f2674a;
    }

    public final void J(int i, a aVar) {
        TextView textViewR;
        SimpleDateFormat simpleDateFormat;
        View viewP;
        float f;
        f92.d(aVar, "viewHolder");
        ChargeStatSession chargeStatSessionB = B(i);
        TextView textViewQ = aVar.Q();
        if (textViewQ != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(chargeStatSessionB.capacityRatio >= 0 ? "+" : "");
            sb.append(chargeStatSessionB.capacityRatio);
            sb.append("%");
            textViewQ.setText(sb.toString());
        }
        TextView textViewO = aVar.O();
        if (textViewO != null) {
            textViewO.setText(this.f2670a.c((chargeStatSessionB.endTime - chargeStatSessionB.beginTime) / 60000.0d));
        }
        if (this.f2671a.a(chargeStatSessionB.beginTime)) {
            View viewS = aVar.S();
            if (viewS != null) {
                viewS.setVisibility(0);
            }
            textViewR = aVar.R();
            if (textViewR != null) {
                simpleDateFormat = this.f2675b;
                textViewR.setText(simpleDateFormat.format(Long.valueOf(chargeStatSessionB.beginTime)));
            }
        } else {
            View viewS2 = aVar.S();
            if (viewS2 != null) {
                viewS2.setVisibility(8);
            }
            textViewR = aVar.R();
            if (textViewR != null) {
                simpleDateFormat = this.f2673a;
                textViewR.setText(simpleDateFormat.format(Long.valueOf(chargeStatSessionB.beginTime)));
            }
        }
        if (i == this.f7258a) {
            viewP = aVar.P();
            if (viewP != null) {
                f = 0.7f;
                viewP.setAlpha(f);
            }
        } else {
            viewP = aVar.P();
            if (viewP != null) {
                f = 0.0f;
                viewP.setAlpha(f);
            }
        }
        if (this.c && this.f7258a == i) {
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
        int i2 = this.f7258a;
        if (i2 == i && this.c == z) {
            return;
        }
        this.c = z;
        if (i2 != -1) {
            this.f7258a = i;
            j(i2);
        }
        this.f7258a = i;
        j(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f2674a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i) {
        return i;
    }
}
