package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberModel {

    @SerializedName("churchMembers")
    @Expose
    private ChurchMembers churchMembers;

    /**
     * No args constructor for use in serialization
     *
     */
    public MemberModel() {
    }

    /**
     *
     * @param churchMembers
     */
    public MemberModel(ChurchMembers churchMembers) {
        super();
        this.churchMembers = churchMembers;
    }

    public ChurchMembers getChurchMembers() {
        return churchMembers;
    }

    public void setChurchMembers(ChurchMembers churchMembers) {
        this.churchMembers = churchMembers;
    }

}
