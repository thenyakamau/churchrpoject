package networking;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.text.DateFormat;
import java.util.concurrent.TimeUnit;

public class Api {

    private Retrofit retrofit;



    static String BASE_URL = "https://fdfe2a98.ngrok.io/churchproject/churchbackend/public/";

    private static Retrofit provideRetrofitInstance() {


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

    private static Gson myGson(){

        return new GsonBuilder()
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setDateFormat(DateFormat.LONG)
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();

    }

    public static ApiInterface fetchApiInterface(){

        return provideRetrofitInstance().create(ApiInterface.class);

    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
