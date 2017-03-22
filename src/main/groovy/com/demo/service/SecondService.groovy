package com.demo.service

import org.json.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by karthirockz on 23/03/17.
 */

@RestController
class SecondService {

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<String> get(@PathVariable("userId") int userId) {

        JSONObject jsonData = new JSONObject()
        jsonData.put('host', "I GOT the UserID: ${userId}")
        return ResponseEntity.ok(new JSONObject().put("jsonData", jsonData).toString())
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE, produces = "application/json")
    ResponseEntity<String> delete(@PathVariable("userId") int userId) {

        JSONObject jsonData = new JSONObject()
        jsonData.put('host', "I have DELETED UserID: ${userId}")
        return ResponseEntity.ok(new JSONObject().put("jsonData", jsonData).toString())
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT, produces = "application/json")
    ResponseEntity<String> update(@PathVariable("userId") int userId) {

        JSONObject jsonData = new JSONObject()
        jsonData.put('host', "I have UPDATED UserID: ${userId}")
        return ResponseEntity.ok(new JSONObject().put("jsonData", jsonData).toString())
    }
}
