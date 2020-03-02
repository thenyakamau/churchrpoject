package networking;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.text.DateFormat;
import java.util.concurrent.TimeUnit;

public class Api {

    private Retrofit retrofit;
    private String BASE_URL = "";

    private Retrofit provideRetrofitInstance() {

        Gson gson = new GsonBuilder().serializeNulls().create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(myGson()))
                .client(getNewHttpClient())
                .build();
    }

    static OkHttpClient getNewHttpClient() {

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .addInterceptor(chain -> {
                    Request request = chain.request();

                    Request.Builder builder = request.newBuilder()
                            .addHeader("Accept", "application/json")
                            .addHeader("Connection", "close");

                    request = builder.build();

                    return chain.proceed(request);
                })
                .addNetworkInterceptor(networkInterceptor()) //only used if network is on
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);


           // client.addNetworkInterceptor(new StethoInterceptor());


        return client.build();
    }





    private static Interceptor networkInterceptor(){

        return (chain) -> {

            Response response = chain.proceed(chain.request());


            return response.newBuilder()
                    .build();

        };

    }

    private Gson myGson(){

        return new GsonBuilder()
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setDateFormat(DateFormat.LONG)
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();

    }


}
