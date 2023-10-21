package test;

import com.shucai.design.VideoUserService;

public class ApiTest {


    public static void main(String[] args) {
        VideoUserService videoUserService = new VideoUserService();
        videoUserService.serveGrade("VIP用户");
        videoUserService.serveGrade("普通用户");
        videoUserService.serveGrade("访客用户");
    }
}
