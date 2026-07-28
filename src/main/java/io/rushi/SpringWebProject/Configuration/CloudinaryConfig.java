package io.rushi.SpringWebProject.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary Cloudinary() {

        return new Cloudinary(ObjectUtils.asMap(

                "cloud_name","glwfymp3",
                "api_key","428393921153524",
                "api_secret","I6aj62hM9DfLSBKkRP3UnBOx3V4",
                "secure","true"
        ));

    }
}
