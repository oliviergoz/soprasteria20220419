package musicSpring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"musicSpring.beans", "musicSpring.aspects"})
@EnableAspectJAutoProxy  // active annotation pour les aspects
public class AppConfig {

}
