package io.yolanda.kokkinou.endpoints

import org.springframework.web.bind.annotation.RestController
import io.yolanda.kokkinou.dto.ReturnValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.http.MediaType
import org.springframework.beans.factory.annotation.Autowired
import io.yolanda.kokkinou.config.Configuration

@RestController
@RequestMapping("/users")
class UserEndpoint {
	
	@Autowired
	private lateinit var config: Configuration
	
	@GetMapping
	fun getUsers(): ReturnValue {
		val result = ReturnValue()
		result.listOfNames = config.names
		return result
	}	
}