package pt.ipp.estg.tourpediaexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConverterFactory {

    public TourDataApi getApi(){
        return getRetrofit().create(TourDataApi.class);
    }

    private Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://tour-pedia.org/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
