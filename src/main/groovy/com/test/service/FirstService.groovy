package com.test.service

import org.json.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.EnableWebMvc

/**
 * Created by karthirockz on 22/03/17.
 */

@RestController
class FirstService {

    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<String> get(@PathVariable("gameId") int gameId) {

        JSONObject jsonData = new JSONObject()
        jsonData.put('host', "I GOT the GameID: ${gameId}")
        return ResponseEntity.ok(new JSONObject().put("jsonData", jsonData).toString())
    }

    @RequestMapping(value = "/games/{gameId}", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity<String> create(@PathVariable("gameId") int gameId) {

        JSONObject jsonData = new JSONObject()
        jsonData.put('host', "I CREATED the GameID: ${gameId}")
        return ResponseEntity.ok(new JSONObject().put("jsonData", jsonData).toString())
    }
}
