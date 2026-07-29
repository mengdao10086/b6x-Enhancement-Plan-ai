package com.flydigi.data;

import com.google.gson.annotations.SerializedName;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import f0.v;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class LoginBaseResponse<T> implements Serializable {

    @SerializedName(CommonNetImpl.RESULT)
    public T data;

    @SerializedName("msg")
    public String msg;

    @SerializedName(v.N0)
    public int state;

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        LoginBaseResponse loginBaseResponse = (LoginBaseResponse) o10;
        return this.state == loginBaseResponse.state && Objects.equals(this.msg, loginBaseResponse.msg) && Objects.equals(this.data, loginBaseResponse.data);
    }

    public int hashCode() {
        int i10 = this.state * 31;
        String str = this.msg;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        T t10 = this.data;
        return iHashCode + (t10 != null ? t10.hashCode() : 0);
    }

    public String toString() {
        return "BaseResponse{state=" + this.state + ", msg='" + this.msg + "', data=" + this.data + '}';
    }
}
