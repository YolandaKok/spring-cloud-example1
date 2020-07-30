package io.yolanda.kokkinou.config

import org.springframework.stereotype.Component
import org.springframework.boot.context.properties.ConfigurationProperties

@Component
@ConfigurationProperties("user")
class Configuration {
	lateinit var names: String
}