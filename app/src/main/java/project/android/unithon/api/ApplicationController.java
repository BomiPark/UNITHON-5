package project.android.unithon.api;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by USER on 2017-07-28.
 */

public class ApplicationController extends Application {
    private static ApplicationController instance;
    public static ApplicationController getInstance() {return instance;}

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationController.instance = this; //앱이 처음 실행될 때 인스턴스 생성.

//        Typekit.getInstance()
//                .addNormal(Typekit.createFromAsset(this, "윤고딕320.TTF"))
//                .addBold(Typekit.createFromAsset(this, "윤고딕340.TTF"))
//                .addCustom1(Typekit.createFromAsset(this, "NanumBarunGothic.ttf"))
//                .addCustom2(Typekit.createFromAsset(this, "윤고딕310.TTF"))
//                .addCustom3(Typekit.createFromAsset(this, "NanumBarunGothicBold.ttf"))
//                .addCustom4(Typekit.createFromAsset(this,"윤고딕330.TTF"))
//                .addCustom5(Typekit.createFromAsset(this, "윤고딕350.TTF"));// "fonts/폰트.ttf"
    }

    private ClientService clientService;

    public ClientService getClientService() {
        return clientService;
    }

    private String baseUrl;

    public void buildNetworkService(String url) {  //받아온 ip, 포트넘버로 네트워크 접근.
        synchronized (ApplicationController.class) {
            if(clientService == null) {
                baseUrl= url;
                Gson gson= new GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").create();
                GsonConverterFactory factory= GsonConverterFactory.create(gson);
                //서버로부터 json 형식으로 데이터를 받아오고 이를 파싱해서 받아오기 위해 사용

                Retrofit retrofit= new Retrofit.Builder().baseUrl(baseUrl)
                        .addConverterFactory(factory).build();

                clientService= retrofit.create(ClientService.class);
            }
        }
    }
}