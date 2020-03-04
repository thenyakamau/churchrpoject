package networking;

import model.MemberModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/fetchChurchMembers")
    Call<MemberModel> fetchChurchMembers();

}
