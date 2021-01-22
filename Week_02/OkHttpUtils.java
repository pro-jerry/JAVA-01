package nio.nio01.homework;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpUtils {

    // 缓存客户端实例
    public static OkHttpClient client = new OkHttpClient();

    // GET 调用
    public static String getAsString(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.headers().get("Content-Type"));
            return response.body().string();
        }
    }

    public static void main(String[] args) throws Exception {

        String url = "http://localhost:8088/api/hello";

        String text = OkHttpUtils.getAsString(url);
        System.out.println("url: " + url + " ; response: \n" + text);

        // 清理资源
        OkHttpUtils.client = null;
    }
}
