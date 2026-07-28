package io.rushi.SpringWebProject.Configuration;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    public Cloudinary Cloudinary() {

        return new Cloudinary();

    }
}
