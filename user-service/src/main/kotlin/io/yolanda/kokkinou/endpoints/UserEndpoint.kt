package io.yolanda.kokkinou.endpoints

import org.springframework.web.bind.annotation.RestController
import io.yolanda.kokkinou.dto.ReturnValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.http.MediaType
import com.google.gson.Gson

@RestController
@RequestMapping("/users")
class UserEndpoint {
	@RequestMapping("/")
	fun getUsers(): String {
		val result = ReturnValue()
		result.listOfNames = "Yolanda, Maria, Eleni"
		val jsonString = Gson().toJson(result)
		
		return jsonString
	}	
}