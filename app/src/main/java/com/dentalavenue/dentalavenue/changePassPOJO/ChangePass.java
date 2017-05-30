package com.dentalavenue.dentalavenue.changePassPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by USER on 5/29/2017.
 */

public class ChangePass {

    @SerializedName("pass_change")
    @Expose
    private List<PassChange> passChange = null;

    public List<PassChange> getPassChange() {
        return passChange;
    }

    public void setPassChange(List<PassChange> passChange) {
        this.passChange = passChange;
    }

}
