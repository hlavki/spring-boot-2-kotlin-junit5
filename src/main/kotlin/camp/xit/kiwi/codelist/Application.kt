package camp.xit.kiwi.codelist

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@SpringBootApplication
open class Application {

    @Bean
    open fun objectMapperBuilder(): Jackson2ObjectMapperBuilder = Jackson2ObjectMapperBuilder()
            .modulesToInstall(KotlinModule())
            .featuresToDisable(SerializationFeature.WRAP_ROOT_VALUE,
                    SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                    DeserializationFeature.UNWRAP_ROOT_VALUE)
//            .defaultTyping(ObjectMapper.DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping.NON_FINAL)
//                    .init(JsonTypeInfo.Id.NAME, null)
//                    .inclusion(JsonTypeInfo.As.PROPERTY)
//                    .typeProperty("class"))
            .serializationInclusion(JsonInclude.Include.NON_EMPTY)
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
