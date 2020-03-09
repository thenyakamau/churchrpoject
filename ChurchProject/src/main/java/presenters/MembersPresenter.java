package presenters;

import interfaces.MembersInterface;
import model.MemberModel;
import model.MembersDatum;
import networking.Api;
import networking.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.lang.reflect.Proxy;
import java.util.List;

public class MembersPresenter {

    private MembersInterface membersInterface;
    public MembersPresenter(MembersInterface membersInterface) {
        this.membersInterface = membersInterface;
    }



    public void getMembersList() {
       // Proxy.newProxyInstance(ClassLoader.getPlatformClassLoader(), ApiInterface.class, )
        Call<MemberModel> call = Api.fetchApiInterface().fetchChurchMembers();

        call.enqueue(new Callback<MemberModel>() {
            List<MembersDatum> membersDatumList;

            @Override
            public void onResponse(Call<MemberModel> call, Response<MemberModel> response) {
                if (response.isSuccessful() && response.body() != null) {

                    membersDatumList = response.body().getChurchMembers().getData();

                    System.out.println(membersDatumList.get(0).getName());

                    membersInterface.membersData(membersDatumList);
                }

            }

            @Override
            public void onFailure(Call<MemberModel> call, Throwable throwable) {

            }

        });
    }
}
