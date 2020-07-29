package io.yolanda.kokkinou.endpoints

import org.springframework.web.bind.annotation.RestController
import io.yolanda.kokkinou.dto.ReturnValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.http.MediaType

@RestController
@RequestMapping("/users")
class UserEndpoint {
	
	@GetMapping
	fun getUsers(): ReturnValue {
		val result = ReturnValue()
		result.listOfNames = "Yolanda, Maria, Eleni"
		return result
	}	
}